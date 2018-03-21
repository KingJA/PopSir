package sample.kingja.popsir;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kingja.popsir.ListPop;
import com.kingja.popsir.PopConfig;
import com.kingja.popsir.PopSpinner;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private PopSpinner spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn = findViewById(R.id.btn);
        PopConfig config = new PopConfig.Builder(this)
                .setPopHeight(500)
                .build();
        final ListPop listPop = new ListPop(config)
                .setAdapter(new PopAdapter(this, Arrays.asList("A", "B", "C", "D", "E", "F")))
                .setOnItemClickListener(new ListPop.OnItemClickListener<String>() {
                    @Override
                    public void onItemClick(String item, int position) {
                        spinner1.setSelectText(item);
                    }
                });

        spinner1 = findViewById(R.id.spinner1);
        spinner1.setOnSpinnerStatusChangedListener(new PopSpinner.OnSpinnerStatusChangedListener() {
            @Override
            public void setOnSpinnerStatusChanged(boolean opened) {
                if (opened) {
                    listPop.showAsDropDown(spinner1);
                }else{
                    listPop.dismiss();
                }
            }
        });
    }

    public void openPop(View view) {
        Button btn = findViewById(R.id.btn);
        PopConfig config = new PopConfig.Builder(this)
                .setPopHeight(500)
                .build();
        new ListPop(config)
                .setAdapter(new PopAdapter(this, Arrays.asList("A", "B", "C", "D", "E", "F")))
                .setOnItemClickListener(new ListPop.OnItemClickListener<String>() {
                    @Override
                    public void onItemClick(String item, int position) {
                        Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
                    }
                }).showAsDropDown(btn);

    }

    public void say(View view) {
        Log.e(TAG, "say: ");
    }
}
