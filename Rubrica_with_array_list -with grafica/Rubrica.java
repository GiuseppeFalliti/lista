import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Rubrica {
    public ArrayList<Contatto> contatti; // array dinamico 
    public ArrayList<Contatto> arrayFavo; // array dinamico favoriti
    public static String regexNumber = "\\d{2} \\d{10}";

    /**
     * costruttore inizializza gli array dinamici.
     */
    public Rubrica() {
        contatti = new ArrayList<Contatto>();
        arrayFavo = new ArrayList<Contatto>();
    }

    public void addContact(String nome, String cognome, String numero, int mese, int anno, int giorno) {
        try {
            if (Pattern.matches(regexNumber, numero)) {
                DateTime dataToStringa = new DateTime(mese, anno, giorno);
                Contatto c1 = new Contatto(nome, cognome, numero, dataToStringa);
                contatti.add(c1);
                JOptionPane.showMessageDialog(null, c1);
            } else {
                JOptionPane.showMessageDialog(null, "NUMERO ERRATO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void searchNomeAndCognome(String data) {
        try {
            for (Contatto contatto : contatti) {
                if (contatto.getData().toString().equalsIgnoreCase(data)) {
                    JOptionPane.showMessageDialog(null, contatto);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "contatto non trovato");
        }
    }


    public void subbNumber(String nome, String cognome) {
        for (int i = 0; i < contatti.size(); i++) {
            if (contatti.get(i) != null && contatti.get(i).getNome().equalsIgnoreCase(nome)
                    && contatti.get(i).getCognome().equalsIgnoreCase(cognome)) {
                contatti.remove(i);
                JOptionPane.showMessageDialog(null, "contatto eliminato");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "contatto non esistente");
    }


    public String Numero(String nome, String cognome) {
        for (int i = 0; i < contatti.size(); i++) {
            if (contatti.get(i).getNome().equalsIgnoreCase(nome)
                    && contatti.get(i).getCognome().equalsIgnoreCase(cognome)) {
                return "numero telefono-->" + contatti.get(i).getNumero_telefono();
            }
        }
        return null;
    }


    public Contatto editContact(String nome, String cognome, String numbers) {
        for (int i = 0; i < contatti.size(); i++) {
            if (contatti.get(i) != null && contatti.get(i).getNome().equalsIgnoreCase(nome)
                    && contatti.get(i).getCognome().equalsIgnoreCase(cognome)) {
                if (Pattern.matches(regexNumber, numbers)) {
                    Contatto c2 = new Contatto(nome, cognome, numbers);
                    contatti.set(i, c2);
                    return c2;
                } else {
                    JOptionPane.showMessageDialog(null, "numero errato!");
                }
            }
        }
        return null;
    }


    public void AddfavitesContacts(String nome, String cognome) {
        try {
            for (int i = 0; i < contatti.size(); i++) {
                if (contatti.get(i).getNome().equalsIgnoreCase(nome) && contatti.get(i).getCognome().equalsIgnoreCase(cognome)) {
                    arrayFavo.add(contatti.get(i));
                    JOptionPane.showMessageDialog(null, contatti.get(i), "Contatto aggiunto nei preferiti", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "contatto non trovato");
        }
    }
    

    public Contatto editContactFavorites(String nome, String cognome, String numbers) {
        for (int i = 0; i < arrayFavo.size(); i++) {
            if (arrayFavo.get(i) != null && arrayFavo.get(i).getNome().equalsIgnoreCase(nome)
                    && arrayFavo.get(i).getCognome().equalsIgnoreCase(cognome)) {
                if (Pattern.matches(regexNumber, numbers)) {
                    Contatto c2 = new Contatto(nome, cognome, numbers);
                    arrayFavo.set(i, c2);
                    return c2;
                } else {
                    JOptionPane.showMessageDialog(null, "numero errato!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "contatto non esistente");
            }
        }
        return null;
    }

    public void printAllFavitesContacts() {
        for (Contatto c : arrayFavo) {
            JOptionPane.showMessageDialog(null, c);
        }
    }

    public void printAllContact() {
        for (Contatto c : contatti) {
            JOptionPane.showMessageDialog(null, c);
        }
    }
}
