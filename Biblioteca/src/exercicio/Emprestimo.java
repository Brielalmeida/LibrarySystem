package exercicio;

import java.time.LocalDate;

public class Emprestimo implements EstadoInt{

	private int matriculaColaborador;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	
	
	public Emprestimo(int matriculaColaborador) {
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(5);
        this.matriculaColaborador = matriculaColaborador;
    }
	
	@Override
	public String name() {
		return "Empréstimo\nMatrícula :" + this.matriculaColaborador + "\nEmpréstimo: " + this.dataEmprestimo + "\nDevolução: " + this.dataDevolucao;
	}

	@Override
	public int check() {
		return 2;
	}
	

}
