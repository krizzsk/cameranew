package us.pinguo.widget.discreteseekbar.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.util.Calendar;
import us.pinguo.widget.discreteseekbar.internal.a.c;
import us.pinguo.widget.discreteseekbar.internal.b.b;
/* loaded from: classes6.dex */
public class PopupIndicator {
    private final WindowManager a;
    private boolean b;
    private Floater c;

    /* renamed from: d  reason: collision with root package name */
    private b.InterfaceC0469b f12550d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f12551e = new int[2];

    /* renamed from: f  reason: collision with root package name */
    Point f12552f = new Point();

    /* renamed from: g  reason: collision with root package name */
    private long f12553g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class Floater extends FrameLayout implements b.InterfaceC0469b {
        private Marker a;
        private int b;

        public Floater(Context context, AttributeSet attributeSet, int i2, String str, int i3, int i4, boolean z, ColorStateList colorStateList, int i5) {
            super(context);
            Marker marker = new Marker(context, attributeSet, i2, str, i3, i4, z, colorStateList, i5);
            this.a = marker;
            addView(marker, new FrameLayout.LayoutParams(-2, -2, 51));
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.b.b.InterfaceC0469b
        public void a() {
            if (PopupIndicator.this.f12550d != null) {
                PopupIndicator.this.f12550d.a();
            }
            PopupIndicator.this.f();
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.b.b.InterfaceC0469b
        public void b() {
            if (PopupIndicator.this.f12550d != null) {
                PopupIndicator.this.f12550d.b();
            }
        }

        public void d(int i2, int i3) {
            this.a.setColors(i2, i3);
        }

        public void e(int i2) {
            this.b = i2;
            int measuredWidth = i2 - (this.a.getMeasuredWidth() / 2);
            Marker marker = this.a;
            marker.offsetLeftAndRight(measuredWidth - marker.getLeft());
            if (c.b(this)) {
                return;
            }
            invalidate();
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            int measuredWidth = this.b - (this.a.getMeasuredWidth() / 2);
            Marker marker = this.a;
            marker.layout(measuredWidth, 0, marker.getMeasuredWidth() + measuredWidth, this.a.getMeasuredHeight());
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            measureChildren(i2, i3);
            setMeasuredDimension(View.MeasureSpec.getSize(i2), this.a.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupIndicator.this.c.a.c();
        }
    }

    public PopupIndicator(Context context, AttributeSet attributeSet, int i2, String str, int i3, int i4, boolean z, ColorStateList colorStateList, int i5) {
        this.a = (WindowManager) context.getSystemService("window");
        this.c = new Floater(context, attributeSet, i2, str, i3, i4, z, colorStateList, i5);
    }

    private int c(int i2) {
        return (i2 & (-426521)) | 32768 | 8 | 16 | 512;
    }

    private WindowManager.LayoutParams d(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.flags = c(layoutParams.flags);
        layoutParams.type = 1000;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = 3;
        layoutParams.setTitle("DiscreteSeekBar Indicator:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    private void g(WindowManager.LayoutParams layoutParams) {
        this.a.addView(this.c, layoutParams);
        this.c.a.d();
    }

    private void i() {
        this.c.measure(View.MeasureSpec.makeMeasureSpec(this.f12552f.x, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f12552f.y, Integer.MIN_VALUE));
    }

    private void o(int i2) {
        this.c.e(i2 + this.f12551e[0]);
    }

    private void p(View view, WindowManager.LayoutParams layoutParams, int i2) {
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        this.f12552f.set(displayMetrics.widthPixels, displayMetrics.heightPixels);
        i();
        int measuredHeight = this.c.getMeasuredHeight();
        int paddingBottom = this.c.a.getPaddingBottom();
        view.getLocationInWindow(this.f12551e);
        layoutParams.x = 0;
        layoutParams.y = (this.f12551e[1] - measuredHeight) + i2 + paddingBottom;
        layoutParams.width = this.f12552f.x;
        layoutParams.height = measuredHeight;
    }

    public void e() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis() - this.f12553g;
        if (timeInMillis >= 800) {
            this.c.a.c();
        } else {
            this.c.postDelayed(new a(), 800 - timeInMillis);
        }
    }

    public void f() {
        if (h()) {
            this.b = false;
            this.a.removeViewImmediate(this.c);
        }
    }

    public boolean h() {
        return this.b;
    }

    public void j(int i2) {
        if (h()) {
            o(i2);
        }
    }

    public void k(int i2, int i3) {
        this.c.d(i2, i3);
    }

    public void l(b.InterfaceC0469b interfaceC0469b) {
        this.f12550d = interfaceC0469b;
    }

    public void m(CharSequence charSequence) {
        this.c.a.setValue(charSequence);
    }

    public void n(View view, Rect rect) {
        this.f12553g = Calendar.getInstance().getTimeInMillis();
        if (h()) {
            this.c.a.d();
            return;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken != null) {
            WindowManager.LayoutParams d2 = d(windowToken);
            d2.gravity = 8388659;
            p(view, d2, rect.bottom);
            this.b = true;
            o(rect.centerX());
            g(d2);
        }
    }

    public void q(String str) {
        f();
        Floater floater = this.c;
        if (floater != null) {
            floater.a.e(str);
        }
    }
}
