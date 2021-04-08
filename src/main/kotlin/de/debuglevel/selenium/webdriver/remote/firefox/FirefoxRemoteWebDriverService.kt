package de.debuglevel.selenium.webdriver.remote.firefox

import de.debuglevel.selenium.webdriver.WebDriverService
import mu.KotlinLogging
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver

class FirefoxRemoteWebDriverService(
    private val firefoxRemoteWebDriverProperties: FirefoxRemoteWebDriverProperties
) : WebDriverService {
    private val logger = KotlinLogging.logger {}

    override fun get(): WebDriver {
        logger.debug { "Getting WebDriver..." }

        val firefoxOptions = FirefoxOptions()
        val remoteDriver = RemoteWebDriver(firefoxRemoteWebDriverProperties.url, firefoxOptions)
        remoteDriver.fileDetector = LocalFileDetector()

        logger.debug { "Got WebDriver: $remoteDriver" }
        return remoteDriver
    }
}