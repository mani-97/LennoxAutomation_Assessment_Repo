package org.lennox.testcase.proposal;

import org.lennox.functions.BuildProposalValidations;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lennox.base.Utility;

public class CreateProposal extends Utility {

	public BuildProposalValidations common = new BuildProposalValidations();

	@BeforeClass
	public void startTest() {

		testDataRead(credentialsFilePath);
		testDataRead(testFilePath);
		testDataRead(UITexts);
		openChrome();
		navigateToPage(credentials.get("URL"));
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), uiTexts.get("PAGE_TITLE"), "Page title is not matching, page not loaded as expected");
		
	}

	@Test
	public void buildProposalFlow() throws InterruptedException {

		common.loginAndVerify();
		common.dashboardValidations();

	}

	@AfterClass
	public void closeTest() {

		closeBrowser();

	}

}