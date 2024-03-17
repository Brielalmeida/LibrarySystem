package exercicio;

public class Disponivel implements EstadoInt{

	@Override
	public String name() {
		return "Disponível";
	}

	@Override
	public int check() {
		return 1;
	}

	
}
