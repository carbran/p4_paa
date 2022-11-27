package ex1;

import java.util.Scanner;
import java.util.Arrays;

public class merge_sort {
// % Entrada: vetor com n coordenadas, A.
// % Sa´ıda: uma vers˜ao ordenada desse vetor (n˜ao decrescente).
// Se n > 1
// ent˜ao retorna
// merge(mergesort(A[1, . . . , ⌊n/2⌋]),mergesort(A[1, . . . , ⌈n/2⌉])).
// sen˜ao retorna A
// Fim de se-ent˜ao-sen˜ao.
    public static int[] mergeSort(int[] vetor) {
        int tamanho = vetor.length;
        if(tamanho > 1){
            int[] vetor1 = Arrays.copyOfRange(vetor, 0, Math.round(tamanho/2));
            int[] vetor2 = Arrays.copyOfRange(vetor, 0, Math.round(tamanho/2));
            return merge(mergeSort(vetor1),mergeSort(vetor2));
        }else{
            return vetor;
        }
    }
// aqui o denota concatena¸c˜ao
//função merge(x[1, . . . , k], y[1, . . . , l]).
// Se k = 0, ent˜ao retorna y[1, . . . , l]. Fim de se-ent˜ao.
// Se l = 0, ent˜ao retorna x[1, . . . , k]. Fim de se-ent˜ao.
// Se x[1] ≤ y[1]
// ent˜ao retorna x[1] o merge(x[2, . . . , k], y[1, . . . , l]).
// sen˜ao retorna y[1] o merge(x[1, . . . , k], y[2, . . . , l]).
// Fim de se-ent˜ao-sen˜ao.
    private static int[] merge(int[] vet1, int[] vet2) {
        int tamanho1 = vet1.length;
        int tamanho2 = vet2.length;

        if (vet1[tamanho1-1] == 0) {
            return vet2;
        }
        if (vet2[tamanho2-1] == 0) {
            return vet1;
        }

        if (vet1[1] < vet2[1]) {
            int[] vet1_1 = Arrays.copyOfRange(vet1, 1, Math.round(tamanho1/2));
            //return vet1[1] + merge(vet1_1,vet2);
            return null; 
        } else {
            int[] vet2_1 = Arrays.copyOfRange(vet2, 1, Math.round(tamanho2/2));
            //return vet2[1] + merge(vet1,vet2_1);
            return null;
        }
    }

    public static void imprime_vetor(int[] vetor_imp) {
        for (int i = 0; i < vetor_imp.length; i++) {
            if(i == 0){
                System.out.print("[" + vetor_imp[i] + ", ");
            }else if(i < vetor_imp.length -1){
                System.out.print(vetor_imp[i] + ", ");
            }else{
                System.out.print(vetor_imp[i] + "]");
            }           
        }
    }

    public static void main(String[] args) {
        int tamanho_vetor;
        Scanner ler = new Scanner(System.in);

        System.out.println("MERGE SORT");
        System.out.println("Informe o tamanho do vetor:");
        tamanho_vetor = ler.nextInt();

        int[] vet_desordenado = new int[tamanho_vetor];

        System.out.println("\nGerando vetor de valores aleatórios entre 0 e 1000:");
        for (int i = 0; i < vet_desordenado.length; i++) {
            vet_desordenado[i] = (int)Math.round(Math.random() * 1000);
            // gera um número inteiro aleatório no intervalo de 0 até 10
        }
        imprime_vetor(vet_desordenado);

        System.out.println("\n\nOrdenando vetor:");
        mergeSort(vet_desordenado);
        imprime_vetor(vet_desordenado);

        ler.close();
    }
}
