package com.example.campusexpensese06206;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.campusexpensese06206.adapter.ExpensesAdapter;
import com.example.campusexpensese06206.model.ExpensesModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExpensesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpensesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExpensesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExpensesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExpensesFragment newInstance(String param1, String param2) {
        ExpensesFragment fragment = new ExpensesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_expenses, container, false);
        ListView lvExpenses = view.findViewById(R.id.lvExpenses);
        List<ExpensesModel> expensesModels = new ArrayList<>();

        expensesModels.add(new ExpensesModel(1,"An Sang", 25000, "An banh my, uong tra chanh",R.drawable.logo));
        expensesModels.add(new ExpensesModel(2,"Ca phe", 55000, "Ca phe voi ban be",R.drawable.home_icon));
        expensesModels.add(new ExpensesModel(3,"Xem phim", 200000, "Di xem phim voi nguoi yeu",R.drawable.payments_icon));
        expensesModels.add(new ExpensesModel(4,"Shopping", 2500000, "Mua sam voi ban be",R.drawable.settings_icon));
        ExpensesAdapter adapter = new ExpensesAdapter(expensesModels);
        lvExpenses.setAdapter(adapter);

        lvExpenses.setClickable(true);
        lvExpenses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ExpensesModel expense = (ExpensesModel) lvExpenses.getItemAtPosition(position);
                int idExpense = (int) expense.getId();
                String nameExpense = expense.getName();
                Toast.makeText(getActivity(), idExpense + " - " + nameExpense, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}