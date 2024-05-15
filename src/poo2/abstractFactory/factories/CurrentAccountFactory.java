package poo2.abstractFactory.factories;

import poo2.abstractFactory.objects.Account;
import poo2.abstractFactory.objects.CurrentAccount;

public class CurrentAccountFactory implements AccountFactory {
	private static volatile CurrentAccountFactory instance;
	
	@Override
	public Account abrirCuenta() {
		CurrentAccount emp = new CurrentAccount();
		
		return emp;
	}
	
	public static CurrentAccountFactory getInstance() {
		CurrentAccountFactory result = instance;
		
		if (result != null) {
			return result;
		}
		// ...
		synchronized (CurrentAccountFactory.class) {
			// ...
			if (instance == null) {
				instance = new CurrentAccountFactory();
			}
			return instance;
		}
	}
}