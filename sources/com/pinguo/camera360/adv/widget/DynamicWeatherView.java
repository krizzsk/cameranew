package com.pinguo.camera360.adv.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes3.dex */
public class DynamicWeatherView extends SurfaceView implements SurfaceHolder.Callback {
    private Context a;
    private b b;
    private SurfaceHolder c;

    /* renamed from: d  reason: collision with root package name */
    private c f6165d;

    /* renamed from: e  reason: collision with root package name */
    private int f6166e;

    /* renamed from: f  reason: collision with root package name */
    private int f6167f;

    /* loaded from: classes3.dex */
    private class b extends Thread {
        private boolean a;

        private b() {
            this.a = false;
        }

        public void a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Canvas lockCanvas;
            while (this.a) {
                if (DynamicWeatherView.this.f6165d != null && DynamicWeatherView.this.f6166e != 0 && DynamicWeatherView.this.f6167f != 0 && (lockCanvas = DynamicWeatherView.this.c.lockCanvas()) != null) {
                    DynamicWeatherView.this.f6165d.a(lockCanvas);
                    if (!this.a) {
                        return;
                    }
                    DynamicWeatherView.this.c.unlockCanvasAndPost(lockCanvas);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Canvas canvas);

        void b(Context context, int i2, int i3);
    }

    public DynamicWeatherView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f6166e = i2;
        this.f6167f = i3;
        c cVar = this.f6165d;
        if (cVar != null) {
            cVar.b(this.a, i2, i3);
        }
    }

    public void setType(c cVar) {
        this.f6165d = cVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        b bVar = new b();
        this.b = bVar;
        bVar.a(true);
        this.b.start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.b.a(false);
    }

    public DynamicWeatherView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DynamicWeatherView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = context;
        SurfaceHolder holder = getHolder();
        this.c = holder;
        holder.addCallback(this);
        this.c.setFormat(-2);
    }
}
