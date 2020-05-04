package com.example.mytasklist;

import android.content.Context;
import android.os.Bundle;

import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.mytasklist.R.id.delete_task;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tasklist extends Fragment {
    private ListView itemsList;

    private Button btn;

    private RecyclerView mRecyclerView;
    public static ArrayList<Task> taskList = new ArrayList<>();
    ArrayList<Task> arrayTask = new ArrayList<>( );
    private TaskAdapter adapter;


    public Tasklist() {
        // Required empty public constructor
    }

    public Tasklist(Task task) {
    }

    public Task addTask(Task t){
        arrayTask.add( t );
        return t;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        View view  = inflater.inflate(R.layout.fragment_tasklist, container, false);

        mRecyclerView = (RecyclerView) view.findViewById( R.id.myRecyclerView );

        adapter = new TaskAdapter(taskList);

        mRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity()) );
        mRecyclerView.setAdapter(adapter);

        return view;
    }

}
