package entities;

public abstract class Pessoa {

	private String nome;
	private int idade;
	private String cpf;
	private char sexo;
	private Endereco enderecoPessoa;
	private Contato contato;
	
	public Pessoa(String nome, int idade, String cpf, char sexo, Endereco enderecoPessoa, Contato contato) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.sexo = sexo;
		this.enderecoPessoa = enderecoPessoa;
		this.contato = contato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public Endereco getEnderecoPessoa() {
		return enderecoPessoa;
	}

	public void setEnderecoPessoa(Endereco enderecoPessoa) {
		this.enderecoPessoa = enderecoPessoa;
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public String toString(){
		return "Nome: " + this.getNome() + "\n" +
			   "CPF: " + this.getCpf() + "\n" +
			   "Idade: " + this.getIdade() + "\n" + 
			   "Sexo: " + this.getSexo() + "\n" +
			   this.getEnderecoPessoa() +
			   this.getContato();
	}
	
	public abstract double calcularSalario();
	
}




