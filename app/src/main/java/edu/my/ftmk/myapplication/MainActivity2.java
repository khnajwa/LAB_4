package edu.my.ftmk.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.my.ftmk.myapplication.databinding.ActivityRegisterBinding;

public class MainActivity2 extends AppCompatActivity {

    ActivityRegisterBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the binding
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        binding.editTextTextPersonName2.setText(intent.getStringExtra("username"));
        binding.editTextTextPassword.setText(intent.getStringExtra("password")); // Populate password EditText

        fnLoadInput();
        binding.btnNext.setOnClickListener(this::fnNext);
    }

private void fnNext(View view){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
}


    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        fnSaveState();
        super.onPause();
    }

    public void fnSaveState(){

    }

    public void fnLoadInput(){

    }

    public void fnCalculateAge(View view) {
        String dobYearStr = binding.editTextDate.getText().toString();

        if (!dobYearStr.isEmpty()) {
            int dobYear = Integer.parseInt(dobYearStr);
            int currentYear = 2024;
            int age = currentYear - dobYear;

            binding.editTextDate.setText("You are " + age + " years old");
        } else {
            binding.editTextDate.setError("Please enter a valid year");
        }
    }


}
