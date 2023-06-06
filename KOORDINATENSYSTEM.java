
/**
 * Write a description of class KOORDINATENSYSTEM here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KOORDINATENSYSTEM
{
    RECHTECK xAchse;
    RECHTECK[] xAchseStriche;
    TEXT[] xAchseTexte;
    RECHTECK yAchse;
    RECHTECK[] yAchseStriche;
    TEXT[] yAchseTexte; 
    int breite;
    int höhe;
    public KOORDINATENSYSTEM()
    {
        breite = 13;
        höhe = 10;
        xAchseStriche=new RECHTECK[2*breite+1];
        yAchseStriche=new RECHTECK[2*höhe+1];
        xAchseTexte = new TEXT[2*breite+1];
        yAchseTexte = new TEXT[2*breite+1];

        xAchse = new RECHTECK(30,0.1);
        xAchse.setzeMittelpunkt(0, 0);
        xAchse.setzeFarbe("Schwarz");
        yAchse = new RECHTECK(0.1,30);
        yAchse.setzeMittelpunkt(0, 0);
        yAchse.setzeFarbe("Schwarz");
        for(int i = -breite; i<=breite;i++){
            int a = 0;
            if(i!=0){
                xAchseTexte[i+breite] = new TEXT(i,a-0.5,0.5,i);
                xAchseTexte[i+breite].setzeFarbe("Blau");
                xAchseStriche[i+breite] = new RECHTECK(0.05,2*höhe+1);
                xAchseStriche[i+breite].setzeMittelpunkt(i, a);
                xAchseStriche[i+breite].setzeFarbe("Schwarz");
            }
        }
        for(int i = -höhe; i<=höhe;i++){
            int a = 0;
            if(i!=0){
                yAchseTexte[i+höhe] = new TEXT(a+0.5,i,0.5,i);
                yAchseTexte[i+höhe].setzeFarbe("Blau");
                yAchseStriche[i+höhe] = new RECHTECK(breite*2+1,0.05);
                yAchseStriche[i+höhe].setzeMittelpunkt(a, i);
                yAchseStriche[i+höhe].setzeFarbe("Schwarz");
            }
        }

    }

    void setzeSichtbar(boolean sichtbar){
        xAchse.setzeSichtbar(sichtbar);
        yAchse.setzeSichtbar(sichtbar);
        for(int i = 0; i<yAchseStriche.length;i++){
            if(yAchseStriche[i]!=null){
                yAchseStriche[i].setzeSichtbar(sichtbar);
            }
        }
        for(int i = 0; i<xAchseStriche.length;i++){
            if(xAchseStriche[i]!=null){
                xAchseStriche[i].setzeSichtbar(sichtbar);
            }
        }
        for(int i = 0; i<xAchseTexte.length;i++){
            if(xAchseTexte[i]!=null){
                xAchseTexte[i].setzeSichtbar(sichtbar);
            }
        }
        for(int i = 0; i<yAchseTexte.length;i++){
            if(yAchseTexte[i]!=null){
                yAchseTexte[i].setzeSichtbar(sichtbar);
            }
        }
    }

    void einblenden(){
        setzeSichtbar(true);
    }

    void ausblenden(){
        setzeSichtbar(false);
    } 

}