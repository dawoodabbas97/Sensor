package dawoodabbas.sensor;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class Sensor extends Activity implements SensorEventListener {


    TextView title, X, Y, Z,var;
    android.hardware.Sensor sens;
    SensorManager sm;
    int pos = -1;
    String titl = "";
    String u = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);


        Bundle b = getIntent().getExtras();
        if (b != null) {
            pos = b.getInt("pos");
        }

        if (pos == 1) {
            Log.i("abbas", "if");
            sm = (SensorManager) getSystemService(SENSOR_SERVICE);

            sens = sm.getDefaultSensor(android.hardware.Sensor.TYPE_GYROSCOPE);
            titl = "GRYSCOPE";
            u = "rad/sec";


        } else if (pos == 2)

        {
            Log.i("abbas", "else");
            sm = (SensorManager) getSystemService(SENSOR_SERVICE);

            sens = sm.getDefaultSensor(android.hardware.Sensor.TYPE_MAGNETIC_FIELD);
            titl = "MAGNETIC FIELD";
            u = "\u00B5T";

        }

        else if(pos==3)
        {
            sm = (SensorManager) getSystemService(SENSOR_SERVICE);

            sens = sm.getDefaultSensor(android.hardware.Sensor.TYPE_LIGHT);
            titl="Light";
            u=" lx";
        }

        else if(pos==4)
        {sm = (SensorManager) getSystemService(SENSOR_SERVICE);

            sens = sm.getDefaultSensor(android.hardware.Sensor.TYPE_PROXIMITY);
            Log.i("abbas","press");
            titl="Proximity";
            u=" cm";
        }



        title = (TextView) findViewById(R.id.title);
        title.setText(titl);
        sm.registerListener(this, sens, SensorManager.SENSOR_DELAY_NORMAL);
        X = (TextView) findViewById(R.id.X);
        Y = (TextView) findViewById(R.id.Y);
        Z = (TextView) findViewById(R.id.Z);
        var=(TextView)findViewById(R.id.var);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if(pos==1||pos==2) {
            X.setText("X= " + Float.toString(event.values[0]) + u);
            Y.setText("Y= " + Float.toString(event.values[1]) + u);
            Z.setText("Z= " + Float.toString(event.values[2]) + u);
        }
        else {
            var.setText(Float.toString(event.values[0])+ u);
        }
    }

    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy) {

    }
}
