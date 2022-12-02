import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class LoginPageTests {

    WebDriver chromeDriver = new ChromeDriver();

    @Test
    void userCanSignUp() throws IOException, InterruptedException {
        chromeDriver.get("http://localhost:3000/");
        WebElement emailInput = chromeDriver.findElement(By.name("email"));
        WebElement passwordInput = chromeDriver.findElement(By.name("password"));

        emailInput.sendKeys("selenium@test.com");
        passwordInput.sendKeys("X5#$Y3hRzkH1");

        WebElement signUpButton = chromeDriver.findElement(By.name("signup"));

        signUpButton.click();
        TimeUnit.SECONDS.sleep(5);
        WebElement infoMessage = chromeDriver.findElement(By.name("info-message"));
        Assertions.assertEquals("You are signed up", infoMessage.getText());
    }

    @Test
    void userCanLogin() throws IOException, InterruptedException {
        chromeDriver.get("http://localhost:3000/");
        WebElement emailInput = chromeDriver.findElement(By.name("email"));
        WebElement passwordInput = chromeDriver.findElement(By.name("password"));

        emailInput.sendKeys("selenium@test.com");
        passwordInput.sendKeys("X5#$Y3hRzkH1");

        WebElement loginButton = chromeDriver.findElement(By.name("login"));

        Assertions.assertTrue(loginButton.isEnabled());
    }

    @Test
    void weakPasswordCannotSignUp() throws IOException, InterruptedException {
        chromeDriver.get("http://localhost:3000/");
        WebElement emailInput = chromeDriver.findElement(By.name("email"));
        WebElement passwordInput = chromeDriver.findElement(By.name("password"));

        emailInput.sendKeys("seleniumWeakPassword@test.com");
        passwordInput.sendKeys("weakpassword");

        WebElement signUpButton = chromeDriver.findElement(By.name("signup"));

        signUpButton.click();
        TimeUnit.SECONDS.sleep(5);
        WebElement infoMessage = chromeDriver.findElement(By.name("info-message"));
        Assertions.assertEquals("Too weak of a password, try another", infoMessage.getText());
    }
}
