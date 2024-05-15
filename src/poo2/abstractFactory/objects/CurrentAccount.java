package poo2.abstractFactory.objects;

public class CurrentAccount extends Account {
	protected static double PORCENTAJE_LIMITE_SOBREGIRO = 50.0;
	private double porcentajeLimiteSobregiro;
	private double limiteSobregiro;

	public CurrentAccount() {
		
	}

	public CurrentAccount(int a) {
		super(a);
		this.porcentajeLimiteSobregiro = PORCENTAJE_LIMITE_SOBREGIRO;
	}

	public CurrentAccount(int a, double porcentajeLimiteSobregiro) {
		super(a);
		this.porcentajeLimiteSobregiro = porcentajeLimiteSobregiro;
	}

	@Override
	public void deposit(double sum) {
		// Si el balance esta en 0, significa que no se ha realizado ningún deposito
		if (this.getBalance() == 0) {
			super.deposit(sum);
			this.limiteSobregiro = this.getBalance() * (porcentajeLimiteSobregiro / 100);
		} else {
			super.deposit(sum);
		}
	}

	@Override
	public void withdraw(double sum) {
		// System.out.println("CurrentAccount.withdraw: " + this.getAccountNumber());
		if (sum > 0) {
			double disponibleRetirar = this.getBalance() + limiteSobregiro;
			if (sum <= disponibleRetirar) {
				super.withdraw(sum);
			} else {
				System.err.println("CurrentAccount.withdraw(...): " + "cannot withdraw more than overdraft limit.");
			}
		} else {
			System.err.println("CurrentAccount.withdraw(...): " + "cannot withdraw negative amount.");
		}
	}

	public double getLimiteSobregiro() {
		return limiteSobregiro;
	}

	public void setLimiteSobregiro(double limiteSobregiro) {
		this.limiteSobregiro = limiteSobregiro;
	}

	public double getPorcentajeLimiteSobregiro() {
		return porcentajeLimiteSobregiro;
	}

	public void setPorcentajeLimiteSobregiro(double porcentajeLimiteSobregiro) {
		this.porcentajeLimiteSobregiro = porcentajeLimiteSobregiro;
	}
}
