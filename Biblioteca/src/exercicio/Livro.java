package exercicio;

import java.util.Scanner;

public class Livro {

	private String nome;
	private String autor;
	private String editora;
	private String area;
	private static int proxCod = 1;
	private int cod;
	private String preco;
	private int matriculaDono;
	public Estado estado;
	
	Livro (String nome, String nomeAutor, String editora, String area, int matriculaDono, String preco) {
		
		this.nome = nome;
		this.editora = editora;
		this.area = area;
		this.preco = preco;
		this.cod = gerarCodigo();
		this.matriculaDono = matriculaDono;
		this.autor = nomeAutor;
		this.estado = new Estado();
		this.estado.iniciarEstado();
	}
	
	public Livro() {
	}
	
	void setEstado(int estado) {
		
		this.estado = new Estado();
		this.estado.iniciarEstado();
		
		if(estado == 0) {
			System.out.println("Digite o motivo: ");
			Scanner b = new Scanner(System.in);
			String motivo = b.nextLine();
			this.estado.mudarIndisponivel(motivo);
			return;
		}
		
		if(estado == 1) {
			this.estado.mudarDisponivel();
		}
		
		if(estado == 2) {
			this.estado.mudarEmprestimo();
		}
	}

	private int gerarCodigo() {
        int code = this.proxCod;
        proxCod++;
        return code;
    }
	
	public int getCod() {
		return this.cod;
	}

	public String getNome() {
		return this.nome;
	}

	public String getAutor() {
		return this.autor;
	}
	
	@Override
	public String toString() {
		return "\nNome: " + this.nome + "\nCód: "+ this.cod +"\nAutor: " +this.autor+ "\nÁrea: " + this.area + "\nEstado: " + estado.getEstado()+ "\n";
	}
	
}
