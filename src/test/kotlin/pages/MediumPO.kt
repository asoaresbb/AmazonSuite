package pages

import org.openqa.selenium.By.xpath
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
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

    fun `hover over an element`(): MediumPO {
        val hoverElement = Actions(driver)

        hoverElement.moveToElement(driver.findElement(xpath("//h4[.='Rachel Jamison']"))).perform()
        Thread.sleep(1000)
        driver.findElement(xpath("//a[.='protectavolunteer.com']")).click()
        Thread.sleep(1000)

        return this
    }


}