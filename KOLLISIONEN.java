
public class KOLLISIONEN extends SPIEL{
    KUGEL k1;
    KUGEL k2;
    RECHTECK r;

    public KOLLISIONEN(){
        super(1600,900,true);//Maus aktivieren
        zeigeKoordinatensystem(true);
        randErzeugen();
        
        k1 = new KUGEL();
        k1.setzeMittelpunkt(3, 0);
        
        
        //Schwerkraft insgesamt aussetzen und k1 an der Physik teilnehmen lassen
        setzeSchwerkraft(0);
        k1.macheAktiv();
        k1.setzeElastizitaet(0.5);
        

        //Zweite Kugel
        k2 = new KUGEL(); k2.setzeMittelpunkt(-5, 0); k2.macheAktiv(); k2.setzeElastizitaet(0.5);

        //Größere Kugel -> mehr Fläche -> mehr Masse -> schwerer zu bewegen
        k2.setzeRadius(5);
        
        //Standdarddichte ist 10 -> weniger Dichte -> weniger Masse -> leichter zu bewegen
        k2.setzeDichte(1);

        //neues Rechteck
        r = new RECHTECK(); r.setzeMittelpunkt(0, 8); r.macheAktiv(); r.setzeElastizitaet(0.9);
        
        //Rotation aktiveren
        r.setzeRotationBlockiert(false);
        
        //Zwei Objekte werden mit fester Entfernung verbunden       
        k2.erzeugeStabverbindung(r, k2.nenneMx(), k2.nenneMy(),r.nenneMx(), r.nenneMy() );
        
        
        

    }

    public void klickReagieren(double x, double y){
        double deltaX = x-k1.nenneMx();
        double deltaY = y-k1.nenneMy();
        k1.wirkeImpuls(deltaX*40, deltaY*40);
    }
    
    public void randErzeugen(){
        RECHTECK randLinks = new RECHTECK();
        randLinks.setzeGroesse(1,30);
        randLinks.setzeFarbe("rot");
        randLinks.setzeMittelpunkt(-26.6, 0);
        randLinks.machePassiv();

        RECHTECK randRechts = new RECHTECK();
        randRechts.setzeGroesse(1,30);
        randRechts.setzeFarbe("rot");
        randRechts.setzeMittelpunkt(26.6, 0);
        randRechts.machePassiv();

        RECHTECK randOben = new RECHTECK();
        randOben.setzeGroesse(55,1);
        randOben.setzeFarbe("rot");
        randOben.setzeMittelpunkt(0, 15);
        randOben.machePassiv();

        RECHTECK randUnten = new RECHTECK();
        randUnten.setzeGroesse(55,1);
        randUnten.setzeFarbe("rot");
        randUnten.setzeMittelpunkt(0,-15);
        randUnten.machePassiv();
    }

}
