package edu.miracosta.cs134.costalattacars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracosta.cs134.costalattacars.model.CarLoan;

public class LoanSummaryActivity extends AppCompatActivity {

    private CarLoan carLoan;
    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        // Extract the data from the intent
        double carPrice, downPayment;
        int loanTerm;
        Intent intent = getIntent();

        // can make strings as constants for all keys to avoid typos
        carPrice = intent.getDoubleExtra("CarPrice", 0.0);
        downPayment = intent.getDoubleExtra("DownPayment", 0.0);
        loanTerm = intent.getIntExtra("LoanTerm", 5);

        // Let's send the data to the Model (CarLoan.java)
        carLoan = new CarLoan();
        carLoan.setPrice(carPrice);
        carLoan.setDownPayment(downPayment);
        carLoan.setLoanTerm(loanTerm);

        // Populate the text views with the data from the carLoan mode

    }

    public void returnToMain(View v) {
        // Done with LoanSummaryActivity, so "finish" / terminate it
        finish();
    }

}
