package com.hzgc.common.facestarepo.table.alarm;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ResidentUtil implements Serializable {
    private static Logger LOG = Logger.getLogger(ResidentUtil.class);
    private static ResidentUtil instance;
    private static String jdbcUrl;
    private static List<Object[]> totalList = null;

    private ResidentUtil(String phoenixUrl) {
        jdbcUrl = phoenixUrl;
        totalList = searchResident();
        LOG.info("ResidentUtil consumer is started");
    }

    public List<Object[]> getTotalList() {
        List var1 = totalList;
        synchronized (totalList) {
            return totalList;
        }
    }

    public static ResidentUtil getInstance(String jdbcUrl) {
        if (instance == null) {
            Class var2 = ResidentUtil.class;
            synchronized (ResidentUtil.class) {
                if (instance == null) {
                    instance = new ResidentUtil(jdbcUrl);
                }
            }
        }

        return instance;
    }

    private List<Object[]> searchResident() {
        String sql = "select id,region,feature from peoplemanager";
        PreparedStatement preparedStatement = null;
        ArrayList findResult = new ArrayList();
        try {
            Connection connection = PhoenixJDBCUtil.getPhoenixJdbcConn(jdbcUrl);
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String rowKey = resultSet.getString("id");
                String region = resultSet.getString("region");
                Array array = resultSet.getArray("feature");
                float[] feature = null;
                if (array != null) {
                    feature = (float[]) ((float[]) array.getArray());
                }
                if (feature != null && feature.length == 512) {
                    Object[] result1 = new Object[]{rowKey, region, feature};
                    findResult.add(result1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return findResult;
    }

    public int updatePeopleManagerTime(List<String> rowkeys) {
        if (rowkeys != null && rowkeys.size() > 0) {
            String sql = "upsert into peoplemanager (id, updatetime) values (?,?)";
            PreparedStatement preparedStatement = null;
            try {
                Connection connection = PhoenixJDBCUtil.getPhoenixJdbcConn(jdbcUrl);
                preparedStatement = connection.prepareStatement(sql);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                for (int i = 0; i < rowkeys.size(); ++i) {
                    preparedStatement.setString(1, (String) rowkeys.get(i));
                    preparedStatement.setTimestamp(2, timestamp);
                    preparedStatement.addBatch();
                    if (i % 500 == 0) {
                        preparedStatement.executeBatch();
                        connection.commit();
                    }
                }
                preparedStatement.executeBatch();
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null && !preparedStatement.isClosed()) {
                        preparedStatement.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return 0;
        } else {
            return 0;
        }
    }

}
