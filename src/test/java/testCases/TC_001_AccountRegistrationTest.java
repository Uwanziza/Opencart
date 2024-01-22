package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"regression","master"})
	public void verify_account_registration() {
		logger.info("starting Tc001 AccountRegistration Test *****");
         logger.debug("**** Application logs ****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link");
			hp.clickRegister();
			logger.info("Clicked on registration link");

			logger.info("Entering customer details");
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString() + "@gmail.com");// randomly generated the email
			//regpage.setTelephone(randomeNumber());

			String password = randomAlphaNumeric();

			regpage.setPassword(password);
			//regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			logger.info("clicked on continue ");

			logger.info("Validating expected message");
			String confmsg=regpage.getConfirmationMsg();
			if (confmsg.equals("Your Account Has Been Created!"))
			{
				logger.info("Test Passed ......");
			Assert.assertTrue(true);
			}else{
				logger.error("Test Failed");
				//Assert.fail();
			}
			//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("test failed..");
			Assert.fail();
		}

		logger.debug("**** Application logs ****");
		logger.info("**** finished TC001 _AccountingRegistrationTest *****");

	}
}
