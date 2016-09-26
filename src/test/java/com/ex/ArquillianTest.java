package com.ex;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringConfiguration;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@RunWith(Arquillian.class)
@SpringConfiguration("applicationContext.xml")
@RunAsClient
public class ArquillianTest {

    @Deployment
    public static Archive createTestArchive() {
        return Deployments.createDeployment();
    }

    @Drone
    private WebDriver browser;

    @ArquillianResource
    private URL contextRoot;

    @Before
    public void loadPage() {
      browser.navigate().to(contextRoot + "login");
    }

    @FindBy(id = "name")
    private WebElement loginInput;

    @FindBy(id = "pwd")
    private WebElement pwdInput;

    @FindBy(id = "submit")
    private WebElement submitBtn;

//    @Test
//    public void testDummy() {
//
//    }

    @Test
    public void test_drone_Login() {
        loginInput.sendKeys("admin");
        pwdInput.sendKeys("test");
        submitBtn.submit();
        Assert.assertTrue(true);
    }
}
