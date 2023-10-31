package com.example.databasefintiflushky;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DBHelper dbHelper;
    TextView tvOut;
    EditText ename, esname, eyear, eNew;
    Button  btnDel, btnAdd, btnGet, btnDelOne, btnUpdate, btnSearch;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        tvOut = findViewById(R.id.tvOut);

        ename = findViewById(R.id.editName);
        esname = findViewById(R.id.editSurname);
        eyear = findViewById(R.id.editYear);
        eNew = findViewById(R.id.editNew);

        btnDel = findViewById(R.id.buttonDel);
        btnAdd = findViewById(R.id.buttonAdd);
        btnGet = findViewById(R.id.buttonGet);
        btnDelOne = findViewById(R.id.buttonDelOne);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnSearch = findViewById(R.id.buttonSearch);

        btnDel.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnGet.setOnClickListener(this);
        btnDelOne.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnSearch.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        LinkedList<Data> list;
        String text = "";
        switch(v.getId()){
            case R.id.buttonDel:
                dbHelper.DeleteAll();
                break;
            case R.id.buttonAdd:
                String name = ename.getText().toString();
                String sname = esname.getText().toString();
                int year = Integer.parseInt(eyear.getText().toString());

                Data data = new Data(name, sname, year);
                dbHelper.AddOne(data);
                break;
            case R.id.buttonGet:
                list = dbHelper.GetAll();
                for (Data d:list) text = text +(d.name)+ "  " +(d.surname)+ " "+ (d.year)+"\n";
                tvOut.setText(text.toString());
                break;
            case R.id.buttonDelOne:
                dbHelper.DeleeOne(eNew.getText().toString());
                break;

            case R.id.buttonUpdate:
                dbHelper.UpfateOne(eNew.getText().toString());
                break;

            case R.id.buttonSearch:
                list = dbHelper.Search(eNew.getText().toString());
                for (Data d:list) text = text +(d.name)+ "  " +(d.surname)+ " "+ (d.year)+"\n";
                tvOut.setText(text.toString());
                break;

            case R.id.button1000:
                tvOut.setText(""+ dbHelper.insert1000());
                break;
        }

    }
}
