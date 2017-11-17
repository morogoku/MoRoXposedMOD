package moro.com.moroxposedmod;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        boolean check = prefs.getBoolean("check", false);
        final SharedPreferences.Editor editor = prefs.edit();

        CheckBox cb = findViewById(R.id.checkBox);
        cb.setChecked(check);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    editor.putBoolean("check", true);
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Check Activado", Toast.LENGTH_LONG).show();
                }else{
                    editor.putBoolean("check", false);
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Check Desactivado", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
