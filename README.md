# Confluence Boilerplates plugin

## Introduction

This plugin gives confluence authors the ability to use boilerplates - little
 snippets based on other confluence pages - to include into the current page.

Currently only supported for Confluence Server & Datacenter.
 
## Installation

Download the obr-file from the latest release and install it using the universal plugin manager.

## Configuration

Per default, confluence pages labeled with "boilerplate" in every available 
space are available in the editor using the "Add Boilerplate"-button.
 
You can use the administrator configuration menu to change the used label and
 if the pages are searched using all available spaces or only the space the 
 currently edited page is in.

The items in the boilerplate menu will be the titles of the found pages. You can 
structure the items by using a separator (_ by default) in the titles. This will
create matching submenus

## Building

Install the [Atlassian Plugin SDK](https://developer.atlassian.com/server/framework/atlassian-sdk/downloads/), set
your JAVA_HOME variable to a Java 11 JDK home and run atlas-package from this folder.