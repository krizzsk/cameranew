package us.pinguo.admobvista.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import us.pinguo.admobvista.f.d;
/* loaded from: classes3.dex */
public class AdLoadingView extends View {
    private Handler a;
    private Runnable b;
    private Paint c;

    /* renamed from: d  reason: collision with root package name */
    private Rect f9001d;

    /* renamed from: e  reason: collision with root package name */
    int f9002e;

    /* renamed from: f  reason: collision with root package name */
    int f9003f;

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdLoadingView.this.invalidate();
        }
    }

    public AdLoadingView(Context context) {
        super(context);
        this.a = null;
        this.b = new a();
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(-1);
        this.c.setAntiAlias(true);
        this.f9001d = new Rect();
        this.f9002e = 0;
        this.f9003f = -1;
        this.a = new Handler();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.a.removeCallbacks(this.b);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        if (this.f9003f != measuredWidth) {
            int i3 = measuredWidth / 16;
            int a2 = d.a(24.0f);
            if (i3 > a2) {
                i3 = a2;
            }
            this.c.setTextSize(i3);
            this.c.getTextBounds("Relax while loading...", 0, 22, this.f9001d);
            this.f9003f = measuredWidth;
        }
        this.f9002e = this.f9002e % 4;
        Rect rect = this.f9001d;
        canvas.drawText("Relax while loading...", 0, (22 + i2) - 3, (measuredWidth / 2) - ((rect.right + rect.left) / 2), (measuredHeight / 2) - ((rect.bottom + rect.top) / 2), this.c);
        this.f9002e++;
        this.a.postDelayed(this.b, 500L);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        if (i2 != 0) {
            this.a.removeCallbacks(this.b);
        }
        super.onVisibilityChanged(view, i2);
    }

    public AdLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = new a();
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(-1);
        this.c.setAntiAlias(true);
        this.f9001d = new Rect();
        this.f9002e = 0;
        this.f9003f = -1;
        this.a = new Handler();
    }

    public AdLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = null;
        this.b = new a();
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(-1);
        this.c.setAntiAlias(true);
        this.f9001d = new Rect();
        this.f9002e = 0;
        this.f9003f = -1;
        this.a = new Handler();
    }
}
