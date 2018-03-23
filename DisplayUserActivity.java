package pl.pafc.userdatabase;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayUserActivity extends Activity {

    private TextView mDispayUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user);

        String mNewUser = getIntent().getStringExtra("newUser");

        mDispayUser = (TextView) findViewById(R.id.displayNewUserID);
        mDispayUser.setText(mNewUser);
    }
}
