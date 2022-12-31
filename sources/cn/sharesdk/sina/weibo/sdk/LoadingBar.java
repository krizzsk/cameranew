package cn.sharesdk.sina.weibo.sdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class LoadingBar extends TextView {
    private int a;
    private int b;
    private Paint c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f249d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f250e;

    public LoadingBar(Context context) {
        super(context);
        this.f250e = new Runnable() { // from class: cn.sharesdk.sina.weibo.sdk.LoadingBar.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingBar.this.a++;
                LoadingBar loadingBar = LoadingBar.this;
                loadingBar.a(loadingBar.a);
            }
        };
        a(context);
    }

    private Rect b() {
        int left = getLeft();
        int top = getTop();
        return new Rect(0, 0, (getLeft() + (((getRight() - getLeft()) * this.a) / 100)) - left, getBottom() - top);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.c.setColor(this.b);
        canvas.drawRect(b(), this.c);
    }

    private void a(Context context) {
        this.f249d = new Handler();
        this.c = new Paint();
        a();
    }

    public LoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public void a() {
        this.b = -11693826;
    }

    public void a(int i2) {
        if (i2 < 7) {
            this.f249d.postDelayed(this.f250e, 70L);
        } else {
            this.f249d.removeCallbacks(this.f250e);
            this.a = i2;
        }
        invalidate();
    }
}
