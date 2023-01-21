class Ticket {
    Jadwal jadwal;
    Kereta kereta = new Kereta(jadwal);
    String kelas;
    String tujuan;
    int jumlahKursi;
    int harga;

    Ticket(Jadwal jadwal) {
        this.jadwal = jadwal;
    }

    Pelanggan pelanggan = new Pelanggan();
    Stasiun stasiun = new Stasiun();

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