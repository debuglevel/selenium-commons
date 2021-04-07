package de.debuglevel.selenium

class InvalidContentException(actualContent: String, assumedContent: String) :
    InvalidPageException("Element content is '$actualContent' although it was assumed to be '$assumedContent'")