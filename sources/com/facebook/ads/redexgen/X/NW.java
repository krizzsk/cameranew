package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
@TargetApi(19)
/* loaded from: assets/audience_network.dex */
public final class NW extends LinearLayout {
    public static byte[] A0A;
    public static String[] A0B = {"knq4crm7fvqQP", "POuWJNR6FFtqsTvB6KeDXgsqVDDrfXB5", "10LYd3PkBnL3JTlwXO74lkb8laVhyfxM", "yGvyB2PsIdOlgSHN7xWAdIyeKrkcUuSJ", "30OsfDGqNeLBXhmKwxFpv8WuoKRgKdOB", "v4mwmIuaROl", "LuFvPWZsJ2RrZ", "py7QobRXpH9AZVstdVJJOkEIejHuBaN9"};
    public static final int A0C;
    public static final int A0D;
    public static final Uri A0E;
    public static final View.OnTouchListener A0F;
    @Nullable
    public ImageView A00;
    public ImageView A01;
    @Nullable
    public ImageView A02;
    public ImageView A03;
    public NV A04;
    public C1037Nc A05;
    public String A06;
    public boolean A07;
    public final WebView A08;
    public final InterfaceC1040Nf A09;

    public static String A05(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = (byte) ((copyOfRange[i5] ^ i4) ^ 39);
            String[] strArr = A0B;
            if (strArr[3].charAt(13) == strArr[1].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[6] = "2vQcPj1ELj1bu";
            strArr2[0] = "7aOELiI6quiDs";
            copyOfRange[i5] = b;
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0A = new byte[]{80, 115, 113, 121, 27, 52, 55, 43, 61, 39, 14, 19, 22, 0, 19, 5, 14, 49, 36, 47, 97, 47, 32, 53, 40, 55, 36, 97, 35, 51, 46, 54, 50, 36, 51, 5, 6, 11, 17, 16, 94, 6, 8, 5, 10, 15, 18, 29, 23, 1, 28, 26, 23, 93, 26, 29, 7, 22, 29, 7, 93, 18, 16, 7, 26, 28, 29, 93, 37, 58, 54, 36, 27, 23, 21, 86, 25, 22, 28, 10, 23, 17, 28, 86, 27, 16, 10, 23, 21, 29, 80, 76, 76, 72, 2, 23, 23, 79, 79, 79, 22, 94, 89, 91, 93, 90, 87, 87, 83, 22, 91, 87, 85};
    }

    static {
        A07();
        A0C = Color.rgb(224, 224, 224);
        A0E = Uri.parse(A05(90, 23, 31));
        A0F = new NQ();
        A0D = Color.argb(34, 0, 0, 0);
    }

    public NW(XT xt, WebView webView) {
        super(xt);
        this.A09 = new C1176Sn(this);
        this.A08 = webView;
        this.A07 = JE.A06(xt);
        A08(xt);
    }

    private void A08(XT xt) {
        int i2 = (int) (50.0f * getResources().getDisplayMetrics().density);
        M5.A0M(this, -1);
        setGravity(16);
        this.A01 = new ImageView(xt);
        this.A01.setContentDescription(A05(4, 5, 127));
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        this.A01.setScaleType(ImageView.ScaleType.CENTER);
        this.A01.setImageBitmap(ME.A01(MD.BROWSER_CLOSE));
        this.A01.setOnTouchListener(A0F);
        this.A01.setOnClickListener(new NR(this));
        addView(this.A01, layoutParams);
        if (this.A07) {
            this.A00 = new ImageView(xt);
            this.A00.setEnabled(false);
            this.A00.setAlpha(0.3f);
            this.A00.setContentDescription(A05(0, 4, 53));
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i2, i2);
            this.A00.setScaleType(ImageView.ScaleType.CENTER);
            this.A00.setImageBitmap(ME.A01(MD.BACK_ARROW));
            this.A00.setOnTouchListener(A0F);
            this.A00.setOnClickListener(new NS(this));
            addView(this.A00, layoutParams2);
        }
        this.A05 = new C1037Nc(xt);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = this.A07 ? 0.5f : 1.0f;
        this.A05.setGravity(17);
        addView(this.A05, layoutParams3);
        if (this.A07) {
            this.A02 = new ImageView(xt);
            this.A02.setEnabled(false);
            this.A02.setAlpha(0.3f);
            this.A02.setContentDescription(A05(9, 7, 70));
            ViewGroup.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
            this.A02.setScaleType(ImageView.ScaleType.CENTER);
            this.A02.setImageBitmap(ME.A02(MD.BACK_ARROW));
            this.A02.setOnTouchListener(A0F);
            this.A02.setOnClickListener(new NT(this));
            addView(this.A02, layoutParams4);
        }
        this.A03 = new ImageView(xt);
        ViewGroup.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(i2, i2);
        this.A03.setContentDescription(A05(16, 19, 102));
        this.A03.setScaleType(ImageView.ScaleType.CENTER);
        this.A03.setOnTouchListener(A0F);
        this.A03.setOnClickListener(new NU(this, xt));
        addView(this.A03, layoutParams5);
        setupDefaultNativeBrowser(xt);
    }

    public InterfaceC1040Nf getBrowserNavigationListener() {
        return this.A09;
    }

    public void setListener(NV nv) {
        this.A04 = nv;
    }

    public void setTitle(String str) {
        this.A05.setTitle(str);
    }

    public void setUrl(String str) {
        this.A06 = str;
        if (TextUtils.isEmpty(str) || A05(35, 11, 67).equals(str)) {
            this.A05.setSubtitle(null);
            this.A03.setEnabled(false);
            this.A03.setColorFilter(new PorterDuffColorFilter(A0C, PorterDuff.Mode.SRC_IN));
            return;
        }
        this.A05.setSubtitle(str);
        this.A03.setEnabled(true);
        this.A03.setColorFilter((ColorFilter) null);
    }

    private void setupDefaultNativeBrowser(XT xt) {
        Bitmap A01;
        List<ResolveInfo> queryIntentActivities = xt.getPackageManager().queryIntentActivities(new Intent(A05(46, 26, 84), A0E), 65536);
        if (queryIntentActivities.size() == 0) {
            this.A03.setVisibility(8);
            A01 = null;
        } else {
            if (queryIntentActivities.size() == 1) {
                if (A05(72, 18, 95).equals(queryIntentActivities.get(0).activityInfo.packageName)) {
                    MD md = MD.BROWSER_LAUNCH_CHROME;
                    if (A0B[5].length() == 31) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0B;
                    strArr[6] = "ER9o4D5KfsgKq";
                    strArr[0] = "PVCMoHz4n3Ffn";
                    A01 = ME.A01(md);
                }
            }
            A01 = ME.A01(MD.BROWSER_LAUNCH_NATIVE);
        }
        this.A03.setImageBitmap(A01);
    }
}
