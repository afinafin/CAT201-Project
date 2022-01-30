package com.example.cat201try2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class WatchVideo extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<DataSetList> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_video);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        arrayList = new ArrayList<DataSetList>();

        DataSetList dataSetList = new DataSetList("https://www.youtube.com/watch?v=a2euhiUQDZ4&t=17s");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("https://www.youtube.com/watch?v=XGtjACeyHtc&t=11s");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("https://youtu.be/m1JaqlFKBYo?list=PLiQyPKgbtKzeN6_BM1TjQ-M42J4AW990b&t=15s");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("https://youtu.be/Gv2bTcFOSDs?list=PLiQyPKgbtKzeN6_BM1TjQ-M42J4AW990b&t=14s");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("https://youtu.be/LAJFMRAo5OE?list=PLiQyPKgbtKzeN6_BM1TjQ-M42J4AW990b&t=17");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("https://youtu.be/K7BIRWl2f54?list=PLiQyPKgbtKzeN6_BM1TjQ-M42J4AW990b&t=16");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("https://youtu.be/cYQ7SPSyD_g?list=PLiQyPKgbtKzeN6_BM1TjQ-M42J4AW990b&t=15");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("https://youtu.be/pPStsSCaeOY?list=PLiQyPKgbtKzeN6_BM1TjQ-M42J4AW990b&t=14");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("https://youtu.be/qQzCrk3SizU?list=PLiQyPKgbtKzeN6_BM1TjQ-M42J4AW990b&t=17");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("https://youtu.be/YfeW_FLGA3c?list=PLiQyPKgbtKzeN6_BM1TjQ-M42J4AW990b&t=15");
        arrayList.add(dataSetList);
        dataSetList = new DataSetList("https://youtu.be/fJ3omuDAnz8?list=PLiQyPKgbtKzeN6_BM1TjQ-M42J4AW990b&t=17");
        arrayList.add(dataSetList);

        YoutubeAdapter youtubeAdapter = new YoutubeAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(youtubeAdapter);

    }
}
