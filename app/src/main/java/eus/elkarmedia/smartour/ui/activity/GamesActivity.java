package eus.elkarmedia.smartour.ui.activity;

import android.app.ListActivity;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import eus.elkarmedia.smartour.R;
import eus.elkarmedia.smartour.core.adapter.GamesAdapter;
import eus.elkarmedia.smartour.core.model.Game;
import eus.elkarmedia.smartour.core.model.Geolocation;

public class GamesActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get location from intent
        double lat = getIntent().getExtras().getDouble(Geolocation.EXTRA_LATITUDE);
        double lon = getIntent().getExtras().getDouble(Geolocation.EXTRA_LONGITUDE);
        double alt = getIntent().getExtras().getDouble(Geolocation.EXTRA_ALTITUDE);
        Location userLocation = new Location("dummyprovider");
        userLocation.setLatitude(lat);
        userLocation.setLongitude(lon);
        userLocation.setAltitude(alt);

        setContentView(R.layout.activity_games);

       // getActionBar().setTitle(R.string.app_name);
        List<Game> gameList = getGameList();
        setListAdapter(new GamesAdapter(gameList, this, userLocation));
    }

    private List<Game> getGameList() {
        List<Game> gameList = new ArrayList<Game>();
        Game game = new Game();
        game.setId(1L);
        game.setTitle("Azkoitia turismo");
        game.setLocation(43.178804, -2.308105);
        gameList.add(game);

        game = new Game();
        game.setId(2L);
        game.setTitle("Gaztaren ibilbidea");
        game.setLocation(43.012068, -2.234559);
        gameList.add(game);

        game = new Game();
        game.setId(3L);
        game.setTitle("Urola Garaia");
        game.setLocation(43.035392, -2.338753);
        gameList.add(game);
        return gameList;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_games, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
