# XE case study 
Your machine must have the corresponding JDK installed, maven will deal with the rest dependencies, which can be seen in the pom file.

Create a maven project with the below tools:
- Cucumber
- Selenium
- testNG
- Gerhkin 

# Run smoke test
- Create file testng.xml for the smoke test
- Open terminal and write **mvn clean test** 
- In the folder **src>test>resources>features** you may find the Cucumber files

# Cucumber report 
In the folder **target>cucumber-report-html>js>overview-features.html**


### Part1
------
File name: **"returnedResultsForRentHouses.feature"**
- On the context of this part 1 check if in page "House for rent",the results that returned related with "house for rent"

### Part2
------
File Name: **"filterGreaterThanFiveHundredThousand.feature"**
- In this part 2 check if the results that returned back in page "House for sales" are greater than 500.000

### Part3
------
File name: **"selectLandForSaleApplyPlotFilterSaveSearch.feature"**
- In part 3 which based on "land for sale" checked if when user is login can save his search.If search is already saved, then the search is deleted
