package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText pid,pname,paddress,pcontact;
    Button save,delete,update,show;
    Student stu;
    DatabaseReference dataref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pid = findViewById(R.id.pid);
        pname = findViewById(R.id.pname);
        paddress= findViewById(R.id.paddress);
        pcontact = findViewById(R.id.pcontact);
        save = findViewById(R.id.save);
        delete=findViewById(R.id.delete);
        update=findViewById(R.id.update);
        show = findViewById(R.id.show);

        stu = new Student();

    }

    public void ClearControls(){
        pid.setText("");
        pname.setText("");
        paddress.setText("");
        pcontact.setText("");
    }

    public void createData(View view){
        dataref =FirebaseDatabase.getInstance().getReference().child("Student");
        try {
            if (TextUtils.isEmpty(pid.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter an id", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(pname.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter name", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(paddress.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please enter address", Toast.LENGTH_SHORT).show();
            else {
                //take inputs from the keyboard and assign them to the instance(stu) class
                stu.setPid(pid.getText().toString().trim());
                stu.setPname(pname.getText().toString().trim());
                stu.setPaddress(paddress.getText().toString().trim());
                stu.setPcontact(Integer.parseInt(pcontact.getText().toString().trim()));

                //insert is to the database
                dataref.push().setValue(stu);

                //Feedback to the user via at toast
                Toast.makeText(getApplicationContext(), "Data send sucessfully...", Toast.LENGTH_SHORT).show();
                ClearControls();
            }
        }catch(NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Invalid contact number ..",Toast.LENGTH_SHORT).show();
        }
    }


}