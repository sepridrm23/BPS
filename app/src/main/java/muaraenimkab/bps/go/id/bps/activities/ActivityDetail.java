package muaraenimkab.bps.go.id.bps.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;
import java.io.OutputStream;

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
    RelativeLayout rLayoutData, rLayoutInternet;
    NestedScrollView lLayout;
    Spinner spinner;
    EditText editText;
    Button btnCari, btnDonlot;
    LinearLayout pencarian;

    String[][] data, dataSearch;
    String[] field;
    int counter;

    private File pdfFile;

//    private static final String TAG = "DetailActivity";
    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tl = findViewById(R.id.main_table);
//        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        TextView tvDiagram = findViewById(R.id.diagram);
        TextView tvTabel = findViewById(R.id.tabel);
        rLayoutData = findViewById(R.id.rLayoutData);
        rLayoutInternet = findViewById(R.id.rLayoutInternet);
        lLayout = findViewById(R.id.lLayout);
        pencarian=findViewById(R.id.pencarian);

        spinner = findViewById(R.id.spinner);
        editText = findViewById(R.id.etCari);
        btnCari = findViewById(R.id.btnCari);
        btnDonlot = findViewById(R.id.btnDonlot);

        ActivityDetail.this.setTitle(getIntent().getStringExtra("name"));

        tvDiagram.setText("Diagram "+getIntent().getStringExtra("name"));
        tvTabel.setText("Tabel "+getIntent().getStringExtra("name"));

//        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
//        anyChartView.setLayoutParams(new LinearLayout.LayoutParams(displayMetrics.widthPixels, displayMetrics.widthPixels));

//        Pie pie = AnyChart.column3d();
//        Cartesian cartesian = AnyChart.vertical();
//
//        final List<DataEntry> dataChart = new ArrayList<>();
//        dataChart.add(new ValueDataEntry("Lubuk Linggau", 250000));
//        dataChart.add(new ValueDataEntry("Pagar Alam", 150000));
//        dataChart.add(new ValueDataEntry("Prabumulih", 200000));
//        dataChart.add(new ValueDataEntry("Palembang", 1550000));
//        dataChart.add(new ValueDataEntry("Empat Lawang", 200000));
//        dataChart.add(new ValueDataEntry("Ogan Ilir", 200000));
//        dataChart.add(new ValueDataEntry("OKU Timur", 270000));
//        dataChart.add(new ValueDataEntry("OKU Selatan", 480000));
//        dataChart.add(new ValueDataEntry("Banyuasin", 550000));
//        dataChart.add(new ValueDataEntry("Musi Banyuasin", 450000));
//        dataChart.add(new ValueDataEntry("Muratara", 850000));
//        dataChart.add(new ValueDataEntry("Musi Rawas", 510000));
//        dataChart.add(new ValueDataEntry("Lahat", 480000));
//        dataChart.add(new ValueDataEntry("Pali", 470000));
//        dataChart.add(new ValueDataEntry("Muara Enim", 510000));
//        dataChart.add(new ValueDataEntry("OKI", 850000));
//        dataChart.add(new ValueDataEntry("OKU", 450000));

//        cartesian.data(dataChart);
//        anyChartView.setChart(cartesian);

        getDetail(getIntent().getStringExtra("id"));

        btnCari.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int index = spinner.getSelectedItemPosition();
                counter=0;
                int flag = 0;
                dataSearch = new String[data.length][field.length];
                for (int a=0; a<data.length; a++) {
                    if (!editText.getText().toString().isEmpty()) {
//                        Log.e("data", index + "|" + data[a][index] + "|" + editText.getText().toString().toLowerCase());
                        if (data[a][index].toLowerCase().contains(editText.getText().toString().toLowerCase())) {
//                            Log.e("in", "in"+" "+data[a][index]);
                            for(int b=0; b<field.length; b++) {
                                dataSearch[counter][b] = data[a][b];
                            }
                            counter++;
                            flag = 1;
                        }else {
//                            Log.e("out", "out"+" "+data[a][index]);
                            if (flag != 1) {
                                flag = 2;
                            }
                        }
                    }else {
//                        Log.e("null", "null");
                        flag = 0;
                    }
                }

                if (flag == 2){
                    tl.removeAllViews();
                    TableRow tr_head = new TableRow(ActivityDetail.this);
                    tr_head.setId(999);
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
                            ViewGroup.LayoutParams.FILL_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));

