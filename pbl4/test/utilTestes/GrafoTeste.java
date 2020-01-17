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
package utilTestes;

import java.util.LinkedList;
import util.Cidade;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import util.Grafo;

public class GrafoTeste {
    private Cidade c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    private Grafo grafo;
    
    /**
     * Este método é executado antes de cada teste. Inicializa o grafo e cria
     * instâncias de cidades para realizar o teste.
     * @see Grafo
     * @see Cidade
     */
    @Before
    public void setUp()
    {   grafo = new Grafo();
        c1 = new Cidade("c1",111,111,0);c2 = new Cidade("c2",222,222,1);
        c3 = new Cidade("c3",333,333,2);c4 = new Cidade("c4",444,444,3);
        c5 = new Cidade("c5",555,555,4);c6 = new Cidade("c6",666,666,5);
        c7 = new Cidade("c7",777,777,6);c8 = new Cidade("c8",888,888,7);
        c9 = new Cidade("c9",999,999,8);c10 = new Cidade("c10",1000,1000,9);
        
        c1.addVizinho(c2);c1.addVizinho(c3);c1.addVizinho(c6);c1.addVizinho(c7);c1.addVizinho(c8);
        c2.addVizinho(c4);c3.addVizinho(c4);c3.addVizinho(c5);c5.addVizinho(c6); c8.addVizinho(c9);
        c8.addVizinho(c10);  
    }
    
    /**
     * Teste que checa se o método de adicionar vizinhos às cidades e checa se a
     * quantidade de vizinhos estão funcionando corretamente. 
     * @see Grafo
     * @see Cidade
     */
    @Test
    public void testeAddVizinhos()
    {   assertTrue(c1.getListaVizinhos().contains(c2));assertTrue(c1.getListaVizinhos().contains(c3));
        assertTrue(c1.getListaVizinhos().contains(c6));assertTrue(c1.getListaVizinhos().contains(c7));
        assertTrue(c1.getListaVizinhos().contains(c8));assertTrue(c2.getListaVizinhos().contains(c4));
        assertTrue(c3.getListaVizinhos().contains(c4));assertTrue(c3.getListaVizinhos().contains(c5));
        assertTrue(c5.getListaVizinhos().contains(c6));assertTrue(c8.getListaVizinhos().contains(c9));
        
        assertEquals(5,c1.qntdVizinhos());assertEquals(2,c2.qntdVizinhos());
        assertEquals(3,c3.qntdVizinhos());assertEquals(2,c4.qntdVizinhos());
        assertEquals(2,c5.qntdVizinhos());assertEquals(2,c6.qntdVizinhos());
        assertEquals(1,c7.qntdVizinhos());assertEquals(3,c8.qntdVizinhos());
        assertEquals(1,c9.qntdVizinhos());assertEquals(1,c10.qntdVizinhos());
    }
    
      /**
     * Teste que checa se o método de verificar se determinadas cidades
     * são vizinhas está funcionando corretamente.
     * @see Grafo
     * @see Cidade
     */
    @Test
    public void testeIsVizinho()
    {   assertTrue(c1.isVizinho(c2));assertTrue(c1.isVizinho(c3));
        assertTrue(c1.isVizinho(c6));assertTrue(c1.isVizinho(c7));
        assertTrue(c1.isVizinho(c8));assertTrue(c2.isVizinho(c4));
        assertTrue(c4.isVizinho(c3));assertTrue(c3.isVizinho(c5));
        assertTrue(c5.isVizinho(c6));assertTrue(c8.isVizinho(c9));
        assertTrue(c8.isVizinho(c10));
    
        assertFalse(c1.isVizinho(c5));assertFalse(c1.isVizinho(c4));
        assertFalse(c1.isVizinho(c10));assertFalse(c1.isVizinho(c9));
        assertFalse(c2.isVizinho(c3));assertFalse(c3.isVizinho(c2));
    }
    
