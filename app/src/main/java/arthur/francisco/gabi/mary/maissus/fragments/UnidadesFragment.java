package arthur.francisco.gabi.mary.maissus.fragments;

import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import arthur.francisco.gabi.mary.maissus.R;
import arthur.francisco.gabi.mary.maissus.activities.HomeActivity;
import arthur.francisco.gabi.mary.maissus.adapters.UnidadesAdapter;
import arthur.francisco.gabi.mary.maissus.model.HomeActivityViewModel;
import arthur.francisco.gabi.mary.maissus.model.Unidade;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UnidadesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnidadesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UnidadesFragment() {
        // Required empty public constructor
    }

    public static UnidadesFragment newInstance() {
        UnidadesFragment fragment = new UnidadesFragment();
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
        return inflater.inflate(R.layout.fragment_unidades, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HomeActivityViewModel homeActivityViewModel = new ViewModelProvider(getActivity()).get(HomeActivityViewModel.class);
        List<Unidade> unidades = homeActivityViewModel.getUnidades();

        UnidadesAdapter unidadesAdapter = new UnidadesAdapter((HomeActivity) getActivity(), unidades);

        RecyclerView rvUnidades = view.findViewById(R.id.rvUnidades);
        rvUnidades.setAdapter(unidadesAdapter);

        rvUnidades.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}