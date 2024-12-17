package arthur.francisco.gabi.mary.maissus.model;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeActivityViewModel extends ViewModel {

    public List<Agendamento> getAgendamentos() {
        List<Agendamento> agendamentos = new ArrayList<>();

        Agendamento a1 = new Agendamento();
        a1.nomePaciente = "Daniel Ribeiro Trindade";
        a1.especialidade = "Médico Clinico Geral";
        a1.data = new Date();

        agendamentos.add(a1);

        return agendamentos;

    }
}
