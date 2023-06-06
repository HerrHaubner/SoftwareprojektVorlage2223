public class JUMPnRUN extends SPIEL{
    FIGUR obb;
    FIGUR plattform;
    FIGUR plattform2;
    FIGUR bombe1;
    FIGUR bombe2;
    FIGUR bombe3;
    FIGUR pilz;
    public JUMPnRUN(){
        zeigeKoordinatensystem(true);
        obb = new FIGUR("obb.png");
        plattform = new FIGUR("plattform.png");
        plattform2 = new FIGUR("plattform.png");
        bombe1 = new FIGUR("bombe.png");
        bombe2 = new FIGUR("bombe.png");
        bombe3 = new FIGUR("bombe.png");
        pilz = new FIGUR("pilz.png");
        setzePositionen();
        warte(2);

        //Auf aktive Objekte wirkt die Schwerkraft und sie nehmen damit an der Physik teil
        obb.macheAktiv();

        //Passive Objekte nehmen nicht an der Physik teil, aber sie können von aktiven Objekten nicht durchdrungen werden.
        plattform.machePassiv();
        plattform2.machePassiv();

        //Gerade(Zeit, PositionX, PositionY, HinUndZurück)
        bombe1.animiereGerade(1, 10, 2.5, true);

        //Kreis(Zeit, MittelpunktX, MittelpunktY, imUhrzeigersinn, BildMitDrehen)
        bombe2.animiereKreis(5, 9, 0, false, true);

        //Transparenz(Zeit, Transparenzwert zwischen 0 und 1) 
        bombe3.animiereTransparenz(3, 0.5);
        
        //Elastizitätswert zwischen 0 und 1 (Wert nahe 1 bedeutet Flummi)
        obb.setzeElastizitaet(0.3);
        
        //Der Pilz nimmt nun auch an der Physik teil, und kann vom OBB geschoben werden
        pilz.macheAktiv();
                
    }

    public void tasteReagieren(int taste){
        if(taste == TASTE.RAUF){
            obb.springe(12);
        }
        
    }

    public void bildAktualisierungReagieren(double s){
        if(istTasteGedrueckt(TASTE.RECHTS)){
            obb.verschiebenUm(0.1, 0);
        }
        if(istTasteGedrueckt(TASTE.LINKS)){
            obb.verschiebenUm(-0.1, 0);
        }
    }

    public void setzePositionen(){
        obb.setzeMittelpunkt(-1.5,0);
        plattform.setzeMittelpunkt(0, -5);
        plattform2.setzeMittelpunkt(5, -5);
        bombe1.setzeMittelpunkt(7, 2.5);
        bombe2.setzeMittelpunkt(7, 0);
        bombe3.setzeMittelpunkt(7, 5);
        pilz.setzeMittelpunkt(2, -4);
    }

    
}