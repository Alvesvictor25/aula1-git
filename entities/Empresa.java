package entities;

import java.text.DecimalFormat;

public class Empresa {
	
	private String nome;
	private long cnpj;
	private String site;
	private Departamento[] departamentos;
	private Endereco enderecoEmpresa;
	
	public Empresa(String nome, long cnpj, String site,
			Departamento[] departamentos, Endereco enderecoEmpresa) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.site = site;
		this.departamentos = departamentos;
		this.enderecoEmpresa = enderecoEmpresa;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public Departamento[] getDepartamentos() {
		return departamentos;
	}
	
	public void setDepartamentos(Departamento[] departamentos) {
		this.departamentos = departamentos;
	}
	
	public Endereco getEnderecoEmpresa() {
		return enderecoEmpresa;
	}
	
	public void setEnderecoEmpresa(Endereco enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}
	
	
	//Relativo ao Exercício 6
	//Lógica: Laço de repetição para percorrer os departamentos pedindo para que cada departamento some 
	// as idades dos seus funcionários e gerente. O retorno do método é acumulado na variável idadeTotal.
	public void somarIdadesPessoas(){
		int idadeTotal = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			idadeTotal = idadeTotal + this.getDepartamentos()[i].somarIdadesPessoasDepartamento();		
		}
		System.out.println("O somatório das idades de todos os Departamentos é igual a " + idadeTotal + ".");
	}
	
	
	//Relativo ao Exercício 7
	//Lógica: Laço de repetição para percorrer os departamentos pedindo para que cada departamento  
	// informe quem é a pessoa mais idosa e a mais nova do departamento. 
	//O resultado é impresso para cada departamento da empresa.
	public void identificarPessoaMaisNovaMaisVelhaPorDepartamento() {
		for(int i = 0; i < this.getDepartamentos().length; i++) {
			Departamento depto = this.getDepartamentos()[i];
			Pessoa pessoaMaisNova = depto.obterPessoaMaisNovaPorDepartamento();
			System.out.println("A pessoa mais nova do departamento de " + depto.getArea() + " é: \n" + pessoaMaisNova.toString());
			Pessoa pessoaMaisIdosa = depto.obterPessoaMaisIdosaPorDepartamento();
			System.out.println("A pessoa mais idosa do departamento de " + depto.getArea() + " é: \n" + pessoaMaisIdosa.toString());
		}
	}
	
	
	//Relativo ao Exercício 8
	//Lógica: Laço de repetição para percorrer os departamentos pedindo para que cada departamento  
	// informe quem é a pessoa mais idosa e a mais nova do departamento. A medida que cada departamento
	// devolve a pessoa é feita a comparação com a pessoa do outro departamento. 
	//Ao terminar o laço de repetiçao se tem a pessoa mais idosa e nova da empresa e o resultado é impresso. 
	public void identificarPessoaMaisNovaMaisVelha(){
		String areaPessoaMaisNova = this.getDepartamentos()[0].getArea();
		String areaPessoaMaisIdosa = this.getDepartamentos()[0].getArea();
		Pessoa pessoaMaisNova = this.getDepartamentos()[0].obterPessoaMaisNovaPorDepartamento();
		Pessoa pessoaMaisIdosa = this.getDepartamentos()[0].obterPessoaMaisIdosaPorDepartamento();
		
		for(int i = 1; i < this.getDepartamentos().length; i++){
			Pessoa pessoaNova = this.getDepartamentos()[i].obterPessoaMaisNovaPorDepartamento();
			if(pessoaMaisNova.getIdade() > pessoaNova.getIdade()){
				pessoaMaisNova = pessoaNova;
				areaPessoaMaisNova = this.getDepartamentos()[i].getArea();
			}
			Pessoa pessoaIdosa = this.getDepartamentos()[i].obterPessoaMaisIdosaPorDepartamento();
			if(pessoaMaisIdosa.getIdade() < pessoaIdosa.getIdade()){
				pessoaMaisIdosa = pessoaIdosa;
				areaPessoaMaisIdosa = this.getDepartamentos()[i].getArea();
			}
		}
		System.out.println("A pessoa mais nova da empresa é do " + areaPessoaMaisNova + " é: \n" + pessoaMaisNova.toString());
		System.out.println("A pessoa mais idosa da empresa é do " + areaPessoaMaisIdosa + " é: \n" + pessoaMaisIdosa.toString());
	}
	
	
	//Relativo ao Exercício 9
	//Lógica: Laço de repetição para percorrer os departamentos pedindo para que cada departamento informe 
	// quantos homens e quantas mulheres o departamento possui. 
	// Os retornos desses métodos são acumulados nas variáveis qtdeHomensDep e qtdeMulheresDep.
	// O método imprime esses valores e na sequência acumula as informações nas variáveis qtdeHomens e qtdeMulheres
	// para contabilizar os valores de toda a empresa. Após o laço é impressa essas informações.
	public void calcularPercentualPessoas(){
		int qtdeHomens = 0;
		int qtdeMulheres = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			int qtdeHomensDep = this.getDepartamentos()[i].contabilizarQuantidadeHomens();
			int qtdeMulheresDep = this.getDepartamentos()[i].contabilizarQuantidadeMulheres();
			System.out.println("O Total de Homens do " + this.getDepartamentos()[i].getArea() + " é: " + qtdeHomensDep);
			System.out.println("O Total de Mulheres do " + this.getDepartamentos()[i].getArea() + " é: " + qtdeMulheresDep);
			qtdeHomens = qtdeHomens + qtdeHomensDep;
			qtdeMulheres = qtdeMulheres + qtdeMulheresDep;
		}
		System.out.println("O Percentual de Homens da Empresa é: " + (qtdeHomens * 100/(qtdeHomens+qtdeMulheres)) + "%.");
		System.out.println("O Percentual de Mulheres da Empresa é: " + (qtdeMulheres * 100/(qtdeHomens+qtdeMulheres)) + "%.");
	}
	
	
	//Relativo ao Exercício 10.
	//Lógica: Laço de repetição para percorrer os departamentos pedindo para que cada departamento identifique
	// as pessoas (funcionário e gerente) que moram na cidade informada.
	// O próprio departamento irá imprimir as informações.
	public void identificarPessoasPorCidade(String cidade){
		System.out.println("Pessoas que moram na cidade de " + cidade + ":");
		for(int i = 0; i < this.getDepartamentos().length; i++){
			this.getDepartamentos()[i].identificarPessoasDepartamentoPorCidade(cidade);
		}
	}
	
	
	//Relativo ao Exercício 11 - Letra D.
	//Lógica: Laço de repetição para percorrer os departamentos pedindo para que cada departamento calcule
	// os impostos do departamento. O retorno desse método é acumulado na variável impostoTotal.
	// O próprio departamento irá imprimir as informações.
	public void calcularImposto(){
		DecimalFormat df = new DecimalFormat("0.00");
		double impostoTotal = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			impostoTotal = impostoTotal + this.getDepartamentos()[i].calcularImpostoPorDepartamento();
		}
		System.out.println("O imposto mensal referente a salário é de R$ " + df.format(impostoTotal));
	}
	
	
	//Relativo ao Exercicio 11 - Letra E
	//Lógica: Esse método utiliza-se de dois métodos de apoio nesta mesma classe.
	// Esses métodos de apoio já retornam o salario de todos os gerentes e de todos os funcionários.
	public void calcularSalarioTotalEmpresa(){
		DecimalFormat df = new DecimalFormat("0.00");
		double salarioGerente = obterTotalSalarioGerentes();
		double salarioFuncionario = obterTotalSalarioFuncionarios();
		System.out.println("O total de Salarios (Gerentes e Funcionários) é de R$ " + df.format(salarioFuncionario + salarioGerente));
	}
	
	
	//Relativo ao Exercício 11 - Letra F
	//Lógica: Como foi desenvolvido um método para calcular o salário de todos os gerentes para atender o exercício da Letra E,
	// basta nesse exercício aproveitar o mesmo método.
	public void calcularSalarioTotalGerentes(){
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("O valor a ser pago para os Gerentes é de R$ "+ df.format(obterTotalSalarioGerentes()));
	}
	
	
	//Relativo ao Exercício 11 - Letra F
	//Lógica: Como foi desenvolvido um método para calcular o salário de todos os funcionários para atender o exercício da Letra E,
	// basta nesse exercício aproveitar o mesmo método.
	public void calcularSalarioTotalFuncionarios(){
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("O valor a ser pago para aos Funcionários é de R$ "+ df.format(obterTotalSalarioFuncionarios()));
	}
	
	
	//Relativo ao Exercício 11 - Letra E e F
	//Método de Apoio (PRIVATE). 
	//Lógica: Esse médodo de apoio é privado e tem como objetivo percorrer os departamentos e acumular os 
	// salários dos gerentes e retornar essa informação para o método chamador.
	private double obterTotalSalarioGerentes(){
		double salarioTotal = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			salarioTotal = salarioTotal + this.getDepartamentos()[i].getGerente().calcularSalario();
		}
		return salarioTotal;
	}
	
	
	//Relativo ao Exercício 11 - Letra E e F
	//Método de Apoio (PRIVATE). 
	//Lógica: Esse médodo de apoio é privado e tem como objetivo percorrer os departamentos e acumular os 
	// salários dos funcionários e retornar essa informação para o método chamador.
	private double obterTotalSalarioFuncionarios(){
		double salarioTotal = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			for(int j = 0; j < this.getDepartamentos()[i].getFuncionarios().length; j++){
				salarioTotal = salarioTotal + this.getDepartamentos()[i].getFuncionarios()[j].calcularSalario();
			}
		}
		return salarioTotal;
	}
	
	
	//Relativo ao Exercício 11 - Letra G.
	//Lógica: Desenvolvido dois métodos que fazem o cáculo do salário líquido do gerente e do funcionário.
	//Se utilizou dois laços de repetição para percorrer os departamentos pegando gerente e funcionários.
	public void calcularSalarioLiquido(){
		for(int i = 0; i < this.getDepartamentos().length; i++){
			this.getDepartamentos()[i].getGerente().calcularSalarioLiquidoGerente();
			for(int j = 0; j < this.getDepartamentos()[i].getFuncionarios().length; j++){
				this.getDepartamentos()[i].getFuncionarios()[j].calcularSalarioLiquidoFuncionario();
			}
		}
	}
	
	
	//Relativo ao Exercício 11 - Letra J.
	//Lógica: Laço de repetição para percorrer os departamentos e acumular o valor da meta de cada departamento.
	public void calcularMetaTotal(){
		DecimalFormat df = new DecimalFormat("0.00");
		double metaTotal = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			metaTotal = metaTotal + this.getDepartamentos()[i].getMeta();
		}
		System.out.println("A meta total da empresa " + this.getNome() + " é R$ " + df.format(metaTotal));
	}
	
	
	//Relativo ao Exercício 14
	//Lógica: Como o exercício pede o maior salário de gerente e funcionário da empresa, criou-se os objetos funcionário e gerente
	// para guardar a informação. Como esse funcionário e gerente pode ser de qualquer departamento também se identificou o departamento
	// através da variável local area (gerente e funcionário).
	// É usado um método identificarPessoaMaiorSalarioDepartamento que retorna o maior salário entre os funcionário do departamento.
	// São feitas comparações entre os gerentes dos departamentos e também entre os funcionários dos departamentos para se ter o maior 
	// salário entre gerentes e entre funcionários.
	// Por fim são impressas as informações.
	public void identificaMaioresSalarios(){
		DecimalFormat df = new DecimalFormat("0.00");
		String areaGerente = this.getDepartamentos()[0].getArea();
		String areaFuncionario = this.getDepartamentos()[0].getArea();
		Gerente gerente = this.getDepartamentos()[0].getGerente();
		Funcionario funcionario = this.getDepartamentos()[0].identificarPessoaMaiorSalarioDepartamento();
		
		for(int i = 1; i < this.getDepartamentos().length; i++){
			 if(this.getDepartamentos()[i].getGerente().getSalario() > gerente.getSalario()){
				 gerente = this.getDepartamentos()[i].getGerente();
				 areaGerente = this.getDepartamentos()[i].getArea();
			 }
			 Funcionario outroFuncionario = this.getDepartamentos()[i].identificarPessoaMaiorSalarioDepartamento();
			 if(outroFuncionario.getSalario() > funcionario.getSalario()){
				 funcionario = outroFuncionario;
				 areaFuncionario = this.getDepartamentos()[i].getArea();;
			 }
			 
		}
		System.out.println("\nO Gerente com o maior salário é o " + gerente.getNome() + " do Departamento " + areaGerente + " com o Salário de " + df.format(gerente.getSalario()));
		System.out.println("\nO Funcionário com o maior salário é o " + funcionario.getNome() + " do Departamento " + areaFuncionario + " com o Salário de " + df.format(funcionario.getSalario()));
	}
	
	
	//Relativo ao Exercício 15
	//Lógica: Como o exercício pede o menor salário de gerente e funcionário da empresa, criou-se os objetos funcionário e gerente
	// para guardar a informação. Como esse funcionário e gerente pode ser de qualquer departamento também se identificou o departamento
	// através da variável local area (gerente e funcionário).
	// É usado um método identificarPessoaMenorSalarioDepartamento que retorna o menor salário entre os funcionário do departamento.
	// São feitas comparações entre os gerentes dos departamentos e também entre os funcionários dos departamentos para se ter o menor 
	// salário entre gerentes e entre funcionários.
	// Por fim são impressas as informações.
	public void identificaMenoresSalarios(){
		DecimalFormat df = new DecimalFormat("0.00");
		String areaGerente = this.getDepartamentos()[0].getArea();
		String areaFuncionario = this.getDepartamentos()[0].getArea();
		Gerente gerente = this.getDepartamentos()[0].getGerente();
		Funcionario funcionario = this.getDepartamentos()[0].identificarPessoaMenorSalarioDepartamento();
		
		for(int i = 1; i < this.getDepartamentos().length; i++){
			 if(this.getDepartamentos()[i].getGerente().getSalario() < gerente.getSalario()){
				 gerente = this.getDepartamentos()[i].getGerente();
				 areaGerente = this.getDepartamentos()[i].getArea();
			 }
			 Funcionario outroFuncionario = this.getDepartamentos()[i].identificarPessoaMenorSalarioDepartamento();
			 if(outroFuncionario.getSalario() < funcionario.getSalario()){
				 funcionario = outroFuncionario;
				 areaFuncionario = this.getDepartamentos()[i].getArea();;
			 }
			 
		}
		System.out.println("\nO Gerente com o menor salário é o " + gerente.getNome() + " do Departamento " + areaGerente + " com o Salário de " + df.format(gerente.getSalario()));
		System.out.println("\nO Funcionário com o menor salário é o " + funcionario.getNome() + " do Departamento " + areaFuncionario + " com o Salário de " + df.format(funcionario.getSalario()));
	}
	
	
	//Relativo ao Exercicio 16
	//Lógica: Esse método se utiliza de um método de apoio para verificar se o nome do contato a ser procurado é um gerente ou funcionário.
	// Se for gerentes ele executa um laço de repetição nos departamentos pegando apenas os gerentes para imprimir o contato.
	// Se for funcionário ele executa um laço de repetição nos departamentos pegando apenas os funcionários para imprimir o contato.
	public void consultarContato(String nome){
		if (verificarGerente(nome)){
			for(int i = 0; i < this.getDepartamentos().length; i++){
				this.getDepartamentos()[i].consultarContatoGerente(nome);
			}
		} else {
			for(int i = 0; i < this.getDepartamentos().length; i++){
				this.getDepartamentos()[i].consultarContatoFuncionarios(nome);
			}
		}
	}
	
	
	//Método de apoio privado que verificar se um dado nome é um gerente ou não.
	private boolean verificarGerente(String nome){
		for(int i = 0; i < this.getDepartamentos().length; i++){
			if (nome.equals(this.getDepartamentos()[i].getGerente().getNome())){
				return true;
			}
		}
		return false;
	}
	
}



