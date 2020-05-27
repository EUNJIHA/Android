package com.example.test;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// Data 검색, View 생성 후 연결
public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> listViewItems = new ArrayList<ListViewItem>();

    @Override
    public int getCount() {
        return listViewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Context context = parent.getContext();

        if (convertView == null) {

            // LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        ImageView itemProfile = (ImageView) convertView.findViewById(R.id.item_profile);
        TextView itemTitle = (TextView) convertView.findViewById(R.id.item_title);
        TextView itemContent = (TextView) convertView.findViewById(R.id.item_content);
        TextView itemTime = (TextView) convertView.findViewById(R.id.item_time);

        ListViewItem listViewItem = listViewItems.get(position);

        itemProfile.setImageDrawable(listViewItem.getRoom_profile());
        itemTitle.setText(listViewItem.getRoom_title());
        itemContent.setText(listViewItem.getRoom_content());
        itemTime.setText(listViewItem.getRoom_time());

        return convertView;
    }

    public void addItem(Drawable profile, String title, String content, String time){
        ListViewItem item = new ListViewItem();

        item.setRoom_profile(profile);
        item.setRoom_title(title);
        item.setRoom_content(content);
        item.setRoom_time(time);

        listViewItems.add(item);
    }
}
