import models.Customer;

import static models.CxService.buildData;

public class Main {
    public static void main(String[] args) {
        Customer customer = buildData(3);
        System.out.println(customer.getName()+" "+customer.getLastName()+" From "+customer.getCountry());
    }
}
