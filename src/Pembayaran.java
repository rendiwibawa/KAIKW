import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

class Pembayaran {
    // Ticket ticket = new Ticket();
    ArrayList<Pemesanan> pemesanans;
    private int totalHarga;
    int uangBayar;

    String metodeBayar;
    String kelas; // Pemesanan
    Time waktuBayar;
    
    int x = 0;

    Pembayaran(ArrayList<Pemesanan> pemesanans) {
        this.pemesanans = pemesanans;
    }

    void setTotalHarga(int jml){
        totalHarga = jml * x;
    }

    int getTotalHarga(){
        return totalHarga;
    }

    public void formUi(Scanner sc) {
        System.out.println("Pembayaran");

        System.out.println("Id Tiket yang dipesan :");
        int i = 1;
        for (Pemesanan pemesanan : pemesanans) {
            System.out.println(i++ + ". " + pemesanan.ticket.idTicket);
        }
        i = 1;

        for (Pemesanan pemesanan : pemesanans) {
            totalHarga += pemesanan.ticket.harga;
        }
        System.out.println("Total harga : " + totalHarga);

        System.out.print("Masukkan uang anda : ");
        uangBayar = sc.nextInt();

        System.out.println("Uang kembalian : " + (totalHarga - uangBayar));


    }
}