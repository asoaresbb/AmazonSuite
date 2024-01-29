import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import pages.OlxHomepagePO

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SendMessageToSellerTest {

    private val driver = WebDriverManager.chromedriver().create()

    @BeforeAll
    fun `maximize window`() {
        driver.manage().window().maximize();
    }

    // Notice how it's taking advantage of the Page Object Model
    // by running multiple instructions on different pages

    @Test
    fun `unregistered sends a message to seller`() {
        OlxHomepagePO(driver)
            .`accept cookies`()
            .`type search`("iphone capa")
            .`run search`()
            .`select first result`()
            .`send a message to seller`()
            .`confirm registration is needed`()
    }

    @AfterAll
    fun `close browser`() {
        driver.quit()
    }
}