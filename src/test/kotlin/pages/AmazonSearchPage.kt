package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class AmazonSearchPage(private val driver: WebDriver) {

    init {
        assert(driver.currentUrl.contains("/s?"))
    }

    fun `select sponsored`(): AmazonDetailPage {
        driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-medium a-color-base a-text-normal']"))
            .click()
        return AmazonDetailPage(driver)
    }
}
