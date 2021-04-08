package de.debuglevel.selenium.webdriver.remote.chrome

import de.debuglevel.selenium.webdriver.remote.RemoteWebDriverProperties
import java.net.URL

/**
 * Properties to configure a remote Chrome WebDriver
 * @param url URL to the remote WebDriver (e.g. `http://localhost:4001/wd/hub`)
 */
class ChromeRemoteWebDriverProperties(
    url: URL,
) : RemoteWebDriverProperties(url)