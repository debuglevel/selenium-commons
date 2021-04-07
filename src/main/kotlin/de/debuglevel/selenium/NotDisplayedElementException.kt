package de.debuglevel.selenium

import org.openqa.selenium.WebElement

class NotDisplayedElementException(element: WebElement) : InvalidPageException("Element '$element' is not displayed.")