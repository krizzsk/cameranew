package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BaseIndicatorController {
    private View a;
    private List<Animator> b;

    /* loaded from: classes2.dex */
    public enum AnimStatus {
        START,
        END,
        CANCEL
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnimStatus.values().length];
            a = iArr;
            try {
                iArr[AnimStatus.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AnimStatus.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AnimStatus.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public abstract List<Animator> a();

    public abstract void b(Canvas canvas, Paint paint);

    public int c() {
        View view = this.a;
        if (view == null) {
            return 0;
        }
        return view.getHeight();
    }

    public View d() {
        return this.a;
    }

    public int e() {
        View view = this.a;
        if (view == null) {
            return 0;
        }
        return view.getWidth();
    }

    public void f() {
        this.b = a();
    }

    public void g() {
        View view = this.a;
        if (view != null) {
            view.postInvalidate();
        }
    }

    public void h(AnimStatus animStatus) {
        List<Animator> list = this.b;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = this.b.get(i2);
            boolean isRunning = animator.isRunning();
            int i3 = a.a[animStatus.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && isRunning) {
                        animator.cancel();
                    }
                } else if (isRunning) {
                    animator.end();
                }
            } else if (!isRunning) {
                animator.start();
            }
        }
    }

    public void i(View view) {
        this.a = view;
    }
}
