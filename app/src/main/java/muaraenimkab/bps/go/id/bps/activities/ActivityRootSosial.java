package muaraenimkab.bps.go.id.bps.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import muaraenimkab.bps.go.id.bps.models.Models;
import muaraenimkab.bps.go.id.bps.R;
import muaraenimkab.bps.go.id.bps.adapters.SosialViewAdapter;

public class ActivityRootSosial extends AppCompatActivity {
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
        ActivityRootSosial.this.setTitle(flag);

        if (flag.equals("Gender")){
            data = new Models[]{
                    new Models("Angka Harapan Hidup Laki-laki"),
                    new Models("Angka Harapan Hidup Perempuan"),
                    new Models("Harapan Lama Sekolah Laki-laki"),
                    new Models("Harapan Lama Sekolah Perempuan"),
                    new Models("Indeks Pembangunan Gender"),
                    new Models("Pengeluaran per Kapita Laki-laki"),
                    new Models("Pengeluaran per Kapita Perempuan"),
            };
        }else if (flag.equals("Geografi")){
            data = new Models[]{
                    new Models("Jarak ke Ibukota Provinsi"),
                    new Models("Luas Wilayah"),
                    new Models("Persentase Luas Wilayah"),
            };
        }else if (flag.equals("Iklim")){
            data = new Models[]{
                    new Models("Curah Hujan"),
                    new Models("Kecepatan Angin"),
                    new Models("Kelembaban Udara Maksimum"),
                    new Models("Kelembaban Udara Minimum"),
                    new Models("Suhu Maksimum"),
                    new Models("Suhu Minimun"),
                    new Models("Suhu Rata-rata"),
            };
        }else if (flag.equals("Indeks Pembangunan Manusia")){
            data = new Models[]{
                    new Models("Angka Harapan Hidup"),
                    new Models("Harapan Lama Sekolah"),
                    new Models("Indeks Pembangunan Manusia"),
                    new Models("Pengeluaran per Kapita"),
                    new Models("Rata-rata Lama Sekolah"),
            };
        }else if (flag.equals("Kemiskinan dan Ketimpangan")){
            data = new Models[]{
                    new Models("Garis Kemiskinan Makanan"),
                    new Models("Garis Kemiskinan non Makanan"),
                    new Models("Jumlah Penduduk Miskin"),
                    new Models("Ketimpangan Pendapatan"),
                    new Models("Persentase Penduduk Miskin"),
                    new Models("Rasio Gini"),
            };
        }else if (flag.equals("Kependudukan")){
            data = new Models[]{
                    new Models("Jumlah Penduduk"),
                    new Models("Jumlah Rumah Tangga"),
                    new Models("Kepadatan Penduduk"),
                    new Models("Rasio Jenis Kelamin"),
                    new Models("Rasio Ketergantungan"),
            };
        }else if (flag.equals("Kesehatan")){
            data = new Models[]{
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
            };
        }else if (flag.equals("Konsumsi dan Pengeluaran")){
            data = new Models[]{
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
            };
        }else if (flag.equals("Lingkungan Hidup")){
            data = new Models[]{
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
            };
        }else if (flag.equals("Pemerintahan")){
            data = new Models[]{
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
            };
        }else if (flag.equals("Pendidikan")){
            data = new Models[]{
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
            };
        }else if (flag.equals("Perumahan")){
            data = new Models[]{
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
            };
        }else if (flag.equals("Politik dan Keamanan")){
            data = new Models[]{
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
            };
        }else if (flag.equals("Tenaga Kerja")){
            data = new Models[]{
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
                    new Models(""),
            };
        }

        aList = new ArrayList<>(Arrays.asList(data));

        rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        linearLayoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(linearLayoutManager);
        SosialViewAdapter laporanViewAdapter = new SosialViewAdapter(this, aList, flag);
        rView.setAdapter(laporanViewAdapter);

    }
}
