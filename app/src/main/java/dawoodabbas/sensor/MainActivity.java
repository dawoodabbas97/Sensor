package dawoodabbas.sensor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


public class MainActivity extends ActionBarActivity {

public static int[] icons={R.drawable.sample_2,R.drawable.sample_8,R.drawable.sample_4,R.drawable.sample_6,R.drawable.sample_3,R.drawable.sample_5};
    public static String[]tex={"Accelometer","Gryoscope","Magnetic","Light","Proximity","Exit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView=(GridView)findViewById(R.id.grid);
        gridView.setAdapter(new Imageadapter(this,tex,icons));
gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (position==0)
        {
            Intent i=new Intent(getApplicationContext(),accelometer.class);
        startActivity(i);}
        else if(position!=5)         {
            Intent j=new Intent(getApplicationContext(),Sensor.class);
            j.putExtra("pos",position);
            Log.i("abbas", "gryoscope");
            startActivity(j);
        }
        else
        {
            finish();
        }

    }
});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
