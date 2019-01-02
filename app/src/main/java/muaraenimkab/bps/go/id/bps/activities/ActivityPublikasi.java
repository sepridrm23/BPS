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
import muaraenimkab.bps.go.id.bps.adapters.PublikasiViewAdapter;
import muaraenimkab.bps.go.id.bps.R;

public class ActivityPublikasi extends AppCompatActivity {
    RecyclerView rView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Models> aList;
    Models[] data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publikasi);
        rView = findViewById(R.id.recycler_view);

        ActivityPublikasi.this.setTitle("Publikasi Statistik");
        data = new Models[]{
                new Models("Indikator Penting Kabupaten Muara Enim\nISSN : 2477-4472"),
                new Models("Indeks Tendensi Konsumen Kabupaten Muara Enim\nISSN : 2476-4772"),
                new Models("Laporan Perekonomian Kabupaten Muara Enim\nISSN : 2475-4172"),
                new Models("Statistik Daerah Kabupaten Muara Enim\nISSN : 2478-4072"),
                new Models("Muara Enim dalam Angka\nISSN : 1878-4092"),
        };

        aList = new ArrayList<>(Arrays.asList(data));

        rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        linearLayoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(linearLayoutManager);
        PublikasiViewAdapter laporanViewAdapter = new PublikasiViewAdapter(this, aList);
        rView.setAdapter(laporanViewAdapter);

    }
}
