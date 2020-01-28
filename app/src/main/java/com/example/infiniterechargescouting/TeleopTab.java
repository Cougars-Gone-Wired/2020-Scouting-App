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

    private static TextView teleInnerScoreTextView;
    private static Button teleScore1PlusButton;
    private static Button teleScore1MinusButton;
    private static TextView teleOuterScoreTextView;
    private static Button teleScore2PlusButton;
    private static Button teleScore2MinusButton;
    private static TextView teleLowScoreTextView;
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
        //enterData();
        return view;
    }

    public static void enterData () {
        //This enters all variable data from this class into the mainActivity variables except
        //for the score variables. Those are entered through the MainActivity button methods
        spinCPCheckbox = view.findViewById(R.id.spinCheckbox);
        if (spinCPCheckbox.isChecked()) {
            MainActivity.controlPanelSpin = "1";
        } else {
            MainActivity.controlPanelSpin = "0";
        }
        colorCPCheckbox = view.findViewById(R.id.colorSpinCheckbox);
        if (colorCPCheckbox.isChecked()) {
            MainActivity.controlPanelColor = "1";
        } else {
            MainActivity.controlPanelColor = "0";
        }
    }

    public void sets(final View view) {
        //This sets all text boxes and score values to the saved variables so they don't
        //Disappear when switching between tabs
        //If statements are for setting the text boxes to 0 initially, otherwise they begin blank
        teleInnerScoreTextView = view.findViewById(R.id.teleInnerGoalScoreTextView);
        if (MainActivity.teleInnerGoalNum == 0) {
            teleInnerScoreTextView.setText("0");
        } else {
            teleInnerScoreTextView.setText(MainActivity.teleInnerGoalText);
        }

        teleOuterScoreTextView = view.findViewById(R.id.teleOuterGoalScoreTextView);
        if (MainActivity.teleOuterGoalNum == 0) {
            teleOuterScoreTextView.setText("0");
        } else {
            teleOuterScoreTextView.setText(MainActivity.teleOuterGoalText);
        }

        teleLowScoreTextView = view.findViewById(R.id.teleLowGoalScoreTextView);
        if (MainActivity.teleLowGoalNum == 0) {
            teleLowScoreTextView.setText("0");
        } else {
            teleLowScoreTextView.setText(MainActivity.teleLowGoalText);
        }
    }

    public static void reset () {
        //Resets all variables and text boxes, called by submitButton in EndgameTab class
        teleInnerScoreTextView = view.findViewById(R.id.teleInnerGoalScoreTextView);
        teleInnerScoreTextView.setText("");
        MainActivity.teleInnerGoalNum = 0;
        MainActivity.teleInnerGoalText = "";

        teleOuterScoreTextView = view.findViewById(R.id.teleOuterGoalScoreTextView);
        teleOuterScoreTextView.setText("");
        MainActivity.teleOuterGoalNum = 0;
        MainActivity.teleOuterGoalText = "";

        teleLowScoreTextView = view.findViewById(R.id.teleLowGoalScoreTextView);
        teleLowScoreTextView.setText("");
        MainActivity.teleLowGoalNum = 0;
        MainActivity.teleLowGoalText = "";

        colorCPCheckbox = view.findViewById(R.id.colorSpinCheckbox);
        spinCPCheckbox = view.findViewById(R.id.spinCheckbox);
        colorCPCheckbox.setChecked(false);
        spinCPCheckbox.setChecked(false);
        MainActivity.controlPanelColor = "";
        MainActivity.controlPanelSpin = "";
    }
}