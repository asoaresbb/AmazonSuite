package pages

import org.openqa.selenium.By.ByClassName
import org.openqa.selenium.WebDriver

class OlxSearchPagePO(private val driver: WebDriver) {

    init {
        assert(driver.currentUrl.contains("www.olx.pt"))
    }

    fun `select first result`(): OlxDetailPagePO {
        /*
        driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-medium a-color-base a-text-normal']"))
            .click()

        WebDriverWait(driver, ofSeconds(8))
            .pollingEvery(ofMillis(50))
            .until(elementToBeClickable(cssSelector("#location-input")))

         */

        Thread.sleep(7000)
        driver.findElements(ByClassName("css-qfzx1y")).first().click()
        Thread.sleep(3000)
        return OlxDetailPagePO(driver)
    }
}
