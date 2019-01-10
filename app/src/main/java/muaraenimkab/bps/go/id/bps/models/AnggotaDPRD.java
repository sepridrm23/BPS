package muaraenimkab.bps.go.id.bps.models;

public class AnggotaDPRD {
    String id,nama_periode, nama_partai, jumlah_kursi;

    public AnggotaDPRD(String id,String nama_periode, String nama_partai, String jumlah_kursi) {
        this.id=id;
        this.nama_periode = nama_periode;
        this.nama_partai = nama_partai;
        this.jumlah_kursi = jumlah_kursi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_periode() {
        return nama_periode;
    }

    public void setNama_periode(String nama_periode) {
        this.nama_periode = nama_periode;
    }

    public String getNama_partai() {
        return nama_partai;
    }

    public void setNama_partai(String nama_partai) {
        this.nama_partai = nama_partai;
    }

    public String getJumlah_kursi() {
        return jumlah_kursi;
    }

    public void setJumlah_kursi(String jumlah_kursi) {
        this.jumlah_kursi = jumlah_kursi;
    }
}
