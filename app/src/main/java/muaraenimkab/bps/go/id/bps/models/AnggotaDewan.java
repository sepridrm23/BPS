package muaraenimkab.bps.go.id.bps.models;

public class AnggotaDewan {
    String id,nama_lengkap,nama_partai, tempat_lahir, tgl_lahir, nama_gender, nama_agama, nama_pendidikan,status_nikah;

    public AnggotaDewan(String id,String nama_lengkap, String nama_partai, String tempat_lahir, String tgl_lahir, String nama_gender,
                        String nama_agama, String nama_pendidikan, String status_nikah) {
        this.id=id;
        this.nama_lengkap = nama_lengkap;
        this.nama_partai = nama_partai;
        this.tempat_lahir = tempat_lahir;
        this.tgl_lahir = tgl_lahir;
        this.nama_gender = nama_gender;
        this.nama_agama = nama_agama;
        this.nama_pendidikan = nama_pendidikan;
        this.status_nikah = status_nikah;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getNama_partai() {
        return nama_partai;
    }

    public void setNama_partai(String nama_partai) {
        this.nama_partai = nama_partai;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getNama_gender() {
        return nama_gender;
    }

    public void setNama_gender(String nama_gender) {
        this.nama_gender = nama_gender;
    }

    public String getNama_agama() {
        return nama_agama;
    }

    public void setNama_agama(String nama_agama) {
        this.nama_agama = nama_agama;
    }

    public String getNama_pendidikan() {
        return nama_pendidikan;
    }

    public void setNama_pendidikan(String nama_pendidikan) {
        this.nama_pendidikan = nama_pendidikan;
    }

    public String getStatus_nikah() {
        return status_nikah;
    }

    public void setStatus_nikah(String status_nikah) {
        this.status_nikah = status_nikah;
    }
}
