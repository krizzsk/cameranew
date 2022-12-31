package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.util.Arrays;
@TargetApi(19)
/* renamed from: com.facebook.ads.redexgen.X.Nc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1037Nc extends LinearLayout {
    public static byte[] A04;
    public static String[] A05 = {"c3XyMVVK2ZPeOt0e4CLBNBDbK", "DsCUYZfHfFO6YC0ZUz1", "eLhkJXERmPgt", "", "", "5cC1cV814bBflaO82eB2FX5nm", "", "kS5kSd3yRJfI"};
    public Drawable A00;
    public TextView A01;
    public TextView A02;
    public final XT A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 119);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        byte[] bArr = {7, 27, 27, 31, 28};
        if (A05[4].length() != 0) {
            throw new RuntimeException();
        }
        A05[1] = "lhzBP3Bo4mEfv1CoOUdrfuIGeogVZlJ";
        A04 = bArr;
    }

    static {
        A02();
    }

    public C1037Nc(XT xt) {
        super(xt);
        this.A03 = xt;
        A01();
    }

    private void A01() {
        float f2 = getResources().getDisplayMetrics().density;
        setOrientation(1);
        this.A02 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.A02.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.A02.setTextSize(2, 20.0f);
        this.A02.setEllipsize(TextUtils.TruncateAt.END);
        this.A02.setSingleLine(true);
        this.A02.setVisibility(8);
        addView(this.A02, layoutParams);
        this.A01 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.A01.setAlpha(0.5f);
        this.A01.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.A01.setTextSize(2, 15.0f);
        this.A01.setCompoundDrawablePadding((int) (5.0f * f2));
        this.A01.setEllipsize(TextUtils.TruncateAt.END);
        this.A01.setSingleLine(true);
        this.A01.setVisibility(8);
        addView(this.A01, layoutParams2);
    }

    private Drawable getPadlockDrawable() {
        if (this.A00 == null) {
            this.A00 = ME.A03(this.A03, MD.BROWSER_PADLOCK);
        }
        return this.A00;
    }

    public void setSubtitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.A01.setText((CharSequence) null);
            this.A01.setVisibility(8);
            return;
        }
        Uri parse = Uri.parse(str);
        this.A01.setText(parse.getHost());
        this.A01.setCompoundDrawablesRelativeWithIntrinsicBounds(A00(0, 5, 24).equals(parse.getScheme()) ? getPadlockDrawable() : null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.A01.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.A02.setText((CharSequence) null);
            String[] strArr = A05;
            if (strArr[6].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A05[4] = "";
            this.A02.setVisibility(8);
            return;
        }
        this.A02.setText(str);
        this.A02.setVisibility(0);
    }
}
