package edu.kiet.www.epoquejudge.Adapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import edu.kiet.www.epoquejudge.R;

/**
 * Created by sooraj on 27-02-2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.view_holder> {
    List<String> eventName,type,category,venue,schedule;
         public EventsAdapter( List<String> eventName,List<String>type,List<String>category,List<String>venue,List<String>schedule){
             this.eventName=eventName;
             this.type=type;
             this.category=category;
             this.venue=venue;
             this.schedule=schedule;
         }
    public class view_holder extends RecyclerView.ViewHolder{
        TextView eventDetails;
        public view_holder(View itemView) {
            super(itemView);

            eventDetails=(TextView)itemView.findViewById(R.id.event_name);
        }
    }
    
    @Override
    public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_details_card,null);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(view_holder holder, int position) {
        holder.eventDetails.setText(eventName.get(position)+"\n"+type.get(position)+"\n"+category.get(position)+"\n"+venue.get(position)+"\n"+schedule.get(position));
    }

    @Override
    public int getItemCount() {
        return eventName.size();
    }
}
