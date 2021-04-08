package de.debuglevel.selenium.validation

import org.openqa.selenium.WebElement

/**
 * Thrown if the page should display an element but does not (although it might exist hidden).
 * @param element Which element was expected to be displayed.
 */
class ElementNotDisplayedException(element: WebElement) :
    InvalidPageException("Element '$element' is not displayed.")