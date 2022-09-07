import java.io.Console;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            int n = App.getRandomNumberUsingInts(0,40); 
            int arreglo[] = new int[n];
            int arregloDerecha[] = new int [n/2];
            int arregloIzquierda[] = new int [n/2];
            // Rellenamos el arreglo
            for (int j = 0; j < arreglo.length; j++) {
                arreglo[j] = App.getRandomNumberUsingInts(0,3*n);
            }
            //Asignamos los valores a cada mitad correspondiente
            for (int j = 0; j < arreglo.length /2; j++) {
                arregloDerecha[j] = arreglo[j];
            }
            int posicionIzquierda = arreglo.length/2;
            for (int j = 0; j < arreglo.length/2; j++) {
                arregloIzquierda[j] = arreglo[posicionIzquierda];
                posicionIzquierda++;  
            }
            
            //Coincidencias
            int contador = concurrenciasSubaareglosPeor(arregloIzquierda, arregloDerecha);
            System.out.println("("+arreglo.length+","+contador+")");
        }
    }

    //Función que regresa números aleatorios entre un rango
    public static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
        .findFirst()
        .getAsInt();
    }

    public static int concurrenciasSubaareglos(int[] aDer, int[] aIzq) {
        int contador = 1;
        contador++;
        for (int i = 0 ; i < aDer.length; i++) {contador++;contador++;
            for (int j = 0; j < aIzq.length; j++) {contador++;
                if (aDer[i]==aIzq[j]) {
                    contador++;
                    contador++;
                    return contador;
                }
            }
            contador++;
        }
        contador++;
        return contador;
    }

    public static int concurrenciasSubaareglosMejor(int[] aDer, int[] aIzq) {
        int contador = 1;
        contador++;
        for (int i = 0 ; i < aDer.length; i++) {contador++;contador++;
            for (int j = 0; j < aIzq.length; j++) {contador++;
                aDer[i]=aIzq[j];
                if (aDer[i]==aIzq[j]) {

                    contador++;
                    contador++;
                    return contador;
                }
            }
            contador++;
        }
        contador++;
        return contador;
    }
    public static int concurrenciasSubaareglosPeor(int[] aDer, int[] aIzq) {
        int contador = 1;
        contador++;
        for (int i = 0 ; i < aDer.length; i++) {contador++;contador++;
            for (int j = 0; j < aIzq.length; j++) {contador++;
                aDer[i]=aIzq[j]+1;
                if (aDer[i]==aIzq[j]) {
                    contador++;
                    contador++;
                    return contador;
                }
            }
            contador++;
        }
        contador++;
        return contador;
    }
}
