package muaraenimkab.bps.go.id.bps.activities;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import muaraenimkab.bps.go.id.bps.adapters.MenuViewAdapter;
import muaraenimkab.bps.go.id.bps.models.Menu;
import muaraenimkab.bps.go.id.bps.models.Models;
import muaraenimkab.bps.go.id.bps.R;
import muaraenimkab.bps.go.id.bps.models.Value;
import muaraenimkab.bps.go.id.bps.services.APIServices;
import muaraenimkab.bps.go.id.bps.utils.Utilities;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
//    CardView cvSosial, cvEkonomi, cvPertanian, cvIndikator, cvPublikasi, cvBeritaStatistik, cvBerita, cvKontak, cvTentang;

    RecyclerView rView;
    ArrayList<Models> aList;
    Models[] data;

    float dpWidth;

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

//        data = new Models[]{
//                new Models("Keadaan Geogradis & Iklim"),
//                new Models("Pemerintahan"),
//                new Models("Penduduk & Tenaga Kerja"),
//                new Models("Sosial"),
//                new Models("Pertanian"),
//                new Models("Industri, Tambang, Energi"),
//                new Models("Perdagangan & Konstruksi"),
//                new Models("Transportasi, Komunikasi, Pariwisata"),
//                new Models("Keuangan & Harga"),
//                new Models("Pengeluaran & Konsumsi Penduduk"),
//                new Models("Pendapatan Regional"),
//                new Models("Kemiskinan"),
//                new Models("Perbandingan Regional"),
//                new Models("Indikator Strategis"),
//                new Models("Publikasi Statistik"),
//                new Models("Berita Resmi Statistik"),
//                new Models("Berita"),
//                new Models("Kontak"),
//                new Models("Tentang Kami")
//        };
//
//        aList = new ArrayList<>(Arrays.asList(data));

        getMenu();

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        dpWidth = displayMetrics.widthPixels / displayMetrics.density;
//
        imageView.setLayoutParams(new LinearLayout.LayoutParams(displayMetrics.widthPixels, displayMetrics.widthPixels/2));

//        int noOfColumns = (int) (dpWidth / 120);
//        rView.setHasFixedSize(true);
//        rView.setLayoutManager(new GridLayoutManager(this, noOfColumns));
//        MenuViewAdapter rcAdapter = new MenuViewAdapter(this, aList);
//        rView.setAdapter(rcAdapter);

//        rView.setNestedScrollingEnabled(false);
//        rView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));
//        rView.setItemAnimator(new DefaultItemAnimator());
//        MenuViewAdapter rcAdapter = new MenuViewAdapter(this, aList);
//        rView.setAdapter(rcAdapter);


    }

    private void getMenu() {

        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        final String random = Utilities.getRandom(5);

        OkHttpClient okHttpClient = Utilities.getUnsafeOkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utilities.getURL())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        APIServices api = retrofit.create(APIServices.class);
        Call<Value<Menu>> call = api.getmenu(random);
        call.enqueue(new Callback<Value<Menu>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(@NonNull Call<Value<Menu>> call, @NonNull Response<Value<Menu>> response) {
                if (response.body() != null) {
                    int success = Objects.requireNonNull(response.body()).getSuccess();
                    if (success == 1) {
                        ArrayList<Menu> data = (ArrayList<Menu>) Objects.requireNonNull(response.body()).getData();

                        int noOfColumns = (int) (dpWidth / 120);
                        rView.setHasFixedSize(true);
                        rView.setLayoutManager(new GridLayoutManager(MainActivity.this, noOfColumns));
                        MenuViewAdapter rcAdapter = new MenuViewAdapter(MainActivity.this, data);
                        rView.setAdapter(rcAdapter);
                        pDialog.dismiss();
                    }else {
                        Snackbar.make(MainActivity.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
                                Snackbar.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }
                }else {
                    Snackbar.make(MainActivity.this.findViewById(android.R.id.content), "gagal mengambil data. Silahkan coba lagi",
                            Snackbar.LENGTH_LONG).show();
                    pDialog.dismiss();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onFailure(@NonNull Call<Value<Menu>> call, @NonNull Throwable t) {
                System.out.println("Retrofit Error:" + t.getMessage());
                Snackbar.make(MainActivity.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
                        Snackbar.LENGTH_LONG).show();
                pDialog.dismiss();
            }
        });
    }

}
