package assertions;

import org.assertj.core.api.SoftAssertions;

public class BaseAssertions {

    protected final SoftAssertions softAssertions;

    public BaseAssertions(){
        softAssertions = new SoftAssertions();
    }

    public void assertAll(){
        softAssertions.assertAll();
    }
}
