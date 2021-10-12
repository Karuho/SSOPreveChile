package com.example.solemne1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Editar extends AppCompatActivity {

    private Button btnReturn2, btnEdit;
    private EditText txtEditName, txtEditLastName, txtEditAge,  txtEditEmail;
    private String userName, userLastName, userAge, userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        // Referencias
        btnReturn2 = findViewById(R.id.btnReturn2);
        btnEdit = findViewById(R.id.btnEdit);
        txtEditName = findViewById(R.id.txtEditName);
        txtEditLastName = findViewById(R.id.txtEditLastName);
        txtEditAge = findViewById(R.id.txtEditAge);
        txtEditEmail = findViewById(R.id.txtEditEmail);

        btnReturn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),UserMenu.class);
                startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtEditName.setError(null);
                txtEditLastName.setError(null);
                txtEditAge.setError(null);
                txtEditEmail.setError(null);
                userName = txtEditName.getEditableText().toString();
                userLastName = txtEditLastName.getEditableText().toString();
                userAge = txtEditAge.getEditableText().toString();
                userEmail = txtEditEmail.getEditableText().toString();
                if (ValidateEdit() > 0) {
                    ValidateEdit();
                } else {
                    Intent intent = new Intent(view.getContext(), UserMenu.class);
                    startActivity(intent);
                    switch (view.getId()) {
                        case R.id.btnEdit:
                            Toast.makeText(getApplicationContext(), "Datos Actualizados", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            break;
                    }
                }
            }
        });
    }

    public int ValidateEdit(){
        Validaciones validate = new Validaciones();
        int Errors = 0;

        if(validate.validateEmpty(userName)){
            txtEditName.setError("Campo 'Nombre' vacio");
            Errors++;
        }
        if(validate.validateEmpty(userLastName)){
            txtEditLastName.setError("Campo 'Apellido' vacio");
            Errors++;
        }
        if(validate.validateEmpty(userAge)){
            txtEditAge.setError("Campo 'Nombre' vacio");
            Errors++;
        }
        if(validate.validateEmpty(userEmail)){
            txtEditEmail.setError("Campo 'Nombre' vacio");
            Errors++;
        }
        if(!validate.validateEmail(userEmail)){
            Toast.makeText(Editar.this, "Error: Email inválido", Toast.LENGTH_SHORT).show();
            Errors++;
        }
        return Errors;
    }
}