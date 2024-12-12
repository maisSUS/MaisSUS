package arthur.francisco.gabi.mary.maissus.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import arthur.francisco.gabi.mary.maissus.R;


import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.Arrays;
import java.util.List;

public class AgendarConsultaActivity extends AppCompatActivity {

    private Spinner spinnerUnidade, spinnerEspecialidade, spinnerProfissional, spinnerHorario;
    private EditText etData;
    private Button btnProsseguir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Chama o metodo onCreate da classe pai (AppCompatActivity ou Activity).
        super.onCreate(savedInstanceState);

        // Ativa o suporte ao modo Edge-to-Edge (tela inteira), permitindo que o conteúdo do aplicativo seja renderizado por baixo das barras do sistema.
        EdgeToEdge.enable(this);

        // Define o layout XML associado a esta Activity.
        setContentView(R.layout.activity_agendar_consulta);

        // Define um listener para lidar com os insets do sistema (áreas reservadas para barras de status, navegacao, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {

            // Obtem os insets do sistema, que indicam o espaço ocupado pelas barras do sistema (status, navegacao, etc.).
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Ajusta o padding da View raiz com base nos valores dos insets.
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            // Retorna os insets para que outras Views possam processá-los se necessário.
            return insets;
        });

        // Inicializando os elementos
        spinnerUnidade = findViewById(R.id.spUnidade);
        spinnerEspecialidade = findViewById(R.id.spEspecialidade);
        spinnerProfissional = findViewById(R.id.spProfissional);
        spinnerHorario = findViewById(R.id.spHorario);
        etData = findViewById(R.id.etData);
        btnProsseguir = findViewById(R.id.btnConsulta);

        // Listas de exemplo
        List<String> unidades = Arrays.asList("URS Feu Rosa", "UBS Jacaraípe", "UBS Vila Nova de Colares");
        List<String> especialidades = Arrays.asList("Clínico Geral", "Dermatologista", "Pediatria");
        List<String> profissionais = Arrays.asList("Katia Flávia dos Santos", "Ana Paula Silva", "Maria Eduarda Rodrigues");
        List<String> horarios = Arrays.asList("08:00", "09:00", "10:00");

        // Configurando os Adapters
        configurarSpinner(spinnerUnidade, unidades);
        configurarSpinner(spinnerEspecialidade, especialidades);
        configurarSpinner(spinnerProfissional, profissionais);
        configurarSpinner(spinnerHorario, horarios);

        // Evento do botão
        btnProsseguir.setOnClickListener(v -> {
            String unidadeSelecionada = spinnerUnidade.getSelectedItem().toString();
            String especialidadeSelecionada = spinnerEspecialidade.getSelectedItem().toString();
            String profissionalSelecionado = spinnerProfissional.getSelectedItem().toString();
            String data = etData.getText().toString();
            String horarioSelecionado = spinnerHorario.getSelectedItem().toString();

            if (data.isEmpty()) {
                Toast.makeText(this, "Por favor, escolha uma data!", Toast.LENGTH_SHORT).show();
            } else {
                // Lógica para prosseguir com os dados
                Toast.makeText(this, "Consulta agendada com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        // Evento para abrir um DatePicker ao clicar no campo de data
        etData.setOnClickListener(v -> abrirDatePicker());
    }

    private void configurarSpinner(Spinner spinner, List<String> itens) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itens);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void abrirDatePicker() {
        // Implementar DatePicker
    }
}