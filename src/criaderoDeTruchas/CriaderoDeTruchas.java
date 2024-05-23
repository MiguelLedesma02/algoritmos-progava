package criaderoDeTruchas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriaderoDeTruchas {

	private Vertedero vertedero;
	private List<Estanque> estanques;
	
	CriaderoDeTruchas(List<Estanque> estanques){
		
		this.estanques = new ArrayList<Estanque>();
		try {
			this.estanques = estanques;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void asignarCañerias() {
		
		int profundidadCañeriaIzq = 0;
		for(Estanque estanque : this.estanques) {	
			
			estanque.setProfundidadCañeriaIzq(profundidadCañeriaIzq);
			profundidadCañeriaIzq = estanque.getProfundidadCañeriaIzq();
		}
	}
	
	public void llenar() {
		
		this.asignarCañerias();
		
		for(Estanque estanque : this.estanques) {	
			
			if(!estanque.estaLleno() && this.vertedero.getVolumenDeAgua() > 0) {
				
				int cañeriaMasBaja = estanque.getCañeriaMasBaja();
				if(cañeriaMasBaja == estanque.getProfundidadCañeriaDer()) {
					//Te vas a la der
					
					
				}
				else {
					//Te vas a la izq
				}
				
			}
		}
	}
}