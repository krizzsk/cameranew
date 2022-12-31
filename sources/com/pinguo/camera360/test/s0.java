package com.pinguo.camera360.test;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.text.TextUtils;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import us.pinguo.camera360.shop.data.FilterType;
/* compiled from: PhotoCustomTestManager.java */
/* loaded from: classes3.dex */
public class s0 implements Runnable {
    private final List<us.pinguo.camera360.shop.data.h> a;
    private List<r0> b;
    private final String c;

    /* renamed from: e  reason: collision with root package name */
    private u0 f6984e;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6983d = false;

    /* renamed from: f  reason: collision with root package name */
    private int f6985f = 30;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6986g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PhotoCustomTestManager.java */
    /* loaded from: classes3.dex */
    public class a implements us.pinguo.poker.n {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ String b;
        final /* synthetic */ CountDownLatch c;

        a(s0 s0Var, boolean[] zArr, String str, CountDownLatch countDownLatch) {
            this.a = zArr;
            this.b = str;
            this.c = countDownLatch;
        }

        @Override // us.pinguo.poker.n
        public void a(byte[] bArr, String str) {
            this.a[0] = true;
            us.pinguo.util.l.d(str, this.b);
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
    public s0(List<us.pinguo.camera360.shop.data.h> list) {
        Resources.getSystem().getDisplayMetrics();
        this.a = list;
        this.c = us.pinguo.foundation.utils.c0.c();
    }

    private boolean a(byte[] bArr, String str) {
        return false;
    }

    private String b(String str) {
        FileOutputStream fileOutputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Exception unused) {
        }
        try {
            decodeFile.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream);
        } catch (Exception unused2) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                us.pinguo.util.f.a(fileOutputStream2);
            }
            return str;
        }
        return str;
    }

    private boolean c(Effect effect, byte[] bArr, String str, String str2, int i2, Point point, Point point2, String[] strArr) {
        boolean[] zArr = {false};
        CountDownLatch countDownLatch = new CountDownLatch(1);
        if (effect.getFliterType() != FilterType.Loc && TextUtils.isEmpty(effect.getOnLineParam(Effect.Version.latest))) {
            com.pinguo.camera360.m.b bVar = new com.pinguo.camera360.m.b();
            bVar.q(null);
            bVar.m(effect);
            bVar.n(effect.getKey());
            bVar.p(str2);
            bVar.w(str);
            bVar.B(i2);
            bVar.A(new com.pinguo.camera360.k.a.a.a.b(point2.x, point2.y));
            bVar.x(new com.pinguo.camera360.k.a.a.a.b(point.x, point.y));
            int i3 = this.f6985f;
            if (i3 >= 0 && i3 <= 100) {
                float a2 = com.pinguo.camera360.utils.b.a(effect, i3);
                if (strArr != null && strArr.length > 0) {
                    strArr[0] = String.valueOf(a2);
                }
                if (this.f6986g) {
                    bVar.s(true);
                    bVar.C((int) ((a2 * 1000.0f) + 0.5f));
                }
            } else {
                if (strArr != null && strArr.length > 0) {
                    strArr[0] = "0";
                }
                if (this.f6986g) {
                    bVar.s(true);
                    bVar.C(0);
                }
            }
        } else {
            Effect.Version version = Effect.Version.latest;
            if (!TextUtils.isEmpty(effect.getOnLineParam(version))) {
                us.pinguo.poker.o e2 = us.pinguo.poker.o.e();
                e2.d(new us.pinguo.poker.m(str + String.valueOf(System.currentTimeMillis()), bArr, effect.getOnLineParam(version), 0), new a(this, zArr, str2, countDownLatch));
            }
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return zArr[0];
    }

    private us.pinguo.camera360.shop.data.h d(String str) {
        for (us.pinguo.camera360.shop.data.h hVar : this.a) {
            if (hVar.f().equals(str)) {
                return hVar;
            }
        }
        return null;
    }

    private String f(int i2) {
        if (i2 < 10) {
            return "0" + i2;
        }
        return String.valueOf(i2);
    }

    private boolean g(byte[] bArr, Point point, String str) {
        int i2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = true;
        FileOutputStream fileOutputStream = null;
        BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
        int i3 = options.outWidth;
        if (i3 >= 1 && (i2 = options.outHeight) >= 1) {
            int min = (int) (Math.min(i3 / point.x, i2 / point.y) - 1.0f);
            int i4 = 2;
            if (min > 16) {
                i4 = 16;
            } else if (min > 8) {
                i4 = 8;
            } else if (min > 4) {
                i4 = 4;
            } else if (min <= 2) {
                i4 = 1;
            }
            options.inSampleSize = i4;
            options.inJustDecodeBounds = false;
            options.inDither = false;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
            Matrix matrix = new Matrix();
            matrix.postScale((point.x + 0.2f) / decodeStream.getWidth(), (point.y + 0.2f) / decodeStream.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream2);
                    us.pinguo.util.f.a(fileOutputStream2);
                    return true;
                } catch (Exception unused) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        us.pinguo.util.f.a(fileOutputStream);
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        us.pinguo.util.f.a(fileOutputStream);
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f6983d = false;
    }

    public void h(u0 u0Var) {
        this.f6984e = u0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(List<r0> list) {
        if (this.f6983d) {
            return;
        }
        this.f6983d = true;
        this.b = list;
        new Thread(this).start();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2;
        int i3;
        String str;
        String str2;
        int i4;
        List<us.pinguo.camera360.shop.data.g> list;
        String str3;
        us.pinguo.camera360.shop.data.h hVar;
        byte[] bArr;
        String str4;
        int i5;
        String str5;
        String str6;
        us.pinguo.util.l.f(this.c + "/test_data");
        int size = this.b.size();
        int i6 = 0;
        int i7 = 0;
        while (i7 < size && this.f6983d) {
            r0 r0Var = this.b.get(i7);
            String str7 = "/sdcard/c360_filter/" + r0Var.b();
            Point m = us.pinguo.util.e.m(str7);
            Point point = new Point();
            if (str7.endsWith(".png")) {
                b(str7);
            }
            byte[] c = us.pinguo.util.k.c(str7);
            if (c == null) {
                this.f6984e.s("error_readfile:" + str7);
            } else {
                int j2 = us.pinguo.util.j.j(c);
                us.pinguo.camera360.shop.data.h d2 = d(r0Var.a());
                String str8 = "_";
                if (d2 == null) {
                    this.f6984e.s("error_" + r0Var.a() + "_" + r0Var.b());
                } else {
                    FilterType[] filterTypeArr = new FilterType[1];
                    filterTypeArr[i6] = FilterType.Effect;
                    List<us.pinguo.camera360.shop.data.g> c2 = d2.c(filterTypeArr);
                    int size2 = c2.size();
                    List<Point> c3 = r0Var.c();
                    String b = r0Var.b();
                    String str9 = b.substring(i6, b.length() - 4) + "_" + d2.g();
                    StringBuilder sb = new StringBuilder();
                    String str10 = "/sdcard/c360_filter_result/";
                    sb.append("/sdcard/c360_filter_result/");
                    sb.append(str9);
                    String str11 = "/";
                    sb.append("/");
                    i2 = size;
                    sb.append(f(i6));
                    sb.append("_原图.jpg");
                    String sb2 = sb.toString();
                    us.pinguo.util.l.e(new File(sb2).getParentFile());
                    if (!a(c, sb2)) {
                        us.pinguo.util.k.i(sb2, c);
                    }
                    String str12 = "x";
                    if (c3.size() > 0) {
                        Iterator<Point> it = c3.iterator();
                        while (it.hasNext()) {
                            Iterator<Point> it2 = it;
                            Point next = it.next();
                            int i8 = i7;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("/sdcard/c360_filter_result/");
                            sb3.append(str9);
                            sb3.append("_");
                            Point point2 = point;
                            sb3.append(next.x);
                            sb3.append(str12);
                            sb3.append(next.y);
                            sb3.append("/");
                            String str13 = str12;
                            sb3.append(f(0));
                            sb3.append("_原图.jpg");
                            String sb4 = sb3.toString();
                            us.pinguo.util.l.e(new File(sb4).getParentFile());
                            if (g(c, next, sb4)) {
                                this.f6984e.t(sb4);
                            } else {
                                this.f6984e.s(sb4);
                            }
                            i7 = i8;
                            it = it2;
                            point = point2;
                            str12 = str13;
                        }
                    }
                    String str14 = str12;
                    i3 = i7;
                    Point point3 = point;
                    int i9 = 0;
                    while (i9 < size2 && this.f6983d) {
                        us.pinguo.camera360.shop.data.g gVar = c2.get(i9);
                        if (gVar instanceof Effect) {
                            Effect effect = (Effect) gVar;
                            if (effect.getFliterType() == FilterType.Loc) {
                                this.f6984e.s("不支持批量处理大片滤镜:" + d2.h() + str11 + effect.getNameCN());
                            } else {
                                String str15 = str11 + f(i9 + 1) + str8 + effect.getNameCN() + ".jpg";
                                String str16 = str10 + str9 + str15;
                                us.pinguo.util.l.e(new File(str16).getParentFile());
                                i5 = i9;
                                String str17 = str15;
                                str = str10;
                                str2 = str9;
                                i4 = size2;
                                String str18 = str7;
                                list = c2;
                                str3 = str11;
                                str4 = str7;
                                str6 = str8;
                                hVar = d2;
                                bArr = c;
                                boolean c4 = c(effect, c, str18, str16, j2, m, point3, new String[1]);
                                u0 u0Var = this.f6984e;
                                if (u0Var != null) {
                                    if (c4) {
                                        byte[] c5 = us.pinguo.util.k.c(str16);
                                        a(c5, str16);
                                        this.f6984e.t(str16);
                                        if (c3.size() > 0) {
                                            for (Point point4 : c3) {
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append(str);
                                                sb5.append(str2);
                                                sb5.append(str6);
                                                sb5.append(point4.x);
                                                String str19 = str14;
                                                sb5.append(str19);
                                                sb5.append(point4.y);
                                                String str20 = str17;
                                                sb5.append(str20);
                                                String sb6 = sb5.toString();
                                                if (g(c5, point4, sb6)) {
                                                    this.f6984e.t(sb6);
                                                } else {
                                                    this.f6984e.s(sb6);
                                                }
                                                str14 = str19;
                                                str17 = str20;
                                            }
                                        }
                                    } else {
                                        str5 = str14;
                                        u0Var.s("make filed:" + str16);
                                        i9 = i5 + 1;
                                        str14 = str5;
                                        str9 = str2;
                                        str10 = str;
                                        str8 = str6;
                                        str11 = str3;
                                        size2 = i4;
                                        c2 = list;
                                        str7 = str4;
                                        d2 = hVar;
                                        c = bArr;
                                    }
                                }
                                str5 = str14;
                                i9 = i5 + 1;
                                str14 = str5;
                                str9 = str2;
                                str10 = str;
                                str8 = str6;
                                str11 = str3;
                                size2 = i4;
                                c2 = list;
                                str7 = str4;
                                d2 = hVar;
                                c = bArr;
                            }
                        }
                        str = str10;
                        str2 = str9;
                        i4 = size2;
                        list = c2;
                        str3 = str11;
                        hVar = d2;
                        bArr = c;
                        str4 = str7;
                        i5 = i9;
                        str5 = str14;
                        str6 = str8;
                        i9 = i5 + 1;
                        str14 = str5;
                        str9 = str2;
                        str10 = str;
                        str8 = str6;
                        str11 = str3;
                        size2 = i4;
                        c2 = list;
                        str7 = str4;
                        d2 = hVar;
                        c = bArr;
                    }
                    i7 = i3 + 1;
                    size = i2;
                    i6 = 0;
                }
            }
            i2 = size;
            i3 = i7;
            i7 = i3 + 1;
            size = i2;
            i6 = 0;
        }
        this.f6983d = false;
        u0 u0Var2 = this.f6984e;
        if (u0Var2 != null) {
            u0Var2.e0();
        }
    }
}
