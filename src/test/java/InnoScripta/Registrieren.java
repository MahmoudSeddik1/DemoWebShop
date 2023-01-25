package InnoScripta;

import basetests.BaseTests;
import org.testng.annotations.Test;

public class Registrieren extends BaseTests {
    @Test
    public void testRegistrieren(){
       var anmeldenPage= innoHomepage.clickAnmeldenNewTab();
       getWindowManager().SwitchToTab("IMS");
    }
}
