package fr.bulleux.jpa_test;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

public class SwitchTest {

    @Ignore
    @Test
    void newSwitch(){
        String test = "4";
        switch (test){
            case "4" : System.out.println(test);
            break;
        }
    }
}
