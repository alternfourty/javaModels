package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AuxConnect {
    static Connection connection;

    public static ArrayList<Map<String, String>> auxConn(String query){

        ArrayList<Map<String, String>> dataBD = new ArrayList<>();
        Map<String, String> dataCol = new HashMap<>();

        try (Connection connection = Connections.getConnection()){
            try(PreparedStatement stmt = connection.prepareStatement(query)){
                try(ResultSet rs = stmt.executeQuery()){


                    while (rs.next()) {

                        int columnCount= rs.getMetaData().getColumnCount();

                        for (int i = 1; i <= columnCount; i++) {
                            String columnName = rs.getMetaData().getColumnName(i);
                            Object columnValue = rs.getObject(i);
                            dataCol.put(columnName,columnValue.toString());

                        }

                        dataBD.add(dataCol);
                    }

                    dataCol= new HashMap<>();
                    connection.close();
                }

            }



            return  dataBD;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
