package com.example.mytasklist;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class newtask extends Fragment implements View.OnClickListener {
    private EditText itemET;
    private EditText DesTask;
    private DatePicker dateTask;
    private TimePicker timeTask;
    private Button btn;

    public newtask() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =   inflater.inflate(R.layout.fragment_newtask,container,false);

        itemET = view.findViewById(R.id.item_edit_text);
        DesTask = view.findViewById( R.id.new_task_description );
        dateTask = view.findViewById( R.id.new_task_date );
        timeTask = view.findViewById( R.id.new_task_time );
        timeTask.setIs24HourView(true);

        btn = view.findViewById(R.id.add_btn);

        btn.setOnClickListener(this);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_btn:
                if( TextUtils.isEmpty(itemET.getText()) || TextUtils.isEmpty(itemET.getText())){
                    CharSequence text = "Le champ nom ou description est vide";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText( getActivity(), text, duration );
                    toast.show();
                }else {
                    String itemEntered = itemET.getText().toString();
                    String itemDesc = DesTask.getText().toString();

                    int day = dateTask.getDayOfMonth();
                    int month = dateTask.getMonth();
                    int year = dateTask.getYear();
                    Calendar calendar_end = Calendar.getInstance();
                    calendar_end.set( year, month, day );

                    String date = String.format( "%s/%d/%d", day, month + 1, year );

                    int hour = timeTask.getHour();
                    int m = timeTask.getMinute();

                    String taskDuration = String.format( "%s h %d m", hour, m );

                    Task task = new Task( itemEntered, itemDesc, date, taskDuration );
                    Tasklist.taskList.add( task );

                    itemET.setText( "" );
                    DesTask.setText( "" );

                    CharSequence text = "Tâche ajoutée";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText( getActivity(), text, duration );
                    toast.show();
                }
                break;

            default:
                break;
        }
    }
}
