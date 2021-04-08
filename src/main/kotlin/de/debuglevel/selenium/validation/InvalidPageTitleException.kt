package de.debuglevel.selenium.validation

/**
 * Thrown if the page title is not the one which was expected.
 * @param actualPageTitle The current page title
 * @param expectedPageTitle Which page title was expected
 */
class InvalidPageTitleException(
    actualPageTitle: String,
    expectedPageTitle: String
) : InvalidPageException("Page title is '$actualPageTitle' although it was expected to be '$expectedPageTitle'", inner)