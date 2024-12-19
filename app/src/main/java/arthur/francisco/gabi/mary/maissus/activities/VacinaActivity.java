package arthur.francisco.gabi.mary.maissus.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import arthur.francisco.gabi.mary.maissus.R;
import arthur.francisco.gabi.mary.maissus.adapters.UnidadesAdapter;
import arthur.francisco.gabi.mary.maissus.model.HomeActivityViewModel;
import arthur.francisco.gabi.mary.maissus.model.Unidade;
import arthur.francisco.gabi.mary.maissus.model.VacinasActivityViewModel;

public class VacinaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vacina);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        VacinasActivityViewModel homeActivityViewModel = new ViewModelProvider(this).get(VacinasActivityViewModel.class);
        List<Unidade> unidades = homeActivityViewModel.getUnidades();

        UnidadesAdapter unidadesAdapter = new UnidadesAdapter(VacinaActivity.this, unidades);

        RecyclerView rvUnidades = findViewById(R.id.rvInfoUnidade);
        rvUnidades.setAdapter(unidadesAdapter);

        rvUnidades.setLayoutManager(new LinearLayoutManager(VacinaActivity.this));
    }

    public void navegarDetalhesUnidade() {
        Intent intent = new Intent(VacinaActivity.this, UnidadeActivity.class);
        startActivity(intent);
    }
}