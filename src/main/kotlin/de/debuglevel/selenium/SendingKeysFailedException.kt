package de.debuglevel.selenium

/**
 * Thrown if an element has not the content which was sent to it.
 */
class SendingKeysFailedException(
    actualContent: String,
    sentKeys: String
) : Exception("Content of element is '$actualContent' although keys '$sentKeys' were sent")