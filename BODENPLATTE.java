
/**
 * Klasse zur Beschreibung eines Bodens
 * 
 * @author Klaus Reinold
 * @version 1.0
 */
public class BODENPLATTE
{
    /**
     * Konstruktor für Objekte der Klasse Boden
     * 
     * Das "Wiese.png" hat eine Breite von ca. 2.13
     */
    public BODENPLATTE(int anzahlElemente, double startX, double startY)
    {
        for ( int i=0 ; i<anzahlElemente ; i=i+1 )
        {
            FIGUR f = new FIGUR( "Wiese.png" );
            f.setzeMittelpunkt( startX+i*2.13 , startY );
            f.machePassiv();
        }
    }

}
