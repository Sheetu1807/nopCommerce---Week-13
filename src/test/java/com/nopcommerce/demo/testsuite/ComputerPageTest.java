package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class ComputerPageTest extends TestBase {

    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        computerPage=new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        homePage.clickOnComputers();
        String expectedComputerText= "Computers";
        Assert.assertEquals(expectedComputerText, homePage.VerifyComputersText());
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.clickOnComputers();
        computerPage.ClickonDesktop();
        String expectedDesktopLink ="Desktops";
        Assert.assertEquals(expectedDesktopLink, computerPage.VerifyDesktoplink());
    }

    @Test(dataProvider = "BuildComputer", dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software){
        homePage.clickOnComputers();
        computerPage.ClickonDesktop();
        buildYourOwnComputerPage.ClickonProduct();
        buildYourOwnComputerPage.BuildApplication(processor, ram, hdd, os, software);
        buildYourOwnComputerPage.ClickonAddToCart();
        String ExpectValidationmsg="The product has been added to your shopping cart";
        Assert.assertEquals(ExpectValidationmsg, buildYourOwnComputerPage.VerifyValidationMsg());
    }
}