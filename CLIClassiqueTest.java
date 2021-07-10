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

		Configuration c1 = new Configuration;
		c1.setAlpha() = 0.9f;
		c1.setEpsilon() = 1.0f;
		c1.setIndice() = 30f;
		c1.setMode() = CREUSE;

		Configuration c2 = new Configuration;
		c2.setAlpha() = 0.9f
		c2.setEpsilon() = 1.0f;
		c2.setIndice() = 30f;
		c2.setMode() = CREUSE;

		assertEquals(c1,c2);
	
	}

}
