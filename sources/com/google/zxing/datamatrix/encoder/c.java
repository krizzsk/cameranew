package com.google.zxing.datamatrix.encoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: C40Encoder.java */
/* loaded from: classes2.dex */
public class c implements g {
    private int b(h hVar, StringBuilder sb, StringBuilder sb2, int i2) {
        int length = sb.length();
        sb.delete(length - i2, length);
        hVar.f5010f--;
        int c = c(hVar.c(), sb2);
        hVar.k();
        return c;
    }

    private static String d(CharSequence charSequence, int i2) {
        int charAt = (charSequence.charAt(i2) * 1600) + (charSequence.charAt(i2 + 1) * '(') + charSequence.charAt(i2 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(h hVar, StringBuilder sb) {
        hVar.s(d(sb, 0));
        sb.delete(0, 3);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            char c = hVar.c();
            hVar.f5010f++;
            int c2 = c(c, sb);
            int a = hVar.a() + ((sb.length() / 3) << 1);
            hVar.q(a);
            int a2 = hVar.g().a() - a;
            if (!hVar.i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (a2 < 2 || a2 > 2)) {
                    c2 = b(hVar, sb, sb2, c2);
                }
                while (sb.length() % 3 == 1 && ((c2 <= 3 && a2 != 1) || c2 > 3)) {
                    c2 = b(hVar, sb, sb2, c2);
                }
            } else if (sb.length() % 3 == 0 && j.n(hVar.d(), hVar.f5010f, e()) != e()) {
                hVar.o(0);
                break;
            }
        }
        f(hVar, sb);
    }

    int c(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        } else if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        } else if (c >= '`' && c <= 127) {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        } else {
            sb.append("\u0001\u001e");
            return c((char) (c - 128), sb) + 2;
        }
    }

    public int e() {
        return 1;
    }

    void f(h hVar, StringBuilder sb) {
        int length = sb.length() % 3;
        int a = hVar.a() + ((sb.length() / 3) << 1);
        hVar.q(a);
        int a2 = hVar.g().a() - a;
        if (length == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (hVar.i()) {
                hVar.r((char) 254);
            }
        } else if (a2 == 1 && length == 1) {
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (hVar.i()) {
                hVar.r((char) 254);
            }
            hVar.f5010f--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (a2 > 0 || hVar.i()) {
                hVar.r((char) 254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        hVar.o(0);
    }
}
