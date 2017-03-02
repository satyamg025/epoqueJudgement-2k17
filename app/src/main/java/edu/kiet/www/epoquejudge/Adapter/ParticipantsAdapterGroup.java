package edu.kiet.www.epoquejudge.Adapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
      //  String team_members[]=team_mem.split(",");
        //for(int i=0;i<data.getName().get(position).size();i++){
          //  members=members+data.getName().get(position).get(i)+" ("+team_members[i]+")";
            //members=members+"\n";

        //}
        holder.participants_group.setText(data.getName().get(position)+"\n( "+data.getTeamLeader().get(position)+" )");
        if(!data.getalready_judgement().isEmpty()) {
            Log.e("inside group","inside");

            if (data.getalready_judgement().contains(data.getGid().get(position))) {
                Log.e("Inside", "inside");
                holder.give_judgement_group.setText("Judgement Done");
                holder.give_judgement_group.setEnabled(false);
            }
        }

    }

    @Override
    public int getItemCount() {
        return data.getTeamName().size();
    }
    public class view_holder extends RecyclerView.ViewHolder{
        TextView teamName,participants_group;
        AppCompatButton give_judgement_group;
        public view_holder(final View itemView) {
            super(itemView);
            teamName=(TextView)itemView.findViewById(R.id.teamname);
            participants_group=(TextView)itemView.findViewById(R.id.participants_group);
            give_judgement_group=(AppCompatButton)itemView.findViewById(R.id.give_judgement_group);

            give_judgement_group.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,EventJudgement.class);
                    Bundle bundle=new Bundle();
                    Log.e("position",Integer.toString(getAdapterPosition()));
                    bundle.putString("event_id",data.getEventId().get(getAdapterPosition()));
                    bundle.putString("id",data.getGid().get(getAdapterPosition()));
                    bundle.putString("type","G");
                    bundle.putStringArray("max",data.getMax().toArray(new String[data.getMax().size()]));
                    bundle.putStringArray("min",data.getMin().toArray(new String[data.getMin().size()]));
                    bundle.putStringArray("attr_id",data.getAttrId().toArray(new String[data.getAttrId().size()]));
                   // Log.e("attr_id",String.valueOf((String[])data.getAttrId().toArray()));
                    bundle.putStringArray("attr",data.getAttributes().toArray(new String[data.getAttributes().size()]));
                    intent.putExtras(bundle);
                    itemView.getContext().startActivity(intent);
                    ((Activity)context).finish();

                }
            });

        }
    }

}
