package pages


import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.By.id
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait
import seleniumtestinglib.locators.ByText
import java.time.Duration.ofMillis
import java.time.Duration.ofSeconds


class CetelemPO(private val driver: WebDriver) {

    private val js = driver as JavascriptExecutor

    fun navigateToCetelem(): CetelemPO {
        driver.get("https://www.cetelem.pt/")
        return this
    }

    fun navigateToOther(): CetelemPO {
        driver.get("https://www.empruntis.com/financement/credit-immobilier-simulation.php")
        return this
    }

    fun `accept cookies cetelem`(): CetelemPO {
        WebDriverWait(driver, ofSeconds(8))
            .pollingEvery(ofMillis(200))
            .until(visibilityOfElementLocated(ByText("Aceitar todas as cookies")))
            .click()
        return this
    }

    fun `accept cookies empruntis`(): CetelemPO {
        Thread.sleep(3000)
        WebDriverWait(driver, ofSeconds(8))
            .pollingEvery(ofMillis(200))
            .until(visibilityOfElementLocated(cssSelector("#axeptio_btn_acceptAll")))
            .click()
        return this
    }

//    //TODO slider mal construído sem acessibilade nem aria role(abrir ticket jira)
//    fun `drag the slider via js`(): CetelemPO {
//        val slider = driver.findElement(cssSelector(".noUi-origin"))
//        Actions(driver).dragAndDropBy(slider, 50, 0).perform()
//
//        Thread.sleep(2000)
//        return this
//    }

    fun `drag the slider via selenium`(): CetelemPO {
        val slider = driver.findElement(id("input-duration-range"))

        Actions(driver).dragAndDropBy(slider, 50, 0).perform()

        Thread.sleep(2000)
        return this
    }

}