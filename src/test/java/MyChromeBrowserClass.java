import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import static org.openqa.selenium.chrome.ChromeOptions.CAPABILITY;

public class MyChromeBrowserClass implements WebDriverProvider {

    @SuppressWarnings("deprecation")
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        ChromeDriverManager.getInstance(CHROME).setup();
        capabilities.setCapability(CAPABILITY, getChromeOptions());

        return new ChromeDriver(capabilities);
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("user-data-dir=./src/test/profiles/chrome/testProfile/");
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("disable-popup-blocking", "true");

        chromeOptions.addArguments("disable-infobars");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);

        return chromeOptions;
    }

}
