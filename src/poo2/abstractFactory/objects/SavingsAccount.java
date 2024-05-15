package poo2.abstractFactory.objects;

public class SavingsAccount extends Account{
	protected static double INTERES = 20.0;
	private double interes;
	
	public SavingsAccount() {
		
	}

	public SavingsAccount(int a) {
		super(a);
		this.interes = INTERES;
	}

	public SavingsAccount(int a, double interes) {
		super(a);
		this.interes = interes;
	}
	
	@Override
	public void deposit(double sum) {
		//System.out.println("SavingsAccount.deposit: " + this.getAccountNumber());
		if (sum > 0) {
			super.deposit(sum + (this.getBalance() * interes / 100.0));
		}
		else {
			System.err.println("SavingsAccount.deposit(...): " + "cannot deposit negative amount.");
		}
	}
	
	@Override
    public void withdraw(double sum) {
		//System.out.println("SavingsAccount.withdraw: " + this.getAccountNumber());
        if (sum > this.getBalance()) {
        	System.err.println("SavingsAccount.withdraw(...): cannot withdraw a value greater than the account balance.");
        }
        else {
        	super.withdraw(sum);
        }
    }
	
	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}
}
