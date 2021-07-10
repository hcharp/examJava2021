import org.junit.jupiter.api.Test; //@Test
import static org.junit.jupiter.api.Assertions.*; //assertEquals()


public class CLIClassiqueTest {
	
	/*
	Exemple testé : 
	-K 10 -A .90 -K 20 -P -K 30 -C
	Résultat attendu :
	alpha=0.9, epsilon=-1.0, indice=30, mode=CREUSE
	*/
	
	@Test
	public void testExempleSujet() {

		Configuration c1 = new Configuration();
		c1.alpha = 0.9f;
		c1.epsilon = 1.0f;
		c1.indice = 30;
		c1.mode = Mode.CREUSE;

		Configuration c2 = new Configuration();
		c2.alpha = 0.9f;
		c2.epsilon = 1.0f;
		c2.indice = 30;
		c2.mode = Mode.CREUSE;

		assertEquals(c1,c2);
	
	}

}
