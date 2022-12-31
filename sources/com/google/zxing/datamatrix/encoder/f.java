package com.google.zxing.datamatrix.encoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EdifactEncoder.java */
/* loaded from: classes2.dex */
public final class f implements g {
    private static void b(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c >= '@' && c <= '^') {
            sb.append((char) (c - '@'));
        } else {
            j.e(c);
            throw null;
        }
    }

    private static String c(CharSequence charSequence, int i2) {
        int length = charSequence.length() - i2;
        if (length != 0) {
            int charAt = (charSequence.charAt(i2) << 18) + ((length >= 2 ? charSequence.charAt(i2 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i2 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i2 + 3) : (char) 0);
            char c = (char) ((charAt >> 8) & 255);
            char c2 = (char) (charAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((charAt >> 16) & 255));
            if (length >= 2) {
                sb.append(c);
            }
            if (length >= 3) {
                sb.append(c2);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    private static void e(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z = true;
            if (length == 1) {
                hVar.p();
                int a = hVar.g().a() - hVar.a();
                int f2 = hVar.f();
                if (f2 > a) {
                    hVar.q(hVar.a() + 1);
                    a = hVar.g().a() - hVar.a();
                }
                if (f2 <= a && a <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i2 = length - 1;
                String c = c(charSequence, 0);
                if (!(!hVar.i()) || i2 > 2) {
                    z = false;
                }
                if (i2 <= 2) {
                    hVar.q(hVar.a() + i2);
                    if (hVar.g().a() - hVar.a() >= 3) {
                        hVar.q(hVar.a() + c.length());
                        z = false;
                    }
                }
                if (z) {
                    hVar.k();
                    hVar.f5010f -= i2;
                } else {
                    hVar.s(c);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            hVar.o(0);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            b(hVar.c(), sb);
            hVar.f5010f++;
            if (sb.length() >= 4) {
                hVar.s(c(sb, 0));
                sb.delete(0, 4);
                if (j.n(hVar.d(), hVar.f5010f, d()) != d()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        e(hVar, sb);
    }

    public int d() {
        return 4;
    }
}
