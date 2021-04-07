package de.debuglevel.selenium

class SendKeysFailedException(actualContent: String, sentKeys: String) :
    InvalidPageException("Content of element is '$actualContent' although keys '$sentKeys' were sent")