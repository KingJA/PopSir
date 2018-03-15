package sample.kingja.popsir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openPop(View view) {
        Button btn = findViewById(R.id.btn);
        ListPop listPop = new ListPop(this);
        listPop.showAsDropDown(btn);
    }
}
