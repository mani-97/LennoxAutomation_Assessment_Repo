package com.lennox.pageobject.proposal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.lennox.base.Utility;

public class LoginPageObject extends Utility {

public LoginPageObject() {

PageFactory.initElements(driver, this);

}


@FindBy(how = How.XPATH, using = "//*[text()='Sign In']")
private WebElement signInBtn;

@FindBy(how = How.XPATH, using = "//h1[text()='Sign In']")
private WebElement signInFieldText;

@FindBy(how = How.XPATH, using = "//input[@id='j_username']")
private WebElement userNameFld;

@FindBy(how = How.XPATH, using = "//input[@id='j_password']")
private WebElement passwordFld;

@FindBy(how = How.XPATH, using = "//button[@id='loginSubmit']")
private WebElement loginBtn;

@FindBy(how = How.XPATH, using = "//*[@class='far fa-bars v2-hamburger-menu']")
private WebElement hamBurgerMenu;

@FindBy(how = How.XPATH, using = "//*[text()='Sales Tools']")
private WebElement salesToolsBtn;

@FindBy(how = How.XPATH, using = "//*[text()='Build a Proposal']")
private WebElement buildProposalBtn;

public WebElement getSignInBtn() {
return signInBtn;
}

public WebElement getSignInFieldText() {
return signInFieldText;
}

public WebElement getUserNameFld() {
return userNameFld;
}

public WebElement getPasswordFld() {
return passwordFld;
}

public WebElement getLoginBtn() {
return loginBtn;
}

public WebElement getHamBurgerMenu() {
return hamBurgerMenu;
}

public WebElement getSalesToolsBtn() {
return salesToolsBtn;
}

public WebElement getBuildProposalBtn() {
return buildProposalBtn;
}


}