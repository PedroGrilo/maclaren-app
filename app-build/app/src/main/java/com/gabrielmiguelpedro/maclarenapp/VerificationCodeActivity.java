package com.gabrielmiguelpedro.maclarenapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gabrielmiguelpedro.maclarenapp.Exceptions.EmptyFieldException;

import static com.gabrielmiguelpedro.maclarenapp.R.layout.activity_verification_code;

public class VerificationCodeActivity extends AppCompatActivity {

    private String email;
    private TextView code,btn_back;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_verification_code);
        try {
            email = getEmail();
            Toast.makeText(getApplicationContext(),email, Toast.LENGTH_SHORT).show();

            btn_back = findViewById(R.id.btn_back_vc);
            btn_next = findViewById(R.id.btn_end_vc);
            code = findViewById(R.id.code_tv);
            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private String getEmail() throws EmptyFieldException {
        Bundle email = getIntent().getExtras();
        if (email != null)
            return email.getString("email");
        throw new EmptyFieldException();
    }

}

