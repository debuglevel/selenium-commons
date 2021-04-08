package de.debuglevel.selenium.webdriver.remote

import de.debuglevel.selenium.webdriver.WebDriverProperties
import java.net.URL

/**
 * Properties to configure a remote WebDriver
 * @param url URL to the remote WebDriver (e.g. `http://localhost:4001/wd/hub`)
 */
abstract class RemoteWebDriverProperties(
    val url: URL,
) : WebDriverProperties()