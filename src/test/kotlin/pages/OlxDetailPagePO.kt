package pages

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.openqa.selenium.By
import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class OlxDetailPagePO(private val driver: WebDriver) {

    init {
        WebDriverWait(driver, Duration.ofSeconds(8))
            .pollingEvery(Duration.ofMillis(200))
            .until(presenceOfElementLocated(By.ByClassName("css-xhd036")))
        assertTrue(driver.findElement(cssSelector(".css-xhd036")).isEnabled)
    }

    fun `send a message to seller`(): OlxDetailPagePO {
        driver.findElement(cssSelector(".css-xhd036")).click()
        return this
    }

    fun `confirm registration is needed`(): OlxDetailPagePO {
        WebDriverWait(driver, Duration.ofSeconds(8))
            .pollingEvery(Duration.ofMillis(200))
            .until(presenceOfElementLocated(cssSelector(".css-1a74nwz .css-1oea5q3")))
        assertEquals("Email", driver.findElement(cssSelector(".css-1a74nwz .css-1oea5q3")).text)
        return this
    }
}