package arthur.francisco.gabi.mary.maissus.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import arthur.francisco.gabi.mary.maissus.R;
import arthur.francisco.gabi.mary.maissus.activities.HomeActivity;
import arthur.francisco.gabi.mary.maissus.activities.VacinaActivity;
import arthur.francisco.gabi.mary.maissus.model.Unidade;

public class UnidadesAdapter extends RecyclerView.Adapter{
    AppCompatActivity activity;
    List<Unidade> unidades;

    public UnidadesAdapter(AppCompatActivity activity, List<Unidade> itens){
        this.activity = activity;
        this.unidades = itens;
    }

    //metodo que cria elementos de interface para um item
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflador de layout que le o arquivo xml do item
        LayoutInflater inflater = LayoutInflater.from(activity);
        //o inflador cria os elementos de interface referentes a um item e os guarda dentro de um objeto do tipo View
        View v = inflater.inflate(R.layout.item_unidade, parent, false);
        //o objeto do tipo View eh guardado dentro de um objeto do tipo MyViewHolder, que eh retornado pela funcao
        return new MyViewHolder(v);
    }

    //metodo que preenche a interface de usuario com os dados de um item
    /* recebe dois parametros: holder (objeto do tipo ViewHolder qeu guarda os itens de interface criados na execucao
    do metodo anterior); position (indicador de qual elemento da lista deve ser usado para preencher o item)*/
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //obtem o item a ser usado para preencher a UI
        Unidade Unidade = unidades.get(position);

        //obtem o objeto do tipo View que esta guardado dentro do ViewHolder
        View v = holder.itemView;

        TextView tvNomeUnidadeItem = v.findViewById(R.id.tvNomeUnidadeItem);
        tvNomeUnidadeItem.setText(Unidade.nome);

        TextView tvLocalizacao = v.findViewById(R.id.tvLocalizacao);
        tvLocalizacao.setText(Unidade.localizacao);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activity instanceof HomeActivity) {
                    ((HomeActivity) activity).navegarDetalhesUnidade();
                }
                else {
                    ((VacinaActivity) activity).navegarDetalhesUnidade();
                }

            }
        });
    }

    public int getItemCount() {
        return unidades.size();
    }


}