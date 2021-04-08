package de.debuglevel.selenium.validation

/**
 * Thrown if the page URL differs from the expected one.
 * @param actualUrl The current page URL.
 * @param expectedUrl The expected page URL.
 */
class InvalidUrlException(
    actualUrl: String,
    expectedUrl: String
) : InvalidPageException("Page URL is '$actualUrl' although it was expected to be '$expectedUrl'")