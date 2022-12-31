package com.google.zxing.datamatrix.encoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: X12Encoder.java */
/* loaded from: classes2.dex */
public final class m extends c {
    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            char c = hVar.c();
            hVar.f5010f++;
            c(c, sb);
            if (sb.length() % 3 == 0) {
                c.g(hVar, sb);
                if (j.n(hVar.d(), hVar.f5010f, e()) != e()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        f(hVar, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    int c(char c, StringBuilder sb) {
        if (c == '\r') {
            sb.append((char) 0);
        } else if (c == ' ') {
            sb.append((char) 3);
        } else if (c == '*') {
            sb.append((char) 1);
        } else if (c == '>') {
            sb.append((char) 2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
        } else {
            j.e(c);
            throw null;
        }
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    public int e() {
        return 3;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    void f(h hVar, StringBuilder sb) {
        hVar.p();
        int a = hVar.g().a() - hVar.a();
        hVar.f5010f -= sb.length();
        if (hVar.f() > 1 || a > 1 || hVar.f() != a) {
            hVar.r((char) 254);
        }
        if (hVar.e() < 0) {
            hVar.o(0);
        }
    }
}
