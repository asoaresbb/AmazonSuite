package pages

import org.openqa.selenium.By.className
import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.WebDriver


class IkeaShelfDetailPO(private val driver: WebDriver) {

    fun navigateProduct(): IkeaShelfDetailPO {
        //Sem stock:
        //driver.get("https://www.ikea.com/pt/pt/p/persby-estante-de-parede-branco-10191264/")
        //Com stock:
        driver.get("https://www.ikea.com/pt/pt/p/persby-estante-de-parede-pret-cast-50191262/")
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

    fun `check stock`(): IkeaShelfDetailPO {
        when {
            driver.findElement(cssSelector(".pip-btn--fluid")).isEnabled -> {
                driver.findElement(cssSelector(".pip-btn--fluid")).click()
                println("Eu cliquei lá!")
                Thread.sleep(2000)
            }

            else -> println("Não tem stock do produto")
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

}