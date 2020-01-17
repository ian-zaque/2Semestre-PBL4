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
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.Controlador;
import util.Aresta;
import util.Grafo;
import util.Vertice;

public class PainelGrafo extends JPanel{
    
    /**
     * Construtor da classe PainelGrafo. 
     */
    public PainelGrafo() { super(); }
    
    /**
     * Método da classe PainelGrafo que estende de JPanel e sobreescreve o 
     * método paintComponent para pintar um grafo na interface.
     * @param graphics - parametro usado para pintar o que deseja-se na interface.
     */
    @Override
    protected void paintComponent(Graphics graphics)
    {   try
        {   super.paintComponent(graphics);
            setOpaque(false);
        
            Controlador control = new Controlador("./");
            Grafo grafo = control.geraGrafo();
            Object[] vertices = grafo.getVertices().toArray(); 
            Object[] arestas = grafo.getArestas().toArray();
            this.setName(grafo.getNomeMapa());
            
            Graphics2D grap2 = (Graphics2D) graphics;
            grap2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            
            for(int cont = 0; cont < arestas.length; cont++)
            { int x1 = ((Aresta)arestas[cont]).getVert1().getCity().getPosX();
              int y1 = ((Aresta)arestas[cont]).getVert1().getCity().getPosY();
              int x2 = ((Aresta)arestas[cont]).getVert2().getCity().getPosX();                
              int y2 = ((Aresta)arestas[cont]).getVert2().getCity().getPosY();
              grap2.setColor(Color.black);
              grap2.draw(new Line2D.Float(x1,y1,x2,y2));
              grap2.drawLine(x1, y1, x2, y2);            
            }
        
            for(int cont = 0;cont < vertices.length; cont++)
            {   int x = ((Vertice)vertices[cont]).getCity().getPosX();
                int y = ((Vertice)vertices[cont]).getCity().getPosY();
                grap2.setColor(Color.red);
                grap2.fillOval(x,y,15,15);
                grap2.drawString(((Vertice)vertices[cont]).getCity().getNome(), x, y);
                grap2.setStroke(new BasicStroke(5));              
            }
        }       
        catch (Exception ex)
        { Logger.getLogger(PainelGrafo.class.getName()).log(Level.SEVERE, null, ex); }        
    }
}
