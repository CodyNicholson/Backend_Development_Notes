# This code will open a chrome browser, go to my GitHub Profile, check the username and full name, 
# click on the Test_Case_Automation repository, and verify that this file exists in that repository

from selenium import webdriver

driver = webdriver.Chrome('C:\Program Files (x86)\Google\Chrome\chromedriver.exe')
driver.get("https://github.com/Cody-Nicholson96")

#ER1
expectedValue = "Cody Nicholson"
actualValue = driver.find_element_by_xpath("//div[@class='vcard-fullname']").text
failureDetails ="The Full name was wrong on the GitHub profile page for Cody Nicholson"
assert (actualValue == expectedValue), failureDetails

#ER2
expectedValue = "Cody-Nicholson96"
actualValue = driver.find_element_by_xpath("//div[@class='vcard-username']").text
failureDetails = "The User Name was incorrect on the GitHub profile page"
assert (actualValue == expectedValue), failureDetails

driver.find_element_by_xpath("//ul//span[@title='Test_Case_Automation']").click()

#ER3
expectedValue = "testCaseAutomationInPython.py"
actualValue = driver.find_element_by_xpath("//div[@class='repository-content']//a[@title='testCaseAutomationInPython.py']").text
failureDetails = "The 'testCaseAutomationInPython.py' file did not exist in the 'Test_Case_Automation' repository"
assert (actualValue == expectedValue), failureDetails

driver.close()
