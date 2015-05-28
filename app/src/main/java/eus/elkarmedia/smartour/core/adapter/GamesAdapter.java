package eus.elkarmedia.smartour.core.adapter;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.gms.location.LocationServices;

import java.util.List;

import eus.elkarmedia.smartour.R;
import eus.elkarmedia.smartour.core.model.Game;

/**
 * Created by lenovo on 27/05/2015.
 */
public class GamesAdapter extends BaseAdapter {

    private List<Game> gameList;
    private Location location, userLocation;
    private Context context;

    public GamesAdapter(List<Game> gameList, Context context, Location userLocation) {
        this.gameList = gameList;
        location = new Location(LocationManager.NETWORK_PROVIDER);
        this.context = context;
        this.userLocation = userLocation;
    }

    @Override
    public int getCount() {
        return gameList.size();
    }



    @Override
    public Object getItem(int position) {
        return gameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return gameList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View item = convertView;

        Game game = gameList.get(position);

        Location gameLocation = new Location("dummyprovider");
        gameLocation.setLatitude(game.getLocation().getLatitude());
        gameLocation.setLongitude(game.getLocation().getLongitude());

        if (item == null || !( item.getTag() instanceof ViewHolder)) {

            LayoutInflater mInflater = LayoutInflater.from(context);
            item = mInflater.inflate( R.layout.row_activity_games_item, null);
            // Creates a ViewHolder and store references to the two children views we want to bind data to.
            holder = new ViewHolder();
            holder.title = (TextView) item.findViewById(R.id.title);
            holder.distance = (TextView) item.findViewById(R.id.distance);
            //Save holder
            item.setTag(holder);
        }else{
            // Get the ViewHolder back
            holder = (ViewHolder) item.getTag();
        }
        Log.d("distance",String.valueOf(game.getDistance(userLocation)));
        holder.title.setText(game.getTitle());
        holder.distance.setText(context.getString(R.string.distance, game.getDistance(userLocation)));
        return item;
    }

    class ViewHolder{
        TextView title,distance;
    }

    /*public void onConnected(Bundle bundle) {
        Log.d("GoogleAPI","connected to api");
        userLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (userLocation != null) {
            Log.d("Distance",userLocation.getLatitude() + "/" + userLocation.getLongitude());
        }
    }*/


}
