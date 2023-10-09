package suport;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunBase;
import java.time.Duration;
import java.util.Random;

public class Utility extends RunBase {

    public static void located(By locator, Duration seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static String getRandomEmail(){
        String email_start = "test+";
        String email_end = "@test.com";

        Random random = new Random();

        int low = 1;
        int high = 9999999;
        int result = random.nextInt(high-low) + low;

        return email_start + result + email_end;
    }

    public static String getRandomPassword(){
        return RandomStringUtils.randomAlphanumeric(15);
    }

    public static String getRandomNumber(){
        return RandomStringUtils.randomNumeric(8);
    }

    public static void clickButton(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static class name {
        private static Random random = new Random();
        private static String[] fNames = { "Amelia", "Olivia", "Emily", "Ava", "Isla", "Jessica", "Poppy", "Isabella",
                "Sophie", "Mia", "Ruby", "Lily", "Grace", "Evie", "Sophia", "Ella", "Scarlett", "Chloe", "Isabelle",
                "Freya", "Charlotte", "Sienna", "Daisy", "Phoebe", "Millie", "Eva", "Alice", "Lucy", "Florence",
                "Sofia", "Layla", "Lola", "Holly", "Imogen", "Molly", "Matilda", "Lilly", "Rosie", "Elizabeth", "Erin",
                "Maisie", "Lexi", "Ellie", "Hannah", "Evelyn", "Abigail", "Elsie", "Summer", "Megan", "Jasmine", "Maya",
                "Amelie", "Lacey", "Willow", "Emma", "Bella", "Eleanor", "Esme", "Eliza", "Georgia", "Harriet",
                "Gracie", "Annabelle", "Emilia", "Amber", "Ivy", "Brooke", "Rose", "Anna", "Zara", "Leah", "Mollie",
                "Martha", "Faith", "Hollie", "Amy", "Bethany", "Violet" };
        private static String[] lNames = { " Smith", " Johnson", " Williams", " Brown", " Jones", " Garcia",
                " Miller", " Davis", " Rodriguez", " Martinez", " Hernandez", " Lopez" };

        public static String getRandomName() {
            return fNames[random.nextInt(fNames.length)] + lNames[random.nextInt(lNames.length)];
        }

        public static String getRandomFirstName() {
            return fNames[random.nextInt(fNames.length)];
        }

        public static String getRandomLastName() {
            return lNames[random.nextInt(lNames.length)];
        }
    }

    public static class email {
        private static Random random = new Random();
        private static String[] emails = { "test+1@test.com", "test+2@test.com", "test+3@test.com",
                "test+4@test.com", "test+5@test.com", "test+6@test.com", "test+7@test.com",
                "test+8@test.com", "test+9@test.com", "test+10@test.com"
        };

        public static String getEmail() {
            return emails[random.nextInt(emails.length)];
        }
    }


}
