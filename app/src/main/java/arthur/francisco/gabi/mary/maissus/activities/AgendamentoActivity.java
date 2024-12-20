package arthur.francisco.gabi.mary.maissus.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import arthur.francisco.gabi.mary.maissus.R;
import arthur.francisco.gabi.mary.maissus.model.Unidade;

public class AgendamentoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agendamento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(AgendamentoActivity.this, R.style.MyTimePickerDialogTheme));
                LayoutInflater inflater = getLayoutInflater();

                builder.setView(inflater.inflate(R.layout.dlg_cancelamento, null))

                        // Add action buttons
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                builder.setTitle("Deseja cancelar seu agendamento?");
                builder.create().show();
            }
        });
    }
}