package exercicio;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {
	
	private static ArrayList<Livro> livrosList = new ArrayList<>(); //
    private static ArrayList<Funcionario> funcionariosList = new ArrayList<>();

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
        int escolha = 0;
        
        
        do {
        	System.out.println("Sistema Biblioteca\nO que deseja fazer?\n1 - Menu Livros | 2 - Menu cadastro | 0 - Encerrar");
        	escolha = entrada.nextInt();
            switch (escolha) {
                case 1:
                	livroMenu();
                    break;
                case 2:
                	cadastroMenu();
                    break;
                case 0:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
                    break;
            }
        } while (escolha != 0);

        entrada.close();
    

	}

	private static void cadastroMenu() {
		Scanner entrada2 = new Scanner(System.in);
        int escolha2 = 0;
        
        
        do {
        	System.out.println("\nMenu cadastro\nO que deseja fazer?\n1 - Cadastrar Livro | 2 - Cadastrar Funcionário | 0 - Retornar");
        	escolha2 = entrada2.nextInt();
            switch (escolha2) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 0:
                    System.out.println("Retornando...");
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
                    break;
            }
        } while (escolha2 != 0);
	}
	private static void livroMenu() {
		Scanner entrada2 = new Scanner(System.in);
        int escolha2 = 0;

        do {
        	 System.out.println("\nMenu Livros\nO que deseja fazer?\n1 - Emprestar | 2 - Devolver | 3 - Tornar Indisponível | 4 - Tornar Disponivel | 5 - Consultar |0 - Retornar");
        	escolha2 = entrada2.nextInt();
            switch (escolha2) {
                case 1:
                    emprestarLivro();
                    break;
                case 2:
                    devolverLivro();
                    break;
                case 3:
                    livroIndisponivel(); //a
                    break;
                case 4:
                    livroDisponivel(); //a
                    break;
                case 5:
                	consultarLivro();
                case 0:
                    System.out.println("Retornando...");
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
                    break;
            }
        } while (escolha2 != 0);
		
	}

	private static void consultarLivro() {
        Livro livro = buscarFormas();
        System.out.println(livro.toString());
		
	}
	private static void livroDisponivel() {
		Livro livro = buscarFormas();
        livro.setEstado(0);
	}
	private static void livroIndisponivel() {
		Livro livro = buscarFormas();
        livro.setEstado(0);
        
	}

	private static void devolverLivro() {
		Livro livro = buscarFormas();
        
		Scanner entradaSub = new Scanner(System.in);
        System.out.println("O livro está em bom estado?\n1 - Sim | 2 - Não");
        int escolhaSub = entradaSub.nextInt();
        switch(escolhaSub) {
        case 1:
        	livro.setEstado(1);
        	System.out.println("Devolvido com sucesso");
        	break;
        case 2:
        	livro.setEstado(0);
        	System.out.println("Livro Indisponivel");
        	break;
        default:
        	System.out.println("Escolha uma opção válida");
        	break;
        }
        
        
        

	}

	private static void emprestarLivro() {
		
        Livro livro = buscarFormas();
        livro.setEstado(2);
        
		
	}
	

	private static void cadastrarFuncionario() {
		Scanner entradaFunc = new Scanner(System.in);
		
		System.out.println("Digite o nome do Funcionario:");
		String nome = entradaFunc.next();
		
		System.out.println("Digite o numero da OAB (Caso não exista responda em branco):");
		String numeroOAB = entradaFunc.next();
		
		System.out.println("Digite o cargo do funcionario:");
		String cargo = entradaFunc.next();
		
		
		Funcionario func = new Funcionario(nome, numeroOAB, cargo);
		funcionariosList.add(func);
		
		System.out.println("Funcionario cadastrado");
		System.out.println(func.toString());
		
		return;
	}

	private static void cadastrarLivro() {
		Scanner entradaLivro = new Scanner(System.in);
		Scanner entradaLivro2 = new Scanner(System.in);
		
		System.out.println("Digite o nome do livro:");
		String nome = entradaLivro.nextLine();
		
		System.out.println("Digite a matrícula do dono:");
		int matriculaDono = entradaLivro2.nextInt();
		
		System.out.println("Digite o nome da editora:");
		String editora = entradaLivro.nextLine();
		
		System.out.println("Digite a área do livro:");
		String area = entradaLivro.nextLine();
		
		System.out.println("Digite o nome do autor:");
		String nomeAutor = entradaLivro.nextLine();
		
		System.out.println("Digite o preço do livro:");
		String preco = entradaLivro.nextLine();
		
		Livro livro = new Livro(nome, nomeAutor, editora, area, matriculaDono, preco);
		livrosList.add(livro);
		
		System.out.println("Livro cadastrado");
		
		System.out.println(livro.toString());
		
		return;
		
	}
	
	
	
	
	private static Livro buscarLivroPorCodigo(int codigo) {
	    for (Livro livro : livrosList) {
	        if (livro.getCod() == codigo) {
	            return livro;
	        }
	    }
	    return null; // 
	}
	
	

	private static Livro buscarLivroPorNome(String nome) {
	    for (Livro livro : livrosList) {
	        if (livro.getNome().equalsIgnoreCase(nome)) {
	            return livro;
	        }
	    }
	    return null; 
	}

	private static Livro buscarLivroPorAutor(String autor) {
	    for (Livro livro : livrosList) {
	        if (livro.getAutor().equalsIgnoreCase(autor)) {
	            return livro;
	        }
	    }
	    return null; 
	}


	private static Livro buscarFormas() {
		Scanner entradaSub = new Scanner(System.in);
        int escolhaSub = 0;
        Livro livro = new Livro(); 
        
		System.out.println("Digite a forma de perquisa:\n1 - Nome | 2 - Código | 3 - Autor");
        escolhaSub = entradaSub.nextInt();
		
        
        switch(escolhaSub){
        case 1:
        	System.out.println("Digite o nome do Livro:");
        	Scanner a = new Scanner(System.in);
        	String nome = a.next();
        	livro = buscarLivroPorNome(nome);
        	break;
        case 2:
        	System.out.println("Digite o Código do Livro:");
        	Scanner b = new Scanner(System.in);
        	int code = b.nextInt();
        	livro = buscarLivroPorCodigo(code);
        	break;
        case 3:
        	System.out.println("Digite o nome do Livro:");
        	Scanner c = new Scanner(System.in);
        	String autor = c.next();
        	livro = buscarLivroPorNome(autor);
        	break;
        default:
        	System.out.println("Escolha uma opção válida");
        	break;
        }
        
        return livro;
		
	}
}

