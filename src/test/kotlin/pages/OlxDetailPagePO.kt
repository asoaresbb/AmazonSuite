package pages

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.openqa.selenium.By
import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.WebDriver

class OlxDetailPagePO(private val driver: WebDriver) {

    init {
        assertTrue(driver.findElement(By.cssSelector(".css-xhd036")).isEnabled)
    }

    fun `send a message to seller`(): OlxDetailPagePO {
        driver.findElement(cssSelector(".css-xhd036")).click()
        return this
    }

    fun `confirm registration is needed`(): OlxDetailPagePO {
        Thread.sleep(3000)
        assertEquals("Email", driver.findElement(cssSelector(".css-1a74nwz .css-1oea5q3")).text)
        return this
    }
}