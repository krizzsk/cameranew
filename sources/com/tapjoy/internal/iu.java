package com.tapjoy.internal;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class iu implements Serializable, Comparable {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final iu b = new iu((byte[]) new byte[0].clone());
    final byte[] c;

    /* renamed from: d  reason: collision with root package name */
    transient int f7731d;

    /* renamed from: e  reason: collision with root package name */
    transient String f7732e;

    public iu(byte[] bArr) {
        this.c = bArr;
    }

    public String a() {
        String str = this.f7732e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, je.a);
        this.f7732e = str2;
        return str2;
    }

    public String b() {
        byte[] bArr = this.c;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = a;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public int c() {
        return this.c.length;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        iu iuVar = (iu) obj;
        int c = c();
        int c2 = iuVar.c();
        int min = Math.min(c, c2);
        for (int i2 = 0; i2 < min; i2++) {
            int a2 = a(i2) & Draft_75.END_OF_FRAME;
            int a3 = iuVar.a(i2) & Draft_75.END_OF_FRAME;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (c == c2) {
            return 0;
        }
        return c < c2 ? -1 : 1;
    }

    public byte[] d() {
        return (byte[]) this.c.clone();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof iu) {
            iu iuVar = (iu) obj;
            int c = iuVar.c();
            byte[] bArr = this.c;
            if (c == bArr.length && iuVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.f7731d;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Arrays.hashCode(this.c);
        this.f7731d = hashCode;
        return hashCode;
    }

    public String toString() {
        if (this.c.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int length = a2.length();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = a2.length();
                break;
            } else if (i3 == 64) {
                break;
            } else {
                int codePointAt = a2.codePointAt(i2);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i3++;
                    i2 += Character.charCount(codePointAt);
                }
            }
        }
        i2 = -1;
        if (i2 == -1) {
            if (this.c.length <= 64) {
                return "[hex=" + b() + "]";
            }
            return "[size=" + this.c.length + " hex=" + a(0, 64).b() + "…]";
        }
        String replace = a2.substring(0, i2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (i2 >= a2.length()) {
            return "[text=" + replace + "]";
        }
        return "[size=" + this.c.length + " text=" + replace + "…]";
    }

    public iu a(int i2, int i3) {
        if (i2 >= 0) {
            byte[] bArr = this.c;
            if (i3 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.c.length + ")");
            }
            int i4 = i3 - i2;
            if (i4 >= 0) {
                if (i2 == 0 && i3 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i2, bArr2, 0, i4);
                return new iu(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte a(int i2) {
        return this.c[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ir irVar) {
        byte[] bArr = this.c;
        irVar.a(bArr, 0, bArr.length);
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 >= 0) {
            byte[] bArr2 = this.c;
            return i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && je.a(bArr2, i2, bArr, i3, i4);
        }
        return false;
    }
}
