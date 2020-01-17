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


public class Veiculo {
    private final int idVeiculo;
    private final double custo;

    /**
     * Construtor da classe Veiculo. Inicializa seus atributos e instancia um
     * objeto desta classe. O custo de usar o transporte é a multiplicação dos
     * parâmetros kilometragem e preco.
     * 
     * 
     * @param idVeiculo - identificação deste Veiculo
     * @param kilometragem - distancia a ser percorrida pelo veiculo.
     * @param preco - valor do combustivel a ser usado no veiculo.
     */
    public Veiculo(int idVeiculo, double kilometragem, double preco)
    {   this.idVeiculo = idVeiculo;
        this.custo = kilometragem*preco;
    }

    /**
     * Método que retorna o atributo idVeiculos desta classe.
     * @return - retorna o atributo idVeiculos desta classe.
     */
    public int getIdVeiculo()
    {  return idVeiculo; }

    /**
     * Método que retorna o atributo custo desta classe.
     * @return - retorna o atributo custo desta classe.
     */
    public double getCusto()
    { return custo;  }

    
    
}
