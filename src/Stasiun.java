import java.util.ArrayList;

class Stasiun {
    String nama;
    String lokasi;

    Stasiun (String nama, String lokasi) {
        this.nama = nama;
        this.lokasi = lokasi;
    }

    ArrayList<Stasiun>arrayList = new ArrayList<Stasiun>();
    
    void inisialData(){
        arrayList.add(new Stasiun("Bubulak","Bogor"));
        arrayList.add(new Stasiun("Arjosari","Bandung"));
        arrayList.add(new Stasiun("Grand Max City","Tuban"));
    }

    void printData() {
        System.out.println("============================================================");
        for (Stasiun stasiun : arrayList) {
            System.out.println("Nama : " + stasiun.nama + ", Alamat : " + stasiun.lokasi);
        }
    }

}
