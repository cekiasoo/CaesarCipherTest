package com.ce.caesarciphertest;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by CE on 2017/1/15.
 */

public class LimitInputFilter implements InputFilter {

    private int mMin, mMax;

    public LimitInputFilter(int pMin, int pMax) {
        this.mMin = pMin;
        this.mMax = pMax;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            int input = Integer.parseInt(dest.toString() + source.toString());
            if (isInRange(mMin, mMax, input))
                return null;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "";
    }

    private boolean isInRange(int a, int b, int c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}