package us.pinguo.image.saver.e;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import us.pinguo.librouter.b.c.f;
import us.pinguo.util.j;
/* compiled from: PGExifInfo.java */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    private static final DateFormat f11184f;

    /* renamed from: g  reason: collision with root package name */
    private static final DateFormat f11185g;

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f11186h;
    private byte[] a = null;
    private List<b> b = new ArrayList();
    private List<b> c = null;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f11187d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11188e = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PGExifInfo.java */
    /* loaded from: classes4.dex */
    public static class b {
        private int a;
        private int b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f11189d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f11190e;

        /* renamed from: f  reason: collision with root package name */
        private byte[] f11191f;

        /* renamed from: g  reason: collision with root package name */
        private List<b> f11192g;

        private b() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.f11189d = -1;
            this.f11190e = null;
            this.f11191f = null;
            this.f11192g = null;
        }
    }

    static {
        Locale locale = Locale.ENGLISH;
        f11184f = new SimpleDateFormat("yyyy:MM:dd", locale);
        f11185g = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        f11186h = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    public a(byte[] bArr) {
        if (b(bArr)) {
            a(bArr);
        }
    }

    private void a(byte[] bArr) {
        int length = bArr.length;
        if (14 >= length) {
            return;
        }
        int o = j.o(bArr, 10, 4, false);
        if (o != 1229531648 && o != 1296891946) {
            us.pinguo.common.log.a.e("Invalid byte order", new Object[0]);
            return;
        }
        boolean z = o == 1229531648;
        this.f11188e = z;
        if (18 < length && j.o(bArr, 14, 4, z) == 8 && s(bArr, length, 18, this.f11188e, this.b) == -1) {
            this.b = new ArrayList();
        }
    }

    private boolean b(byte[] bArr) {
        if (bArr != null && bArr.length >= 10) {
            byte[] bArr2 = new byte[10];
            this.a = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, 10);
            return true;
        }
        return false;
    }

    private boolean c(byte[] bArr, int i2, b bVar, int i3) {
        byte[] bArr2;
        if (i3 <= 0 || i3 >= i2 || bVar.f11190e != null) {
            return false;
        }
        int i4 = i3 + 10;
        int i5 = bVar.a;
        if (i5 == 34665) {
            bVar.f11192g = new ArrayList();
            s(bArr, i2, i4, this.f11188e, bVar.f11192g);
            return bVar.f11192g.size() > 0;
        } else if (i5 == 34853) {
            bVar.f11192g = new ArrayList();
            s(bArr, i2, i4, this.f11188e, bVar.f11192g);
            return bVar.f11192g.size() > 0;
        } else if (i5 != 40965) {
            try {
                if (bVar.b == 2) {
                    if (bArr[(bVar.f11189d + i4) - 1] == 0) {
                        bArr2 = new byte[bVar.f11189d];
                        System.arraycopy(bArr, i4, bArr2, 0, bVar.f11189d);
                    } else if (bArr[bVar.f11189d + i4] == 0) {
                        bArr2 = new byte[bVar.f11189d + 1];
                        System.arraycopy(bArr, i4, bArr2, 0, bVar.f11189d + 1);
                    } else {
                        bArr2 = new byte[bVar.f11189d];
                        System.arraycopy(bArr, i4, bArr2, 0, bVar.f11189d);
                    }
                } else {
                    bArr2 = new byte[bVar.f11189d];
                    System.arraycopy(bArr, i4, bArr2, 0, bVar.f11189d);
                }
                bVar.f11191f = bArr2;
                return true;
            } catch (Exception unused) {
                return false;
            }
        } else {
            bVar.f11192g = new ArrayList();
            s(bArr, i2, i4, this.f11188e, bVar.f11192g);
            return bVar.f11192g.size() > 0;
        }
    }

    private b e(int i2) {
        if (i2 == 274 || i2 == 305 || i2 == 271 || i2 == 272 || i2 == 306) {
            b i3 = i(i2, this.b);
            if (i3 == null) {
                b bVar = new b();
                bVar.a = i2;
                List<b> list = this.b;
                list.add(g(i2, list), bVar);
                return bVar;
            }
            return i3;
        } else if (i2 != 36868 && i2 != 36867) {
            if (i2 == 34853) {
                b i4 = i(34853, this.b);
                if (i4 == null) {
                    b bVar2 = new b();
                    bVar2.a = 34853;
                    bVar2.c = 1;
                    bVar2.b = 4;
                    bVar2.f11192g = new ArrayList();
                    List<b> list2 = this.b;
                    list2.add(g(34853, list2), bVar2);
                    return bVar2;
                }
                return i4;
            }
            return null;
        } else {
            b i5 = i(34665, this.b);
            if (i5 == null) {
                i5 = new b();
                i5.a = 34665;
                i5.c = 1;
                i5.b = 4;
                i5.f11192g = new ArrayList();
                List<b> list3 = this.b;
                list3.add(g(34665, list3), i5);
                b bVar3 = new b();
                bVar3.a = 36864;
                bVar3.b = 7;
                bVar3.c = 4;
                bVar3.f11190e = new byte[4];
                bVar3.f11190e[0] = 48;
                bVar3.f11190e[1] = 50;
                bVar3.f11190e[2] = 50;
                bVar3.f11190e[3] = 48;
                i5.f11192g.add(g(36864, i5.f11192g), bVar3);
            }
            b i6 = i(i2, i5.f11192g);
            if (i6 == null) {
                b bVar4 = new b();
                bVar4.a = i2;
                i5.f11192g.add(g(i2, i5.f11192g), bVar4);
                return bVar4;
            }
            return i6;
        }
    }

    private byte[] f(int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = 0;
        }
        return bArr;
    }

    private int g(int i2, List<b> list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3).a >= i2) {
                return i3;
            }
        }
        return size;
    }

    private byte[] h(List<b> list, int i2, boolean z) {
        int length;
        if (list == null) {
            return new byte[0];
        }
        int size = list.size();
        if (size == 0) {
            return new byte[0];
        }
        int i3 = (size * 12) + 2 + 4;
        byte[] f2 = f(i3);
        j.q(f2, size, 2, 0, this.f11188e);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = list.get(i5);
            int i6 = (i5 * 12) + 2;
            j.q(f2, bVar.a, 2, i6, this.f11188e);
            j.q(f2, bVar.b, 2, i6 + 2, this.f11188e);
            j.q(f2, bVar.c, 4, i6 + 4, this.f11188e);
            if (bVar.f11190e != null) {
                r(f2, bVar.f11190e, 4, i6 + 8);
            } else {
                if (bVar.f11191f == null) {
                    if (bVar.f11192g != null) {
                        int i7 = i2 + i3 + i4;
                        byte[] h2 = h(bVar.f11192g, i7, false);
                        if (h2.length != 0) {
                            j.q(f2, i7, 4, i6 + 8, this.f11188e);
                            byteArrayOutputStream.write(h2, 0, h2.length);
                            length = h2.length;
                        }
                    }
                } else {
                    j.q(f2, i2 + i3 + i4, 4, i6 + 8, this.f11188e);
                    byteArrayOutputStream.write(bVar.f11191f, 0, bVar.f11191f.length);
                    length = bVar.f11191f.length;
                }
                i4 += length;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byte[] bArr = null;
        if (z && this.c != null) {
            int i8 = i2 + i3 + i4;
            j.q(f2, i8, 4, i3 - 4, this.f11188e);
            byte[] h3 = h(this.c, i8, false);
            p(h3, i8 + h3.length);
            bArr = h3;
        }
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        byteArrayOutputStream2.write(f2, 0, f2.length);
        byteArrayOutputStream2.write(byteArray, 0, byteArray.length);
        if (z && bArr != null && this.f11187d != null) {
            byteArrayOutputStream2.write(bArr, 0, bArr.length);
            byte[] bArr2 = this.f11187d;
            byteArrayOutputStream2.write(bArr2, 0, bArr2.length);
        }
        return byteArrayOutputStream2.toByteArray();
    }

    private b i(int i2, List<b> list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = list.get(i3);
            if (bVar.a == i2) {
                return bVar;
            }
        }
        return null;
    }

    private void p(byte[] bArr, int i2) {
        for (int i3 = 2; i3 < bArr.length; i3 += 12) {
            if (j.o(bArr, i3, 2, this.f11188e) == 513) {
                j.q(bArr, i2, 4, i3 + 8, this.f11188e);
            }
        }
    }

    private void q(long j2, int i2) {
        byte[] bytes;
        b e2 = e(i2);
        if (e2 == null) {
            return;
        }
        e2.b = 2;
        e2.c = 20;
        String format = f11185g.format(new Date(j2));
        try {
            bytes = format.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = format.getBytes();
        }
        byte[] f2 = f(20);
        System.arraycopy(bytes, 0, f2, 0, bytes.length < 20 ? bytes.length : 20);
        e2.f11191f = f2;
    }

    private static void r(byte[] bArr, byte[] bArr2, int i2, int i3) {
        System.arraycopy(bArr2, 0, bArr, i3, i2);
    }

    private int s(byte[] bArr, int i2, int i3, boolean z, List<b> list) {
        int i4 = i3 + 2;
        int i5 = -1;
        if (i4 >= i2) {
            return -1;
        }
        int i6 = 2;
        int o = j.o(bArr, i3, 2, z);
        if (o > 1024) {
            return -1;
        }
        int i7 = 0;
        while (i7 < o) {
            int i8 = i4 + 2;
            if (i8 >= i2) {
                return i5;
            }
            int o2 = j.o(bArr, i4, i6, z);
            if (o2 == 37500 || o2 == 8192 || o2 == 0) {
                i4 += 12;
            } else {
                int i9 = i8 + 2;
                if (i9 >= i2) {
                    return i5;
                }
                int o3 = j.o(bArr, i8, i6, z);
                if (o3 < 1 || o3 >= 13) {
                    i4 = i8 + 10;
                } else {
                    int i10 = i9 + 4;
                    if (i10 >= i2) {
                        return i5;
                    }
                    int o4 = j.o(bArr, i9, 4, z);
                    int i11 = i10 + 4;
                    if (i11 >= i2) {
                        return i5;
                    }
                    b bVar = new b();
                    bVar.a = o2;
                    bVar.b = o3;
                    bVar.c = o4;
                    int i12 = f11186h[o3] * o4;
                    bVar.f11189d = i12;
                    if (i12 <= 4 && o2 != 34853 && o2 != 34665 && o2 != 40965) {
                        bVar.f11190e = new byte[]{bArr[i10], bArr[i10 + 1], bArr[i10 + 2], bArr[i10 + 3]};
                        list.add(bVar);
                    } else if (c(bArr, i2, bVar, j.o(bArr, i10, 4, z))) {
                        list.add(bVar);
                    }
                    i4 = i11;
                }
            }
            i7++;
            i5 = -1;
            i6 = 2;
        }
        return i4;
    }

    public byte[] d() {
        if (this.b.size() == 0) {
            return new byte[0];
        }
        if (this.a == null) {
            byte[] f2 = f(10);
            this.a = f2;
            f2[0] = -1;
            f2[1] = -31;
            j.q(f2, 1165519206, 4, 4, false);
        }
        byte[] f3 = f(8);
        j.q(f3, this.f11188e ? 1229531648 : 1296891946, 4, 0, false);
        j.q(f3, 8, 4, 4, this.f11188e);
        byte[] h2 = h(this.b, 8, true);
        if (h2.length != 0) {
            int length = h2.length + 18;
            j.q(this.a, length - 2, 2, 2, false);
            byte[] bArr = new byte[length];
            System.arraycopy(this.a, 0, bArr, 0, 10);
            System.arraycopy(f3, 0, bArr, 10, 8);
            System.arraycopy(h2, 0, bArr, 18, h2.length);
            return bArr;
        }
        return new byte[0];
    }

    public void j(long j2) {
        q(j2, 306);
    }

    public void k(f fVar) {
        b e2;
        byte[] bytes;
        if (fVar == null || (e2 = e(34853)) == null) {
            return;
        }
        b i2 = i(0, e2.f11192g);
        if (i2 != null) {
            i2.a = 0;
            i2.b = 1;
            i2.c = 4;
            i2.f11190e = new byte[4];
            i2.f11190e[0] = 2;
            i2.f11190e[1] = 2;
            i2.f11190e[2] = 0;
            i2.f11190e[3] = 0;
        }
        b i3 = i(1, e2.f11192g);
        if (i3 == null) {
            i3 = new b();
            i3.a = 1;
            e2.f11192g.add(g(1, e2.f11192g), i3);
        }
        i3.b = 2;
        i3.c = 2;
        i3.f11190e = f(4);
        double c = fVar.c();
        if (c > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            i3.f11190e[0] = 78;
        } else {
            i3.f11190e[0] = 83;
        }
        if (c < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            c = -c;
        }
        b i4 = i(2, e2.f11192g);
        if (i4 == null) {
            i4 = new b();
            i4.a = 2;
            e2.f11192g.add(g(2, e2.f11192g), i4);
        }
        i4.b = 5;
        i4.c = 3;
        i4.f11191f = f(24);
        int floor = (int) Math.floor(c);
        double d2 = (c - floor) * 60.0d;
        int floor2 = (int) Math.floor(d2);
        j.q(i4.f11191f, floor, 4, 0, this.f11188e);
        j.q(i4.f11191f, 1, 4, 4, this.f11188e);
        j.q(i4.f11191f, floor2, 4, 8, this.f11188e);
        j.q(i4.f11191f, 1, 4, 12, this.f11188e);
        j.q(i4.f11191f, (int) Math.floor((d2 - floor2) * 60.0d * 10000.0d), 4, 16, this.f11188e);
        j.q(i4.f11191f, 10000, 4, 20, this.f11188e);
        b i5 = i(3, e2.f11192g);
        if (i5 == null) {
            i5 = new b();
            i5.a = 3;
            e2.f11192g.add(g(3, e2.f11192g), i5);
        }
        i5.b = 2;
        i5.c = 2;
        i5.f11190e = f(4);
        double d3 = fVar.d();
        if (d3 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            i5.f11190e[0] = 69;
        } else {
            i5.f11190e[0] = 87;
        }
        if (d3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d3 = -d3;
        }
        b i6 = i(4, e2.f11192g);
        if (i6 == null) {
            i6 = new b();
            i6.a = 4;
            e2.f11192g.add(g(4, e2.f11192g), i6);
        }
        i6.b = 5;
        i6.c = 3;
        i6.f11191f = f(24);
        int floor3 = (int) Math.floor(d3);
        double d4 = (d3 - floor3) * 60.0d;
        int floor4 = (int) Math.floor(d4);
        j.q(i6.f11191f, floor3, 4, 0, this.f11188e);
        j.q(i6.f11191f, 1, 4, 4, this.f11188e);
        j.q(i6.f11191f, floor4, 4, 8, this.f11188e);
        j.q(i6.f11191f, 1, 4, 12, this.f11188e);
        j.q(i6.f11191f, (int) Math.floor((d4 - floor4) * 60.0d * 10000.0d), 4, 16, this.f11188e);
        j.q(i6.f11191f, 10000, 4, 20, this.f11188e);
        b i7 = i(5, e2.f11192g);
        if (i7 == null) {
            i7 = new b();
            i7.a = 5;
            e2.f11192g.add(g(5, e2.f11192g), i7);
        }
        i7.b = 1;
        i7.c = 1;
        i7.f11190e = f(4);
        double b2 = fVar.b();
        int i8 = (b2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (b2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1));
        if (i8 < 0) {
            i7.f11190e[0] = 1;
        }
        if (i8 < 0) {
            b2 = -b2;
        }
        b i9 = i(6, e2.f11192g);
        if (i9 == null) {
            i9 = new b();
            i9.a = 6;
            e2.f11192g.add(g(6, e2.f11192g), i9);
        }
        i9.b = 5;
        i9.c = 1;
        i9.f11191f = f(8);
        j.q(i9.f11191f, (int) (b2 * 1000.0d), 4, 0, this.f11188e);
        j.q(i9.f11191f, 1000, 4, 4, this.f11188e);
        long f2 = fVar.f();
        if (f2 > 0) {
            b i10 = i(7, e2.f11192g);
            if (i10 == null) {
                i10 = new b();
                i10.a = 7;
                e2.f11192g.add(g(7, e2.f11192g), i10);
            }
            i10.b = 5;
            i10.c = 3;
            i10.f11191f = f(24);
            long j2 = f2 / 1000;
            long j3 = j2 / 60;
            long j4 = j3 / 60;
            j.q(i10.f11191f, (int) (j4 - ((j4 / 24) * 24)), 4, 0, this.f11188e);
            j.q(i10.f11191f, 1, 4, 4, this.f11188e);
            j.q(i10.f11191f, (int) (j3 - (60 * j4)), 4, 8, this.f11188e);
            j.q(i10.f11191f, 1, 4, 12, this.f11188e);
            j.q(i10.f11191f, (int) (j2 - (j3 * 60)), 4, 16, this.f11188e);
            j.q(i10.f11191f, 1, 4, 20, this.f11188e);
            b i11 = i(29, e2.f11192g);
            if (i11 == null) {
                i11 = new b();
                i11.a = 29;
                e2.f11192g.add(g(29, e2.f11192g), i11);
            }
            i11.b = 2;
            i11.c = 11;
            i11.f11191f = f(11);
            String format = f11184f.format(new Date(f2));
            try {
                bytes = format.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bytes = format.getBytes();
            }
            System.arraycopy(bytes, 0, i11.f11191f, 0, 10);
        }
    }

    public void l(int i2) {
        b e2 = e(274);
        if (e2 == null) {
            return;
        }
        e2.b = 3;
        e2.c = 1;
        e2.f11190e = f(4);
        j.q(e2.f11190e, j.k(i2), 2, 0, this.f11188e);
    }

    public void m(long j2) {
        q(j2, 36867);
        q(j2, 36868);
    }

    public void n(int i2, int i3) {
        b i4 = i(256, this.b);
        b i5 = i(257, this.b);
        if (i4 != null && i5 != null) {
            i4.b = 4;
            i4.c = 1;
            i4.f11190e = j.r(i2, 4, this.f11188e);
            i5.b = 4;
            i5.c = 1;
            i5.f11190e = j.r(i3, 4, this.f11188e);
        }
        b i6 = i(34665, this.b);
        if (i6 == null || i6.f11192g == null) {
            return;
        }
        b i7 = i(40962, i6.f11192g);
        b i8 = i(40963, i6.f11192g);
        if (i7 == null || i8 == null) {
            return;
        }
        i7.b = 4;
        i7.c = 1;
        i7.f11190e = j.r(i2, 4, this.f11188e);
        i8.b = 4;
        i8.c = 1;
        i8.f11190e = j.r(i3, 4, this.f11188e);
    }

    public void o(String str) {
        b e2;
        if (str == null || "".equals(str) || (e2 = e(305)) == null) {
            return;
        }
        e2.b = 2;
        byte[] bytes = str.getBytes();
        int length = bytes.length + 1;
        if (length <= 4) {
            length = 5;
        }
        byte[] f2 = f(length);
        System.arraycopy(bytes, 0, f2, 0, bytes.length);
        e2.c = length;
        e2.f11191f = f2;
        e2.f11190e = null;
    }
}
