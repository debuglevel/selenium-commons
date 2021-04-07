package de.debuglevel.selenium.webdriver.firefox

import de.debuglevel.selenium.webdriver.WebDriverService
import io.micronaut.context.annotation.Requires
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import javax.inject.Singleton

@Singleton
@Requires(property = "app.ptk-automation.webdrivers.firefox.enabled", value = "true")
class FirefoxWebDriverService(
    private val firefoxWebDriverProperties: FirefoxWebDriverProperties
) : WebDriverService {
    private val logger = KotlinLogging.logger {}

    override fun get(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        System.setProperty("webdriver.gecko.driver", firefoxWebDriverProperties.binarypath)
        val firefoxDriver = FirefoxDriver()

        return firefoxDriver
    }
}