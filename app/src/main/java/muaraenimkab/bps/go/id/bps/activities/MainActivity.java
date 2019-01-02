package muaraenimkab.bps.go.id.bps.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;

import muaraenimkab.bps.go.id.bps.adapters.MenuViewAdapter;
import muaraenimkab.bps.go.id.bps.models.Models;
import muaraenimkab.bps.go.id.bps.R;

public class MainActivity extends AppCompatActivity {
//    CardView cvSosial, cvEkonomi, cvPertanian, cvIndikator, cvPublikasi, cvBeritaStatistik, cvBerita, cvKontak, cvTentang;

    RecyclerView rView;
    ArrayList<Models> aList;
    Models[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rView = findViewById(R.id.recycler_view);

        ImageView imageView = findViewById(R.id.image_view);

//        cvSosial = findViewById(R.id.card_view_sosial);
//        cvEkonomi = findViewById(R.id.card_view_ekonomi);
//        cvPertanian = findViewById(R.id.card_view_pertanian);
//        cvIndikator = findViewById(R.id.card_view_indikator);
//        cvPublikasi = findViewById(R.id.card_view_publikasi);
//        cvBeritaStatistik = findViewById(R.id.card_view_berita_statistik);
//        cvBerita = findViewById(R.id.card_view_berita);
//        cvKontak = findViewById(R.id.card_view_kontak);
//        cvTentang = findViewById(R.id.card_view_tentang);
//
//        cvSosial.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ActivityMainRoot.class);
//                intent.putExtra("flag", "1");
//                startActivity(intent);
//            }
//        });
//
//        cvEkonomi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ActivityMainRoot.class);
//                intent.putExtra("flag", "2");
//                startActivity(intent);
//            }
//        });
//
//        cvPertanian.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ActivityMainRoot.class);
//                intent.putExtra("flag", "3");
//                startActivity(intent);
//            }
//        });
//
//        cvIndikator.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ActivityMainRoot.class);
//                intent.putExtra("flag", "4");
//                startActivity(intent);
//            }
//        });
//
//        cvPublikasi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ActivityPublikasi.class);
//                intent.putExtra("flag", "5");
//                startActivity(intent);
//            }
//        });
//
//        cvBerita.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ActivityBerita.class);
//                intent.putExtra("flag", "7");
//                startActivity(intent);
//            }
//        });
//
//        cvBeritaStatistik.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ActivityBeritaResmi.class);
//                intent.putExtra("flag", "6");
//                startActivity(intent);
//            }
//        });
//
//        cvKontak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ActivityKontak.class);
//                intent.putExtra("flag", "8");
//                startActivity(intent);
//            }
//        });
//
//        cvTentang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ActivityTentang.class);
//                intent.putExtra("flag", "9");
//                startActivity(intent);
//            }
//        });

        data = new Models[]{
                new Models("Keadaan Geogradis & Iklim"),
                new Models("Pemerintahan"),
                new Models("Penduduk & Tenaga Kerja"),
                new Models("Sosial"),
                new Models("Pertanian"),
                new Models("Industri, Tambang, Energi"),
                new Models("Perdagangan & Konstruksi"),
                new Models("Transportasi, Komunikasi, Pariwisata"),
                new Models("Keuangan & Harga"),
                new Models("Pengeluaran & Konsumsi Penduduk"),
                new Models("Pendapatan Regional"),
                new Models("Kemiskinan"),
                new Models("Perbandingan Regional"),
                new Models("Indikator Strategis"),
                new Models("Publikasi Statistik"),
                new Models("Berita Resmi Statistik"),
                new Models("Berita"),
                new Models("Kontak"),
                new Models("Tentang Kami")
        };

        aList = new ArrayList<>(Arrays.asList(data));

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 120);

        imageView.setLayoutParams(new LinearLayout.LayoutParams(displayMetrics.widthPixels/1, displayMetrics.widthPixels/2));

        rView.setHasFixedSize(true);
        rView.setLayoutManager(new GridLayoutManager(this, noOfColumns));
        MenuViewAdapter rcAdapter = new MenuViewAdapter(this, aList);
        rView.setAdapter(rcAdapter);

//        rView.setNestedScrollingEnabled(false);
//        rView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));
//        rView.setItemAnimator(new DefaultItemAnimator());
//        MenuViewAdapter rcAdapter = new MenuViewAdapter(this, aList);
//        rView.setAdapter(rcAdapter);

    }
}
