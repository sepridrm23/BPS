package muaraenimkab.bps.go.id.bps.activities;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import muaraenimkab.bps.go.id.bps.R;
import muaraenimkab.bps.go.id.bps.models.AnggotaDPRD;
import muaraenimkab.bps.go.id.bps.models.AnggotaDewan;
import muaraenimkab.bps.go.id.bps.models.DataPemerintahan;
import muaraenimkab.bps.go.id.bps.models.DataPenduduk;
import muaraenimkab.bps.go.id.bps.models.LapanganUsaha;
import muaraenimkab.bps.go.id.bps.models.Value;
import muaraenimkab.bps.go.id.bps.services.APIServices;
import muaraenimkab.bps.go.id.bps.utils.Utilities;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityDetail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getdatapemerintahan();
        getanggotadprd();
        getanggotadewan();
        getlapanganusaha();
        getdatapenduduk();

//        Pie pie = AnyChart.column3d();
         Cartesian cartesian = AnyChart.vertical();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Lubuk Linggau", 250000));
        data.add(new ValueDataEntry("Pagar Alam", 150000));
        data.add(new ValueDataEntry("Prabumulih", 200000));
        data.add(new ValueDataEntry("Palembang", 1550000));
        data.add(new ValueDataEntry("Empat Lawang", 200000));
        data.add(new ValueDataEntry("Ogan Ilir", 200000));
        data.add(new ValueDataEntry("OKU Timur", 270000));
        data.add(new ValueDataEntry("OKU Selatan", 480000));
        data.add(new ValueDataEntry("Banyuasin", 550000));
        data.add(new ValueDataEntry("Musi Banyuasin", 450000));
        data.add(new ValueDataEntry("Muratara", 850000));
        data.add(new ValueDataEntry("Musi Rawas", 510000));
        data.add(new ValueDataEntry("Lahat", 480000));
        data.add(new ValueDataEntry("Pali", 470000));
        data.add(new ValueDataEntry("Muara Enim", 510000));
        data.add(new ValueDataEntry("OKI", 850000));
        data.add(new ValueDataEntry("OKU", 450000));

        cartesian.data(data);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setChart(cartesian);

    }

    private void getdatapemerintahan() {
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
        Call<Value<DataPemerintahan>> call = api.getdatapemerintahan(random);
        call.enqueue(new Callback<Value<DataPemerintahan>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(@NonNull Call<Value<DataPemerintahan>> call, @NonNull Response<Value<DataPemerintahan>> response) {
                if (response.body() != null) {
                    int success = Objects.requireNonNull(response.body()).getSuccess();
                    if (success == 1) {
                        ArrayList<DataPemerintahan> data = (ArrayList<DataPemerintahan>) Objects.requireNonNull(response.body()).getData();

                        pDialog.dismiss();
                    }else {
                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
                                Snackbar.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }
                }else {
                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
                            Snackbar.LENGTH_LONG).show();
                    pDialog.dismiss();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onFailure(@NonNull Call<Value<DataPemerintahan>> call, @NonNull Throwable t) {
                System.out.println("Retrofit Error:" + t.getMessage());
                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
                        Snackbar.LENGTH_LONG).show();
                pDialog.dismiss();
            }
        });
    }

    private void getanggotadprd() {
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
        Call<Value<AnggotaDPRD>> call = api.getanggotadprd(random);
        call.enqueue(new Callback<Value<AnggotaDPRD>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(@NonNull Call<Value<AnggotaDPRD>> call, @NonNull Response<Value<AnggotaDPRD>> response) {
                if (response.body() != null) {
                    int success = Objects.requireNonNull(response.body()).getSuccess();
                    if (success == 1) {
                        ArrayList<AnggotaDPRD> data = (ArrayList<AnggotaDPRD>) Objects.requireNonNull(response.body()).getData();

                        pDialog.dismiss();
                    }else {
                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
                                Snackbar.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }
                }else {
                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
                            Snackbar.LENGTH_LONG).show();
                    pDialog.dismiss();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onFailure(@NonNull Call<Value<AnggotaDPRD>> call, @NonNull Throwable t) {
                System.out.println("Retrofit Error:" + t.getMessage());
                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
                        Snackbar.LENGTH_LONG).show();
                pDialog.dismiss();
            }
        });
    }

    private void getanggotadewan() {
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
        Call<Value<AnggotaDewan>> call = api.getanggotadewan(random);
        call.enqueue(new Callback<Value<AnggotaDewan>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(@NonNull Call<Value<AnggotaDewan>> call, @NonNull Response<Value<AnggotaDewan>> response) {
                if (response.body() != null) {
                    int success = Objects.requireNonNull(response.body()).getSuccess();
                    if (success == 1) {
                        ArrayList<AnggotaDewan> data = (ArrayList<AnggotaDewan>) Objects.requireNonNull(response.body()).getData();

                        pDialog.dismiss();
                    }else {
                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
                                Snackbar.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }
                }else {
                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
                            Snackbar.LENGTH_LONG).show();
                    pDialog.dismiss();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onFailure(@NonNull Call<Value<AnggotaDewan>> call, @NonNull Throwable t) {
                System.out.println("Retrofit Error:" + t.getMessage());
                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
                        Snackbar.LENGTH_LONG).show();
                pDialog.dismiss();
            }
        });
    }

    private void getlapanganusaha() {
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
        Call<Value<LapanganUsaha>> call = api.getlapanganusaha(random);
        call.enqueue(new Callback<Value<LapanganUsaha>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(@NonNull Call<Value<LapanganUsaha>> call, @NonNull Response<Value<LapanganUsaha>> response) {
                if (response.body() != null) {
                    int success = Objects.requireNonNull(response.body()).getSuccess();
                    if (success == 1) {
                        ArrayList<LapanganUsaha> data = (ArrayList<LapanganUsaha>) Objects.requireNonNull(response.body()).getData();

                        pDialog.dismiss();
                    }else {
                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
                                Snackbar.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }
                }else {
                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
                            Snackbar.LENGTH_LONG).show();
                    pDialog.dismiss();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onFailure(@NonNull Call<Value<LapanganUsaha>> call, @NonNull Throwable t) {
                System.out.println("Retrofit Error:" + t.getMessage());
                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
                        Snackbar.LENGTH_LONG).show();
                pDialog.dismiss();
            }
        });
    }

    private void getdatapenduduk() {
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
        Call<Value<DataPenduduk>> call = api.getdatapenduduk(random);
        call.enqueue(new Callback<Value<DataPenduduk>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(@NonNull Call<Value<DataPenduduk>> call, @NonNull Response<Value<DataPenduduk>> response) {
                if (response.body() != null) {
                    int success = Objects.requireNonNull(response.body()).getSuccess();
                    if (success == 1) {
                        ArrayList<DataPenduduk> data = (ArrayList<DataPenduduk>) Objects.requireNonNull(response.body()).getData();

                        pDialog.dismiss();
                    }else {
                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
                                Snackbar.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }
                }else {
                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
                            Snackbar.LENGTH_LONG).show();
                    pDialog.dismiss();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onFailure(@NonNull Call<Value<DataPenduduk>> call, @NonNull Throwable t) {
                System.out.println("Retrofit Error:" + t.getMessage());
                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
                        Snackbar.LENGTH_LONG).show();
                pDialog.dismiss();
            }
        });
    }
}