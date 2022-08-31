package EmailAdminApp;
public class EmailApp {
    public static void main(String[] args){
        Email em1 = new Email("xi", "tang");
        em1.setMailboxCapacity(2000);
        System.out.println(em1.getMailboxCapacity());
        em1.changePassword("Ilovemyfamily");
        System.out.println(em1.getPassword());
    }
}
