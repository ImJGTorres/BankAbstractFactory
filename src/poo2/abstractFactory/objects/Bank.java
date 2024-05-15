package poo2.abstractFactory.objects;

import java.util.ArrayList;


public class Bank {
	private static Bank instance;
	private ArrayList<Account> cuentas = new ArrayList<Account>();

	public ArrayList<Account> getCuentas() {
		return cuentas;
	}
	
	public static Bank getInstance() {
		if (instance==null) {
			instance = new Bank();
		}
		return instance;
	}

	public void setCuentas(ArrayList<Account> cuentas) {
		this.cuentas = cuentas;
	}
	
	public void payDividend(int accnum, double valor) {
		int indexAccount = -1;
		try {
			indexAccount = this.findAccountIndex(accnum);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if(indexAccount != -1) this.cuentas.get(indexAccount).deposit(valor);
	}
	
	public void withdrawAccount(int accnum, double valor) {
		int indexAccount = -1;
		try {
			indexAccount = this.findAccountIndex(accnum);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if(indexAccount != -1) this.cuentas.get(indexAccount).withdraw(valor);
	}
	
	public void openAccount(char account, int accountNumber) throws Exception{
        Account accountBank;
        if (cuentas.size() > 0) {
            if (buscarCuentaRepetida(accountNumber)) {
                throw new Exception("Ya existe esta cuenta");
            }
        }
        if (account != 'A' && account != 'C') {
            throw new RuntimeException("Account type " + account + " is not recognized");
        }
        if (account == 'C') {
            accountBank = new CurrentAccount(accountNumber);
            System.out.println("Current account " + accountNumber + " open.");
        } else {
            accountBank = new SavingsAccount(accountNumber);
            System.out.println("Savings account " + accountNumber + " open.");
        } 
        this.cuentas.add(accountBank);
    }
	
	public boolean buscarCuentaRepetida(int accountNumber) {
        for (Account account : cuentas) {
            if (accountNumber == account.getAccountNumber()) {
                return true;
            }
        }
        return false;
    }
	
	//PUNTO 2
	public void vincularCliente(Cliente c, int accnum) {
		boolean encontrado = false;
		int indice = 0;
		for(int i = 0; !encontrado && i < this.cuentas.size(); i++) {
				if(this.cuentas.get(i).getAccountNumber() == accnum) encontrado = true;
				indice = i;
			}
			if (!encontrado) {
				System.out.println("Cuenta no existente");
			}
			else {
				c.vincularCuenta(this.cuentas.get(indice));
			}
	}
	
	public void listarCuentas(Cliente c) {
		System.out.println("CC: " + c.getCc() + ", Nombre: " + c.getNombre() + ", Saldo total de las cuentas: " + c.acumuladoCuentas(c.getCuentas()));
	}
	
	
	public void closeAccount(int accnum) {
		int indexAccount = -1;
		try {
			indexAccount = this.findAccountIndex(accnum);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if(indexAccount != -1) {
			this.cuentas.remove(indexAccount);
			System.out.println("Closed account with the number: " + accnum);
		}
	}
	
	public int findAccountIndex(int accnum) {
		boolean encontrada = false;
		int i;
		for (i = 0; i < cuentas.size() && !encontrada; i++) {
			if (this.cuentas.get(i).getAccountNumber() == accnum) {
				encontrada = true;
			}
		}
		if (!encontrada) throw new RuntimeException("This account number doesn't exist: " + accnum);
		return i - 1;
	}
	
	public double getBalance(int accnum) {
		double balance = 0.0;
		int indexAccount = -1;
		try {
			indexAccount = this.findAccountIndex(accnum);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if(indexAccount != -1) {
			balance = this.cuentas.get(indexAccount).getBalance();
		}
		return balance;
	}
	
	public void sendLetterToOverdraftAccounts() {
	    for (Account account : cuentas) {
	        if (account instanceof CurrentAccount) {
	            CurrentAccount currentAccount = (CurrentAccount) account;
	            if (currentAccount.getBalance() < 0) {
	            	System.out.println("Sending letter to this account number: " + account.getAccountNumber());
	            }
	        }
	    }
	}
}
