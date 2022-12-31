package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class NJ extends LinearLayout {
    public static final int A03 = (int) (LY.A00 * 40.0f);
    public static final int A04 = (int) (LY.A00 * 20.0f);
    public static final int A05 = (int) (LY.A00 * 10.0f);
    public final C2D A00;
    public final XT A01;
    public final N3 A02;

    public NJ(XT xt, C2D c2d, N3 n3, MD md) {
        this(xt, c2d, n3, null, md);
    }

    public NJ(XT xt, C2D c2d, N3 n3, @Nullable String str, MD md) {
        super(xt);
        this.A01 = xt;
        this.A00 = c2d;
        this.A02 = n3;
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (!TextUtils.isEmpty(str)) {
            View A01 = A01(str);
            A01.setPadding(0, 0, 0, 0);
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            M5.A0M(view, -10459280);
            addView(A01, layoutParams);
            addView(view);
        }
        if (!TextUtils.isEmpty(this.A00.A03())) {
            View A00 = A00(md, this.A00.A03());
            int i2 = A05;
            A00.setPadding(0, i2, 0, i2);
            addView(A00, layoutParams);
        }
        ViewGroup A02 = A02();
        A02.setPadding(0, A05, 0, 0);
        addView(A02, layoutParams);
    }

    private View A00(MD md, String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        int i2 = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 16;
        imageView.setImageBitmap(ME.A01(md));
        TextView textView = new TextView(getContext());
        M5.A0X(textView, true, 14);
        textView.setTextColor(-10459280);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        textView.setText(str);
        textView.setPadding(A05, 0, 0, 0);
        textView.setFocusable(true);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private View A01(String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        imageView.setImageBitmap(ME.A01(MD.BACK_ARROW));
        int i2 = A05;
        imageView.setPadding(0, i2, i2 * 2, i2);
        int i3 = A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        imageView.setOnClickListener(new NH(this));
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setText(str);
        M5.A0X(textView, true, 16);
        textView.setTextColor(-14934495);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, A03, 0);
        layoutParams2.gravity = 17;
        LinearLayout header = new LinearLayout(getContext());
        header.setOrientation(0);
        header.addView(imageView, layoutParams);
        header.addView(textView, layoutParams2);
        return header;
    }

    private ViewGroup A02() {
        NP np = new NP(this.A01);
        for (C2D c2d : this.A00.A05()) {
            N5 n5 = new N5(this.A01);
            n5.setData(c2d.A04(), null);
            n5.setOnClickListener(new NI(this, n5, c2d));
            np.addView(n5);
        }
        return np;
    }
}
