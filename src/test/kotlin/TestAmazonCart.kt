import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import pages.AmazonHomepage

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestAmazonCart {

    private val driver = WebDriverManager.chromedriver().create()

    // Notice how it's taking advantage of the Page Object Model
    // by running multiple instructions on different pages

    @Test
    fun `add to cart`() {
        AmazonHomepage(driver)
            .`type search`("OTOFLY iphone case")
            .`run search`()
            .`select first result`()
            .`add to cart`()
    }

    @AfterAll
    fun `close browser`() {
        driver.close()
    }
}