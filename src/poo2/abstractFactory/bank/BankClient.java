package poo2.abstractFactory.bank;

import poo2.abstractFactory.factories.AccountFactory;
import poo2.abstractFactory.factories.CurrentAccountFactory;
import poo2.abstractFactory.factories.SavingsAccountFactory;
import poo2.abstractFactory.objects.Account;

/**
 *
 * @author 
 */
public class BankClient {
    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
		BankClient app = new BankClient();
		
		AccountFactory factory = app.configureApplication('C');
		
		
		Account acc = factory.abrirCuenta();
	}
	
	private AccountFactory configureApplication(char parametro) {
		AccountFactory factory = null;
		
		// Se simula la revisión de parámetros de configuracion
		// int random = ((new Random()).nextInt()*10);
		
		if(parametro=='C')
			factory = CurrentAccountFactory.getInstance();
		else if(parametro=='S')
			factory = SavingsAccountFactory.getInstance();
		
		factory = CurrentAccountFactory.getInstance();
		
		return factory;
	}

}