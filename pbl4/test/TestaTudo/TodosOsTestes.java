
package TestaTudo;

import modelTestes.ControladorTeste;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import utilTestes.GrafoTeste;

@RunWith(Suite.class)
@Suite.SuiteClasses(
  { ControladorTeste.class,
    GrafoTeste.class,  
    
})

/**
 * Classe que realiza uma suíte de todos os testes do programa.
 */
public class TodosOsTestes {    
}
