package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class AmazonHomepage(private val driver: WebDriver) {

    init {
        driver.get("https://amazon.com")
    }

    fun `type search`(text: String): AmazonHomepage {
        driver.findElement(By.cssSelector("#nav-search-bar-form input"))
            .sendKeys(text)
        return this
    }

    fun `run search`(): AmazonSearchPage {
        driver.findElement(By.id("nav-search-submit-button")).click()
        return AmazonSearchPage(driver)
    }
}