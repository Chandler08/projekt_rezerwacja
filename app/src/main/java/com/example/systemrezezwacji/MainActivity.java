package com.example.systemrezezwacji;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_TYPE = "EXTRA_TYPE";
    public static final String EXTRA_URGENT = "EXTRA_URGENT";

    private EditText etName;
    private Spinner spType;
    private CheckBox cbUrgent;
    private TextView tvStatus;

    private final ActivityResultLauncher<Intent> startSummary = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    tvStatus.setText("Status: Rezerwacja potwierdzona!");
                } else if (result.getResultCode() == RESULT_CANCELED) {
                    tvStatus.setText("Status: Rezerwacja anulowana.");
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        spType = findViewById(R.id.spType);
        cbUrgent = findViewById(R.id.cbUrgent);
        tvStatus = findViewById(R.id.tvStatus);
        Button btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();

            if (name.isEmpty()) {
                etName.setError("Pole nie może być puste!");
                return;
            }

            Intent intent = new Intent(this, SummaryActivity.class);
            intent.putExtra(EXTRA_NAME, name);
            intent.putExtra(EXTRA_TYPE, spType.getSelectedItem().toString());
            intent.putExtra(EXTRA_URGENT, cbUrgent.isChecked());

            startSummary.launch(intent);
        });
    }
}