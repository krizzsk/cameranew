package com.pinguo.camera360.test;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.io.File;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import us.pinguo.camera360.shop.data.FilterType;
/* compiled from: PhotoTestManager.java */
/* loaded from: classes3.dex */
public class t0 implements Runnable {
    private final List<us.pinguo.camera360.shop.data.h> a;

    /* renamed from: f  reason: collision with root package name */
    private u0 f6989f;
    private byte[] c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f6987d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6988e = false;

    /* renamed from: g  reason: collision with root package name */
    private int f6990g = 30;

    /* renamed from: h  reason: collision with root package name */
    private File[] f6991h = null;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6992i = false;
    private final String b = us.pinguo.foundation.utils.c0.c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PhotoTestManager.java */
    /* loaded from: classes3.dex */
    public class a implements us.pinguo.poker.n {
        final /* synthetic */ String a;
        final /* synthetic */ boolean[] b;
        final /* synthetic */ CountDownLatch c;

        a(t0 t0Var, String str, boolean[] zArr, CountDownLatch countDownLatch) {
            this.a = str;
            this.b = zArr;
            this.c = countDownLatch;
        }

        @Override // us.pinguo.poker.n
        public void a(byte[] bArr, String str) {
            us.pinguo.util.l.d(str, this.a);
            this.b[0] = new File(str).exists();
            this.c.countDown();
        }

        @Override // us.pinguo.poker.n
        public void b(int i2, String str) {
            this.c.countDown();
        }

        @Override // us.pinguo.poker.n
        public void c(us.pinguo.poker.s sVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t0(List<us.pinguo.camera360.shop.data.h> list) {
        this.a = list;
    }

    private boolean a(Effect effect, byte[] bArr, String str, String str2, int i2, Point point, Point point2, String[] strArr) {
        boolean[] zArr = new boolean[1];
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Effect.Version version = Effect.Version.latest;
        if (TextUtils.isEmpty(effect.getOnLineParam(version))) {
            com.pinguo.camera360.m.b bVar = new com.pinguo.camera360.m.b();
            bVar.q(null);
            bVar.m(effect);
            bVar.n(effect.getKey());
            bVar.p(str2);
            bVar.w(str);
            bVar.B(i2);
            bVar.A(new com.pinguo.camera360.k.a.a.a.b(point2.x, point2.y));
            bVar.x(new com.pinguo.camera360.k.a.a.a.b(point.x, point.y));
            int i3 = this.f6990g;
            if (i3 >= 0 && i3 <= 100) {
                float a2 = com.pinguo.camera360.utils.b.a(effect, i3);
                if (strArr != null && strArr.length > 0) {
                    strArr[0] = String.valueOf(a2);
                }
                if (this.f6992i) {
                    bVar.s(true);
                    bVar.C((int) ((a2 * 1000.0f) + 0.5f));
                }
            } else {
                if (strArr != null && strArr.length > 0) {
                    strArr[0] = "0";
                }
                if (this.f6992i) {
                    bVar.s(true);
                    bVar.C(0);
                }
            }
        } else {
            us.pinguo.poker.o e2 = us.pinguo.poker.o.e();
            e2.d(new us.pinguo.poker.m(str + String.valueOf(System.currentTimeMillis()), bArr, effect.getOnLineParam(version), 0), new a(this, str2, zArr, countDownLatch));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return zArr[0];
    }

    private String c(int i2) {
        if (i2 < 10) {
            return "00" + i2;
        } else if (i2 < 100) {
            return "0" + i2;
        } else {
            return String.valueOf(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f6988e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f6988e;
    }

    public void e(u0 u0Var) {
        this.f6989f = u0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(File[] fileArr, int i2, boolean z) {
        if (this.f6988e) {
            return;
        }
        this.f6988e = true;
        this.f6990g = i2;
        this.f6991h = fileArr;
        this.f6992i = z;
        new Thread(this).start();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2;
        int i3;
        List<us.pinguo.camera360.shop.data.g> list;
        us.pinguo.camera360.shop.data.h hVar;
        int i4;
        String str;
        Point point;
        int i5;
        us.pinguo.util.l.f(this.b + "/test_data");
        int size = this.a.size();
        int length = this.f6991h.length;
        int i6 = 0;
        int i7 = 0;
        while (i7 < length && this.f6988e) {
            File file = this.f6991h[i7];
            String absolutePath = file.getAbsolutePath();
            Point m = us.pinguo.util.e.m(absolutePath);
            Point point2 = new Point();
            String substring = absolutePath.substring(i6, absolutePath.length() - 4);
            us.pinguo.util.l.f(substring);
            this.f6987d = us.pinguo.util.j.j(this.c);
            byte[] b = us.pinguo.util.k.b(file);
            this.c = b;
            int i8 = 1;
            Bitmap w = us.pinguo.util.e.w(b, 1280, 1, true);
            point2.x = w.getWidth();
            point2.y = w.getHeight();
            int i9 = 0;
            while (i9 < size && this.f6988e) {
                us.pinguo.camera360.shop.data.h hVar2 = this.a.get(i9);
                FilterType[] filterTypeArr = new FilterType[i8];
                filterTypeArr[i6] = FilterType.Effect;
                List<us.pinguo.camera360.shop.data.g> c = hVar2.c(filterTypeArr);
                int size2 = c.size();
                int i10 = 0;
                while (i10 < size2 && this.f6988e) {
                    us.pinguo.camera360.shop.data.g gVar = c.get(i10);
                    if (gVar instanceof Effect) {
                        Effect effect = (Effect) gVar;
                        StringBuilder sb = new StringBuilder();
                        sb.append(c(i9));
                        sb.append('_');
                        i2 = i10;
                        sb.append(hVar2.g());
                        sb.append('_');
                        sb.append(effect.getNameCN());
                        sb.append(".jpg");
                        String sb2 = sb.toString();
                        String[] strArr = new String[1];
                        int i11 = size2;
                        byte[] bArr = this.c;
                        String absolutePath2 = file.getAbsolutePath();
                        i3 = i11;
                        list = c;
                        hVar = hVar2;
                        i4 = i9;
                        i5 = size;
                        str = substring;
                        point = point2;
                        boolean a2 = a(effect, bArr, absolutePath2, substring + "/" + sb2, this.f6987d, m, point2, strArr);
                        u0 u0Var = this.f6989f;
                        if (u0Var != null) {
                            if (a2) {
                                u0Var.t(sb2 + "  " + strArr[0]);
                            } else {
                                u0Var.s(sb2);
                            }
                        }
                    } else {
                        i2 = i10;
                        i3 = size2;
                        list = c;
                        hVar = hVar2;
                        i4 = i9;
                        str = substring;
                        point = point2;
                        i5 = size;
                    }
                    i10 = i2 + 1;
                    size2 = i3;
                    c = list;
                    hVar2 = hVar;
                    size = i5;
                    i9 = i4;
                    substring = str;
                    point2 = point;
                }
                i9++;
                size = size;
                substring = substring;
                point2 = point2;
                i8 = 1;
                i6 = 0;
            }
            i7++;
            size = size;
            i6 = 0;
        }
        this.f6988e = false;
        u0 u0Var2 = this.f6989f;
        if (u0Var2 != null) {
            u0Var2.e0();
        }
    }
}
