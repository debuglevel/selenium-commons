package de.debuglevel.selenium

class InvalidContentException(
    actualContent: String,
    expectedContent: String
) :
    InvalidPageException("Element content is '$actualContent' although it was expected to be '$expectedContent'")