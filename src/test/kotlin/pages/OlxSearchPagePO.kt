package pages

import org.openqa.selenium.By
import org.openqa.selenium.By.ByClassName
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.ExpectedConditions.attributeContains
import org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import java.time.Duration.ofMillis
import java.time.Duration.ofSeconds

class OlxSearchPagePO(private val driver: WebDriver) {

    init {
        assert(driver.currentUrl.contains("www.olx.pt"))
    }

    fun `select first result`(): OlxDetailPagePO {
        WebDriverWait(driver, ofSeconds(8))
            .pollingEvery(ofMillis(200))
            .until(presenceOfElementLocated(ByClassName("css-qfzx1y")))

        driver.findElements(ByClassName("css-qfzx1y")).first().click()

        return OlxDetailPagePO(driver)
    }
}
