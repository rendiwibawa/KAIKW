import java.util.ArrayList;

class Jadwal {
    String datang;
    String keberangkatan;

    private ArrayList<Jadwal> arrJadwal = new ArrayList<Jadwal>(); 
    int i = 1;

    Jadwal(String datang, String keberangkatan) {
        this.datang = datang;
        this.keberangkatan = keberangkatan;
    }

    void inisialData() {
        arrJadwal.add(new Jadwal("senin  -13.00  ","senin  -13.00"));
        arrJadwal.add(new Jadwal("selasa -13.20  ","selasa -13.20"));
        arrJadwal.add(new Jadwal("minggu -11.00  ","minggu -11.00"));
    }

    void lihatJadwal(){
        for (Jadwal jadwal : arrJadwal) {
            System.out.println("=====================================================================");
            System.out.println( "(" + i + "). " + "Kedatangan |\t"+jadwal.datang + "|Keberangkatan |\t" + jadwal.keberangkatan);
            i++;
        }
            System.out.println("=====================================================================");
    }
    
    Jadwal getJadwal(int ind) {
        return arrJadwal.get(ind); 
    }
}


