package muaraenimkab.bps.go.id.bps;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentStrukturOrganisasi extends Fragment {
    public FragmentStrukturOrganisasi(){

    }

    public static FragmentStrukturOrganisasi newInstance() {
        FragmentStrukturOrganisasi fragment = new FragmentStrukturOrganisasi();
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
        View v = inflater.inflate(R.layout.fragment_struktur, container, false);

        return v;
    }
}
