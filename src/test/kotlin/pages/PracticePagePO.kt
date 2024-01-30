package pages

import org.openqa.selenium.By.*
import org.openqa.selenium.WebDriver

class PracticePagePO(private val driver: WebDriver) {

    fun navigateLogin(): PracticePagePO {
        driver.get("https://www.letskodeit.com/login")
        return this
    }

    fun navigatePracticeSelectors(): PracticePagePO {
        driver.get("https://www.letskodeit.com/practice")
        return this
    }

    //TODO Dados de teste não deveria estar na camada de teste? e não na de implementação.
    fun `select by css - placeholder`(): PracticePagePO {
        driver.findElement(cssSelector("[placeholder='Email Address']")).sendKeys("letskodeit@gmail.com")
        return this
    }

    fun `select by xpath with visible text`(): PracticePagePO {
        driver.findElement(xpath("//a[text()='HOME']")).click()
        return this
    }

    fun `select by relative xpath`(): PracticePagePO {
        driver.findElement(xpath("//button[@id='openwindow']")).click()
        return this
    }

    fun `select by linkText`(): PracticePagePO {
        driver.findElement(linkText("SIGN IN")).click()
        return this
    }



}