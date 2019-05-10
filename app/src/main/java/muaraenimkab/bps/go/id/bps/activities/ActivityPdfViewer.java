package muaraenimkab.bps.go.id.bps.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

import muaraenimkab.bps.go.id.bps.R;

public class ActivityPdfViewer extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);
        PDFView pdfView = findViewById(R.id.pdfView);

        Intent intent = getIntent();
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(path, intent.getStringExtra("data"));
        pdfView.fromFile(file).spacing(5).load();

    }
}
