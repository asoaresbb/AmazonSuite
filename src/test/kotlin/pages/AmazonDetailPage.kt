package pages

import org.junit.jupiter.api.Assertions.assertTrue
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import kotlin.test.assertEquals

class AmazonDetailPage(private val driver: WebDriver) {

    init {
        assertTrue(driver.findElement(By.cssSelector("#add-to-cart-button")).isEnabled)
    }

    fun `add to cart`(): AmazonDetailPage {
        driver.findElement(By.cssSelector("#add-to-cart-button")).click()
        assertEquals("Added to Cart", driver.findElement(By.cssSelector(".a-size-medium-plus")).text)
        return this
    }
}