package com.lennox.pageobject.proposal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.lennox.base.Utility;

public class HomePagePageObject extends Utility {

public HomePagePageObject() {

PageFactory.initElements(driver, this);

}



@FindBy(how = How.XPATH, using = "//*[@class='far fa-bars v2-hamburger-menu']")
private WebElement hamBurgerMenu;

@FindBy(how = How.XPATH, using = "//*[text()='Sales Tools']")
private WebElement salesToolsBtn;

@FindBy(how = How.XPATH, using = "//*[text()='Build a Proposal']")
private WebElement buildProposalBtn;

@FindBy(how = How.XPATH, using = "//*[@class='signedin-user']")
private WebElement signedInUser;

@FindBy(how = How.XPATH, using ="//div[@class='button-set']//a[text()='SELECT LEAD']")
private WebElement selectLeadBtn;

@FindBy(how = How.XPATH, using ="//div[@class='button-set']//*[text()='CREATE LEAD & PROPOSAL']")
private WebElement createLeadBtn;

@FindBy(how = How.XPATH, using ="//*[@class='moby-inner']//a[@class='close']")
private WebElement closeBtnInLeadPop;

@FindBy(how = How.XPATH, using ="//*[@class='lead-select-left lead-select-inn']//h5")
private WebElement createLeadHeaderText;

@FindBy(how = How.XPATH, using ="//*[@class='lead-select-right lead-select-inn']//h5")
private WebElement selectLeadHeaderText;


public WebElement getHamBurgerMenu() {
return hamBurgerMenu;
}

public WebElement getSalesToolsBtn() {
return salesToolsBtn;
}

public WebElement getBuildProposalBtn() {
return buildProposalBtn;
}

public WebElement getSignedInUser() {
return signedInUser;
}

public WebElement getCloseBtnInLeadPop() {
return closeBtnInLeadPop;
}

public WebElement getCreateLeadHeaderText() {

return createLeadHeaderText;
}

public WebElement getSelectLeadHeaderText() {

return selectLeadHeaderText;
}

public WebElement getSelectLeadBtn() {
return selectLeadBtn;
}

public WebElement getCreateLeadBtn() {

return createLeadBtn;
}



}