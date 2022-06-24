public class Dadu{

    Pemain current_pemain;
    int dadu_value;
    int last_value;

    Dadu(Pemain p) {

        current_pemain = p;
        dadu_value = 0;
        last_value = 0;
    }

    private void set_pion_onpapan(Pemain cp, int tno) {

        cp.pn[tno].onpapan = true;
        cp.pn[tno].newposition = 1;

    }

    int setdaduvalue() {
        dadu_value = (int) (Math.random() * 6 + 1);
        return dadu_value;
    }

    boolean checkmove() {
        if (current_pemain.pn[0].onpapan || current_pemain.pn[1].onpapan || current_pemain.pn[2].onpapan || current_pemain.pn[3].onpapan || (dadu_value == 6)) {
            return true;
        } else {
            return false;
        }
    }

    int pion_movement(int tno, Pemain p1, Pemain p2, Pemain p3, Pemain p4) {
        try {
            if (current_pemain.pn[tno].onpapan && !(current_pemain.pn[tno].game_status)) {

                if (!checkblock(current_pemain, tno, p1, p2, p3, p4)) {

                    int a = current_pemain.pn[tno].move_pion(dadu_value, current_pemain.symbol, tno);

                    if (gameover()) {
                        return 100;
                    }

                    if (current_pemain.block && blockbroken(tno)) {
                        current_pemain.block = false;
                    }

                    if (a == -1) {
                        return -1;
                    }

                } else {
                    return 0;
                }

            } else {
                if (dadu_value == 6) {
                    set_pion_onpapan(current_pemain, tno);
                } else {
                    return 0;
                }

            }
        } catch (Exception e) {
            return 0;
        }
        return 1;

    }

    private boolean checkblock(Pemain cp, int tno, Pemain p1, Pemain p2, Pemain p3, Pemain p4) {

        Papan b = new Papan();

        if (p1.block && cp != p1) {
            for(int i = 1; i<=dadu_value;i++)
            {
                if (b.get_absolute_position(cp.nj,(cp.pn[tno].newposition+i))==p1.blockedcell)
                    return true;
            }
        }

        if (p2.block && cp != p2) {
            for(int i = 1; i<=dadu_value;i++)
            {
                if (b.get_absolute_position(cp.nj,(cp.pn[tno].newposition+i))==p2.blockedcell)
                    return true;
            }
        }

        if (p3.block && cp != p3) {
            for(int i = 1; i<=dadu_value;i++)
            {
                if (b.get_absolute_position(cp.nj,(cp.pn[tno].newposition+i))==p3.blockedcell)
                    return true;
            }
        }

        if (p4.block && cp != p4) {
            for(int i = 1; i<=dadu_value;i++)
            {
                if (b.get_absolute_position(cp.nj,(cp.pn[tno].newposition+i))==p4.blockedcell)
                    return true;
            }
        }

        return false;

    }

    private boolean blockbroken(int tno) {

        for (int x = 0; x <= 3; x++) {
            for (int y =0;y<=3;y++)
            {
                if (current_pemain.pn[x].newposition == current_pemain.pn[y].newposition && y != x) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean gameover() {

        for (int i = 0; i <= 3; i++) {
            if (!current_pemain.pn[i].game_status) {
                return false;
            }
        }

        return true;

    }

}
