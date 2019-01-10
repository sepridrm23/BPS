package muaraenimkab.bps.go.id.bps.models;

public class Menu {
    private String id, subid, nama, logo;

    public Menu(String id, String subid, String nama, String logo) {
        this.id = id;
        this.subid = subid;
        this.nama = nama;
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubid() {
        return subid;
    }

    public void setSubid(String subid) {
        this.subid = subid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
