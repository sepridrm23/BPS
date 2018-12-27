package muaraenimkab.bps.go.id.bps;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityBeritaResmi extends AppCompatActivity {
    RecyclerView rView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Models> aList;
    Models[] data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        rView = findViewById(R.id.recycler_view);

        ActivityBeritaResmi.this.setTitle("Berita Resmi Statistik");
        data = new Models[]{
                new Models("Perkembangan Ekspor dan Impor Kabupaten Muara Enim"),
                new Models("Hasil Pendapatan Potensi Desa 2018 Kabupaten Muara Enim"),
                new Models("Keadaan Ketenagakerjaan Kabupaten Muara Enim"),
                new Models("Indeks Tendensi Konsumen Triwulan III-2018"),
                new Models("Luas Panen dan Produksi Padi Kabupaten Muara Enim 2018"),
        };

        aList = new ArrayList<>(Arrays.asList(data));

        rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        linearLayoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(linearLayoutManager);
        BeritaResmiViewAdapter laporanViewAdapter = new BeritaResmiViewAdapter(this, aList);
        rView.setAdapter(laporanViewAdapter);
    }
}
