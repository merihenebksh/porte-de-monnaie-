package junit.monprojet.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mon_projet_test.PorteMonnaie;
import mon_projet_test.SommeArgent;

public class PorteMonnaieTest {
    private PorteMonnaie porteMonnaie;

    @Before
    public void setUp() {
        porteMonnaie = new PorteMonnaie();
    }

    @Test
    public void testAjouteSomme() {
        SommeArgent somme1 = new SommeArgent(5, "EUR");
        SommeArgent somme2 = new SommeArgent(5, "EUR");

        
        porteMonnaie.ajouteSomme(somme1);

        assertEquals("Contenu du porte-monnaie:\n5 EUR\n", porteMonnaie.toString());

        porteMonnaie.ajouteSomme(somme2);

        assertEquals("Contenu du porte-monnaie:\n10 EUR\n", porteMonnaie.toString());
    }
}
