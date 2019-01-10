package muaraenimkab.bps.go.id.bps.models;

public class DataPenduduk {
    String id, tahun, kecamatan, jum_laki_anak,jum_laki_dewasa, jum_laki_lansia, jum_per_anak,
            jum_per_dewasa, jum_per_lansia, jum_kepadatan, jum_tumbuh;

    public DataPenduduk(String id, String tahun, String kecamatan, String jum_laki_anak, String jum_laki_dewasa, String jum_laki_lansia,
                        String jum_per_anak, String jum_per_dewasa, String jum_per_lansia, String jum_kepadatan, String jum_tumbuh) {
        this.id = id;
        this.tahun = tahun;
        this.kecamatan = kecamatan;
        this.jum_laki_anak = jum_laki_anak;
        this.jum_laki_dewasa = jum_laki_dewasa;
        this.jum_laki_lansia = jum_laki_lansia;
        this.jum_per_anak = jum_per_anak;
        this.jum_per_dewasa = jum_per_dewasa;
        this.jum_per_lansia = jum_per_lansia;
        this.jum_kepadatan = jum_kepadatan;
        this.jum_tumbuh = jum_tumbuh;
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

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getJum_laki_anak() {
        return jum_laki_anak;
    }

    public void setJum_laki_anak(String jum_laki_anak) {
        this.jum_laki_anak = jum_laki_anak;
    }

    public String getJum_laki_dewasa() {
        return jum_laki_dewasa;
    }

    public void setJum_laki_dewasa(String jum_laki_dewasa) {
        this.jum_laki_dewasa = jum_laki_dewasa;
    }

    public String getJum_laki_lansia() {
        return jum_laki_lansia;
    }

    public void setJum_laki_lansia(String jum_laki_lansia) {
        this.jum_laki_lansia = jum_laki_lansia;
    }

    public String getJum_per_anak() {
        return jum_per_anak;
    }

    public void setJum_per_anak(String jum_per_anak) {
        this.jum_per_anak = jum_per_anak;
    }

    public String getJum_per_dewasa() {
        return jum_per_dewasa;
    }

    public void setJum_per_dewasa(String jum_per_dewasa) {
        this.jum_per_dewasa = jum_per_dewasa;
    }

    public String getJum_per_lansia() {
        return jum_per_lansia;
    }

    public void setJum_per_lansia(String jum_per_lansia) {
        this.jum_per_lansia = jum_per_lansia;
    }

    public String getJum_kepadatan() {
        return jum_kepadatan;
    }

    public void setJum_kepadatan(String jum_kepadatan) {
        this.jum_kepadatan = jum_kepadatan;
    }

    public String getJum_tumbuh() {
        return jum_tumbuh;
    }

    public void setJum_tumbuh(String jum_tumbuh) {
        this.jum_tumbuh = jum_tumbuh;
    }
}
