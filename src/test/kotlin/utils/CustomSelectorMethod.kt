package utils

import org.openqa.selenium.By.id
import org.openqa.selenium.By.xpath
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

data class CustomSelectorMethod(private val driver: WebDriver) {

    fun getElement(type: String, locator: String): WebElement? {
        val lowerCaseType = type.lowercase()
        return when (lowerCaseType) {
            "id" -> {
                driver.findElement(id(locator))
            }

            "xpath" -> {
                driver.findElement(xpath(locator))
            }

            else -> {
                println("ola")
                return null
            }
        }
    }

}