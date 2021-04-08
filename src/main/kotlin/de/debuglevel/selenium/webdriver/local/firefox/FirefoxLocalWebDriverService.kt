package de.debuglevel.selenium.webdriver.local.firefox

import de.debuglevel.selenium.webdriver.WebDriverService
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

class FirefoxLocalWebDriverService(
    private val firefoxWebDriverProperties: FirefoxLocalWebDriverProperties
) : WebDriverService {
    private val logger = KotlinLogging.logger {}

    override fun get(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        System.setProperty("webdriver.gecko.driver", firefoxWebDriverProperties.binarypath)
        val firefoxDriver = FirefoxDriver()

        return firefoxDriver
    }
}