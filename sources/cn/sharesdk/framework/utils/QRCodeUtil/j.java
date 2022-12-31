package cn.sharesdk.framework.utils.QRCodeUtil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import java.io.FileInputStream;
import java.util.HashMap;
/* compiled from: QRCode.java */
/* loaded from: classes.dex */
public class j {
    private float C;
    private Bitmap G;
    private boolean H;
    private float[] J;
    private float[] K;
    private float[] L;
    protected Bitmap a;
    private Point B = new Point();
    private int D = 400;
    private int E = 400;
    protected Point b = new Point();
    protected Point c = new Point(400, 400);

    /* renamed from: d  reason: collision with root package name */
    protected String f199d = null;

    /* renamed from: e  reason: collision with root package name */
    protected int f200e = 1;

    /* renamed from: f  reason: collision with root package name */
    protected String f201f = null;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f202g = true;

    /* renamed from: h  reason: collision with root package name */
    protected int f203h = 0;

    /* renamed from: i  reason: collision with root package name */
    protected Bitmap f204i = null;

    /* renamed from: j  reason: collision with root package name */
    protected Drawable f205j = null;

    /* renamed from: k  reason: collision with root package name */
    protected String f206k = null;

    /* renamed from: l  reason: collision with root package name */
    protected String f207l = null;
    protected int n = 6;
    protected boolean o = true;
    protected int p = 0;
    protected Bitmap q = null;
    protected Drawable r = null;
    protected String s = null;
    protected String t = null;
    protected int u = 6;
    protected boolean v = true;
    private boolean I = true;
    private int y = 400;
    private int w = 400;
    private int x = 400;
    private int z = 0;
    private int A = 80;
    protected int m = -1;
    private int F = ViewCompat.MEASURED_STATE_MASK;
    private k M = new k();

    public j() {
        e();
    }

    private void e() {
        Point point = this.c;
        int i2 = point.x;
        Point point2 = this.b;
        int i3 = i2 - point2.x;
        int i4 = point.y - point2.y;
        int sqrt = (int) (Math.sqrt(((i3 * i3) + (i4 * i4)) * 2) / 2.0d);
        this.y = sqrt;
        Point point3 = this.B;
        Point point4 = this.c;
        int i5 = point4.x;
        Point point5 = this.b;
        point3.x = (i5 + point5.x) / 2;
        point3.y = (point4.y + point5.y) / 2;
        this.A = (int) (sqrt * 0.2d);
        this.C = (float) (Math.toDegrees(Math.atan2(i4, i3)) - 45.0d);
    }

    public void a(int i2, int i3) {
        if (this.H) {
            return;
        }
        this.w = i2;
        this.x = i3;
        this.I = true;
    }

    public void b(String str) {
        String str2;
        if (this.H) {
            return;
        }
        if (this.f200e == 2 && (str2 = this.f201f) != null && str2.equals(str)) {
            return;
        }
        this.f201f = str;
        this.f200e = 2;
        this.f202g = true;
        this.I = true;
    }

    public void c(String str, boolean z) {
        if (str == null || str.length() == 0 || this.H) {
            return;
        }
        if (z || this.u >= 4) {
            String str2 = this.s;
            if (str2 != null && str2.equals(str) && this.u == 4) {
                return;
            }
            this.s = str;
            this.u = 4;
            this.v = true;
            this.I = true;
        }
    }

