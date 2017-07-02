package jp.techacademy.takashi.nagamoto.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TimePicker.OnTimeChangedListener {

    TextView mTextView;
    int hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //時間の初期化
        hour = 0;

        //ボタン
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        //テキスト
        mTextView = (TextView) findViewById(R.id.textView);

        //TimePicker
        TimePicker timePicker= (TimePicker) findViewById(R.id.timePicker);
        //TimePickerを24時間表示に変更
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(this);

    }

    //TimePickerの時間が変更された時
    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute){
        //時間を保存
        hour = hourOfDay;
    }

    //ボタンが押された時の処理
    @Override
    public void onClick(View v) {
        if(hour >= 2 && hour <= 9){
            mTextView.setText("おはよう");
        }
        else if(hour >= 10 && hour <= 17){
            mTextView.setText("こんにちは");
        }
        else{
            mTextView.setText("こんばんは");
        }
    }
}
