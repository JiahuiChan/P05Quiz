package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox cbOneWay , cbRound;
    Button btnMinus , btnPlus , btnSubmit;
    TextView tvPax;

    private double calOneWay(int pax){
        double amt = pax * 100;
        return amt;
    }

    private double calRoundTrip(int pax) {
        double amt = pax * 100 * 2;
        return amt;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbOneWay = findViewById(R.id.cbOneWay);
        cbRound = findViewById(R.id.cbRound);
        tvPax = findViewById(R.id.tvPax);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbOneWay.isChecked()){
                    double amt = calOneWay(tvPax);
                    Intent intent = new Intent(MainActivity.this , FlightDetails.class);
                    intent.putExtra("Tickets","One Way Trip");
                    startActivity(intent);

                }else if(cbRound.isChecked()){
                    Intent intent = new Intent(MainActivity.this , FlightDetails.class);
                    intent.putExtra("Tickets","Round Trip");
                    startActivity(intent);
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 0;
                Intent intent = new Intent(MainActivity.this , FlightDetails.class);
                intent.putExtra("pax",a-1);
                startActivity(intent);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 0;
                Intent intent = new Intent(MainActivity.this , FlightDetails.class);
                intent.putExtra("pax",a+1);
                startActivity(intent);
            }
        });
    }
}
