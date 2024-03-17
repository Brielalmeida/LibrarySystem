package exercicio;

import java.util.Scanner;

public class Estado {
	
	public EstadoInt estado;
	
	public void mudarDisponivel() {
		if (estado.check() == 1) {
			System.out.println("Livro já está disponivel");
			return;
		}
		estado = new Disponivel();	
	}
	
	public void mudarIndisponivel(String motivo) {
		if (estado.check() == 0) {
			System.out.println("Livro já está Indisponível");
			return;
		}
		estado = new Indisponivel(motivo);
		
	}
	
	public void mudarEmprestimo() {
		Scanner a = new Scanner(System.in);;
		if (estado.check() == 2) {
			System.out.println("Livro já está em Emprestimo");
			return;
		}
		System.out.println("Digite a matrícula do colaborador que quer o empréstimo: ");
		int matricula = a.nextInt();
		estado = new Emprestimo(matricula);	
		System.out.println(estado.name());
	}
	
	public void iniciarEstado() {
		estado = new Disponivel();
	}
	
	String getEstado() {
		return estado.name();
	}

}
