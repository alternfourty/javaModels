package models;

import utils.AuxConnect;

import java.util.ArrayList;
import java.util.Map;

import static utils.AuxConnect.auxConn;

public class CxService {

    public static Customer buildData(int customerId){
        String query = "SELECT * FROM CUS00 WHERE id = %s".formatted(customerId);
        ArrayList<Map<String, String>> data = auxConn(query);

        assert data != null;
        return Customer.builder()
                .id(Integer.parseInt(data.get(0).get("id")))
                .name(data.get(0).get("name"))
                .LastName(data.get(0).get("LastName"))
                .phone(data.get(0).get("phone"))
                .age(Integer.parseInt(data.get(0).get("age")))
                .country(data.get(0).get("country"))
                .build();

    }

}
