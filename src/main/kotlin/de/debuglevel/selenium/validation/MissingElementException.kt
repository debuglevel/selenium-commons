package de.debuglevel.selenium.validation

import org.openqa.selenium.By

/**
 * Thrown if the page should contain an element but does not.
 * @param by Which element was expected to exist.
 */
class MissingElementException(by: By, inner: Exception) :
    InvalidPageException("No matching element for '$by' could be found, although it should exist.", inner)