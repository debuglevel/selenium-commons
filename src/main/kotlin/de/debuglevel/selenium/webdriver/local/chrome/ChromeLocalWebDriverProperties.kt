package de.debuglevel.selenium.webdriver.local.chrome

import de.debuglevel.selenium.webdriver.local.LocalWebDriverProperties

class ChromeLocalWebDriverProperties : LocalWebDriverProperties() {
    override var enabled = false
    override var binarypath = ""
}
