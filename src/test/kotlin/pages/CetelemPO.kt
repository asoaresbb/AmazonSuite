package pages


import org.openqa.selenium.By.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait
import seleniumtestinglib.TL.By.text
import java.time.Duration.ofMillis
import java.time.Duration.ofSeconds


class CetelemPO(private val driver: WebDriver) {

    fun navigateToCetelem(): CetelemPO {
        driver.get("https://www.cetelem.pt/")
        return this
    }

    fun navigateToOther(): CetelemPO {
        driver.get("https://www.empruntis.com/financement/credit-immobilier-simulation.php")
        return this
    }

    fun navigateTopdfUpload(): CetelemPO {
        driver.get("https://www.helpconvert.net/en/word-pdf/2?keyword=convert%20to%20pdf&gad_source=1&gclid=CjwKCAiAi6uvBhADEiwAWiyRdpQ0v5jw_ctD7wltvoLenfU2Omc3oN2J-8DqwZthCKTQo-er4QrPLhoChGoQAvD_BwE")
        return this
    }

    fun `accept cookies cetelem`(): CetelemPO {
        WebDriverWait(driver, ofSeconds(8))
            .pollingEvery(ofMillis(200))
            .until(visibilityOfElementLocated(text("Aceitar todas as cookies")))
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

    fun `drag the slider via selenium`(): CetelemPO {
        val slider = driver.findElement(id("input-duration-range"))

        Actions(driver).dragAndDropBy(slider, 50, 0).perform()

        Thread.sleep(2000)
        return this
    }

    fun `upload image`(): CetelemPO {

        driver.findElement(xpath("//button[@id='browse']")).click()

        driver.findElement(cssSelector("input[type=file]"))
            .sendKeys("C:\\Users\\asbernardo\\Downloads\\QA Engineer JD.pdf")

        Thread.sleep(3000)
        return this
    }

}