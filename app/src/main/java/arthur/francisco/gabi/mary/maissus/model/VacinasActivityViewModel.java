package arthur.francisco.gabi.mary.maissus.model;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class VacinasActivityViewModel extends ViewModel {

    public List<Unidade> getUnidades(){

        List<Unidade> unidades = new ArrayList<>();

        Unidade u1 = new Unidade();
        u1.nome = "UBS Pedro Feu Rosa";
        u1.localizacao = "Av Vitoria Régia, Feu Rosa";
        unidades.add(u1);

        Unidade u2 = new Unidade();
        u2.nome = "UBS Jacaraípe";
        u2.localizacao = "Av Minas Gerais, Das Laranjeiras";
        unidades.add(u2);

        Unidade u3 = new Unidade();
        u3.nome = "UBS Vila Nova de Colares";
        u3.localizacao = "Rua Papagaio, Feu Rosa";
        unidades.add(u3);

        return unidades;
    }
}
