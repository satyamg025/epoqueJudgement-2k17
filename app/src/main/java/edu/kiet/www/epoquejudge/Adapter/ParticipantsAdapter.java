package edu.kiet.www.epoquejudge.Adapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import edu.kiet.www.epoquejudge.Activity.EventJudgement;
import edu.kiet.www.epoquejudge.R;

/**
 * Created by sooraj on 27-02-2017.
 */

public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.view_holder> {
    List<String> eventName=new ArrayList<>(),participants_group=new ArrayList<>(),participants_solo=new ArrayList<>();
    Context context;
    public ParticipantsAdapter(Context context,List<String>eventName, List<String>participants_group, List<String>participants_solo){
        this.eventName=eventName;
        this.context=context;
        this.participants_group=participants_group;
        this.participants_solo=participants_solo;
    }

    @Override
    public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_participants_group_card,null);
        View view2=LayoutInflater.from(parent.getContext()).inflate(R.layout.event_participants_solo_card,null);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(view_holder holder, int position) {
        holder.teamName.setText(eventName.get(position));
        holder.participants_group.setText(participants_group.get(position));
        holder.participants_solo.setText(participants_solo.get(position));
    }

    @Override
    public int getItemCount() {
        return eventName.size();
    }
    public class view_holder extends RecyclerView.ViewHolder{
        TextView teamName,participants_group,participants_solo;
        AppCompatButton give_judgement_group,give_judgement_solo;
        public view_holder(View itemView) {
            super(itemView);
            teamName=(TextView)itemView.findViewById(R.id.teamname);
            participants_group=(TextView)itemView.findViewById(R.id.participants_group);
           participants_solo=(TextView)itemView.findViewById(R.id.participants_solo);
            give_judgement_group=(AppCompatButton)itemView.findViewById(R.id.give_judgement_group);
            give_judgement_group.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,EventJudgement.class);
                    context.startActivity(intent);
                }
            });
            give_judgement_solo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,EventJudgement.class);
                    context.startActivity(intent);
                }
            });

        }
    }

}
