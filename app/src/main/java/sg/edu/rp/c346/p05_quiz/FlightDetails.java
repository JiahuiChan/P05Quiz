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
        String tickets = intentReceived.getStringExtra("Tickets");
        String pax = intentReceived.getStringExtra("pax");

        tv1.setText("You have selected" + tickets);

        tv2.setText("Your air ticket costs" + pax);


    }
}
