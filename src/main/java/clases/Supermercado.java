package clases;

public class Supermercado {

	private int id;
	private String nombre;
	
	public Supermercado() {
		super();
	}

	public Supermercado(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
