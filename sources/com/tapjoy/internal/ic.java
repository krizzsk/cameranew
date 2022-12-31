package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.os.Build;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class ic {

    /* renamed from: d  reason: collision with root package name */
    private static final String f7667d = "ic";
    int a;
    int b;
    ie c;

    /* renamed from: e  reason: collision with root package name */
    private int[] f7668e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f7669f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f7670g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f7671h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private byte[] f7672i;

    /* renamed from: j  reason: collision with root package name */
    private int f7673j;

    /* renamed from: k  reason: collision with root package name */
    private int f7674k;

    /* renamed from: l  reason: collision with root package name */
    private Cif f7675l;
    private short[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;
    private int[] q;
    private a r;
    private Bitmap s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private int x;
    private boolean y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        @Nonnull
        Bitmap a(int i2, int i3, Bitmap.Config config);

        byte[] a(int i2);

        int[] b(int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ic(a aVar, ie ieVar, ByteBuffer byteBuffer) {
        this(aVar, ieVar, byteBuffer, (byte) 0);
    }

    private synchronized void b(ie ieVar, ByteBuffer byteBuffer) {
        int highestOneBit = Integer.highestOneBit(1);
        this.u = 0;
        this.c = ieVar;
        this.y = false;
        this.a = -1;
        this.b = 0;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f7670g = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f7670g.order(ByteOrder.LITTLE_ENDIAN);
        this.t = false;
        Iterator it = ieVar.f7685e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((id) it.next()).f7679g == 3) {
                this.t = true;
                break;
            }
        }
        this.v = highestOneBit;
        int i2 = ieVar.f7686f;
        this.x = i2 / highestOneBit;
        int i3 = ieVar.f7687g;
        this.w = i3 / highestOneBit;
        this.p = this.r.a(i2 * i3);
        this.q = this.r.b(this.x * this.w);
    }

    private int c() {
        try {
            b();
            byte[] bArr = this.f7672i;
            int i2 = this.f7674k;
            this.f7674k = i2 + 1;
            return bArr[i2] & Draft_75.END_OF_FRAME;
        } catch (Exception unused) {
            this.u = 1;
            return 0;
        }
    }

    private int d() {
        int c = c();
        if (c > 0) {
            try {
                if (this.f7671h == null) {
                    this.f7671h = this.r.a(255);
                }
                int i2 = this.f7673j;
                int i3 = this.f7674k;
                int i4 = i2 - i3;
                if (i4 >= c) {
                    System.arraycopy(this.f7672i, i3, this.f7671h, 0, c);
                    this.f7674k += c;
                } else if (this.f7670g.remaining() + i4 >= c) {
                    System.arraycopy(this.f7672i, this.f7674k, this.f7671h, 0, i4);
                    this.f7674k = this.f7673j;
                    b();
                    int i5 = c - i4;
                    System.arraycopy(this.f7672i, 0, this.f7671h, i4, i5);
                    this.f7674k += i5;
                } else {
                    this.u = 1;
                }
            } catch (Exception unused) {
                this.u = 1;
            }
        }
        return c;
    }

    private Bitmap e() {
        Bitmap a2 = this.r.a(this.x, this.w, this.y ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565);
        if (Build.VERSION.SDK_INT >= 12) {
            a2.setHasAlpha(true);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e6 A[Catch: all -> 0x03b3, LOOP:9: B:112:0x01e4->B:113:0x01e6, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:9:0x0010, B:14:0x001a, B:16:0x002e, B:18:0x003a, B:22:0x0043, B:24:0x0047, B:27:0x004b, B:29:0x004f, B:30:0x005d, B:32:0x0061, B:35:0x0067, B:38:0x006d, B:40:0x0071, B:42:0x0079, B:49:0x0087, B:45:0x0080, B:47:0x0084, B:51:0x008d, B:53:0x0091, B:54:0x0095, B:55:0x00b1, B:57:0x00b7, B:59:0x00c0, B:61:0x00cf, B:63:0x00d3, B:66:0x00de, B:68:0x00e4, B:69:0x00e8, B:71:0x00ec, B:72:0x00f0, B:74:0x00f4, B:75:0x00fa, B:77:0x010b, B:82:0x0135, B:84:0x013b, B:86:0x0141, B:88:0x015c, B:92:0x016f, B:97:0x017d, B:99:0x0192, B:102:0x01a0, B:103:0x01b5, B:105:0x01ca, B:109:0x01db, B:113:0x01e6, B:119:0x0233, B:120:0x023b, B:126:0x0258, B:130:0x025f, B:140:0x0275, B:142:0x027c, B:144:0x0281, B:146:0x028d, B:147:0x028f, B:149:0x02a0, B:151:0x02a9, B:177:0x034a, B:182:0x0356, B:178:0x034d, B:181:0x0353, B:152:0x02b9, B:153:0x02c8, B:155:0x02cd, B:158:0x02d6, B:160:0x02e0, B:161:0x02f8, B:163:0x02ff, B:164:0x0301, B:166:0x0306, B:169:0x030d, B:171:0x0317, B:172:0x032f, B:175:0x0336, B:183:0x0365, B:184:0x037b, B:186:0x037f, B:190:0x0386, B:192:0x038a, B:193:0x0390, B:194:0x039e, B:65:0x00d6, B:60:0x00c9, B:21:0x003f, B:8:0x000e), top: B:202:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized android.graphics.Bitmap a() {
        /*
            Method dump skipped, instructions count: 950
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.ic.a():android.graphics.Bitmap");
    }

    private ic(a aVar, ie ieVar, ByteBuffer byteBuffer, byte b) {
        this(aVar);
        b(ieVar, byteBuffer);
    }

    private ic(a aVar) {
        this.f7669f = new int[256];
        this.f7673j = 0;
        this.f7674k = 0;
        this.r = aVar;
        this.c = new ie();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ic() {
        this(new ih());
    }

    private void b() {
        if (this.f7673j > this.f7674k) {
            return;
        }
        if (this.f7672i == null) {
            this.f7672i = this.r.a(16384);
        }
        this.f7674k = 0;
        int min = Math.min(this.f7670g.remaining(), 16384);
        this.f7673j = min;
        this.f7670g.get(this.f7672i, 0, min);
    }

    private synchronized void a(ie ieVar, byte[] bArr) {
        a(ieVar, ByteBuffer.wrap(bArr));
    }

    private synchronized void a(ie ieVar, ByteBuffer byteBuffer) {
        b(ieVar, byteBuffer);
    }

    private void a(int[] iArr, id idVar, int i2) {
        int i3 = idVar.f7676d;
        int i4 = this.v;
        int i5 = i3 / i4;
        int i6 = idVar.b / i4;
        int i7 = idVar.c / i4;
        int i8 = idVar.a / i4;
        int i9 = this.x;
        int i10 = (i6 * i9) + i8;
        int i11 = (i5 * i9) + i10;
        while (i10 < i11) {
            int i12 = i10 + i7;
            for (int i13 = i10; i13 < i12; i13++) {
                iArr[i13] = i2;
            }
            i10 += this.x;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized int a(byte[] bArr) {
        if (this.f7675l == null) {
            this.f7675l = new Cif();
        }
        ie a2 = this.f7675l.a(bArr).a();
        this.c = a2;
        if (bArr != null) {
            a(a2, bArr);
        }
        return this.u;
    }
}
