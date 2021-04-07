package de.debuglevel.selenium

class InvalidUrlException(actualUrl: String, assumedUrl: String) :
    InvalidPageException("Page URL is '$actualUrl' although it was assumed to be '$assumedUrl'")