package arthur.francisco.gabi.mary.maissus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import arthur.francisco.gabi.mary.maissus.R;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnCriarConta = findViewById(R.id.btnCriarConta);
        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNome = findViewById(R.id.etNome);
                final String nome = etNome.getText().toString();
                if (nome.isEmpty()){
                    Toast.makeText(CadastroActivity.this, "Campo de 'Nome' não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }
                EditText etSobrenome = findViewById(R.id.etSobrenome);
                final String sobrenome = etSobrenome.getText().toString();
                if (sobrenome.isEmpty()){
                    Toast.makeText(CadastroActivity.this, "Campo de 'Sobrenome' não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }
                EditText etCPF = findViewById(R.id.etCPF);
                final String cpf = etCPF.getText().toString();
                if (cpf.isEmpty()){
                    Toast.makeText(CadastroActivity.this, "Campo de 'CPF' não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }
                EditText etCartaoSUS = findViewById(R.id.etCartaoSUS);
                final String cartaoSUS = etCartaoSUS.getText().toString();
                if (cartaoSUS.isEmpty()){
                    Toast.makeText(CadastroActivity.this, "Campo de 'Cartão do SUS' não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }
                EditText etTelefone = findViewById(R.id.etTelefone);
                final String telefone = etTelefone.getText().toString();
                if (telefone.isEmpty()){
                    Toast.makeText(CadastroActivity.this, "Campo de 'Telefone' não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }
                EditText etEmail = findViewById(R.id.etEmail);
                final String email = etEmail.getText().toString();
                if (email.isEmpty()){
                    Toast.makeText(CadastroActivity.this, "Campo de 'Email' não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }
                EditText etSenha = findViewById(R.id.etSenha);
                final String senha = etSenha.getText().toString();
                if (senha.isEmpty()){
                    Toast.makeText(CadastroActivity.this, "Campo de 'Senha' não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }
                EditText etConfirmarSenha = findViewById(R.id.etConfirmarSenha);
                final String confirmarSenha = etConfirmarSenha.getText().toString();
                if (confirmarSenha.isEmpty()){
                    Toast.makeText(CadastroActivity.this, "Campo de 'Confirmar Senha' não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(CadastroActivity.this, HomeActivity.class);
            }
        });

    }

}