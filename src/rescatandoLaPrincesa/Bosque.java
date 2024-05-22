package rescatandoLaPrincesa;

public class Bosque {
	
	private int[] dragones;
	private int[][] bosque;
	private int claroPrincipe;
	private int claroPrincesa;
	
	public Bosque(int[] dragones, int[][] bosque, int claroPrincipe, int claroPrincesa) {
		
		this.dragones = new int[dragones.length];
		this.dragones = dragones;
		
		this.bosque = new int[bosque.length][bosque.length];
		this.bosque = bosque;
	}

	public int[] getDragones() {
		return dragones;
	}

	public int[][] getBosque() {
		return bosque;
	}
}
