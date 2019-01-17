package muaraenimkab.bps.go.id.bps.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import muaraenimkab.bps.go.id.bps.R;
import muaraenimkab.bps.go.id.bps.models.ValueArr;
import muaraenimkab.bps.go.id.bps.services.APIServices;
import muaraenimkab.bps.go.id.bps.utils.Utilities;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityDetail extends AppCompatActivity {
    TableLayout tl;
    RelativeLayout rLayout;
    NestedScrollView lLayout;
    Spinner spinner;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tl = findViewById(R.id.main_table);
        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        TextView tvDiagram = findViewById(R.id.diagram);
        TextView tvTabel = findViewById(R.id.tabel);
        rLayout = findViewById(R.id.rLayout);
        lLayout = findViewById(R.id.lLayout);

        spinner = findViewById(R.id.spinner);
        editText = findViewById(R.id.etCari);
        button = findViewById(R.id.btnCari);

        ActivityDetail.this.setTitle(getIntent().getStringExtra("name"));

        tvDiagram.setText("Diagram "+getIntent().getStringExtra("name"));
        tvTabel.setText("Tabel "+getIntent().getStringExtra("name"));

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        anyChartView.setLayoutParams(new LinearLayout.LayoutParams(displayMetrics.widthPixels, displayMetrics.widthPixels));

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
        anyChartView.setChart(cartesian);

        getDetail(getIntent().getStringExtra("id"));

//        TableRow tr_head = new TableRow(this);
//        tr_head.setId(10);
//        tr_head.setBackgroundColor(Color.GRAY);
//        tr_head.setLayoutParams(new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.FILL_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT));
//
//        TextView label_date = new TextView(this);
//        label_date.setId(20);
//        label_date.setText("DATE");
//        label_date.setTextColor(Color.WHITE);
//        label_date.setPadding(5, 5, 5, 5);
//        tr_head.addView(label_date);// add the column to the table row here
//
//        TextView label_weight_kg = new TextView(this);
//        label_weight_kg.setId(21);// define id that must be unique
//        label_weight_kg.setText("Wt(Kg.)"); // set the text for the header
//        label_weight_kg.setTextColor(Color.WHITE); // set the color
//        label_weight_kg.setPadding(5, 5, 5, 5); // set the padding (if required)
//        tr_head.addView(label_weight_kg); // add the column to the table row here
//
//        tl.addView(tr_head, new TableLayout.LayoutParams(
//                LinearLayout.LayoutParams.FILL_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT));
//
//        Integer count=0;
//        for(int a=0; a<5; a++){
//            String date = "23-09-1995";// get the first variable
//            Double weight_kg = 20.0;// get the second variable
//// Create the table row
//            TableRow tr = new TableRow(this);
//            if(count%2!=0) tr.setBackgroundColor(Color.GRAY);
//            tr.setId(100+count);
//            tr.setLayoutParams(new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.FILL_PARENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT));
//
////Create two columns to add as table data
//            // Create a TextView to add date
//            TextView labelDATE = new TextView(this);
//            labelDATE.setId(200+count);
//            labelDATE.setText(date);
//            labelDATE.setPadding(2, 0, 5, 0);
//            if(count%2!=0) {
//                labelDATE.setTextColor(Color.WHITE);
//            }else {
//                labelDATE.setTextColor(Color.GRAY);
//            }
//            tr.addView(labelDATE);
//            TextView labelWEIGHT = new TextView(this);
//            labelWEIGHT.setId(200+count);
//            labelWEIGHT.setText(weight_kg.toString());
//            if(count%2!=0) {
//                labelWEIGHT.setTextColor(Color.WHITE);
//            }else {
//                labelWEIGHT.setTextColor(Color.GRAY);
//            }
//            tr.addView(labelWEIGHT);
//
//// finally add this to the table row
//            tl.addView(tr, new TableLayout.LayoutParams(
//                    LinearLayout.LayoutParams.FILL_PARENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT));
//            count++;
//        }

    }

    private void getDetail(final String id) {
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
        Call<ValueArr> call = api.getdetail(random, id);
        call.enqueue(new Callback<ValueArr>() {
            @SuppressLint("ResourceType")
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(@NonNull Call<ValueArr> call, @NonNull Response<ValueArr> response) {
                if (response.body() != null) {
                    int success = Objects.requireNonNull(response.body()).getSuccess();
                    if (success == 1) {
                        String[][] data = response.body().getData();
                        String[] field = response.body().getField();

                        List<String> arr = new ArrayList<>(Arrays.asList(field));
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(ActivityDetail.this, android.R.layout.simple_spinner_dropdown_item, arr);
                        spinner.setAdapter(adapter);

                        TableRow tr_head = new TableRow(ActivityDetail.this);
                        tr_head.setId(999);
//                        tr_head.setBackgroundColor(Color.GRAY);
                        tr_head.setBackgroundColor(ContextCompat.getColor(ActivityDetail.this, R.color.colorPrimary));
                        tr_head.setLayoutParams(new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.FILL_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));

                        for(int a=0; a<field.length; a++){
                            TextView tv = new TextView(ActivityDetail.this);
                            tv.setId(a);
                            tv.setText(field[a]);
                            tv.setTextColor(Color.WHITE);
                            tv.setTextSize(17);
                            tv.setTypeface(null, Typeface.BOLD);
                            tv.setPadding(15, 15, 15, 15);
                            tr_head.addView(tv);
                        }

                        tl.addView(tr_head, new TableLayout.LayoutParams(
                                LinearLayout.LayoutParams.FILL_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));

                        for(int a=0; a<data.length; a++){
                            TableRow tr = new TableRow(ActivityDetail.this);
                            if(a%2!=0) tr.setBackgroundColor(Color.GRAY);
                            tr.setId((field.length+1)+a);
                            tr.setLayoutParams(new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.FILL_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT));

                            for(int b=0; b<data[a].length; b++){
                                TextView tv = new TextView(ActivityDetail.this);
                                tv.setId((field.length+1)+(a+1)+b);
                                tv.setText(data[a][b]);
                                tv.setTextSize(15);
                                tv.setPadding(18, 5, 15, 5);
                                if(a%2!=0) {
                                    tv.setTextColor(Color.WHITE);
                                }else {
                                    tv.setTextColor(Color.GRAY);
                                }
                                tr.addView(tv);
                            }

                            tl.addView(tr, new TableLayout.LayoutParams(
                                    LinearLayout.LayoutParams.FILL_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT));
                        }

                        rLayout.setVisibility(View.GONE);
                        lLayout.setVisibility(View.VISIBLE);
                        pDialog.dismiss();
                    }else if(success == 2){
                        rLayout.setVisibility(View.VISIBLE);
                        lLayout.setVisibility(View.GONE);
                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Data belum tersedia",
                                Snackbar.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }else {
                        rLayout.setVisibility(View.VISIBLE);
                        lLayout.setVisibility(View.GONE);
                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
                                Snackbar.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }
                }else {
                    rLayout.setVisibility(View.VISIBLE);
                    lLayout.setVisibility(View.GONE);
                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
                            Snackbar.LENGTH_LONG).show();
                    pDialog.dismiss();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onFailure(@NonNull Call<ValueArr> call, @NonNull Throwable t) {
                System.out.println("Retrofit Error:" + t.getMessage());
                rLayout.setVisibility(View.VISIBLE);
                lLayout.setVisibility(View.GONE);
                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
                        Snackbar.LENGTH_LONG).show();
                pDialog.dismiss();
            }
        });
    }

