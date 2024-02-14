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

    fun `select by css - attribute placeholder`(email: String): PracticePagePO {
        driver.findElement(cssSelector("[placeholder='Email Address']")).sendKeys(email)
        Thread.sleep(2000)
        return this
    }

    fun `clear text`(email: String): PracticePagePO {
        driver.findElement(cssSelector("[placeholder='Email Address']")).sendKeys(email)
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
        Thread.sleep(2000)
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