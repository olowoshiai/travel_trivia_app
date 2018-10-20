package com.example.aisha.intrepidget;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ThirdFragment extends Fragment {

    public Button btnGBP;
    public Button btnINR;
    public Button btnEUR;
    public Button btnYEN;
    public Button btnNGN;
    public Button btnCAD;
    public EditText edDollarAmount;
    public TextView tvResultAmount;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        btnGBP = (Button)view.findViewById(R.id.btnPounds);
        btnINR = (Button)view.findViewById(R.id.btnRuppes);
        btnEUR = (Button)view.findViewById(R.id.btnEuro);
        btnYEN = (Button)view.findViewById(R.id.btnYen);
        btnNGN = (Button)view.findViewById(R.id.btnNaira);
        btnCAD = (Button)view.findViewById(R.id.btnCadDollar);
        edDollarAmount = (EditText)view.findViewById(R.id.etCurrencyAmount);
        tvResultAmount = (TextView)view.findViewById(R.id.tvCurrResulr);
        calcPounds();
        calcRupees();
        calcCanDol();
        calcEuro();
        calcYen();
        calcNaira();

        return view;
    }

    public void calcPounds(){
        btnGBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BigDecimal tmpAmount;
                tmpAmount = new BigDecimal(edDollarAmount.getText().toString());
                BigDecimal convert = new BigDecimal(0.75);

                BigDecimal result = tmpAmount.multiply(convert);
                result = result.setScale(2, RoundingMode.CEILING);
                tvResultAmount.setText("€" + result.toString());
            }});}

    public void calcRupees(){
        btnINR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BigDecimal tmpAmount;
                tmpAmount = new BigDecimal(edDollarAmount.getText().toString());
                BigDecimal convert = new BigDecimal(64.42);

                BigDecimal result = tmpAmount.multiply(convert);
                result = result.setScale(2, RoundingMode.CEILING);
                tvResultAmount.setText("₹" + result.toString());

            }});
    }

    public void calcEuro(){
        btnEUR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BigDecimal tmpAmount;
                tmpAmount = new BigDecimal(edDollarAmount.getText().toString());
                BigDecimal convert = new BigDecimal(1.18);

                BigDecimal result = tmpAmount.multiply(convert);
                result = result.setScale(2, RoundingMode.CEILING);
                tvResultAmount.setText("€" + result.toString());
            }
        });
    }

    public void calcYen(){
        btnYEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BigDecimal tmpAmount;
                tmpAmount = new BigDecimal(edDollarAmount.getText().toString());
                BigDecimal convert = new BigDecimal(113.44);

                BigDecimal result = tmpAmount.multiply(convert);
                result = result.setScale(2, RoundingMode.CEILING);
                tvResultAmount.setText("¥" + result.toString());
            }
        });
    }

    public void calcNaira(){
        btnNGN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BigDecimal tmpAmount;
                tmpAmount = new BigDecimal(edDollarAmount.getText().toString());
                BigDecimal convert = new BigDecimal(360.00);

                BigDecimal result = tmpAmount.multiply(convert);
                result = result.setScale(2, RoundingMode.CEILING);
                tvResultAmount.setText("₦" + result.toString());
            }
        });
    }

    public void calcCanDol(){
        btnCAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BigDecimal tmpAmount;
                tmpAmount = new BigDecimal(edDollarAmount.getText().toString());
                BigDecimal convert = new BigDecimal(1.28);

                BigDecimal result = tmpAmount.multiply(convert);
                result = result.setScale(2, RoundingMode.CEILING);
                tvResultAmount.setText("CAD " + result.toString());
            }
        });
    }
}
