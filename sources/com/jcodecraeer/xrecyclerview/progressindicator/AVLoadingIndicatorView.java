package com.jcodecraeer.xrecyclerview.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.jcodecraeer.xrecyclerview.R;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.a;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.a0;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.b;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.b0;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.c;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.d;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.e;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.f;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.g;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.h;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.i;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.j;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.k;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.l;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.m;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.n;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.o;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.p;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.q;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.r;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.s;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.t;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.u;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.v;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.w;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.x;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.y;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.z;
/* loaded from: classes2.dex */
public class AVLoadingIndicatorView extends View {
    int a;
    int b;
    Paint c;

    /* renamed from: d  reason: collision with root package name */
    BaseIndicatorController f5813d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5814e;

    public AVLoadingIndicatorView(Context context) {
        super(context);
        e(null, 0);
    }

    private void b() {
        switch (this.a) {
            case 0:
                this.f5813d = new g();
                break;
            case 1:
                this.f5813d = new f();
                break;
            case 2:
                this.f5813d = new b();
                break;
            case 3:
                this.f5813d = new d();
                break;
            case 4:
                this.f5813d = new a0();
                break;
            case 5:
                this.f5813d = new c();
                break;
            case 6:
                this.f5813d = new h();
                break;
            case 7:
                this.f5813d = new j();
                break;
            case 8:
                this.f5813d = new s();
                break;
            case 9:
                this.f5813d = new r();
                break;
            case 10:
                this.f5813d = new q();
                break;
            case 11:
                this.f5813d = new p();
                break;
            case 12:
                this.f5813d = new k();
                break;
            case 13:
                this.f5813d = new t();
                break;
            case 14:
                this.f5813d = new u();
                break;
            case 15:
                this.f5813d = new l();
                break;
            case 16:
                this.f5813d = new i();
                break;
            case 17:
                this.f5813d = new a();
                break;
            case 18:
                this.f5813d = new v();
                break;
            case 19:
                this.f5813d = new w();
                break;
            case 20:
                this.f5813d = new m();
                break;
            case 21:
                this.f5813d = new n();
                break;
            case 22:
                this.f5813d = new o();
                break;
            case 23:
                this.f5813d = new x();
                break;
            case 24:
                this.f5813d = new b0();
                break;
            case 25:
                this.f5813d = new y();
                break;
            case 26:
                this.f5813d = new e();
                break;
            case 27:
                this.f5813d = new z();
                break;
        }
        this.f5813d.i(this);
    }

    private int c(int i2) {
        return ((int) getContext().getResources().getDisplayMetrics().density) * i2;
    }

    private void e(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AVLoadingIndicatorView);
        this.a = obtainStyledAttributes.getInt(R.styleable.AVLoadingIndicatorView_indicator, 0);
        this.b = obtainStyledAttributes.getColor(R.styleable.AVLoadingIndicatorView_indicator_color, -1);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(this.b);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setAntiAlias(true);
        b();
    }

    private int f(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    void a() {
        BaseIndicatorController baseIndicatorController = this.f5813d;
        if (baseIndicatorController == null) {
            return;
        }
        baseIndicatorController.f();
    }

    void d(Canvas canvas) {
        BaseIndicatorController baseIndicatorController = this.f5813d;
        if (baseIndicatorController == null) {
            return;
        }
        baseIndicatorController.b(canvas, this.c);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        BaseIndicatorController baseIndicatorController = this.f5813d;
        if (baseIndicatorController == null) {
            return;
        }
        baseIndicatorController.h(BaseIndicatorController.AnimStatus.START);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BaseIndicatorController baseIndicatorController = this.f5813d;
        if (baseIndicatorController == null) {
            return;
        }
        baseIndicatorController.h(BaseIndicatorController.AnimStatus.CANCEL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f5814e) {
            return;
        }
        this.f5814e = true;
        a();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension(f(c(30), i2), f(c(30), i3));
    }

    public void setIndicatorColor(int i2) {
        this.b = i2;
        this.c.setColor(i2);
        invalidate();
    }

    public void setIndicatorId(int i2) {
        this.a = i2;
        b();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (getVisibility() != i2) {
            super.setVisibility(i2);
            VdsAgent.onSetViewVisibility(this, i2);
            BaseIndicatorController baseIndicatorController = this.f5813d;
            if (baseIndicatorController == null) {
                return;
            }
            if (i2 != 8 && i2 != 4) {
                baseIndicatorController.h(BaseIndicatorController.AnimStatus.START);
            } else {
                baseIndicatorController.h(BaseIndicatorController.AnimStatus.END);
            }
        }
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(attributeSet, 0);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e(attributeSet, i2);
    }
}
