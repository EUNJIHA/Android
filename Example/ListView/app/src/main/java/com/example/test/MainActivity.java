package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ListViewAdapter();

        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile1), "2020 MakeUs", "사진을 보냈습니다.", "5월 23일");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile2), "2020-1 비전인사이드 인턴", "ㅋㅋㅋ임티 찰떡", "오후 4:09");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile3), "[2020-1] 은지다영순", "https://youtu.be/_55EKqSagM8", "5월 23일");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile4), "[2020-1] 청년54교구 리더방", "여기로 오심 되어요", "5월 23일");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile5), "💙우리가족💙", "이모티콘을 보냈습니다.", "5월 19일");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile1), "2020 MakeUs", "사진을 보냈습니다.", "5월 23일");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile2), "2020-1 비전인사이드 인턴", "ㅋㅋㅋ임티 찰떡", "오후 4:09");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile3), "[2020-1] 은지다영순", "https://youtu.be/_55EKqSagM8", "5월 23일");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile4), "[2020-1] 청년54교구 리더방", "여기로 오심 되어요", "5월 23일");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile5), "💙우리가족💙", "이모티콘을 보냈습니다.", "5월 19일");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile1), "2020 MakeUs", "사진을 보냈습니다.", "5월 23일");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile2), "2020-1 비전인사이드 인턴", "ㅋㅋㅋ임티 찰떡", "오후 4:09");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile3), "[2020-1] 은지다영순", "https://youtu.be/_55EKqSagM8", "5월 23일");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile4), "[2020-1] 청년54교구 리더방", "여기로 오심 되어요", "5월 23일");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile5), "💙우리가족💙", "이모티콘을 보냈습니다.", "5월 19일");
    }
}
