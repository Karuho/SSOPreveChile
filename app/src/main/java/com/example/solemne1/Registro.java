package com.example.solemne1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private Button btnConfirmRegister;
    private EditText txtName, txtLastName, txtAge, txtPassRegister, txtEmailRegister;
    private String userName, userLastName, userAge, userPass, userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Referencias
        btnConfirmRegister = findViewById(R.id.btnConfirmRegister);
        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        txtAge = findViewById(R.id.txtAge);
        txtPassRegister = findViewById(R.id.txtPassRegister);
        txtEmailRegister = findViewById(R.id.txtEmailRegister);

        btnConfirmRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtName.setError(null);
                txtLastName.setError(null);
                txtAge.setError(null);
                txtPassRegister.setError(null);
                txtEmailRegister.setError(null);
                userName = txtName.getEditableText().toString();
                userLastName = txtLastName.getEditableText().toString();
                userAge = txtAge.getEditableText().toString();
                userPass = txtPassRegister.getEditableText().toString();
                userEmail = txtEmailRegister.getEditableText().toString();
                if (ValidateRegister() > 0) {
                    ValidateRegister();
                } else {
                    Intent intent = new Intent(view.getContext(), UserMenu.class);
                    startActivity(intent);
                    switch (view.getId()) {
                        case R.id.btnConfirmRegister:
                            Toast.makeText(getApplicationContext(), "Usuario Registrado", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            break;
                    }
                }
            }
        });
    }

    public int ValidateRegister(){
        Validaciones validate = new Validaciones();
        int Errors = 0;

        if(validate.validateEmpty(userName)){
            txtName.setError("Campo 'Nombre' vacio");
            Errors++;
        }
        if(validate.validateEmpty(userLastName)){
            txtLastName.setError("Campo 'Apellido' vacio");
            Errors++;
        }
        if(validate.validateEmpty(userAge)){
            txtAge.setError("Campo 'Nombre' vacio");
            Errors++;
        }
        if(validate.validateEmpty(userPass)){
            txtPassRegister.setError("Campo 'Contraseña' vacio");
            Errors++;
        }
        if(validate.validateEmpty(userEmail)){
            txtEmailRegister.setError("Campo 'Nombre' vacio");
            Errors++;
        }
        if(validate.validatePass(userPass) || !validate.validateEmail(userEmail)){
            Toast.makeText(Registro.this, "Error: Email y/o contraseña inválido(s)", Toast.LENGTH_SHORT).show();
            Errors++;
        }
        return Errors;
    }
}