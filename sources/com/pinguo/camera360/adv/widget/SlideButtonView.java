package com.pinguo.camera360.adv.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class SlideButtonView extends Button {
    private Paint a;
    private LinearGradient b;
    private int[] c;

    /* renamed from: d  reason: collision with root package name */
    private int f6186d;

    /* renamed from: e  reason: collision with root package name */
    private float f6187e;

    /* renamed from: f  reason: collision with root package name */
    private Matrix f6188f;

    /* renamed from: g  reason: collision with root package name */
    private int f6189g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6190h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f6191i;

    /* renamed from: j  reason: collision with root package name */
    private String f6192j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            if (!(SlideButtonView.this.getContext() instanceof Activity) || !((Activity) SlideButtonView.this.getContext()).isFinishing()) {
                if (SlideButtonView.this.f6190h) {
                    return;
                }
                SlideButtonView.this.f6188f.setTranslate(SlideButtonView.this.f6186d, 0.0f);
                SlideButtonView.this.b.setLocalMatrix(SlideButtonView.this.f6188f);
                SlideButtonView.this.invalidate();
                SlideButtonView slideButtonView = SlideButtonView.this;
                SlideButtonView.f(slideButtonView, slideButtonView.f6187e * 5.0f);
                if (SlideButtonView.this.f6186d > SlideButtonView.this.f6189g) {
                    SlideButtonView.this.f6186d = 0;
                }
                SlideButtonView.this.f6191i.sendEmptyMessageDelayed(1, 30L);
                return;
            }
            SlideButtonView.this.l();
        }
    }

    public SlideButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6190h = false;
        this.f6191i = new b();
        this.f6192j = "";
        a();
    }

    private void a() {
        this.f6190h = false;
        this.f6192j = String.valueOf(toString().hashCode());
        this.f6187e = getResources().getDisplayMetrics().density;
        this.c = new int[]{Color.argb(0, 255, 255, 255), Color.argb(0, 255, 255, 255), Color.argb(255, 255, 255, 255)};
        this.b = new LinearGradient(0.0f, 0.0f, this.f6187e * 90.0f, 0.0f, this.c, new float[]{0.0f, 0.8f, 1.0f}, Shader.TileMode.MIRROR);
        this.f6186d = 0;
        this.a = new Paint();
        this.f6188f = new Matrix();
        this.a.setAlpha(255);
        this.f6189g = (int) getResources().getDimension(R.dimen.album_adv_slide_width);
        this.f6191i.sendEmptyMessageDelayed(1, 30L);
    }

    static /* synthetic */ int f(SlideButtonView slideButtonView, float f2) {
        int i2 = (int) (slideButtonView.f6186d + f2);
        slideButtonView.f6186d = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f6191i != null) {
            this.f6190h = true;
            us.pinguo.advsdk.utils.b.a(this.f6192j + ":slide:stop");
            this.f6191i.removeMessages(1);
            this.f6191i.removeCallbacksAndMessages(null);
        }
    }

    public void m() {
        this.f6190h = false;
        if (this.f6191i == null) {
            this.f6191i = new b();
        }
        if (this.f6191i != null) {
            us.pinguo.advsdk.utils.b.a(this.f6192j + ":slide:restart");
            this.f6191i.removeMessages(1);
            this.f6191i.removeCallbacksAndMessages(null);
            this.f6191i.sendEmptyMessageDelayed(1, 30L);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
        this.f6191i = null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.setShader(this.b);
        canvas.drawPaint(this.a);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onDetachedFromWindow();
        if (i2 == 8) {
            l();
        } else if (i2 == 0) {
            m();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onDetachedFromWindow();
        if (i2 == 8) {
            l();
        } else if (i2 == 0) {
            m();
        }
    }

    public SlideButtonView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6190h = false;
        this.f6191i = new b();
        this.f6192j = "";
        a();
    }

    public SlideButtonView(Context context) {
        super(context);
        this.f6190h = false;
        this.f6191i = new b();
        this.f6192j = "";
        a();
    }
}
