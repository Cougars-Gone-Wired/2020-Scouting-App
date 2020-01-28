package com.example.infiniterechargescouting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    //Auto Array Variables
    public static String scoutName = "";
    public static String teamNum = "";
    public static String matchNum = "";
    public static String autoInnerGoalText = "";
    public static String autoOuterGoalText = "";
    public static String crossedBaseline;
    public static String autoLowGoalText = "";
    public static int autoInnerGoalNum = 0;
    public static int autoOuterGoalNum = 0;
    public static int autoLowGoalNum = 0;

    //Teleop Array Variables
    public static String teleInnerGoalText;
    public static int teleInnerGoalNum;
    public static String teleOuterGoalText;
    public static int teleOuterGoalNum;
    public static String teleLowGoalText;
    public static int teleLowGoalNum;
    public static String controlPanelSpin;
    public static String controlPanelColor;

    //Endgame Array Variables
    public static String climb;
    public static String breakdown;
    public static String isBalanced;
    public static String comments = "";

    //All data array
    public static String[] all_data_array = new String[16];




    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem CoverTab, AutoTab, TeleopTab, EndgameTab;
    public PagerAdapter PageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        CoverTab = (TabItem) findViewById((R.id.TabOne));
        AutoTab = (TabItem) findViewById((R.id.TabTwo));
        TeleopTab = (TabItem) findViewById((R.id.TabThree));
        EndgameTab = (TabItem) findViewById((R.id.TabFour));
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        PageAdapter = new com.example.infiniterechargescouting.PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(PageAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    PageAdapter.notifyDataSetChanged();
                }
                else if (tab.getPosition() == 1) {
                    PageAdapter.notifyDataSetChanged();
                }
                else if (tab.getPosition() == 2) {
                    PageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }


    public void autoInnerGoalMinusButton(View view) {
        TextView autoScore1TV = findViewById(R.id.autoInnerGoalScoreTextView);

        if (autoInnerGoalNum > 0) {
            autoInnerGoalNum--;
            autoInnerGoalText = String.valueOf(autoInnerGoalNum);
            autoScore1TV.setText(autoInnerGoalText);
        }
    }

    public void autoInnerGoalPlusButton(View view){
        TextView autoScore1TV = findViewById(R.id.autoInnerGoalScoreTextView);
        autoInnerGoalNum++;
        autoInnerGoalText = String.valueOf(autoInnerGoalNum);
        autoScore1TV.setText(autoInnerGoalText);
    }

    public void autoOuterGoalMinusButton(View view) {
        TextView autoScore2TV = findViewById(R.id.autoOuterGoalScoreTextView);
        if (autoOuterGoalNum > 0) {
            autoOuterGoalNum--;
            autoOuterGoalText = String.valueOf(autoOuterGoalNum);
            autoScore2TV.setText(autoOuterGoalText);
        }
    }

    public void autoOuterGoalPlusButton(View view) {
        TextView autoScore2TV = findViewById(R.id.autoOuterGoalScoreTextView);
        autoOuterGoalNum++;
        autoOuterGoalText = String.valueOf(autoOuterGoalNum);
        autoScore2TV.setText(autoOuterGoalText);
    }

    public void autoLowGoalMinusButton(View view) {
        TextView autoScore2TV = findViewById(R.id.autoLowGoalScoreTextView);
        if (autoLowGoalNum > 0) {
            autoLowGoalNum--;
            autoLowGoalText = String.valueOf(autoLowGoalNum);
            autoScore2TV.setText(autoLowGoalText);
        }
    }

    public void autoLowGoalPlusButton(View view){
        TextView autoScore2TV = findViewById(R.id.autoLowGoalScoreTextView);
        autoLowGoalNum++;
        autoLowGoalText = String.valueOf(autoLowGoalNum);
        autoScore2TV.setText(autoLowGoalText);
    }

    public void teleInnerGoalMinusButton(View view) {
        TextView teleScore1TV = findViewById(R.id.teleInnerGoalScoreTextView);
        if (teleInnerGoalNum > 0) {
            teleInnerGoalNum--;
            teleInnerGoalText = String.valueOf(teleInnerGoalNum);
            teleScore1TV.setText(teleInnerGoalText);
        }
    }

    public void teleInnerGoalPlusButton(View view) {
        TextView teleScore1TV = findViewById(R.id.teleInnerGoalScoreTextView);
        teleInnerGoalNum++;
        teleInnerGoalText = String.valueOf(teleInnerGoalNum);
        teleScore1TV.setText(teleInnerGoalText);
    }

    public void teleOuterGoalMinusButton(View view) {
        TextView teleScore2TV = findViewById(R.id.teleOuterGoalScoreTextView);
        if (teleOuterGoalNum > 0) {
            teleOuterGoalNum--;
            teleOuterGoalText = String.valueOf(teleOuterGoalNum);
            teleScore2TV.setText(teleOuterGoalText);
        }
    }

    public void teleOuterGoalPlusButton(View view) {
        TextView teleScore2TV = findViewById(R.id.teleOuterGoalScoreTextView);
        teleOuterGoalNum++;
        teleOuterGoalText = String.valueOf(teleOuterGoalNum);
        teleScore2TV.setText(teleOuterGoalText);
    }

    public void teleLowGoalMinusButton(View view) {
        TextView teleScore3TV = findViewById(R.id.teleLowGoalScoreTextView);
        if (teleLowGoalNum > 0) {
            teleLowGoalNum--;
            teleLowGoalText = String.valueOf(teleLowGoalNum);
            teleScore3TV.setText(teleLowGoalText);
        }
    }

    public void teleLowGoalPlusButton(View view) {
        TextView teleScore3TV = findViewById(R.id.teleLowGoalScoreTextView);
        teleLowGoalNum++;
        teleLowGoalText = String.valueOf(teleLowGoalNum);
        teleScore3TV.setText(teleLowGoalText);
    }


    //Set all data array
    public static void setDataArray() {
        all_data_array[0] = scoutName;
        all_data_array[1] = teamNum;
        all_data_array[2] = matchNum;
        all_data_array[3] = crossedBaseline;
        all_data_array[4] = autoInnerGoalText;
        all_data_array[5] = autoOuterGoalText;
        all_data_array[6] = autoLowGoalText;
        all_data_array[7] = teleInnerGoalText;
        all_data_array[8] = teleOuterGoalText;
        all_data_array[9] = teleLowGoalText;
        all_data_array[10] = controlPanelSpin;
        all_data_array[11] = controlPanelColor;
        all_data_array[12] = climb;
        all_data_array[13] = isBalanced;
        all_data_array[14] = breakdown;
        all_data_array[15] = comments;
    }
}