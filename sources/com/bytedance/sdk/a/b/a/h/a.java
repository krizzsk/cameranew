package com.bytedance.sdk.a.b.a.h;

import com.bytedance.sdk.a.a.j;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.g.e;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Marker;
/* compiled from: PublicSuffixDatabase.java */
/* loaded from: classes.dex */
public final class a {
    private static final byte[] a = {42};
    private static final String[] b = new String[0];
    private static final String[] c = {Marker.ANY_MARKER};

    /* renamed from: d  reason: collision with root package name */
    private static final a f1031d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f1032e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final CountDownLatch f1033f = new CountDownLatch(1);

    /* renamed from: g  reason: collision with root package name */
    private byte[] f1034g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f1035h;

    public static a a() {
        return f1031d;
    }

    private void b() {
        boolean z = false;
        while (true) {
            try {
                try {
                    c();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e2) {
                    e.b().a(5, "Failed to read public suffix list", e2);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void c() throws IOException {
        InputStream resourceAsStream = a.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        com.bytedance.sdk.a.a.e a2 = l.a(new j(l.a(resourceAsStream)));
        try {
            byte[] bArr = new byte[a2.j()];
            a2.a(bArr);
            byte[] bArr2 = new byte[a2.j()];
            a2.a(bArr2);
            synchronized (this) {
                this.f1034g = bArr;
                this.f1035h = bArr2;
            }
            this.f1033f.countDown();
        } finally {
            c.a(a2);
        }
    }

    public String a(String str) {
        int length;
        int length2;
        Objects.requireNonNull(str, "domain == null");
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] a2 = a(split);
        if (split.length != a2.length || a2[0].charAt(0) == '!') {
            if (a2[0].charAt(0) == '!') {
                length = split.length;
                length2 = a2.length;
            } else {
                length = split.length;
                length2 = a2.length + 1;
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split("\\.");
            for (int i2 = length - length2; i2 < split2.length; i2++) {
                sb.append(split2[i2]);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        return null;
    }

    private String[] a(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i2 = 0;
        if (!this.f1032e.get() && this.f1032e.compareAndSet(false, true)) {
            b();
        } else {
            try {
                this.f1033f.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.f1034g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            bArr[i3] = strArr[i3].getBytes(c.f910e);
        }
        int i4 = 0;
        while (true) {
            str = null;
            if (i4 >= length) {
                str2 = null;
                break;
            }
            str2 = a(this.f1034g, bArr, i4);
            if (str2 != null) {
                break;
            }
            i4++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i5 = 0; i5 < bArr2.length - 1; i5++) {
                bArr2[i5] = a;
                str3 = a(this.f1034g, bArr2, i5);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i2 >= length - 1) {
                    break;
                }
                String a2 = a(this.f1035h, bArr, i2);
                if (a2 != null) {
                    str = a2;
                    break;
                }
                i2++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        } else if (str2 == null && str3 == null) {
            return c;
        } else {
            String[] split = str2 != null ? str2.split("\\.") : b;
            String[] split2 = str3 != null ? str3.split("\\.") : b;
            return split.length > split2.length ? split : split2;
        }
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        int length = bArr.length;
        int i6 = 0;
        while (i6 < length) {
            int i7 = (i6 + length) / 2;
            while (i7 > -1 && bArr[i7] != 10) {
                i7--;
            }
            int i8 = i7 + 1;
            int i9 = 1;
            while (true) {
                i3 = i8 + i9;
                if (bArr[i3] == 10) {
                    break;
                }
                i9++;
            }
            int i10 = i3 - i8;
            int i11 = i2;
            boolean z2 = false;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (z2) {
                    i4 = 46;
                    z = false;
                } else {
                    z = z2;
                    i4 = bArr2[i11][i12] & Draft_75.END_OF_FRAME;
                }
                i5 = i4 - (bArr[i8 + i13] & Draft_75.END_OF_FRAME);
                if (i5 == 0) {
                    i13++;
                    i12++;
                    if (i13 == i10) {
                        break;
                    } else if (bArr2[i11].length != i12) {
                        z2 = z;
                    } else if (i11 == bArr2.length - 1) {
                        break;
                    } else {
                        i11++;
                        z2 = true;
                        i12 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i5 >= 0) {
                if (i5 <= 0) {
                    int i14 = i10 - i13;
                    int length2 = bArr2[i11].length - i12;
                    while (true) {
                        i11++;
                        if (i11 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i11].length;
                    }
                    if (length2 >= i14) {
                        if (length2 <= i14) {
                            return new String(bArr, i8, i10, c.f910e);
                        }
                    }
                }
                i6 = i3 + 1;
            }
            length = i8 - 1;
        }
        return null;
    }
}
