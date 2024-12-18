package arthur.francisco.gabi.mary.maissus.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import arthur.francisco.gabi.mary.maissus.R;
import arthur.francisco.gabi.mary.maissus.activities.AgendarConsultaActivity;
import arthur.francisco.gabi.mary.maissus.activities.AgendarExameActivity;
import arthur.francisco.gabi.mary.maissus.activities.HomeActivity;
import arthur.francisco.gabi.mary.maissus.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configuração do carousel
        /*
        ImageCarousel carousel = view.findViewById(R.id.carousel);
        carousel.registerLifecycle(getLifecycle());

        List<CarouselItem> list = new ArrayList<>();
        list.add(new CarouselItem("https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Foto 1"));
        list.add(new CarouselItem("https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080", "Foto 2"));
        carousel.setData(list);*/

        // Configuração dos botões
        Button btAgdConsulta = view.findViewById(R.id.btAgdConsulta);
        Button btAgdExame = view.findViewById(R.id.btAgdExame);
        Button btVacinas = view.findViewById(R.id.btVacinas);
        Button btUnidades = view.findViewById(R.id.btUnidades);

        btAgdConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AgendarConsultaActivity.class);
                startActivity(intent);
            }
        });

        btAgdExame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AgendarExameActivity.class);
                startActivity(intent);
            }
        });

        btVacinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VacinasFragment fragment = new VacinasFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.flHome, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btUnidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UnidadesFragment fragment = new UnidadesFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.flHome, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}