package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyListenerClass implements WebDriverListener {
    @Override
    public void beforeClick(WebElement element) {
        if (element.getText().equals("")) {
            System.out.println("Clicking on " + element.getText() + "#Name!");
        } else{
            System.out.println("Clicking on " + element.getText());
        }
    }

    @Override
    public void afterBack(WebDriver.Navigation navigation) {
        System.out.println("Navigation button back is clicked successfully");
    }

    @Override
    public void afterQuit(WebDriver driver) {
        System.out.println("Quitting");
    }


//    @Override
//    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
//        System.out.println("On method "+method+", Exception " + "'" + e +"'" + " was found!" );
//    }

}
