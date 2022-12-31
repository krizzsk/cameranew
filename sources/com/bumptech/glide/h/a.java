package com.bumptech.glide.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
/* compiled from: GifDecoder.java */
/* loaded from: classes.dex */
public class a {
    private static final String o = "a";
    private static final Bitmap.Config p = Bitmap.Config.ARGB_8888;
    private int[] a;
    private ByteBuffer b;

    /* renamed from: d  reason: collision with root package name */
    private short[] f654d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f655e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f656f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f657g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f658h;

    /* renamed from: i  reason: collision with root package name */
    private int f659i;

    /* renamed from: k  reason: collision with root package name */
    private InterfaceC0026a f661k;

    /* renamed from: l  reason: collision with root package name */
    private Bitmap f662l;
    private boolean m;
    private int n;
    private final byte[] c = new byte[256];

    /* renamed from: j  reason: collision with root package name */
    private c f660j = new c();

    /* compiled from: GifDecoder.java */
    /* renamed from: com.bumptech.glide.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0026a {
        void a(Bitmap bitmap);

        Bitmap b(int i2, int i3, Bitmap.Config config);
    }

    public a(InterfaceC0026a interfaceC0026a) {
        this.f661k = interfaceC0026a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0134 A[LOOP:5: B:60:0x0132->B:61:0x0134, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(com.bumptech.glide.h.b r27) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.h.a.c(com.bumptech.glide.h.b):void");
    }

    private Bitmap h() {
        InterfaceC0026a interfaceC0026a = this.f661k;
        c cVar = this.f660j;
        int i2 = cVar.f673f;
        int i3 = cVar.f674g;
        Bitmap.Config config = p;
        Bitmap b = interfaceC0026a.b(i2, i3, config);
        if (b == null) {
            c cVar2 = this.f660j;
            b = Bitmap.createBitmap(cVar2.f673f, cVar2.f674g, config);
        }
        m(b);
        return b;
    }

    private int k() {
        try {
            return this.b.get() & Draft_75.END_OF_FRAME;
        } catch (Exception unused) {
            this.n = 1;
            return 0;
        }
    }

    private int l() {
        int k2 = k();
        int i2 = 0;
        if (k2 > 0) {
            while (i2 < k2) {
                int i3 = k2 - i2;
                try {
                    this.b.get(this.c, i2, i3);
                    i2 += i3;
                } catch (Exception e2) {
                    Log.w(o, "Error Reading Block", e2);
                    this.n = 1;
                }
            }
        }
        return i2;
    }

    @TargetApi(12)
    private static void m(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009a A[EDGE_INSN: B:57:0x009a->B:46:0x009a ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap o(com.bumptech.glide.h.b r18, com.bumptech.glide.h.b r19) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.h.a.o(com.bumptech.glide.h.b, com.bumptech.glide.h.b):android.graphics.Bitmap");
    }

    public void a() {
        this.f659i = (this.f659i + 1) % this.f660j.c;
    }

    public void b() {
        this.f660j = null;
        this.f657g = null;
        this.f658h = null;
        Bitmap bitmap = this.f662l;
        if (bitmap != null) {
            this.f661k.a(bitmap);
        }
        this.f662l = null;
        this.b = null;
    }

    public int d() {
        return this.f659i;
    }

    public int e(int i2) {
        if (i2 >= 0) {
            c cVar = this.f660j;
            if (i2 < cVar.c) {
                return cVar.f672e.get(i2).f668i;
            }
        }
        return -1;
    }

    public int f() {
        return this.f660j.c;
    }

    public int g() {
        return this.f660j.m;
    }

    public int i() {
        int i2;
        if (this.f660j.c <= 0 || (i2 = this.f659i) < 0) {
            return -1;
        }
        return e(i2);
    }

    public synchronized Bitmap j() {
        if (this.f660j.c <= 0 || this.f659i < 0) {
            String str = o;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "unable to decode frame, frameCount=" + this.f660j.c + " framePointer=" + this.f659i);
            }
            this.n = 1;
        }
        int i2 = this.n;
        if (i2 != 1 && i2 != 2) {
            int i3 = 0;
            this.n = 0;
            b bVar = this.f660j.f672e.get(this.f659i);
            int i4 = this.f659i - 1;
            b bVar2 = i4 >= 0 ? this.f660j.f672e.get(i4) : null;
            int[] iArr = bVar.f670k;
            if (iArr == null) {
                this.a = this.f660j.a;
            } else {
                this.a = iArr;
                c cVar = this.f660j;
                if (cVar.f677j == bVar.f667h) {
                    cVar.f679l = 0;
                }
            }
            if (bVar.f665f) {
                int[] iArr2 = this.a;
                int i5 = bVar.f667h;
                int i6 = iArr2[i5];
                iArr2[i5] = 0;
                i3 = i6;
            }
            if (this.a == null) {
                String str2 = o;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No Valid Color Table");
                }
                this.n = 1;
                return null;
            }
            Bitmap o2 = o(bVar, bVar2);
            if (bVar.f665f) {
                this.a[bVar.f667h] = i3;
            }
            return o2;
        }
        String str3 = o;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.n);
        }
        return null;
    }

    public void n(c cVar, byte[] bArr) {
        this.f660j = cVar;
        this.n = 0;
        this.f659i = -1;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.b = wrap;
        wrap.rewind();
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        this.m = false;
        Iterator<b> it = cVar.f672e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().f666g == 3) {
                this.m = true;
                break;
            }
        }
        int i2 = cVar.f673f;
        int i3 = cVar.f674g;
        this.f657g = new byte[i2 * i3];
        this.f658h = new int[i2 * i3];
    }
}
