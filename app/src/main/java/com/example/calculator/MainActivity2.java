package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity2 extends AppCompatActivity {
    private long pressTime;
    public String expr ="";
    TextView text_result,text_insert;
    ImageButton backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();// to hide title bar.

        text_insert =findViewById(R.id.insert);
        text_result =findViewById(R.id.result);
        backspace = findViewById(R.id.backspace);

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String val = text_insert.getText().toString();
                if(expr.length()>=1){
                    expr = expr.substring(0,expr.length()-1);
                    text_insert.setText(expr);
                    if(expr.length()<=0){
                        text_insert.setText("0");
                    }
                }
                else{
                    Toast.makeText(MainActivity2.this, "Nothing to Delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
//double tap to exit
    public void onBackPressed(){
        if(pressTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            finish();
        }
        else{
            Toast.makeText(this, "Press back again to exit",Toast.LENGTH_SHORT).show();
        }
        pressTime = System.currentTimeMillis();
    }

    public void updateTv(char c){
        expr = expr + c;
        text_insert.setText(expr);
    }

    public void fun7(View view){updateTv('7');}
    public void fun8(View view){updateTv('8');}
    public void fun9(View view){updateTv('9');}
    public void fun4(View view){updateTv('4');}
    public void fun5(View view){updateTv('5');}
    public void fun6(View view){updateTv('6');}
    public void fun1(View view){updateTv('1');}
    public void fun2(View view){updateTv('2');}
    public void fun3(View view){updateTv('3');}
    public void fun00(View view){updateTv('0');}
    public void fun0(View view){updateTv('0');}
    public void funPoint(View view){updateTv('.');}
    public void fun_Div(View view){updateTv('/');}
    public void fun_Mul(View view){updateTv('*');}
    public void fun_Add(View view){updateTv('+');}
    public void fun_Sub(View view){updateTv('-');}
    public void fun_mod(View view){updateTv('%');}
    //public void fun_back(View view){updateTv('');}
    public void funAC(View view){
        expr =" ";
        text_insert.setText(expr);
        text_result.setText(expr);
    }

    public void funEqual(View view){
        Expression ex = new ExpressionBuilder(expr).build();
        Double res = ex.evaluate();
        String s1 = Double.toString(res);
        text_result.setText(s1);
    }

}

