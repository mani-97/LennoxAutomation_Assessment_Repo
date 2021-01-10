package org.lennox.functions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetElementDisplayed;
import org.openqa.selenium.support.PageFactory;

import com.lennox.base.Utility;
import com.lennox.pageobject.proposal.AddLeadPageObject;
import com.lennox.pageobject.proposal.HomePagePageObject;
import com.lennox.pageobject.proposal.LoginPageObject;

public class BuildProposalValidations extends Utility {

	LoginPageObject loginPgObject;
	HomePagePageObject homePgObject;
	AddLeadPageObject addLeadPgObject;
	String formattedDate;

	public void loginAndVerify(){

		try {
			loginPgObject = PageFactory.initElements(driver, LoginPageObject.class);
			homePgObject = PageFactory.initElements(driver, HomePagePageObject.class);
			click(loginPgObject.getSignInBtn());
			fillTextBox(loginPgObject.getUserNameFld(), credentials.get("UserName"),10);
			fillTextBox(loginPgObject.getPasswordFld(), credentials.get("Password"),10);
			click(loginPgObject.getLoginBtn());
			waitElementPresents(homePgObject.getHamBurgerMenu(), 10);
			screenshot(homePgObject.getSignedInUser());
			String signedInUserName = getElementText(homePgObject.getSignedInUser());
			String userName = credentials.get("UserName");
			userName = userName.substring(0,userName.indexOf("@"));
			assertEquals(signedInUserName, userName,"Username in dashboard is not matching with the user logged in");
			click(loginPgObject.getHamBurgerMenu());
		}catch(Exception e) {

			e.printStackTrace();
		}
	}

	public void dashboardValidations() {
		try {

			addLeadPgObject = PageFactory.initElements(driver, AddLeadPageObject.class);
			scrollDownByJS(homePgObject.getSalesToolsBtn());
			click(homePgObject.getSalesToolsBtn(),10);
			click(homePgObject.getBuildProposalBtn(),10);
			assertEquals(homePgObject.getCreateLeadHeaderText(), uiTexts.get("CREATE_LEAD_HEADING"), "Create lead header is not matching as expected");
			assertEquals(homePgObject.getSelectLeadHeaderText(), uiTexts.get("SELECT_LEAD_HEADING"), "Select lead header is not matching as expected");

			assertEquals(getElementText(homePgObject.getCreateLeadBtn()), uiTexts.get("CREATE_LEAD_BTN_TEXT"), "Create lead button  text is not matching as expected");
			assertEquals(getElementText(homePgObject.getSelectLeadBtn()), uiTexts.get("SELECT_LEAD_BTN_TEXT"), "Select lead button  text is not matching as expected");
			Thread.sleep(2000);
			waitElementClickable(homePgObject.getSelectLeadBtn(),10);
			moveToElementNClick(homePgObject.getSelectLeadBtn());

			waitElementClickable(addLeadPgObject.getAddLeadBtn(), 10);
			click(addLeadPgObject.getAddLeadBtn(),10);
			waitElementClickable(addLeadPgObject.getFirstNameFld(), 10);
			scrollDownByJS(addLeadPgObject.getFirstNameFld());
			assertTrue(addLeadPgObject.getFirstNameFld().isDisplayed(),"Add lead button is not navigated to AddLead Page");
			fillTextBox(addLeadPgObject.getFirstNameFld(),excelData.get("FirstName"));
			fillTextBox(addLeadPgObject.getLastNameFld(),excelData.get("LastName"));
			fillTextBox(addLeadPgObject.getEmailFld(),excelData.get("Email"));
			fillTextBox(addLeadPgObject.getPhoneNumberFld(),excelData.get("PhoneNumber"));

			assertEquals(getAttribute(addLeadPgObject.getFirstNameFld(), "value"), excelData.get("FirstName"), "First name field is not filled with correct value from excel");
			assertEquals(getAttribute(addLeadPgObject.getLastNameFld(), "value"), excelData.get("LastName"), "Last name field is not filled with correct value from excel");
			assertEquals(getAttribute(addLeadPgObject.getEmailFld(), "value"), excelData.get("Email"), "Email field is not filled with correct value from excel");
			assertEquals(getAttribute(addLeadPgObject.getPhoneNumberFld(), "value"), excelData.get("PhoneNumber"), "Phone number field is not filled with correct value from excel");

			scrollDownByJS(addLeadPgObject.getCalComponent());
			parseDateMonthYear("MMMMM", excelData.get("SchedulingRequestDate"));
			String month = formattedDate;
			System.out.println("Parsed month "+month);
			parseDateMonthYear("dd", excelData.get("SchedulingRequestDate"));
			String date = formattedDate;
			System.out.println("Parsed date "+date);
			parseDateMonthYear("YYYY", excelData.get("SchedulingRequestDate"));
			String year = formattedDate;
			System.out.println("Parsed year "+year);

			click(addLeadPgObject.getCalComponent(),10);
			int monthsInAYear = 12;
			for (int i = 0; i < monthsInAYear; i++) {

				if (!month.equals(getElementText(addLeadPgObject.getMonthInCalendar()))) {

					click(addLeadPgObject.getCaledarNextNavButton(),20);
					click(addLeadPgObject.getMonthInCalendar(),10);
				}
				else {

					break;
				}

			}

			click(driver.findElement(By.xpath(addLeadPgObject.selectDateXpath(date))));

			assertEquals(getElementText(addLeadPgObject.getCalComponent()),excelData.get("SchedulingRequestDate"),
					"Date is not selected as expected");

			scrollDownByJS(addLeadPgObject.getAddDocumentBtn());
			click(addLeadPgObject.getAddDocumentBtn(),10);

			dropDownByValue(addLeadPgObject.getDocumentDropDown(), "OTHER");

			fillTextBox(addLeadPgObject.getUploadDocument(), excelData.get("AddDocument"));
			click(addLeadPgObject.getAddDocToLeadBtn(),10);

			fillTextBox(addLeadPgObject.getUploadImage(), excelData.get("AddImage"));

			scrollDownByJS(addLeadPgObject.getSaveLeadBtn());
			click(addLeadPgObject.getSaveLeadBtn(),20);

			waitElementPresents(addLeadPgObject.getSuccessMessage(), 20);

			assertTrue(getElementText(addLeadPgObject.getSuccessMessage()).contains("Lead Saved Successfully"), "Lead is not saved successfully");

		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifySavedLead() {




	}

	public void parseDateMonthYear(String expectedFormat, String dateToBeParsed) {
		try {
			SimpleDateFormat selectedDateFormat = new SimpleDateFormat(expectedFormat, Locale.ENGLISH);
			SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
			Date formattedPreferredDate = parser.parse(dateToBeParsed);
			formattedDate = selectedDateFormat.format(formattedPreferredDate);
		}
		catch (Exception e) {

			e.printStackTrace();

		}
	}

}