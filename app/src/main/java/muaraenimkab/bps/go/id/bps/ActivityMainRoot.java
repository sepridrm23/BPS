package muaraenimkab.bps.go.id.bps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityMainRoot extends AppCompatActivity {
    RecyclerView rView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Models> aList;
    Models[] data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        rView = findViewById(R.id.recycler_view);

        String flag = getIntent().getStringExtra("flag");

        if (flag.equals("0")) {
            ActivityMainRoot.this.setTitle("Keadaan Geogradis & Iklim");
            data = new Models[]{
                    new Models("Letak Geografis & Kondisi Topografi"),
                    new Models("Ketinggian"),
                    new Models("Kemiringan Tanah"),
                    new Models("Jenis Tanah"),
                    new Models("Jarak ke Ibu Kota Kecamatan"),
                    new Models("Keadaan Iklim"),
            };
        }else if (flag.equals("1")){
            ActivityMainRoot.this.setTitle("Pemerintahan");
            data = new Models[]{
                    new Models("Wilayah Administrasi"),
                    new Models("Keanggotaan Dewan"),
                    new Models("Keadaan Pegawai Negeri Sipil"),
            };
//            data = new Models[]{
//                    new Models("Gender"),
//                    new Models("Geografi"),
//                    new Models("Iklim"),
//                    new Models("Indeks Pembangunan Manusia"),
//                    new Models("Kemiskinan dan Ketimpangan"),
//                    new Models("Kependudukan"),
//                    new Models("Kesehatan"),
//                    new Models("Konsumsi dan Pengeluaran"),
//                    new Models("Lingkungan Hidup"),
//                    new Models("Pemerintahan"),
//                    new Models("Pendidikan"),
//                    new Models("Perumahan"),
//                    new Models("Politik dan Keamanan"),
//                    new Models("Tenaga Kerja"),
//            };
        }else if (flag.equals("2")){
            ActivityMainRoot.this.setTitle("Penduduk & Tenaga Kerja");
            data = new Models[]{
                    new Models("Penduduk"),
                    new Models("Ketenagakerjaan"),
//                    new Models("Eksport-Import"),
//                    new Models("Energi"),
//                    new Models("Indeks Tendensi Konsumen"),
//                    new Models("Inflasi"),
//                    new Models("Keuangan"),
//                    new Models("Komunikasi"),
//                    new Models("Konstruksi"),
//                    new Models("Nilai Tukar Petani"),
//                    new Models("PDRB(Lapangan Usaha)"),
//                    new Models("PDRB(Pengeluaran)"),
//                    new Models("Pariwisata"),
//                    new Models("Produk Domestik Regional Bruto"),
            };
        }else if (flag.equals("3")){
            ActivityMainRoot.this.setTitle("Sosial");
            data = new Models[]{
                    new Models("Pendidikan"),
                    new Models("Kesehatan"),
                    new Models("Keluarga Berencana"),
                    new Models("Agama"),
//                    new Models("Hortikultura"),
//                    new Models("Kehutanan"),
//                    new Models("Perikanan"),
//                    new Models("Perkebunan"),
//                    new Models("Pertambangan"),
//                    new Models("Peternakan"),
//                    new Models("Tanaman Pangan"),
            };
        } else if (flag.equals("4")){
            ActivityMainRoot.this.setTitle("Pertanian");
            data = new Models[]{
                    new Models("Tanaman Pangan"),
                    new Models("Perkebunan"),
                    new Models("Peternakan"),
                    new Models("Perikanan"),
//                    new Models("Angka Harapan Hidup 2017 : 65,14 Tahun"),
//                    new Models("Angka Partisipasi Murni SD 2017 : 78,83 Persen"),
//                    new Models("Angka Partisipasi Murni SMP 2017 : 56,13 Persen"),
//                    new Models("Angka Partisipasi Murni SMA 2017 : 43,48 Persen"),
//                    new Models("Garis Kemiskinan September 2017 : 464.056 Rupiah/Kapita/Bulan"),
            };
        }else if (flag.equals("5")){
            ActivityMainRoot.this.setTitle("Industri, Tambang, Energi");
            data = new Models[]{
                    new Models("Perindustrian"),
                    new Models("Pertambangan"),
                    new Models("Listrik"),
                    new Models("Air"),
            };
        }else if (flag.equals("6")){
            ActivityMainRoot.this.setTitle("Perdagangan & Konstruksi");
            data = new Models[]{
                    new Models("Perdagangan"),
                    new Models("Konstruksi"),
            };
        }else if (flag.equals("7")){
            ActivityMainRoot.this.setTitle("Transportasi, Komunikasi, Pariwisata");
            data = new Models[]{
                    new Models("Prasarana Jalan"),
                    new Models("Angkutan Darat"),
                    new Models("Pos"),
                    new Models("Komunikasi"),
                    new Models("Pariwisata"),
            };
        }else if (flag.equals("8")){
            ActivityMainRoot.this.setTitle("Keuangan & Harga");
            data = new Models[]{
                    new Models("Keuangan"),
                    new Models("Harga"),
            };
        }else if (flag.equals("9")){
            ActivityMainRoot.this.setTitle("Pengeluaran & Konsumsi Penduduk");
            data = new Models[]{
                    new Models("Pengeluaran dan Konsumsi"),
            };
        }else if (flag.equals("10")){
            ActivityMainRoot.this.setTitle("Pendapatan Regional");
            data = new Models[]{
                    new Models("Produk Domestik Regional Bruto (PDRB)"),
                    new Models("Struktur Ekonomi"),
                    new Models("Pertumbuhan Ekonomi"),
                    new Models("Laju Inflasi PDRB"),
                    new Models("Pendapatan per Kapita"),
            };
        }else if (flag.equals("11")){
            ActivityMainRoot.this.setTitle("Kemiskinan");
            data = new Models[]{
                    new Models("Kemiskinan"),
            };
        }else if (flag.equals("12")){
            ActivityMainRoot.this.setTitle("Perbandingan Regional");
            data = new Models[]{
                    new Models("Kependudukan"),
                    new Models("Kemiskinan")
            };
        }else if (flag.equals("13")){
            ActivityMainRoot.this.setTitle("Indikator Strategis");
            data = new Models[]{
                    new Models("Angka Harapan Hidup 2017 : 65,14 Tahun"),
                    new Models("Angka Partisipasi Murni SD 2017 : 78,83 Persen"),
                    new Models("Angka Partisipasi Murni SMP 2017 : 56,13 Persen"),
                    new Models("Angka Partisipasi Murni SMA 2017 : 43,48 Persen"),
                    new Models("Garis Kemiskinan September 2017 : 464.056 Rupiah/Kapita/Bulan"),
            };
        }

        aList = new ArrayList<>(Arrays.asList(data));

        if (flag.equals("13")){
            rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            linearLayoutManager = new LinearLayoutManager(this);
            rView.setLayoutManager(linearLayoutManager);
            IndikatorViewAdapter laporanViewAdapter = new IndikatorViewAdapter(this, aList);
            rView.setAdapter(laporanViewAdapter);
        }else {
            rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            linearLayoutManager = new LinearLayoutManager(this);
            rView.setLayoutManager(linearLayoutManager);
            RecyclerViewAdapter laporanViewAdapter = new RecyclerViewAdapter(this, aList, flag);
            rView.setAdapter(laporanViewAdapter);
        }
    }
}
