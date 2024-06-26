package tests

import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTest {

    @BeforeAll
    fun setup() {
        RestAssured.filters(AllureRestAssured())
    }

    @BeforeAll
    fun tearDown() {
        RestAssured.reset()
    }
}