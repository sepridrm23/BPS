package muaraenimkab.bps.go.id.bps.activities;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Objects;

import muaraenimkab.bps.go.id.bps.R;
import muaraenimkab.bps.go.id.bps.adapters.SubMenuViewAdapter;
import muaraenimkab.bps.go.id.bps.models.Menu;
import muaraenimkab.bps.go.id.bps.models.Value;
import muaraenimkab.bps.go.id.bps.services.APIServices;
import muaraenimkab.bps.go.id.bps.utils.Utilities;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {
    RelativeLayout rlNodata, rlNoInternet;

    RecyclerView rView;
    LinearLayoutManager linearLayoutManager;
    String search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu);

        rlNodata = findViewById(R.id.rLayoutData);
        rlNoInternet = findViewById(R.id.rLayoutInternet);

        rView = findViewById(R.id.recycler_view);
        search = getIntent().getStringExtra("search");
        SearchActivity.this.setTitle("Hasil pencarian '"+search+"'");
        getSearchMenu();
    }

    private void getSearchMenu() {
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
        Call<Value<Menu>> call = api.getsearchsubmenu(random, search);
        call.enqueue(new Callback<Value<Menu>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(@NonNull Call<Value<Menu>> call, @NonNull Response<Value<Menu>> response) {
                if (response.body() != null) {
                    int success = Objects.requireNonNull(response.body()).getSuccess();
                    if (success == 1) {
                        ArrayList<Menu> data = (ArrayList<Menu>) Objects.requireNonNull(response.body()).getData();

                        if (data.size() == 0){
                            rlNodata.setVisibility(View.VISIBLE);
                            rlNoInternet.setVisibility(View.GONE);
                        }else {
                            rView.addItemDecoration(new DividerItemDecoration(SearchActivity.this, LinearLayoutManager.VERTICAL));
                            linearLayoutManager = new LinearLayoutManager(SearchActivity.this);
                            rView.setLayoutManager(linearLayoutManager);
                            SubMenuViewAdapter laporanViewAdapter = new SubMenuViewAdapter(SearchActivity.this, data);
                            rView.setAdapter(laporanViewAdapter);
                        }
                        pDialog.dismiss();
                    }else {
                        rlNodata.setVisibility(View.VISIBLE);
                        rlNoInternet.setVisibility(View.GONE);
                        Snackbar.make(SearchActivity.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
                                Snackbar.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }
                }else {
                    rlNodata.setVisibility(View.VISIBLE);
                    rlNoInternet.setVisibility(View.GONE);
                    Snackbar.make(SearchActivity.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
                            Snackbar.LENGTH_LONG).show();
                    pDialog.dismiss();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onFailure(@NonNull Call<Value<Menu>> call, @NonNull Throwable t) {
                System.out.println("Retrofit Error:" + t.getMessage());
                rlNodata.setVisibility(View.GONE);
                rlNoInternet.setVisibility(View.VISIBLE);
                Snackbar.make(SearchActivity.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
                        Snackbar.LENGTH_LONG).show();
                pDialog.dismiss();
            }
        });
    }

}
