package Task15;

import Task15.listUsers.ListUsers;
import Task15.singleUser.SingleUser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Task15 {

    @BeforeTest
    public void precondition(){
        baseURI = "https://reqres.in/";
    }

    @Test
    public void listUsersTest1(){
        String endpoint = "/api/users?page=2";
        ListUsers listUsers = given().when().get(endpoint).as(ListUsers.class);
        Assert.assertEquals(listUsers.page,2);
        Assert.assertEquals(listUsers.data.get(0).id,7 );
    }

    @Test
    public void SingleUserTest2(){
        String endpoint = "/api/users/2";
        SingleUser singleUser = given().when().get(endpoint).as(SingleUser.class);

    }

    @Test
    public void singleUserNotFound(){
        String endpoint = "/api/users/23";
        given().when()
    }
}
