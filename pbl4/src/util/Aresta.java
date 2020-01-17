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

import Excecoes.CidadesNaoVizinhasException;
import java.util.Objects;

public class Aresta {
    private int peso;
    private final Vertice vert1;
    private final Vertice vert2;

    /**
     * Método que retorna o atributo peso desta classe.
     * @return - retorna o atributo peso desta classe.
     */
    public int getPeso(){ return peso;}

    /**
     * Método que retorna o atributo Vértice vert1 desta classe.
     * @return - retorna o atributo Vértice vert1 desta classe.
     * @see Vertice
     */
    public Vertice getVert1(){ return vert1;}

    /**
     * Método que retorna o atributo Vértice vert2 desta classe.
     * @return - retorna o atributo Vértice vert2 desta classe.
     * @see Vertice
     */
    public Vertice getVert2(){ return vert2;}    
    
    /**
     * Método que atualiza o atributo peso desta classe.
     * @param peso - o novo atributo peso desta classe.
     */
    public void setPeso(int peso){this.peso = peso; }
    
    /**
     * Construtor da classe Aresta. Inicializa os seus atributos se os parâmetros
     * Vertice v1 e Vertice v2 forem vizinhos. Se não forem, lança uma 
     * exceção CidadesNaoVizinhasException. Sefor, os inicializa e inicializa 
     * o atributo peso recebido como parâmetro.
     * 
     * @param v1 - Vértice de onde parte-se. 
     * @param v2 - Vértice de onde chega-se.
     * @param peso - atributo que marca o peso da aresta, nesse caso, a distância
     * entre um vértice e outro.
     * 
     * @throws Exception 
     * @see Vertice
     */
    public Aresta(Vertice v1, Vertice v2, int peso) throws Exception
    { try
      { if(!v1.isVizinho(v2))
          { throw new Exception(); }  
        else 
        { this.vert1 = v1;this.vert2 = v2;
          this.peso = peso;         
        }          
      }
      catch(Exception e)
      { throw new CidadesNaoVizinhasException(); }
    }               

   /**
     * Método sobreescrito que é chamado por um objeto da classe Aresta e compara 
     * a outro se seus atributos são iguais.
     * @param obj - objeto a ser comparado.
     * @return 'true' se os objetos tiverem os valores dos atributos iguais, 'false' caso contrário.
     */
    @Override
    public boolean equals(Object obj)
    {   if(!(obj instanceof Aresta)) { return false; }
        if(this == obj){ return true;}
      return this.peso == ((Aresta)obj).getPeso() && this.vert1.equals(((Aresta)obj).getVert1()) 
        && this.vert2.equals(((Aresta)obj).getVert2());
    }

    /**
     * Método sobreescrito que é responsável por calcular o hash de um objeto 
     * do tipo Aresta para determinar qual posição para este objeto em uma estrutura
     * de dados.
     * @return - retorna o hash de um objeto do tipo Aresta.
     */
    @Override
    public int hashCode()
    {   int hash = 3;
        hash = 59 * hash + (int)(Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.vert1);
        hash = 59 * hash + Objects.hashCode(this.vert2);
        return hash;
    }        
}
