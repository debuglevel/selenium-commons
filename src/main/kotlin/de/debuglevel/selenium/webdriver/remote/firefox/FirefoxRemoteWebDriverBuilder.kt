package de.debuglevel.selenium.webdriver.remote.firefox

import de.debuglevel.selenium.webdriver.WebDriverBuilder
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver

class FirefoxRemoteWebDriverBuilder(
    private val firefoxRemoteWebDriverProperties: FirefoxRemoteWebDriverProperties
) : WebDriverBuilder {
    private val logger = KotlinLogging.logger {}

    override fun build(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        val firefoxOptions = FirefoxOptions()
        val remoteDriver = RemoteWebDriver(firefoxRemoteWebDriverProperties.url, firefoxOptions)
        remoteDriver.fileDetector = LocalFileDetector()

        logger.debug { "Got WebDriver: $remoteDriver" }
        return remoteDriver
    }
}