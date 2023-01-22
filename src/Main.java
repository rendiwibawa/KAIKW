import java.util.Scanner;
// import javafx.scene.chart.NumberAxis;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    static ArrayList<Pemesanan> pemesananArr = new ArrayList<Pemesanan>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;

        // Object From Ori Class
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
                    Load_Animate.animate(5);
                    pesan(jadwal, kereta, stasiun, scan);
                    break;
                case 3:
                    Load_Animate.animate(5);
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
        int stasiunInput;
        int jadwalInput; 
        int keretaInput;

        do { //nama
            System.out.print("Masukkan nama anda : ");
            nama = sc.nextLine();
        } while (nama.length() < 1);

        do { //email
            System.out.print("Masukkan email anda : ");
            email = sc.nextLine();
        } while (email.length() < 1 || !email.contains("@"));

        do{ //nomor telepon
            System.out.print("Masukkan nomor telepon : ");
            noTelp = sc.nextInt();
        }while(noTelp < 1);
        
        Pelanggan pelanggan = new Pelanggan(nama, email, noTelp);


        do{ // Stasiun
            stasiun.printData();
            System.out.print("Pilih Stasiun (1 - 3) : ");
            stasiunInput = sc.nextInt() - 1;
        }while(stasiunInput < 0 || stasiunInput > 2);
        

        // Jadwal
        do{
            jadwal.lihatJadwal();
            System.out.print("Pilih waktu keberangkatan (1 - 3) : ");
            jadwalInput = sc.nextInt() - 1;
        }while (jadwalInput < 0 || jadwalInput > 2);
        

        // Kereta
        do{
            kereta.printKereta();
            System.out.print("Pilih Kereta (1 - 5) : ");
            keretaInput = sc.nextInt() - 1;
        }while(keretaInput < 0 || keretaInput > 4);
        

        // Kelas
        // TODO: Tambahkan pilihan kelas serta harganya
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

        // TODO: Buat kalkulasi harga bedasarkan kelas yang dipilih
        ticket.harga = jumlah * 10000;

        Pemesanan pemesanan = new Pemesanan(ticket);
        pemesananArr.add(pemesanan);


        // Pembayaran pembayaran = new Pembayaran(pemesananArr);

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
