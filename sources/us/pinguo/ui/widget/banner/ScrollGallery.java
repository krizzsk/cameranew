package us.pinguo.ui.widget.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.SpinnerAdapter;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
/* loaded from: classes6.dex */
public class ScrollGallery extends Gallery {
    private boolean a;
    private int b;
    private c c;

    /* renamed from: d  reason: collision with root package name */
    private int f12264d;

    /* renamed from: e  reason: collision with root package name */
    private int f12265e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12266f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12267g;

    /* renamed from: h  reason: collision with root package name */
    private int f12268h;

    /* renamed from: i  reason: collision with root package name */
    private Runnable f12269i;

    /* renamed from: j  reason: collision with root package name */
    private Handler f12270j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12271k;

    /* loaded from: classes6.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                ScrollGallery.this.j();
                sendEmptyMessageDelayed(100, ScrollGallery.this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollGallery.c(ScrollGallery.this);
            if (ScrollGallery.this.f12268h > 0 || ScrollGallery.this.f12267g || ScrollGallery.this.f12266f) {
                return;
            }
            if (ScrollGallery.this.c != null) {
                ScrollGallery.this.c.b();
            }
            ScrollGallery.this.f12271k = true;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a();

        void b();
    }

    public ScrollGallery(Context context) {
        this(context, null);
    }

    static /* synthetic */ int c(ScrollGallery scrollGallery) {
        int i2 = scrollGallery.f12268h;
        scrollGallery.f12268h = i2 - 1;
        return i2;
    }

    private void h() {
        setAnimationDuration(1000);
        setSoundEffectsEnabled(false);
        setFadingEdgeLength(0);
        this.f12269i = new b();
    }

    private void k() {
        this.f12270j.removeMessages(100);
        this.f12270j.sendEmptyMessageDelayed(100, this.b);
    }

    private void l() {
        this.f12270j.removeMessages(100);
    }

    @Override // android.widget.Gallery, android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        return false;
    }

    protected void i() {
        int autoScrollTime;
        onKeyDown(21, null);
        if (getAdapter() == null || !(getAdapter() instanceof us.pinguo.ui.widget.banner.b) || (autoScrollTime = ((us.pinguo.ui.widget.banner.b) getAdapter()).getAutoScrollTime(getSelectedItemPosition() - 1)) <= 0) {
            return;
        }
        this.b = autoScrollTime;
    }

    public void j() {
        int autoScrollTime;
        onKeyDown(22, null);
        if (getAdapter() == null || !(getAdapter() instanceof us.pinguo.ui.widget.banner.b) || (autoScrollTime = ((us.pinguo.ui.widget.banner.b) getAdapter()).getAutoScrollTime(getSelectedItemPosition() + 1)) <= 0) {
            return;
        }
        this.b = autoScrollTime;
    }

    @Override // android.widget.Gallery, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        if (this.a) {
            k();
        }
        super.onAttachedToWindow();
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.a) {
            l();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f12270j.removeMessages(100);
        if (motionEvent2.getX() > motionEvent.getX()) {
            i();
        } else {
            j();
        }
        if (this.a) {
            this.f12270j.sendEmptyMessageDelayed(100, this.b);
            return true;
        }
        return true;
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f12271k = true;
        c cVar = this.c;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // android.widget.Gallery, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f12264d = x;
            this.f12265e = y;
            this.f12268h++;
            this.f12267g = false;
            this.f12266f = false;
            postDelayed(this.f12269i, 200L);
        } else if (action != 1) {
            if (action == 2 && !this.f12266f && (Math.abs(this.f12264d - x) > 20 || Math.abs(this.f12265e - y) > 20)) {
                this.f12266f = true;
            }
        } else {
            this.f12267g = true;
            if (this.f12271k && (cVar = this.c) != null) {
                cVar.a();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.a) {
            if (z) {
                k();
            } else {
                l();
            }
        }
    }

    public void setAutoScroll(boolean z) {
        if (z != this.a) {
            this.a = z;
            if (z) {
                k();
            } else {
                l();
            }
        }
    }

    public void setOnLongPressListener(c cVar) {
        this.c = cVar;
    }

    public ScrollGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.b = PathInterpolatorCompat.MAX_NUM_POINTS;
        this.f12270j = new a();
        h();
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        int autoScrollTime;
        super.setAdapter(spinnerAdapter);
        if (!(spinnerAdapter instanceof us.pinguo.ui.widget.banner.b) || (autoScrollTime = ((us.pinguo.ui.widget.banner.b) spinnerAdapter).getAutoScrollTime(0)) <= 0) {
            return;
        }
        this.b = autoScrollTime;
    }
}
