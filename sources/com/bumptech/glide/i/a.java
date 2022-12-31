package com.bumptech.glide.i;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: AnimatedGifEncoder.java */
/* loaded from: classes.dex */
public class a {
    private int a;
    private int b;

    /* renamed from: d  reason: collision with root package name */
    private int f681d;

    /* renamed from: h  reason: collision with root package name */
    private OutputStream f685h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f686i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f687j;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f688k;

    /* renamed from: l  reason: collision with root package name */
    private int f689l;
    private byte[] m;
    private boolean u;
    private Integer c = null;

    /* renamed from: e  reason: collision with root package name */
    private int f682e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f683f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f684g = false;
    private boolean[] n = new boolean[256];
    private int o = 7;
    private int p = -1;
    private boolean q = false;
    private boolean r = true;
    private boolean s = false;
    private int t = 10;

    private void b() {
        byte[] bArr = this.f687j;
        int length = bArr.length;
        int i2 = length / 3;
        this.f688k = new byte[i2];
        c cVar = new c(bArr, length, this.t);
        this.m = cVar.h();
        int i3 = 0;
        while (true) {
            byte[] bArr2 = this.m;
            if (i3 >= bArr2.length) {
                break;
            }
            byte b = bArr2[i3];
            int i4 = i3 + 2;
            bArr2[i3] = bArr2[i4];
            bArr2[i4] = b;
            this.n[i3 / 3] = false;
            i3 += 3;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < i2) {
            byte[] bArr3 = this.f687j;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int g2 = cVar.g(bArr3[i6] & Draft_75.END_OF_FRAME, bArr3[i7] & Draft_75.END_OF_FRAME, bArr3[i8] & Draft_75.END_OF_FRAME);
            this.n[g2] = true;
            this.f688k[i5] = (byte) g2;
            i5++;
            i6 = i8 + 1;
        }
        this.f687j = null;
        this.f689l = 8;
        this.o = 7;
        Integer num = this.c;
        if (num != null) {
            this.f681d = c(num.intValue());
        } else if (this.u) {
            this.f681d = c(0);
        }
    }

    private int c(int i2) {
        if (this.m == null) {
            return -1;
        }
        int red = Color.red(i2);
        int green = Color.green(i2);
        int blue = Color.blue(i2);
        int i3 = 16777216;
        int length = this.m.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            byte[] bArr = this.m;
            int i6 = i4 + 1;
            int i7 = red - (bArr[i4] & Draft_75.END_OF_FRAME);
            int i8 = i6 + 1;
            int i9 = green - (bArr[i6] & Draft_75.END_OF_FRAME);
            int i10 = blue - (bArr[i8] & Draft_75.END_OF_FRAME);
            int i11 = (i7 * i7) + (i9 * i9) + (i10 * i10);
            int i12 = i8 / 3;
            if (this.n[i12] && i11 < i3) {
                i3 = i11;
                i5 = i12;
            }
            i4 = i8 + 1;
        }
        return i5;
    }

    private void e() {
        int width = this.f686i.getWidth();
        int height = this.f686i.getHeight();
        int i2 = this.a;
        if (width != i2 || height != this.b) {
            Bitmap createBitmap = Bitmap.createBitmap(i2, this.b, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
            this.f686i = createBitmap;
        }
        int i3 = width * height;
        int[] iArr = new int[i3];
        this.f686i.getPixels(iArr, 0, width, 0, 0, width, height);
        this.f687j = new byte[i3 * 3];
        this.u = false;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = iArr[i4];
            if (i7 == 0) {
                i5++;
            }
            byte[] bArr = this.f687j;
            int i8 = i6 + 1;
            bArr[i6] = (byte) (i7 & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((i7 >> 8) & 255);
            bArr[i9] = (byte) ((i7 >> 16) & 255);
            i4++;
            i6 = i9 + 1;
        }
        double d2 = (i5 * 100) / i3;
        this.u = d2 > 4.0d;
        if (Log.isLoggable("AnimatedGifEncoder", 3)) {
            Log.d("AnimatedGifEncoder", "got pixels for frame with " + d2 + "% transparent pixels");
        }
    }

    private void i() throws IOException {
        int i2;
        int i3;
        this.f685h.write(33);
        this.f685h.write(249);
        this.f685h.write(4);
        if (this.c != null || this.u) {
            i2 = 1;
            i3 = 2;
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i4 = this.p;
        if (i4 >= 0) {
            i3 = i4 & 7;
        }
        this.f685h.write(i2 | (i3 << 2) | 0 | 0);
        o(this.f683f);
        this.f685h.write(this.f681d);
        this.f685h.write(0);
    }

    private void j() throws IOException {
        this.f685h.write(44);
        o(0);
        o(0);
        o(this.a);
        o(this.b);
        if (this.r) {
            this.f685h.write(0);
        } else {
            this.f685h.write(this.o | 128);
        }
    }

    private void k() throws IOException {
        o(this.a);
        o(this.b);
        this.f685h.write(this.o | 240);
        this.f685h.write(0);
        this.f685h.write(0);
    }

    private void l() throws IOException {
        this.f685h.write(33);
        this.f685h.write(255);
        this.f685h.write(11);
        p("NETSCAPE2.0");
        this.f685h.write(3);
        this.f685h.write(1);
        o(this.f682e);
        this.f685h.write(0);
    }

    private void m() throws IOException {
        OutputStream outputStream = this.f685h;
        byte[] bArr = this.m;
        outputStream.write(bArr, 0, bArr.length);
        int length = 768 - this.m.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f685h.write(0);
        }
    }

    private void n() throws IOException {
        new b(this.a, this.b, this.f688k, this.f689l).f(this.f685h);
    }

    private void o(int i2) throws IOException {
        this.f685h.write(i2 & 255);
        this.f685h.write((i2 >> 8) & 255);
    }

    private void p(String str) throws IOException {
        for (int i2 = 0; i2 < str.length(); i2++) {
            this.f685h.write((byte) str.charAt(i2));
        }
    }

    public boolean a(Bitmap bitmap) {
        if (bitmap == null || !this.f684g) {
            return false;
        }
        try {
            if (!this.s) {
                g(bitmap.getWidth(), bitmap.getHeight());
            }
            this.f686i = bitmap;
            e();
            b();
            if (this.r) {
                k();
                m();
                if (this.f682e >= 0) {
                    l();
                }
            }
            i();
            j();
            if (!this.r) {
                m();
            }
            n();
            this.r = false;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean d() {
        boolean z;
        if (this.f684g) {
            this.f684g = false;
            try {
                this.f685h.write(59);
                this.f685h.flush();
                if (this.q) {
                    this.f685h.close();
                }
                z = true;
            } catch (IOException unused) {
                z = false;
            }
            this.f681d = 0;
            this.f685h = null;
            this.f686i = null;
            this.f687j = null;
            this.f688k = null;
            this.m = null;
            this.q = false;
            this.r = true;
            return z;
        }
        return false;
    }

    public void f(int i2) {
        this.f683f = Math.round(i2 / 10.0f);
    }

    public void g(int i2, int i3) {
        if (!this.f684g || this.r) {
            this.a = i2;
            this.b = i3;
            if (i2 < 1) {
                this.a = 320;
            }
            if (i3 < 1) {
                this.b = 240;
            }
            this.s = true;
        }
    }

    public boolean h(OutputStream outputStream) {
        boolean z = false;
        if (outputStream == null) {
            return false;
        }
        this.q = false;
        this.f685h = outputStream;
        try {
            p("GIF89a");
            z = true;
        } catch (IOException unused) {
        }
        this.f684g = z;
        return z;
    }
}
