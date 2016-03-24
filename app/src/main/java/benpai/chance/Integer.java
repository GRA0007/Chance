package benpai.chance;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Integer extends AppCompatActivity {

    boolean notBlankBefore = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void addToHistory(int number) {
        LinearLayout history = (LinearLayout) findViewById(R.id.history);
        LayoutInflater inflater = LayoutInflater.from(this);

        // Inflate layout
        TextView txt = (TextView) inflater.inflate(R.layout.int_history, history, false);
        View divider = inflater.inflate(R.layout.int_history_divider, history, false);
        // Modify inflated layout
        txt.setText(String.valueOf(number));
        // Add the modified layout to the row
        if (notBlankBefore) {
            history.addView(divider, 0);
        }
        history.addView(txt, 0);
        notBlankBefore = true;
    }

    //TODO: Allow user to select min and max values
    public void numberClick(View view) {
        Random random = new Random();
        int max = 100;
        int min = 1;
        int number = random.nextInt((max - min) + 1) + min;
        TextView currentInteger = (TextView) findViewById(R.id.currentInt);
        TextView empty = (TextView) findViewById(R.id.history_empty);
        TextView hint = (TextView) findViewById(R.id.int_help);
        empty.setVisibility(view.GONE);
        hint.setVisibility(view.GONE);
        currentInteger.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

        currentInteger.setText(String.valueOf(number));
        addToHistory(number);
    }

    public void clearHistory(View view) {
        LinearLayout history = (LinearLayout) findViewById(R.id.history);
        TextView empty = (TextView) findViewById(R.id.history_empty);
        history.removeAllViews();
        empty.setVisibility(view.VISIBLE);
        notBlankBefore = false;
    }

    //TODO: remove history states individually when longpressed

    public void notifyLongClick(View view) {
        Toast.makeText(this, R.string.long_press_to_remove, Toast.LENGTH_SHORT).show();
    }
}
