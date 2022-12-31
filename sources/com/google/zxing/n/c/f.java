package com.google.zxing.n.c;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.g;
/* compiled from: QRCode.java */
/* loaded from: classes2.dex */
public final class f {
    private Mode a;
    private ErrorCorrectionLevel b;
    private g c;

    /* renamed from: d  reason: collision with root package name */
    private int f5032d = -1;

    /* renamed from: e  reason: collision with root package name */
    private b f5033e;

    public static boolean b(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public b a() {
        return this.f5033e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.b = errorCorrectionLevel;
    }

    public void d(int i2) {
        this.f5032d = i2;
    }

    public void e(b bVar) {
        this.f5033e = bVar;
    }

    public void f(Mode mode) {
        this.a = mode;
    }

    public void g(g gVar) {
        this.c = gVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.a);
        sb.append("\n ecLevel: ");
        sb.append(this.b);
        sb.append("\n version: ");
        sb.append(this.c);
        sb.append("\n maskPattern: ");
        sb.append(this.f5032d);
        if (this.f5033e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f5033e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
