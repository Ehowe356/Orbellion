package com.example.orbellion;


import android.app.Activity;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;



/* currentMaxEnergy: the amount of energy the player gains at the start of their turn
   currentMaxEnergyBar:the bar that shows the max energy a user can have currently
   maxEnergy: the upper limit of energy the player can have during the game
   currentEnergy: the amount of energy the player can use during their turn
   playerEnergyBar: an array of all the orbs on the screen that show useable energy
   ex: at the start of the game the maxEnergy is set to 6, the currentMaxEnergy is set to 1, and currentEnergy is set to 1,
       if a card with an energy cost of 1 is played then the currentEnergy is set to 0 they end their turn
       when its their turn again their currentMaxEnergy is set to 2, the currentEnergy is set to 2, the maxEnergy remains 6
       when it becomes a players turn and their currentMAxEnergy is 6 then it does not go up
       when the first helion is killed maxEnergy is set to 8
       when the second helion is killed maxEnergy is set to 10

*/
public class player extends AppCompatActivity{
    private int currentMaxEnergy;
    private int currentMaxEnergyBar;
    private int maxEnergy;
    private int currentEnergy;

    private int[] playerEnergyBar;


    private Activity mActivity;
    public player(int currentMaxEnergy, int maxEnergy, int currentEnergy, int[] playerEnergyBar,int currentMaxEnergyBar, Activity mActivity){
        this.currentMaxEnergy = currentMaxEnergy;
        this.maxEnergy = maxEnergy;
        this.playerEnergyBar = playerEnergyBar;
        this.currentMaxEnergyBar = currentMaxEnergyBar;
        this.currentEnergy = currentEnergy;
        this.mActivity = mActivity;
    }

    public int getCurrentMaxEnergy(){
        return this.currentMaxEnergy;
    }

    public void updateCurrentMaxEnergy(int n){
        if(this.currentMaxEnergy < this.maxEnergy)
            this.currentMaxEnergy += n;
    }
    public int getCurrentEnergy(){
        return this.currentEnergy;
    }

    public void setCurrentEnergy(int n){
        if(currentEnergy < currentMaxEnergy)
            this.currentEnergy = n;
    }

    public void updateCurrentEnergy(int n){
        if(getCurrentEnergy() + n <= getCurrentMaxEnergy() && getCurrentEnergy() +n >=0){
            this.currentEnergy += n;
        }
    }

    public void setPlayerEnergyBar(){
        for(int i=1;i<= currentEnergy;i++){
            ImageView energy = mActivity.findViewById(playerEnergyBar[i-1]);
            energy.setImageResource(R.drawable.energyfilled);
        }

        for(int i=currentEnergy+1;i<= currentMaxEnergy+1;i++){
            ImageView energy = mActivity.findViewById(playerEnergyBar[i-1]);
            energy.setImageResource(R.drawable.eneryempty);
        }
    }

    public void setPlayerCurrentMaxEnergyBar(){
        ImageView currentMaxEnergyBarIM = mActivity.findViewById(this.currentMaxEnergyBar);
        currentMaxEnergyBarIM.requestLayout();
        currentMaxEnergyBarIM.getLayoutParams().width = 105 * currentMaxEnergy;
    }


}
