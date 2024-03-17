package exercicio;

public class Funcionario {
	
	private int matricula;
	private static int proxMatricula = 1;
	private String nome;
	private String numeroOAB;
	private String cargo;
	
	Funcionario(String nome, String numeroOAB, String cargo) {
		
		this.nome = nome;
		this.numeroOAB = numeroOAB;
		this.matricula = gerarMatricula();
		this.cargo = cargo;
		
		
	}
	
	private int gerarMatricula() {
        int code = this.proxMatricula;
        proxMatricula++;
        return code;
    }
	
	public int getMatricula() {
		return this.matricula;
	}
	
	@Override
	public String toString() {
		return "\nNome: " + this.nome + "\nMatricula: "+ this.matricula +"\nCargo: " + this.cargo+ "\n";
	}

}
