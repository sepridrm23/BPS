package muaraenimkab.bps.go.id.bps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView cvSosial, cvEkonomi, cvPertanian, cvIndikator, cvPublikasi, cvBeritaStatistik, cvBerita, cvKontak, cvTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cvSosial = findViewById(R.id.card_view_sosial);
        cvEkonomi = findViewById(R.id.card_view_ekonomi);
        cvPertanian = findViewById(R.id.card_view_pertanian);
        cvIndikator = findViewById(R.id.card_view_indikator);
        cvPublikasi = findViewById(R.id.card_view_publikasi);
        cvBeritaStatistik = findViewById(R.id.card_view_berita_statistik);
        cvBerita = findViewById(R.id.card_view_berita);
        cvKontak = findViewById(R.id.card_view_kontak);
        cvTentang = findViewById(R.id.card_view_tentang);

        cvSosial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityMainRoot.class);
                intent.putExtra("flag", "1");
                startActivity(intent);
            }
        });

        cvEkonomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityMainRoot.class);
                intent.putExtra("flag", "2");
                startActivity(intent);
            }
        });

        cvPertanian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityMainRoot.class);
                intent.putExtra("flag", "3");
                startActivity(intent);
            }
        });

        cvIndikator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityMainRoot.class);
                intent.putExtra("flag", "4");
                startActivity(intent);
            }
        });

        cvPublikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityPublikasi.class);
                intent.putExtra("flag", "5");
                startActivity(intent);
            }
        });

        cvBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityBerita.class);
                intent.putExtra("flag", "7");
                startActivity(intent);
            }
        });

        cvBeritaStatistik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityBeritaResmi.class);
                intent.putExtra("flag", "6");
                startActivity(intent);
            }
        });

        cvKontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityKontak.class);
                intent.putExtra("flag", "8");
                startActivity(intent);
            }
        });

        cvTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityTentang.class);
                intent.putExtra("flag", "9");
                startActivity(intent);
            }
        });
    }
}
