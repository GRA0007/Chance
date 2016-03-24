package benpai.chance;

import android.content.Intent;
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

public class Dice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void addToHistory(int side) {
        LinearLayout history = (LinearLayout) findViewById(R.id.history);
        LayoutInflater inflater = LayoutInflater.from(this);

        // Inflate layout
        TextView txt = (TextView) inflater.inflate(R.layout.dice_history, history, false);
        // Modify inflated layout
        switch (side) {
            case 1:
                txt.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.dice_1, 0, 0);
                txt.setText(R.string.one);
                break;
            case 2:
                txt.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.dice_2, 0, 0);
                txt.setText(R.string.two);
                break;
            case 3:
                txt.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.dice_3, 0, 0);
                txt.setText(R.string.three);
                break;
            case 4:
                txt.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.dice_4, 0, 0);
                txt.setText(R.string.four);
                break;
            case 5:
                txt.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.dice_5, 0, 0);
                txt.setText(R.string.five);
                break;
            case 6:
                txt.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.dice_6, 0, 0);
                txt.setText(R.string.six);
                break;
            default:
                txt.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.dice_unknown, 0, 0);
                txt.setText("?");
                break;
        }
        // Add the modified layout to the row
        history.addView(txt, 0);
    }

    public void diceClick(View view) {
        Random random = new Random();
        int diceFace = random.nextInt(6) + 1;
        TextView diceName = (TextView) findViewById(R.id.diceFace);
        ImageView currentDiceImage = (ImageView) findViewById(R.id.currentDice);
        TextView empty = (TextView) findViewById(R.id.history_empty);
        empty.setVisibility(view.GONE);

        switch (diceFace) {
            case 1:
                diceName.setText(R.string.one);
                currentDiceImage.setImageResource(R.drawable.dice_1_large);
                break;
            case 2:
                diceName.setText(R.string.two);
                currentDiceImage.setImageResource(R.drawable.dice_2_large);
                break;
            case 3:
                diceName.setText(R.string.three);
                currentDiceImage.setImageResource(R.drawable.dice_3_large);
                break;
            case 4:
                diceName.setText(R.string.four);
                currentDiceImage.setImageResource(R.drawable.dice_4_large);
                break;
            case 5:
                diceName.setText(R.string.five);
                currentDiceImage.setImageResource(R.drawable.dice_5_large);
                break;
            case 6:
                diceName.setText(R.string.six);
                currentDiceImage.setImageResource(R.drawable.dice_6_large);
                break;
        }
        addToHistory(diceFace);
    }

    public void clearHistory(View view) {
        LinearLayout history = (LinearLayout) findViewById(R.id.history);
        TextView empty = (TextView) findViewById(R.id.history_empty);
        history.removeAllViews();
        empty.setVisibility(view.VISIBLE);
    }

    //TODO: remove history states individually when longpressed

    public void notifyLongClick(View view) {
        Toast.makeText(this, R.string.long_press_to_remove, Toast.LENGTH_SHORT).show();
    }

    //Testing only
    public void intGen(View view) {
        Intent intent = new Intent(this, Integer.class);
        startActivity(intent);
    }
}
