package edu.miracosta.cs134.costalattacars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracosta.cs134.costalattacars.model.CarLoan;

public class MainActivity extends AppCompatActivity {

    // Instance Variables to connect the Controller with the View
    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioGroup loanTermRadioGroup;

    private CarLoan carLoan;
    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wire up views
        carPriceEditText = findViewById(R.id.carPriceEditText);
        downPaymentEditText = findViewById(R.id.downPaymentEditText);
        loanTermRadioGroup = findViewById(R.id.loanTermRadioGroup);

    }

    public void generateReport(View v) {

        // Extract the data from the intent
        double carPrice, downPayment;
        int loanTerm;
        /*Intent intent = getIntent();

        // can make strings as constants for all keys to avoid typos
        carPrice = intent.getDoubleExtra("CarPrice", 0.0);
        downPayment = intent.getDoubleExtra("DownPayment", 0.0);
        loanTerm = intent.getIntExtra("LoanTerm", 5);*/

        // Let's send the data to the Model (CarLoan.java)
        carLoan = new CarLoan();


        // parse to double and toString
        carPrice = Double.parseDouble(carPriceEditText.getText().toString());
        downPayment = Double.parseDouble(downPaymentEditText.getText().toString());

        // Let's make a decision to which radio button is selected
        switch (loanTermRadioGroup.getCheckedRadioButtonId())
        {
            case R.id.threeYearsRadioButton:
                loanTerm = 3;
                break;
            case R.id.fourYearsRadioButton:
                loanTerm = 4;
                break;
            default:
                loanTerm = 5;
                break;
        }

        carLoan.setPrice(carPrice);
        carLoan.setDownPayment(downPayment);
        carLoan.setLoanTerm(loanTerm);

        // Let's instantiate the Intent and navigate to LoanSummaryActivity
        // Intent intent = new Intent(this, LoanSummaryActivity.class);
        Intent intent = new Intent(this, LoanSummaryActivity.class);
        // Put data into Intent
        intent.putExtra("MonthlyPayment", currency.format(carLoan.monthlyPayment()));
        intent.putExtra("CarPrice", currency.format(carPrice));
        intent.putExtra("TaxRate", (CarLoan.OCEANSIDE_TAX_RATE * 100.0) + "%");
        intent.putExtra("TaxAmount", currency.format(carLoan.taxAmount()));
        intent.putExtra("DownPayment", currency.format(downPayment));
        intent.putExtra("TotalCost", currency.format(carLoan.totalCost()));
        intent.putExtra("BorrowedAmount", currency.format(carLoan.borrowedAmount()));
        intent.putExtra("InterestAmount", currency.format(carLoan.interestAmount()));
        intent.putExtra("LoanTerm", loanTerm + " years");
        // Fire off the Intent
        startActivity(intent);
    }
}
