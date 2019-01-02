package muaraenimkab.bps.go.id.bps.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;

import muaraenimkab.bps.go.id.bps.fragments.FragmentInformasi;
import muaraenimkab.bps.go.id.bps.fragments.FragmentPengolahanData;
import muaraenimkab.bps.go.id.bps.fragments.FragmentStrukturOrganisasi;
import muaraenimkab.bps.go.id.bps.fragments.FragmentTugasFungsi;
import muaraenimkab.bps.go.id.bps.fragments.FragmentVisiMisi;
import muaraenimkab.bps.go.id.bps.R;

public class ActivityTentang extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager mViewPager;
    Toolbar toolbar;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        tabLayout = findViewById(R.id.tLayout);
        mViewPager = findViewById(R.id.container);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Tentang Kami");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        tabLayout.setTabTextColors(Color.parseColor("#00574B"), Color.parseColor("#FFFFFF"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#008577"));
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(mViewPager);
            }
        });
    }

    class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentInformasi();
                case 1:
                    return new FragmentVisiMisi();
                case 2:
                    return new FragmentStrukturOrganisasi();
                case 3:
                    return new FragmentTugasFungsi();
                case 4:
                    return new FragmentPengolahanData();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Informasi Umum";
                case 1:
                    return "Visi dan Misi";
                case 2:
                    return "Struktur Organisasi";
                case 3:
                    return "Tugas, Fungsi dan Kewenangan";
                case 4:
                    return "Pengolahan Data";
            }
            return null;
        }
    }
}
