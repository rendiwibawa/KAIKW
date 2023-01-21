import java.util.ArrayList;

class Kereta {
    String namaKereta;
    String tujuan;
    private int jumlahKursi = 40;

    ArrayList<Kereta> keretaArr = new ArrayList<Kereta>();

    Kereta(String namaKereta) {
        this.namaKereta = namaKereta;
    }

    void inisialData() {
        keretaArr.add(new Kereta("Yudistira"));
        keretaArr.add(new Kereta("Arjuna"));
        keretaArr.add(new Kereta("Nakula"));
        keretaArr.add(new Kereta("Sadewa"));
        keretaArr.add(new Kereta("Bima"));
    }

    void printKereta() {
        for (Kereta kereta : keretaArr) {
            System.out.println("Nama : Kereta " + kereta.namaKereta);
            System.out.println("Jumlah Kursi : " + kereta.jumlahKursi);
        }
    }

    Kereta getKereta(int ind) {
        return keretaArr.get(ind);
    }

    /*
     * Mobil
     * Mobil mb = new Mobil();
     * mb.nama = "hello"
     * mb.nama = "hola"
     * 
     * Mobil mb2 = new Mobil();
     * 
     *  ==================
     *  new Mobil("Avanza")
     *  new Mobil("Xenia")
     *  ==================
     * 
     *  ArrayList mbArr
     *  Mobil ml = mbArr.get(0) => new Mobil("Avanza")
     * 
     * 
     * 
     */

    int showJumlahKursi() {
        return jumlahKursi;
    }

    void updateJumlahKursi(int jumlah) {
        jumlahKursi -= jumlah;
    }    

}
