package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class second_screen extends AppCompatActivity {
    private ProgressBar prg;
    private Spinner spinner;
    private Button btnDangKy;
    private EditText edtHoTen, edtNgaySinh;
    private RadioButton rbNam, rbNu;
    private CheckBox cbVaoDoan, cbDongTien, cbTotNghiep;
    private FloatingActionButton fabDel;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        // spinner initialize
        spinner = findViewById(R.id.SpinerDanToc);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.DanToc, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerActivity());
        // ProgressBar
        prg = findViewById(R.id.progressBar);
        // radio btn
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        //edt text
        edtHoTen = findViewById(R.id.edtHoTen);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        //checkbox
        cbDongTien = findViewById(R.id.cbDongTien);
        cbVaoDoan = findViewById(R.id.cbVaoDoan);
        cbTotNghiep = findViewById(R.id.cbTotNghiep);
        //fab
        fabDel = findViewById(R.id.fabDel);
        fabDel.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator.ofFloat(fabDel, "rotation", 0f, 360f).setDuration(800).start();
                edtHoTen.setText("");
                edtNgaySinh.setText("");
                spinner.setSelection(0);
                prg.setProgress(0);
                rbNam.setChecked(true);
                cbDongTien.setChecked(false);
                cbTotNghiep.setChecked(false);
                cbVaoDoan.setChecked(false);
            }
        }));

        // btnDangKy
        btnDangKy = findViewById(R.id.btnDangKy);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            i = 0;
            CountDownTimer mCountDownTimer;
            mCountDownTimer=new CountDownTimer(3000,30) {
                // chạy progressBar 0 -> 100 trong 3s
                @Override
                public void onTick(long millisUntilFinished) {
                    i++;
                    prg.setProgress((int)i * 100 / (3000 / 30));

                }
                @Override
                public void onFinish() {
                    i++;
                    prg.setProgress(100);
                    // lay ho ten, ngay sinh
                    String hoTen = edtHoTen.getText().toString();
                    String ngaySinh = edtNgaySinh.getText().toString();
                    // lay gioi tinh
                    String gioiTinh = "";
                    if (rbNam.isChecked()) {
                        gioiTinh = "nam";
                    } else {
                        gioiTinh = "nữ";
                    }
                    //thong tin doan
                    String doan = "";
                    String totNghiep = "";
                    String dongTien = "";
                    if (cbDongTien.isChecked()) {
                        doan = ", đã vào Đoàn";
                    }
                    if (cbTotNghiep.isChecked()) {
                        totNghiep = ", đã tốt nghiệp";
                    }
                    if (cbDongTien.isChecked()) {
                        dongTien = ", đã đóng tiền";
                    }
                    String danToc = spinner.getSelectedItem().toString();
                    String result = "Họ tên: " + hoTen + ", ngày sinh: " + ngaySinh + ", giới tính: " + gioiTinh
                                    + doan + totNghiep + dongTien + ", " + danToc;
                    Toast.makeText(second_screen.this, result, Toast.LENGTH_LONG).show();
                }
            };
            mCountDownTimer.start();
            }
        });
    }

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }
}
