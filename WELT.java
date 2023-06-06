import java.util.ArrayList;
public class WELT extends SPIEL
{

    BODENPLATTE [] böden; 
    BODENTEIL[][] stufen;
    TRAVELER t;
    
    
    public WELT(){
        super();
        FIGUR hintergrund = new FIGUR( "hintergrund2.png" );
        hintergrund.setzeMittelpunkt( 0 , 2 );
        hintergrund.skaliere(0.8);
        
        
        //Jedes BODEN-Objekt besteht aus vielen kleinen Figuren, 
        //welche nach dem Erstellen, nicht mehr verändert werden können.
        böden = new BODENPLATTE[5];
        böden[0] = new  BODENPLATTE(13, -13, -9.3);  
        for(int i = 1; i<böden.length;i++){
                böden[i] = new BODENPLATTE(3,-9+3*i,-9.3+3.5*i);
        }
        
        // Jedes BODENTEIL-Objekt ist eine eigene FIGUR und 2.13 lang
        stufen = new BODENTEIL[3][4];
            for(int i = 1; i<stufen.length;i++){
                for(int j = 1; j<stufen[i].length;j++){
                stufen[i][j] = new BODENTEIL();
                stufen[i][j].setzeMittelpunkt(2+i*2.13+3*j, 4.5-3.5*j);
            }
        }
        
        t= new TRAVELER();
       
    }

    
    void Level2(){
    
        böden = new BODENPLATTE[10];
        böden[0] = new  BODENPLATTE(13, -13, -9.3);  
        for(int i = 1; i<böden.length;i++){
                böden[i] = new BODENPLATTE(3,-9+2*i,-9.3+1.5*i);
        }
        
    }
    
    void Level3(){
    
        böden = new BODENPLATTE[10];
        böden[0] = new  BODENPLATTE(13, -13, -9.3);  
        for(int i = 1; i<böden.length;i++){
                böden[i] = new BODENPLATTE(3,-9+2*i,-9.3+1.5*i);
        }
        
    }
   
}