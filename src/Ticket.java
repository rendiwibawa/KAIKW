class Ticket {
    String kelas;
    int jumlahKursi;
    int harga;

    Kereta kereta;
    Jadwal jadwal;
    Pelanggan pelanggan;
    Stasiun stasiun;

    Ticket(Kereta kereta, Jadwal jadwal, Pelanggan pelanggan, Stasiun stasiun) {
        this.kereta = kereta;
        this.jadwal = jadwal;
        this.pelanggan = pelanggan;
        this.stasiun = stasiun;
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
}