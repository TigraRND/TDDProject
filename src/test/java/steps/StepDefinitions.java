package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class StepDefinitions {

    @Дано("В базе данных есть пользователь с ID {int}")
    public void weHaveUserIDInDB(int id) {
        System.out.println("Пользователь с ID " + id + " есть в базе данных");
    }

    @Когда("Пользователь посылает запрос на получение информации")
    public void userSentRequestToGtInfo() {
        System.out.println("Пользователь отправляет запрос");
    }

    @Тогда("Мы сохраняем информацию о пользовательском запросе в базу данных")
    public void weSavedInfoAboutUserRequestInDB() {
        System.out.println("Данные о пользователе попали в базу данных");
    }

    @When("Запрашиваем информацию о пользователе с ID {int} именем {string} и фамилией {string}")
    public void gettingInformationAboutUserWithNameAndSurname(int id, String name, String lastName) {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users/" + id)
                .then()
                .extract().response();

        System.out.println(response.getBody().prettyPrint());
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("data.first_name"),name);
        Assert.assertEquals(response.jsonPath().getString("data.last_name"),lastName);
    }

}
