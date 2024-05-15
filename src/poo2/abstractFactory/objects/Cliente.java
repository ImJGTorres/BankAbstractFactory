package poo2.abstractFactory.objects;

import java.util.ArrayList;

public class Cliente {
	private int cc;
	private String nombre;
	private String apellido;
	private ArrayList<Account> cuentas = new ArrayList<Account>();
	
	public Cliente(int cc, String nombre, String apellido) {
		this.cc = cc;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	//PUNTO 2
	public void vincularCuenta(Account cuenta) {
		this.cuentas.add(cuenta);
	}
	
	//PUNTO 3
	public void listarCuentas(int cc, String nombre, ArrayList<Account> cuentas) {
		System.out.println("CC: " + cc + ", Nombre: " + nombre + ", Saldo total de las cuentas: " + acumuladoCuentas(cuentas));
	}
	
	//PUNTO 3
	public double acumuladoCuentas(ArrayList<Account> cuentas) {
		double suma = 0.0;
		for (int i = 0; i<cuentas.size(); i++) {
			suma+= this.cuentas.get(i).getBalance();
		}
		return suma;
	}
	
	public ArrayList<Account> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<Account> cuentas) {
		this.cuentas = cuentas;
	}
	
	public int getCc() {
		return cc;
	}
	
	public String getNombre() {
		return nombre;
	}	
	
}
