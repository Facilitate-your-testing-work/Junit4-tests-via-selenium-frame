import junit.framework.TestCase;

public class UseCaseGroupReceiveNewWorkOrderTest extends TestCase {

    public Actionwords actionwords = new Actionwords();
    // Receive reactive work orders
    
    public void test0200101Uid9c77d0213de74e71ad4bee899579d53f() {
    //public void test0200101Uid03daf907a65f4e4b82787d5db2d87fb6() {
        // Given SetBrowswerType "Chrome"
        actionwords.setBrowswerType("Chrome");
        // And SetTargetUrl "https://swtest.aklc.net"
        actionwords.setTargetUrl("https://swtest.aklc.net");
        // When LoginStormport "west@cityparks.co.nz" "password12"
        actionwords.loginStormport("west@cityparks.co.nz", "password12");
        // And FilterOrderByType "REACTIVE"
        actionwords.filterOrderByType("REACTIVE");
        // Then VerifyAsReceivedOrderType "REACTIVE"
        actionwords.verifyAsReceivedOrderType("REACTIVE"); 
    }
    // Receive planned work orders
    public void test0200201Uid7db626c31ab4443ea62bb30f902a60d7() {
    //public void test0200201Uida448cf6bb3f1491f850938b91170aa14() {
        // Given SetBrowswerType "Chrome"
        actionwords.setBrowswerType("Chrome");
        // And SetTargetUrl "https://swtest.aklc.net"
        actionwords.setTargetUrl("https://swtest.aklc.net");
        // When LoginStormport "west@cityparks.co.nz" "password12"
        actionwords.loginStormport("west@cityparks.co.nz", "password12");
        // And FilterOrderByType "PLANNED"
        actionwords.filterOrderByType("PLANNED");
        // Then VerifyAsReceivedOrderType "PLANNED"
        actionwords.verifyAsReceivedOrderType("PLANNED");
    }
    // Receive Preventive work orders
    public void test0200301Uidc61b496d21dc41c58a3073df2aca287e() {
    //public void test0200301Uid0d5e2659ce7e402e8e094c8913076996() {
        // Given SetBrowswerType "Chrome"
        actionwords.setBrowswerType("Chrome");
        // And SetTargetUrl "https://swtest.aklc.net"
        actionwords.setTargetUrl("https://swtest.aklc.net");
        // When LoginStormport "west@cityparks.co.nz" "password12"
        actionwords.loginStormport("west@cityparks.co.nz", "password12");
        // And FilterOrderByType "PREVENTIVE"
        actionwords.filterOrderByType("PREVENTIVE");
        // Then VerifyAsReceivedOrderType "PREVENTIVE"
        actionwords.verifyAsReceivedOrderType("PREVENTIVE");
    }
}