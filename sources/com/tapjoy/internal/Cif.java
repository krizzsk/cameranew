package com.tapjoy.internal;

import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* renamed from: com.tapjoy.internal.if  reason: invalid class name */
/* loaded from: classes3.dex */
public final class Cif {
    private ByteBuffer b;
    private ie c;
    private final byte[] a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    private int f7693d = 0;

    private void b() {
        boolean z = false;
        while (!z && !h() && this.c.c <= Integer.MAX_VALUE) {
            int g2 = g();
            if (g2 == 33) {
                int g3 = g();
                if (g3 == 1) {
                    e();
                } else if (g3 == 249) {
                    this.c.f7684d = new id();
                    g();
                    int g4 = g();
                    id idVar = this.c.f7684d;
                    int i2 = (g4 & 28) >> 2;
                    idVar.f7679g = i2;
                    if (i2 == 0) {
                        idVar.f7679g = 1;
                    }
                    idVar.f7678f = (g4 & 1) != 0;
                    short s = this.b.getShort();
                    if (s < 2) {
                        s = 10;
                    }
                    id idVar2 = this.c.f7684d;
                    idVar2.f7681i = s * 10;
                    idVar2.f7680h = g();
                    g();
                } else if (g3 == 254) {
                    e();
                } else if (g3 != 255) {
                    e();
                } else {
                    f();
                    String str = "";
                    for (int i3 = 0; i3 < 11; i3++) {
                        str = str + ((char) this.a[i3]);
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        c();
                    } else {
                        e();
                    }
                }
            } else if (g2 == 44) {
                ie ieVar = this.c;
                if (ieVar.f7684d == null) {
                    ieVar.f7684d = new id();
                }
                this.c.f7684d.a = this.b.getShort();
                this.c.f7684d.b = this.b.getShort();
                this.c.f7684d.c = this.b.getShort();
                this.c.f7684d.f7676d = this.b.getShort();
                int g5 = g();
                boolean z2 = (g5 & 128) != 0;
                int pow = (int) Math.pow(2.0d, (g5 & 7) + 1);
                id idVar3 = this.c.f7684d;
                idVar3.f7677e = (g5 & 64) != 0;
                if (z2) {
                    idVar3.f7683k = a(pow);
                } else {
                    idVar3.f7683k = null;
                }
                this.c.f7684d.f7682j = this.b.position();
                g();
                e();
                if (!h()) {
                    ie ieVar2 = this.c;
                    ieVar2.c++;
                    ieVar2.f7685e.add(ieVar2.f7684d);
                }
            } else if (g2 != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    private void c() {
        do {
            f();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                int i2 = bArr[1] & Draft_75.END_OF_FRAME;
                int i3 = bArr[2] & Draft_75.END_OF_FRAME;
                ie ieVar = this.c;
                int i4 = (i3 << 8) | i2;
                ieVar.m = i4;
                if (i4 == 0) {
                    ieVar.m = -1;
                }
            }
            if (this.f7693d <= 0) {
                return;
            }
        } while (!h());
    }

    private void d() {
        String str = "";
        for (int i2 = 0; i2 < 6; i2++) {
            str = str + ((char) g());
        }
        if (!str.startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        this.c.f7686f = this.b.getShort();
        this.c.f7687g = this.b.getShort();
        int g2 = g();
        ie ieVar = this.c;
        ieVar.f7688h = (g2 & 128) != 0;
        ieVar.f7689i = 2 << (g2 & 7);
        ieVar.f7690j = g();
        this.c.f7691k = g();
        if (!this.c.f7688h || h()) {
            return;
        }
        ie ieVar2 = this.c;
        ieVar2.a = a(ieVar2.f7689i);
        ie ieVar3 = this.c;
        ieVar3.f7692l = ieVar3.a[ieVar3.f7690j];
    }

    private void e() {
        int g2;
        do {
            try {
                g2 = g();
                ByteBuffer byteBuffer = this.b;
                byteBuffer.position(byteBuffer.position() + g2);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (g2 > 0);
    }

    private int f() {
        int g2 = g();
        this.f7693d = g2;
        int i2 = 0;
        if (g2 > 0) {
            while (true) {
                try {
                    int i3 = this.f7693d;
                    if (i2 >= i3) {
                        break;
                    }
                    int i4 = i3 - i2;
                    this.b.get(this.a, i2, i4);
                    i2 += i4;
                } catch (Exception unused) {
                    this.c.b = 1;
                }
            }
        }
        return i2;
    }

    private int g() {
        try {
            return this.b.get() & Draft_75.END_OF_FRAME;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    private boolean h() {
        return this.c.b != 0;
    }

    public final Cif a(byte[] bArr) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.b = null;
            Arrays.fill(this.a, (byte) 0);
            this.c = new ie();
            this.f7693d = 0;
            ByteBuffer asReadOnlyBuffer = wrap.asReadOnlyBuffer();
            this.b = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.b = null;
            this.c.b = 2;
        }
        return this;
    }

    public final ie a() {
        if (this.b != null) {
            if (h()) {
                return this.c;
            }
            d();
            if (!h()) {
                b();
                ie ieVar = this.c;
                if (ieVar.c < 0) {
                    ieVar.b = 1;
                }
            }
            return this.c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    private int[] a(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = bArr[i4] & Draft_75.END_OF_FRAME;
                int i7 = i5 + 1;
                int i8 = bArr[i5] & Draft_75.END_OF_FRAME;
                int i9 = i7 + 1;
                int i10 = i3 + 1;
                iArr[i3] = (i6 << 16) | ViewCompat.MEASURED_STATE_MASK | (i8 << 8) | (bArr[i7] & Draft_75.END_OF_FRAME);
                i4 = i9;
                i3 = i10;
            }
        } catch (BufferUnderflowException unused) {
            this.c.b = 1;
        }
        return iArr;
    }
}
