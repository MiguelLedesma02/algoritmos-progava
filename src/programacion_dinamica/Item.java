package programacion_dinamica;

public class Item {
	
	private int precio;
	private int peso;
	private String descripcion;
	
	public Item(int precio, int peso, String descripcion) {
		
		this.precio = precio;
		this.peso = peso;
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return this.precio;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
}
