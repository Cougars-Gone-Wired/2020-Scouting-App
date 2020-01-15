package com.example.infiniterechargescouting;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeleopTab extends Fragment {

    private static TextView teleScore1ScoreTextView;
    private static Button teleScore1PlusButton;
    private static Button teleScore1MinusButton;
    private static TextView teleScore2ScoreTextView;
    private static Button teleScore2PlusButton;
    private static Button teleScore2MinusButton;
    private static TextView teleScore3ScoreTextView;
    private static Button teleScore3PlusButton;
    private static Button teleScore3MinusButton;
    private static TextView teleScore4ScoreTextView;
    private static Button teleScore4PlusButton;
    private static Button teleScore4MinusButton;
    private static CheckBox spinCPCheckbox;
    private static CheckBox colorCPCheckbox;
    private static View view;

    public TeleopTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_teleop_tab, container, false); //creates view
        sets(view);
        enterData();
        return view;
    }

    public void enterData () {
        //This enters all variable data from this class into the mainActivity variables except
        //for the score variables. Those are entered through the MainActivity button methods
        spinCPCheckbox = view.findViewById(R.id.spinCheckbox);
        if (spinCPCheckbox.isChecked()) {
            MainActivity.controlPanelSpin = "True";
        } else {
            MainActivity.controlPanelSpin = "False";
        }
        colorCPCheckbox = view.findViewById(R.id.colorSpinCheckbox);
        if (colorCPCheckbox.isChecked()) {
            MainActivity.controlPanelColor = "True";
        } else {
            MainActivity.controlPanelColor = "False";
        }
    }

    public void sets(final View view) {
        //This sets all text boxes and score values to the saved variables so they don't
        //Disappear when switching between tabs
        //If statements are for setting the text boxes to 0 initially, otherwise they begin blank
        teleScore1ScoreTextView = view.findViewById(R.id.teleInnerGoalScoreTextView);
        if (MainActivity.teleInnerGoalNum == 0) {
            teleScore1ScoreTextView.setText("0");
        } else {
            teleScore1ScoreTextView.setText(MainActivity.teleInnerGoalText);
        }

        teleScore2ScoreTextView = view.findViewById(R.id.teleOuterGoalScoreTextView);
        if (MainActivity.teleOuterGoalNum == 0) {
            teleScore2ScoreTextView.setText("0");
        } else {
            teleScore2ScoreTextView.setText(MainActivity.teleOuterGoalText);
        }

        teleScore3ScoreTextView = view.findViewById(R.id.teleLowGoalScoreTextView);
        if (MainActivity.teleLowGoalNum == 0) {
            teleScore3ScoreTextView.setText("0");
        } else {
            teleScore3ScoreTextView.setText(MainActivity.teleLowGoalText);
        }
    }

    public static void reset () {
        //Resets all variables and text boxes, called by submitButton in EndgameTab class
        teleScore1ScoreTextView = view.findViewById(R.id.teleInnerGoalScoreTextView);
        teleScore1ScoreTextView.setText("");
        MainActivity.teleInnerGoalNum = 0;
        MainActivity.teleInnerGoalText = "";

        teleScore2ScoreTextView = view.findViewById(R.id.teleOuterGoalScoreTextView);
        teleScore2ScoreTextView.setText("");
        MainActivity.teleOuterGoalNum = 0;
        MainActivity.teleOuterGoalText = "";

        teleScore3ScoreTextView = view.findViewById(R.id.teleLowGoalScoreTextView);
        teleScore3ScoreTextView.setText("");
        MainActivity.teleLowGoalNum = 0;
        MainActivity.teleLowGoalText = "";

        colorCPCheckbox = view.findViewById(R.id.colorSpinCheckbox);
        spinCPCheckbox = view.findViewById(R.id.spinCheckbox);
        colorCPCheckbox.setChecked(false);
        spinCPCheckbox.setChecked(false);
    }
}