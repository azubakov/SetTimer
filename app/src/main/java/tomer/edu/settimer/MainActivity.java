package tomer.edu.settimer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
    }

    @TargetApi(Build.VERSION_CODES.N)
    public void setAlarms(View view) {
        int hour = 0;
        int minutes = 0;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hour = timePicker.getHour();
            minutes = timePicker.getMinute();
        }
        else
        {
            hour = timePicker.getCurrentHour();
            minutes = timePicker.getCurrentMinute();

        }

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);

        intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "call Mome.");
        startActivity(intent);


        Calendar c = Calendar.getInstance();
        
        c.set(2017, 11, 3, 21, 32);

    }
}
