package ex2;
import java.util.Scanner;

public class Fibonacci1 {

    public static int fibonacci(int posFib) {
        if (posFib < 2) {
            return posFib; 
        }else{
            return fibonacci(posFib - 1) + fibonacci(posFib - 2);
        }
    }

    public static void main(String[] args) {
        int posicao_fib;
        int resposta;
        Scanner ler = new Scanner (System.in);

        System.out.println("FIBONACCI");
        System.out.println("Insira qual posição do número de Fibonacci deseja encontrar:");
        posicao_fib = ler.nextInt();

        resposta = fibonacci(posicao_fib);
        System.out.println("O número é " + resposta);
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