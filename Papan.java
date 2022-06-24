import java.io.FileNotFoundException;
import java.io.FileReader;
import static java.lang.System.exit;
import static java.lang.Thread.sleep;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Papan  {

    Map<Integer, Kordinat> maptable;
    Pemain p1, p2, p3, p4;
    Dadu d;
    public static char[][] papanarray;
    int row = 67, column = 92;
    boolean gameover = false;

    public Papan() {
        p1 = new Pemain(1, 'B', "BIRU");
        p2 = new Pemain(2, 'K', "KUNING");
        p3 = new Pemain(3, 'H', "HIJAU");
        p4 = new Pemain(4, 'M', "MERAH");
        d = new Dadu(p3);
        this.maptable = new HashMap<Integer, Kordinat>();
        create_maptable();
    }

    int get_absolute_position(int pid, int position) {
        if (position < 0) {
            return position;
        }
        switch (pid) {
            case 1:
                return position;
            case 2:
                if (0 <= position && position <= 38) {
                    return position + 13;
                } else if (39 <= position && position <= 51) {
                    return position - 39;
                } else if (52 <= position && position <= 57) {
                    return position + 6;
                }
            case 3:
                if (0 <= position && position <= 25) {
                    return position + 26;
                } else if (26 <= position && position <= 51) {
                    return position - 26;
                } else if (52 <= position && position < 57) {
                    return position + 12;
                }
            case 4:
                if (0 <= position && position <= 12) {
                    return position + 39;
                } else if (13 <= position && position <= 51) {
                    return position - 13;
                } else if (52 <= position && position < 57) {
                    return position + 18;
                }
        }
        return 0;
    }

    void create_maptable() {
        maptable.put(-1, new Kordinat(45, 10));
        maptable.put(-2, new Kordinat(45, 23));
        maptable.put(-3, new Kordinat(53, 10));
        maptable.put(-4, new Kordinat(53, 23));
        maptable.put(-5, new Kordinat(9, 10));
        maptable.put(-6, new Kordinat(9, 23));
        maptable.put(-7, new Kordinat(17, 10));
        maptable.put(-8, new Kordinat(17, 23));
        maptable.put(-9, new Kordinat(9, 64));
        maptable.put(-10, new Kordinat(9, 78));
        maptable.put(-11, new Kordinat(17, 64));
        maptable.put(-12, new Kordinat(17, 78));
        maptable.put(-13, new Kordinat(45, 64));
        maptable.put(-14, new Kordinat(45, 78));
        maptable.put(-15, new Kordinat(53, 64));
        maptable.put(-16, new Kordinat(53, 78));

        maptable.put(0, new Kordinat(58, 38));
        maptable.put(1, new Kordinat(54, 38));
        maptable.put(2, new Kordinat(50, 38));
        maptable.put(3, new Kordinat(46, 38));
        maptable.put(4, new Kordinat(42, 38));
        maptable.put(5, new Kordinat(38, 38));
        maptable.put(6, new Kordinat(34, 32));
        maptable.put(7, new Kordinat(34, 26));
        maptable.put(8, new Kordinat(34, 20));
        maptable.put(9, new Kordinat(34, 14));
        maptable.put(10, new Kordinat(34, 8));
        maptable.put(11, new Kordinat(34, 2));
        maptable.put(12, new Kordinat(30, 2));
        maptable.put(13, new Kordinat(26, 2));
        maptable.put(14, new Kordinat(26, 8));
        maptable.put(15, new Kordinat(26, 14));
        maptable.put(16, new Kordinat(26, 20));
        maptable.put(17, new Kordinat(26, 26));
        maptable.put(18, new Kordinat(26, 32));
        maptable.put(19, new Kordinat(22, 38));
        maptable.put(20, new Kordinat(18, 38));
        maptable.put(21, new Kordinat(14, 38));
        maptable.put(22, new Kordinat(10, 38));
        maptable.put(23, new Kordinat(6, 38));
        maptable.put(24, new Kordinat(2, 38));
        maptable.put(25, new Kordinat(2, 44));
        maptable.put(26, new Kordinat(2, 50));
        maptable.put(27, new Kordinat(6, 50));
        maptable.put(28, new Kordinat(10, 50));
        maptable.put(29, new Kordinat(14, 50));
        maptable.put(30, new Kordinat(18, 50));
        maptable.put(31, new Kordinat(22, 50));
        maptable.put(32, new Kordinat(26, 56));
        maptable.put(33, new Kordinat(26, 62));
        maptable.put(34, new Kordinat(26, 68));
        maptable.put(35, new Kordinat(26, 74));
        maptable.put(36, new Kordinat(26, 80));
        maptable.put(37, new Kordinat(26, 86));
        maptable.put(38, new Kordinat(30, 86));
        maptable.put(39, new Kordinat(34, 86));
        maptable.put(40, new Kordinat(34, 80));
        maptable.put(41, new Kordinat(34, 74));
        maptable.put(42, new Kordinat(34, 68));
        maptable.put(43, new Kordinat(34, 62));
        maptable.put(44, new Kordinat(34, 56));
        maptable.put(45, new Kordinat(38, 50));
        maptable.put(46, new Kordinat(42, 50));
        maptable.put(47, new Kordinat(46, 50));
        maptable.put(48, new Kordinat(50, 50));
        maptable.put(49, new Kordinat(54, 50));
        maptable.put(50, new Kordinat(58, 50));
        maptable.put(51, new Kordinat(58, 44));

        maptable.put(52, new Kordinat(54, 44));
        maptable.put(53, new Kordinat(50, 44));
        maptable.put(54, new Kordinat(46, 44));
        maptable.put(55, new Kordinat(42, 44));
        maptable.put(56, new Kordinat(38, 44));
        maptable.put(57, new Kordinat(34, 44));

        maptable.put(58, new Kordinat(30, 8));
        maptable.put(59, new Kordinat(30, 14));
        maptable.put(60, new Kordinat(30, 20));
        maptable.put(61, new Kordinat(30, 26));
        maptable.put(62, new Kordinat(30, 32));
        maptable.put(63, new Kordinat(30, 38));

        maptable.put(64, new Kordinat(6, 44));
        maptable.put(65, new Kordinat(10, 44));
        maptable.put(66, new Kordinat(14, 44));
        maptable.put(67, new Kordinat(18, 44));
        maptable.put(68, new Kordinat(22, 44));
        maptable.put(69, new Kordinat(26, 44));

        maptable.put(70, new Kordinat(30, 80));
        maptable.put(71, new Kordinat(30, 74));
        maptable.put(72, new Kordinat(30, 68));
        maptable.put(73, new Kordinat(30, 62));
        maptable.put(74, new Kordinat(30, 56));
        maptable.put(75, new Kordinat(30, 50));

    }

    void initialize_papan() {
        try {
            readFile("papanludo.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Tidak dapat memuat file papan. Berkas tidak ditemukan");
            exit(1);
        }
    }

    void gameplay() {
        Scanner input = new Scanner(System.in);
        Scanner pionchoice = new Scanner(System.in);
        String s, t = "";
        s = input.next();

        if (s.equalsIgnoreCase("S")) {
            gamestarted();
            displaypapan();
            while (!gameover) {
                s = input.next();
                if (s.equalsIgnoreCase("R")) {
                    int dv = d.setdaduvalue();
                    write_to_papan_array(64, 86, String.valueOf(dv));
                    displaypapan();
                    if (d.checkmove()) {
                        int valid_pion = 0;
                        boolean start = true;
                        while (valid_pion != 1) {
                            write_to_papan_array(64, 0, "                             ");
                            displaypapan();
                            if (!start) {
                                if (valid_pion == 0) {
                                    System.out.println("\"" + t + "\"" + "Pion ini belum bisa bergerak");
                                }
                            }
                            System.out.println("Pilih pion yang ingin digerakkan (1,2,3,4):");
                            t = pionchoice.next();
                            int tno;
                            try {
                                tno = Integer.parseInt(t) - 1;
                                valid_pion = d.pion_movement(tno, p1, p2, p3, p4);

                                if (valid_pion == 100) {
                                    write_to_papan_array(66, 11, d.current_pemain.color + "            ");
                                    updatePapan();
                                    displaypapan();
                                    System.out.println("PERMAINAN SELESAI");
                                    exit(0);
                                }

                                if (valid_pion != 0) {
                                    check_jumped_upon(tno);
                                    if (double_position(d.current_pemain.pn[tno], d.current_pemain) == 2) {
                                        int cell = get_absolute_position(d.current_pemain.nj, d.current_pemain.pn[tno].newposition);
                                        if (cell <= 51) {
                                            d.current_pemain.block = true;
                                            d.current_pemain.blockedcell = cell;
                                        }
                                    }
                                }

                            } catch (NumberFormatException e) {
                                valid_pion = 0;
                            }

                            start = false;
                        }
                        write_to_papan_array(64, 0, "TEKAN \"R\" UNTUK ROLL DADU.");

                    }
                    set_turn();
                    updatePapan();
                    displaypapan();

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Papan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    void readFile(String file) throws FileNotFoundException {

        papanarray = new char[row][column];
        Scanner papan = new Scanner(new FileReader("papanludo.txt"));
        String line;
        try {
            line = papan.nextLine();
            int lineno = 0;
            while (line != null) {

                line = papan.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    papanarray[lineno][i] = line.charAt(i);
                }
                lineno++;
            }
        } catch (NoSuchElementException e) {
        }
        displaypapan();

    }

    private void gamestarted() {
        d.current_pemain = p1;
        write_to_papan_array(62, 86, "BIRU");
        write_to_papan_array(62, 0, "GAME DIMULAI                ");
    }

    static void write_to_papan_array(int r1, int c1, String inputstring) {
        for (int i = c1; i <= c1 + inputstring.length() - 1; i++) {
            papanarray[r1][i] = inputstring.charAt(i - c1);
        }
    }

    private void displaypapan() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                System.out.printf("%c", papanarray[r][c]);
            }
            System.out.println();
        }
    }

    private void updatePapan() {

        for (int i = 0; i <= 3; i++) {
            Kordinat op = map_position_to_kordinat(get_absolute_position(p1.nj, p1.pn[i].lastposition), p1.nj);
            Kordinat np = map_position_to_kordinat(get_absolute_position(p1.nj, p1.pn[i].newposition), p1.nj);

            if ((double_position(p1.pn[i], p1) != 1) && (double_position(p1.pn[i], p2) != 1) && (double_position(p1.pn[i], p3) != 1) && (double_position(p1.pn[i], p4) != 1)) {
                write_to_papan_array(op.x, op.y, "  ");
            }
            write_to_papan_array(np.x, np.y, p1.symbol + String.valueOf(i + 1));
        }

        for (int i = 0; i <= 3; i++) {
            Kordinat op = map_position_to_kordinat(get_absolute_position(p2.nj, p2.pn[i].lastposition), p2.nj);
            Kordinat np = map_position_to_kordinat(get_absolute_position(p2.nj, p2.pn[i].newposition), p2.nj);

            if ((double_position(p2.pn[i], p1) != 1) && (double_position(p2.pn[i], p2) != 1) && (double_position(p2.pn[i], p3) != 1) && (double_position(p2.pn[i], p4) != 1)) {

                write_to_papan_array(op.x, op.y, "  ");
            }
            write_to_papan_array(np.x, np.y, p2.symbol + String.valueOf(i + 1));
        }

        for (int i = 0; i <= 3; i++) {
            Kordinat op = map_position_to_kordinat(get_absolute_position(p3.nj, p3.pn[i].lastposition), p3.nj);
            Kordinat np = map_position_to_kordinat(get_absolute_position(p3.nj, p3.pn[i].newposition), p3.nj);

            if ((double_position(p3.pn[i], p1) != 1) && (double_position(p3.pn[i], p2) != 1) && (double_position(p3.pn[i], p3) != 1) && (double_position(p3.pn[i], p4) != 1)) {
                write_to_papan_array(op.x, op.y, "  ");
            }
            write_to_papan_array(np.x, np.y, p3.symbol + String.valueOf(i + 1));
        }

        for (int i = 0; i <= 3; i++) {
            Kordinat op = map_position_to_kordinat(get_absolute_position(p4.nj, p4.pn[i].lastposition), p4.nj);
            Kordinat np = map_position_to_kordinat(get_absolute_position(p4.nj, p4.pn[i].newposition), p4.nj);

            if ((double_position(p4.pn[i], p1) != 1) && (double_position(p4.pn[i], p2) != 1) && (double_position(p4.pn[i], p3) != 1) && (double_position(p4.pn[i], p4) != 1)) {
                write_to_papan_array(op.x, op.y, "  ");
            }
            write_to_papan_array(np.x, np.y, p4.symbol + String.valueOf(i + 1));
        }

        switch (d.current_pemain.nj) {
            case 1:
                write_to_papan_array(62, 86, "BIRU");
                break;
            case 2:
                write_to_papan_array(62, 86, "KUNING");
                break;
            case 3:
                write_to_papan_array(62, 86, "HIJAU");
                break;
            case 4:
                write_to_papan_array(62, 86, "MERAH");
                break;
            default:
                System.out.println("");
                break;
        }
    }

    private Kordinat map_position_to_kordinat(int position, int pid) {
        return maptable.get(position);
    }

    void set_turn() {

        if (d.dadu_value != 6) {
            if (d.current_pemain == p1) {
                d.current_pemain = p2;
            } else if (d.current_pemain == p2) {
                d.current_pemain = p3;
            } else if (d.current_pemain == p3) {
                d.current_pemain = p4;
            } else if (d.current_pemain == p4) {
                d.current_pemain = p1;
            }
        }

        d.last_value = d.dadu_value;
        write_to_papan_array(64, 86, String.valueOf(" "));
        write_to_papan_array(66, 86, String.valueOf(d.last_value));
    }

    private void check_jumped_upon(int tno) {
        for (int i = 0; i <= 3; i++) {
            if (get_absolute_position(p1.nj, p1.pn[i].newposition) == get_absolute_position(d.current_pemain.nj, d.current_pemain.pn[tno].newposition)) {
                if (p1.nj != d.current_pemain.nj) {
                    p1.pn[i].newposition = -1 * 0 * 4 - i - 1;
                    p1.pn[i].onpapan = false;
                }
            }

            if (get_absolute_position(p2.nj, p2.pn[i].newposition) == get_absolute_position(d.current_pemain.nj, d.current_pemain.pn[tno].newposition)) {
                if (p2.nj != d.current_pemain.nj) {
                    p2.pn[i].newposition = -1 * 1 * 4 - i - 1;
                    p2.pn[i].onpapan = false;
                }
            }

            if (get_absolute_position(p3.nj, p3.pn[i].newposition) == get_absolute_position(d.current_pemain.nj, d.current_pemain.pn[tno].newposition)) {
                if (p3.nj != d.current_pemain.nj) {
                    p3.pn[i].newposition = -1 * 2 * 4 - i - 1;
                    p3.pn[i].onpapan = false;
                }
            }

            if (get_absolute_position(p4.nj, p4.pn[i].newposition) == get_absolute_position(d.current_pemain.nj, d.current_pemain.pn[tno].newposition)) {
                if (p4.nj != d.current_pemain.nj) {
                    p4.pn[i].newposition = -1 * 3 * 4 - i - 1;
                    p4.pn[i].onpapan = false;
                }
            }
        }

    }

    private int double_position(Pion tk, Pemain p) {

        for (int i = 0; i <= 3; i++) {
            if (tk != p.pn[i]) {
                if ((tk.lastposition == p.pn[i].newposition)) {
                    return 1;
                }
            }
        }

        for (int i = 0; i <= 3; i++) {
            if ((p.pn[i].newposition == tk.newposition) && (tk != p.pn[i])) {
                return 2;
            }
        }
        return 0;
    }
}
