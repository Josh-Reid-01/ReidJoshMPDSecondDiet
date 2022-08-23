package org.me.gcu.labstuff.reidjoshmpdseconddiet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<RSSItem> rssList;
    LayoutInflater inflater;

    public CustomBaseAdapter (Context ctx, ArrayList<RSSItem> rssItemList){
        this.context=ctx;
        this.rssList=rssItemList;
        inflater=LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return rssList.size();
    }

    @Override
    public Object getItem(int i) {
        return rssList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        }
        RSSItem tempRSSItem=(RSSItem) getItem(i);

        ImageView img = (ImageView) convertView.findViewById(R.id.wthrIcon);
        TextView tvTitle=(TextView) convertView.findViewById(R.id.titletxt);
        TextView tvDesc=(TextView) convertView.findViewById(R.id.desctxt);
        TextView tvDate=(TextView) convertView.findViewById(R.id.datetxt);


        if(tempRSSItem.getTitle().contains("Sunny")) {
            img.setBackgroundResource(R.drawable.day_clear);
        }
        else if (tempRSSItem.getTitle().contains("Rain")) {
            img.setBackgroundResource(R.drawable.day_rain);
        }

        else if (tempRSSItem.getTitle().contains("Cloud")){
            img.setBackgroundResource(R.drawable.cloudy);
        }

        else if (tempRSSItem.getTitle().contains("Thundery Showers")){
            img.setBackgroundResource(R.drawable.rain_thunder);
        }

        else if (tempRSSItem.getTitle().contains("Clear Sky")){
            img.setBackgroundResource(R.drawable.day_clear);
        }

        else if (tempRSSItem.getTitle().contains("Mist")){
            img.setBackgroundResource(R.drawable.fog);
        }

        else if (tempRSSItem.getTitle().contains("Drizzle")){
            img.setBackgroundResource(R.drawable.day_rain);
        }
        tvTitle.setText(tempRSSItem.getTitle());
        tvDesc.setText(tempRSSItem.getDesc());
        tvDate.setText(tempRSSItem.getPubDate());


        return convertView;






    }
}
