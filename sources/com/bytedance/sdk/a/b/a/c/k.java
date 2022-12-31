package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.w;
import java.io.IOException;
import java.net.ProtocolException;
/* compiled from: StatusLine.java */
/* loaded from: classes.dex */
public final class k {
    public final w a;
    public final int b;
    public final String c;

    public k(w wVar, int i2, String str) {
        this.a = wVar;
        this.b = i2;
        this.c = str;
    }

    public static k a(aa aaVar) {
        return new k(aaVar.b(), aaVar.c(), aaVar.d());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a == w.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.b);
        if (this.c != null) {
            sb.append(' ');
            sb.append(this.c);
        }
        return sb.toString();
    }

    public static k a(String str) throws IOException {
        w wVar;
        String str2;
        int i2 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() >= 9 && str.charAt(8) == ' ') {
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    wVar = w.HTTP_1_0;
                } else if (charAt == 1) {
                    wVar = w.HTTP_1_1;
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            wVar = w.HTTP_1_0;
            i2 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i3 = i2 + 3;
        if (str.length() >= i3) {
            try {
                int parseInt = Integer.parseInt(str.substring(i2, i3));
                if (str.length() <= i3) {
                    str2 = "";
                } else if (str.charAt(i3) == ' ') {
                    str2 = str.substring(i2 + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new k(wVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }
        throw new ProtocolException("Unexpected status line: " + str);
    }
}
