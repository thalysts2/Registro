package com.example.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText et_nome,et_senha;
    Button bt_login;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_nome = (EditText)findViewById(R.id.et_nome);
        et_senha = findViewById(R.id.et_senha);
        db = new DBHelper(this);

        bt_login = findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = et_nome.getText().toString();
                String senha = et_senha.getText().toString();

                if (nome.equals("")){
                    Toast.makeText(LoginActivity.this,"Nome não inserido,tente novamente",Toast.LENGTH_SHORT).show();

                }else if(senha.equals("")){
                    Toast.makeText(LoginActivity.this,"senha não inserida,tente novamente comedia",Toast.LENGTH_SHORT).show();

                }else {
//                    tudo ok
                    String res = db.ValidarLogin(nome,senha);

                    if (res.equals("OK")){
                        Toast.makeText(LoginActivity.this,"Login com sucesso",Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(LoginActivity.this,"Login errado,tente novamente",Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
    }
}