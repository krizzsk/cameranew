package com.pinguo.album.opengles;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;
/* compiled from: StringTexture.java */
/* loaded from: classes3.dex */
public class t extends d {
    private final a v;
    private final TextPaint w;

    private t(a aVar, TextPaint textPaint, int i2, int i3) {
        super(i2, i3);
        this.v = aVar;
        this.w = textPaint;
    }

    public static TextPaint J(float f2, int i2, boolean z) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f2);
        textPaint.setAntiAlias(true);
        textPaint.setColor(i2);
        if (z) {
            textPaint.setShadowLayer(2.0f, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        }
        return textPaint;
    }

    public static t K(String str, float f2, int i2) {
        return M(str, J(f2, i2, true));
    }

    public static t L(String str, float f2, int i2, boolean z) {
        return M(str, J(f2, i2, z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
        if (r1 > r5) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.pinguo.album.opengles.t M(java.lang.String r10, android.text.TextPaint r11) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 10
            r2 = 0
            int r3 = r10.indexOf(r1, r2)
            r4 = 1
            if (r3 >= 0) goto L1e
            float r1 = r11.measureText(r10)
            double r1 = (double) r1
            double r1 = java.lang.Math.ceil(r1)
            int r1 = (int) r1
            r0.add(r10)
            r3 = 1
            goto L6b
        L1e:
            r6 = r3
            r3 = 0
            r5 = 0
        L21:
            r7 = -1
            if (r6 == r7) goto L49
            int r3 = r3 + 1
            java.lang.String r2 = r10.substring(r2, r6)
            r0.add(r2)
            float r2 = r11.measureText(r2)
            double r8 = (double) r2
            double r8 = java.lang.Math.ceil(r8)
            int r2 = (int) r8
            if (r2 <= r5) goto L3a
            r5 = r2
        L3a:
            int r2 = r6 + 1
            int r6 = r10.length()
            if (r2 < r6) goto L44
            r6 = -1
            goto L21
        L44:
            int r6 = r10.indexOf(r1, r2)
            goto L21
        L49:
            int r1 = r10.length()
            int r1 = r1 - r4
            if (r2 >= r1) goto L6a
            int r3 = r3 + 1
            int r1 = r10.length()
            java.lang.String r10 = r10.substring(r2, r1)
            r0.add(r10)
            float r10 = r11.measureText(r10)
            double r1 = (double) r10
            double r1 = java.lang.Math.ceil(r1)
            int r1 = (int) r1
            if (r1 <= r5) goto L6a
            goto L6b
        L6a:
            r1 = r5
        L6b:
            android.graphics.Paint$FontMetricsInt r10 = r11.getFontMetricsInt()
            int r2 = r10.bottom
            int r10 = r10.top
            int r2 = r2 - r10
            int r2 = r2 * r3
            if (r1 > 0) goto L79
            r1 = 1
        L79:
            if (r2 > 0) goto L7c
            goto L7d
        L7c:
            r4 = r2
        L7d:
            com.pinguo.album.opengles.t r10 = new com.pinguo.album.opengles.t
            com.pinguo.album.opengles.t$a r2 = new com.pinguo.album.opengles.t$a
            r2.<init>(r0)
            r10.<init>(r2, r11, r1, r4)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.album.opengles.t.M(java.lang.String, android.text.TextPaint):com.pinguo.album.opengles.t");
    }

    @Override // com.pinguo.album.opengles.d
    protected void I(Canvas canvas, Bitmap bitmap) {
        Paint.FontMetricsInt fontMetricsInt = this.w.getFontMetricsInt();
        canvas.translate(0.0f, -fontMetricsInt.top);
        int i2 = 0;
        if (!this.v.e()) {
            for (String str : this.v.d()) {
                canvas.drawText(str, 0.0f, i2, this.w);
                i2 += fontMetricsInt.bottom - fontMetricsInt.top;
            }
            return;
        }
        int i3 = 0;
        while (i2 < this.v.a()) {
            int intValue = this.v.c().get(i2).intValue();
            this.w.setColor(this.v.b().get(i2).intValue());
            this.w.setTextSize(intValue);
            canvas.drawText(this.v.d().get(i2), 0.0f, i3, this.w);
            Paint.FontMetricsInt fontMetricsInt2 = this.w.getFontMetricsInt();
            i3 += fontMetricsInt2.bottom - fontMetricsInt2.top;
            i2++;
        }
    }

    /* compiled from: StringTexture.java */
    /* loaded from: classes3.dex */
    public static class a {
        private List<String> a;
        private List<Integer> b;
        private List<Integer> c;

        public a() {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = new ArrayList();
        }

        public int a() {
            return this.a.size();
        }

        public List<Integer> b() {
            return this.c;
        }

        public List<Integer> c() {
            return this.b;
        }

        public List<String> d() {
            return this.a;
        }

        public boolean e() {
            return this.c.size() > 0 && this.b.size() > 0 && this.b.size() == this.c.size() && this.b.size() == this.a.size();
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return aVar.d().equals(d()) && aVar.b().equals(b()) && aVar.c().equals(c());
            }
            return false;
        }

        a(List<String> list) {
            this.a = list;
            this.b = new ArrayList();
            this.c = new ArrayList();
        }
    }
}
