package com.example.niva.translation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TranslationActivity extends AppCompatActivity {
    private TranslationLogic logic = new TranslationLogic();
    private Button cmdStart, cmdCheck;
    private EditText txtAns;
    private TextView lblRight, lblWrong, lblQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        txtAns = (EditText)findViewById(R.id.txtAnswer);

        lblRight = (TextView)findViewById(R.id.lblRight);
        lblWrong = (TextView)findViewById(R.id.lblWrong);
        lblQuestion = (TextView)findViewById(R.id.lblQuestion);

        cmdStart = (Button)findViewById(R.id.cmdStart);
        cmdStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cmdStart.getText().toString().equals("Start"))
                    startGame();

                else
                    stopGame();
            }
        });

        cmdCheck = (Button)findViewById(R.id.cmdCheck);
        cmdCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(!logic.report(txtAns.getText().toString())){
                   Toast.makeText(getApplicationContext(), "wrong, the correct way is: " + logic.getAns(), Toast.LENGTH_LONG).show();
               }
                lblRight.setText("right: " + logic.getRight());
                lblWrong.setText("wrong: " + logic.getWrong());
                txtAns.setText("");
                lblQuestion.setText(logic.getNext()+"");
            }
        });
    }



    private void startGame() {
        cmdStart.setText("Stop");
        cmdCheck.setEnabled(true);
        lblQuestion.setText(logic.getNext()+"");

    }

    private void stopGame() {
        logic = new TranslationLogic();
        lblRight.setText("right: " + logic.getRight());
        lblWrong.setText("wrong: " + logic.getWrong());
        cmdStart.setText("Start");
        cmdCheck.setEnabled(false);
        lblQuestion.setText("");
        txtAns.setText("");
    }
}
