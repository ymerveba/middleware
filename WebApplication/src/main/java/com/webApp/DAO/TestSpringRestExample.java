package com.webApp.DAO;



 


import org.springframework.web.client.RestTemplate;

import com.webApp.Domain.DiscountRequestObject;
import com.webApp.Domain.DiscountResponseObject;

 
public class TestSpringRestExample {
 
    public static final String SERVER_URI = "http://localhost:8080/Middleware";
    public static final String GET_DISCOUNT = "/getDiscount";
    public static void main(String args[]){
         
        /*testGetDummyEmployee();
        System.out.println("*****");*/
        testCreateEmployee();
       /* System.out.println("*****");
        testGetEmployee();
        System.out.println("*****");
        testGetAllEmployee();*/
    }
 
   /* private static void testGetAllEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        //we can't get List<Employee> because JSON convertor doesn't know the type of
        //object in the list and hence convert it to default JSON object type LinkedHashMap
        List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+EmpRestURIConstants.GET_ALL_EMP, List.class);
        System.out.println(emps.size());
        for(LinkedHashMap map : emps){
            System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
        }
    }*/
 
    private static void testCreateEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        DiscountRequestObject request = new DiscountRequestObject();   
        request.setPassword("passw0rd");  
        request.setUserID("c@email.com");
        request.setTotalValue(50000);
        request.setNumberOfTransactions(500);
        request.setWebAppId("webApp");
        DiscountResponseObject response = restTemplate.postForObject(SERVER_URI+GET_DISCOUNT, request, DiscountResponseObject.class);
        System.out.println(response.getUserID()+response.getDiscount());
    }
 
   /* private static void testGetEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = restTemplate.getForObject(SERVER_URI+"/rest/emp/1", Employee.class);
        printEmpData(emp);
    }
 
    private static void testGetDummyEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = restTemplate.getForObject(SERVER_URI+EmpRestURIConstants.DUMMY_EMP, Employee.class);
        printEmpData(emp);
    }*/
     
   
}