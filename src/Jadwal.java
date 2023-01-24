import java.util.ArrayList;

class Jadwal {
    String datang;
    String keberangkatan;
    String kelas;

    private ArrayList<Jadwal> arrJadwal = new ArrayList<Jadwal>();
    int i = 1;

    Jadwal(String datang, String keberangkatan) {
        this.datang = datang;
        this.keberangkatan = keberangkatan;
    }

    void inisialData() {
        arrJadwal.add(new Jadwal("Senin : 14:00", "Selasa : 14:00"));
        arrJadwal.add(new Jadwal("Rabu : 15:00", "Kamis : 15:00"));
        arrJadwal.add(new Jadwal("Jumat : 15:00", "Sabtu : 15:00"));

        arrJadwal.add(new Jadwal("Senin : 14:00", "Selasa : 10:00"));
        arrJadwal.add(new Jadwal("Rabu : 15:00", "Kamis : 11:00"));
        arrJadwal.add(new Jadwal("Jumat : 16:00", "Sabtu : 12:00"));

        arrJadwal.add(new Jadwal("Senin : 14:00", "Senin : 19:00"));
        arrJadwal.add(new Jadwal("Rabu : 15:00", "Rabu : 20:00"));
        arrJadwal.add(new Jadwal("Jumat : 16:00", "Jumat : 21:00"));
    }

    void lihatJadwal(String kelas){
        if( kelas == "Ekonomi"){
            System.out.println("=======================================================");
            System.out.println("\t\tJADWAL KERETA EKONOMI");
            for (int i = 0; i < 3; i++) {
                System.out.println("=======================================================");
                System.out.println("Keberangkatan " + arrJadwal.get(i).keberangkatan + " | " + "Kedatangan " + arrJadwal.get(i).datang);
                System.out.println("=======================================================");
            }
        }else if( kelas == "Eksekutif"){
            System.out.println("=======================================================");
            System.out.println("\t\tJADWAL KERETA EKSEKUTIF");
            for (int i = 3; i < 6; i++) {
                System.out.println("=======================================================");
                System.out.println("Keberangkatan " + arrJadwal.get(i).keberangkatan + " | " + "Kedatangan " + arrJadwal.get(i).datang);
                System.out.println("=======================================================");
            }

        }else if(kelas == "Bisnis"){
            System.out.println("=======================================================");
            System.out.println("\t\tJADWAL KERETA BISNIS");
            for (int i = 6; i < 9; i++) {
                System.out.println("=======================================================");
                System.out.println("Keberangkatan " + arrJadwal.get(i).keberangkatan + " | " + "Kedatangan " + arrJadwal.get(i).datang);
                System.out.println("=======================================================");
            }
        }
    }

    Jadwal getJadwal(int ind) {
        return arrJadwal.get(ind);
    }
}


