package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.*;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class VormerkkarteTest
{

    private Kunde _kunde;
    private Vormerkkarte _karte;
    private Medium _medium;

    public VormerkkarteTest()
    {
        _medium = new CD("Karotten", "Toller Party-Song", "Die Hasen", 3);
        _kunde = new Kunde(new Kundennummer(430210), "Karl", "Max");
        _karte = new Vormerkkarte(_medium);
    }

    @Test
    public void testeFuegeHinzu()
    {
        assertTrue(_karte.istVormerkenMöglich());
        _karte.fuegeVormerkerHinzu(_kunde);
        assertFalse(_karte.istVormerkenMöglich(_kunde));
    }

    @Test
    public void testeEntfernen()
    {
        _karte.fuegeVormerkerHinzu(_kunde);
        assertFalse(_karte.istVormerkenMöglich(_kunde));
        _karte.entferneVormerker(_kunde);
        assertTrue(_karte.istVormerkenMöglich(_kunde));
    }

    @Test
    public void testeMehrAlsDreiKunden()
    {
        Kunde nummer1 = new Kunde(new Kundennummer(106253), "Holger", "Andora");
        Kunde nummer2 = new Kunde(new Kundennummer(402561), "Anna", "Lieb");
        Kunde nummer3 = new Kunde(new Kundennummer(426361), "Tim", "Müller");
        Kunde nummer4 = new Kunde(new Kundennummer(233356), "Mario", "Italia");

        _karte.fuegeVormerkerHinzu(nummer1);
        _karte.fuegeVormerkerHinzu(nummer2);
        _karte.fuegeVormerkerHinzu(nummer3);
        assertFalse(_karte.istVormerkenMöglich(nummer4));
    }

    @Test
    public void testeErstenVormerker()
    {
        Kunde nummer1 = new Kunde(new Kundennummer(106253), "Holger", "Andora");
        Kunde nummer2 = new Kunde(new Kundennummer(108973), "Anna", "Lieb");
        Kunde nummer3 = new Kunde(new Kundennummer(107463), "Karl", "Jobber");

        _karte.fuegeVormerkerHinzu(nummer1);
        _karte.fuegeVormerkerHinzu(nummer2);
        _karte.fuegeVormerkerHinzu(nummer3);
        assertTrue(_karte.istErsterVormerker(nummer1));
        _karte.entferneVormerker(nummer1);
        assertTrue(_karte.istErsterVormerker(nummer2));
    }

    @Test
    public void testeGetVormerker()
    {
        Kunde nummer1 = new Kunde(new Kundennummer(106253), "Holger", "Andora");
        Kunde nummer2 = new Kunde(new Kundennummer(108973), "Anna", "Lieb");
        Kunde nummer3 = new Kunde(new Kundennummer(107463), "Karl", "Jobber");

        _karte.fuegeVormerkerHinzu(nummer1);
        _karte.fuegeVormerkerHinzu(nummer2);
        _karte.fuegeVormerkerHinzu(nummer3);
        assertTrue(_karte.getVormerker(0)
            .equals(nummer1));
        assertFalse(_karte.getVormerker(1)
            .equals(nummer3));
    }

}
