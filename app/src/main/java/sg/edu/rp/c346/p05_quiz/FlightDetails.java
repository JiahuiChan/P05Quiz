package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FlightDetails extends AppCompatActivity {

    TextView tv1 , tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);



        Intent intentReceived = getIntent();
        int tickets = intentReceived.getIntExtra("type" , 0);
        int pax = intentReceived.getIntExtra("pax" , 0);
        double cost = 100 * pax;

        if (tickets == 1){
            tv1.setText("You have selected One-Way Trip");
            tv2.setText(Double.toString(cost));

        }
        else{
            tv1.setText("You have selected Round Trip");
            cost = cost * 2;
            tv2.setText(Double.toString(cost));
        }

    }
}
