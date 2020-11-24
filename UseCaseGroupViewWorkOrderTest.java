import junit.framework.TestCase;

public class UseCaseGroupViewWorkOrderTest extends TestCase {

    public Actionwords actionwords = new Actionwords();
    // Filter work orders by "Status" and "Type"
    public void test0300101Uid8dd6aa8b4b974aae9c492b435ceb01d0() {
    //public void test0300101Uid040a6df433e3468baa9719e2a47a6aea() {
        // Given SetBrowswerType "Chrome"
        actionwords.setBrowswerType("Chrome");
        // And SetTargetUrl "https://swtest.aklc.net"
        actionwords.setTargetUrl("https://swtest.aklc.net");
        // When LoginStormport "west@cityparks.co.nz" "password12"
        actionwords.loginStormport("west@cityparks.co.nz", "password12");
        // And SetOrderStatusToFiler "APPROVED"
        actionwords.setOrderStatusToFiler("APPROVED");
        // And FilterOrderByType "REACTIVE"
        actionwords.filterOrderByType("REACTIVE");
        // Then VerifyAsReceivedOrderTypeAndStatus "REACTIVE" "APPROVED"
        actionwords.verifyAsReceivedOrderTypeAndStatus("REACTIVE", "APPROVED");
    }
    // Filter work orders by "Due date + start date / end date" and "Type"
    public void test0300103Uid1ae7fa10122c4a9993072af89c949c61() {
    //public void test0300103Uid3b007f03fcbb4829958ef04b8bb801a1() {
        // Given SetBrowswerType "Chrome"
        actionwords.setBrowswerType("Chrome");
        // And SetTargetUrl "https://swtest.aklc.net"
        actionwords.setTargetUrl("https://swtest.aklc.net");
        // When LoginStormport "west@cityparks.co.nz" "password12"
        actionwords.loginStormport("west@cityparks.co.nz", "password12");
        // And SetOrderDueDateOfStartAndEnd "01/12/2019" "16/01/2020"
        actionwords.setOrderDueDateOfStartAndEnd("01/12/2019", "16/01/2020");
        // And FilterOrderByType "PREVENTIVE"
        actionwords.filterOrderByType("PREVENTIVE");
        // Then VerifyAsReceivedOrderTypeAndDueDate "PREVENTIVE" "01/12/2019" "16/01/2020"
        actionwords.verifyAsReceivedOrderTypeAndDueDate("PREVENTIVE", "01/12/2019", "16/01/2020");
    }
}