package com.example.solemne1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private EditText tilEmail, tilPass;
    private String userEmail, userPass;
    private CheckBox cbViewPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        tilEmail = findViewById(R.id.tilEmail);
        tilPass = findViewById(R.id.tilPass);
        cbViewPass = findViewById(R.id.cbViewPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tilEmail.setError(null);
                tilPass.setError(null);
                userEmail = tilEmail.getEditableText().toString();
                userPass = tilPass.getEditableText().toString();
                if (ValidateLogin()>0){
                    ValidateLogin();
                } else {
                    Intent intent = new Intent(view.getContext(), UserMenu.class);
                    startActivity(intent);
                    switch (view.getId()) {
                        case R.id.btnLogin:
                            Toast.makeText(getApplicationContext(), "¡Bienvenido!", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            break;
                    }
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Registro.class);
                startActivity(intent);
            }
        });
    }

    public void viewPass(View view){
        //Guardar cursor
        int cursor = tilPass.getSelectionEnd();

        if(cbViewPass.isChecked()){
            tilPass.setInputType(InputType.TYPE_CLASS_TEXT
                    | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }else{
            tilPass.setInputType(InputType.TYPE_CLASS_TEXT
                    | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }

        // Restaurar cursor
        tilPass.setSelection(cursor);
    }

    public int ValidateLogin(){
        Validaciones validate = new Validaciones();
        int Errors = 0;

        if(validate.validateEmpty(userEmail)){
            tilEmail.setError("Campo 'Email' vacio");
            Errors++;
        }
        if(validate.validateEmpty(userPass)){
            tilPass.setError("Campo 'Contraseña' vacio");
            Errors++;
        }
        if(validate.validatePass(userPass) || !validate.validateEmail(userEmail)){
            Toast.makeText(MainActivity.this, "Error: Email y/o contraseña inválido(s)", Toast.LENGTH_SHORT).show();
            Errors++;
        }
        return Errors;
    }
}