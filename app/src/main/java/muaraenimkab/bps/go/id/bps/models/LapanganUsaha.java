package muaraenimkab.bps.go.id.bps.models;

public class LapanganUsaha {
    String id, tahun, nama_usaha, asing_gender_l, asing_gender_p, lokal_gender_l, lokal_gender_p;

    public LapanganUsaha(String id, String tahun, String nama_usaha, String asing_gender_l,
                         String asing_gender_p, String lokal_gender_l, String lokal_gender_p) {
        this.id = id;
        this.tahun = tahun;
        this.nama_usaha = nama_usaha;
        this.asing_gender_l = asing_gender_l;
        this.asing_gender_p = asing_gender_p;
        this.lokal_gender_l = lokal_gender_l;
        this.lokal_gender_p = lokal_gender_p;
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

    public String getNama_usaha() {
        return nama_usaha;
    }

    public void setNama_usaha(String nama_usaha) {
        this.nama_usaha = nama_usaha;
    }

    public String getAsing_gender_l() {
        return asing_gender_l;
    }

    public void setAsing_gender_l(String asing_gender_l) {
        this.asing_gender_l = asing_gender_l;
    }

    public String getAsing_gender_p() {
        return asing_gender_p;
    }

    public void setAsing_gender_p(String asing_gender_p) {
        this.asing_gender_p = asing_gender_p;
    }

    public String getLokal_gender_l() {
        return lokal_gender_l;
    }

    public void setLokal_gender_l(String lokal_gender_l) {
        this.lokal_gender_l = lokal_gender_l;
    }

    public String getLokal_gender_p() {
        return lokal_gender_p;
    }

    public void setLokal_gender_p(String lokal_gender_p) {
        this.lokal_gender_p = lokal_gender_p;
    }
}
