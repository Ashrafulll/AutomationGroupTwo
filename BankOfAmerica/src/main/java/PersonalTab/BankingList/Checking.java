package PersonalTab.BankingList;

import base.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Checking extends CommonAPI {

    public static JavascriptExecutor js = ((JavascriptExecutor) driver);

    @FindBy(how = How.ID, using = "compare-accounts-large")
    WebElement Compare_Accounts_Button;

    @FindBy(how = How.ID, using = "interestCheckingAccountLink")
    WebElement Interest_Checking_Account_Button;

    @FindBy(how = How.ID, using = "coreCheckingAccountLink")
    WebElement Core_Checking_Account_Button;

    //// Common Elements for Core and Interest Checking ////
    @FindBy(how = How.ID, using = "rb-savings-regular-account")
    WebElement Regular_Savings_Account_Box;

    @FindBy(how = How.ID, using = "rb-savings-rewards-account")
    WebElement Rewards_Savings_Account_Box;

    @FindBy(how = How.ID, using = "rb-savings-account-none")
    WebElement Checking_Savings_Account_Box;

    @FindBy(how = How.ID, using = "go-to-application-mediumup")
    WebElement Go_To_Application_Button;

    private void Compare_Accounts() throws InterruptedException {
        Compare_Accounts_Button.click();
        Thread.sleep(2000);
    }

    private void If_Statement_Check_Box(String checkBox) {

        if(checkBox.contains("Regular")) {
            Regular_Savings_Account_Box.click();
        } else if (checkBox.contains("Rewards")) {
            Rewards_Savings_Account_Box.click();
        } else if (checkBox.contains("checking")) {
            Checking_Savings_Account_Box.click();
        } else {
            System.err.println("ERROR: Please Choose Valid Check Box");
        }
    }

    public void Core_Checking(String checkBox) throws InterruptedException {
        Compare_Accounts();
        Core_Checking_Account_Button.click();
        If_Statement_Check_Box(checkBox);
        Thread.sleep(2000);
        // Scrolling down: js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Go_To_Application_Button.click();
        Thread.sleep(5000);
    }

    public void Interest_Checking(String checkBox) throws InterruptedException {
        Compare_Accounts();
        Interest_Checking_Account_Button.click();
        If_Statement_Check_Box(checkBox);
        Thread.sleep(2000);
        Go_To_Application_Button.click();
        Thread.sleep(5000);
    }
}
