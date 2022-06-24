public class Pemain {

    int nj;

    Pion pn[];
    char symbol;
    boolean block;
    int blockedcell;
    String color;


    Pemain(int pid, char c, String clr)
    {
        nj = pid;
        symbol =c;
        color =clr;
        pn = new Pion[4];
        for(int i =0; i<=3;i++)
            pn[i]= new Pion(i+1,pid-1);
    }
}
