package de.debuglevel.selenium.webdriver.remote.firefox

import de.debuglevel.selenium.webdriver.remote.RemoteWebDriverProperties
import java.net.URL

/**
 * Properties to configure a remote Firefox WebDriver
 * @param url URL to the remote WebDriver (e.g. `http://localhost:4001/wd/hub`)
 */
class FirefoxRemoteWebDriverProperties(
    url: URL,
) : RemoteWebDriverProperties(url)