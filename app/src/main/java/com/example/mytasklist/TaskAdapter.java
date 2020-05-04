package com.example.mytasklist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.mytasklist.R.id.delete_task;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {
    private ArrayList<Task> taskList;
    private static int pos;

    public TaskAdapter(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from( parent.getContext() );
        View view = layoutInflater.inflate( R.layout.task_item, parent, false );

        return new MyViewHolder( view );

    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.MyViewHolder holder, int position) {
        pos = position;
        holder.display( taskList.get( position ) );
    }

    @Override
    public int getItemCount() {
        return this.taskList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitle;
        private TextView mDescription;
        private TextView mDate;
        private TextView mDuration;
        private Button btn;

        private ArrayList<Task> taskList;

        private MyViewHolder(View itemView) {
            super( itemView );

            mTitle = (TextView) itemView.findViewById( R.id.title );
            mDescription = (TextView) itemView.findViewById( R.id.description );
            mDate = (TextView) itemView.findViewById( R.id.date_task );
            mDuration = (TextView) itemView.findViewById( R.id.duration_task );

            btn = itemView.findViewById( delete_task );
            btn.setOnClickListener( this );

        }

        void display(Task task) {
            mTitle.setText( task.getTitle() );
            mDescription.setText( task.getDescription() );
            mDate.setText( task.getDate() );
            mDuration.setText( "Durée : " + task.getDuration() );
        }

        @Override
       public void onClick(View v) {
           Log.w( "position remove", String.valueOf( pos ) );
            Tasklist.taskList.remove( pos );
            notifyDataSetChanged();
            Context context = itemView.getContext();
            CharSequence text = "Tâche supprimée !";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText( context, text, duration );
            toast.show();
        }
    }
}
