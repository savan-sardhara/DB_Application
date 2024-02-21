package com.example.db_application;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class CRUD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        DBHelper db=new DBHelper(CRUD.this);
        EditText nm=findViewById(R.id.etnm);
        EditText id=findViewById(R.id.etid);

        TextView tv=findViewById(R.id.tvdisp);

        Button ins=findViewById(R.id.btninsert);
        Button view=findViewById(R.id.btnview);
        Button del=findViewById(R.id.btndelete);
        Button update=findViewById(R.id.btnupdate);



        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String snm,id;
                snm=nm.getText().toString();
                db.insertdata(snm);
                nm.setText("");
            }
        });

        TableLayout tb=findViewById(R.id.tablaydata);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Cursor c=db.viewAll();

                 while (c.moveToNext()){

                     TableRow row=new TableRow(getApplicationContext());

                     TextView idtv=new TextView(getApplicationContext());
                     idtv.setText(c.getString(0));
                     idtv.setPadding(5,5,5,5);
                     row.addView(idtv);

                     TextView nmtv=new TextView(getApplicationContext());
                     nmtv.setText(c.getString(1));
                     nmtv.setPadding(5,5,5,5);
                     row.addView(nmtv);

                     tb.addView(row);

//                     tv.setText(tv.getText().toString()+"/ "+c.getString(0)+"/ "+c.getString(1));
                 }

                 c.close();

            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i=id.getText().toString();
                db.DeletData(i);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.UpdateData(nm.getText().toString(),id.getText().toString());
            }
        });



    }
}