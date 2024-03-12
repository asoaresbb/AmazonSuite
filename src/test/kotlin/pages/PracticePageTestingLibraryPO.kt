package pages


import org.openqa.selenium.WebDriver
import seleniumtestinglib.Role
import seleniumtestinglib.TL.By.altText
import seleniumtestinglib.TL.By.placeholderText
import seleniumtestinglib.TL.By.role
import seleniumtestinglib.TL.By.text


class PracticePageTestingLibraryPO(private val driver: WebDriver) {

    fun navigateLogin(): PracticePageTestingLibraryPO {
        driver.get("https://www.letskodeit.com/login")
        return this
    }

    fun navigatePracticeSelectors(): PracticePageTestingLibraryPO {
        driver.get("https://www.letskodeit.com/practice")
        return this
    }

    fun navigateECommerce(): PracticePageTestingLibraryPO {
        driver.get("https://ecommercepractice.letskodeit.com/")
        return this
    }

    fun `select by role`(): PracticePageTestingLibraryPO {
        driver.findElement(role(Role.Button, "Alert")).click()
        Thread.sleep(2000)
        return this
    }

    fun `select by placeholderText`(email: String): PracticePageTestingLibraryPO {
        driver.findElement(placeholderText("Email")).sendKeys(email)
        Thread.sleep(2000)
        return this
    }

    fun `select by text`(): PracticePageTestingLibraryPO {
        driver.findElement(text("SHOP NOW")).click()
        Thread.sleep(2000)
        return this
    }

    fun `select by alternative text`(): PracticePageTestingLibraryPO {
        driver.findElement(altText("blog new standard of closing")).click()

        Thread.sleep(2000)
        return this
    }


}