    /**
     * Teste que verifica se o método de adicionar vértices ao grafo está 
     * funcionando corretamente.
     * @see Grafo
     * @see Vertice
     * @see Cidade
     */
    @Test
    public void testeAddVertices()
    {   grafo.addVertice(c1);grafo.addVertice(c2);grafo.addVertice(c3);grafo.addVertice(c4);
        grafo.addVertice(c5);grafo.addVertice(c6);grafo.addVertice(c7);grafo.addVertice(c8);
        grafo.addVertice(c9);grafo.addVertice(c10);
        
        assertTrue(grafo.contemVertice(c1));assertTrue(grafo.contemVertice(c2));  
        assertTrue(grafo.contemVertice(c3));assertTrue(grafo.contemVertice(c4));
        assertTrue(grafo.contemVertice(c5));assertTrue(grafo.contemVertice(c6));
        assertTrue(grafo.contemVertice(c7));assertTrue(grafo.contemVertice(c8));
        assertTrue(grafo.contemVertice(c9));assertTrue(grafo.contemVertice(c10)); 
    }
    
    /**
     * Teste que verifica se o método de adicionar arestas ao grafo está 
     * funcionando corretamente.
     * @throws java.lang.Exception
     * @see Grafo
     * @see Vertice
     * @see Aresta
     * @see Cidade
     */
    @Test
    public void testeAddArestas() throws Exception
    {   grafo.addVertice(c1);grafo.addVertice(c2);grafo.addVertice(c3);grafo.addVertice(c4);
        grafo.addVertice(c5);grafo.addVertice(c6);grafo.addVertice(c7);grafo.addVertice(c8);
        grafo.addVertice(c9);grafo.addVertice(c10);
        
        grafo.addAresta(c1,c2,3);grafo.addAresta(c1,c3,4);grafo.addAresta(c1,c8,9);
        grafo.addAresta(c1,c7,8);grafo.addAresta(c1,c6,7);grafo.addAresta(c2,c4,6);
        grafo.addAresta(c3,c4,7);grafo.addAresta(c3,c5,8);grafo.addAresta(c5,c6,11);
        grafo.addAresta(c8,c9,17);grafo.addAresta(c8,c10,18);
        
        assertTrue(grafo.contemAresta(c1,c2));assertTrue(grafo.contemAresta(c1,c3));
        assertTrue(grafo.contemAresta(c1,c6));assertTrue(grafo.contemAresta(c1,c7));
        assertTrue(grafo.contemAresta(c1,c8));assertTrue(grafo.contemAresta(c8,c9));
        assertTrue(grafo.contemAresta(c8,c10));assertTrue(grafo.contemAresta(c3,c4));
        assertTrue(grafo.contemAresta(c2,c4));assertTrue(grafo.contemAresta(c3,c5));
        assertTrue(grafo.contemAresta(c5,c6));assertTrue(grafo.contemAresta(c3,c1));
    }
    
    /**
     * Teste que verifica se o método de achar o menor caminho entre dois vértices
     * está funcionando corretamente.
     * @throws java.lang.Exception
     * @see Grafo
     * @see Vertice
     * @see Aresta
     * @see Cidade
     */
    @Test
    public void testeDijkstra() throws Exception
    {   grafo.addVertice(c1);grafo.addVertice(c2);grafo.addVertice(c3);grafo.addVertice(c4);
        grafo.addVertice(c5);grafo.addVertice(c6);grafo.addVertice(c7);grafo.addVertice(c8);
        grafo.addVertice(c9);grafo.addVertice(c10);
        
        grafo.addAresta(c1,c2,3);grafo.addAresta(c1,c3,4);grafo.addAresta(c1,c8,9);
        grafo.addAresta(c1,c7,8);grafo.addAresta(c1,c6,7);grafo.addAresta(c2,c4,6);
        grafo.addAresta(c3,c4,7);grafo.addAresta(c3,c5,8);grafo.addAresta(c5,c6,11);
        grafo.addAresta(c8,c9,17);grafo.addAresta(c8,c10,18);
        
        LinkedList lista = grafo.dijkstra(grafo, 0, 8);
        assertEquals(2,lista.size());
    }
}
