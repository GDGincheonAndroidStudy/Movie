package seunghyo.com.movie;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements FragmentA.OnClickActionCallBackA, FragmentB.OnclickActionB {

    LinearLayout linearLayout_port;
    LinearLayout linearLayout_land;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
            linearLayout_port = (LinearLayout) findViewById(R.id.linear1);
            linearLayout_port.setVisibility(View.GONE);

            FragmentManager fragmentManager = this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = null;

            fragment = new FragmentA();

            fragmentTransaction.replace(R.id.fragmentOne, fragment);
            fragmentTransaction.commit();
        } else {
            setContentView(R.layout.activity_main_land);
            linearLayout_land = (LinearLayout) findViewById(R.id.linear1);

            FragmentManager fragmentManager = this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment_left = new FragmentA();
            Fragment fragment_right = new FragmentC();

            fragmentTransaction.replace(R.id.fragmentOne, fragment_left);
            fragmentTransaction.replace(R.id.fragmentTwo, fragment_right);

            fragmentTransaction.commit();
        }
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

    @Override
    public void onclicklistview() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            linearLayout_port.setVisibility(View.VISIBLE);
        } else {
            linearLayout_land.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void OnclickCloseBtn() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            linearLayout_port.setVisibility(View.GONE);
        } else {
            linearLayout_land.setVisibility(View.VISIBLE);
        }
    }
}

