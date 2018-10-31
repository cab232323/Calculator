package com.example.mechrevo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String str1 = "";
    private String str2 = "";
    private String sym ="";
    private TextView text ;
    private Button acc =null;
    private Button symbol = null;
    private Button percent = null;
    private Button division = null;
    private Button nine = null;
    private Button eight = null;
    private Button seven = null;
    private Button six = null;
    private Button five = null;
    private Button four = null;
    private Button three = null;
    private Button two = null;
    private Button one = null;
    private Button multiply = null;
    private Button minus = null;
    private Button add = null;
    private Button zero = null;
    private Button equal = null;
    final String TAG="出错了";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        symbol = (Button) findViewById(R.id.symbol);
        percent = (Button) findViewById(R.id.percent);
        division = (Button) findViewById(R.id.division);
        nine = (Button) findViewById(R.id.nine);
        eight = (Button) findViewById(R.id.eight);
        seven = (Button) findViewById(R.id.seven);
        six = (Button) findViewById(R.id.six);
        five = (Button) findViewById(R.id.five);
        four = (Button) findViewById(R.id.four);
        three = (Button) findViewById(R.id.three);
        two = (Button) findViewById(R.id.two);
        one = (Button) findViewById(R.id.one);
        multiply = (Button) findViewById(R.id.multiply);
        minus = (Button) findViewById(R.id.minus);
        add = (Button) findViewById(R.id.add);
        zero = (Button) findViewById(R.id.zero);
        equal = (Button) findViewById(R.id.equal);
        text=(TextView) findViewById(R.id.text);
        acc=(Button) findViewById(R.id.ac);
        acc.setOnClickListener(listener);
        nine.setOnClickListener(listener);
        eight.setOnClickListener(listener);
        seven.setOnClickListener(listener);
        six.setOnClickListener(listener);
        five.setOnClickListener(listener);
        four.setOnClickListener(listener);
        three.setOnClickListener(listener);
        two.setOnClickListener(listener);
        one.setOnClickListener(listener);
        zero.setOnClickListener(listener);
        division.setOnClickListener(listener);
        add.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        multiply.setOnClickListener(listener);
        equal.setOnClickListener(listener);
    }
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ac: {
                text.setText("0");
                str1="";
                str2="";
                sym="";
            }
            break;
            case R.id.minus:{
                if(str2==""){
                    sym="-";
                }
                else{
                    result();
                    sym="-";
                }
            }
            break;
            case R.id.multiply:{
                if(str2==""){
                    sym="*";
                }
                else{
                    result();
                    sym="*";
                }
            }
            break;
            case R.id.division:{
                if(str2==""){
                    sym="/";
                }
                else{
                    result();
                    sym="/";
                }
            }
            break;
            case R.id.add: {
                if(str2==""){
                    sym="+";
                }
                else{
                    result();
                    sym="+";
                }
            }
            break;
            case R.id.equal:{
                result();
            }
            break;
            case R.id.nine:{
                num(9);
            }
            break;
            case R.id.eight:{
                num(8);
            }
            break;
            case R.id.seven:{
                num(7);
            }
            break;
            case R.id.six:{
                num(6);
            }
            break;
            case R.id.five:{
                num(5);
            }
            break;
            case R.id.four:{
                num(4);
            }
            break;
            case R.id.three:{
                num(3);
            }
            break;
            case R.id.two:{
                num(2);
            }
            break;
            case R.id.one:{
                num(1);
            }
            break;
            case R.id.zero:{
                num(0);
            }
            break;
        }
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.v("监听处","到此处！");
            onViewClicked(view);
        }
    };
    public void num(int num){
        if(sym==""){
            str1=str1+num;
            Log.w("Str1的值",str1);
            Log.w("Str2的值",str2);
            text.setText(str1);

        }
        else{
            str2=str2+num;
            Log.w("Str1的值",str1);
            Log.w("Str2的值",str2);
            text.setText(str2);
        }
    }
    public void result(){
        switch (sym){
            case ("+"):{
                double d1 = Double.parseDouble(str1) ;
                double d2 = Double.parseDouble(str2) ;
                text.setText(""+(d1+d2));
                str1=""+(d1+d2);
                str2="";
            }
            break;
            case ("-"):{
                double d1 = Double.parseDouble(str1) ;
                double d2 = Double.parseDouble(str2) ;
                text.setText(""+(d1-d2));
                str1=""+(d1-d2);
                str2="";
            }
            break;
            case ("*"):{
                double d1 = Double.parseDouble(str1) ;
                double d2 = Double.parseDouble(str2) ;
                text.setText(""+(d1*d2));
                str1=""+(d1*d2);
                str2="";
            }
            break;
            case ("/"):{
                double d1 = Double.parseDouble(str1) ;
                double d2 = Double.parseDouble(str2) ;
                text.setText(""+(d1/d2));
                str1=""+(d1/d2);
                str2="";
            }
            break;
        }
    }

}
