package de.debuglevel.selenium.webdriver.chrome

import de.debuglevel.selenium.webdriver.WebDriverService
import io.micronaut.context.annotation.Requires
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import javax.inject.Singleton

@Singleton
@Requires(property = "app.ptk-automation.webdrivers.chrome.enabled", value = "true")
class ChromeWebDriverService(
    private val chromeWebDriverProperties: ChromeWebDriverProperties
) : WebDriverService {
    private val logger = KotlinLogging.logger {}

    override fun get(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        System.setProperty("webdriver.chrome.driver", chromeWebDriverProperties.binarypath)
        val chromeDriver = ChromeDriver()

        return chromeDriver
    }
}