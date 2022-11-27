package ex2;
import java.util.Scanner;

public class Fibonacci2 {

    public static void fibonacci(int[] vetorFib) {
        
        for (int i = 0; i < vetorFib.length; i++) {
            if (i < 2){
                vetorFib[i] = 1;
            }else{
                vetorFib[i] = vetorFib[i - 1] + vetorFib[i - 2];
            }
        }
    }

    public static void main(String[] args) {
        int posicao_fib;
        Scanner ler = new Scanner (System.in);

        System.out.println("FIBONACCI");
        System.out.println("Insira qual posição do número de Fibonacci deseja encontrar:");
        posicao_fib = ler.nextInt();

        int[] vetor_fib = new int[posicao_fib];

        fibonacci(vetor_fib);
        System.out.println("O número é " + vetor_fib[posicao_fib-1]);
        ler.close();
    }
}
// Algoritmo: Fibonacci.
// % Entrada: uma fun¸c˜ao F e um n´umero natural n.
// % Sa´ıda: n´umero de Fibonacci F(n).
// In´ıcio de fun¸c˜ao.
// Se n < 2
// ent˜ao F(n) := n.
// sen˜ao F(n) := F(n − 1) + F(n − 2).
// Fim de se-ent˜ao-sen˜ao.
// Fim de fun¸c˜ao.