//                    for(int a=0; a<1; a++){
                        TableRow tr = new TableRow(ActivityDetail.this);
                        tr.setBackgroundColor(Color.GRAY);
                        tr.setId((field.length+1)+1);
                        tr.setLayoutParams(new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.FILL_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));

                        for(int b=0; b<field.length; b++){
                            TextView tv = new TextView(ActivityDetail.this);
                            tv.setId((field.length+1)+(1+1)+b);
                            tv.setText("                    -                    ");
                            tv.setTextSize(15);
                            tv.setPadding(18, 5, 15, 5);
                            tv.setTextColor(Color.WHITE);
                            tr.addView(tv);
                        }

                        tl.addView(tr, new TableLayout.LayoutParams(
                                LinearLayout.LayoutParams.FILL_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));
//                    }

                    Toast.makeText(ActivityDetail.this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();

                }else if (flag == 1){
                    if (counter > 0) {
                        tl.removeAllViews();
//                        for (int a = 0; a < counter; a++) {
//                            for (int b = 0; b < field.length; b++) {
//                                Log.e("data search", "" + dataSearch[a][b]);
//                            }
//                        }

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

                        for(int a=0; a<counter; a++){
                            TableRow tr = new TableRow(ActivityDetail.this);
                            if(a%2!=0) tr.setBackgroundColor(Color.GRAY);
                            tr.setId((field.length+1)+a);
                            tr.setLayoutParams(new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.FILL_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT));

                            for(int b=0; b<dataSearch[a].length; b++){
                                TextView tv = new TextView(ActivityDetail.this);
                                tv.setId((field.length+1)+(a+1)+b);
                                tv.setText(dataSearch[a][b]);
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
                    }
                }
            }
        });

        btnDonlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    createPdfWrapper();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        });

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
                        data = response.body().getData();
                        field = response.body().getField();

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

                        rLayoutData.setVisibility(View.GONE);
                        rLayoutInternet.setVisibility(View.GONE);
                        lLayout.setVisibility(View.VISIBLE);
                        pencarian.setVisibility(View.VISIBLE);
                        btnDonlot.setVisibility(View.VISIBLE);
                        pDialog.dismiss();
                    }else if(success == 2){
                        rLayoutData.setVisibility(View.VISIBLE);
                        rLayoutInternet.setVisibility(View.GONE);
                        lLayout.setVisibility(View.GONE);
                        pencarian.setVisibility(View.GONE);
                        btnDonlot.setVisibility(View.GONE);
                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Data belum tersedia",
                                Snackbar.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }else {
                        rLayoutData.setVisibility(View.VISIBLE);
                        rLayoutInternet.setVisibility(View.GONE);
                        lLayout.setVisibility(View.GONE);
                        pencarian.setVisibility(View.GONE);
                        btnDonlot.setVisibility(View.GONE);
                        Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
                                Snackbar.LENGTH_LONG).show();
                        pDialog.dismiss();
                    }
                }else {
                    rLayoutData.setVisibility(View.VISIBLE);
                    rLayoutInternet.setVisibility(View.GONE);
                    lLayout.setVisibility(View.GONE);
                    pencarian.setVisibility(View.GONE);
                    btnDonlot.setVisibility(View.GONE);
                    Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Gagal mengambil data. Silahkan coba lagi",
                            Snackbar.LENGTH_LONG).show();
                    pDialog.dismiss();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onFailure(@NonNull Call<ValueArr> call, @NonNull Throwable t) {
                System.out.println("Retrofit Error:" + t.getMessage());
                rLayoutData.setVisibility(View.GONE);
                rLayoutInternet.setVisibility(View.VISIBLE);
                lLayout.setVisibility(View.GONE);
                pencarian.setVisibility(View.GONE);
                btnDonlot.setVisibility(View.GONE);
                Snackbar.make(ActivityDetail.this.findViewById(android.R.id.content), "Tidak terhubung ke Internet",
                        Snackbar.LENGTH_LONG).show();
                pDialog.dismiss();
            }
        });
    }

    private void createPdfWrapper() throws FileNotFoundException, DocumentException {

        int hasWriteStoragePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_CONTACTS)) {
//                    showMessageOKCancel("You need to allow access to Storage",
//                            new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                                REQUEST_CODE_ASK_PERMISSIONS);
//                                    }
//                                }
//                            });
                    return;
                }

                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
            }

        }else {
            createPdf();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    try {
                        createPdfWrapper();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Permission Denied
                    Toast.makeText(this, "WRITE_EXTERNAL Permission Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private void createPdf() throws FileNotFoundException, DocumentException {
//        final ProgressDialog pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(false);
//        pDialog.show();

        File docsFolder = new File(Environment.getExternalStorageDirectory() + "/Simada");
        if (!docsFolder.exists()) {
            docsFolder.mkdir();
//            Log.i(TAG, "Created a new directory for PDF");
        }

        pdfFile = new File(docsFolder.getAbsolutePath(),getIntent().getStringExtra("name")+".pdf");
        OutputStream output = new FileOutputStream(pdfFile);
        Document document = new Document();
        PdfWriter.getInstance(document, output);
        document.open();
        document.setPageSize(PageSize.A4);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_muaraenim);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bm=Bitmap.createScaledBitmap(bm, 70,70, true);
        bm.compress(Bitmap.CompressFormat.PNG, 100, stream);
        Image img = null;
        byte[] byteArray = stream.toByteArray();
        try {
            img = Image.getInstance(byteArray);
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        document.add(img);

        BaseFont urName = null;
        try {
            urName = BaseFont.createFont(
                    BaseFont.TIMES_ROMAN,
                    BaseFont.CP1252,
                    BaseFont.EMBEDDED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font mOrderDetailsTitleFont = new Font(urName, 20.0f, Font.BOLDITALIC, BaseColor.BLACK);
        Chunk mOrderDetailsTitleChunk = new Chunk(getIntent().getStringExtra("name"), mOrderDetailsTitleFont);
        Paragraph mOrderDetailsTitleParagraph = new Paragraph(mOrderDetailsTitleChunk);
//        mOrderDetailsTitleParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(mOrderDetailsTitleParagraph);

//        LineSeparator lineSeparator = new LineSeparator();
//        lineSeparator.setLineColor(new BaseColor(0, 0, 0, 68));
//        document.add(new Chunk(lineSeparator));
//
//        document.add( Chunk.NEWLINE );

        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(field.length+1);
        table.setWidthPercentage(100);
        float[] columnSize = new float[field.length+1];
        int med = 92 / field.length;
        columnSize[0] = 8;
        for (int a=1; a<field.length+1; a++){
            columnSize[a] = med;
        }
        table.setWidths(columnSize);

        PdfPCell[] cell = new PdfPCell[field.length+1];
        Font fontTitle = new Font(urName, 15, Font.BOLD);
        Font fontDetail = new Font(urName, 14);

        cell[0] = new PdfPCell(new Phrase("No", fontTitle));
        cell[0].setPadding(7);
        table.addCell(cell[0]);
        for (int a = 0; a < field.length; a++){
            cell[a+1] = new PdfPCell(new Phrase(field[a], fontTitle));
            cell[a+1].setPadding(7);
            table.addCell(cell[a+1]);
        }

        for(int a=0; a<data.length; a++) {
            int no = a+1;
            cell[0] = new PdfPCell(new Phrase(String.valueOf(no), fontDetail));
            cell[0].setPadding(7);
            table.addCell(cell[0]);
            for (int b = 0; b < data[a].length; b++) {
                cell[b+1] = new PdfPCell(new Phrase(data[a][b], fontDetail));
                cell[b+1].setPadding(7);
                table.addCell(cell[b+1]);
            }
        }
        document.add(table);

        document.close();

//        pDialog.dismiss();

        previewPdf();

    }

    private void previewPdf() {

//        PackageManager packageManager = getPackageManager();
//        Intent testIntent = new Intent(Intent.ACTION_VIEW);
//        testIntent.setType("application/pdf");
//        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
//        if (list.size() > 0) {
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_VIEW);
//            Uri uri = Uri.fromFile(pdfFile);
//            intent.setDataAndType(uri, "application/pdf");
//
//            startActivity(intent);
//        }else{
//            Toast.makeText(this,"Data berhasil diunduh ke folder Simada",Toast.LENGTH_LONG).show();
//        }

//        PackageManager packageManager = getPackageManager();
//        Intent testIntent = new Intent(Intent.ACTION_VIEW);
//        testIntent.setType("application/pdf");
//        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
//        if (list.size() > 0) {

            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                    m.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            File file = new File(Environment.getExternalStorageDirectory()
                    + "/Simada/" + getIntent().getStringExtra("name") + ".pdf");
            if (file.exists()) {
                Uri path = Uri.fromFile(file);
                Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
                pdfIntent.setDataAndType(path, "application/pdf");
                pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                try {
                    startActivity(pdfIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(this, "File berhasil diunduh ke folder Simada 1", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "File berhasil diunduh ke folder Simada 2", Toast.LENGTH_LONG).show();
            }

//        }else{
//            Toast.makeText(this,"File berhasil diunduh ke folder Simada 3",Toast.LENGTH_LONG).show();
//        }
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