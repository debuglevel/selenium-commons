package de.debuglevel.selenium.webdriver.local.firefox

import de.debuglevel.selenium.webdriver.WebDriverBuilder
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

class FirefoxLocalWebDriverBuilder(
    private val firefoxWebDriverProperties: FirefoxLocalWebDriverProperties
) : WebDriverBuilder {
    private val logger = KotlinLogging.logger {}

    override fun build(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        System.setProperty("webdriver.gecko.driver", firefoxWebDriverProperties.driverBinaryPath.toString())
        val firefoxDriver = FirefoxDriver()

        logger.debug { "Got WebDriver: $firefoxDriver" }
        return firefoxDriver
    }
}