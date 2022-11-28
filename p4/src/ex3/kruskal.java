package ex3;

// https://www.programiz.com/dsa/kruskal-algorithm
// https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/

import java.util.*;

// criar a árvore geradora mínima do grafo fornecido
class kruskal {
  // criar uma aresta do grafo que implementa a interface Comparable
  class Aresta implements Comparable<Aresta> {
    int origem, destino, peso;

    public int compareTo(Aresta ArestaParaComparar) {
      return this.peso - ArestaParaComparar.peso;
    }
  };

  // classe para união
  class subconjunto {
    int pai, valor;
  };

  // inicializando vertices, arestas a vetor de arestas
  int vertices, arestas;
  Aresta aresta[];

  // usando costrutor para criar o grafo
  kruskal(int v, int a) {
    vertices = v;
    arestas = a;
    aresta = new Aresta[arestas];
    for (int i = 0; i < a; ++i)
      aresta[i] = new Aresta(); // criar a aresta para todas as arestas fornecidas
  }

  // método para encontrar o subconjunto de um elemento
  int encontrar(subconjunto subconjuntos[], int i) {
    if (subconjuntos[i].pai != i)
      subconjuntos[i].pai = encontrar(subconjuntos, subconjuntos[i].pai);
    return subconjuntos[i].pai;
  }

  // método para união de subconjuntos
  void Uniao(subconjunto subconjuntos[], int x, int y) {
    int xRaiz = encontrar(subconjuntos, x);
    int yRaiz = encontrar(subconjuntos, y);

    if (subconjuntos[xRaiz].valor < subconjuntos[yRaiz].valor)
      subconjuntos[xRaiz].pai = yRaiz;
    else if (subconjuntos[xRaiz].valor > subconjuntos[yRaiz].valor)
      subconjuntos[yRaiz].pai = xRaiz;
    else {
      subconjuntos[yRaiz].pai = xRaiz;
      subconjuntos[xRaiz].valor++;
    }
  }

  // aplicar kruskal
  void AplicarKruskal() {

    // inicializando o vetor para salvar a Árvore Geradora Mínima 
    Aresta resultado[] = new Aresta[vertices];
    int e = 0;
    int i = 0;
    for (i = 0; i < vertices; ++i)
      resultado[i] = new Aresta();

    // ordenando as arestas
    Arrays.sort(aresta);

    // criar um vetor dos vértices do tipo Subconjunto para os subconjuntos de vértices
    subconjunto subconjuntos[] = new subconjunto[vertices];

    // alocando memória para criar o subconjunto dos vértices
    for (i = 0; i < vertices; ++i)
      subconjuntos[i] = new subconjunto();

    // usado para criar subconjunto com elemento único
    for (int v = 0; v < vertices; ++v) {
      subconjuntos[v].pai = v;
      subconjuntos[v].valor = 0;
    }
    i = 0;

    // selecionar a menor aresta e incrementar o índice para próxima iteração
    while (e < vertices - 1) {
      // criar um instância da aresta para a príxma aresta
      Aresta proximaAresta = new Aresta();
      proximaAresta = aresta[i++];
      int x = encontrar(subconjuntos, proximaAresta.origem);
      int y = encontrar(subconjuntos, proximaAresta.destino);

      // se a aresta não criar ciclo após incluí-la, adicionamos ela no resultado e incrementamos o índice
      if (x != y) {
        resultado[e++] = proximaAresta;
        Uniao(subconjuntos, x, y);
      }
    }
    for (i = 0; i < e; ++i)
      System.out.println(resultado[i].origem + " - " + resultado[i].destino + ": " + resultado[i].peso);
  }

  public static void main(String[] args) {
    int vertices = 6; // Number of vertices
    int arestas = 8; // Number of arestas
    kruskal G = new kruskal(vertices, arestas);

    G.aresta[0].origem = 0;
    G.aresta[0].destino = 1;
    G.aresta[0].peso = 4;

    G.aresta[1].origem = 0;
    G.aresta[1].destino = 2;
    G.aresta[1].peso = 4;

    G.aresta[2].origem = 1;
    G.aresta[2].destino = 2;
    G.aresta[2].peso = 2;

    G.aresta[3].origem = 2;
    G.aresta[3].destino = 3;
    G.aresta[3].peso = 3;

    G.aresta[4].origem = 2;
    G.aresta[4].destino = 5;
    G.aresta[4].peso = 2;

    G.aresta[5].origem = 2;
    G.aresta[5].destino = 4;
    G.aresta[5].peso = 4;

    G.aresta[6].origem = 3;
    G.aresta[6].destino = 4;
    G.aresta[6].peso = 3;

    G.aresta[7].origem = 5;
    G.aresta[7].destino = 4;
    G.aresta[7].peso = 3;
    G.AplicarKruskal();
  }
}

/* https://www.javatpoint.com/kruskal-algorithm-java
 //main() method starts  
    public static void main(String[] args) {  
          
        int v, e;  
        //create scanner class object to get input from user  
        Scanner sc = new Scanner(System.in);  
          
        //show custom message  
        System.out.println("Enter number of vertices: ");  
          
        //store user entered value into variable v  
        v = sc.nextInt();  
          
        //show custom message  
        System.out.println("Enter number of edges");  
          
        //store user entered value into variable e  
        e = sc.nextInt();  
          
        KruskalAlgorithm graph = new KruskalAlgorithm(v, e);        // use for creating Graph  
          
        for(int i = 0; i < e; i++){  
            System.out.println("Enter source value for edge["+ i +"]");  
            graph.edgeArray[i].source = sc.nextInt();  
              
            System.out.println("Enter destination value for edge["+ i +"]");  
            graph.edgeArray[i].destination = sc.nextInt();  
              
            System.out.println("Enter weight for edge["+i+"]");  
            graph.edgeArray[i].weight = sc.nextInt();  
        }  
          
        // call applyKruskal() method to get MST  
        graph.applyKruskal();  
    }  
}  
 */