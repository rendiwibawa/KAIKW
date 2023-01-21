class Kereta {
    String namaKereta;
    private int jumlahKursi = 40;

    Jadwal jadwal;

    Kereta(Jadwal jadwal) {
        this.jadwal = jadwal;
    }

    int showJumlahKursi() {
        return jumlahKursi;
    }

    void updateJumlahKursi(int jumlah) {
        jumlahKursi = jumlah;
    }    

}
