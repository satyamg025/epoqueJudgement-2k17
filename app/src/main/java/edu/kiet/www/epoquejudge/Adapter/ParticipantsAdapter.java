package edu.kiet.www.epoquejudge.Adapter;
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
import edu.kiet.www.epoquejudge.Models.GetSoloTeamsPOJO;
import edu.kiet.www.epoquejudge.R;

/**
 * Created by sooraj on 27-02-2017.
 */

public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.view_holder> {
    Context context;
    GetSoloTeamsPOJO data;

    public ParticipantsAdapter(Context applicationContext, GetSoloTeamsPOJO body) {
        this.context=applicationContext;
        this.data=body;
    }

    @Override
    public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.event_participants_solo_card,null);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(view_holder holder, int position) {
        holder.participants_solo.setText(data.getName().get(position));
    }

    @Override
    public int getItemCount() {
        return data.getName().size();
    }
    public class view_holder extends RecyclerView.ViewHolder{
        TextView teamName,participants_solo;
        AppCompatButton give_judgement_solo;
        public view_holder(final View itemView) {
            super(itemView);
            teamName=(TextView)itemView.findViewById(R.id.teamname);
           participants_solo=(TextView)itemView.findViewById(R.id.participants_solo);
            give_judgement_solo=(AppCompatButton)itemView.findViewById(R.id.give_judgement_solo);
            give_judgement_solo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle=new Bundle();
                    Intent intent=new Intent(context,EventJudgement.class);
                    bundle.putString("event_id",data.getEventId().get(getAdapterPosition()));
                    bundle.putString("id",data.getLibCardNo().get(getAdapterPosition()));
                    bundle.putString("type","S");
                    bundle.putStringArray("max",data.getMax().toArray(new String[data.getMax().size()]));
                    bundle.putStringArray("min",data.getMin().toArray(new String[data.getMin().size()]));
                    bundle.putStringArray("attr_id",data.getAttrId().toArray(new String[data.getAttrId().size()]));
                   // Log.e("attr_id",String.valueOf((String[])data.getAttrId().toArray()));
                    bundle.putStringArray("attr",data.getAttributes().toArray(new String[data.getAttributes().size()]));

                    intent.putExtras(bundle);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }

}
