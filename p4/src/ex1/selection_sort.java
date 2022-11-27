package ex1;

import java.util.Scanner;

public class selection_sort {
    public static void selectionSort(int[] vetor) {
        int min, aux;
        for (int i = 0; i < vetor.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[min]) {
                    min = j;
                }
            }
            aux = vetor[min];
            vetor[min] = vetor[i];
            vetor[i] = aux;
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

        System.out.println("SELECTION SORT");
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
        selectionSort(vet_desordenado);
        imprime_vetor(vet_desordenado);

        ler.close();
    }
}
// % Entrada: vetor com n coordenadas, A.
// % Sa´ıda: vetor ordenado em ordem n˜ao decrescente.
// Para i = 1, . . . , (n − 1)
// min := i.
// Para j = (i + 1), . . . , n
// Se A(j) < A(min)
// ent˜ao min := j.
// Fim de se-ent˜ao.
// Fim de para.
// x := A(min).
// A(min) := A(i).
// A(i) := x.
// Fim de para.