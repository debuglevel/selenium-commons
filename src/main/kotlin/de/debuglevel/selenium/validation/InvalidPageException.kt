package de.debuglevel.selenium.validation

/**
 * Thrown if the current page does not seem the one which was expected.
 */
open class InvalidPageException(message: String? = null, inner: Exception? = null) : Exception(message, inner)
