package com.hzgc.common.facestarepo.table.alarm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hzgc.common.facestarepo.table.table.ObjectInfoTable;
import lombok.Data;
import org.apache.commons.lang.StringUtils;


public class StarepoServiceUtil {

    public List<ObjectInfo> getOfflineAlarm(String jdbcUrl, long time) {
        if (StringUtils.isBlank(jdbcUrl) || time == 0){
            return null;
        }
        Timestamp offlineTime = new Timestamp(System.currentTimeMillis() - time);
        String sql = "select * from " + ObjectInfoTable.TABLE_NAME + " where " + ObjectInfoTable.UPDATETIME + "<= ?";
        List<ObjectInfo> objectInfoList = new ArrayList<>();
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = PhoenixJDBCUtil.getPhoenixJdbcConn(jdbcUrl);
            ps = conn.prepareStatement(sql);
            ps.setObject(1, offlineTime);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ObjectInfo objectInfo = new ObjectInfo();
                objectInfo.setId(resultSet.getString(ObjectInfoTable.ROWKEY));
                objectInfo.setName(resultSet.getString(ObjectInfoTable.NAME));
                objectInfo.setPkey(resultSet.getString(ObjectInfoTable.PKEY));
                objectInfo.setIdcard(resultSet.getString(ObjectInfoTable.IDCARD));
                objectInfo.setSex(resultSet.getInt(ObjectInfoTable.SEX));
                objectInfo.setReason(resultSet.getString(ObjectInfoTable.REASON));
                objectInfo.setCreator(resultSet.getString(ObjectInfoTable.CREATOR));
                objectInfo.setCphone(resultSet.getString(ObjectInfoTable.CPHONE));
                objectInfo.setCreatetime(resultSet.getTimestamp(ObjectInfoTable.CREATETIME));
                objectInfo.setUpdatetime(resultSet.getTimestamp(ObjectInfoTable.UPDATETIME));
                objectInfo.setStatustime(resultSet.getTimestamp(ObjectInfoTable.STATUSTIME));
                objectInfo.setImportant(resultSet.getInt(ObjectInfoTable.IMPORTANT));
                objectInfo.setStatus(resultSet.getInt(ObjectInfoTable.STATUS));
                objectInfoList.add(objectInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
                if (resultSet != null && !resultSet.isClosed()){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return objectInfoList;
    }

    @Data
  public class ObjectInfo {
        private String id;
        private String name;
        private String pkey;
        private String idcard;
        private Integer sex;
        private String reason;
        private String creator;
        private String cphone;
        private Timestamp createtime;
        private Timestamp updatetime;
        private Timestamp statustime;
        private Integer important;
        private Integer status;
    }
}
