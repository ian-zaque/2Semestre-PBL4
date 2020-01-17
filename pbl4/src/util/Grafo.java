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

import Excecoes.CidadesNaoSelecionadasException;
import Excecoes.CidadesNaoVizinhasException;
import Excecoes.DijkstraCorrompidoException;
import Excecoes.VerticeNaoExistenteException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Grafo {    
    private Set<Vertice> vertices;
    private Set<Aresta> arestas;
    private Map<Vertice, Set<Aresta>> vizinhanca;
    private String nomeMapa;
    
    /**
     * Construtor da classe Grafo. Inicializa os seus atributos e instancia 
     * um objeto desta classe.
     */
    public Grafo()
    {   vertices = new HashSet<>();
        arestas = new HashSet<>();
        vizinhanca = new HashMap<>();
    }        

    /**
     * Método que retorna o atributo vizinhanca que é um Map<K,V> que
     * guarda os vertices e as arestas. 
     * 
     * @return - atributo vizinhanca desta classe.
     * 
     * @see Map
     * @see Set
     * @see Vertice
     * @see Aresta
     */
    public Map<Vertice, Set<Aresta>> getVizinhanca(){return vizinhanca; }   

    /**
     * Método que retorna o atributo vertices que é um Set que
     * guarda os vertices desta classe.
     * 
     * @return - atributo vertices desta classe.
     *
     * @see Set
     * @see Vertice
     * @see Aresta
     */
    public Set<Vertice> getVertices(){ return vertices; }

    /**
     * Método que retorna o atributo arestas que é um Set que
     * guarda as arests desta classe.
     * 
     * @return - atributo arestas desta classe.
     *
     * @see Set
     * @see Vertice
     * @see Aresta
     */
    public Set<Aresta> getArestas(){ return arestas;}   
    
    /**
     * Método que retorna o atributo String nomeMapa desta classe.  
     * @return - retorna o atributo nomeMapa desta classe.
     */
    public String getNomeMapa(){ return nomeMapa; }

    /**
     * Método que atualiza o atributo String nomeMapa desta classe. 
     * 
     * @param nomeMapa - nova String que será o atributo nomeMapa desta classe. 
     */
    public void setNomeMapa(String nomeMapa) { this.nomeMapa = nomeMapa;}   
    
    /**
     * Método público que chama o método privado de adicionar vértices ao grafo.
     * 
     * @param cid - cidade que será adicionada a um vertice do grafo.
     * 
     * @return - retorna 'true' se adicionar, 'false' caso contrário.
     */
    public boolean addVertice(Cidade cid) { return addVertice(new Vertice(cid)); }
    
        /**
         * Método privado que adiciona um novo vertice ao atributo vertices da classe.
         * @param vert - Vertice novo a ser adicionado.
         * @return - 'true' se adicionar, 'false' caso contrário.
         */
        private boolean addVertice(Vertice vert){ return vertices.add(vert);  }
    
    /**
     * Método público que chama o método privado de adicionar arestas ao grafo.
     * 
     * @param c1 - cidade 1 que será adicionada a um vertice do grafo.
     * @param c2 - cidade 2 que será adicionada a um vertice do grafo.
     * @param peso - peso da aresta que representa a distancia de um vertice ao outro.
     * 
     * @return - retorna 'true' se adicionar, 'false' caso contrário.
     * @throws Exception 
     */    
    public boolean addAresta(Cidade c1, Cidade c2, int peso) throws Exception
    { return addAresta(new Aresta(new Vertice(c1),new Vertice(c2),peso)); }
       
        /**
        * Método privado que adiciona uma nova aresta ao atributo arestas da classe.
        * @param ares - nova aresta a ser adicionada. 
        * @return - 'true' se adicionar, 'false' caso contrário.
        */
        private boolean addAresta(Aresta ares)
        {   if(!arestas.add(ares)) { return false;} 
            
            vizinhanca.putIfAbsent(ares.getVert1(), new HashSet<>());
            vizinhanca.putIfAbsent(ares.getVert2(), new HashSet<>());

            vizinhanca.get(ares.getVert1()).add(ares);
            vizinhanca.get(ares.getVert2()).add(ares);

          return true;        
        }        
    
    /**
    * Método que checa se o atributo vertices contém o parâmetro Cidade passado.
    * 
    * @param cid - cidade para checar se o grafo o contém.
    * 
    * @return - 'true' se conter, 'false' caso contrário.
    * @see Vertice
    * @see Aresta
    * @see Iterator
    */
    public boolean contemVertice(Cidade cid)
    {   Iterator it = vertices.iterator();
        while(it.hasNext())
        {   if(((Vertice)it.next()).getCity().equals(cid))
                { return true; }
        }
      return false;  
    }       
       
    /**
    * Método que checa se o atributo arestas contém uma aresta que contém vértices
    * que possuem as cidades passadas como parâmetro.
    * 
    * @param c1 - cidade 1 a ser checada se é contida em arestas.  
    * @param c2 - cidade 2 a ser checada se é contida em arestas.
    * 
    * @return - 'true' se conter, 'false' caso contrário.
    * @see Vertice
    * @see Aresta
    * @see Iterator
    */
    public boolean contemAresta(Cidade c1, Cidade c2)
    {   if(!c1.isVizinho(c2) && !c2.isVizinho(c1)) { return false;}        
        Iterator itera = arestas.iterator();
        while(itera.hasNext())
        {   if((((Aresta)itera.next()).getVert1().getCity().isVizinho(c1) || ((Aresta)itera.next()).getVert1().getCity().isVizinho(c2)))
            {   if((((Aresta)itera.next()).getVert2().getCity().isVizinho(c1)) || ((Aresta)itera.next()).getVert2().getCity().isVizinho(c2))
                {   if(c1.isVizinho(c2))
                      {return true; }
                }
            }
        }    
      return false;  
    }   
    
    /**
     * Método que retorna o vértice cujo índice é igual ao passado como parâmetro. 
     * 
     * @param index - índice que deseja-se ter o vértice correspondente.
     * 
     * @return - retorna o vértice cujo índice é igual ao passado como parâmetro. 
     * @throws Exception 
     * 
     * @see Vertice
     * @see Aresta
     */
    public Vertice getVertice(int index) throws Exception
    { try
        {   if(index >= 0)
            {  for(Vertice vert : vertices) 
                {   if(vert.getCity().getIndex() == index)
                    {   return vert;  }
                }
            }        
         throw new Exception();            
        }
        catch(Exception e)
        {   throw new VerticeNaoExistenteException();   }   
    }
    
    /**
     * Método que retorna a aresta cujos vértices tem índice igual aos 
     * passados como parâmetro. 
     * 
     * @param index1 - índice 1 que deseja-se ter o vértice correspondente.
     * @param index2 - índice 2 que deseja-se ter o vértice correspondente.
     * 
     * @return - retorna o vértice cujo índice é igual ao passado como parâmetro. 
     * @throws CidadesNaoVizinhasException 
     * 
     * @see Vertice
     * @see Aresta
     */
    public Aresta getAresta(int index1, int index2) throws CidadesNaoVizinhasException
    {  try
        {   if(index1 >= 0 && index2 >= 0)
            {   for(Aresta ares : arestas)
                {   if(ares.getVert1().equals(getVertice(index1)) && ares.getVert2().equals(getVertice(index2)))
                    {   return ares; }
                }
            }         
          throw new Exception();  
        }
        catch(Exception e)
        { throw new CidadesNaoVizinhasException();   }       
    }
    
    /**
     * Método que verifica o peso de uma aresta que possui os dois vértices 
     * passados como parâmetro.
     * 
     * @param v1 - vértice 1 que deseja-se saber o peso entre ele e outro.
     * @param v2 - vértice 2 que deseja-se saber o peso entre ele e outro.
     * 
     * @return - retorna o peso da aresta entre estes dois vértices do parâmetro.
     * @throws Exception 
     * 
     * @see Vertice
     * @see Aresta
     */
    public int getPesoEntreVertices(Vertice v1, Vertice v2) throws Exception 
    {   try
        {   for(Aresta ares : arestas)
            {   if( (ares.getVert1().equals(v1) && ares.getVert2().equals(v2))
                  || ares.getVert2().equals(v1) && ares.getVert1().equals(v2))
                    {   return ares.getPeso();  }
            }
          throw new Exception();        
        }
        catch(Exception e)
        { throw new VerticeNaoExistenteException();  }       
    }
    
    /**
     * Método que checa se o grafo está vazio.
     * @return - retorna 'true' se estiver vazio, 'false' caso contrário.
     */
    public boolean isEmpty() { return this.vizinhanca.isEmpty();  }      

    /**
     * Método que retorna a quantidade de vértices do grafo.
     * @return - retorna a quantidade de vértices do grafo.
     */
    public int qntdVertices() { return vertices.size(); }

    /**
     * Método que retorna a quantidade de arestas do grafo.
     * @return - retorna a quantidade de arestas do grafo.
     */
    public int qntdArestas() { return arestas.size();  }
        
    /**
     * Método que calcula o menor caminho entre dois vértices. Utiliza o algoritmo
     * de Dijkstra, presente na classe Dijkstra. 
     * 
     * @param grafo - grafo que deseja-se calcular o algoritmo de Dijkstra.
     * @param indexVerticeInicial - indice do vertice por onde começa o algoritmo.
     * @param indexVerticeFinal - indice do vertice por onde termina o algoritmo.
     * 
     * @return - retorna o menor caminho entre dois vértices.
     * 
     * @throws CidadesNaoSelecionadasException
     * @throws DijkstraCorrompidoException 
     * 
     * @see Vertice
     * @see Aresta
     * @see Dijkstra
     */    
    public LinkedList<Vertice> dijkstra(Grafo grafo, int indexVerticeInicial, int indexVerticeFinal) throws CidadesNaoSelecionadasException, DijkstraCorrompidoException 
    {   try
        {   Dijkstra d = new Dijkstra();
            return (LinkedList<Vertice>) d.calcularDijkstra(this,getVertice(indexVerticeInicial),getVertice(indexVerticeFinal));            
        }
        catch(Exception e)
        {   throw new DijkstraCorrompidoException(); }        
    }   
}
