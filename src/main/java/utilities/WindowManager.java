package utilities;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBackward(){
        navigate.back();
    }
    public void goForward(){
        navigate.forward();
    }
    public void Refresh(){
        navigate.refresh();
    }
    public void goTo(String URL){
        navigate.to(URL);

    }
    public void SwitchToTab(String tab){
        var Tabs = driver.getWindowHandles();
        for(String Tab:Tabs){
            driver.switchTo().window(Tab);
            if(tab == driver.getTitle()){
                break;
            }
        }


    }
}
