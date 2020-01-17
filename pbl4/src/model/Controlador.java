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
package model;

import Excecoes.FalhaGeracaoInformacoesException;
import Excecoes.GrafoIncompletoException;
import util.Cidade;
import util.Grafo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


//Essa classe é responsável por pegar as informaçoes de um txt e jogar pro grafo :) 
public class Controlador {
    private final File diretorio;
    private final Grafo grafo;
    
    /**
     * Construtor da classe Controlador que instancia um objeto desta classe e
     * inicializa os atributos do tipo File e do tipo Grafo.  
     * @param caminho - string que localiza o arquivo .txt que será lido e 
     * possui as informações das cidades.
     * @see File
     * @see Grafo
     */
    public Controlador(String caminho)
    { this.diretorio = new File(caminho);
      this.grafo = new Grafo();  
    }

    /**
     * Método que retorna o atributo do tipo File.
     * @return - retorna o atributo do tipo File que gere e administra a 
     * manipulação dos diretorios usados.
     */
    public File getDiretorio(){ return diretorio; }

    /**
     * Método que retorna o atributo do tipo Grafo. 
     * @return - retorna o atributo do tipo Grafo.
     */
    public Grafo getGrafo() { return grafo; }   
    
    /**
     * Método que lê as informações contidas em um arquivo .txt, separa os termos
     * necessários, instancia um objeto Cidade e adiciona um vértice com esta cidade
     * como atributo. Em seguida lê outro arquivo.txt com as informações para 
     * fazer as ligações entre as cidades, instanciando arestas e adicionando-as
     * ao grafo.
     * 
     * @return - retorna um objeto Grafo carregado com os vértices e 
     * arestas instanciados com as cidades, pesos e coordenadas.
     * 
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception 
     * @see Grafo
     * 
     * @see Integer
     * @see BufferedReader
     * @see FileReader
     * @see Cidade
     * @see Vertice
     * @see Aresta
     */
    public Grafo geraGrafo() throws FileNotFoundException, IOException, Exception
    {   try
        {   BufferedReader leitorArquivo = new BufferedReader(new FileReader("cidades.txt"));
            String linhaTxt; String[] arrayInfo; 
        
            while((linhaTxt = leitorArquivo.readLine()) != null)
            {   arrayInfo = linhaTxt.split("=");
                if(arrayInfo.length == 1) { grafo.setNomeMapa(arrayInfo[0]);  }        
                else
                {   int pX = Integer.parseInt(arrayInfo[1]);
                    int pY = Integer.parseInt(arrayInfo[2]);
                    int index = Integer.parseInt(arrayInfo[3]);
                    Cidade cidade = new Cidade(arrayInfo[0],pX,pY,index);
                    grafo.addVertice(cidade);
                }
            }   
        
            leitorArquivo = new BufferedReader(new FileReader("adjacencias.txt"));
            while((linhaTxt = leitorArquivo.readLine()) != null)
            {   arrayInfo = linhaTxt.split("=");
            
                Cidade cidade = grafo.getVertice(Integer.parseInt(arrayInfo[0])-1).getCity();
                Cidade vizinha = grafo.getVertice(Integer.parseInt(arrayInfo[1])-1).getCity();
                int peso = Integer.parseInt(arrayInfo[2]);
                cidade.addVizinho(vizinha);
                grafo.addAresta(cidade, vizinha, peso);
            }
            leitorArquivo.close();
           return grafo;             
        }
        catch(IOException e)
        {   throw new FalhaGeracaoInformacoesException(); }
        catch(Exception e)
        {   throw new GrafoIncompletoException();    }
    }    
}
