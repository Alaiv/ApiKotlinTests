package steps

import infrastructure.Specs.requestSpec
import infrastructure.Specs.responseSpec
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import models.Pet

fun addPet(pet: Pet): Response {
    return Given {
        spec(requestSpec)
    } When {
        body(pet)
        post("/v2/pet")
    } Then {
        spec(responseSpec)
    } Extract {
        response()
    }
}