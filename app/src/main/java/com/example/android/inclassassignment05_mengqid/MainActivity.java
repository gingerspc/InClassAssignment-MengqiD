package com.example.android.inclassassignment05_mengqid;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    public static final String INTENT_STUDENT_LIST = "Student List";
    ArrayList<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void save(View view)
        {
            EditText name = (EditText) findViewById(R.id.name);
            String studentName = name.getText().toString();

            EditText uni = (EditText) findViewById(R.id.uni);
            String studentUni = name.getText().toString();

            RadioButton female = (RadioButton) findViewById(R.id.female);
            boolean isFemale = female.isChecked();

            RadioButton male = (RadioButton) findViewById(R.id.male);
            boolean isMale = male.isChecked();

            RadioButton other = (RadioButton) findViewById(R.id.other);
            boolean isOther = other.isChecked();

            String gender;

            if (isFemale) {
                gender = "female";
            } else if (isMale) {
                gender = "male";
            } else {
                gender = "other";
            }

            String graduateStatus;
            RadioButton graduate = (RadioButton) findViewById(R.id.graduate);
            if (graduate.isChecked()) {
                graduateStatus = "Graduated";
            }
            else
            {
                graduateStatus = "Not Graduated";
            }


            //Build a ArrayList
            Student newStudent = new Student(studentName,studentUni,gender,graduateStatus);
            students.add(newStudent);

            // Clear the data
            studentName="";
            name.setText(studentName);

            studentUni="";
            uni.setText(studentUni);

            Toast.makeText(this,"Record is saved!", Toast.LENGTH_SHORT).show();

        }

    public void results (View view)
    {
        //Put the arraylist in the intent
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("Student Records",students);
        students = new ArrayList<>();
        startActivity(intent);
    }


    public void profile(View view) {
        Toast.makeText(this,"Your profile picture is uploading...", Toast.LENGTH_SHORT).show();
    }

}
