package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbOneWay , cbRound;
    Button btnMinus , btnPlus , btnSubmit;
    TextView tvPax;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbOneWay = findViewById(R.id.cbOneWay);
        cbRound = findViewById(R.id.cbRound);
        btnMinus = findViewById(R.id.btnMin);
        btnPlus = findViewById(R.id.btnPlus);
        tvPax = findViewById(R.id.tvPax);
        btnSubmit = findViewById(R.id.btnSubmit);


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currPax = Integer.parseInt(tvPax.getText().toString());
                if(currPax == 1){
                    Toast.makeText(MainActivity.this,"Number of Pax cannot be below 1",Toast.LENGTH_LONG).show();
                }
                else{
                    currPax -= 1;
                    tvPax.setText(currPax + ""); // + "" to change to String because tvPax is a String
                }
            }

        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currPax = Integer.parseInt(tvPax.getText().toString());
                currPax += 1;
                tvPax.setText(currPax + ""); // + "" to change to String because tvPax is a String
            }


        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbOneWay.isChecked() && cbRound.isChecked()){
                    Toast.makeText(MainActivity.this,"Please select only one ticket type",Toast.LENGTH_LONG).show();
                }
                else if (!cbOneWay.isChecked() && !cbRound.isChecked()){
                    Toast.makeText(MainActivity.this,"Please select a ticket type",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,FlightDetails.class);
                    if(cbOneWay.isChecked()){
                        intent.putExtra("type",1);
                    }
                    else{
                        intent.putExtra("type",2);
                    }

                    intent.putExtra("pax",Integer.parseInt(tvPax.getText().toString()));
                    startActivity(intent);
                }
            }

        });
    }
}
