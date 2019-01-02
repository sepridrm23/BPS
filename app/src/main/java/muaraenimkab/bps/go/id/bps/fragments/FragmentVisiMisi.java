package muaraenimkab.bps.go.id.bps.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import muaraenimkab.bps.go.id.bps.R;

public class FragmentVisiMisi extends Fragment {
    public FragmentVisiMisi(){

    }

    public static FragmentVisiMisi newInstance() {
        FragmentVisiMisi fragment = new FragmentVisiMisi();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_visi_misi, container, false);

        return v;
    }
}
