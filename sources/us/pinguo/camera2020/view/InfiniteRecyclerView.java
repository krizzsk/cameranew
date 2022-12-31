package us.pinguo.camera2020.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
/* compiled from: InfiniteRecyclerView.kt */
/* loaded from: classes3.dex */
public final class InfiniteRecyclerView extends RecyclerView {
    private final Handler a;
    private final k2 b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9299d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfiniteRecyclerView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new Handler(Looper.getMainLooper());
        this.b = new k2(this);
    }

    public final k2 b() {
        return this.b;
    }

    public final boolean c() {
        return this.f9299d;
    }

    public final boolean d() {
        return this.c;
    }

    public final void e() {
        if (this.c) {
            f();
        }
        this.f9299d = true;
        this.c = true;
        this.a.postDelayed(this.b, 16L);
    }

    public final void f() {
        this.c = false;
        removeCallbacks(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent e2) {
        kotlin.jvm.internal.s.h(e2, "e");
        int action = e2.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3 || action == 4) && this.f9299d) {
                e();
            }
        } else if (this.c) {
            f();
        }
        return super.onTouchEvent(e2);
    }

    public final void setCanRun$camera2020_release(boolean z) {
        this.f9299d = z;
    }

    public final void setRunning$camera2020_release(boolean z) {
        this.c = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfiniteRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Handler(Looper.getMainLooper());
        this.b = new k2(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfiniteRecyclerView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Handler(Looper.getMainLooper());
        this.b = new k2(this);
    }
}
