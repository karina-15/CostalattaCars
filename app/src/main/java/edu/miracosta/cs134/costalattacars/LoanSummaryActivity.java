package edu.miracosta.cs134.costalattacars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracosta.cs134.costalattacars.model.CarLoan;

public class LoanSummaryActivity extends AppCompatActivity {
    // Instance variables
    // in activity_loan_summary.xml;
    private TextView monthlyPaymentTextView;
    private TextView carPriceTextView;
    private TextView salesTaxRateTextView;
    private TextView taxAmountTextView;
    private TextView downPaymentTextView;
    private TextView totalCostTextView;
    private TextView borrowedAmountTextView;
    private TextView interestAmountTextView;
    private TextView loanTermTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        // "Wire up" instance variables (initialize them)
        monthlyPaymentTextView = findViewById(R.id.monthlyPaymentTextView);
        carPriceTextView = findViewById(R.id.carPriceTextView);
        salesTaxRateTextView = findViewById(R.id.salesTaxRateTextView);
        taxAmountTextView = findViewById(R.id.taxAmountTextView);
        downPaymentTextView = findViewById(R.id.downPaymentTextView);
        totalCostTextView = findViewById(R.id.totalCostTextView);
        borrowedAmountTextView = findViewById(R.id.borrowedAmountTextView);
        interestAmountTextView = findViewById(R.id.interestAmountTextView);
        loanTermTextView = findViewById(R.id.loanTermTextView);

        // Receive the intent (from MainActivity)
        Intent intent = getIntent();

        // Populate the text views with the data from the carLoan mode
        monthlyPaymentTextView.setText(intent.getStringExtra("MonthlyPayment"));
        carPriceTextView.setText(intent.getStringExtra("CarPrice"));
        salesTaxRateTextView.setText(intent.getStringExtra("TaxRate"));
        taxAmountTextView.setText(intent.getStringExtra("TaxAmount"));
        downPaymentTextView.setText(intent.getStringExtra("DownPayment"));
        totalCostTextView.setText(intent.getStringExtra("TotalCost"));
        borrowedAmountTextView.setText(intent.getStringExtra("BorrowedAmount"));
        interestAmountTextView.setText(intent.getStringExtra("InterestAmount"));
        loanTermTextView.setText(intent.getStringExtra("LoanTerm"));
    }

    public void returnToMain(View v) {
        // Done with LoanSummaryActivity, so "finish" / terminate it
        finish();
    }

}
