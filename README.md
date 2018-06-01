# Trailhead Badges Scraper

## Description

This Java application has been created to get the data in [Trailhead.com](https://trailhead.salesforce.com)
from every badge to be stored in a NoSQL database.

## Configuration

* application.properties with the next parameters: uri (to connect to the database host), database (name),
collection (name), and test (a test value for JUnit).
* [ChromeDriver](https://chromedriver.storage.googleapis.com/index.html) installed.

## Badges

[Trailhead.com](https://trailhead.salesforce.com) has three different types
of badges:

* Modules
* Projects
* Superbadges

The data stored from these badges is the next one:

* Type: Represents if the badge is a Module, Project or Superbadge.
* Name: Contains the name of the badge.
* Href: Represents the URL of the badge inside [Trailhead.com](https://trailhead.salesforce.com)
* Hours: The estimated duration of every badge.

*Note: Superbadges has a minimum and maximum estimated duration.*

## Sample Data

**Modules**

    {
        "type": "Module",
        "name": "API Basics",
        "href": "https://trailhead.salesforce.com/modules/api_basics",
        "hours": 2.00
    }
    
**Projects**

    {
        "type": "Project",
        "name": "Build Flexible Apps with Visualforce Pages and Lightning Components",
        "href": "https://trailhead.salesforce.com/projects/workshop-lightning-programmatic",
        "hours": 1.83
    }
    
**Superbadges**

    {
        "type": "Superbadge",
        "name": "Advanced Apex Specialist",
        "href": "https://trailhead.salesforce.com/en/superbadges/superbadge_aap",
        "hours": {
            "min": 12.00,
            "max": 16.00
        }
    }