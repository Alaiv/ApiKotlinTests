package tests

import extentions.extractAs
import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import models.Category
import models.Pet
import models.Tag
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import steps.addPet

@Epic("Питомец")
@Feature("Создание питомца")
class AddPetTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка создания питомца")
    fun `create pet`() {
        val pet = Pet(
            id = 13,
            category = Category(12, "test"),
            name = "Megapet",
            photoUrls = listOf("https://url.com"),
            tags = listOf(Tag(id = 133, name = "megatag")),
            status = "available"
        )

        When {
            addPet(pet)
        } Then {
            statusCode(200)
            val petResponse = extractAs<Pet>()
            Assertions.assertEquals(petResponse.name, pet.name)
            Assertions.assertEquals(petResponse.id, pet.id)
        }
    }
}