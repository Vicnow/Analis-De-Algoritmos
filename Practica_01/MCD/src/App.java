import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
    

    int[] arregloFibonacci = App.fibonacciArray(10);

    int numero1 = 40;
    int numero2 = 40;

    int maximoComunDivisor = App.maximoComunDivisor(numero1, numero2);
    System.out.println("Maximo común divisor de: " +numero1+" , "+numero2+ " = " + maximoComunDivisor);

    }

    public static int[] fibonacciArray(int size){
        int arreglo[] = new int[size];
        int f = 0;
        int t1 = 1;
        int t2;
        for (int i = 0; i < arreglo.length; i++) {
            t2 = f;
            f = t1 + f;
            t1 = t2;
            arreglo[i] = t1;
        }
        return arreglo;
    }

    public static int randomFibanoacciPosition(int arreglo[]){
        int position;
        position = arreglo[App.getRandomNumberUsingInts(0, arreglo.length)];
        return position;
    }

    public static int maximoComunDivisor(int num1, int num2) {
        int a = Math.max(num1,num2);
        int b = Math.min(num1,num2);
        int temporal = 0;
        while (b != 0) {
            temporal = b;
            b = a % b;
            a = temporal;
        }
        return temporal;
    }

    //Función que regresa números aleatorios entre un rango
    public static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
          .findFirst()
          .getAsInt();
    }
}
