package us.pinguo.camera2020.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.camera2020.R;
import us.pinguo.foundation.utils.o;
/* loaded from: classes3.dex */
public class CameraModeSwitchLayout extends LinearLayout implements View.OnClickListener {
    private CameraSwitchMode a;
    private int b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f9465d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f9466e;

    /* renamed from: f  reason: collision with root package name */
    private ViewDragHelper f9467f;

    /* renamed from: g  reason: collision with root package name */
    private int f9468g;

    /* renamed from: h  reason: collision with root package name */
    private int f9469h;

    /* renamed from: i  reason: collision with root package name */
    private b f9470i;

    /* renamed from: j  reason: collision with root package name */
    private OverScroller f9471j;

    /* renamed from: k  reason: collision with root package name */
    private float f9472k;

    /* renamed from: l  reason: collision with root package name */
    private float f9473l;
    private long m;

    /* loaded from: classes3.dex */
    class a extends ViewDragHelper.Callback {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            int width = ((CameraModeSwitchLayout.this.getWidth() / 2) + this.a) - view.getMeasuredWidth();
            int width2 = (CameraModeSwitchLayout.this.getWidth() / 2) - this.a;
            return i2 > width ? width : i2 < width2 ? width2 : i2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            if (view == CameraModeSwitchLayout.this.c) {
                int width = CameraModeSwitchLayout.this.getWidth() / 2;
                if (Math.abs(width - ((CameraModeSwitchLayout.this.c.getLeft() + CameraModeSwitchLayout.this.f9466e.getLeft()) + (CameraModeSwitchLayout.this.f9466e.getWidth() / 2))) < Math.abs(width - ((CameraModeSwitchLayout.this.c.getLeft() + CameraModeSwitchLayout.this.f9465d.getLeft()) + (CameraModeSwitchLayout.this.f9465d.getWidth() / 2)))) {
                    CameraModeSwitchLayout.this.b = 1;
                    CameraModeSwitchLayout.this.f9467f.settleCapturedViewAt(CameraModeSwitchLayout.this.f9469h, 0);
                    CameraModeSwitchLayout.this.k();
                } else {
                    CameraModeSwitchLayout.this.b = 0;
                    CameraModeSwitchLayout.this.f9467f.settleCapturedViewAt(CameraModeSwitchLayout.this.f9468g, 0);
                    CameraModeSwitchLayout.this.k();
                }
                CameraModeSwitchLayout.this.invalidate();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            return view == CameraModeSwitchLayout.this.c;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(CameraSwitchMode cameraSwitchMode);
    }

    public CameraModeSwitchLayout(@NonNull Context context) {
        super(context);
        CameraSwitchMode cameraSwitchMode = CameraSwitchMode.PHOTO;
        this.a = cameraSwitchMode;
        this.b = cameraSwitchMode.getIndex();
    }

    private void i() {
        if (this.b == 0) {
            this.f9465d.setAlpha(1.0f);
            this.f9466e.setAlpha(0.5f);
            return;
        }
        this.f9465d.setAlpha(0.5f);
        this.f9466e.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float j(float f2) {
        float f3 = f2 - 1.0f;
        return (f3 * f3 * f3 * f3 * f3) + 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        i();
        CameraSwitchMode cameraSwitchMode = this.b == 0 ? CameraSwitchMode.PHOTO : CameraSwitchMode.MOVIE;
        if (this.a == cameraSwitchMode) {
            return;
        }
        this.a = cameraSwitchMode;
        b bVar = this.f9470i;
        if (bVar != null) {
            bVar.a(cameraSwitchMode);
        }
    }

    private void l(int i2) {
        int left = this.c.getLeft();
        int top = this.c.getTop();
        int i3 = i2 - left;
        int i4 = 0 - top;
        if (i3 == 0 && i4 == 0) {
            this.f9471j.abortAnimation();
            return;
        }
        this.f9471j.startScroll(left, top, i3, i4, 200);
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f9467f.continueSettling(true)) {
            invalidate();
        } else if (this.f9471j.computeScrollOffset()) {
            this.c.offsetLeftAndRight(this.f9471j.getCurrX() - this.c.getLeft());
            invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view == this.f9465d) {
            this.b = 0;
            l(this.f9468g);
        } else if (view == this.f9466e) {
            this.b = 1;
            l(this.f9469h);
        }
        k();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setZ(this, 1.0f);
        this.f9471j = new OverScroller(getContext(), us.pinguo.camera2020.widget.a.a);
        this.f9467f = ViewDragHelper.create(this, 1.0f, new a(us.pinguo.foundation.t.b.a.b(getResources(), 120.0f)));
        this.c = findViewById(R.id.pv_switch_content);
        this.f9465d = (TextView) findViewById(R.id.pv_switch_photo);
        this.f9466e = (TextView) findViewById(R.id.pv_switch_video);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            return this.f9467f.shouldInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = (i4 - i2) / 2;
        this.f9468g = i6 - ((this.c.getLeft() + this.f9465d.getLeft()) + (this.f9465d.getWidth() / 2));
        int left = i6 - ((this.c.getLeft() + this.f9466e.getLeft()) + (this.f9466e.getWidth() / 2));
        this.f9469h = left;
        if (this.b == 0) {
            this.c.offsetLeftAndRight(this.f9468g);
        } else {
            this.c.offsetLeftAndRight(left);
        }
        i();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            this.f9467f.processTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 && System.currentTimeMillis() - this.m < 300) {
                    Rect rect = new Rect();
                    Rect rect2 = new Rect();
                    this.f9466e.getGlobalVisibleRect(rect);
                    this.f9465d.getGlobalVisibleRect(rect2);
                    if (o.c(getContext())) {
                        int k2 = us.pinguo.foundation.t.b.a.k();
                        rect.set(rect.left, rect.top, rect.right, rect.bottom + k2);
                        rect2.set(rect2.left, rect2.top, rect2.right, rect2.bottom + k2);
                    }
                    if (rect.contains((int) this.f9472k, (int) this.f9473l)) {
                        this.f9467f.abort();
                        onClick(this.f9466e);
                    } else if (rect2.contains((int) this.f9472k, (int) this.f9473l)) {
                        this.f9467f.abort();
                        onClick(this.f9465d);
                    }
                }
            } else {
                this.f9472k = motionEvent.getRawX();
                this.f9473l = motionEvent.getRawY();
                this.m = System.currentTimeMillis();
            }
            return true;
        }
        return false;
    }

    public void setOnCameraModeSelectListener(b bVar) {
        this.f9470i = bVar;
    }

    public void setSelectIndex(int i2) {
        this.b = i2;
        requestLayout();
    }

    public void setStyle(boolean z) {
        if (z) {
            this.f9465d.setTextColor(Color.argb(255, 58, 64, 77));
            this.f9466e.setTextColor(Color.argb(255, 58, 64, 77));
            return;
        }
        this.f9465d.setTextColor(-1);
        this.f9466e.setTextColor(-1);
    }

    public CameraModeSwitchLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        CameraSwitchMode cameraSwitchMode = CameraSwitchMode.PHOTO;
        this.a = cameraSwitchMode;
        this.b = cameraSwitchMode.getIndex();
    }

    public CameraModeSwitchLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        CameraSwitchMode cameraSwitchMode = CameraSwitchMode.PHOTO;
        this.a = cameraSwitchMode;
        this.b = cameraSwitchMode.getIndex();
    }
}
