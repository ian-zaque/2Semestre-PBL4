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

import Excecoes.DijkstraCorrompidoException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Dijkstra {   
    private List<Vertice> menorCaminho;
    private Vertice verticeCaminho;
    private Vertice atual;
    private Vertice adjacente;	
    private List<Vertice> naoVisitados;
      
    /**
     * Construtor da classe Dijkstra. Inicializa seus atributos menorCaminho e
     * naoVisitados. Esta classe é responsável pela roteirização do menor caminho
     * de um vértice a outro.
     */
    public Dijkstra()
    {   menorCaminho = new LinkedList<>();
        naoVisitados = new LinkedList<>();
    }
    
    /**
     * Método que calcula o menor caminho entre os vértices passados por parâmetro.
     * O algoritmo de Dijkstra checa os vértices adjacentes e escolhe o próximo de menor
     * custo até chegar no vértice desejado.
     * 
     * @param grafo - grafo a ser rodado o algoritmo.
     * @param largada - vértice tomado para começar algoritmo. 
     * @param chegada - vértice onde deseja-se chegar.
     * @return - retorna o menor caminho entre os vértices escolhidos.
     * 
     * @throws Exception - lança a exceção DijkstraCorrompidoException se houver
     * alguma falha na execução do algoritmo. 
     * @see Grafo
     * @see Vertice
     * @see Aresta
     * @see Collections
     * @see ComparaVertice
     * @see Integer
     * @see DijkstraCorrompidoException
     */
    public List<Vertice> calcularDijkstra(Grafo grafo, Vertice largada, Vertice chegada) throws Exception    
    {   try        
        {   menorCaminho.add(largada);
            for(int cont = 0; cont < grafo.qntdVertices(); cont++)
            {   Vertice vertAux = grafo.getVertice(cont);
                
                if(vertAux.equals(largada))  {  vertAux.setCusto(0); }
                
                else { vertAux.setCusto(Integer.MAX_VALUE);  } 
              naoVisitados.add(vertAux);                
            }
            Collections.sort(naoVisitados, new ComparaVertice());
            
            while(!naoVisitados.isEmpty())
            {   atual = naoVisitados.get(0);
            
                for(int cont = 0; cont < atual.getCity().qntdVizinhos(); cont++)
                {  adjacente = (Vertice) atual.getCity().getListaVizinhos().get(cont);
                    
                    if(!adjacente.isVisitado())       
                    {   if(adjacente.getCusto() > (atual.getCusto() + grafo.getPesoEntreVertices( atual, (Vertice)atual.getCity().getListaVizinhos().get(cont)) ) )
                        {   adjacente.setCusto(grafo.getPesoEntreVertices( atual, (Vertice)atual.getCity().getListaVizinhos().get(cont)));
                            adjacente.setAnterior(atual);                       
                        }
                        
                        if(chegada == adjacente)
                        {   menorCaminho.clear();
                            verticeCaminho = adjacente;
                            menorCaminho.add(adjacente);
                                while(verticeCaminho.getAnterior() != null)
                                {   menorCaminho.add(verticeCaminho.getAnterior());
                                    verticeCaminho = verticeCaminho.getAnterior();                                    
                                }  
                          Collections.sort(menorCaminho, new ComparaVertice());      
                        }                     
                    }                    
                }
              atual.setVisitado(true);
              naoVisitados.remove(atual);
              Collections.sort(naoVisitados,new ComparaVertice());              
            } 
          return menorCaminho;  
        }
        catch(Exception e)
        { throw new DijkstraCorrompidoException(); }      
    }
}
