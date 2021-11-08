package Task15;

import Task15.delayedResponse.Data2;
import Task15.delayedResponse.DelayedResponse;
import Task15.listResource.Datum1;
import Task15.listResource.ListResource;
import Task15.listUsers.ListUsers;
import Task15.singleResource.SingleResource;
import Task15.singleUser.SingleUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

public class Task15 {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in/";
    }

    @Test(priority = 1)
    public void listUsersTest1() {
        String endpoint = "/api/users?page=2";
        String expectedData = "{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces/7-image.jpg\"}";
        ListUsers listUsers = given().when().get(endpoint).as(ListUsers.class);
        Assert.assertEquals(listUsers.page, 2);
        Assert.assertEquals(listUsers.data.get(0).id, 7);
        Gson gson = new Gson();
        Assert.assertEquals(expectedData, gson.toJson(listUsers.data.get(0)));
    }

    @Test(priority = 2)
    public void singleUserTest2() {
        String endpoint = "/api/users/2";
        SingleUser singleUser = given().when().get(endpoint).as(SingleUser.class);
        Assert.assertEquals(singleUser.data.email, "janet.weaver@reqres.in");
    }

    @Test(priority = 3)
    public void singleUserNotFoundTest3() {
        String endpoint = "/api/users/23";
        given().when().get(endpoint).then().statusCode(404);
    }

    @Test(priority = 4)
    public void listResourceTest4() {
        String endpoint = "/api/unknown";
        ListResource listResource = given().when().get(endpoint).as(ListResource.class);
        Datum1 expectedDatum1 = new Datum1() {{
            setId(1);
            setName("cerulean");
            setYear(2000);
            setColor("#98B2D1");
            setPantone_value("15-4020");
        }};
        Assert.assertEquals(listResource.data.get(0), expectedDatum1);
        Assert.assertEquals(listResource.per_page, 6);
        Assert.assertEquals(listResource.support.text, "To keep ReqRes free, contributions towards server costs are appreciated!");
    }

    @Test(priority = 5)
    public void singleResourceTest5() {
        String endpoint = "/api/unknown/2";
        SingleResource singleResource = given().when().get(endpoint).as(SingleResource.class);
        Assert.assertEquals(singleResource.data.color, "#C74375");
    }

    @Test(priority = 6)
    public void singleResourceNotFoundTest6() {
        String endpoint = "/api/unknown/23";
        given().when().get(endpoint).then().statusCode(404);
    }

    @Test(priority = 7)
    public void postCreateTest7() {
        String endpoint = "/api/users";
        String requestBody = readFileAsString("postForTest7");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
    }


    @Test(priority = 8)
    public void postRegisterSuccessfulTest8() {
        String endpoint = "/api/register";
        String requestBody = readFileAsString("postForTest8");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");
        Assert.assertEquals(response.jsonPath().getInt("id"), 4);
    }

    @Test(priority = 9)
    public void postRegisterUnsuccessfulTest9() {
        String endpoint = "/api/register";
        String requestBody = readFileAsString("postForTest9");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(response.jsonPath().get("error"), "Missing password");
    }

    @Test(priority = 10)
    public void postLoginSuccessfulTest10() {
        String endpoint = "/api/login";
        String requestBody = readFileAsString("postForTest10");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");
    }

    @Test(priority = 11)
    public void postLoginUnsuccessfulTest11() {
        String endpoint = "/api/login";
        String requestBody = readFileAsString("postForTest11");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(response.jsonPath().get("error"), "Missing password");
    }

    @Test(priority = 12)
    public void delayedResponseTest12() {
        String endpoint = "/api/users?delay=3";
        DelayedResponse delayedResponse = given().when().get(endpoint).as(DelayedResponse.class);
        Data2 data2 = new Data2() {{
            setId(1);
            setEmail("george.bluth@reqres.in");
            setFirst_name("George");
            setLast_name("Bluth");
            setAvatar("https://reqres.in/img/faces/1-image.jpg");
        }};
        given().when().get(endpoint).then().statusCode(200);
        Assert.assertEquals(delayedResponse.data.get(0), data2);
    }

    @Test(priority = 13)
    public void putUpdateTest13() {
        String endpoint = "/api/users/2";
        String requestBody = readFileAsString("put");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().put(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
    }

    @Test(priority = 14)
    public void patchUpdateTest14() {
        String endpoint = "/api/users/2";
        String requestBody = readFileAsString("patch");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().patch(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("name"), "morpheus");
    }

    @Test(priority = 15)
    public void deleteTest15() {
        String endpoint = "/api/users/2";
        Response response = given().delete(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 204);
    }

    public static String readFileAsString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/Task15/requests/" + fileName + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    Gson gson = new Gson();

    @BeforeTest
    public void preconditions() throws JsonProcessingException {
        baseURI = "https://www.onliner.by";
        String endpoint = "/sdapi/catalog.api/search/notebook";
        String  json = given().when().get(endpoint).asPrettyString();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        jsonObject.get("products").getAsJsonArray().forEach(name-> System.out.println(name.getAsJsonObject().get("extended_name")));


    }

}
