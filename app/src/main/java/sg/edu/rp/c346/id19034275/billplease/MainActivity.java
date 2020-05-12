package sg.edu.rp.c346.id19034275.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText enterAmount,enterDiscount,enterPax;
    TextView tvTotal,getTvEachpay;//tvOutput;
    Button tgReset;
    ToggleButton tgSPLIT,tgSVS,tgGST;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAmount=(EditText) findViewById(R.id.editInputAmount);
        enterPax=(EditText)findViewById(R.id.editInputNumPax);
        enterDiscount=(EditText) findViewById(R.id.etDiscount);

        tvTotal=(TextView)findViewById(R.id.tvTotal);
        getTvEachpay=(TextView)findViewById(R.id.tvPay);

        tgReset=(Button) findViewById(R.id.btnReset);

        tgSPLIT=(ToggleButton) findViewById(R.id.btnSplit);
        tgSVS=(ToggleButton) findViewById(R.id.tbSVS);
        tgGST=(ToggleButton) findViewById(R.id.tbGST);


        tgSPLIT.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                if(enterAmount.getText().toString().trim().length()==0){
                    return;
                }
                if (enterPax.getText().toString().trim().length() == 0) {
                    return;
                }
                double amount= Double.parseDouble(enterAmount.getText().toString().trim());
                if(tgSVS.isChecked()&&tgGST.isChecked()){
                    amount=amount*1.17;

                }else if(tgSVS.isChecked()&&!tgGST.isChecked()){
                    amount=amount*1.1;
                }
                else if(!tgSVS.isChecked()&&tgGST.isChecked()){
                    amount=amount*1.07;
                }

                if(enterDiscount.getText().toString().trim().length()>0){
                    double discount=Double.parseDouble(enterDiscount.getText().toString().trim());
                    amount=amount *(1-discount/100.0);
                }


                int pax=Integer.parseInt(enterPax.getText().toString().trim());


                tvTotal.setText("Total Bill  : $"+String.format("%.2f",amount));
                tvTotal.setTypeface(null, Typeface.BOLD);
                getTvEachpay.setText("Each Pays: $"+String.format("%.2f",amount/pax));
                getTvEachpay.setTypeface(null, Typeface.BOLD);


                tgReset.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        enterAmount.setText("");
                        enterPax.setText("");
                        enterDiscount.setText("");
                    }
                });




            }
        });










    }
}
