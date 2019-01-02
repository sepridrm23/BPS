package muaraenimkab.bps.go.id.bps.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import muaraenimkab.bps.go.id.bps.models.Berita;
import muaraenimkab.bps.go.id.bps.adapters.BeritaViewAdapter;
import muaraenimkab.bps.go.id.bps.R;

public class ActivityBerita extends AppCompatActivity {
    RecyclerView rView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Berita> aList;
    Berita[] data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        rView = findViewById(R.id.recycler_view);

        ActivityBerita.this.setTitle("Berita");
        data = new Berita[]{
                new Berita("Pelatihan Dasar CPNS Golongan III", "09 September 2018\n\nPelatihan Dasar CPNS Golongan III diselenggarakan berdasarkan peraturan kepala LAN no.22 Tahun 2016. Kegiatan ini menggantikan kegiatan Diklat Prajabatan yang wajib diikuti..."),
                new Berita("Pelatihan Dasar CPNS Golongan III", "07 September 2018\n\nPelatihan Dasar CPNS Golongan III diselenggarakan berdasarkan peraturan kepala LAN no.22 Tahun 2016. Kegiatan ini menggantikan kegiatan Diklat Prajabatan yang wajib diikuti..."),
                new Berita("Pelatihan Dasar CPNS Golongan III", "05 September 2018\n\nPelatihan Dasar CPNS Golongan III diselenggarakan berdasarkan peraturan kepala LAN no.22 Tahun 2016. Kegiatan ini menggantikan kegiatan Diklat Prajabatan yang wajib diikuti..."),
        };

        aList = new ArrayList<>(Arrays.asList(data));

        rView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        linearLayoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(linearLayoutManager);
        BeritaViewAdapter laporanViewAdapter = new BeritaViewAdapter(this, aList);
        rView.setAdapter(laporanViewAdapter);
    }
}
