package Task17;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static mysql.DeleteHelper.getDelete;
import static mysql.InputHelper.getInsert;
import static mysql.SelectHelper.getSelect;
import static mysql.UpdateHelper.getUpdate;

public class Task17 {

    @Description("Select inquiry")
    @Test
    public void test1() throws Exception {
        getSelect().select("*").from("user").where("id = 0").getListData().forEach(System.out::println);
    }

    @Test
    public void test2() throws Exception {
        getSelect().select("*").from("user").where("age = '32' and first_name = 'User 2'").getListData().forEach(System.out::println);
    }

    @Description("Insert inquiry")
    @Test
    public void test3() throws Exception {
        getInsert().insert().into("user (id, first_name, last_name, age)").values("('11', 'Vika', 'Added', '23')").resultSetInsert();
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
    }

    @Test
    public void test4() throws Exception {
        getInsert().insert().into("user (id, first_name, last_name, age)").values("('12', 'Cat', '', '2')").resultSetInsert();
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
    }

    @Description("Update inquiry")
    @Test
    public void test5() throws Exception {
        getUpdate().update("user").set("id = 55").where("id = 11").resultSetUpdate();
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
    }

    @Test
    public void test6() throws Exception {
        getUpdate().update("user").set("first_name = 'Dog'").where("first_name = 'Cat'").resultSetUpdate();
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
    }

    @Description("Delete inquiry")
    @Test
    public void test7() throws Exception {
        getDelete().delete().from("user").where("id = 12").resultSetDelete();
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
    }

    @Test
    public void test8() throws Exception {
        getDelete().delete().from("user").where("first_name = 'Vika'").resultSetDelete();
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
    }
}
