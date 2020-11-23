package com.example.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {
    EditText et_nome,et_senha,et_senha2;
    Button bt_registrar;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);


        db= new DBHelper(this);
        et_nome = findViewById(R.id.et_reg_nome);
        et_senha = findViewById(R.id.et_reg_senha);
        et_senha2 = findViewById(R.id.et_reg_senha2);

        bt_registrar = findViewById(R.id.bt_registarnovo);

        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = et_nome.getText().toString();
                String senha1 = et_senha.getText().toString();
                String senha2 = et_senha2.getText().toString();

                if(nome.equals("")){
                    Toast.makeText(RegistrarActivity.this,"Nome não inserido,tente novamente",Toast.LENGTH_SHORT).show();
                }
                else if (senha1.equals("")|| senha2.equals("")){
                    Toast.makeText(RegistrarActivity.this,"Deve preencher a senha,tente novamente",Toast.LENGTH_SHORT).show();
                }
                else if(!senha1.equals(senha2)){
                    Toast.makeText(RegistrarActivity.this," Senha não corresponde ,tente novamente",Toast.LENGTH_SHORT).show();
                }else{
                    //tudo ok
                    long res = db.CriarUtlizador(nome, senha1);
                    if (res>0){
                        Toast.makeText(RegistrarActivity.this,"Registro Ok jovem",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegistrarActivity.this,"Registro incorreto,tente novamente",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}