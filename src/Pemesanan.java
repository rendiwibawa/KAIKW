import java.util.UUID;

class Pemesanan {
    String idPemesanan;
    int idTicket;
    String status;
    int totalHarga;

    void removePemesanan() {

    }

    Pemesanan (Ticket ticket) {
        idTicket = ticket.idTicket;
        idPemesanan = UUID.randomUUID().toString();
    }

}
