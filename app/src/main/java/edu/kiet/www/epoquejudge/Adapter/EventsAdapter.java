package edu.kiet.www.epoquejudge.Adapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.List;
import edu.kiet.www.epoquejudge.Activity.EventJudgement;
import edu.kiet.www.epoquejudge.Activity.ParticipantsActivity;
import edu.kiet.www.epoquejudge.R;

/**
 * Created by sooraj on 27-02-2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.view_holder> {
    List<String> eventName,type,category,venue,schedule;
    Context context;
         public EventsAdapter(Context context,List<String> eventName, List<String>type, List<String>category, List<String>venue, List<String>schedule){
             this.eventName=eventName;
             this.type=type;
             this.category=category;
             this.venue=venue;
             this.schedule=schedule;
             this.context=context;
         }

    @Override
    public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_details_card,null);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(view_holder holder, int position) {
        holder.Name.setText(eventName.get(position));
        holder.Type.setText(type.get(position));
        holder.Category.setText(category.get(position));
        holder.Venue.setText(venue.get(position));
        holder.Schedule.setText(schedule.get(position));
    }

    @Override
    public int getItemCount() {
        return eventName.size();
    }
    public class view_holder extends RecyclerView.ViewHolder{
        CardView eventCard;
        TextView Name,Type,Category,Venue,Schedule;
        ImageView eventPhoto;
        public view_holder(View itemView) {
            super(itemView);
            eventCard=(CardView)itemView.findViewById(R.id.event_card);
            Name=(TextView)itemView.findViewById(R.id.event_name);
            Type=(TextView)itemView.findViewById(R.id.type);
            Category=(TextView)itemView.findViewById(R.id.category);
            Venue=(TextView)itemView.findViewById(R.id.venue);
            Schedule=(TextView)itemView.findViewById(R.id.schedule);
            eventPhoto=(ImageView)itemView.findViewById(R.id.event_photo);
            eventCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,ParticipantsActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

}
