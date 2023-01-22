import java.sql.Time;

class Pembayaran {
    // Ticket ticket = new Ticket();
   private int totalHarga;
    String metodeBayar;
    String kelas;
    Time waktuBayar;
    int x = 0;

    // TODO: Finish the pembayaran method for calculate the price
    Pembayaran(String kelas){
        this.kelas = kelas;
        if(this.kelas == "Ekonomi"){
            x = 10000;
        }else if (this.kelas == "Eksekutif") {
            x = 15000;
        }else if(this.kelas == "Bisnis"){
            x = 25000;
        }
    }

    void setTotalHarga(int jml){
        totalHarga = jml * x;
    }

    int getTotalHarga(){
        return totalHarga;
    }
}