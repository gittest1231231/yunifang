package bw.ynifang.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import bw.ynifang.R;

public class Welcome2 extends AppCompatActivity {
    private int i=4;
    private Button welcomeBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome2);
        welcomeBt = (Button) findViewById(R.id.welcom_bt);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        welcomeBt.setText("跳过"+(i--)+"s");
                        if (i<0){
                            welcomeBt.setVisibility(View.INVISIBLE);
                            Intent intent = new Intent(Welcome2.this, DaoHang.class);
                            startActivity(intent);
                            timer.cancel();
                            finish();
                        }

                    }
                });
            }
        },0,1000);
    }
}
