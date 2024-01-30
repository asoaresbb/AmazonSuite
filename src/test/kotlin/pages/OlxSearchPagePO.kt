package pages

import org.openqa.selenium.By.ByClassName
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration.ofMillis
import java.time.Duration.ofSeconds

class OlxSearchPagePO(private val driver: WebDriver) {

    init {
        assert(driver.currentUrl.contains("www.olx.pt"))
    }

    fun `select first result`(): OlxDetailPagePO {
        WebDriverWait(driver, ofSeconds(8))
            .pollingEvery(ofMillis(200))
            .until(visibilityOfElementLocated(ByClassName("css-qfzx1y")))

        driver.findElements(ByClassName("css-qfzx1y")).first().click()

        return OlxDetailPagePO(driver)
    }
}
