package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import seleniumtestinglib.TL.By.text
import utils.CustomSelectorMethod

class MediumPO(private val driver: WebDriver) {

    private val alexa = CustomSelectorMethod(driver)

    fun navigateToMedium(): MediumPO {
        driver.get("https://medium.com/")
        return this
    }

    fun `write an article`(): MediumPO {
        alexa.getElement("xpath", "//a[.='Write']")?.click()
        alexa.getElement("xpath", "//a[.='Apply now']")?.click()
        Thread.sleep(1500)
        return this
    }

    fun `hover over an element`(author: String): MediumPO {
        Actions(driver).moveToElement(driver.findElement(text(author))).perform()
        Thread.sleep(1000)
        driver.findElement(text("Follow")).click()
        Thread.sleep(1000)

        return this
    }


}