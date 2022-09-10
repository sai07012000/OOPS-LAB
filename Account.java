
import java.util.Scanner;

public class Account {
	
	static Scanner sc=new Scanner(System.in);
	int accno,phno;
	String name;
    float balance;
    void getinput() {
		System.out.println("Enter Name : ");
		name=sc.nextLine();
		System.out.println("Enter Account no. : ");
		accno=sc.nextInt();
		System.out.println("Enter Phone no. : ");
		phno=sc.nextInt();
		System.out.println("Enter balance. : ");
		balance=sc.nextFloat();
		
	}
	 void deposite()
	 {
		 System.out.println("Enter the amount to be deposited : ");
		 float dep=sc.nextFloat();
		 balance +=dep;
		 System.out.println("Amount  , balance ="+balance);
		 
	 }
	 void withdraw()
	 {
		 System.out.println("Enter the amount to be Withdrawn : ");
		 float wit=sc.nextFloat();
		 if(wit<=balance)
		 {
		 balance -=wit;
		 System.out.println("Amount withdrawn , balance ="+balance);
		 }
		 else
			 System.out.println("Insufficiant balance");
		 
	 }

	 void display() {
		 System.out.println("\nName:"+name+"\nAccount Number:"+accno+"\nPhone No:"+phno+"\nBalance"+balance);
	 }
	public static void main(String[] args) {
		
		Account p=new Account();
		
		p.getinput();
		while(true)
		{
			System.out.println("Press 1 :Deposite 2:Withdraw 3:Display");
			int choice=sc.nextInt();
			if(choice==1)
				p.deposite();
			else if(choice==2)
				p.withdraw();
			else if(choice==3)
				p.display();
			else
				System.out.println("Invalid choice");
			
		}
		

	}

}
