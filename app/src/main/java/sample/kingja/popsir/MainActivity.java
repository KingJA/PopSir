package sample.kingja.popsir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kingja.popsir.ListPop;
import com.kingja.popsir.PopConfig;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openPop(View view) {
        Button btn = findViewById(R.id.btn);
        PopConfig config = new PopConfig.Builder(this)
                .setPopHeight(500)
                .build();

        new ListPop(config).setAdapter(new PopAdapter(this)).showAsDropDown(btn);
    }

    public void say(View view) {
        Log.e(TAG, "say: ");
    }
}
