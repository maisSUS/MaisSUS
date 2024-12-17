package arthur.francisco.gabi.mary.maissus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import arthur.francisco.gabi.mary.maissus.R;
import arthur.francisco.gabi.mary.maissus.fragments.AgendamentosFragment;
import arthur.francisco.gabi.mary.maissus.fragments.HomeFragment;
import arthur.francisco.gabi.mary.maissus.fragments.PerfilFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bnvHome);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.opHome:
                        HomeFragment homeFragment = HomeFragment.newInstance();
                        setFragment(homeFragment);
                        break;
                    case R.id.opAgendamentos:
                        AgendamentosFragment agendamentosFragment = AgendamentosFragment.newInstance();
                        setFragment(agendamentosFragment);
                        break;
                    case R.id.opPerfil:
                        PerfilFragment perfilFragment = PerfilFragment.newInstance();
                        setFragment(perfilFragment);
                        break;
                }
                return true;
            }
        });
    }

    public void navegarDetalhesAgendamento(){
        Intent intent = new Intent(HomeActivity.this, AgendamentoActivity.class);
        startActivity(intent);
    }

    public void navegarDetalhesVacina() {
        Intent intent = new Intent(HomeActivity.this, VacinaActivity.class);
        startActivity(intent);
    }

    public void navegarDetalhesUnidade() {
        Intent intent = new Intent(HomeActivity.this, UnidadeActivity.class);
        startActivity(intent);
    }
}