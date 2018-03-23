package pl.pafc.userdatabase;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_acctivity);
    }

    public void addUserButton(View view) {
        Intent addUserButton = new Intent(this, AddUserActivity.class);
        startActivity(addUserButton);
    }

    public void exitButton(View view) {
        System.exit(0);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}
