package com.bumptech.glide.h;

import android.util.Log;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {
    private ByteBuffer b;
    private c c;
    private final byte[] a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    private int f680d = 0;

    private boolean b() {
        return this.c.b != 0;
    }

    private int d() {
        try {
            return this.b.get() & Draft_75.END_OF_FRAME;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    private void e() {
        this.c.f671d.a = m();
        this.c.f671d.b = m();
        this.c.f671d.c = m();
        this.c.f671d.f663d = m();
        int d2 = d();
        boolean z = (d2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (d2 & 7) + 1);
        b bVar = this.c.f671d;
        bVar.f664e = (d2 & 64) != 0;
        if (z) {
            bVar.f670k = g(pow);
        } else {
            bVar.f670k = null;
        }
        this.c.f671d.f669j = this.b.position();
        q();
        if (b()) {
            return;
        }
        c cVar = this.c;
        cVar.c++;
        cVar.f672e.add(cVar.f671d);
    }

    private int f() {
        int d2 = d();
        this.f680d = d2;
        int i2 = 0;
        if (d2 > 0) {
            int i3 = 0;
            while (true) {
                try {
                    i3 = this.f680d;
                    if (i2 >= i3) {
                        break;
                    }
                    i3 -= i2;
                    this.b.get(this.a, i2, i3);
                    i2 += i3;
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f680d, e2);
                    }
                    this.c.b = 1;
                }
            }
        }
        return i2;
    }

    private int[] g(int i2) {
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
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.c.b = 1;
        }
        return iArr;
    }

    private void h() {
        boolean z = false;
        while (!z && !b()) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 == 1) {
                    p();
                } else if (d3 == 249) {
                    this.c.f671d = new b();
                    i();
                } else if (d3 == 254) {
                    p();
                } else if (d3 != 255) {
                    p();
                } else {
                    f();
                    String str = "";
                    for (int i2 = 0; i2 < 11; i2++) {
                        str = str + ((char) this.a[i2]);
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        l();
                    } else {
                        p();
                    }
                }
            } else if (d2 == 44) {
                c cVar = this.c;
                if (cVar.f671d == null) {
                    cVar.f671d = new b();
                }
                e();
            } else if (d2 != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    private void i() {
        d();
        int d2 = d();
        b bVar = this.c.f671d;
        int i2 = (d2 & 28) >> 2;
        bVar.f666g = i2;
        if (i2 == 0) {
            bVar.f666g = 1;
        }
        bVar.f665f = (d2 & 1) != 0;
        int m = m();
        if (m < 3) {
            m = 10;
        }
        b bVar2 = this.c.f671d;
        bVar2.f668i = m * 10;
        bVar2.f667h = d();
        d();
    }

    private void j() {
        String str = "";
        for (int i2 = 0; i2 < 6; i2++) {
            str = str + ((char) d());
        }
        if (!str.startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        k();
        if (!this.c.f675h || b()) {
            return;
        }
        c cVar = this.c;
        cVar.a = g(cVar.f676i);
        c cVar2 = this.c;
        cVar2.f679l = cVar2.a[cVar2.f677j];
    }

    private void k() {
        this.c.f673f = m();
        this.c.f674g = m();
        int d2 = d();
        c cVar = this.c;
        cVar.f675h = (d2 & 128) != 0;
        cVar.f676i = 2 << (d2 & 7);
        cVar.f677j = d();
        this.c.f678k = d();
    }

    private void l() {
        do {
            f();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                this.c.m = ((bArr[2] & Draft_75.END_OF_FRAME) << 8) | (bArr[1] & Draft_75.END_OF_FRAME);
            }
            if (this.f680d <= 0) {
                return;
            }
        } while (!b());
    }

    private int m() {
        return this.b.getShort();
    }

    private void n() {
        this.b = null;
        Arrays.fill(this.a, (byte) 0);
        this.c = new c();
        this.f680d = 0;
    }

    private void p() {
        int d2;
        do {
            d2 = d();
            ByteBuffer byteBuffer = this.b;
            byteBuffer.position(byteBuffer.position() + d2);
        } while (d2 > 0);
    }

    private void q() {
        d();
        p();
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    public c c() {
        if (this.b != null) {
            if (b()) {
                return this.c;
            }
            j();
            if (!b()) {
                h();
                c cVar = this.c;
                if (cVar.c < 0) {
                    cVar.b = 1;
                }
            }
            return this.c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public d o(byte[] bArr) {
        n();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.b = wrap;
            wrap.rewind();
            this.b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.b = null;
            this.c.b = 2;
        }
        return this;
    }
}
