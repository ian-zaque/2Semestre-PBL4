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

import java.util.Objects;

public class Vertice{
    private final Cidade city;
    private int custo;
    private boolean visitado;
    private Vertice anterior;
    
    /**
     * Construtor da classe Vertice. Instancia um objeto Vertice e 
     * inicializa seus atributos.
     * 
     * @param cid - Cidade que seu atributo se tornará.
     * @see Cidade
     */
    public Vertice(Cidade cid)
    {   this.city = cid; 
        custo = Integer.MAX_VALUE; visitado = false;
    }

    /**
     * Método que retorna o atributo city desta classe.
     * @return - retorna o atributo city desta classe.
     */
    public Cidade getCity() {  return city; } 
    
    /**
     * Método que retorna o atributo custo desta classe.
     * @return - retorna o atributo custo desta classe.
     */
    public int getCusto(){ return custo; }

    /**
     * Método que retorna o atributo visitado desta classe. 
     * @return - retorna o atributo visitado desta classe. 
     */
    public boolean isVisitado() { return visitado; }  
    
    /**
     * Método que atualiza o atributo visitado da classe.
     * @param sentenca - novo estado do atributo visitado desta classe.
     */
    public void setVisitado(boolean sentenca) {this.visitado = sentenca;}
    
    /**
     * Método que atualiza o atributo custo da classe.
     * @param custo - novo valor do atributo custo desta classe.
     */
    public void setCusto(int custo) { this.custo = custo; }  

    /**
     * Método que retorna o atributo anteriror desta classe. 
     * @return - retorna o atributo anteriror desta classe. 
     */
    public Vertice getAnterior() { return anterior; }

    /**
     * Método que atualiza o atributo anterior da classe.
     * @param anterior -  novo valor do atributo anterior desta classe.
     */
    public void setAnterior(Vertice anterior) { this.anterior = anterior; }  
    
    /**
     * Método que checa se o vertice do parametro é vizinho do objeto desta classe.
     * 
     * @param vert - vertice que deseja-se saber se é vizinho.
     * @return - 'true' se for vizinho, 'false' em caso contrário.
     */
    public boolean isVizinho(Vertice vert)
    {   return this.city.getListaVizinhos().contains(vert.getCity()); }      
      
    /**
     * Método sobreescrito que é chamado por um objeto da classe Vertice e compara 
     * a outro se seus atributos são iguais.
     * 
     * @param obj - objeto a ser comparado.
     * 
     * @return 'true' se os objetos tiverem os valores dos atributos iguais, 'false' caso contrário.
     */
    @Override
    public boolean equals(Object obj)
    {   if(!(obj instanceof Vertice)) {return false; }
        if(!this.isVizinho((Vertice) obj)) { return false; }
        if(this == obj) { return true; }        
      return this.city.equals(obj);                    
    }               

    /**
     * Método sobreescrito que é responsável por calcular o hash de um objeto 
     * do tipo Vertice para determinar qual posição para este objeto em uma estrutura
     * de dados.
     * @return - retorna o hash de um objeto do tipo Vertice.
     */
    @Override
    public int hashCode()
    {   int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.city);
        return hash;
    }    
}
