package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Welsh_Powell {

    // ordeno los vértices por grado en orden decreciente
    public static List<Integer> ordenarPorGrado(int[][] grafo) {
        int n = grafo.length;
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vertices.add(i);
        }
        vertices.sort((v1, v2) -> degree(grafo, v2) - degree(grafo, v1));
        return vertices;
    }

    //Obtengo el grado de un vértice
    public static int degree(int[][] grafo, int vertice) {
        int degree = 0;
        for (int i = 0; i < grafo[vertice].length; i++) {
            if (grafo[vertice][i] == 1) {
                degree++;
            }
        }
        return degree;
    }

    public static int[] welshPowell(int[][] grafo) {
        int n = grafo.length;
        List<Integer> vertices = ordenarPorGrado(grafo);
        int[] color = new int[n];
        Arrays.fill(color, -1);  // -1 indica que el vértice aún no ha sido coloreado

        int colorActual = 0;

        for (int vertice : vertices) {
            if (color[vertice] == -1) {  // Si el vértice no fue coloreado
                color[vertice] = colorActual;

                // Colorear todos los vértices no adyacentes con el mismo color
                for (int adyacente : vertices) {
                    if (color[adyacente] == -1 && !tieneAdyacentePintado(grafo, color, adyacente, colorActual)) {
                        color[adyacente] = colorActual;
                    }
                }

                colorActual++;
            }
        }

        return color;
    }

    // Método para verificar si un vértice adyacente tiene el mismo color
    public static boolean tieneAdyacentePintado(int[][] graph, int[] color, int vertice, int colorActual) {
        for (int i = 0; i < graph[vertice].length; i++) {
            if (graph[vertice][i] == 1 && color[i] == colorActual) {
                return true;
            }
        }
        return false;
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

        int[] coloreo = welshPowell(graph);
        for (int i = 0; i < coloreo.length; i++) {
            System.out.println("Vertice " + i + " --->  Color " + coloreo[i]);
        }
    }
}
