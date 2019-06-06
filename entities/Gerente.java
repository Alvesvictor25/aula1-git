package entities;

import java.text.DecimalFormat;

public class Gerente extends Pessoa{
	
	private double salario;

	public Gerente(String nome, int idade, String cpf, char sexo,
			Endereco enderecoPessoa, Contato contato, double salario) {
		super(nome, idade, cpf, sexo, enderecoPessoa, contato);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double calcularSalario(){
		return this.getSalario() * 1.20;
	}
	
	
	//M�todo que faz o c�lculo do Sal�rio L�quido de um Gerente.
	public void calcularSalarioLiquidoGerente() {
		DecimalFormat df = new DecimalFormat("0.00");
		double salarioBruto = this.calcularSalario();
		double INSS = salarioBruto * 0.10;
		double IR = 0;
		if (salarioBruto - INSS > 2000){
			IR = (salarioBruto - INSS) * 0.15;
		}
		double salarioLiquido = salarioBruto - INSS - IR;
		System.out.println("Gerente: " + this.getNome() + ". \n" +
		                   "Sal�rio Bruto: " + df.format(salarioBruto) + "\n" +
							"INSS: " + df.format(INSS) + "\n" + 
		                   	"IR: " + df.format(IR) + "\n" +
							"Sal�rio L�quido: "+ df.format(salarioLiquido) + "\n");
	}
	
}


