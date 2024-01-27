package pages

import org.openqa.selenium.By.ByClassName
import org.openqa.selenium.WebDriver

class AmazonSearchPage(private val driver: WebDriver) {

    init {
        assert(driver.currentUrl.contains("/s?"))
    }

    fun `select first result`(): AmazonDetailPage {
        //driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-medium a-color-base a-text-normal']"))
        //    .click()
        driver.findElements(ByClassName("puisg-col-inner")).first().click()
        return AmazonDetailPage(driver)
    }
}
