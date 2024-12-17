package arthur.francisco.gabi.mary.maissus.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import arthur.francisco.gabi.mary.maissus.R;
import arthur.francisco.gabi.mary.maissus.activities.HomeActivity;
import arthur.francisco.gabi.mary.maissus.model.Vacina;

public class VacinasAdapter extends RecyclerView.Adapter{
    HomeActivity homeActivity;
    List<Vacina> vacinas;

    public VacinasAdapter(HomeActivity homeActivity, List<Vacina> vacinas){
        this.homeActivity = homeActivity;
        this.vacinas = vacinas;
    }

    //metodo que cria elementos de interface para um item
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflador de layout que le o arquivo xml do item
        LayoutInflater inflater = LayoutInflater.from(homeActivity);
        //o inflador cria os elementos de interface referentes a um item e os guarda dentro de um objeto do tipo View
        View v = inflater.inflate(R.layout.item_vacina, parent, false);
        //o objeto do tipo View eh guardado dentro de um objeto do tipo MyViewHolder, que eh retornado pela funcao
        return new MyViewHolder(v);
    }

    //metodo que preenche a interface de usuario com os dados de um item
    /* recebe dois parametros: holder (objeto do tipo ViewHolder qeu guarda os vacinas de interface criados na execucao
    do metodo anterior); position (indicador de qual elemento da lista deve ser usado para preencher o item)*/
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //obtem o item a ser usado para preencher a UI
        Vacina vacina = vacinas.get(position);

        //obtem o objeto do tipo View que esta guardado dentro do ViewHolder
        View v = holder.itemView;

        TextView tvNomeVacina = v.findViewById(R.id.tvNomeVacina);
        tvNomeVacina.setText(vacina.nome);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivity.navegarDetalhesVacina();
            }
        });
    }

    public int getItemCount() {
        return vacinas.size();
    }


}