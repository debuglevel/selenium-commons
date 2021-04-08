package de.debuglevel.selenium

/**
 * Thrown if the current page does not seem the one which was expected.
 */
open class InvalidPageException(message: String? = null) : Exception(message)
