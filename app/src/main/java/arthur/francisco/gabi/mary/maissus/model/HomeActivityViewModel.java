package arthur.francisco.gabi.mary.maissus.model;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeActivityViewModel extends ViewModel {

    public List<Agendamento> getAgendamentos() {
        List<Agendamento> agendamentos = new ArrayList<>();

        Agendamento a1 = new Agendamento();
        a1.nomePaciente = "Francisco Lorenssute dos Santos";
        a1.especialidade = "Clínico Geral";
        a1.data = new Date();
        agendamentos.add(a1);

        Agendamento a2 = new Agendamento();
        a2.nomePaciente = "Francisco Lorenssute dos Santos";
        a2.especialidade = "Pediatra";
        a2.data = new Date();
        agendamentos.add(a2);

        Agendamento a3 = new Agendamento();
        a3.nomePaciente = "Francisco Lorenssute dos Santos";
        a3.especialidade = "Geriatra";
        a3.data = new Date();
        agendamentos.add(a3);

        Agendamento a4 = new Agendamento();
        a4.nomePaciente = "Francisco Lorenssute dos Santos";
        a4.especialidade = "Dermatologista";
        a4.data = new Date();
        agendamentos.add(a4);

        Agendamento a5 = new Agendamento();
        a5.nomePaciente = "Francisco Lorenssute dos Santos";
        a5.especialidade = "Clínico Geral";
        a5.data = new Date();
        agendamentos.add(a5);

        return agendamentos;
    }

    public List<Vacina> getVacinas(){

        List<Vacina> vacinas = new ArrayList<>();

        Vacina v1 = new Vacina();
        v1.nome = "Hepatite A";
        vacinas.add(v1);

        Vacina v2 = new Vacina();
        v2.nome = "Hepatite B";
        vacinas.add(v2);

        Vacina v3 = new Vacina();
        v3.nome = "Febre Amarela";
        vacinas.add(v3);

        Vacina v4 = new Vacina();
        v4.nome = "HPV";
        vacinas.add(v4);

        Vacina v5 = new Vacina();
        v5.nome = "Coronavírus";
        vacinas.add(v5);

        return vacinas;
    }

    public List<Unidade> getUnidades(){

        List<Unidade> unidades = new ArrayList<>();

        Unidade u1 = new Unidade();
        u1.nome = "UBS Pedro Feu Rosa";
        u1.localizacao = "Av Vitoria Régia, Feu Rosa";
        unidades.add(u1);

        Unidade u2 = new Unidade();
        u2.nome = "UBS Jacaraípe";
        u2.localizacao = "Av Minas Gerais, Jacaraípe";
        unidades.add(u2);

        Unidade u3 = new Unidade();
        u3.nome = "UBS Vila Nova de Colares";
        u3.localizacao = "Rua Papagaio, Vila Nova de Colares";
        unidades.add(u3);

        Unidade u4 = new Unidade();
        u4.nome = "UBS Novo Horizonte";
        u4.localizacao = "Rua Papagaio, Novo Horizonte";
        unidades.add(u4);

        Unidade u5 = new Unidade();
        u5.nome = "UBS Manguinhos ";
        u5.localizacao = "Rua Papagaio, Manguinhos";
        unidades.add(u5);

        return unidades;
    }
}
