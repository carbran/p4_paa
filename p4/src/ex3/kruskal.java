package ex3;

import java.util.*;

// criar a árvore geradora mínima do grafo fornecido
class grafo {
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
  grafo(int v, int a) {
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
    int vertices = 6; // número de vértices (Cidades)
    int arestas = 15; // número de arestas (distâncias)
    grafo G = new grafo(vertices, arestas);

    // L - CM
    G.aresta[0].origem = 0;
    G.aresta[0].destino = 1;
    G.aresta[0].peso = 5558;

    // L - NY
    G.aresta[1].origem = 0;
    G.aresta[1].destino = 2;
    G.aresta[1].peso = 3469;

    // L - Pa
    G.aresta[2].origem = 0;
    G.aresta[2].destino = 3;
    G.aresta[2].peso = 214;

    // L - Pe
    G.aresta[3].origem = 0;
    G.aresta[3].destino = 4;
    G.aresta[3].peso = 5074;

    // L -  T
    G.aresta[4].origem = 0;
    G.aresta[4].destino = 5;
    G.aresta[4].peso = 5959;

    // CM - NY
    G.aresta[5].origem = 1;
    G.aresta[5].destino = 2;
    G.aresta[5].peso = 2090;

    // CM - Pa
    G.aresta[6].origem = 1;
    G.aresta[6].destino = 3;
    G.aresta[6].peso = 5725;

    // CM - Pe
    G.aresta[7].origem = 1;
    G.aresta[7].destino = 4;
    G.aresta[7].peso = 7753;
    
    // CM - T
    G.aresta[8].origem = 1;
    G.aresta[8].destino = 5;
    G.aresta[8].peso = 7035;
    
    // NY - Pa
    G.aresta[9].origem = 2;
    G.aresta[9].destino = 3;
    G.aresta[9].peso = 3636;
    
    // NY - Pe
    G.aresta[10].origem = 2;
    G.aresta[10].destino = 4;
    G.aresta[10].peso = 6844;
    
    // NY - T
    G.aresta[11].origem = 2;
    G.aresta[11].destino = 5;
    G.aresta[11].peso = 6757;
    
    // Pa - Pe
    G.aresta[12].origem = 3;
    G.aresta[12].destino = 4;
    G.aresta[12].peso = 5120;
    
    // Pa - T
    G.aresta[13].origem = 3;
    G.aresta[13].destino = 5;
    G.aresta[13].peso = 6053;
    
    // Pe - T
    G.aresta[14].origem = 4;
    G.aresta[14].destino = 5;
    G.aresta[14].peso = 1307;
    
    G.AplicarKruskal();
  }
}