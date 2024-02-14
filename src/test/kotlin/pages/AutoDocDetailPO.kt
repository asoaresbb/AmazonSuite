package pages


import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select
import seleniumtestinglib.locators.ByRole
import seleniumtestinglib.locators.Role.Button


class AutoDocDetailPO(private val driver: WebDriver) {

    fun navigate(): AutoDocDetailPO {
        driver.get("https://www.auto-doc.pt/")
        return this
    }

    fun `accept cookies`(): AutoDocDetailPO {
        driver.findElement(ByRole(Button, "Aceitar todos os cookies")).click()
        return this
    }

    fun `select elements from dropdown`(): AutoDocDetailPO {
        val dropdown = driver.findElement(cssSelector("#form_maker_id"))

        Select(dropdown).selectByIndex(4)
        println("Selecionei Audi via índice")
        Thread.sleep(2000)

        Select(dropdown).selectByValue("74")
        println("Alterei para Mercedes-Benz via value")
        Thread.sleep(2000)

        Select(dropdown).selectByVisibleText("FORD")
        println("Alterei para Ford via texto visível")
        Thread.sleep(2000)

        for (option in Select(dropdown).options) {
            println(option.text)
        }
        return this
    }

}