package extentions

import io.restassured.response.Response
import io.restassured.response.ValidatableResponse

inline  fun <reified T> ValidatableResponse.extractAs(): T {
    return this.extract().body().`as`(T::class.java)
}

inline fun <reified T> Response.extractAs(): T {
    return this.then().extract().body().`as`(T::class.java)
}