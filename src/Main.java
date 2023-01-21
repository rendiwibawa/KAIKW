import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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
                lihatJadwal();
            }
        } while (menu != 4);

    }
    // Hallo

    static void lihatJadwal(){
        Jadwal jadwal = new Jadwal(); 
        jadwal.
    }
}

