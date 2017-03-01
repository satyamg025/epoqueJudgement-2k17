package edu.kiet.www.epoquejudge.Adapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.kiet.www.epoquejudge.Activity.EventJudgement;
import edu.kiet.www.epoquejudge.Models.GetGroupTeamsPOJO;
import edu.kiet.www.epoquejudge.R;

/**
 * Created by sooraj on 27-02-2017.
 */

public class ParticipantsAdapterGroup extends RecyclerView.Adapter<ParticipantsAdapterGroup.view_holder> {
    Context context;
    GetGroupTeamsPOJO data;

    public ParticipantsAdapterGroup(Context applicationContext, GetGroupTeamsPOJO body) {
        this.context=applicationContext;
        this.data=body;
    }

    @Override
    public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_participants_group_card,null);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(view_holder holder, int position) {

        holder.teamName.setText(data.getTeamName().get(position));
        String members="";
        String team_mem=data.getTeamMember().get(position);
        String team_members[]=team_mem.split(",");
        for(int i=0;i<data.getName().get(position).size();i++){
            members=members+data.getName().get(position).get(i)+" ("+team_members[i]+")";
            members=members+"\n";

        }
        holder.participants_group.setText(members);

    }

    @Override
    public int getItemCount() {
        return data.getTeamName().size();
    }
    public class view_holder extends RecyclerView.ViewHolder{
        TextView teamName,participants_group;
        AppCompatButton give_judgement_group;
        public view_holder(View itemView) {
            super(itemView);
            teamName=(TextView)itemView.findViewById(R.id.teamname);
            participants_group=(TextView)itemView.findViewById(R.id.participants_group);
            give_judgement_group=(AppCompatButton)itemView.findViewById(R.id.give_judgement_group);
            give_judgement_group.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,EventJudgement.class);
                    context.startActivity(intent);
                }
            });

        }
    }

}
