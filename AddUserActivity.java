package pl.pafc.userdatabase;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddUserActivity extends Activity {

    private static final String FILE_NAME = "usersDatabase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }

    public String readFromFile(String line) {

        try {
            FileInputStream fileInputStream = openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuffer stringBuffer = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                return line;
            }

            reader.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public void saveOnClick (View view) {

        String line = "";
        String tString = "";
        String tJson = "";
        String text = "[]";

        EditText mPesel = (EditText) findViewById(R.id.peselId);
        EditText mName = (EditText) findViewById(R.id.nameId);
        EditText mAddress = (EditText) findViewById(R.id.addressId);
        EditText mEmail = (EditText) findViewById(R.id.emailID);

        User user = new User();
        Gson json = new GsonBuilder().setPrettyPrinting().create();

        try {
            user.setPesel(mPesel.getText().toString());
            user.setName(mName.getText().toString());
            user.setAddress(mAddress.getText().toString());
            user.setEmail(mEmail.getText().toString());

            JSONArray jsonArray = new JSONArray();
            jsonArray.put(user);
            tJson = json.toJson(jsonArray);

            // zapis do pliku
            FileOutputStream outputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            outputStream.write(tJson.getBytes());
            outputStream.close();
            Toast.makeText(getApplicationContext(), "saved into file", Toast.LENGTH_SHORT).show();

            // odczyt z pliku
            FileInputStream fileInputStream = openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            fileInputStream.close();
            inputStreamReader.close();
            bufferedReader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Toast.makeText(this, "Saved!\n" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(AddUserActivity.this, DisplayUserActivity.class);
        intent.putExtra("newUser", tJson);

        startActivity(intent);
        finish();

    }
}
