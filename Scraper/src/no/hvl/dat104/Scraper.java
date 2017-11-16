package no.hvl.dat104;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Peder on 15.11.2017.
 */
public class Scraper {
    public static void main(String[] args) {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        String url = "https://idp.feide.no/simplesaml/module.php/feide/login.php?asLen=196&AuthState=_9fca4163f7ea1def117e4e14f389d3a338a30db096%3Ahttps%3A%2F%2Fidp.feide.no%2Fsimplesaml%2Fsaml2%2Fidp%2FSSOService.php%3Fspentityid%3Durn%253Amace%253Afeide.no%253Aservices%253Ase.timeedit.hib%26cookieTime%3D1510783130%26RelayState%3D";
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
      /*  WebDriver driver = new HtmlUnitDriver();*/
      //https://idp.feide.no/simplesaml/module.php/feide/login.php?asLen=196&AuthState=_9fca4163f7ea1def117e4e14f389d3a338a30db096%3Ahttps%3A%2F%2Fidp.feide.no%2Fsimplesaml%2Fsaml2%2Fidp%2FSSOService.php%3Fspentityid%3Durn%253Amace%253Afeide.no%253Aservices%253Ase.timeedit.hib%26cookieTime%3D1510783130%26RelayState%3D"
        //driver.get("https://idp.feide.no/simplesaml/module.php/feide/login.php?asLen=196&AuthState=_9fca4163f7ea1def117e4e14f389d3a338a30db096%3Ahttps%3A%2F%2Fidp.feide.no%2Fsimplesaml%2Fsaml2%2Fidp%2FSSOService.php%3Fspentityid%3Durn%253Amace%253Afeide.no%253Aservices%253Ase.timeedit.hib%26cookieTime%3D1510783130%26RelayState%3D");

        Cookie cookie = new Cookie("SimpleSAMLAuthToken", "_9287d4df126a74cce8048b2a5e89e228275db1c353");
        Cookie cookie2 = new Cookie("org_feide", "3Ahib");
        driver.manage().addCookie(cookie);
        // And now use this to visit Google
        Set<Cookie> allCookies = driver.manage().getCookies();
// And now output all the available cookies for the current URL

        // Find the text input element by its name
        //WebElement element = driver.findElement(By.name("username"));
        WebElement submit = driver.findElement(By.className("submit"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement pw = driver.findElement(By.id("password"));
        WebElement js = driver.findElement(By.id("input_has_js"));

        username.sendKeys(System.getenv("FEIDE_B"));
        pw.sendKeys(System.getenv("FEIDE_P"));
        // Enter something to search for
        //element.sendKeys("Cheese!");
        // Now submit the form. WebDriver will find the form for us from the element
        submit.submit();
        driver.navigate().to("https://no.timeedit.net/web/hib/db1/student/ri1Q54.html");
        try {
            readCSVInternett();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        //System.out.println(driver.getPageSource());

        //driver.quit();
    }
    public static void readCSVInternett() throws FileNotFoundException, IOException {
        String URL = "https://no.timeedit.net/web/hib/db1/student/ri1Q54.csv";
        if(URL.contains("html")) {
            URL = URL.replace("html", "csv");
            System.out.println(URL);
        }
        System.out.println("ok");
        java.net.URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection.getResponseCode() == 200) {
            System.out.println("ok");
            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(streamReader);
            String line = br.readLine();
            line = br.readLine() + br.readLine() + br.readLine();
            String[] fieldsene = line.split(",");
            fieldsene = Arrays.copyOfRange(fieldsene, 3, fieldsene.length);
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                fieldsene = line.split(",");
                String dato = fieldsene[0].substring(0);
                String tidFra = fieldsene[1].substring(1);
                String tidTil = fieldsene[3].substring(1);
                String aktivitet = fieldsene[6].substring(1);
                String navn = fieldsene[8].substring(1);
                String beskrivelse = fieldsene[10].substring(1);
                String sted = fieldsene[9].substring(1);
                System.out.println(Arrays.toString(fieldsene));

            }
            br.close();
        }
    }
}
