package com.example.ubkit.sendemail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editDestinatario, editAssunto, editTexto;
    Button btnEnviar;
    String destinatario, assunto, texto;
    Intent intent;
    boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editDestinatario = findViewById(R.id.editDestinatario);
        editAssunto = findViewById(R.id.editAssunto);
        editTexto = findViewById(R.id.editTexto);

        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    dados();

                    if (check == true){


                        intent = new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{destinatario});
                        intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
                        intent.putExtra(Intent.EXTRA_TEXT, texto);

                        intent.setType("message/rfc822");

                        startActivity(Intent.createChooser(intent,"Escolha um app"));

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Prencha todos os campos", Toast.LENGTH_SHORT).show();
                        }








            }
        });






    }
    public void dados(){

        destinatario = editDestinatario.getText().toString();
        assunto = editAssunto.getText().toString();
        texto = editTexto.getText().toString();

        //Validando os campos

        if (destinatario.isEmpty())
        {check = false;
        editDestinatario.setError("Complete o campo");
        editDestinatario.requestFocus();}
        else{}


        if (assunto.isEmpty())
        {check = false;
        editAssunto.setError("Complete o campo");
        editAssunto.requestFocus();
        }
        else{}


        if (texto.isEmpty())
        {check = false;
        editTexto.setError("Complete o campo");
        editTexto.requestFocus();
        }else{}




    }

}







