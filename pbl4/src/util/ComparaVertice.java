/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autor: <Ian Zaque Pereira de Jesus dos Santos>
 * Data:  <07/02/2019>
 *
 * Declaro que este código foi elaborado por mim de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */
package util;

import java.util.Comparator;

public class ComparaVertice implements Comparator{ 
    
    /**
     * Método sobreescrito da interface Comparator. Compara os custos de 2 vértices
     * para usar no algoritmo de Dijkstra.
     * 
     * @param o1 - objeto 1 a ser comparado.
     * @param o2 - objeto 2 a ser comparado.
     * @return - retorna 1 se o custo de o1 for maior que o de o2, -1 se for menor
     * e 0 se for igual.
     * 
     * @see Vertice
     * @see Comparator
     */
    @Override
    public int compare(Object o1, Object o2)
    {   if(((Vertice)o1).getCusto() > ((Vertice)o2).getCusto())
         { return 1;  }
        
        else if(((Vertice)o1).getCusto() < ((Vertice)o2).getCusto())
         {   return -1; }
     return 0;
    }  
}
