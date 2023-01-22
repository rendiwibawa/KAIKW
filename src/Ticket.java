import java.util.UUID;

class Ticket {
    String kelas;
    String idTicket;
    int jumlahKursi;
    int harga;

    Kereta kereta;
    Jadwal jadwal;
    Pelanggan pelanggan;
    Stasiun stasiun;
    Pemesanan pemesanan;

    Ticket(Kereta kereta, Jadwal jadwal, Pelanggan pelanggan, Stasiun stasiun) {
        this.kereta = kereta;
        this.jadwal = jadwal;
        this.pelanggan = pelanggan;
        this.stasiun = stasiun;

        idTicket = UUID.randomUUID().toString();
        idTicket = idTicket.substring(0,8);
    }

    int getJumlahKursi() {
        return jumlahKursi;
    }

    

    void setJumlahKursi(int jml) {
        jumlahKursi -= jml;
    }

    // method
    void showDetails() {
        System.out.println("====================");
        System.out.println("Kereta" + kereta.namaKereta);
        System.out.println("Atas nama : " + pelanggan.nama);
        System.out.println("Jenis layanan : " + kelas);
        System.out.println("Jumlah Kursi : " + jumlahKursi);
        System.out.println("Total Harga : " + (jumlahKursi * harga));
    }


    void cetakTiket() {
        System.out.println("====================================================");
        System.out.println("||           --TIKET KERETA KAI KW--              ||");
        System.out.println("====================================================");
        System.out.println("|| Nama / Name\t\tKereta / Train            ||");
        System.out.println("|| *" + pelanggan.nama + "\t\t*" + kereta.namaKereta + "\t\t  ||");
        System.out.println("|| kelas / Class\tJumlah kursi / Total seat ||");
        System.out.println("|| *" + kelas + " \t\t*"  + pemesanan.jumlahKursi+"\t\t\t  ||");
        System.out.println("|| Kedatangan / Arrival\tKeberangkatan / Departure ||");
        System.out.println("|| *" + jadwal.datang + "\t*" + jadwal.keberangkatan + "\t\t ||");
        System.out.println("|| Harga / Price\tID Ticket\t\t  ||");
        System.out.println("|| *Rp."+ harga + "\t\t*" + idTicket + "\t\t   ||");
        System.out.println("====================================================");
    }
}