package muaraenimkab.bps.go.id.bps.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import muaraenimkab.bps.go.id.bps.models.Models;
import muaraenimkab.bps.go.id.bps.R;
import muaraenimkab.bps.go.id.bps.activities.ActivityRootEkonomi;
import muaraenimkab.bps.go.id.bps.activities.ActivityRootPertanian;
import muaraenimkab.bps.go.id.bps.activities.ActivityRootSosial;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DataObjectHolder> {
    private Context context;
    private ArrayList<Models> mList;
    private String flag;

    public RecyclerViewAdapter(Context context, ArrayList<Models> mList, String flag) {
        this.context = context;
        this.mList = mList;
        this.flag = flag;
    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
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
                if (flag.equals("1")){
                    Intent intent = new Intent(context, ActivityRootSosial.class);
                    intent.putExtra("flag", mList.get(position).getTitle());
                    context.startActivity(intent);
                }else if (flag.equals("2")){
                    Intent intent = new Intent(context, ActivityRootEkonomi.class);
                    intent.putExtra("flag", mList.get(position).getTitle());
                    context.startActivity(intent);
                }else if (flag.equals("3")){
                    Intent intent = new Intent(context, ActivityRootPertanian.class);
                    intent.putExtra("flag", mList.get(position).getTitle());
                    context.startActivity(intent);
                }
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
