package grafos;

import java.util.Arrays;

import java.util.Arrays;

public class ColoreoSecuencial_alpha {

    
    public static int[] coloreoSecuencial(int[][] grafo) {
        int n = grafo.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);  // -1 indica que el vértice aún no ha sido coloreado

        // Colorear cada vértice secuencialmente
        for (int vertice = 0; vertice < n; vertice++) {
            boolean[] coloresDisponibles = new boolean[n];
            Arrays.fill(coloresDisponibles, true);  // Todos los colores están inicialmente disponibles

            // Marcar colores de los vértices adyacentes como no disponibles
            for (int adyacente = 0; adyacente < n; adyacente++) {
                if (grafo[vertice][adyacente] == 1 && color[adyacente] != -1) {
                    coloresDisponibles[color[adyacente]] = false;
                }
            }

            // Encontrar el primer color disponible
            int colorAElegir;
            for (colorAElegir = 0; colorAElegir < n; colorAElegir++) {
                if (coloresDisponibles[colorAElegir]) {
                    break;
                }
            }

            // Asignar el color al vértice
            color[vertice] = colorAElegir;
        }

        return color;
    }

    public static void main(String[] args) {
        int[][] graph = {
            { 0, 1, 0, 0, 0, 1, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
            { 0, 1, 0, 1, 0, 0, 0, 0, 1, 0 },
            { 1, 0, 1, 0, 0, 0, 1, 0, 1, 1 },
            { 0, 0, 1, 0, 0, 1, 0, 0, 0, 1 },
            { 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 1, 1, 0, 1, 0, 1 },
            { 0, 0, 0, 0, 0, 1, 1, 0, 1, 0 }
        };

        int[] coloreo = coloreoSecuencial(graph);
        for (int i = 0; i < coloreo.length; i++) {
            System.out.println("Vertice " + i + " --->  Color " + coloreo[i]);
        }
    }

}
