package muaraenimkab.bps.go.id.bps.models;

public class DataPemerintahan {
    String id, tahun, jumlah_keputusan, jumlah_polisi, jumlah_polres, jumlah_penduduk, jumlah_akta_lahir, jumlah_akta_kawin,
    jumlah_kematian, jumlah_cerai, jumlah_anak, jumlah_sertifikat;

    public DataPemerintahan(String id, String tahun, String jumlah_keputusan, String jumlah_polisi, String jumlah_polres, String jumlah_penduduk,
                            String jumlah_akta_lahir, String jumlah_akta_kawin, String jumlah_kematian, String jumlah_cerai, String jumlah_anak,
                            String jumlah_sertifikat) {
        this.id = id;
        this.tahun = tahun;
        this.jumlah_keputusan = jumlah_keputusan;
        this.jumlah_polisi = jumlah_polisi;
        this.jumlah_polres = jumlah_polres;
        this.jumlah_penduduk = jumlah_penduduk;
        this.jumlah_akta_lahir = jumlah_akta_lahir;
        this.jumlah_akta_kawin = jumlah_akta_kawin;
        this.jumlah_kematian = jumlah_kematian;
        this.jumlah_cerai = jumlah_cerai;
        this.jumlah_anak = jumlah_anak;
        this.jumlah_sertifikat = jumlah_sertifikat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getJumlah_keputusan() {
        return jumlah_keputusan;
    }

    public void setJumlah_keputusan(String jumlah_keputusan) {
        this.jumlah_keputusan = jumlah_keputusan;
    }

    public String getJumlah_polisi() {
        return jumlah_polisi;
    }

    public void setJumlah_polisi(String jumlah_polisi) {
        this.jumlah_polisi = jumlah_polisi;
    }

    public String getJumlah_polres() {
        return jumlah_polres;
    }

    public void setJumlah_polres(String jumlah_polres) {
        this.jumlah_polres = jumlah_polres;
    }

    public String getJumlah_penduduk() {
        return jumlah_penduduk;
    }

    public void setJumlah_penduduk(String jumlah_penduduk) {
        this.jumlah_penduduk = jumlah_penduduk;
    }

    public String getJumlah_akta_lahir() {
        return jumlah_akta_lahir;
    }

    public void setJumlah_akta_lahir(String jumlah_akta_lahir) {
        this.jumlah_akta_lahir = jumlah_akta_lahir;
    }

    public String getJumlah_akta_kawin() {
        return jumlah_akta_kawin;
    }

    public void setJumlah_akta_kawin(String jumlah_akta_kawin) {
        this.jumlah_akta_kawin = jumlah_akta_kawin;
    }

    public String getJumlah_kematian() {
        return jumlah_kematian;
    }

    public void setJumlah_kematian(String jumlah_kematian) {
        this.jumlah_kematian = jumlah_kematian;
    }

    public String getJumlah_cerai() {
        return jumlah_cerai;
    }

    public void setJumlah_cerai(String jumlah_cerai) {
        this.jumlah_cerai = jumlah_cerai;
    }

    public String getJumlah_anak() {
        return jumlah_anak;
    }

    public void setJumlah_anak(String jumlah_anak) {
        this.jumlah_anak = jumlah_anak;
    }

    public String getJumlah_sertifikat() {
        return jumlah_sertifikat;
    }

    public void setJumlah_sertifikat(String jumlah_sertifikat) {
        this.jumlah_sertifikat = jumlah_sertifikat;
    }
}
