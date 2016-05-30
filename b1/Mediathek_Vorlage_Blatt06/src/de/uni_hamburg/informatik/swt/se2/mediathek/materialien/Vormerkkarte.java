package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.ArrayList;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class Vormerkkarte
{
    private ArrayList<Kunde> _vormerkListe;
    private final Medium _medium;
    private final int _maxVormerker;

    public Vormerkkarte(Medium medium)
    {
        assert medium != null : "Vorbedingung medium verletzt: null";

        _maxVormerker = 3;
        _vormerkListe = new ArrayList<>(_maxVormerker);
        _medium = medium;
    }

    /**
     * Prüft ob das Vormerken für einen Kunden möglich ist.
     * Die Kundenliste darf nicht voll sein und der Kunde darf
     * nicht in der Liste enthalten sein.
     * 
     * @param kunde
     * @return true wenn vormerken möglich ist.
     */
    public boolean istVormerkenMöglich(Kunde kunde)
    {
        return _vormerkListe.size() < _maxVormerker
                && !_vormerkListe.contains(kunde);
    }

    /**
     * Prüft ob der übergebene Kunde erster auf der Liste ist.
     * 
     * @param kunde
     * @return true wenn der Kunde an erster Stelle steht.
     */
    public boolean istErsterVormerker(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung kunde verletzt: null";

        return _vormerkListe.get(0)
            .getKundennummer()
            .equals(kunde.getKundennummer());

    }

    /**
     * Prüft ob das Vormerken generell gilt.
     * 
     * @return
     */
    public boolean istVormerkenMöglich()
    {
        return _vormerkListe.size() < _maxVormerker;
    }

    /**
     * Fügt den übergebenden Kunde in die Liste hinzu
     * wenn sie nicht voll ist und der Kunde sich nicht
     * in der Liste befindet.
     * @param kunde
     * 
     * @require kunde != null
     * @require istVormerkenMöglich(kunde)
     * 
     * @ensure _vormerkliste.contains(kunde)
     */
    public void fuegeVormerkerHinzu(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung kunde verletzt: null";
        
        if (istVormerkenMöglich(kunde))
        {
            _vormerkListe.add(kunde);
        }
        else
        {
            System.err.println("Der Kunde darf nicht vormerken!");
        }
    }

    /**
     * Entfernt den übergebenden Kunden aus der Liste und die anderen
     * Kunden rücken nach auf der Liste.
     * @param kunde
     * 
     * @require kunde != null
     * 
     * 
     * @ensure !_vormerkliste.contains(kunde)
     */
    public void entferneVormerker(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung kunde verletzt: null";

        if (_vormerkListe.contains(kunde))
        {

            _vormerkListe.remove(kunde);

        }
        else
        {
            System.err.println("Kunde kann nicht entfernt werden!");
        }

    }

    /**
     * Gibt das Medium zurück, worauf sich die Vormerkkarte bezieht.
     * @return
     * 
     */
    public Medium gibMedium()
    {
        return _medium;
    }

    /**
     * Gibt den Vormerker an der vorgegebenen Position zurück.
     * @param position
     * @return der Kunde an Position x
     * 
     * @require position >= 0
     */

    public Kunde getVormerker(int position)
    {
        if (position < _vormerkListe.size() && position >= 0)
        {
            return _vormerkListe.get(position);
        }
        else
        {
            return null;
        }

    }

}