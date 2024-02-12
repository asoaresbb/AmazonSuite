package pages


import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select
import seleniumtestinglib.locators.ByText


class AutoDocDetailPO(private val driver: WebDriver) {

    fun navigate(): AutoDocDetailPO {
        driver.get("https://www.auto-doc.pt/")
        return this
    }

    fun `accept cookies`(): AutoDocDetailPO {
        driver.findElement(ByText("Aceitar todos os cookies", exact = false)).click()
        return this
    }

    fun `select elements from dropdown`(): AutoDocDetailPO {
        val carDropdown = Select(driver.findElement(cssSelector("#form_maker_id")))

        carDropdown.selectByIndex(4)
        println("Selecionei Audi via índice")
        Thread.sleep(2000)

        carDropdown.selectByValue("74")
        println("Alterei para Mercedes-Benz via value")
        Thread.sleep(2000)

        carDropdown.selectByVisibleText("FORD")
        println("Alterei para Ford via texto visível")
        Thread.sleep(2000)

        for (option in carDropdown.options) {
            println(option.text)
        }
        return this
    }

}