package poo2.abstractFactory.factories;

import poo2.abstractFactory.objects.Account;
import poo2.abstractFactory.objects.SavingsAccount;

public class SavingsAccountFactory implements AccountFactory {
	private static volatile SavingsAccountFactory instance;

	@Override
	public Account abrirCuenta() {
		SavingsAccount emp = new SavingsAccount();
		
		return emp;
	}
	
	public static SavingsAccountFactory getInstance() {
		SavingsAccountFactory result = instance;
		
		if (result != null) {
			return result;
		}
		// ...
		synchronized (SavingsAccountFactory.class) {
			// ...
			if (instance == null) {
				instance = new SavingsAccountFactory();
			}
			return instance;
		}
	}
}
