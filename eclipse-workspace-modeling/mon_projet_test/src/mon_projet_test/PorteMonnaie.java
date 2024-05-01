package mon_projet_test;

import java.util.HashMap;
import java.util.Objects;

public class PorteMonnaie {
    private HashMap<String, Integer> contenu;

    public PorteMonnaie() {
        contenu = new HashMap<>();
    }

    public void ajouteSomme(SommeArgent somme) {
        String unite = somme.getUnite();
        int quantite = somme.getQuantite();

        contenu.put(unite, contenu.getOrDefault(unite, 0) + quantite);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contenu du porte-monnaie:\n");
        for (String unite : contenu.keySet()) {
            int quantite = contenu.get(unite);
            sb.append(quantite).append(" ").append(unite).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PorteMonnaie other = (PorteMonnaie) obj;
        return Objects.equals(contenu, other.contenu);
    }
}
