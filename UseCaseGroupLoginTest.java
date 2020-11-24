import junit.framework.TestCase;

public class UseCaseGroupLoginTest extends TestCase {

    public Actionwords actionwords = new Actionwords();

    public void test0100101Uid55d2c4a966664f31bf4ccaa1eafd70f7() {
    //public void test0100101Uid5ea5b9edd0f042799173d5e584abff98() {	
        // Given SetBrowswerType "Chrome"
        actionwords.setBrowswerType("Chrome");
        // And SetTargetUrl "https://swtest.aklc.net"
        actionwords.setTargetUrl("https://swtest.aklc.net");
        // When LoginStormport "west@cityparks.co.nz" "password12"
        actionwords.loginStormport("west@cityparks.co.nz", "password12");
        // Then VerifyAsUsername "west@cityparks.co.nz"
        actionwords.verifyAsUsername("west@cityparks.co.nz");
    }
    public void test0100102Uid88f7c953ee2f4659953cbcce1b347038() {
    //public void test0100102Uid35307e2a20ab4a63b24fdb9f6895192c() {
        // Given SetBrowswerType "Chrome"
        actionwords.setBrowswerType("Chrome");
        // And SetTargetUrl "https://swtest.aklc.net"
        actionwords.setTargetUrl("https://swtest.aklc.net");
        // When LoginStormport "west@cityparks.co.nz" "password123"
        actionwords.loginStormport("west@cityparks.co.nz", "password123");        
        // Then VerifyAsErrorMessage "Invalid email/password combination"
        actionwords.verifyAsErrorMessage("Invalid email/password combination????????");
        
    }
    public void test0100103Uiddc111751f3c8414d92ed267370e729a2() {
    //public void test0100103Uid8cdf5efaa3614df2a8056fb93e8ed5c4() {
        // Given SetBrowswerType "Chrome"
        actionwords.setBrowswerType("Chrome");
        // And SetTargetUrl "https://swtest.aklc.net"
        actionwords.setTargetUrl("https://swtest.aklc.net");
        // When LoginStormport "central@aklc.net" "password12"
        actionwords.loginStormport("west@cityparks.co.nz", "password12");
        // And ChangePassword "central@aklc.net" "password12" "password123"
        actionwords.changePassword("west@cityparks.co.nz", "password12", "password123");
        // And LogoutStormport
        actionwords.g1.waiting(1);
        actionwords.g1.showInfo(actionwords.getDriver(), "Now logout to test if the new password is correct...", 3);
        actionwords.logoutStormport();
         
        // And LoginStormport "central@aklc.net" "password123"
        actionwords.loginStormport("west@cityparks.co.nz", "password123");
        // Then VerifyAsUsername "central@aklc.net"
        actionwords.verifyAsUsername("west@cityparks.co.nz");
        //---------------------------------------------------------------------------
        //recover the password to "password12":

        actionwords.setBrowswerType("Chrome");
        actionwords.g1.showInfo(actionwords.getDriver(), "Now change password to the original one...", 4);
        // And SetTargetUrl "https://swtest.aklc.net"
        actionwords.setTargetUrl("https://swtest.aklc.net");
        // When LoginStormport "central@aklc.net" "password12"
        actionwords.loginStormport("west@cityparks.co.nz", "password123");
        // And ChangePassword "central@aklc.net" "password12" "password123"
        actionwords.changePassword("west@cityparks.co.nz", "password123", "password12");
        actionwords.getDriver().quit();
    }
}