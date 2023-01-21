import java.util.ArrayList;

class Jadwal {
    String datang;
    String keberangkatan;
    Kereta kereta;

    static ArrayList<Jadwal> arrJadwal = new ArrayList<Jadwal>(); 
    public static void main(String[] args) {
        inisialData(arrJadwal);
        lihatJadwal(arrJadwal);
    }

    Jadwal(String datang, String keberangkatan) {
        this.datang = datang;
        this.keberangkatan = keberangkatan;
    }

    static void inisialData(ArrayList<Jadwal> arrJadwal) {
        arrJadwal.add(new Jadwal("senin  -13.00  ","senin  -13.00"));
        arrJadwal.add(new Jadwal("selasa -13.20  ","selasa -13.20"));
        arrJadwal.add(new Jadwal("minggu -11.00  ","minggu -11.00"));
    }

    static void lihatJadwal(ArrayList<Jadwal> arr){
        for (Jadwal jadwal : arr) {
            System.out.println("==================================================================");
            System.out.println( "Kedatangan |\t"+jadwal.datang + "|Keberangkatan |\t" + jadwal.keberangkatan);
        }
            System.out.println("==================================================================");
    }
    
}


