
public class TRAVELER extends FIGUR implements Ticker, TastenReagierbar
{

    private static final double v_idle = 0;
    private static final double v_walkR = 0.05;
    private static final double v_walkL = -0.05;
    private static final double v_runR = 0.2;
    private static final double v_runL = -0.2;

    private double vX;

    public TRAVELER()
    {
        super("idle","traveler_idle.gif");
        setzeMittelpunkt(-10,0);
        macheAktiv();
        fuegeZustandVonGifHinzu("walk","traveler_walk.gif");
        fuegeZustandVonGifHinzu("run","traveler_run.gif");
        fuegeZustandVonGifHinzu("jumpUp","traveler_jump_1up.gif");
        fuegeZustandVonGifHinzu("jumpTurn","traveler_jump_2midair.gif");
        fuegeZustandVonGifHinzu("jumpDown","traveler_jump_3down.gif");

        setzeAnimationsGeschwindigkeitVon("walk", 0.2);
        setzeAnimationsGeschwindigkeitVon("run", 0.2);
        setzeAnimationsGeschwindigkeitVon("jumpUp", 0.2);
        setzeAnimationsGeschwindigkeitVon("jumpTurn", 0.1);
        setzeAnimationsGeschwindigkeitVon("jumpDown", 0.2);

        setzeAutomatischenUebergang("jumpTurn","jumpDown");

        vX = v_idle;
        starteTickerNeu(0.04);
    }

    public void tick(){
        verschiebenUm(vX, 0);

        if(nenneAktivenZustand()=="jumpUp"&&nenneGeschwindigkeitY()<0){
            setzeZustand("jumpTurn");
        }

        if(nenneAktivenZustand()=="jumpDown" && steht()){
            if(vX==v_runR){
                setzeZustand("run");
            }
            else if(vX==v_walkR){
                setzeZustand("walk");
            }
            else if(vX==0){
                setzeZustand("idle");
            }
            else if(vX==v_walkL){
                setzeZustand("walk");
            }
            else if(vX==v_runL){
                setzeZustand("run");
            }
        }
    }

    public void tasteReagieren(int taste){

        //Taste Rechts einmalig gedrückt
        if(taste == TASTE.RECHTS){
            if(vX == v_runL){
                vX=v_walkL;
                setzeZustand("walk");
            }
            else if(vX == v_walkL){
                vX=v_idle;
                setzeZustand("idle");
            }
            else if(vX == v_idle){
                vX=v_walkR;
                setzeZustand("walk");
                spiegelnHorizontal(false);
            }
            else if(vX == v_walkR){
                vX=v_runR;
                setzeZustand("run");
            }
        }

        //Taste Links einmalig gedrückt
        if(taste == TASTE.LINKS){
            if(vX == v_runR){
                vX=v_walkR;
                setzeZustand("walk");
            }
            else if(vX == v_walkR){
                vX=v_idle;
                setzeZustand("idle");
            }
            else if(vX == v_idle){
                vX=v_walkL;
                setzeZustand("walk");
                spiegelnHorizontal(true);
            }
            else if(vX == v_walkL){
                vX=v_runL;
                setzeZustand("run");
            }
        }

        //Taste Oben einmalig gedrückt
        if(taste == TASTE.RAUF){
            springe(10);
            setzeZustand("jumpUp");
        }

        //Taste Runter einmalig gedrückt
        if(taste == TASTE.RUNTER){
            vX=v_idle;
            setzeZustand("idle");
        }
    }
}
