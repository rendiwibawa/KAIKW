import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Jadwal> arrJadwal = new ArrayList<Jadwal>(); 

        inisialData(arrJadwal);
        int menu;
        do {
            System.out.println("===== SELAMAT DATANG DI KAIKW ======");
            System.out.println("1. Cek jadwal kereta"); // ngeprint
            System.out.println("2. Pemesanan tiket"); // Pesen
            System.out.println("3. Cetak tiket"); 
            System.out.println("4. Exit");
            System.out.println(">> ");
            menu = scan.nextInt();
            switch(menu){
                case 1:
                lihatJadwal(arrJadwal);
            }
        } while (menu != 4);

        scan.close();
    }
    // Hallo

    static void lihatJadwal(ArrayList<Jadwal> arr){
        // int size = arr.size();
        for (Jadwal jadwal : arr) {
            System.out.println(jadwal.datang + " " + jadwal.keberangkatan);
        }
    }

    static void inisialData(ArrayList<Jadwal> arrJadwal) {
        arrJadwal.add(new Jadwal("senin", "selasa"));
    }
}

