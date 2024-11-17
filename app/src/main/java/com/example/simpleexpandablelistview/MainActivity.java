package com.example.simpleexpandablelistview;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandableListView);

        // Data for the ExpandableListView
        List<String> groupList = new ArrayList<>();
        List<List<String>> childList = new ArrayList<>();

        // Groups
        groupList.add("Fruits");
        groupList.add("Vegetables");
        groupList.add("Dairy");

        // Children
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        List<String> vegetables = new ArrayList<>();
        vegetables.add("Carrot");
        vegetables.add("Broccoli");
        vegetables.add("Spinach");

        List<String> dairy = new ArrayList<>();
        dairy.add("Milk");
        dairy.add("Cheese");
        dairy.add("Yogurt");

        childList.add(fruits);
        childList.add(vegetables);
        childList.add(dairy);

        // Adapter setup
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                createGroupList(groupList), // Group data
                android.R.layout.simple_expandable_list_item_1, // Group layout
                new String[]{"GroupName"}, // Group key
                new int[]{android.R.id.text1}, // Group text view
                createChildList(childList), // Child data
                android.R.layout.simple_list_item_1, // Child layout
                new String[]{"ChildName"}, // Child key
                new int[]{android.R.id.text1} // Child text view
        );

        expandableListView.setAdapter(adapter);
    }

    private List<HashMap<String, String>> createGroupList(List<String> groupList) {
        List<HashMap<String, String>> groupData = new ArrayList<>();
        for (String group : groupList) {
            HashMap<String, String> groupMap = new HashMap<>();
            groupMap.put("GroupName", group);
            groupData.add(groupMap);
        }
        return groupData;
    }

    private List<List<HashMap<String, String>>> createChildList(List<List<String>> childList) {
        List<List<HashMap<String, String>>> childData = new ArrayList<>();
        for (List<String> groupChildren : childList) {
            List<HashMap<String, String>> childGroup = new ArrayList<>();
            for (String child : groupChildren) {
                HashMap<String, String> childMap = new HashMap<>();
                childMap.put("ChildName", child);
                childGroup.add(childMap);
            }
            childData.add(childGroup);
        }
        return childData;
    }
}
