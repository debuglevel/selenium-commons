package de.debuglevel.selenium.webdriver.local.firefox

import de.debuglevel.selenium.webdriver.local.LocalWebDriverProperties

class FirefoxLocalWebDriverProperties : LocalWebDriverProperties() {
    override var enabled = false
    override var binarypath = ""
}
