package com.example.aisha.intrepidget;


import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

import static android.content.ContentValues.TAG;

public class SecondFragment extends Fragment {
    public EditText etFood;
    public EditText etHotel;
    public EditText etTransport;
    public EditText etSocial;
    public  EditText etMisc;
    public TextView tvTotal;

    public Button btnSendTot;


    //BigDecimal bigDecimalTotal = new BigDecimal(0.00);
    Integer total =0;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        etFood = (EditText)view.findViewById(R.id.editTextFood);
        etFood.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer tmp;
                tmp = new Integer(etFood.getText().toString());
                Toast.makeText(getActivity(), tmp.toString(), Toast.LENGTH_SHORT).show();

                total += tmp;
                Toast.makeText(getActivity(), total.toString(), Toast.LENGTH_SHORT).show();

                tvTotal.setText("$ " + total.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        etHotel = (EditText)view.findViewById(R.id.editTextHotel);
        etHotel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer tmp;
                tmp = new Integer(etHotel.getText().toString());
                Toast.makeText(getActivity(), tmp.toString(), Toast.LENGTH_SHORT).show();

                total += tmp;
                Toast.makeText(getActivity(), total.toString(), Toast.LENGTH_SHORT).show();

                tvTotal.setText("$ " + total.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        etTransport = (EditText)view.findViewById(R.id.editTextTrans);
        etTransport.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Integer tmp;
                tmp = new Integer(etTransport.getText().toString());
                Toast.makeText(getActivity(), tmp.toString(), Toast.LENGTH_SHORT).show();

                total += tmp;
                Toast.makeText(getActivity(), total.toString(), Toast.LENGTH_SHORT).show();

                tvTotal.setText("$ " + total.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etSocial = (EditText)view.findViewById(R.id.editTextSocial);
        etSocial.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Integer tmp;
                tmp = new Integer(etSocial.getText().toString());
                Toast.makeText(getActivity(), tmp.toString(), Toast.LENGTH_SHORT).show();

                total += tmp;
                Toast.makeText(getActivity(), total.toString(), Toast.LENGTH_SHORT).show();

                tvTotal.setText("$ " + total.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etMisc = (EditText)view.findViewById(R.id.editTextMisc);
        etMisc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer tmp;
                tmp = new Integer(etMisc.getText().toString());
                Toast.makeText(getActivity(), tmp.toString(), Toast.LENGTH_SHORT).show();

                total += tmp;
                Toast.makeText(getActivity(), total.toString(), Toast.LENGTH_SHORT).show();

                tvTotal.setText("$ " + total.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        tvTotal = (TextView)view.findViewById(R.id.textViewTotal);

        return view;
    }



}
