package com.facebook.drawee.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.facebook.drawee.a.b.b;
import com.facebook.drawee.drawable.p;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: DebugControllerOverlayDrawable.java */
/* loaded from: classes.dex */
public class a extends Drawable implements b {
    private String a;
    @Nullable
    private String b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f2441d;

    /* renamed from: e  reason: collision with root package name */
    private int f2442e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f2443f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private p.c f2444g;

    /* renamed from: i  reason: collision with root package name */
    private int f2446i;

    /* renamed from: j  reason: collision with root package name */
    private int f2447j;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private long u;
    @Nullable
    private String v;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, String> f2445h = new HashMap<>();

    /* renamed from: k  reason: collision with root package name */
    private int f2448k = 80;

    /* renamed from: l  reason: collision with root package name */
    private final Paint f2449l = new Paint(1);
    private final Matrix m = new Matrix();
    private final Rect n = new Rect();
    private final RectF o = new RectF();
    private int w = -1;
    private int x = 0;

    public a() {
        h();
    }

    private void b(Canvas canvas, String str, Object obj) {
        d(canvas, str, String.valueOf(obj), -1);
    }

    private void c(Canvas canvas, String str, String str2) {
        d(canvas, str, str2, -1);
    }

    private void d(Canvas canvas, String str, String str2, int i2) {
        String str3 = str + ": ";
        float measureText = this.f2449l.measureText(str3);
        float measureText2 = this.f2449l.measureText(str2);
        this.f2449l.setColor(1711276032);
        int i3 = this.s;
        int i4 = this.t;
        canvas.drawRect(i3 - 4, i4 + 8, i3 + measureText + measureText2 + 4.0f, i4 + this.r + 8, this.f2449l);
        this.f2449l.setColor(-1);
        canvas.drawText(str3, this.s, this.t, this.f2449l);
        this.f2449l.setColor(i2);
        canvas.drawText(str2, this.s + measureText, this.t, this.f2449l);
        this.t += this.r;
    }

    private static String f(String str, @Nullable Object... objArr) {
        return objArr == null ? str : String.format(Locale.US, str, objArr);
    }

    private void g(Rect rect, int i2, int i3) {
        int min = Math.min(40, Math.max(10, Math.min(rect.width() / i3, rect.height() / i2)));
        this.f2449l.setTextSize(min);
        int i4 = min + 8;
        this.r = i4;
        int i5 = this.f2448k;
        if (i5 == 80) {
            this.r = i4 * (-1);
        }
        this.p = rect.left + 10;
        this.q = i5 == 80 ? rect.bottom - 10 : rect.top + 10 + 10;
    }

    @Override // com.facebook.drawee.a.b.b
    public void a(long j2) {
        this.u = j2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.f2449l.setStyle(Paint.Style.STROKE);
        this.f2449l.setStrokeWidth(2.0f);
        this.f2449l.setColor(-26624);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.f2449l);
        this.f2449l.setStyle(Paint.Style.FILL);
        this.f2449l.setColor(this.x);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.f2449l);
        this.f2449l.setStyle(Paint.Style.FILL);
        this.f2449l.setStrokeWidth(0.0f);
        this.f2449l.setColor(-1);
        this.s = this.p;
        this.t = this.q;
        String str = this.b;
        if (str != null) {
            c(canvas, "IDs", f("%s, %s", this.a, str));
        } else {
            c(canvas, "ID", this.a);
        }
        c(canvas, "D", f("%dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height())));
        d(canvas, "I", f("%dx%d", Integer.valueOf(this.c), Integer.valueOf(this.f2441d)), e(this.c, this.f2441d, this.f2444g));
        c(canvas, "I", f("%d KiB", Integer.valueOf(this.f2442e / 1024)));
        String str2 = this.f2443f;
        if (str2 != null) {
            c(canvas, "i format", str2);
        }
        int i2 = this.f2446i;
        if (i2 > 0) {
            c(canvas, "anim", f("f %d, l %d", Integer.valueOf(i2), Integer.valueOf(this.f2447j)));
        }
        p.c cVar = this.f2444g;
        if (cVar != null) {
            b(canvas, "scale", cVar);
        }
        long j2 = this.u;
        if (j2 >= 0) {
            c(canvas, "t", f("%d ms", Long.valueOf(j2)));
        }
        String str3 = this.v;
        if (str3 != null) {
            d(canvas, FirebaseAnalytics.Param.ORIGIN, str3, this.w);
        }
        for (Map.Entry<String, String> entry : this.f2445h.entrySet()) {
            c(canvas, entry.getKey(), entry.getValue());
        }
    }

    @VisibleForTesting
    int e(int i2, int i3, @Nullable p.c cVar) {
        int width = getBounds().width();
        int height = getBounds().height();
        if (width > 0 && height > 0 && i2 > 0 && i3 > 0) {
            if (cVar != null) {
                Rect rect = this.n;
                rect.top = 0;
                rect.left = 0;
                rect.right = width;
                rect.bottom = height;
                this.m.reset();
                cVar.a(this.m, this.n, i2, i3, 0.0f, 0.0f);
                RectF rectF = this.o;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                rectF.right = i2;
                rectF.bottom = i3;
                this.m.mapRect(rectF);
                width = Math.min(width, (int) this.o.width());
                height = Math.min(height, (int) this.o.height());
            }
            float f2 = width;
            float f3 = f2 * 0.1f;
            float f4 = f2 * 0.5f;
            float f5 = height;
            float f6 = 0.1f * f5;
            float f7 = f5 * 0.5f;
            int abs = Math.abs(i2 - width);
            int abs2 = Math.abs(i3 - height);
            float f8 = abs;
            if (f8 < f3 && abs2 < f6) {
                return -16711936;
            }
            if (f8 < f4 && abs2 < f7) {
                return InputDeviceCompat.SOURCE_ANY;
            }
        }
        return SupportMenu.CATEGORY_MASK;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h() {
        this.c = -1;
        this.f2441d = -1;
        this.f2442e = -1;
        this.f2445h = new HashMap<>();
        this.f2446i = -1;
        this.f2447j = -1;
        this.f2443f = null;
        i(null);
        this.u = -1L;
        this.v = null;
        this.w = -1;
        invalidateSelf();
    }

    public void i(@Nullable String str) {
        if (str == null) {
            str = PortalFollowFeeds.TYPE_NONE;
        }
        this.a = str;
        invalidateSelf();
    }

    public void j(int i2, int i3) {
        this.c = i2;
        this.f2441d = i3;
        invalidateSelf();
    }

    public void k(int i2) {
        this.f2442e = i2;
    }

    public void l(String str, int i2) {
        this.v = str;
        this.w = i2;
        invalidateSelf();
    }

    public void m(p.c cVar) {
        this.f2444g = cVar;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        g(rect, 9, 8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
