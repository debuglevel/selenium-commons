package de.debuglevel.selenium.webdriver

import org.openqa.selenium.WebDriver

interface WebDriverService {
    fun get(): WebDriver
}