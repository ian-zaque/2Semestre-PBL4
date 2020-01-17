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

import java.util.ArrayList;
import java.util.Objects;

public class Cidade {
    private final String nome;
    private final int posX;
    private final int posY;
    private final int index;
    private ArrayList listaVizinhos;   
    
    /**
     * Construtor da classe Cidade. Recebe como parâmetro a String nome da cidade,
     * as coordenadas e o indice de identificação da cidade. Inicializa seus 
     * atributos respectivos. 
     * @param nomeCidade - String que será o nome da cidade.
     * @param x - int posição X que é a coordenada X num plano cartesiano.
     * @param y - int posição Y que é a coordenada Y num plano cartesiano.
     * @param index - indice de identificação do objeto Cidade
     */
    public Cidade(String nomeCidade, int x, int y, int index)
    {   this.nome = nomeCidade; this.listaVizinhos = new ArrayList(); 
        this.posY = y; this.posX = x;this.index = index;
    }

    /**
     * Método que retorna o atributo nome desta classe. 
     * @return - retorna o atributo nome desta classe. 
     */
    public String getNome(){ return nome; }

    /**
     * Método que retorna o atributo posX desta classe. 
     * @return - retorna o atributo posX desta classe. 
     */
    public int getPosX(){return posX; }

    /**
     * Método que retorna o atributo posY desta classe. 
     * @return - retorna o atributo posY desta classe. 
     */
    public int getPosY(){return posY;}

    /**
     * Método que retorna o atributo index desta classe. 
     * @return - retorna o atributo index desta classe. 
     */    
    public int getIndex() { return index; }   
    
    /**
     * Método que retorna a quantidade de vizinhos de um objeto desta classe. 
     * @return - retorna a quantidade de vizinhos de um objeto desta classe. 
     */
    public int qntdVizinhos(){ return this.listaVizinhos.size(); }   

    /**
     * Método que retorna o atributo listaVizinhos desta classe. 
     * @return - retorna o atributo listaVizinhos desta classe. 
     */ 
    public ArrayList getListaVizinhos(){return listaVizinhos;}
    
    /**
     * Método que adiciona ao atributo listaVizinhos um novo objeto Cidade. 
     * Também neste objeto adicionado, é adicionado à lista dele o objeto desta classe.
     * 
     * @param viz - novo objeto Cidade que será considerado como novo vizinho a 
     * esta cidade.
     */
    public void addVizinho(Cidade viz) 
    {   if(!listaVizinhos.contains(viz) && !(this == viz)) 
        {   listaVizinhos.add(viz);            
            viz.getListaVizinhos().add(this);   
        }   
    }
    
    /**
     * Método que checa se duas cidades são vizinhas.
     * @param cid - objeto Cidade a ser checado.
     * @return - 'true' se suas listas tem um ao outro, 'false' caso contrário. 
     */
    public boolean isVizinho(Cidade cid) 
    {   return this.listaVizinhos.contains(cid); } 
    
    /**
     * Método sobreescrito que é chamado por um objeto da classe Cidade e compara 
     * a outro se seus atributos são iguais.
     * @param obj - objeto a ser comparado.
     * @return 'true' se os objetos tiverem os valores dos atributos iguais, 'false' caso contrário.
     */
    @Override
    public boolean equals(Object obj)
    {   if(!(obj instanceof Cidade)) {return false;}        
        if(obj == this) { return true;}
    
        else
        { Cidade cid = (Cidade) obj;
          return this.nome.equals(cid.nome) && this.posX == cid.posX 
                  && this.posY == cid.posY;    
        }
    }

    /**
     * Método sobreescrito que é responsável por calcular o hash de um objeto 
     * do tipo Cidade para determinar qual posição para este objeto em uma estrutura
     * de dados.
     * @return - retorna o hash de um objeto do tipo Cidade.
     */
    @Override
    public int hashCode()
    {   int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + this.posX;
        hash = 59 * hash + this.posY;        
        return hash;
    }
}