package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ij  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0921Ij extends ImageView implements InterfaceC1095Pk {
    public static byte[] A05;
    public static String[] A06 = {"CZ6R6baQKTb1E5sAmpDqVkfMXF7zVnG4", "nQZGX73N3q5NRRZlZyP90gUTrDeeLYBu", "LfCM6PYFJNbwOvLH4thVDQon3h1Zk2zk", "bpUakkTElIOqaP65ISNG9oh", "gJtMODfbj2e7z8MJG7ZRKfD", "8rYwk9o7IGDDsMQbyUTj4ra1LUt9E6qX", "3WiLQHXTUUJ8WctEatoRQ", "Xo7nIXQ5hsw2R0tzDjIU8fyfjH4jtFIR"};
    public static final int A07;
    @Nullable
    public C1099Po A00;
    public final Paint A01;
    public final XT A02;
    public final C0937Jb A03;
    public final KM A04;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 19);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{101, 93, 92, 77, 8, 105, 76};
    }

    static {
        A06();
        A07 = (int) (LY.A00 * 4.0f);
    }

    public C0921Ij(XT xt, C0937Jb c0937Jb) {
        super(xt);
        this.A04 = new KM() { // from class: com.facebook.ads.redexgen.X.7c
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(KN kn) {
                C0921Ij.this.A09();
            }
        };
        this.A03 = c0937Jb;
        this.A02 = xt;
        this.A01 = new Paint();
        this.A01.setColor(-1728053248);
        setColorFilter(-1);
        int i2 = A07;
        setPadding(i2, i2, i2, i2);
        setContentDescription(A03(0, 7, 59));
        A05();
        setOnClickListener(new View$OnClickListenerC1109Py(this));
    }

    private void A04() {
        setImageBitmap(ME.A01(MD.SOUND_OFF));
    }

    private void A05() {
        setImageBitmap(ME.A01(MD.SOUND_ON));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A07() {
        C1099Po c1099Po = this.A00;
        if (c1099Po != null) {
            float volume = c1099Po.getVolume();
            String[] strArr = A06;
            if (strArr[5].charAt(12) == strArr[1].charAt(12)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[3] = "7LwdJMyLjSlNEKSwxkcw7Q3";
            strArr2[6] = "d5nTRpYYugpReKnwSxkEX";
            if (volume == 0.0f) {
                return true;
            }
        }
        return false;
    }

    public final void A09() {
        if (this.A00 == null) {
            return;
        }
        if (A07()) {
            A04();
        } else {
            A05();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1095Pk
    public final void A8f(C1099Po c1099Po) {
        this.A00 = c1099Po;
        C1099Po c1099Po2 = this.A00;
        if (c1099Po2 != null) {
            c1099Po2.getEventBus().A05(this.A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1095Pk
    public final void AF4(C1099Po c1099Po) {
        C1099Po c1099Po2 = this.A00;
        if (c1099Po2 != null) {
            c1099Po2.getEventBus().A06(this.A04);
        }
        this.A00 = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        canvas.drawCircle(width, height, Math.min(width, height), this.A01);
        super.onDraw(canvas);
    }
}
