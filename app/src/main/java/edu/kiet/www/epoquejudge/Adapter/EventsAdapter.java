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
import edu.kiet.www.epoquejudge.Models.EventDetailsDataPOJO;
import edu.kiet.www.epoquejudge.Models.EventDetailsPOJO;
import edu.kiet.www.epoquejudge.R;
import retrofit2.Callback;

/**
 * Created by sooraj on 27-02-2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.view_holder> {
    EventDetailsDataPOJO data;
    Context context;


    public EventsAdapter(Context context, EventDetailsDataPOJO data) {
        this.context=context;
        this.data=data;

    }

    @Override
    public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_details_card,null);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(view_holder holder, int position) {
        holder.Name.setText(data.getName().get(position));
        if(data.getType().get(position).equals("I")) {
            holder.Type.setText("Institute");
        }
        else{
            holder.Type.setText("Department");
        }

        if(data.getCategory().get(position).equals("S")) {
            holder.Category.setText("Solo");
        }
        else{
            holder.Category.setText("Group");
        }
        holder.Venue.setText(data.getVenue().get(position));
        holder.Schedule.setText(data.getDate().get(position)+" "+data.getStartTime().get(position)+" to "+data.getEndTime().get(position));


    }

    @Override
    public int getItemCount() {
        return data.getEventId().size();
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context,ParticipantsActivity.class);
                    intent.putExtra("event_id",data.getEventId().get(getAdapterPosition()));
                    intent.putExtra("category",data.getCategory().get(getAdapterPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }

}
