package com.lennox.pageobject.proposal;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.lennox.base.Utility;

public class AddLeadPageObject extends Utility {

	public AddLeadPageObject() {

		PageFactory.initElements(driver, this);

	}


	@FindBy(how = How.XPATH, using = "(//*[text()='ADD LEAD'])[2]")
	private WebElement addLeadBtn;

	@FindBy(how = How.ID, using = "firstName")
	private WebElement firstNameFld;

	@FindBy(how = How.ID, using = "lastName")
	private WebElement lastNameFld;

	@FindBy(how = How.ID, using = "phNo")
	private WebElement phoneNumberFld;

	@FindBy(how = How.ID, using = "email")
	private WebElement emailFld;

	@FindBy(how = How.ID, using = "calender1")
	private WebElement calComponent;

	@FindBy(how = How.XPATH, using = "//*[@class='ui-datepicker-title']")
	private WebElement calTitle;

	@FindBy(how = How.XPATH, using = "//table[@class='ui-datepicker-calendar']")
	private WebElement calTable;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary add-edit-leads-submit create-proposal proposal-created btn-proposal']")
	private WebElement buildProposalBtn;

	@FindBy(how = How.ID,using = "multipleFileSelect-1")
	private WebElement uploadDocument;

	@FindBy(how = How.ID,using = "multipleImageSelect[0]")
	private WebElement uploadImage;

	@FindBy(how = How.XPATH,using = "//*[@name='documents[1].documentType']")
	private WebElement documentDropDown;

	@FindBy(how = How.XPATH,using = "(//div[@class='leads-uploads-add'])[1]")
	private WebElement addDocumentBtn;

	@FindBy(how=How.XPATH,using = "//*[@class='ui-datepicker-next ui-corner-all']")
	private WebElement calendarNextNavButton;

	@FindBy(how=How.XPATH,using = "//*[@class='ui-datepicker-month']")
	private WebElement monthInCalendar;

	@FindBy(how=How.XPATH,using="//a[@class='btn btn-primary mr-15 add-documents-to-page mb-15']")
	private WebElement addDocToLeadBtn;

	@FindBy(how=How.XPATH,using="//*[@class='ui-datepicker-year']")
	private WebElement yearInCalendar;

	@FindBy(how=How.XPATH,using="lead-details-header-name stronger")
	private WebElement createdLeadHeader;

	@FindBy(how=How.ID,using="btn-addLeadsForm")
	private WebElement saveLeadBtn;

	@FindBy(how=How.XPATH,using="(//*[@class='success-msg'])[2]")
	private WebElement successMessage;

	public WebElement getSuccessMessage() {

		return successMessage;
	}

	public WebElement getSaveLeadBtn() {

		return saveLeadBtn;
	}

	public WebElement getAddDocumentBtn() {

		return addDocumentBtn;
	}


	public WebElement getDocumentDropDown() {

		return documentDropDown;
	}

	public WebElement getAddLeadBtn() {
		return addLeadBtn;
	}

	public WebElement getFirstNameFld() {
		return firstNameFld;
	}

	public WebElement getLastNameFld() {
		return lastNameFld;
	}

	public WebElement getPhoneNumberFld() {
		return phoneNumberFld;
	}

	public WebElement getEmailFld() {
		return emailFld;
	}

	public WebElement getCalComponent() {
		return calComponent;
	}

	public WebElement getCalTitle() {
		return calTitle;
	}

	public WebElement getCalTable() {
		return calTable;
	}

	public WebElement getBuildProposalBtn() {
		return buildProposalBtn;
	}

	public WebElement getUploadDocument() {

		return uploadDocument;
	}

	public WebElement getUploadImage() {

		return uploadImage;
	}

	public WebElement getAddDocToLeadBtn() {

		return addDocToLeadBtn;
	}

	public WebElement getCaledarNextNavButton() {

		return calendarNextNavButton;
	}

	public WebElement getMonthInCalendar() {

		return monthInCalendar;
	}

	public WebElement getYearInCalendar() {

		return yearInCalendar;
	}

	public String selectDateXpath(String date) {

		String xpath = "//a[text()='"+date+"']";

		return xpath;
	}

	public WebElement getCreatedLeadHeader() {

		return createdLeadHeader;
	}

}