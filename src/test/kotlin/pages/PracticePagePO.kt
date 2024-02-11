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
        Thread.sleep(2000)
        return this
    }

    fun `clear text`(): PracticePagePO {
        driver.findElement(cssSelector("[placeholder='Email Address']")).sendKeys("letskodeit@gmail.com")
        Thread.sleep(2000)
        driver.findElement(cssSelector("[placeholder='Email Address']")).clear()
        Thread.sleep(2000)
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

    fun `get and print the title`(): PracticePagePO {
        val title = driver.title
        println("Este é o título da página: $title")
        return this
    }

    fun `get and print the url`(): PracticePagePO {
        val currentUrl = driver.currentUrl
        println("Estamos neste url: $currentUrl")
        return this
    }

    fun `navigate back and forward on browser`(): PracticePagePO {
        val navigateToHome = "https://www.letskodeit.com/home"
        driver.navigate().to(navigateToHome)
        Thread.sleep(1000)
        driver.navigate().back()
        Thread.sleep(1000)
        driver.navigate().forward()
        return this
    }

    fun `refresh current page`(): PracticePagePO {
        Thread.sleep(2000)
        driver.navigate().refresh()
        return this
    }

}