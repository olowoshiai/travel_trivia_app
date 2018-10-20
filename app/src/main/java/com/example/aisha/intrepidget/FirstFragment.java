package com.example.aisha.intrepidget;


import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FirstFragment extends Fragment {

    DatabaseHelper myDb;

    public EditText etCity;
    public EditText etDuration;
    public EditText etMonthYear;
    public Button btnAdd;
    public Button btnViewAll;
    public Button btnUpdate;
    public EditText etId;
    public Button btnDelete;
    public EditText etGetCities;
    public Button btnGetCities;
    public TextView tvResult;

    private SQLiteDatabase db;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_first, container, false);
      myDb = new DatabaseHelper(getActivity());

      etCity = (EditText)view.findViewById(R.id.etCity);
      etDuration = (EditText)view.findViewById(R.id.etDuration);
      etMonthYear = (EditText)view.findViewById(R.id.etMonthYear);
      btnAdd = (Button)view.findViewById(R.id.btnAdd);
      btnViewAll = (Button)view.findViewById(R.id.btnViewAll);
      btnUpdate = (Button)view.findViewById(R.id.btnUpdate);
      etId = (EditText) view.findViewById(R.id.etId);
      btnDelete = (Button)view.findViewById(R.id.btnDelete);
      etGetCities = (EditText) view.findViewById(R.id.etGetCities);
      btnGetCities = (Button)view.findViewById(R.id.btnGetCities);
      tvResult = (TextView)view.findViewById(R.id.tvResult);
      addData();
      viewAll();
      updateData();
      deleteData();
      viewCities();

      return view;
    }

    public void addData(){
        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData(etCity.getText().toString(), 
                                etDuration.getText().toString(), etMonthYear.getText().toString());
                        if (isInserted == true){
                            Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getActivity(), "Data Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //pattern: crate button, write query in help class, come here to setOnclick

    public  void viewAll(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0){
                            //show message
                            showMessage("Error", "No data Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("Id: " + res.getString(0) + "\n");
                            buffer.append("City: " + res.getString(1) + "\n");
                            buffer.append("Duration: " + res.getString(2) + "\n");
                            buffer.append("Month/Year: " + res.getString(3) + "\n\n");
                        }
                        //show all data
                        showMessage("Data", buffer.toString());
                    }
                });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public  void  updateData(){
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       boolean isUpdated= myDb.updateData(etId.getText().toString(),
                               etCity.getText().toString(),
                               etDuration.getText().toString(), etMonthYear.getText().toString());

                       if (isUpdated == true){
                           Toast.makeText(getActivity(), "Data Updated", Toast.LENGTH_SHORT).show();
                       }
                       else
                           Toast.makeText(getActivity(), "Data Not Updated", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void deleteData(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = myDb.deleteData(etId.getText().toString());
                        if(deletedRows > 0){
                            Toast.makeText(getActivity(), "Data Deleted", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getActivity(), "Data Not Deleted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void viewCities(){
        btnGetCities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp;
                db = myDb.getReadableDatabase();

                Cursor res = db.rawQuery("SELECT CITY FROM travel_table WHERE MONTHYEAR = "
                        + "'" + etGetCities.getText().toString() + "'", null);

                try{
                    if( res != null){
                        if(res.moveToFirst()){
                            tmp = res.getString(res.getColumnIndex("CITY"));
                            tvResult.append(tmp+"\n");
                        }
                    }
                }finally {
                    res.close();
                }
            }
        });
    }

}