    public void d(String str, boolean z) {
        if (str == null || str.length() == 0 || this.H) {
            return;
        }
        if (z || this.u >= 5) {
            String str2 = this.t;
            if (str2 != null && str2.equals(str) && this.u == 5) {
                return;
            }
            this.t = str;
            this.u = 5;
            this.v = true;
            this.I = true;
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (this.H) {
            return;
        }
        Point point = this.b;
        point.x = i2;
        point.y = i3;
        Point point2 = this.c;
        point2.x = i4;
        point2.y = i5;
        e();
        this.I = true;
    }

    public void b(String str, boolean z) {
        if (str == null || str.length() == 0 || this.H) {
            return;
        }
        if (z || this.n >= 5) {
            String str2 = this.f207l;
            if (str2 != null && str2.equals(str) && this.n == 5) {
                return;
            }
            this.f207l = str;
            this.n = 5;
            this.o = true;
            this.I = true;
        }
    }

    private int d(int i2, int i3) {
        float[] fArr = this.L;
        int i4 = (int) (i2 * fArr[0]);
        int i5 = (int) (i3 * fArr[1]);
        if (i4 >= this.q.getWidth()) {
            i4 = this.q.getWidth() - 1;
        }
        if (i5 >= this.q.getHeight()) {
            i5 = this.q.getHeight() - 1;
        }
        return this.q.getPixel(i4, i5);
    }

    public void c(int i2) {
        if ((i2 >>> 24) == 0) {
            i2 |= ViewCompat.MEASURED_STATE_MASK;
        }
        if (this.H || this.F == i2) {
            return;
        }
        this.F = i2;
        this.I = true;
    }

    private int c(int i2, int i3) {
        float[] fArr = this.K;
        if (fArr == null) {
            return this.F;
        }
        return this.G.getPixel((int) (i2 * fArr[0]), (int) (i3 * fArr[1]));
    }

    public void a(String str) {
        String str2;
        if (this.H) {
            return;
        }
        if (this.f200e == 1 && (str2 = this.f199d) != null && str2.equals(str)) {
            return;
        }
        this.f199d = str;
        this.f200e = 1;
        this.f202g = true;
        this.I = true;
    }

    public void b(int i2) {
        if (i2 <= 0 || this.H) {
            return;
        }
        if (this.p == i2 && this.u == 1) {
            return;
        }
        this.p = i2;
        this.u = 1;
        this.v = true;
        this.I = true;
    }

    private void d() throws Throwable {
        int i2;
        int i3;
        if (this.o && (i3 = this.n) != 6) {
            if (i3 == 1) {
                this.f204i = BitmapFactory.decodeResource(MobSDK.getContext().getResources(), this.f203h);
            } else if (i3 == 3) {
                this.f204i = a(this.f205j);
            } else if (i3 == 4) {
                this.f204i = BitmapFactory.decodeStream(new FileInputStream(this.f206k));
            } else if (i3 == 5) {
                this.f204i = BitmapFactory.decodeStream(new FileInputStream(BitmapHelper.downloadBitmap(MobSDK.getContext(), this.f207l)));
            }
            this.o = false;
        }
        if (!this.v || (i2 = this.u) == 6) {
            return;
        }
        if (i2 == 1) {
            this.q = BitmapFactory.decodeResource(MobSDK.getContext().getResources(), this.p);
        } else if (i2 == 3) {
            this.q = a(this.r);
        } else if (i2 == 4) {
            this.q = BitmapFactory.decodeStream(new FileInputStream(this.s));
        } else if (i2 == 5) {
            this.q = BitmapFactory.decodeStream(new FileInputStream(BitmapHelper.downloadBitmap(MobSDK.getContext(), this.t)));
        }
        this.v = false;
    }

    private void c() throws Throwable {
        if (this.f202g && this.f200e == 1) {
            this.f201f = this.f199d;
        }
    }

    public void a(int i2) {
        if (i2 <= 0 || this.H) {
            return;
        }
        if (this.f203h == i2 && this.n == 1) {
            return;
        }
        this.f203h = i2;
        this.o = true;
        this.n = 1;
        this.I = true;
    }

    public void b(Bitmap bitmap, boolean z) {
        if (bitmap == null || this.H) {
            return;
        }
        if (z || this.u >= 2) {
            if (this.q == bitmap && this.u == 2) {
                return;
            }
            this.q = bitmap;
            this.u = 2;
            this.v = true;
            this.I = true;
        }
    }

    public void a(Bitmap bitmap, boolean z) {
        if (bitmap == null || this.H) {
            return;
        }
        if (z || this.n >= 2) {
            if (this.f204i == bitmap && this.n == 2) {
                return;
            }
            this.f204i = bitmap;
            this.n = 2;
            this.o = true;
            this.I = true;
        }
    }

    public void b(Drawable drawable, boolean z) {
        if (drawable == null || this.H) {
            return;
        }
        if (z || this.u >= 3) {
            if (this.r == drawable && this.u == 3) {
                return;
            }
            this.r = drawable;
            this.u = 3;
            this.v = true;
            this.I = true;
        }
    }

    public void a(Drawable drawable, boolean z) {
        if (drawable == null || this.H) {
            return;
        }
        if (z || this.n >= 3) {
            if (this.f205j != drawable || this.n < 3) {
                this.f205j = drawable;
                this.n = 3;
                this.o = true;
                this.I = true;
            }
        }
    }

    public synchronized Bitmap b() throws Throwable {
        if (this.I) {
            this.H = true;
            c();
            if (this.f201f != null) {
                d();
                Bitmap bitmap = this.f204i;
                if (bitmap != null) {
                    int width = bitmap.getWidth();
                    int i2 = this.D;
                    if (width >= i2) {
                        i2 = this.f204i.getWidth();
                    }
                    this.w = i2;
                    int height = this.f204i.getHeight();
                    int i3 = this.E;
                    if (height >= i3) {
                        i3 = this.f204i.getHeight();
                    }
                    this.x = i3;
                }
                int i4 = this.w;
                int i5 = this.x;
                Bitmap bitmap2 = this.f204i;
                this.a = Bitmap.createBitmap(i4, i5, bitmap2 == null ? Bitmap.Config.ARGB_8888 : bitmap2.getConfig());
                Canvas canvas = new Canvas(this.a);
                a(canvas);
                b(canvas);
                this.H = false;
                this.I = false;
            } else {
                throw new Error("content can not be null,please set url or uri before generate qrcode!");
            }
        }
        return this.a;
    }

    public void a(String str, boolean z) {
        if (str == null || str.length() == 0 || this.H) {
            return;
        }
        if (z || this.n >= 4) {
            String str2 = this.f206k;
            if (str2 != null && str2.equals(str) && this.n == 4) {
                return;
            }
            this.f206k = str;
            this.n = 4;
            this.o = true;
            this.I = true;
        }
    }

    public Bitmap a() {
        return this.a;
    }

    private void a(Canvas canvas) {
        Bitmap bitmap = this.f204i;
        if (bitmap != null) {
            int i2 = this.x;
            this.J = new float[]{bitmap.getWidth() / this.w, this.f204i.getHeight() / i2};
            int[] iArr = new int[this.w * i2];
            int i3 = 0;
            while (true) {
                int i4 = this.x;
                if (i3 >= i4) {
                    Bitmap bitmap2 = this.a;
                    int i5 = this.w;
                    bitmap2.setPixels(iArr, 0, i5, 0, 0, i5, i4);
                    return;
                }
                int i6 = 0;
                while (true) {
                    int i7 = this.w;
                    if (i6 < i7) {
                        iArr[(i7 * i3) + i6] = b(i6, i3);
                        i6++;
                    }
                }
                i3++;
            }
        } else {
            canvas.drawColor(this.m);
        }
    }

    private int b(int i2, int i3) {
        float[] fArr = this.J;
        if (fArr == null) {
            return this.m;
        }
        return this.f204i.getPixel((int) (i2 * fArr[0]), (int) (i3 * fArr[1]));
    }

    private Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void b(Canvas canvas) throws Throwable {
        Bitmap bitmap = this.G;
        if (bitmap != null) {
            this.K = new float[]{bitmap.getWidth() / this.y, this.G.getHeight() / this.y};
        }
        l lVar = new l();
        HashMap hashMap = new HashMap();
        hashMap.put(e.CHARACTER_SET, "utf-8");
        hashMap.put(e.MARGIN, Integer.valueOf(this.z));
        hashMap.put(e.ERROR_CORRECTION, f.H);
        String str = this.f201f;
        a aVar = a.QR_CODE;
        int i2 = this.y;
        c encode = lVar.encode(str, aVar, i2, i2, hashMap);
        int i3 = this.y;
        int[] iArr = new int[i3 * i3];
        for (int i4 = 0; i4 < this.y; i4++) {
            for (int i5 = 0; i5 < this.y; i5++) {
                if (encode.a(i5, i4)) {
                    iArr[(this.y * i4) + i5] = c(i5, i4);
                } else {
                    iArr[(this.y * i4) + i5] = 0;
                }
            }
        }
        Bitmap bitmap2 = this.q;
        if (bitmap2 != null) {
            int i6 = this.A;
            this.L = new float[]{bitmap2.getWidth() / this.A, this.q.getHeight() / i6};
            int i7 = this.y;
            int i8 = (i7 - i6) / 2;
            int i9 = (i7 + i6) / 2;
            for (int i10 = i8; i10 < i9; i10++) {
                for (int i11 = i8; i11 < i9; i11++) {
                    iArr[(this.y * i10) + i11] = d(i11 - i8, i10 - i8);
                }
            }
        }
        int i12 = this.y;
        Bitmap createBitmap = Bitmap.createBitmap(iArr, i12, i12, Bitmap.Config.ARGB_8888);
        Point point = this.B;
        canvas.translate(point.x, point.y);
        canvas.rotate(this.C);
        int i13 = this.y;
        canvas.translate((-i13) / 2, (-i13) / 2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
    }
}
