import java.util.Scanner;
import java.util.HashMap;
import java.math.BigInteger;
import java.util.Random;
public class ATM_Interface
{
    static HashMap<Long,Integer> map=new HashMap<>();
    static HashMap<BigInteger,Long> map1=new HashMap<>();
    static int pin;
    static long ac;
    static BigInteger phone;
    static int balance=1000;
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.print("1.Log In to an existing account\n2.Open new Account\n0.To Exit\nEnter choice:");
        int i=sc.nextInt();
        while(i!=0) {
            //System.out.println(map);
            if (i == 1) {
                if(!map.isEmpty()){
                System.out.print("Enter account no:");
                long acc = sc.nextInt();
                System.out.print("Enter pin:");
                int pin = sc.nextInt();
                if (map.containsKey(acc) && map.containsValue(pin)) {
                    menu();
                }
                else {
                    System.out.println("Invalid A/c no or pin");
                    System.out.println("Forget pin?Y/N");
                    char c=sc.next().charAt(0);
                    if(c=='Y'){
                        setPin();
                    }
                    else {
                        System.exit(0);
                    }
                    }
                }else{System.out.println("Error:#23AD34");}
            }
            else if (i == 2)
            {
                Random r1=new Random();
                System.out.print("Enter PIN:");
                pin=sc.nextInt();
                System.out.println("Enter Registered phone number:");
                phone=sc.nextBigInteger();
                ac=r1.nextInt(999999);
                System.out.println("Account created sucessfully..."+ac);
                map.put(ac,pin);
                map1.put(phone,ac);
            }
            else
            {
                System.out.println("Invalid input...");
            }
            System.out.print("1.Log In to an existing account\n2.Open new Account\n0.To Exit\nEnter choice:");
            i=sc.nextInt();
        }
    }
    public static void menu()
    {
        System.out.println("Balance:"+balance+"\n");
        System.out.println("------ATM Machine------");
        System.out.println("Choose 1 for Check balance");
        System.out.println("Choose 2 for Withdraw");
        System.out.println("Choose 3 for Deposit");
        System.out.println("Choose 4 for Exit");
        int a=sc.nextInt();
        switch(a)
        {
            case 1:
                getBalance();
                break;

            case 2:
                withdrawMoney();
                break;

            case 3:
                depositMoney();
                break;

            case 4:
                System.exit(0);
        }
    }
    public static void getBalance()
    {
        System.out.println("Current Balance:"+balance);
        menu();
    }
    public static void withdrawMoney()
    {
        System.out.println("Enter amount to withdraw:");
        int amount=sc.nextInt();
        if(amount>balance)
        {
            System.out.println("Insufficient balance");
            getBalance();
        }
        else
        {
            balance-=amount;
            System.out.println("Withdrawal successful");
            getBalance();
        }
    }
    public static void depositMoney()
    {
        System.out.println("Enter amount to Deposit:");
        int amount=sc.nextInt();
        balance+=amount;
        System.out.println("Deposit successful");
        getBalance();
    }
    public static void setPin()
    {
        System.out.println("Enter Registered phone number:");
        phone=sc.nextBigInteger();
        System.out.println("Enter a/c no:");
        ac=sc.nextInt();
        if (map1.containsKey(phone) && map1.containsValue(ac) && map.containsKey(ac)) {
            System.out.println("Enter pin:");
            pin=sc.nextInt();
            map.put(ac,pin);
            System.out.println("Pin set succesfully...");
        }
        else{
            System.out.println("Invalid input");
        }
    }
}
