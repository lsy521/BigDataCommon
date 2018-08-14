package com.hzgc.common.facestarepo.table.alarm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RealNameServiceUtil {
    public List<String> getOfflineAlarm(String jdbcUrl,long time){
        if (jdbcUrl != null && time != 0L){
            Timestamp offlineTime = new Timestamp(System.currentTimeMillis() - time);
            String sql = "select id from peoplemanager where updatetime <= ?";
            List<String> idList = new ArrayList<String>();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try{
                connection = PhoenixJDBCUtil.getPhoenixJdbcConn(jdbcUrl);
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setObject(1,offlineTime);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    idList.add(resultSet.getString("id"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    if (preparedStatement != null && !preparedStatement.isClosed()){
                        preparedStatement.close();
                    }
                    if (connection != null && !connection.isClosed()){
                        connection.close();
                    }
                    if (resultSet != null && !resultSet.isClosed()){
                        resultSet.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return idList;
        }else {
            return null;
        }
    }

    public void upsertStatus(String jdhcUrl,String regionid){
        if (regionid != null){
            String sql = "upsert into peoplemanager (id,status) select id,1 from peoplemanager where id= \'?\'";
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                connection = PhoenixJDBCUtil.getPhoenixJdbcConn(jdhcUrl);
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setObject(1,regionid);
                resultSet = preparedStatement.executeQuery();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    if(preparedStatement != null && !preparedStatement.isClosed()) {
                        preparedStatement.close();
                    }

                    if(connection != null && !connection.isClosed()) {
                        connection.close();
                    }

                    if(resultSet != null && !resultSet.isClosed()) {
                        resultSet.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }
}
