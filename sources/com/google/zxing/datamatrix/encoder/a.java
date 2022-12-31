package com.google.zxing.datamatrix.encoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ASCIIEncoder.java */
/* loaded from: classes2.dex */
public final class a implements g {
    private static char b(char c, char c2) {
        if (j.f(c) && j.f(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        if (j.a(hVar.d(), hVar.f5010f) >= 2) {
            hVar.r(b(hVar.d().charAt(hVar.f5010f), hVar.d().charAt(hVar.f5010f + 1)));
            hVar.f5010f += 2;
            return;
        }
        char c = hVar.c();
        int n = j.n(hVar.d(), hVar.f5010f, c());
        if (n == c()) {
            if (j.g(c)) {
                hVar.r((char) 235);
                hVar.r((char) ((c - 128) + 1));
                hVar.f5010f++;
                return;
            }
            hVar.r((char) (c + 1));
            hVar.f5010f++;
        } else if (n == 1) {
            hVar.r((char) 230);
            hVar.o(1);
        } else if (n == 2) {
            hVar.r((char) 239);
            hVar.o(2);
        } else if (n == 3) {
            hVar.r((char) 238);
            hVar.o(3);
        } else if (n == 4) {
            hVar.r((char) 240);
            hVar.o(4);
        } else if (n == 5) {
            hVar.r((char) 231);
            hVar.o(5);
        } else {
            throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(n)));
        }
    }

    public int c() {
        return 0;
    }
}