//    private void getdatapemerintahan() {
//        final ProgressDialog pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(false);
//        pDialog.show();
//
//        final String random = Utilities.getRandom(5);
//
//        OkHttpClient okHttpClient = Utilities.getUnsafeOkHttpClient();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Utilities.getURL())
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();
//
//        APIServices api = retrofit.create(APIServices.class);
//        Call<ValueArr> call = api.getdatapemerintahan(random);
//        call.enqueue(new Callback<ValueArr>() {
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onResponse(@NonNull Call<ValueArr> call, @NonNull Response<ValueArr> response) {
//                if (response.body() != null) {
//                    int success = Objects.requireNonNull(response.body()).getSuccess();
//                    if (success == 1) {
//                        String[][] data = response.body().getData();
//                        String[] field = response.body().getField();
//                        Log.e("field", ""+field[1]);
//                        Log.e("data", ""+data[1]);
//                        Log.e("data", ""+data[1][1]);
//
//                        TableLayout ll = findViewById(R.id.displayLinear);
//                        for (int i = 0; i <data.length; i++) {
//                            TableRow row= new TableRow(ActivityDetail.this);
//                            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
//                            row.setLayoutParams(lp);
//                            for (int a = 0; a <field.length; a++) {
//                                TextView qty = new TextView(ActivityDetail.this);
//                                qty.setText(data[i][a]);
//                                row.addView(qty);
//                            }
//                            ll.addView(row,i);
//                        }
//
////                        TableDataAdapter<String[]> myDataAdapter =
////                                new SimpleTableDataAdapter(getContext(), myData);
////                        TableHeaderAdapter myHeaderAdapter =
////                                new SimpleTableHeaderAdapter(getContext(), "Header1", "Header2", "Header3");
////
////                        TableView<String[]> table = findViewById(R.id.table);
////                        table.setDataAdapter(myDataAdapter);
////                        table.setHeaderAdapter(myHeaderAdapter);
//
//                        pDialog.dismiss();
//                    }else {
//                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
//                                Snackbar.LENGTH_LONG).show();
//                        pDialog.dismiss();
//                    }
//                }else {
//                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
//                            Snackbar.LENGTH_LONG).show();
//                    pDialog.dismiss();
//                }
//            }
//
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onFailure(@NonNull Call<ValueArr> call, @NonNull Throwable t) {
//                System.out.println("Retrofit Error:" + t.getMessage());
//                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
//                        Snackbar.LENGTH_LONG).show();
//                pDialog.dismiss();
//            }
//        });
//    }
//
//    private void getanggotadprd() {
//        final ProgressDialog pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(false);
//        pDialog.show();
//
//        final String random = Utilities.getRandom(5);
//
//        OkHttpClient okHttpClient = Utilities.getUnsafeOkHttpClient();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Utilities.getURL())
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();
//
//        APIServices api = retrofit.create(APIServices.class);
//        Call<Value<AnggotaDPRD>> call = api.getanggotadprd(random);
//        call.enqueue(new Callback<Value<AnggotaDPRD>>() {
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onResponse(@NonNull Call<Value<AnggotaDPRD>> call, @NonNull Response<Value<AnggotaDPRD>> response) {
//                if (response.body() != null) {
//                    int success = Objects.requireNonNull(response.body()).getSuccess();
//                    if (success == 1) {
//                        ArrayList<AnggotaDPRD> data = (ArrayList<AnggotaDPRD>) Objects.requireNonNull(response.body()).getData();
//
//                        pDialog.dismiss();
//                    }else {
//                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
//                                Snackbar.LENGTH_LONG).show();
//                        pDialog.dismiss();
//                    }
//                }else {
//                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
//                            Snackbar.LENGTH_LONG).show();
//                    pDialog.dismiss();
//                }
//            }
//
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onFailure(@NonNull Call<Value<AnggotaDPRD>> call, @NonNull Throwable t) {
//                System.out.println("Retrofit Error:" + t.getMessage());
//                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
//                        Snackbar.LENGTH_LONG).show();
//                pDialog.dismiss();
//            }
//        });
//    }
//
//    private void getanggotadewan() {
//        final ProgressDialog pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(false);
//        pDialog.show();
//
//        final String random = Utilities.getRandom(5);
//
//        OkHttpClient okHttpClient = Utilities.getUnsafeOkHttpClient();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Utilities.getURL())
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();
//
//        APIServices api = retrofit.create(APIServices.class);
//        Call<Value<AnggotaDewan>> call = api.getanggotadewan(random);
//        call.enqueue(new Callback<Value<AnggotaDewan>>() {
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onResponse(@NonNull Call<Value<AnggotaDewan>> call, @NonNull Response<Value<AnggotaDewan>> response) {
//                if (response.body() != null) {
//                    int success = Objects.requireNonNull(response.body()).getSuccess();
//                    if (success == 1) {
//                        ArrayList<AnggotaDewan> data = (ArrayList<AnggotaDewan>) Objects.requireNonNull(response.body()).getData();
//
//                        pDialog.dismiss();
//                    }else {
//                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
//                                Snackbar.LENGTH_LONG).show();
//                        pDialog.dismiss();
//                    }
//                }else {
//                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
//                            Snackbar.LENGTH_LONG).show();
//                    pDialog.dismiss();
//                }
//            }
//
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onFailure(@NonNull Call<Value<AnggotaDewan>> call, @NonNull Throwable t) {
//                System.out.println("Retrofit Error:" + t.getMessage());
//                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
//                        Snackbar.LENGTH_LONG).show();
//                pDialog.dismiss();
//            }
//        });
//    }
//
//    private void getlapanganusaha() {
//        final ProgressDialog pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(false);
//        pDialog.show();
//
//        final String random = Utilities.getRandom(5);
//
//        OkHttpClient okHttpClient = Utilities.getUnsafeOkHttpClient();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Utilities.getURL())
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();
//
//        APIServices api = retrofit.create(APIServices.class);
//        Call<Value<LapanganUsaha>> call = api.getlapanganusaha(random);
//        call.enqueue(new Callback<Value<LapanganUsaha>>() {
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onResponse(@NonNull Call<Value<LapanganUsaha>> call, @NonNull Response<Value<LapanganUsaha>> response) {
//                if (response.body() != null) {
//                    int success = Objects.requireNonNull(response.body()).getSuccess();
//                    if (success == 1) {
//                        ArrayList<LapanganUsaha> data = (ArrayList<LapanganUsaha>) Objects.requireNonNull(response.body()).getData();
//
//                        pDialog.dismiss();
//                    }else {
//                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
//                                Snackbar.LENGTH_LONG).show();
//                        pDialog.dismiss();
//                    }
//                }else {
//                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
//                            Snackbar.LENGTH_LONG).show();
//                    pDialog.dismiss();
//                }
//            }
//
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onFailure(@NonNull Call<Value<LapanganUsaha>> call, @NonNull Throwable t) {
//                System.out.println("Retrofit Error:" + t.getMessage());
//                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
//                        Snackbar.LENGTH_LONG).show();
//                pDialog.dismiss();
//            }
//        });
//    }
//
//    private void getdatapenduduk() {
//        final ProgressDialog pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(false);
//        pDialog.show();
//
//        final String random = Utilities.getRandom(5);
//
//        OkHttpClient okHttpClient = Utilities.getUnsafeOkHttpClient();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Utilities.getURL())
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();
//
//        APIServices api = retrofit.create(APIServices.class);
//        Call<Value<DataPenduduk>> call = api.getdatapenduduk(random);
//        call.enqueue(new Callback<Value<DataPenduduk>>() {
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onResponse(@NonNull Call<Value<DataPenduduk>> call, @NonNull Response<Value<DataPenduduk>> response) {
//                if (response.body() != null) {
//                    int success = Objects.requireNonNull(response.body()).getSuccess();
//                    if (success == 1) {
//                        ArrayList<DataPenduduk> data = (ArrayList<DataPenduduk>) Objects.requireNonNull(response.body()).getData();
//
//                        pDialog.dismiss();
//                    }else {
//                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi"+response.body().getMessage(),
//                                Snackbar.LENGTH_LONG).show();
//                        pDialog.dismiss();
//                    }
//                }else {
//                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
//                            Snackbar.LENGTH_LONG).show();
//                    pDialog.dismiss();
//                }
//            }
//
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onFailure(@NonNull Call<Value<DataPenduduk>> call, @NonNull Throwable t) {
//                System.out.println("Retrofit Error:" + t.getMessage());
//                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
//                        Snackbar.LENGTH_LONG).show();
//                pDialog.dismiss();
//            }
//        });
//    }
}