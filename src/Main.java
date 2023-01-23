import java.util.Scanner;
// import javafx.scene.chart.NumberAxis;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Animation.*;

public class Main {
    static ArrayList<Pemesanan> pemesananArr = new ArrayList<Pemesanan>();
    static Animation animation = new Animation();

    static public void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;

        // Object From Ori Class
        Jadwal jadwal = new Jadwal(null, null);
        Kereta kereta = new Kereta(null);
        Stasiun stasiun = new Stasiun(null, null);
        Pembayaran pembayaran = new Pembayaran(pemesananArr);
        Ticket ticket = new Ticket(kereta, jadwal, null, stasiun);

        jadwal.inisialData();
        kereta.inisialData();
        stasiun.inisialData();

        do {
            animation.clearScreen();

            System.out.println("       SELAMAT DATANG DI KAIKW ");
            LocalDate Date = LocalDate.now(); // Create a date object
            LocalTime Time = LocalTime.now(); // Create a date object

            System.out.println("====================================");
            System.out.println("| Date Now : " + Date + " | " + Time.getHour() + ":" + Time.getMinute() + " WIB |");
            System.out.println("====================================");
            System.out.println("1. Cek jadwal kereta"); // ngeprint
            System.out.println("2. Pemesanan tiket"); // Pesen
            System.out.println("3. Cetak Ticket");
            System.out.println("4. Exit");
            System.out.print(">> ");
            menu = scan.nextInt();
            scan.nextLine();

            switch (menu) {
                case 1:
                    animation.animate(5);
                    System.out.println();

                    jadwal.lihatJadwal();

                    animation.promptEnterKey();
                    break;
                case 2:
                    animation.animate(5);
                    Pemesanan.formUi(jadwal, kereta, stasiun, scan, animation, pemesananArr);
                    pembayaran.formUi(scan);
                    animation.promptEnterKey();
                    break;
                case 3:
                    ArrayList<Pemesanan> pemesanans = pembayaran.getPemesananArr();

                    for(int i = 0; i < pemesanans.size(); i++) {
                        pemesanans.get(i).ticket.cetakTiket();
                    }
                    if(pemesanans.size() == 0){
                        System.out.println("No Ticket Available !");
                    }

                    animation.promptEnterKey();
                    
                case 4:
                    break;
            }

        } while (menu != 4);
        System.out.println("Thanks :3");

        scan.close();
    }
}