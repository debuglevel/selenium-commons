package de.debuglevel.selenium.webdriver.remote.chrome

import de.debuglevel.selenium.webdriver.remote.RemoteWebDriverProperties

class ChromeRemoteWebDriverProperties : RemoteWebDriverProperties() {
    override var enabled = false
    override var url = ""
}
