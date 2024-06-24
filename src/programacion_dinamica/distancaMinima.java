package programacion_dinamica;

public class distancaMinima {
    public static int distancia(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Creamos una matriz para almacenar los resultados de los subproblemas.
        int[][] dp = new int[m + 1][n + 1];

        // Llenamos la primera fila y la primera columna con las distancias de edición.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Calculamos las distancias de edición para los subproblemas restantes.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Si los caracteres son iguales, no se necesita ninguna operación.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Si los caracteres son diferentes, consideramos las operaciones de inserción, borrado o sustitución.
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }

        // El resultado final estará en la esquina inferior derecha de la matriz.
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "inside";
        String word2 = "index";
        int distance = distancia(word1, word2);
        System.out.println("La distancia de edición entre '" + word1 + "' y '" + word2 + "' es: " + distance);
    }
}
