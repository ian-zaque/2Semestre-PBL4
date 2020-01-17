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
package modelTestes;

import model.Controlador;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import util.Grafo;

public class ControladorTeste {
    private Grafo grafo;
    private Controlador controlador;
    
    /**
     * Este método é executado antes de cada teste. Inicializa o grafo e cria
     * instância da classe Controlador para realizar o teste.
     */
    @Before
    public void setUp()
    {   controlador = new Controlador("./");
        grafo = new Grafo();
    }
    
    /**
     * Teste que verifica se o método de pegar informações de um arquivo .txt 
     * e envia-las para o grafo está funcionando.
     * @throws Exception 
     * @see Grafo
     * @see Aresta
     * @see Vertice
     * @see Controlador
     * @see BufferedReader
     */
    @Test
    public void testeGeraGrafo() throws Exception
    {   grafo = controlador.geraGrafo();
        
        assertEquals(33,grafo.qntdVertices());assertEquals(34,grafo.qntdArestas());
        assertEquals("Bahia - Roteamento de Veiculos",grafo.getNomeMapa());
        
        assertEquals("Feira de Santana",grafo.getVertice(0).getCity().getNome());
        assertEquals("Irara",grafo.getVertice(1).getCity().getNome());
        assertEquals("Serrinha",grafo.getVertice(2).getCity().getNome());
        assertEquals("Alagoinhas",grafo.getVertice(3).getCity().getNome());
        assertEquals("Riachao do Jacuipe",grafo.getVertice(4).getCity().getNome());
        assertEquals("Esplanada",grafo.getVertice(5).getCity().getNome());
        assertEquals("Pojuca",grafo.getVertice(6).getCity().getNome());
        assertEquals("Ipira",grafo.getVertice(7).getCity().getNome());
        assertEquals("Jacobina",grafo.getVertice(8).getCity().getNome());
        assertEquals("Camacari",grafo.getVertice(9).getCity().getNome());
        assertEquals("Baixa Grande",grafo.getVertice(10).getCity().getNome());
        assertEquals("Nazare",grafo.getVertice(11).getCity().getNome());
        assertEquals("Salvador",grafo.getVertice(12).getCity().getNome());
        assertEquals("Mundo Novo",grafo.getVertice(13).getCity().getNome());
        assertEquals("Ruy Barbosa",grafo.getVertice(14).getCity().getNome());
        assertEquals("Santa Ines",grafo.getVertice(15).getCity().getNome());
    }  
}
