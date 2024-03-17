package exercicio;

public class Indisponivel implements EstadoInt{
	
	private String motivo;
	
	Indisponivel(String motivo) {
		this.motivo = motivo;
	}
	
	@Override
	public String name() {
		return "Indisponível";
	}

	@Override
	public int check() {
		return 0;
	}

}
