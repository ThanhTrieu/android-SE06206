package com.example.campusexpensese06206.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.campusexpensese06206.R;
import com.example.campusexpensese06206.model.ExpensesModel;

import java.util.List;

public class ExpensesAdapter extends BaseAdapter {
    List<ExpensesModel> expenses;
    public ExpensesAdapter(List<ExpensesModel> model){
        super();
        expenses = model;
    }
    @Override
    public int getCount() {
        return expenses.size();
    }

    @Override
    public Object getItem(int position) {
        return expenses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return expenses.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View expenseListView;
        if (convertView == null){
            expenseListView = View.inflate(parent.getContext(), R.layout.expenses_listview, null);
        } else {
            expenseListView = convertView;
        }
        // lay du lieu tu model do ra listview
        ExpensesModel expense = (ExpensesModel) getItem(position);
        ImageView imgIcon = expenseListView.findViewById(R.id.imgLogo);
        TextView tvId = expenseListView.findViewById(R.id.tvId);
        TextView tvName = expenseListView.findViewById(R.id.tvName);
        TextView tvPrice = expenseListView.findViewById(R.id.tvPrice);
        TextView tvDes = expenseListView.findViewById(R.id.tvDes);

        imgIcon.setImageResource(expense.getIcon());
        tvId.setText(String.valueOf(expense.getId()));
        tvName.setText(expense.getName());
        tvPrice.setText(String.valueOf(expense.getPrice()));
        tvDes.setText(expense.getDescription());

        return expenseListView;
    }
}
