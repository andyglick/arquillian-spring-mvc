package com.ex;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringConfiguration;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.warp.Activity;
import org.jboss.arquillian.warp.Inspection;
import org.jboss.arquillian.warp.Warp;
import org.jboss.arquillian.warp.WarpTest;

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
@WarpTest
@RunAsClient
public class ArquillianWarpTest {

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

    @Test
    public void testDummy() {

    }

    // @Test
    @Ignore
    public void shouldLogIn() throws Exception {

        Warp.initiate(new Activity() {

            @Override
            public void perform() {
                loginInput.sendKeys("admin");
                pwdInput.sendKeys("test");
                submitBtn.submit();
            }
        }).inspect(new Inspection() {
            private static final long serialVersionUid = 1L;
        });

    }
}
