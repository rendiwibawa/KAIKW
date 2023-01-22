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
            System.out.println("3. Exit");
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
                    Pembayaran pembayaran = new Pembayaran(pemesananArr);
                    pembayaran.formUi(scan);
                    break;
            }

        } while (menu != 4);
        System.out.println("Thanks :3");

        scan.close();
    }
}