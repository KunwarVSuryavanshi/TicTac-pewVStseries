package com.example.kunwarviraj.tic_tac_toe;

import android.content.Intent;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int activeplayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameIsActive = true;
    public void drawIn(View view) {
        ImageView counter = (ImageView) view;

        int tap = Integer.parseInt(counter.getTag().toString());

        if (gameState[tap] == 2 && gameIsActive) {
            gameState[tap] = activeplayer;
            counter.setTranslationY(-1000f);

            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.pew);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.tser);
                activeplayer = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(1000);
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    System.out.println(gameState[winningPosition[0]]);

                    String winner = new String("NO ONE IS THE WINNER U MUTHAFUCKER");

                    if (gameState[winningPosition[0]] == 1) {
                        winner = "T-Series has WON!!Subscribe to T-Series!";
                    }
                    else if(gameState[winningPosition[0]] == 0){
                        winner = "PewDiePie has WON!!! Subscribe to PewDiePie!";
                    }
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner);

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                }
            }
        }
    }
        public void playAgain (View view){
            LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
            layout.setVisibility(View.INVISIBLE);
            activeplayer = 0;
            for(int i=0;i<gameState.length;i++)
            {
                gameState[i]=2;
            }
            GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
            for (int i = 0; i < gridLayout.getChildCount(); i++) {
                ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
            }
        }
    }