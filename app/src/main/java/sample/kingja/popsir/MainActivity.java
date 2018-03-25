package sample.kingja.popsir;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kingja.popsir.ListPop;
import com.kingja.popsir.PopAdapter;
import com.kingja.popsir.PopConfig;
import com.kingja.popsir.PopHelper;
import com.kingja.popsir.PopSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private PopSpinner spinner1;
    private PopSpinner spinner2;
    private PopSpinner spinner3;
    private List<PopItem> popItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        ItemAdapter itemAdapter = new ItemAdapter(this, popItems);

        new PopHelper.Builder(this)
                .setList(Arrays.asList("aaa", "ccc", "ddd", "eee", "fff"))
                .setPopSpinner(spinner1)
                .setOnItemClickListener(new PopHelper.OnItemClickListener<String>() {
                    @Override
                    public void onItemClick(String item, int position, PopSpinner popSpinner) {
                        popSpinner.setSelectText(item);
                        Log.e(TAG, "item: " + item);
                    }
                })
                .build();

        new PopHelper.Builder(this)
                .setPopSpinner(spinner2)
                .setAdapter(itemAdapter)
                .setMaxItemCount(5)
                .setOnItemClickListener(new PopHelper.OnItemClickListener<PopItem>() {
                    @Override
                    public void onItemClick(PopItem item, int position, PopSpinner popSpinner) {
                        popSpinner.setSelectText(item.getItemName());
                        Log.e(TAG, "item: " + item.toString());
                    }
                })
                .build();

        PopConfig popConfig = new PopConfig.Builder()
                .setPopAnimationStyle(R.style.PopTop2Bottom)
                .build();
        new PopHelper.Builder(this)
                .setPopSpinner(spinner3)
                .setPopConfig(popConfig)
                .setAdapter(itemAdapter)
                .setOnItemClickListener(new PopHelper.OnItemClickListener<PopItem>() {
                    @Override
                    public void onItemClick(PopItem item, int position, PopSpinner popSpinner) {
                        popSpinner.setSelectText(item.getItemName());
                        Log.e(TAG, "item: " + item.toString());
                    }
                })
                .build();
    }

    private void initDatas() {
        for (int i = 0; i < 9; i++) {
            popItems.add(new PopItem("item " + i, i));
        }
    }

    public void openPop(View view) {

    }

}
