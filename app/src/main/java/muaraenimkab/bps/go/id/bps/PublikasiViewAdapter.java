package muaraenimkab.bps.go.id.bps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PublikasiViewAdapter extends RecyclerView.Adapter<PublikasiViewAdapter.DataObjectHolder> {
    private Context context;
    private ArrayList<Models> mList;

    public PublikasiViewAdapter(Context context, ArrayList<Models> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_publikasi, parent, false);
        return new DataObjectHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onBindViewHolder(@NonNull final DataObjectHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.tvTitle.setText(mList.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //action
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        DataObjectHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
