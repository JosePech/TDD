package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MoveFromDeckToWasteControllerTest.class, MoveFromTableauPileToFoundationTest.class,
        MoveFromWasteToFoundationControllerTest.class, StartGameControllerTest.class})
public class AllTests {

}
