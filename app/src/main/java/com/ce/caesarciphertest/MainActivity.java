package com.ce.caesarciphertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtOffset;
    private EditText mEtOriginalText;
    private Button mBtnCaesarCipher;
    private EditText mEtCipherText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

    }

    private void findViews() {
        mEtOffset = (EditText) findViewById(R.id.et_offset);
        mEtOriginalText = (EditText) findViewById(R.id.et_original_text);
        mBtnCaesarCipher = (Button) findViewById(R.id.btn_caesar_cipher);
        mEtCipherText = (EditText) findViewById(R.id.et_cipher_text);

        mBtnCaesarCipher.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnCaesarCipher) {
            String _StrOffset = mEtOffset.getText().toString();
            int _Offset;
            if (!TextUtils.isEmpty(_StrOffset)) {
                _Offset = Integer.parseInt(_StrOffset);
            } else {
                Toast.makeText(this, "Offset cannot null", Toast.LENGTH_SHORT).show();
                mEtOffset.requestFocus();
                return;
            }
            String _OriginalText = mEtOriginalText.getText().toString();
            if (!TextUtils.isEmpty(_OriginalText)) {
                String _CipherText = caesarCipher(_Offset, _OriginalText);
                mEtCipherText.setText(_CipherText);
            } else {
                Toast.makeText(this, "Original Text cannot null", Toast.LENGTH_SHORT).show();
                mEtOriginalText.requestFocus();
                return;
            }
        }
    }

    private static String caesarCipher(int pOffset, String pOriginalText) {
        StringBuilder _CipherText = new StringBuilder();
        char[] OriginallTextArr = pOriginalText.toCharArray();
        for (int i = 0; i < OriginallTextArr.length; i++) {
            int temp = OriginallTextArr[i] + pOffset;
            char ciphertext = (char) temp;
            _CipherText.append(ciphertext);
        }
        return _CipherText.toString();
    }

}
