package tests.login;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Login.LOGIN_PASSWORD;
import static constants.Constants.Login.LOGIN_USERNAME;
import static constants.Constants.Urls.HOME_PAGE;
import static constants.Constants.Urls.MY_ACCOUNT_PAGE;

public class LoginValidUsernameAndPassword extends BaseTest {

  @Test
  public void ShouldLogin() {
    basePage.open(HOME_PAGE);

    homePage.clickMyAccount();

    loginPage.typeUsername(LOGIN_USERNAME)
      .typePassword(LOGIN_PASSWORD)
      .clickLogin();

    myAccountPage.verifyMyAccountUrl(MY_ACCOUNT_PAGE);
  }
}
