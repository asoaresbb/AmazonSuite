package pages


import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select
import seleniumtestinglib.Role
import seleniumtestinglib.TL.By.role


class AutoDocDetailPO(private val driver: WebDriver) {

    fun navigate(): AutoDocDetailPO {
        driver.get("https://www.auto-doc.pt/")
        return this
    }

    fun `accept cookies`(): AutoDocDetailPO {
        driver.findElement(role(Role.Button, "Aceitar todos os cookies")).click()
        return this
    }

    fun `select elements from dropdown`(): AutoDocDetailPO {
        val listaCarros = driver.findElement(cssSelector("#form_maker_id"))

        Select(listaCarros).selectByIndex(4)
        println("Selecionei Renault via índice")
        Thread.sleep(2000)

        Select(listaCarros).selectByValue("74")
        println("Alterei para Mercedes-Benz via value")
        Thread.sleep(2000)

        Select(listaCarros).selectByVisibleText("FORD")
        println("Alterei para Ford via texto visível")
        Thread.sleep(2000)

        for (car in Select(listaCarros).options) {
            println(car.text)
        }
        return this
    }

}