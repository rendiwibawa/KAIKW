import java.util.Scanner;

import javax.swing.text.AbstractDocument.Content;

import javafx.scene.chart.NumberAxis;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;

        // Object From Ori Clas
        Jadwal jadwal = new Jadwal(null, null);
        Kereta kereta = new Kereta(null);
        Stasiun stasiun = new Stasiun(null, null);

        jadwal.inisialData();
        kereta.inisialData();
        stasiun.inisialData();

        do {
            clearScreen();

            System.out.println("       SELAMAT DATANG DI KAIKW ");
            LocalDate Date = LocalDate.now(); // Create a date object
            LocalTime Time = LocalTime.now(); // Create a date object

            System.out.println("====================================");
            System.out.println("| Date Now : " + Date + " | " + Time.getHour() + ":" + Time.getMinute() + " WIB |");
            System.out.println("====================================");
            System.out.println("1. Cek jadwal kereta"); // ngeprint
            System.out.println("2. Pemesanan tiket"); // Pesen
            System.out.println("3. Cetak tiket");
            System.out.println("4. Exit");
            System.out.print(">> ");
            menu = scan.nextInt();
            scan.nextLine();

            switch (menu) {
                case 1:
                    Load_Animate.animate(5);
                    System.out.println();

                    jadwal.lihatJadwal();

                    promptEnterKey();
                    break;
                case 2:
                    pesan(jadwal, kereta, stasiun, scan);
                    break;
                case 3:
                    System.out.println("CETAK TIKET");
                    promptEnterKey();
                    break;

            }

        } while (menu != 4);
        System.out.println("Thanks :3");

        scan.close();
    }

    public static void promptEnterKey() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // scanner.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pesan(Jadwal jadwal, Kereta kereta, Stasiun stasiun, Scanner sc) {
        System.out.println("PESAN TIKET");
        String nama, email;
        int noTelp;

        do {
            System.out.println("Masukkan nama anda : ");
            nama = sc.nextLine();

        } while (nama.length() < 1);

        do {
            System.out.println("Masukkan email anda : ");
            email = sc.nextLine();
        } while (email.length() < 1 || !email.contains("@"));

        do{
            System.out.println("Masukkan nomor telepon : ");
            noTelp = sc.nextInt();
        }while(noTelp < 1);
        

        Pelanggan pelanggan = new Pelanggan(nama, email, noTelp);

        // Stasiun
        stasiun.printData();
        System.out.println("Pilih Stasiun (1 - 3) : ");
        int stasiunInput = sc.nextInt() - 1;

        // Jadwal
        jadwal.lihatJadwal();
        System.out.println("Pilih waktu keberangkatan (1 - 3) : ");
        int jadwalInput = sc.nextInt() - 1;

        // Kereta
        kereta.printKereta();
        System.out.println("Pilih Kereta (1 - 5) : ");
        int keretaInput = sc.nextInt() - 1;

        // Kelas
        System.out.println("Pilih Kelas kereta (Ekonomi|Eksekutif|Bisnis) : ");
        String kelas = sc.nextLine();

        Ticket ticket = new Ticket(
                kereta.getKereta(keretaInput),
                jadwal.getJadwal(jadwalInput),
                pelanggan,
                stasiun.getStasiun(stasiunInput));

        // Jumlah Kursi
        int kursiTersedia = kereta.getKereta(keretaInput).showJumlahKursi();
        System.out.println("Pilih jumlah kursi " + kursiTersedia + " : ");
        int jumlah = sc.nextInt();

        kereta.getKereta(keretaInput).updateJumlahKursi(jumlah);
        ticket.kelas = kelas;
        ticket.harga = jumlah * 10000;

        promptEnterKey();
    }
}

class Load_Animate {
    static byte anime;

    static void animate(int i) {
        try {
            for (int j = 0; j <= 100; j++) {
                switch (anime) {
                    case 1:
                        System.out.print("\r[ \\ ] :" + j + "%");
                        break;
                    case 2:
                        System.out.print("\r[ | ] :" + j + "%");
                        break;
                    case 3:
                        System.out.print("\r[ / ] :" + j + "%");
                        break;
                    default:
                        anime = 0;
                        System.out.print("\r[ - ] :" + j + "%");
                }
                anime++;
                Thread.sleep(i);
            }
            System.out.println(" Success");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
