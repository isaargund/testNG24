package myapp.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day23_DataProvider1 {
    //DataProvider method works with 2D Array
//We don't need loop to pass all data sets
//Data provider annotation ensures that all data sets are provided to test method one by one
    @DataProvider
    //DataProvider methot 1
    public Object[][] productProvider(){
        Object[][] productList={{"BMW"},{"Volvo"},{"Toyot"},{"Mercedes"},{"Audi"}};

                return productList;
    }

    //Test Method 1

    @Test(dataProvider = "productProvider")//call data provider method by its name and connect wit test method
    public void test1(String data){

        System.out.println(data);
    }

  //DataProvider Method 2
    @DataProvider
    public Object[][] credentialProvider(){
        Object[][] credentialList ={
                {"admin1", "pass1", "CEO", "52"},
                {"admin2", "pass2", "SDET", "45"},
                {"admin3", "pass3", "PM", "38"},
                {"admin4", "pass4", "QA", "30"},
                {"admin5", "pass5", "QA", "45"}
        };
        return credentialList;
    }
    @DataProvider(name="employee_credentials")
    public Object[][] credentialProvider2(){
        Object[][] credentialList ={
                {"admin1", "pass1", "CEO", "52"},
                {"admin2", "pass2", "SDET", "45"},
                {"admin3", "pass3", "PM", "38"},
                {"admin4", "pass4", "QA", "30"},
                {"admin5", "pass5", "QA", "45"}
        };
        return credentialList;
    }


    //tEST Method 2
    //Test Method 2
    @Test (dataProvider = "credentialProvider")
    public void test2(String username, String password, String position, String age){
        System.out.println("UserName: " + username + " | Password: " + password + " | Position :" + position + " | Age: " +age);
    }

    //you can also give a customized name


    //Test Method 3
    @Test (dataProvider = "employee_credentials")
    public void test3(String username, String password, String position, String age){
        System.out.println("UserName: " + username + " | Password: " + password + " | Position :" + position + " | Age: " +age);
    }

}
