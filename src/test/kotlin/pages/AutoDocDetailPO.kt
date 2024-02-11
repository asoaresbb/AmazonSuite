package pages

import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.WebDriver


class AutoDocDetailPO(private val driver: WebDriver) {

    fun navigate(): AutoDocDetailPO {
        driver.get("https://www.auto-doc.pt/")
        return this
    }

    fun `accept cookies`(): AutoDocDetailPO {
        Thread.sleep(1000)
        driver.findElement(cssSelector("#onetrust-accept-btn-handler")).click()
        return this
    }


}