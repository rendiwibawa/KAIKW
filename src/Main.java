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
            System.out.print(">> ");
            menu = scan.nextInt();
            switch(menu){
                case 1:
                lihatJadwal(arrJadwal);
            }
        } while (menu != 4);
        System.out.println("Thanks :3");

        scan.close();
    }

    static void lihatJadwal(ArrayList<Jadwal> arr){
        // int size = arr.size();
        for (Jadwal jadwal : arr) {
            System.out.println("==================================================================");
            System.out.println( "Kedatangan |\t"+jadwal.datang + "|Keberangkatan |\t" + jadwal.keberangkatan);
        }
        System.out.println("==================================================================");

    }

    static void inisialData(ArrayList<Jadwal> arrJadwal) {
        arrJadwal.add(new Jadwal("senin  -13.00  ","senin  -13.00"));
        arrJadwal.add(new Jadwal("selasa -13.20  ", "selasa -13.20"));
        arrJadwal.add(new Jadwal("minggu -11.00  ","minggu -11.00"));
    }
}

