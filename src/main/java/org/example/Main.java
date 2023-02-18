package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Set the path of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Apps/chrome_110/chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to the link
        driver.get("https://demowebshop.tricentis.com/");

        // login
        String username = "xxxx";
        String password = "xxxx";

        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        Thread.sleep(2000);
        WebElement emailTextBox = driver.findElement(By.id("Email"));
        emailTextBox.sendKeys(username);

        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        //-Search for product--laptop
        Thread.sleep(500);
        WebElement searchBox = driver.findElement(By.id("small-searchterms"));
        searchBox.sendKeys("laptop");
        searchBox.sendKeys(Keys.ENTER);

        // -Click on laptop change quantity to "2"
        Thread.sleep(500);
        WebElement laptopLinkParent = driver.findElement(By.className("product-item"));
        WebElement laptopLink = laptopLinkParent.findElement(By.tagName("a"));
        laptopLink.click();

        WebElement qtyTextBox = driver.findElement(By.id("addtocart_31_EnteredQuantity"));
        qtyTextBox.sendKeys(Keys.BACK_SPACE);
        qtyTextBox.sendKeys("2");

        // click on Add to Cart
        Thread.sleep(200);
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button-31"));
        addToCartButton.click();

        // -Mouse over on shopping cart //
        Thread.sleep(200);
        WebElement cartLink = driver.findElement(By.className("ico-cart"));
        cartLink.click();

        // -Click on "Check out"
        Thread.sleep(500);
        WebElement agreeRadioButton = driver.findElement(By.id("termsofservice"));
        agreeRadioButton.click();

        Thread.sleep(200);
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        // -Select Billing address-->click continue
        String firstname = "Selena";
        String lastname = "Salut";
        int country = 1;
        String city = "Seatle";
        String address1 = "No 25 John ave. ";
        String zip = "55442";
        String phone = "10101010";

        Thread.sleep(5000);
        try {
            WebElement fnameBox = driver.findElement(By.id("BillingNewAddress_FirstName"));
            fnameBox.sendKeys(firstname);

            WebElement lnameBox = driver.findElement(By.id("BillingNewAddress_LastName"));
            lnameBox.sendKeys(lastname);

            WebElement dropDownList = driver.findElement(By.id("BillingNewAddress_CountryId"));
            Select select = new Select(dropDownList);
            select.selectByIndex(country);

            WebElement cityBox = driver.findElement(By.id("BillingNewAddress_City"));
            cityBox.sendKeys(city);

            WebElement addBox1 = driver.findElement(By.id("BillingNewAddress_Address1"));
            addBox1.sendKeys(address1);

            WebElement zipBox = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            zipBox.sendKeys(zip);

            WebElement phoneBox = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
            phoneBox.sendKeys(phone);
        }catch (Exception ignored){

        }

        Thread.sleep(2000);
        List<WebElement> continueButtons = driver.findElements(By.className("new-address-next-step-button"));
        continueButtons.get(0).click();

        // Shipping address
        Thread.sleep(2000);
        continueButtons.get(1).click();

        // -Select Shipping Method---> click continue
        Thread.sleep(500);
        WebElement shippingMethodRadioButton = driver.findElement(By.id("shippingoption_0"));
        shippingMethodRadioButton.click();

        Thread.sleep(500);
        WebElement continueButton2 = driver.findElement(By.className("shipping-method-next-step-button"));
        continueButton2.click();

        // -Select Payment Method--> Cash on Delivery
        Thread.sleep(500);
        WebElement paymentRadioButton = driver.findElement(By.id("paymentmethod_0"));
        paymentRadioButton.click();

        //-Payment information--->Click on continue
        Thread.sleep(500);
        WebElement continueButton3 = driver.findElement(By.className("payment-method-next-step-button"));
        continueButton3.click();
        Thread.sleep(500);
        WebElement continueButton4 = driver.findElement(By.className("payment-info-next-step-button"));
        continueButton4.click();


        // -Confirm Order--->Confirm
        Thread.sleep(500);
        WebElement confirmButton = driver.findElement(By.className("confirm-order-next-step-button"));
        confirmButton.click();

        // -It should display "Your order has been successfully processed"
        Thread.sleep(500);
        WebElement messageBox = driver.findElement(By.className("order-completed"));
        String message = messageBox.findElement(By.tagName("strong")).getText();
        System.out.println("Message: " + message);

        // -It should display order number
        String orderNumber = messageBox.findElements(By.tagName("li")).get(0).getText();
        System.out.println(orderNumber);

//         Close the browser
//        driver.quit();
    }
}