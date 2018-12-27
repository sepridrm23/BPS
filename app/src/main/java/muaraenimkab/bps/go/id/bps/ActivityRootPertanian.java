package muaraenimkab.bps.go.id.bps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityRootPertanian extends AppCompatActivity {
    RecyclerView rView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Models> aList;
    Models[] data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        rView = findViewById(R.id.recycler_view);

        String flag = getIntent().getStringExtra("flag");
        ActivityRootPertanian.this.setTitle(flag);

    }
}
