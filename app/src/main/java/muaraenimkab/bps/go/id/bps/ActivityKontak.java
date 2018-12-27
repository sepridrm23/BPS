package muaraenimkab.bps.go.id.bps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class ActivityKontak extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);
        LinearLayout llAlamat, llTelepon, llEmail;
        llAlamat = findViewById(R.id.ll_alamat);
        llTelepon = findViewById(R.id.ll_telepon);
        llEmail = findViewById(R.id.ll_email);

        ActivityKontak.this.setTitle("Kontak");

        llAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        llEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        llTelepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
