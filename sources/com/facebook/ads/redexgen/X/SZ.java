package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class SZ extends O4 implements View.OnClickListener {
    public static byte[] A0B;
    public static String[] A0C = {"idQnrwKrPQs0c3zYYHT6WTvW1aXoRMqQ", "Gekt1WHQiHnIJqxdwB9j8FzDtIJy1cfJ", "sF2V", "CdtBVDHmuEaNC9R8", "jtmNaJ8NDkAfiILRFeCM3WK", "aXO2Ks7stxeTyHMnCxwSATKtkmhK3bmt", "xmLEl9t0StR", ""};
    public static final int A0D;
    public int A00;
    public int A01;
    @Nullable
    public Bitmap A02;
    @Nullable
    public Paint A03;
    @Nullable
    public Rect A04;
    public XT A05;
    @Nullable
    public String A06;
    @Nullable
    public String A07;
    public boolean A08;
    public final O1 A09;
    public final Map<String, String> A0A;

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = copyOfRange[i5] ^ i4;
            if (A0C[2].length() != 4) {
                throw new RuntimeException();
            }
            A0C[3] = "DG";
            copyOfRange[i5] = (byte) (i6 ^ 83);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0B = new byte[]{6, 2, 77, Draft_75.CR, 5, 19, 19, 5, 14, 7, 5, 18};
    }

    static {
        A06();
        A0D = (int) (LY.A00 * 24.0f);
    }

    public SZ(XT xt, String str, C1I c1i, JT jt, MU mu, QZ qz, C1009Lz c1009Lz) {
        this(xt, str, c1i, false, jt, mu, qz, c1009Lz);
    }

    public SZ(XT xt, String str, C1I c1i, boolean z, JT jt, MU mu, QZ qz, C1009Lz c1009Lz) {
        super(xt, c1i);
        this.A0A = new HashMap();
        this.A05 = xt;
        this.A08 = z;
        this.A09 = new O1(xt, str, qz, c1009Lz, jt, mu);
        setOnClickListener(this);
        M5.A0G(1001, this);
    }

    @Nullable
    public static Bitmap A03(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private void A05() {
        String str;
        if (this.A08 && (str = this.A07) != null) {
            this.A02 = A03(ME.A03(this.A05, str.contains(A04(0, 12, 51)) ? MD.MESSENGER : MD.WHATSAPP));
            this.A03 = new Paint();
            int i2 = A0D;
            setPadding(i2, 0, i2, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.A06) && !TextUtils.isEmpty(this.A07)) {
                this.A09.A08(this.A06, this.A07, this.A0A);
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Bitmap bitmap = this.A02;
        if (bitmap != null) {
            this.A04 = new Rect(0, 0, bitmap.getWidth(), this.A02.getHeight());
            this.A01 = this.A02.getWidth();
            this.A00 = 12;
            canvas.save();
            canvas.translate((this.A01 + this.A00) / 2, 0.0f);
        }
        super.onDraw(canvas);
        if (this.A02 != null) {
            int width = (int) ((((getWidth() / 2.0f) - ((getPaint().measureText((String) getText()) + 10.0f) / 2.0f)) - this.A01) - this.A00);
            int i2 = this.A01;
            int height = (getHeight() / 2) - (i2 / 2);
            int top = width + i2;
            Rect destRect = new Rect(width, height, top, i2 + height);
            canvas.drawBitmap(this.A02, this.A04, destRect, this.A03);
            canvas.restore();
        }
    }

    public void setCta(C1J c1j, String str, Map<String, String> map) {
        setCta(c1j, str, map, null);
    }

    public void setCta(C1J c1j, String str, Map<String, String> map, @Nullable O0 o0) {
        this.A06 = str;
        this.A07 = c1j.A05();
        Map<String, String> extraData = this.A0A;
        extraData.putAll(map);
        this.A09.A07(o0);
        String A04 = c1j.A04();
        if (TextUtils.isEmpty(A04) || TextUtils.isEmpty(this.A07)) {
            setVisibility(8);
            return;
        }
        setText(A04);
        A05();
    }

    public void setIsInAppBrowser(boolean z) {
        this.A09.A09(z);
    }
}
