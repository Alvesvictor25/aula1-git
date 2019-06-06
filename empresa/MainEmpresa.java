package empresa;

import entities.Contato;
import entities.Departamento;
import entities.Empresa;
import entities.Endereco;
import entities.Funcionario;
import entities.Gerente;

public class MainEmpresa {

	public static void main(String[] args) {
	
		//Endereço dos Funcionários	
		Endereco endCarla = new Endereco("Rua das Margaridas", 34, "Ingleses", "Florianópolis", "Santa Catarina");
		Endereco endCintia = new Endereco("Rua das Rosas", 1150, "Aririú", "Palhoça", "Santa Catarina");
		Endereco endBruna = new Endereco("Rua das Esmeraldas", 522, "Pedra Branca", "Palhoça", "Santa Catarina");
		Endereco endZeca = new Endereco("Rua das Figueiras", 16, "Estreito", "Florianópolis", "Santa Catarina");
		Endereco endPedro = new Endereco("Rua dos Eucaliptos", 1255, "Barreiros", "São José", "Santa Catarina");
		Endereco endGuilherme = new Endereco("Rua dos Rubis", 15, "Barreiros", "São José", "Santa Catarina");
		Endereco endLuana = new Endereco("Rua das Ametistas", 5522, "Coqueiros", "Florianópolis", "Santa Catarina");
		
		//Endereço dos Gerentes
		Endereco endAna = new Endereco("Rua das Acácias", 200, "Campinas", "São José", "Santa Catarina");
		Endereco endPaulo = new Endereco("Rua dos Diamantes", 9, "Centro", "Biguaçú", "Santa Catarina");
		Endereco endTavares = new Endereco("Rua das Bromélias", 305, "Santa Mônica", "Florianópolis", "Santa Catarina");
		
		//Endereço da Empresa
		Endereco endEmpresa = new Endereco("Rua Siva Jardim", 360, "Centro", "Florianópolis", "Santa Catarina");
	
		//Contato dos Funcionarios
		Contato conCarla = new Contato("11111111", "111111119", "carla@sc.senac.br");
		Contato conCintia = new Contato("22222222", "222222229", "cintia@sc.senac.br");
		Contato conBruna = new Contato("33333333", "333333339", "bruna@sc.senac.br");
		Contato conZeca = new Contato("44444444", "444444449", "zeca@sc.senac.br");
		Contato conPedro = new Contato("55555555", "555555559", "pedro@sc.senac.br");
		Contato conGuilherme = new Contato("66666666", "666666669", "guilherme@sc.senac.br");
		Contato conLuana = new Contato("77777777", "777777779", "luana@sc.senac.br");
		Contato conAna = new Contato("88888888", "888888889", "ana@sc.senac.br");
		Contato conPaulo = new Contato("99999999", "999999999", "paulo@sc.senac.br");
		Contato conTavares = new Contato("10101010", "10101019", "tavares@sc.senac.br");
		
		//Funcioários do Departamento RH
		Funcionario funCarla = new Funcionario("Carla", 45, "01155083679",  'F', endCarla, conCarla, 2000.00);
		Funcionario funCintia = new Funcionario("Cintia", 32, "22751485899",  'F', endCintia, conCintia, 3000.00);
		
		//Funcionários do Departamento Comercial
		Funcionario funBruna = new Funcionario("Bruna", 29, "09876456781",  'F', endBruna, conBruna, 4000.00);
		Funcionario funZeca = new Funcionario("Zeca", 21, "02518492468",  'M', endZeca, conZeca, 5000.00);
		Funcionario funPedro = new Funcionario("Pedro", 33, "00137512290",  'M', endPedro, conPedro, 6000.00);
		
		//Funcionários do Departamento de TI
		Funcionario funGuilherme = new Funcionario("Guilherme", 25, "30134585818",  'M', endGuilherme, conGuilherme, 9000.00);
		Funcionario funLuana = new Funcionario("Luana", 30, "78901485451",  'F', endLuana, conLuana, 10000.00);
		
		//Gerentes dos Departamentos
		Gerente gerRH = new Gerente("Ana", 23, "07158483828",  'F', endAna, conAna, 1000.00);
		Gerente gerComercial = new Gerente("Paulo", 41, "31277448765",  'M', endPaulo, conPaulo, 7000.00);
		Gerente gerTI = new Gerente("Tavares", 52, "44555283569", 'M', endTavares, conTavares, 8000.00);
		
		//Pessoas dos Departamentos
		Funcionario[] funcionariosRH = {funCarla, funCintia};
		Funcionario[] funcionariosComercial = {funBruna, funZeca, funPedro};
		Funcionario[] funcionariosTI = {funGuilherme, funLuana};
				
		//Objetos Departamento
		Departamento dep1 = new Departamento("RH", -50000.00, funcionariosRH, gerRH);
		Departamento dep2 = new Departamento("Comercial", 220000.00, funcionariosComercial, gerComercial);
		Departamento dep3 = new Departamento("TI", 75000.00, funcionariosTI, gerTI);
		
		
		//Departamentos da Empresa
		Departamento[] departamentos = {dep1, dep2, dep3};
		Empresa empresa = new Empresa("Senac Florianópolis", 1234567890123456L, "www.sc.senac.br", departamentos, endEmpresa);        
		
		//Exercicio 6
		empresa.somarIdadesPessoas();
		System.out.println("\n------------------------------------------------\n");
		
		//Exercicio 7
		empresa.identificarPessoaMaisNovaMaisVelhaPorDepartamento();
		System.out.println("\n------------------------------------------------\n");
		
		//Exercicio 8
		empresa.identificarPessoaMaisNovaMaisVelha();
		System.out.println("\n------------------------------------------------\n");
		
		//Exercicio9
		empresa.calcularPercentualPessoas();
		System.out.println("\n------------------------------------------------\n");
		
		//Exercicio 10
		empresa.identificarPessoasPorCidade("Florianópolis");
		System.out.println("\n------------------------------------------------\n");
		
		//Exercício 11 - Letra D
		empresa.calcularImposto();
		System.out.println("\n------------------------------------------------\n");
		
		//Exercício 11 - Letra E
		empresa.calcularSalarioTotalEmpresa();
		System.out.println("\n------------------------------------------------\n");
		
		//Exercicio 11 - Letra F
		empresa.calcularSalarioTotalGerentes();
		empresa.calcularSalarioTotalFuncionarios();
		System.out.println("\n------------------------------------------------\n");
		
		//Exercício 11 - Letra G
		empresa.calcularSalarioLiquido();
		System.out.println("\n------------------------------------------------\n");
		
		//Exercício 11 - Letra J
		empresa.calcularMetaTotal();
		System.out.println("\n------------------------------------------------\n");
		
		//Exercício 14
		empresa.identificaMaioresSalarios();
		System.out.println("\n------------------------------------------------\n");
		
		//Exercicio 15
		empresa.identificaMenoresSalarios();
		System.out.println("\n------------------------------------------------\n");
		
		//Exercicio 16
		empresa.consultarContato("Tavares");
		empresa.consultarContato("Zeca");
		
	}
}




