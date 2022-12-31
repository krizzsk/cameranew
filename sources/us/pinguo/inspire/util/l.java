package us.pinguo.inspire.util;

import android.widget.TextView;
import java.math.BigDecimal;
import java.text.NumberFormat;
/* compiled from: DistanceUtils.java */
/* loaded from: classes9.dex */
public class l {
    public static String a(int i2) {
        if (i2 < 100) {
            return "<100m";
        }
        if (i2 >= 100 && i2 < 1000) {
            return i2 + "m";
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        BigDecimal scale = new BigDecimal(i2).divide(new BigDecimal(1000)).setScale(1, 4);
        return numberFormat.format(scale) + "km";
    }

    public static void b(TextView textView, int i2) {
        textView.setText(a(i2));
    }
}
