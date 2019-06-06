package entities;

public class Departamento {

	private String area;
	private double meta;
	private Funcionario[] funcionarios;
	private Gerente gerente;

	public Departamento(String area, double meta, Funcionario[] funcionarios, Gerente gerente) {
		super();
		this.area = area;
		this.meta = meta;
		this.funcionarios = funcionarios;
		this.gerente = gerente;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public double getMeta() {
		return meta;
	}

	public void setMeta(double meta) {
		this.meta = meta;
	}

	// M�todo que pega a idade do gerente e faz um la�o de repti��o pegando a idade
	// dos funcion�rios.
	// Essas idades s�o acumuladas na vari�vel idadeDepartamento e no final �
	// impressa a informa��o.
	public int somarIdadesPessoasDepartamento() {
		int idadeDepartamento = 0;
		idadeDepartamento = this.getGerente().getIdade();
		for (int i = 0; i < this.getFuncionarios().length; i++) {
			idadeDepartamento = idadeDepartamento + this.getFuncionarios()[i].getIdade();
		}
		System.out.println(
				"O somat�rio das idades do Departamento " + this.getArea() + " � igual a " + idadeDepartamento + ".");
		return idadeDepartamento;
	}

	// O m�todo percorre a lista de funcion�rios do departamento identificando quem
	// � o funcion�rio mais novo.
	// Depois de achado o funcion�rio mais novo, � feita a compara��o com o gerente
	// para achar a pessoa mais nova.
	// Por fim o m�todo retorna ent�o a pessoa mais nova.
	public Pessoa obterPessoaMaisNovaPorDepartamento() {
		Funcionario funcionarioMaisNovo = this.getFuncionarios()[0];
		for (int i = 1; i < this.getFuncionarios().length; i++) {
			if (funcionarioMaisNovo.getIdade() > this.getFuncionarios()[i].getIdade()) {
				funcionarioMaisNovo = this.getFuncionarios()[i];
			}
		}
		if (funcionarioMaisNovo.getIdade() < this.getGerente().getIdade()) {
			return funcionarioMaisNovo;
		} else {
			return this.getGerente();
		}
	}

	// O m�todo percorre a lista de funcion�rios do departamento identificando quem
	// � o funcion�rio mais idoso.
	// Depois de achado o funcion�rio mais idoso, � feita a compara��o com o gerente
	// para achar a pessoa mais idosa.
	// Por fim o m�todo retorna ent�o a pessoa mais idosa.
	public Pessoa obterPessoaMaisIdosaPorDepartamento() {
		Funcionario funcionarioMaisIdoso = this.getFuncionarios()[0];
		for (int i = 1; i < this.getFuncionarios().length; i++) {
			if (funcionarioMaisIdoso.getIdade() < this.getFuncionarios()[i].getIdade()) {
				funcionarioMaisIdoso = this.getFuncionarios()[i];
			}
		}
		if (funcionarioMaisIdoso.getIdade() > this.getGerente().getIdade()) {
			return funcionarioMaisIdoso;
		} else {
			return this.getGerente();
		}
	}

	// M�todo que percorre o departamento contabilizando a quantidade de homens.
	public int contabilizarQuantidadeHomens() {
		int qtdeHomens = 0;
		if (this.getGerente().getSexo() == 'M') {
			qtdeHomens++;
		}
		for (int i = 0; i < this.getFuncionarios().length; i++) {
			if (this.getFuncionarios()[i].getSexo() == 'M') {
				qtdeHomens++;
			}
		}
		return qtdeHomens;
	}

	// M�todo que percorre o departamento contabilizando a quantidade de mulheres.
	public int contabilizarQuantidadeMulheres() {
		int qtdeMulheres = 0;
		if (this.getGerente().getSexo() == 'F') {
			qtdeMulheres++;
		}
		for (int i = 0; i < this.getFuncionarios().length; i++) {
			if (this.getFuncionarios()[i].getSexo() == 'F') {
				qtdeMulheres++;
			}
		}
		return qtdeMulheres;
	}

	// M�todo que imprime as informa��es das pessoas (gerente e funcion�rios) do
	// departamento que moram na cidade recebida como par�metro.
	public void identificarPessoasDepartamentoPorCidade(String cidade) {
		if (this.getGerente().getEnderecoPessoa().getCidade().equals(cidade)) {
			System.out.println(this.getGerente().toString());
		}
		for (int i = 0; i < this.getFuncionarios().length; i++) {
			if (this.getFuncionarios()[i].getEnderecoPessoa().getCidade().equals(cidade)) {
				System.out.println(this.getFuncionarios()[i].toString());
			}
		}
	}

	// M�todo que acumula o valor de imposto com pessoas (gerente e funcion�rios) do
	// departamento.
	// Para isso se acumula em impostoDepartamento o resultado do c�lculo de 90% do
	// valor dos sal�rios.
	public double calcularImpostoPorDepartamento() {
		double impostoDepartamento = this.getGerente().calcularSalario() * 0.90;
		for (int i = 0; i < this.getFuncionarios().length; i++) {
			impostoDepartamento = impostoDepartamento + (this.getFuncionarios()[i].calcularSalario() * 0.90);
		}
		return impostoDepartamento;
	}

	// M�todo que identifica o maior sal�rio entre os funcion�rios do departamento.
	public Funcionario identificarPessoaMaiorSalarioDepartamento() {
		Funcionario funcionario = this.getFuncionarios()[0];
		for (int i = 1; i < this.getFuncionarios().length; i++) {
			if (this.getFuncionarios()[i].getSalario() > funcionario.getSalario()) {
				funcionario = this.getFuncionarios()[i];
			}
		}
		return funcionario;
	}

	// M�todo que identifica o menor sal�rio entre os funcion�rios do departamento.
	public Funcionario identificarPessoaMenorSalarioDepartamento() {
		Funcionario funcionario = this.getFuncionarios()[0];
		for (int i = 1; i < this.getFuncionarios().length; i++) {
			if (this.getFuncionarios()[i].getSalario() < funcionario.getSalario()) {
				funcionario = this.getFuncionarios()[i];
			}
		}
		return funcionario;
	}

	// M�todo que verifica se o nome recebido como par�metro � o nome do gerente do
	// departamento.
	// Se sim, imprime a informa��o de contato.
	public void consultarContatoGerente(String nome) {
		if (nome.equals(this.getGerente().getNome())) {
			System.out.println(this.getGerente().getNome() + " \n" + this.getGerente().getContato());
		}
	}

	// M�todo que verifica se o nome recebido como par�metro � o nome de um dos
	// funcion�rios do departamento.
	// Se sim, imprime a informa��o de contato.
	public void consultarContatoFuncionarios(String nome) {
		for (int i = 0; i < this.getFuncionarios().length; i++) {
			if (nome.equals(this.getFuncionarios()[i].getNome())) {
				System.out
						.println(this.getFuncionarios()[i].getNome() + " \n" + this.getFuncionarios()[i].getContato());
			}
		}
	}

}
