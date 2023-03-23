package com.example.orbellion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //note: to add more energy if needed you also need to update the p1 and p2

    boolean currentP1 = true;
    int gameMaxEnergy = 10;

    int[] p1Energy = {R.id.p1energy1, R.id.p1energy2,R.id.p1energy3,R.id.p1energy4,R.id.p1energy5,R.id.p1energy6,R.id.p1energy7,R.id.p1energy8,R.id.p1energy9,R.id.p1energy10};
    int p1MaxEnergyBar = R.id.p1maxEnergyBar;
    int[] p2Energy = {R.id.p2energy1, R.id.p2energy2,R.id.p2energy3,R.id.p2energy4,R.id.p2energy5,R.id.p2energy6,R.id.p2energy7,R.id.p2energy8,R.id.p2energy9,R.id.p2energy10};
    int p2MaxEnergyBar = R.id.p2maxEnergyBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player p1 = new player(1,6,1,p1Energy,p1MaxEnergyBar,this);
        player p2 = new player(1,6,1,p2Energy,p2MaxEnergyBar,this);





        Button turn = findViewById(R.id.turn);
        turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p1.getCurrentEnergy() < gameMaxEnergy && currentP1) {
                    p1.updateCurrentMaxEnergy(1);
                    p1.setPlayerCurrentMaxEnergyBar();
                    p1.setCurrentEnergy(p1.getCurrentMaxEnergy());
                    p1.setPlayerEnergyBar();
                }

                if(p2.getCurrentEnergy() < gameMaxEnergy && !currentP1) {
                    p2.updateCurrentMaxEnergy(1);
                    p2.setPlayerCurrentMaxEnergyBar();
                    p2.setCurrentEnergy(p2.getCurrentMaxEnergy());
                    p2.setPlayerEnergyBar();
                }

                currentP1 = !currentP1;
            }
        });

        Button p1add = findViewById(R.id.p2add);
        p1add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.updateCurrentEnergy(1);
                p1.setPlayerEnergyBar();
            }
        });

        Button p1sub = findViewById(R.id.p1sub);
        p1sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.updateCurrentEnergy(-1);
                p1.setPlayerEnergyBar();
            }
        });

        Button p2add = findViewById(R.id.p2add);
        p2add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2.updateCurrentEnergy(1);
                p2.setPlayerEnergyBar();
            }
        });

        Button p2sub = findViewById(R.id.p2sub);
        p2sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2.updateCurrentEnergy(-1);
                p2.setPlayerEnergyBar();
            }
        });

    }
}