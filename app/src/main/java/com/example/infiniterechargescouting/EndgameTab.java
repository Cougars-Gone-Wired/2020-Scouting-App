package com.example.infiniterechargescouting;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class EndgameTab extends Fragment {

    public static final String[] endPositionArray = {"Please Select", "1", "2", "3", "4", "5", "Did Not Climb"};
    private static Spinner climbPositionSpinner;
    private static EditText commentBox;
    private static View view;
    private static CheckBox balanceCheckbox;
    private static CheckBox breakdownCheckbox;
    private static CheckBox climbCheckbox;
    private static EditText finalScore;
    AlertDialog.Builder builder;


    public EndgameTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_endgame_tab, container, false);
        sets(view);
        submitButton();
        return view;
    }

    public static void reset() {
        //climbPositionSpinner.setSelection(0);
        commentBox = view.findViewById(R.id.commentsEditText);
        commentBox.setText("");
        MainActivity.comments = "";
        balanceCheckbox = view.findViewById(R.id.balancedCheckbox);
        balanceCheckbox.setChecked(false);
        MainActivity.isBalanced = "0";
        breakdownCheckbox = view.findViewById(R.id.breakdownCheckbox);
        breakdownCheckbox.setChecked(false);
        MainActivity.breakdown = "0";
        climbCheckbox.setChecked(false);
        MainActivity.climb = "0";
        finalScore = view.findViewById(R.id.finalScoreEditText);
        finalScore.setText("");
        MainActivity.finalScore = "";
    }

    public void sets(View view) {
        //climbPositionSpinner = view.findViewById(R.id.climbPositionSpinner);
        //ArrayAdapter<CharSequence> endLevelSpinnerAdapter = new ArrayAdapter<CharSequence>(this.getActivity(), android.R.layout.simple_spinner_item, endPositionArray);
        //endLevelSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //climbPositionSpinner.setAdapter(endLevelSpinnerAdapter);
    }

    public void enterData() {
        balanceCheckbox = view.findViewById(R.id.balancedCheckbox);
        if (balanceCheckbox.isChecked()) {
            MainActivity.isBalanced = "1";
        } else {
            MainActivity.isBalanced = "0";
        }
        breakdownCheckbox = view.findViewById(R.id.breakdownCheckbox);
        if (breakdownCheckbox.isChecked()) {
            MainActivity.breakdown = "1";
        } else {
            MainActivity.breakdown = "0";
        }
        climbCheckbox = view.findViewById(R.id.climbCheckbox);
        if (climbCheckbox.isChecked()) {
            MainActivity.climb = "1";
        } else {
            MainActivity.climb = "0";
        }
        finalScore = view.findViewById(R.id.finalScoreEditText);
        MainActivity.finalScore = finalScore.getText().toString();
        commentBox = view.findViewById(R.id.commentsEditText);
        MainActivity.comments = commentBox.getText().toString();
    }

    public void submitButton() {
        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitDialog();
    }

    public boolean finalSubmit() {
        for (int j = 4; j < 10; j++) {
            if (MainActivity.all_data_array[j].equals("")) {
                MainActivity.all_data_array[j] = "0";
            }
        }
        int issues = 0;
        for (int i = 0; i < MainActivity.all_data_array.length-1; i++) {
            if (MainActivity.all_data_array[i].equals("")) {
                issues++;
            }
        }
        if (issues > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void submitDialog() {
        builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Do you want to Submit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getContext(),"Submitting...",
                                Toast.LENGTH_SHORT).show();
                        submitProcess();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                        Toast.makeText(getContext(),"Closed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    public void submitProcess() {
        AutoTab.enterData();
        TeleopTab.enterData();
        enterData();
        MainActivity.setDataArray();
        if (finalSubmit()) {
            try {
                writeData();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Toast.makeText(getContext(),"Response Submitted",Toast.LENGTH_SHORT).show();
            AutoTab.reset();
            TeleopTab.reset();
            reset();
        } else {
            Toast.makeText(getContext(),"Something isn't filled out",Toast.LENGTH_SHORT).show();
        }
    }
        });
    }

    public void writeData() throws FileNotFoundException {

        final File path = getActivity().getApplicationContext().getExternalFilesDir(null);
        final File file = new File(path, "data.txt");

        final FileOutputStream output_stream = new FileOutputStream(file, true);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(output_stream));

        for (int i = 0; i < MainActivity.all_data_array.length; i++) {
            if (i != MainActivity.all_data_array.length-1) {
                writer.print(MainActivity.all_data_array[i] + ",");
            } else {
                writer.print(MainActivity.all_data_array[i]);
            }
        }
        writer.println();
        //prints to Android/data/com.example.InfiniteRechargeScouting/files
        writer.flush();
        writer.close();
    }
}