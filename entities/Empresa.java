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
	
	
	//Relativo ao Exerc�cio 6
	//L�gica: La�o de repeti��o para percorrer os departamentos pedindo para que cada departamento some 
	// as idades dos seus funcion�rios e gerente. O retorno do m�todo � acumulado na vari�vel idadeTotal.
	public void somarIdadesPessoas(){
		int idadeTotal = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			idadeTotal = idadeTotal + this.getDepartamentos()[i].somarIdadesPessoasDepartamento();		
		}
		System.out.println("O somat�rio das idades de todos os Departamentos � igual a " + idadeTotal + ".");
	}
	
	
	//Relativo ao Exerc�cio 7
	//L�gica: La�o de repeti��o para percorrer os departamentos pedindo para que cada departamento  
	// informe quem � a pessoa mais idosa e a mais nova do departamento. 
	//O resultado � impresso para cada departamento da empresa.
	public void identificarPessoaMaisNovaMaisVelhaPorDepartamento() {
		for(int i = 0; i < this.getDepartamentos().length; i++) {
			Departamento depto = this.getDepartamentos()[i];
			Pessoa pessoaMaisNova = depto.obterPessoaMaisNovaPorDepartamento();
			System.out.println("A pessoa mais nova do departamento de " + depto.getArea() + " �: \n" + pessoaMaisNova.toString());
			Pessoa pessoaMaisIdosa = depto.obterPessoaMaisIdosaPorDepartamento();
			System.out.println("A pessoa mais idosa do departamento de " + depto.getArea() + " �: \n" + pessoaMaisIdosa.toString());
		}
	}
	
	
	//Relativo ao Exerc�cio 8
	//L�gica: La�o de repeti��o para percorrer os departamentos pedindo para que cada departamento  
	// informe quem � a pessoa mais idosa e a mais nova do departamento. A medida que cada departamento
	// devolve a pessoa � feita a compara��o com a pessoa do outro departamento. 
	//Ao terminar o la�o de repeti�ao se tem a pessoa mais idosa e nova da empresa e o resultado � impresso. 
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
		System.out.println("A pessoa mais nova da empresa � do " + areaPessoaMaisNova + " �: \n" + pessoaMaisNova.toString());
		System.out.println("A pessoa mais idosa da empresa � do " + areaPessoaMaisIdosa + " �: \n" + pessoaMaisIdosa.toString());
	}
	
	
	//Relativo ao Exerc�cio 9
	//L�gica: La�o de repeti��o para percorrer os departamentos pedindo para que cada departamento informe 
	// quantos homens e quantas mulheres o departamento possui. 
	// Os retornos desses m�todos s�o acumulados nas vari�veis qtdeHomensDep e qtdeMulheresDep.
	// O m�todo imprime esses valores e na sequ�ncia acumula as informa��es nas vari�veis qtdeHomens e qtdeMulheres
	// para contabilizar os valores de toda a empresa. Ap�s o la�o � impressa essas informa��es.
	public void calcularPercentualPessoas(){
		int qtdeHomens = 0;
		int qtdeMulheres = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			int qtdeHomensDep = this.getDepartamentos()[i].contabilizarQuantidadeHomens();
			int qtdeMulheresDep = this.getDepartamentos()[i].contabilizarQuantidadeMulheres();
			System.out.println("O Total de Homens do " + this.getDepartamentos()[i].getArea() + " �: " + qtdeHomensDep);
			System.out.println("O Total de Mulheres do " + this.getDepartamentos()[i].getArea() + " �: " + qtdeMulheresDep);
			qtdeHomens = qtdeHomens + qtdeHomensDep;
			qtdeMulheres = qtdeMulheres + qtdeMulheresDep;
		}
		System.out.println("O Percentual de Homens da Empresa �: " + (qtdeHomens * 100/(qtdeHomens+qtdeMulheres)) + "%.");
		System.out.println("O Percentual de Mulheres da Empresa �: " + (qtdeMulheres * 100/(qtdeHomens+qtdeMulheres)) + "%.");
	}
	
	
	//Relativo ao Exerc�cio 10.
	//L�gica: La�o de repeti��o para percorrer os departamentos pedindo para que cada departamento identifique
	// as pessoas (funcion�rio e gerente) que moram na cidade informada.
	// O pr�prio departamento ir� imprimir as informa��es.
	public void identificarPessoasPorCidade(String cidade){
		System.out.println("Pessoas que moram na cidade de " + cidade + ":");
		for(int i = 0; i < this.getDepartamentos().length; i++){
			this.getDepartamentos()[i].identificarPessoasDepartamentoPorCidade(cidade);
		}
	}
	
	
	//Relativo ao Exerc�cio 11 - Letra D.
	//L�gica: La�o de repeti��o para percorrer os departamentos pedindo para que cada departamento calcule
	// os impostos do departamento. O retorno desse m�todo � acumulado na vari�vel impostoTotal.
	// O pr�prio departamento ir� imprimir as informa��es.
	public void calcularImposto(){
		DecimalFormat df = new DecimalFormat("0.00");
		double impostoTotal = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			impostoTotal = impostoTotal + this.getDepartamentos()[i].calcularImpostoPorDepartamento();
		}
		System.out.println("O imposto mensal referente a sal�rio � de R$ " + df.format(impostoTotal));
	}
	
	
	//Relativo ao Exercicio 11 - Letra E
	//L�gica: Esse m�todo utiliza-se de dois m�todos de apoio nesta mesma classe.
	// Esses m�todos de apoio j� retornam o salario de todos os gerentes e de todos os funcion�rios.
	public void calcularSalarioTotalEmpresa(){
		DecimalFormat df = new DecimalFormat("0.00");
		double salarioGerente = obterTotalSalarioGerentes();
		double salarioFuncionario = obterTotalSalarioFuncionarios();
		System.out.println("O total de Salarios (Gerentes e Funcion�rios) � de R$ " + df.format(salarioFuncionario + salarioGerente));
	}
	
	
	//Relativo ao Exerc�cio 11 - Letra F
	//L�gica: Como foi desenvolvido um m�todo para calcular o sal�rio de todos os gerentes para atender o exerc�cio da Letra E,
	// basta nesse exerc�cio aproveitar o mesmo m�todo.
	public void calcularSalarioTotalGerentes(){
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("O valor a ser pago para os Gerentes � de R$ "+ df.format(obterTotalSalarioGerentes()));
	}
	
	
	//Relativo ao Exerc�cio 11 - Letra F
	//L�gica: Como foi desenvolvido um m�todo para calcular o sal�rio de todos os funcion�rios para atender o exerc�cio da Letra E,
	// basta nesse exerc�cio aproveitar o mesmo m�todo.
	public void calcularSalarioTotalFuncionarios(){
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("O valor a ser pago para aos Funcion�rios � de R$ "+ df.format(obterTotalSalarioFuncionarios()));
	}
	
	
	//Relativo ao Exerc�cio 11 - Letra E e F
	//M�todo de Apoio (PRIVATE). 
	//L�gica: Esse m�dodo de apoio � privado e tem como objetivo percorrer os departamentos e acumular os 
	// sal�rios dos gerentes e retornar essa informa��o para o m�todo chamador.
	private double obterTotalSalarioGerentes(){
		double salarioTotal = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			salarioTotal = salarioTotal + this.getDepartamentos()[i].getGerente().calcularSalario();
		}
		return salarioTotal;
	}
	
	
	//Relativo ao Exerc�cio 11 - Letra E e F
	//M�todo de Apoio (PRIVATE). 
	//L�gica: Esse m�dodo de apoio � privado e tem como objetivo percorrer os departamentos e acumular os 
	// sal�rios dos funcion�rios e retornar essa informa��o para o m�todo chamador.
	private double obterTotalSalarioFuncionarios(){
		double salarioTotal = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			for(int j = 0; j < this.getDepartamentos()[i].getFuncionarios().length; j++){
				salarioTotal = salarioTotal + this.getDepartamentos()[i].getFuncionarios()[j].calcularSalario();
			}
		}
		return salarioTotal;
	}
	
	
	//Relativo ao Exerc�cio 11 - Letra G.
	//L�gica: Desenvolvido dois m�todos que fazem o c�culo do sal�rio l�quido do gerente e do funcion�rio.
	//Se utilizou dois la�os de repeti��o para percorrer os departamentos pegando gerente e funcion�rios.
	public void calcularSalarioLiquido(){
		for(int i = 0; i < this.getDepartamentos().length; i++){
			this.getDepartamentos()[i].getGerente().calcularSalarioLiquidoGerente();
			for(int j = 0; j < this.getDepartamentos()[i].getFuncionarios().length; j++){
				this.getDepartamentos()[i].getFuncionarios()[j].calcularSalarioLiquidoFuncionario();
			}
		}
	}
	
	
	//Relativo ao Exerc�cio 11 - Letra J.
	//L�gica: La�o de repeti��o para percorrer os departamentos e acumular o valor da meta de cada departamento.
	public void calcularMetaTotal(){
		DecimalFormat df = new DecimalFormat("0.00");
		double metaTotal = 0;
		for(int i = 0; i < this.getDepartamentos().length; i++){
			metaTotal = metaTotal + this.getDepartamentos()[i].getMeta();
		}
		System.out.println("A meta total da empresa " + this.getNome() + " � R$ " + df.format(metaTotal));
	}
	
	
	//Relativo ao Exerc�cio 14
	//L�gica: Como o exerc�cio pede o maior sal�rio de gerente e funcion�rio da empresa, criou-se os objetos funcion�rio e gerente
	// para guardar a informa��o. Como esse funcion�rio e gerente pode ser de qualquer departamento tamb�m se identificou o departamento
	// atrav�s da vari�vel local area (gerente e funcion�rio).
	// � usado um m�todo identificarPessoaMaiorSalarioDepartamento que retorna o maior sal�rio entre os funcion�rio do departamento.
	// S�o feitas compara��es entre os gerentes dos departamentos e tamb�m entre os funcion�rios dos departamentos para se ter o maior 
	// sal�rio entre gerentes e entre funcion�rios.
	// Por fim s�o impressas as informa��es.
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
		System.out.println("\nO Gerente com o maior sal�rio � o " + gerente.getNome() + " do Departamento " + areaGerente + " com o Sal�rio de " + df.format(gerente.getSalario()));
		System.out.println("\nO Funcion�rio com o maior sal�rio � o " + funcionario.getNome() + " do Departamento " + areaFuncionario + " com o Sal�rio de " + df.format(funcionario.getSalario()));
	}
	
	
	//Relativo ao Exerc�cio 15
	//L�gica: Como o exerc�cio pede o menor sal�rio de gerente e funcion�rio da empresa, criou-se os objetos funcion�rio e gerente
	// para guardar a informa��o. Como esse funcion�rio e gerente pode ser de qualquer departamento tamb�m se identificou o departamento
	// atrav�s da vari�vel local area (gerente e funcion�rio).
	// � usado um m�todo identificarPessoaMenorSalarioDepartamento que retorna o menor sal�rio entre os funcion�rio do departamento.
	// S�o feitas compara��es entre os gerentes dos departamentos e tamb�m entre os funcion�rios dos departamentos para se ter o menor 
	// sal�rio entre gerentes e entre funcion�rios.
	// Por fim s�o impressas as informa��es.
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
		System.out.println("\nO Gerente com o menor sal�rio � o " + gerente.getNome() + " do Departamento " + areaGerente + " com o Sal�rio de " + df.format(gerente.getSalario()));
		System.out.println("\nO Funcion�rio com o menor sal�rio � o " + funcionario.getNome() + " do Departamento " + areaFuncionario + " com o Sal�rio de " + df.format(funcionario.getSalario()));
	}
	
	
	//Relativo ao Exercicio 16
	//L�gica: Esse m�todo se utiliza de um m�todo de apoio para verificar se o nome do contato a ser procurado � um gerente ou funcion�rio.
	// Se for gerentes ele executa um la�o de repeti��o nos departamentos pegando apenas os gerentes para imprimir o contato.
	// Se for funcion�rio ele executa um la�o de repeti��o nos departamentos pegando apenas os funcion�rios para imprimir o contato.
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
	
	
	//M�todo de apoio privado que verificar se um dado nome � um gerente ou n�o.
	private boolean verificarGerente(String nome){
		for(int i = 0; i < this.getDepartamentos().length; i++){
			if (nome.equals(this.getDepartamentos()[i].getGerente().getNome())){
				return true;
			}
		}
		return false;
	}
	
}



