package de.debuglevel.selenium.webdriver.local

import de.debuglevel.selenium.webdriver.WebDriverProperties

abstract class LocalWebDriverProperties : WebDriverProperties() {
    abstract var binarypath: String
}