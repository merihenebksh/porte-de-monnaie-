package junit.monprojet.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import mon_projet_test.SommeArgent;
import mon_projet_test.UniteDistincteException;

public class SommeArgentTest {

    private static int counter = 0;
    private SommeArgent m12CHF;
    private SommeArgent m14CHF;
    private SommeArgent m14USD;

    @Before
    public void setUp() {
        counter++;
        System.out.println(counter + "ime passage avant exécution d'une méthode de test");
        m12CHF = new SommeArgent(12, "CHF");
        m14CHF = new SommeArgent(14, "CHF");
        m14USD = new SommeArgent(14, "USD");
    }

    @After
    public void tearDown() {
        System.out.println(counter + "ime passage APRES exécution d'une méthode de test");
    }

    @Test(expected = UniteDistincteException.class)
    public void testAdditionUnitesDistinctes() throws UniteDistincteException {
        SommeArgent somme1 = new SommeArgent(10, "EUR");
        SommeArgent somme2 = new SommeArgent(20, "USD");
        somme1.add(somme2);
    }

    @Test
    public void testAddition() throws UniteDistincteException {
        SommeArgent somme1 = new SommeArgent(10, "EUR");
        SommeArgent somme2 = new SommeArgent(20, "EUR");
        SommeArgent resultat = somme1.add(somme2);
        assertEquals(30, resultat.getQuantite());
        assertEquals("EUR", resultat.getUnite());
    }

    @Test
    public void testEquals() {
        assertTrue(!m12CHF.equals(null));
        assertEquals(m12CHF, m12CHF);
        assertEquals(m12CHF, new SommeArgent(12, "CHF"));
        assertTrue(!m12CHF.equals(m14CHF));
        assertTrue(!m14USD.equals(m14CHF));
    }
}
