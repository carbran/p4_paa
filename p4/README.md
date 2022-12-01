# CMP1065 Projeto e Análise de Algoritmos I
## Prova 4

### **Questão 1**

Considere o problema de ordenação. Seja dado o algoritmo de ordenação por seleção, a saber:

Algoritmo: ordenação por seleção.
        
        % Entrada: vetor com n coordenadas, A.
        % Saída: vetor ordenado em ordem não decrescente.
        
        Para i = 1,..., (n − 1)
            min := i.
        
            Para j = (i + 1),..., n
                Se A(j) < A(min)
                    então min := j.
                Fim de se-então.
            Fim de para.
        
            x := A(min).
            A(min) := A(i).
            A(i) := x.
        Fim de para.

Ainda, seja dado o algoritmo de ordenação por mergesort, a saber:

Algoritmo: ordenação por mergesort.
        
        % Entrada: vetor com n coordenadas, A.
        % Saída: uma versão ordenada desse vetor (não decrescente).
        
        Se n > 1
            então retorna merge(mergesort(A[1,..., ⌊n/2⌋]),mergesort(A[1,..., ⌈n/2⌉])).
        senão 
            retorna A
        Fim de se-então-senão.

No algoritmo mergesort a função merge e como segue: 
(aqui o denota concatenação)

        Função merge(x[1,..., k], y[1,..., l]).
            Se k = 0, 
                então retorna y[1,..., l]. 
            Fim de se-então.
        
            Se l = 0, 
                então retorna x[1,..., k]. 
            Fim de se-então.
        
            Se x[1] ≤ y[1]
                então retorna x[1] o merge(x[2,..., k], y[1,..., l]).
            senão 
                retorna y[1] o merge(x[1,..., k], y[2,..., l]).
            Fim de se-então-senão.

Pede-se: considerando o paradigma de projeto de algoritmo  divisão e conquista, analisar a complexidade computacional de    ambos os algoritmos e implementar os dois algoritmos para uma  entrada de tamanho n = 10 e, em seguida, para n = 100. Observe o desempenho em relação ao tempo de execução.

---
### RESOLUÇÃO

---

### **Questão 2**

Considere o problema de encontrar o n+1-ésimo número de Fibonacci.

Seja dado o algoritmo de Fibonacci (recursivo), a saber:
        
Algoritmo: Fibonacci.

        % Entrada: uma função F e um numero natural n.
        % Saída: numero de Fibonacci F(n).
        
        Início de função.
            Se n < 2
                então F(n) := n.
            senão F(n) := F(n − 1) + F(n − 2).
            Fim de se-então-senão.
        Fim de função.

Ainda, seja dada a seguinte ideia de um algoritmo para o problema de encontrar o n+1-ésimo número de Fibonacci, a saber. O problema de se determinar F(n) foi decomposto nos subproblemas de se determinar F(n − 1) e F(n − 2), respectivamente. Para se calcular F(n − 1), com n − 1 > 1, necessita-se dos resultados dos subproblemas F(n − 2) e F(n − 3). 

A ideia então e calcular cada um destes, exatamente uma vez, armazenando o resultado em uma tabela. Esta seria consultada cada vez que o mesmo subproblema fosse reconsiderado. Nesse caso, a tabela pode ser constituída simplesmente de um vetor de tamanho n + 1, sendo F(n) o elemento da sequência que se deseja calcular.

Pede-se: considerando o paradigma de projeto de algoritmo programação dinâmica, analisar a complexidade computacional de ambos os algoritmos e implementar os dois algoritmos para uma entrada de tamanho n = 10 e, em seguida, para n = 100. Observe o desempenho em relação ao tempo de execução.

---
### RESOLUÇÃO

---

### **Questão 3**

Considere a seguinte tabela de distâncias áereas, em milhas, entre seis das maiores cidades do mundo, respectivamente: Londres (L), Cidade do Mexico (CM), Nova Iorque (NY), Paris (Pa), Pequim (Pe) e Tóquio (T)

|∗      | L     | CM    | NY    | Pa    | Pe    | T     |
|--     | :--:  | :--:  | :--:  | :--:  | :--:  | :--:  |
|**L**  | 0     | 5558  | 3469  | 214   | 5074  | 5959  |
|**CM** | 5558  | 0     | 2090  | 5725  | 7753  | 7035  |
|**NY** | 3469  | 2090  | 0     | 3636  | 6844  | 6757  |
|**Pa** | 214   | 5725  | 3636  | 0     | 5120  | 6053  |
|**Pe** | 5074  | 7753  | 6844  | 5120  | 0     | 1307  |
|**T**  | 5959  | 7035  | 6757  | 6053  | 1307  | 0     |

Ainda, considere o algoritmo:

Algoritmo: Kruskal.

        % Entrada: um grafo G = (V,E) conexo com pesos.
        % Saída: uma árvore geradora mínima.
        
        Iniciar com um subgrafo gerador T = (V, ∅).
        
        Ordenar as arestas de G com pesos não decrescentes,  e1,..., e|E|
        
        Para j = 1,..., |E|
            Se e1,..., eij ja foram escolhidos
                então adicione a T, eij+1 tal que o subgrafo aresta-induzido G[{e1,..., eij+1}] e acíclico.
            Fim de se-então.
        Fim de para.

Pede-se: considerando o paradigma de projeto de algoritmo guloso,encontrar uma árvore geradora mínima para o problema acima usando o algoritmo de Kruskal e analisar a sua complexidade computacional.

---
### RESOLUÇÃO

---