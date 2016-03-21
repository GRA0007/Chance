package benpai.chance;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void addToHistory(Boolean heads) {
        LinearLayout history = (LinearLayout) findViewById(R.id.history);
        LayoutInflater inflater = LayoutInflater.from(this);

        // Inflate layout
        TextView txt = (TextView) inflater.inflate(R.layout.coin_history, history, false);
        // Modify inflated layout
        if (heads) {
            txt.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.coin_head, 0, 0);
            txt.setText(R.string.heads);
        } else {
            txt.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.coin_tail, 0, 0);
            txt.setText(R.string.tails);
        }
        // Add the modified layout to the row
        history.addView(txt, 0);
    }

    public void coinClick(View view) {
        Random random = new Random();
        Boolean coinState = random.nextBoolean();
        TextView coinName = (TextView) findViewById(R.id.coinState);
        ImageView currentCoinImage = (ImageView) findViewById(R.id.currentCoin);
        TextView empty = (TextView) findViewById(R.id.history_empty);
        empty.setVisibility(view.GONE);

        if (coinState) {
            coinName.setText(R.string.heads);
            currentCoinImage.setImageResource(R.drawable.coin_head_large);
            addToHistory(true);
        } else {
            coinName.setText(R.string.tails);
            currentCoinImage.setImageResource(R.drawable.coin_tail_large);
            addToHistory(false);
        }
    }

    public void clearHistory(View view) {
        LinearLayout history = (LinearLayout) findViewById(R.id.history);
        TextView empty = (TextView) findViewById(R.id.history_empty);
        history.removeAllViews();
        empty.setVisibility(view.VISIBLE);
    }

    //TODO: remove history states individually when longpressed
    //TODO: toast user when single clicking history states
}
