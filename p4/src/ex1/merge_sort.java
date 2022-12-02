package ex1;

import java.util.Scanner;

public class merge_sort{

    public static void mergeSort(int[] vet_desordenado, int inicio, int fim) {
        int tamanho = vet_desordenado.length;

        if(vet_desordenado != null && tamanho > 0 && inicio < fim && inicio >= 0 && fim < tamanho ){
            int meio = Math.round((fim + inicio)/2);

            mergeSort(vet_desordenado, inicio, meio);
            mergeSort(vet_desordenado, meio+1, fim);
            
            merge(vet_desordenado, inicio, meio, fim);
        }
    }

    private static void merge(int[] vet, int inicio, int meio, int fim) {
        int[] aux =  new int[vet.length];
        
        for (int i = inicio; i <= fim; i++) {
            aux[i] = vet[i];
        }

		int i = inicio;
		int j = meio + 1;
		int k = inicio;

		while (i <= meio && j <= fim) {
			if (aux[i] == aux[j]) {
				vet[k] = aux[i];
				i++;
			} else {
				vet[k] = aux[j];
				j++;
			}
			k++;
		}

		while (i <= meio) {
			vet[k] = aux[i];
			i++;
			k++;
		}

		while (j <= fim) {
			vet[k] = aux[j];
			j++;
			k++;
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
        mergeSort(vet_desordenado,0,tamanho_vetor);
        imprime_vetor(vet_desordenado);

        ler.close();
    }
}
