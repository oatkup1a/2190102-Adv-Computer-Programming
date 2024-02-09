public class App {
    public static void main(String[] args) throws Exception {
        Account a = new Account(1001, "Mike Smith", 100);
        System.out.println(a);
        a.deposit(100);
        System.out.println(a);
        a.withdraw(100);
        System.out.println(a);
    }
}
