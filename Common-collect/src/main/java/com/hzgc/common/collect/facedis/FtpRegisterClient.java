package com.hzgc.common.collect.facedis;

import com.hzgc.common.util.json.JSONUtil;
import com.hzgc.common.zookeeper.Curator;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FtpRegisterClient {

    private static final Logger LOG = Logger.getLogger(FtpRegisterClient.class);
    private volatile List<FtpRegisterInfo> ftpRegisterInfoList = new ArrayList<>();
    private final String ftp_register_path = "/ftp_register";
    private Curator registerClient;

    public FtpRegisterClient(String zkAddress){
        registerClient = new Curator(zkAddress, 1000, 6000);
        if (registerClient.nodePathExists(ftp_register_path)){
            LOG.info("Ftp register root path '/ftp_register' is exists");
        } else {
            registerClient.createNode(ftp_register_path, null, CreateMode.PERSISTENT);
            LOG.info("Ftp register root path '/ftp_register' create successfully");
        }
        initPathCache(registerClient.getClient());
    }

    public void createNode(FtpRegisterInfo registerInfo){
        if (registerInfo != null && registerInfo.getFtpIPAddress() != null
                && registerInfo.getFtpIPAddress().length() > 0){
            String nodePath = ftp_register_path + "/" + registerInfo.getFtpIPAddress();
            byte[] nodeData = JSONUtil.toJson(registerInfo).getBytes();
            registerClient.createNode(nodePath, nodeData, CreateMode.EPHEMERAL);
            LOG.info("Create ftp register child node path: " + nodePath
                    + " successfully, data: " + JSONUtil.toJson(registerInfo));
        }
    }

    private void initPathCache(CuratorFramework curatorFramework){
        final PathChildrenCache pathCache =
                new PathChildrenCache(curatorFramework, ftp_register_path, true);
        try {
            pathCache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
            pathCache.getListenable().addListener((client, event) -> {
                String log = event.getData() != null ? event.getData().getPath() : null;
                LOG.info("Ftp register child event [type:" + event.getType()
                        + ", path:" + log + "]");
                switch (event.getType()) {
                    case CHILD_ADDED:
                        refreshData(pathCache.getCurrentData());
                        break;
                    case CHILD_UPDATED:
                        refreshData(pathCache.getCurrentData());
                        break;
                    case CHILD_REMOVED:
                        refreshData(pathCache.getCurrentData());
                        break;
                    default:
                        break;
                }
            });
            //尝试第一次刷新节点下数据
            refreshData(pathCache.getCurrentData());
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }
    }

    private void refreshData(List<ChildData> currentData){
        if (currentData != null && currentData.size() > 0){
            List<FtpRegisterInfo> list = new ArrayList<>();
            for (ChildData childData : currentData){
                FtpRegisterInfo registerInfo =
                        JSONUtil.toObject(new String(childData.getData()), FtpRegisterInfo.class);
                list.add(registerInfo);
            }
            ftpRegisterInfoList = list;
            LOG.info("Ftp register info:" + Arrays.toString(ftpRegisterInfoList.toArray()));
        }
    }

    public List<FtpRegisterInfo> getFtpRegisterInfoList() {
        return ftpRegisterInfoList;
    }
}
