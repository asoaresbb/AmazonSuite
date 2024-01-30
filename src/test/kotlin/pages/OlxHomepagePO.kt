package pages

import org.openqa.selenium.By
import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.By.name
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration.ofMillis

import java.time.Duration.ofSeconds

class OlxHomepagePO(private val driver: WebDriver) {

    init {
        driver.get("https://olx.pt")
    }

    fun `accept cookies`(): OlxHomepagePO {
        driver.findElement(cssSelector("#onetrust-accept-btn-handler")).click()
        return this
    }

    fun `type search`(text: String): OlxHomepagePO {
        WebDriverWait(driver, ofSeconds(8))
            .pollingEvery(ofMillis(200))
            .until(elementToBeClickable((name("searchBtn"))))

        driver.findElement(By.cssSelector("#search"))
            .sendKeys(text)
        return this
    }

    fun `run search`(): OlxSearchPagePO {
        driver.findElement(name("searchBtn")).click()
        return OlxSearchPagePO(driver)
    }
}