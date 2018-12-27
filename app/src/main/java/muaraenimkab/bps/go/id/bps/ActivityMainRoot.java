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

        if (flag.equals("1")){
            ActivityMainRoot.this.setTitle("Sosial dan Kependudukan");
            data = new Models[]{
                    new Models("Gender"),
                    new Models("Geografi"),
                    new Models("Iklim"),
                    new Models("Indeks Pembangunan Manusia"),
                    new Models("Kemiskinan dan Ketimpangan"),
                    new Models("Kependudukan"),
                    new Models("Kesehatan"),
                    new Models("Konsumsi dan Pengeluaran"),
                    new Models("Lingkungan Hidup"),
                    new Models("Pemerintahan"),
                    new Models("Pendidikan"),
                    new Models("Perumahan"),
                    new Models("Politik dan Keamanan"),
                    new Models("Tenaga Kerja"),
            };
        }else if (flag.equals("2")){
            ActivityMainRoot.this.setTitle("Ekonomi dan Perdagangan");
            data = new Models[]{
                    new Models("Eksport-Import"),
                    new Models("Energi"),
                    new Models("Indeks Tendensi Konsumen"),
                    new Models("Inflasi"),
                    new Models("Keuangan"),
                    new Models("Komunikasi"),
                    new Models("Konstruksi"),
                    new Models("Nilai Tukar Petani"),
                    new Models("PDRB(Lapangan Usaha)"),
                    new Models("PDRB(Pengeluaran)"),
                    new Models("Pariwisata"),
                    new Models("Produk Domestik Regional Bruto"),
            };
        }else if (flag.equals("3")){
            ActivityMainRoot.this.setTitle("Pertanian dan Pertambangan");
            data = new Models[]{
                    new Models("Hortikultura"),
                    new Models("Kehutanan"),
                    new Models("Perikanan"),
                    new Models("Perkebunan"),
                    new Models("Pertambangan"),
                    new Models("Peternakan"),
                    new Models("Tanaman Pangan"),
            };
        } else if (flag.equals("4")){
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

        if (flag.equals("4")){
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
