package com.example.dialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.security.keystore.StrongBoxUnavailableException;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

import kotlin.text.UStringsKt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);

        btn1.setOnClickListener(v->alertdialog());
        btn2.setOnClickListener(v->listdialog());
        btn3.setOnClickListener(v->showdatedialog());
    }

    private void alertdialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("prosty alert dialog");
        builder.setMessage("to jest wiadomość alert dialog");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "kliknięto ok", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("anuluj", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "kliknięto anuluj", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
    private void listdialog() {
        final String[] items = {"opcja 1", "opcja 2", "opcja 3", "opcja 4", "opcja 5"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("wybierz opcję:");

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MainActivity.this, "wybrano: "
                    + items[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();


        };
        private void showdatedialog() {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog =
                    new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            Toast.makeText(MainActivity.this, "Wybrana data:"
                                    + dayOfMonth + "/" + (month + 1)
                                    + "/" + year, Toast.LENGTH_SHORT).show();
                        }
                    }, year,  month, day);

            datePickerDialog.show();
        }
    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this,
                        "Wybrana godzina" + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
            }
        }, hour, minute , true);

        timePickerDialog.show();
    }
    private void showCustomDialog() {
            final android.app.Dialog dialog = new android.app.Dialog(this);
            dialog.setContentView(R.layout.custom_dialog);

        dialog.findViewById(R.id.button5);
        button btnSubmit = setOnClickListener(View.OnClickListener(); {
                @Override
                        public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "wysłano", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
        });
        dialog.show();
    }
}

