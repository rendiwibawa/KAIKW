import java.util.UUID;
import java.util.ArrayList;
import java.util.Scanner;
import Animation.Animation;

class Pemesanan {
    String idPemesanan;
    int idTicket;
    String status;
    int totalHarga;

    void removePemesanan() {

    }

    Pemesanan (Ticket ticket) {
        idTicket = ticket.idTicket;
        idPemesanan = UUID.randomUUID().toString();
    }

    static void formUi(Jadwal jadwal, Kereta kereta, Stasiun stasiun, Scanner sc, Animation animation, ArrayList<Pemesanan> pemesananArr) {

        System.out.println("PESAN TIKET");
        String nama, email;
        int noTelp;
        int stasiunInput;
        int jadwalInput; 
        int keretaInput;


        // GET data Pelanggan
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
        int pilihKelas;
        String kelas;
        do{
            System.out.println("Pilih Kelas kereta (1. Ekonomi |2. Eksekutif |3. Bisnis) : ");
            pilihKelas = sc.nextInt();
        }while(pilihKelas < 1 || pilihKelas > 3);
        

        Ticket ticket = new Ticket(
            kereta.getKereta(keretaInput),
            jadwal.getJadwal(jadwalInput),
            pelanggan,
            stasiun.getStasiun(stasiunInput)
        );

        switch (pilihKelas) {
            case 1:
                ticket.kelas = "Ekonomi";
                break;
            case 2:
                ticket.kelas = "Eksekutif";
                break;
            case 3:
                ticket.kelas = "Bisnis";
                break;
            default:
                break;
        }


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

        animation.promptEnterKey();
    }

}
