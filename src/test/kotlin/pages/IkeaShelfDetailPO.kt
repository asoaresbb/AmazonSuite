package pages

import org.openqa.selenium.By.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration.ofMillis
import java.time.Duration.ofSeconds
import kotlin.test.assertEquals


class IkeaShelfDetailPO(private val driver: WebDriver) {
    /*
        init {
            // Assert ao título inicial da página ou ao url
            val expectedTitle = "My Awesome Website"
            assertEquals(driver.title, expectedTitle)
            println("Initial page title doesn't match expected: ${driver.title}")

            // Alternativamente, assert ao estado de um elemento
            val logoElement = driver.findElement(id("headerLogo")).isDisplayed
            assertTrue(logoElement)
            println("Logo element not visible on the page")

        }*/

    fun navigateProduct(): IkeaShelfDetailPO {
        //Com stock:
        driver.get("https://www.ikea.com/pt/pt/p/blavingad-toalha-de-banho-padrao-de-tartarugas-azul-escuro-60534066/")
        //Sem stock
        //driver.get("https://www.ikea.com/pt/pt/p/vagsjoen-toalhas-de-maos-banho-conj-l-s29506004/")
        return this
    }

    fun navigateAvailableColors(): IkeaShelfDetailPO {
        driver.get("https://www.ikea.com/pt/pt/p/fredriksjoen-toalha-de-banho-vermelho-escuro-40552749/")
        return this
    }

    fun `accept cookies`(): IkeaShelfDetailPO {
        Thread.sleep(1000)
        driver.findElement(cssSelector("#onetrust-accept-btn-handler")).click()
        return this
    }

    fun `change zip code`(postalCode: String): IkeaShelfDetailPO {
        driver.findElement(cssSelector(".hnf-btn--small.hnf-location__postalcode .hnf-btn__label")).click()
        driver.findElement(id("hnf-txt-postalcodepicker-postcode")).sendKeys(postalCode)
        driver.findElement(xpath("//span[text()='Guardar']")).click()
        Thread.sleep(1000)
        return this
    }

    fun `add to basket or print text`(): IkeaShelfDetailPO {
        val isStock = driver.findElement(cssSelector(".pip-btn--fluid .pip-btn__label"))

        when {
            isStock.text == "Adicionar ao cesto" -> {
                isStock.click()
                println("Adicionei ao cesto!")
                Thread.sleep(1000)
            }

            else -> {
                driver.findElement(cssSelector(".pip-store-section")).click()
                Thread.sleep(1000)
                println("Alerta de indisponibilidade!")
            }
        }
        return this
    }

    fun `first or null`(): IkeaShelfDetailPO {
        driver.findElements(className("pip-product-styles__item"))
            .firstOrNull()
            ?.click()
        val selectedProduct = driver.findElement(cssSelector("h1 .pip-header-section__description-text")).text

        println("Selecionaste: $selectedProduct")
        return this
    }

    fun `assert zip code`(zipCode: String): IkeaShelfDetailPO {
        WebDriverWait(driver, ofSeconds(5))
            .pollingEvery(ofMillis(200))
            .until(visibilityOfElementLocated(xpath("//p[@class='hnf-toast__text']")))

        val expectedMessage = "Selecionou $zipCode como o seu código postal"
        val actualMessage = driver.findElement(xpath("//p[@class='hnf-toast__text']")).text
        assertEquals(expectedMessage, actualMessage, "Zip code message doesn't match expected")

        return this
    }


}