package programacion_dinamica;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Mochila {
	
	private static int sinPD = 0;
	private static int conPD = 0;

	public static void main(String[] args) {
		
		int c = 10;
		
		Item i1 = new Item(200, 3, "Estereo");
		Item i2 = new Item(300, 3, "Laptop");
		Item i3 = new Item(150, 1, "Guitarra");
		Item i4 = new Item(500, 6, "Cuadro");
		Item i5 = new Item(200, 2, "Vestido");
		
		List<Item> items = new ArrayList<>();
		items.add(i1);
		items.add(i2);
		items.add(i3);
		items.add(i4);
		items.add(i5);
		
		System.out.println("Botin - Llamadas");
		System.out.println(robarSinPD(c, items) + " - " + sinPD);
		System.out.println(robarConPD(c, items) + " - " + conPD);
		
	}
	
	public static int robarConPD(int c, List<Item> items) {
		
		Map<Integer, Map<List<Item>, Integer>> memo = new HashMap<>();
		
		return robarMaskConPD(c, items, memo);
	}
	
	public static int robarMaskConPD(int c, List<Item> items, Map<Integer, Map<List<Item>, Integer>> memo) {
		
		conPD ++;
		
		//Si no hay items por robar, el botin es cero
		if(items.isEmpty())
			return 0;
		
		if(memo.containsKey(c) && memo.get(c).containsKey(items))
			return memo.get(c).get(items);
		
		Item itemActual = items.get(0);
		if(items.size() == 1 && c >= itemActual.getPeso())
			return itemActual.getPrecio();
		
		List<Item> aux = new ArrayList<>();
		aux.addAll(items);
		aux.remove(itemActual);
				
		int botinAlNoRobar = 0;
		int botinAlRobar = 0;
		
		botinAlNoRobar = robarMaskConPD(c, aux, memo);
		
		if(c-itemActual.getPeso() >= 0)
			botinAlRobar = robarMaskConPD(c-itemActual.getPeso(), aux, memo) + itemActual.getPrecio();
		
		//Se elige el botin maximo entre robar o no robar este item
		int botin = Math.max(botinAlNoRobar, botinAlRobar);
		
		if(!memo.containsKey(c)) {
			Map<List<Item>, Integer> mapaAux = new HashMap<>();
			memo.put(c, mapaAux);			
		}
		
		memo.get(c).put(items, botin);
		
		return botin;
	}
	
	public static int robarSinPD(int c, List<Item> items) {
		
		sinPD ++;
	
		//Si no hay items por robar, el botin es cero
		if(items.isEmpty())
			return 0;
		
		Item itemActual = items.get(0);
		if(items.size() == 1 && c >= itemActual.getPeso())
			return itemActual.getPrecio();
		
		List<Item> aux = new ArrayList<>();
		aux.addAll(items);
		aux.remove(itemActual);
				
		int botinAlNoRobar = 0;
		int botinAlRobar = 0;
		
		botinAlNoRobar = robarSinPD(c, aux);
		
		if(c-itemActual.getPeso() >= 0)
			botinAlRobar = robarSinPD(c-itemActual.getPeso(), aux) + itemActual.getPrecio();
		
		//Se elige el botin maximo entre robar o no robar este item
		int botin = Math.max(botinAlNoRobar, botinAlRobar);
		
		return botin;
	}
	
}
