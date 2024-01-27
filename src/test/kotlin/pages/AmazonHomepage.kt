package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions.urlContains
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration.ofMillis

import java.time.Duration.ofSeconds

class AmazonHomepage(private val driver: WebDriver) {

    init {
        driver.get("https://amazon.com")
    }

    fun `type search`(text: String): AmazonHomepage {
        WebDriverWait(driver, ofSeconds(5))
            .pollingEvery(ofMillis(50))
            .until(
                urlContains("amazon.com/")
            )
        driver.findElement(By.cssSelector("#nav-search-bar-form input"))
            .sendKeys(text)
        return this
    }

    fun `run search`(): AmazonSearchPage {
        driver.findElement(By.id("nav-search-submit-button")).click()
        return AmazonSearchPage(driver)
    }
}