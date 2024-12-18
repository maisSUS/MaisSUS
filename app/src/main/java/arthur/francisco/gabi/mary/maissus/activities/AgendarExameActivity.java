package arthur.francisco.gabi.mary.maissus.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import arthur.francisco.gabi.mary.maissus.R;

public class AgendarExameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agendar_exame);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinnerUnidade = findViewById(R.id.spUnidade);
        Spinner spinnerExame = findViewById(R.id.spExame);
        Spinner spinnerHorario = findViewById(R.id.spHorario);
        EditText etData = findViewById(R.id.etDataEx);
        Button btnExame = findViewById(R.id.btnExame);

        List<String> unidades = Arrays.asList("Selecione uma unidade", "URS Feu Rosa", "UBS Jacaraípe", "UBS Vila Nova de Colares");
        List<String> exames = Arrays.asList("Selecione um exame", "Clínico Geral", "Dermatologista", "Pediatria", "Otorrinolaringologista");
        List<String> horarios = Arrays.asList("Selecione um horário", "08:00", "08:30", "09:00", "09:30", "10:00");

        configurarSpinner(spinnerUnidade, unidades);
        configurarSpinner(spinnerExame, exames);
        configurarSpinner(spinnerHorario, horarios);

        ImageButton imbData = findViewById(R.id.imbDataEx);
        imbData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCalendar = Calendar.getInstance();
                int year = mCalendar.get(Calendar.YEAR);
                int month = mCalendar.get(Calendar.MONTH);
                int dayOfMonth = mCalendar.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(AgendarExameActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etData.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
                    }
                }, year, month, dayOfMonth).show();
            }
        });

        btnExame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int unidadeSelecionada = spinnerUnidade.getSelectedItemPosition();
                int exameSelecionado = spinnerExame.getSelectedItemPosition();
                int horarioSelecionado = spinnerHorario.getSelectedItemPosition();
                String data = etData.getText().toString();

                if(unidadeSelecionada == 0) {
                    Toast.makeText(AgendarExameActivity.this, "Por favor, selecione uma unidade!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(exameSelecionado == 0) {
                    Toast.makeText(AgendarExameActivity.this, "Por favor, selecione um exame!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(horarioSelecionado == 0) {
                    Toast.makeText(AgendarExameActivity.this, "Por favor, selecione um horário!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(data.isEmpty()){
                    Toast.makeText(AgendarExameActivity.this, "Por favor, escolha uma data!", Toast.LENGTH_SHORT).show();
                    return;
                }

                finish();
            }
        });

        etData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDatePicker();
            }
        });
    }

    private void configurarSpinner(Spinner spinner, List<String> itens) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itens);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    private void abrirDatePicker() {
        // Obtendo a data atual
        /*
        final Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        // Criando o DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Formatar a data selecionada e exibir no EditText
                String dataSelecionada = dayOfMonth + "/" + (month + 1) + "/" + year;
                etData.setText(dataSelecionada);
            }
        }, ano, mes, dia);

        // Exibindo o DatePickerDialog
        datePickerDialog.show();
        */
    }
}