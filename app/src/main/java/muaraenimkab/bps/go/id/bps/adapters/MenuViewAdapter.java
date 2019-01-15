package muaraenimkab.bps.go.id.bps.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import muaraenimkab.bps.go.id.bps.activities.ActivityDetail;
import muaraenimkab.bps.go.id.bps.models.Menu;
import muaraenimkab.bps.go.id.bps.models.Models;
import muaraenimkab.bps.go.id.bps.R;
import muaraenimkab.bps.go.id.bps.activities.ActivityBerita;
import muaraenimkab.bps.go.id.bps.activities.ActivityBeritaResmi;
import muaraenimkab.bps.go.id.bps.activities.ActivityKontak;
import muaraenimkab.bps.go.id.bps.activities.ActivityMainRoot;
import muaraenimkab.bps.go.id.bps.activities.ActivityPublikasi;
import muaraenimkab.bps.go.id.bps.activities.ActivityTentang;
import muaraenimkab.bps.go.id.bps.utils.Utilities;

public class MenuViewAdapter extends RecyclerView.Adapter<MenuViewAdapter.DataObjectHolder> {
    private Context context;
    private ArrayList<Menu> mList;

    public MenuViewAdapter(Context context, ArrayList<Menu> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        return new DataObjectHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onBindViewHolder(@NonNull final DataObjectHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.tvTitle.setText(mList.get(position).getNama());
//        Log.e("logo", Utilities.getURLLogo()+mList.get(position).getLogo());
        Glide.with(context).load(Utilities.getURLLogo()+mList.get(position).getLogo()).into(holder.ivLogo);

//        Picasso .with(context)
//                .load(Utilities.getURLLogo() + mList.get(position).getLogo())
//                .fit()
//                .centerCrop()
//                .into(holder.ivLogo);

//        holder.tvTitle.setText(mList.get(position).getTitle());
//
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (position == 14){
//                    Intent intent = new Intent(context, ActivityPublikasi.class);
//                    intent.putExtra("flag", "14");
//                    context.startActivity(intent);
//                } else if (position == 15){
//                    Intent intent = new Intent(context, ActivityBeritaResmi.class);
//                    intent.putExtra("flag", "15");
//                    context.startActivity(intent);
//                } else if (position == 16){
//                    Intent intent = new Intent(context, ActivityBerita.class);
//                    intent.putExtra("flag", "16");
//                    context.startActivity(intent);
//                } else if (position == 17){
//                    Intent intent = new Intent(context, ActivityKontak.class);
//                    intent.putExtra("flag", "17");
//                    context.startActivity(intent);
//                } else if (position == 18){
//                    Intent intent = new Intent(context, ActivityTentang.class);
//                    intent.putExtra("flag", "18");
//                    context.startActivity(intent);
//                } else {
//                    Intent intent = new Intent(context, ActivityMainRoot.class);
//                    intent.putExtra("flag", String.valueOf(position));
//                    context.startActivity(intent);
//                }
                Intent intent = new Intent(context, ActivityMainRoot.class);
                intent.putExtra("flag", String.valueOf(mList.get(position).getId()));
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivLogo;
//        CardView cView;

        DataObjectHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivLogo = itemView.findViewById(R.id.iv_logo);
//            cView = itemView.findViewById(R.id.card_view);

//            Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
//            final DisplayMetrics outMetrics = new DisplayMetrics();
//            display.getMetrics(outMetrics);
//            int displaySize = Math.round(outMetrics.widthPixels);
//            int viewPagerWidth = (displaySize/4);
//            int viewPagerHeight = (displaySize/6);
//            ivLogo.setLayoutParams(new LinearLayout.LayoutParams(viewPagerWidth, viewPagerHeight));
        }
    }
}
