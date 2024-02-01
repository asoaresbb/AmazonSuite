package pages

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.openqa.selenium.By
import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration.ofMillis
import java.time.Duration.ofSeconds

class OlxDetailPagePO(private val driver: WebDriver) {

    init {
        WebDriverWait(driver, ofSeconds(8))
            .pollingEvery(ofMillis(200))
            .until(visibilityOfElementLocated(By.ByClassName("css-xhd036")))
        assertTrue(driver.findElement(cssSelector(".css-xhd036")).isEnabled)
    }

    fun `send a message to seller`(): OlxDetailPagePO {
        driver.findElement(cssSelector(".css-xhd036")).click()
        return this
    }

    fun `confirm registration is needed`(): OlxDetailPagePO {
        WebDriverWait(driver, ofSeconds(8))
            .pollingEvery(ofMillis(200))
            .until(visibilityOfElementLocated(cssSelector(".css-1a74nwz .css-1oea5q3")))
        assertEquals("Email", driver.findElement(cssSelector(".css-1a74nwz .css-1oea5q3")).text)
        return this
    }
}