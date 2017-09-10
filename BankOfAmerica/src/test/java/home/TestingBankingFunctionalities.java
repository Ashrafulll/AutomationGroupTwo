package home;

import PersonalTab.BankingList.Checking;
import base.CommonAPI;
import PersonalTab.BankingList.Banking;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestingBankingFunctionalities extends CommonAPI {

    @Test
    public void Test_Checking() throws InterruptedException {
        Banking banking = PageFactory.initElements(driver, Banking.class);
        Checking checking = PageFactory.initElements(driver, Checking.class);
        banking.Checking();
        checking.Core_Checking("Regular");
    }
}
