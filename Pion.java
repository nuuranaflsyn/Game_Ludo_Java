class Pion {

    int newposition;
    int lastposition;
    boolean game_status;
    boolean onpapan;
    boolean hasablock;
    boolean double_pos;
    boolean double_pos_flag;

    Pion(int pionid, int pemainno) {
        lastposition = -1 * pemainno * 4 - pionid;
        onpapan = false;
        newposition = -1 * pemainno * 4 - pionid;
        game_status = false;
        double_pos = false;
        double_pos_flag = false;
    }

    int move_pion(int dadu_value, char symbol, int tno) {
        boolean invalid_move = false;
        lastposition = newposition;
        if (newposition < 0) {
            newposition = 1;
        }
        if (newposition > 50) {
            switch (newposition + dadu_value) {
                case 57:
                    this.game_status = true;
                    newposition = 57;
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                    newposition = newposition + dadu_value;
                    break;
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:

                    invalid_move = true;

                default:
                    ;
            }
        } else {
            newposition = newposition + dadu_value;
        }

        if (invalid_move) {
            System.out.println("Langkah tidak sesuai untuk pion yang dipilih");
            return -1;
        }
        if (double_pos) {
            double_pos = false;
            double_pos_flag = true;
        }
        return 0;
    }
}
