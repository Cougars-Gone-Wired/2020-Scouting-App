package com.example.infiniterechargescouting;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AutoTab extends Fragment {


    private static EditText scoutNameEditText;
    private static TextView teamNumTextView;
    private static EditText matchNumEditText;
    private static TextView autoInnerScoreTextView;
    private static Button autoScore1MinusButton;
    private static Button autoScore1PlusButton;
    private static TextView autoOuterScoreTextView;
    private static Button autoScore2MinusButton;
    private static Button autoScore2PlusButton;
    private static TextView autoLowScoreTextView;
    private static Button confirmButton;
    private static View view;
    private static CheckBox baselineCheckbox;
    private static Button setMatchButton;
    private static Boolean confirmation = false;


    public AutoTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_auto_tab, container, false); //creates view
        MatchList.createTeamList();
        sets(view);
        enterData();
        return view;
    }


    public static void enterData() {
        //This enters all variable data from this class into the mainActivity variables except
        //for the score variables. Those are entered through the mainActivity button methods
        scoutNameEditText = view.findViewById(R.id.scoutNameEditText);
        teamNumTextView = view.findViewById(R.id.teamNumTextView);
        baselineCheckbox = view.findViewById(R.id.baselineCheckbox);
        matchNumEditText = view.findViewById(R.id.matchNumEditText);
        MainActivity.scoutName = scoutNameEditText.getText().toString();
        MainActivity.teamNum = teamNumTextView.getText().toString();
        MainActivity.matchNum = matchNumEditText.getText().toString();
        if (baselineCheckbox.isChecked()) {
            MainActivity.crossedBaseline = "1";
        } else {
            MainActivity.crossedBaseline = "0";
        }
        setMatchButton = view.findViewById(R.id.setMatchButton);
        setMatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //The onClick method runs when a button is clicked

                //these lines must be inside an onClick method since onCreateView only runs when window is created.
                int match_number = Integer.valueOf(matchNumEditText.getText().toString());


                if (match_number > MatchList.numMatches) {
                    teamNumTextView.setText("match does not exist");
                } else if (match_number >= 1 && match_number <= MatchList.numMatches) {
                    teamNumTextView.setText(MatchList.teamArray[Integer.valueOf(matchNumEditText.getText().toString()) - 1]);
                } else {
                    teamNumTextView.setText("no match selected");
                }
                MainActivity.teamNum = teamNumTextView.getText().toString();
            }
        });
    }
            public void sets(View view) {
                //This sets text boxes and scores to the saved variables so they don't disappear when
                //switching between tabs
                //If statements for setting text views to 0 initially, otherwise they start blank
                scoutNameEditText = view.findViewById(R.id.scoutNameEditText);
                scoutNameEditText.setText(MainActivity.scoutName);

                teamNumTextView = view.findViewById(R.id.teamNumTextView);
                teamNumTextView.setText(MainActivity.teamNum);

                autoInnerScoreTextView = view.findViewById(R.id.autoInnerGoalScoreTextView);
                if (MainActivity.autoInnerGoalNum == 0) {
                    autoInnerScoreTextView.setText("0");
                } else {
                    autoInnerScoreTextView.setText(MainActivity.autoInnerGoalText);
                }

                autoOuterScoreTextView = view.findViewById(R.id.autoOuterGoalScoreTextView);
                if (MainActivity.autoOuterGoalNum == 0) {
                    autoOuterScoreTextView.setText("0");
                } else {
                    autoOuterScoreTextView.setText(MainActivity.autoOuterGoalText);
                }

                autoLowScoreTextView = view.findViewById(R.id.autoLowGoalScoreTextView);
                if (MainActivity.autoLowGoalNum == 0) {
                    autoLowScoreTextView.setText("0");
                } else {
                    autoLowScoreTextView.setText(MainActivity.autoLowGoalText);
                }
            }

            public static void reset() {
                //Resets all textViews and textBoxes and variables, called from submitButton in EndgameTab
                MainActivity.scoutName = "";
                scoutNameEditText = view.findViewById(R.id.scoutNameEditText);
                scoutNameEditText.setText("");
                //scoutNameEditText.setText(MainActivity.scoutName);
                MainActivity.teamNum = "";
                teamNumTextView = view.findViewById(R.id.teamNumTextView);
                teamNumTextView.setText("0000");
                MainActivity.autoInnerGoalText = "0";
                MainActivity.autoInnerGoalNum = 0;
                autoInnerScoreTextView = view.findViewById(R.id.autoInnerGoalScoreTextView);
                autoInnerScoreTextView.setText(MainActivity.autoInnerGoalText);
                MainActivity.autoOuterGoalText = "0";
                MainActivity.autoOuterGoalNum = 0;
                autoOuterScoreTextView = view.findViewById(R.id.autoOuterGoalScoreTextView);
                autoOuterScoreTextView.setText(MainActivity.autoOuterGoalText);
                MainActivity.autoLowGoalText = "0";
                MainActivity.autoLowGoalNum = 0;
                autoLowScoreTextView = view.findViewById(R.id.autoLowGoalScoreTextView);
                autoLowScoreTextView.setText(MainActivity.autoLowGoalText);
                baselineCheckbox = view.findViewById(R.id.baselineCheckbox);
                baselineCheckbox.setChecked(false);
                MainActivity.crossedBaseline = "0";
            }
}