package PersonalTab.BankingList;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Savings extends CommonAPI {

    Wait wait = new FluentWait(driver);

    @FindBy(how = How.ID, using = "compare-accounts-large")
    WebElement Compare_Accounts_Button;

    @FindBy(how = How.ID, using = "regularSavingsAccountLink")
    WebElement Regular_Savings_Account_Button;

    @FindBy(how = How.ID, using = "rewardsMmsAccountLink")
    WebElement Rewards_Money_Market_Savings_Account_Button;

    @FindBy(how = How.ID, using = "rb-savings-regular-account")
    WebElement Regular_Savings_Box;

    @FindBy(how = How.ID, using = "rb-mms-account")
    WebElement Upgrade_To_Rewards_Box;

    @FindBy(how = How.ID, using = "go-to-application-mediumup")
    WebElement Go_To_Application_Button;

    private void Compare_Accounts() throws InterruptedException {
        Compare_Accounts_Button.click();
        Thread.sleep(2000);
    }

    private void If_Statement_Check_Box(String checkBox) {

        if(checkBox.contains("Regular")) {
            Regular_Savings_Box.click();
        } else if (checkBox.contains("Rewards")) {
            Upgrade_To_Rewards_Box.click();
        } else {
            System.err.println("ERROR: Please Choose Valid Check Box");
        }
    }

    public void Core_Checking(String checkBox) throws InterruptedException {
        Compare_Accounts();
        Regular_Savings_Account_Button.click();
        If_Statement_Check_Box(checkBox);
        Thread.sleep(2000);
        Go_To_Application_Button.click();
        Thread.sleep(5000);
    }

    public void Interest_Checking(String checkBox) throws InterruptedException {
        Compare_Accounts();
        Rewards_Money_Market_Savings_Account_Button.click();
        If_Statement_Check_Box(checkBox);
        Thread.sleep(2000);
        Go_To_Application_Button.click();
        Thread.sleep(5000);
    }
}
