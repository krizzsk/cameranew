package us.pinguo.camera2020.view.t2;

import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Pair;
import kotlin.jvm.internal.s;
import kotlin.y.c;
/* compiled from: MakeupColorScrollListener.kt */
/* loaded from: classes3.dex */
public final class a extends RecyclerView.OnScrollListener {
    private int a;
    private int b;
    private float c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private InterfaceC0363a f9451d;

    /* compiled from: MakeupColorScrollListener.kt */
    /* renamed from: us.pinguo.camera2020.view.t2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0363a {
        void a(View view);
    }

    private final View a(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        int i2 = Integer.MAX_VALUE;
        View view = null;
        int i3 = 0;
        while (i3 < childCount) {
            int i4 = i3 + 1;
            View view2 = ViewGroupKt.get(recyclerView, i3);
            int abs = Math.abs(((int) (view2.getLeft() + (view2.getWidth() * 0.5d))) - this.a);
            if (abs <= i2) {
                view = view2;
                i3 = i4;
                i2 = abs;
            } else {
                i3 = i4;
            }
        }
        return view;
    }

    private final Pair<View, View> b(RecyclerView recyclerView) {
        int b;
        int childCount = recyclerView.getChildCount();
        View view = null;
        View view2 = null;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        while (i4 < childCount) {
            int i5 = i4 + 1;
            View view3 = ViewGroupKt.get(recyclerView, i4);
            float x = view3.getX() + (view3.getWidth() / 2);
            if (Math.abs(x - this.a) >= this.b) {
                view3.setScaleX(1.0f);
                view3.setScaleY(1.0f);
            }
            b = c.b(Math.abs(x - this.a));
            if (x <= this.a) {
                if (b <= i3) {
                    view = view3;
                    i4 = i5;
                    i3 = b;
                } else {
                    i4 = i5;
                }
            } else if (b <= i2) {
                view2 = view3;
                i4 = i5;
                i2 = b;
            } else {
                i4 = i5;
            }
        }
        return new Pair<>(view, view2);
    }

    private final void g(RecyclerView recyclerView) {
        if (this.b == 0) {
            return;
        }
        Pair<View, View> b = b(recyclerView);
        View first = b.getFirst();
        if (first != null) {
            float c = (((c() - (e() - (first.getX() + (first.getWidth() / 2)))) / c()) * (d() - 1)) + 1.0f;
            if (c <= 1.0d) {
                c = 1.0f;
            }
            first.setScaleX(c);
            first.setScaleY(c);
        }
        View second = b.getSecond();
        if (second == null) {
            return;
        }
        float c2 = (((c() - ((second.getX() + (second.getWidth() / 2)) - e())) / c()) * (d() - 1)) + 1.0f;
        float f2 = ((double) c2) > 1.0d ? c2 : 1.0f;
        second.setScaleX(f2);
        second.setScaleY(f2);
    }

    public final int c() {
        return this.b;
    }

    public final float d() {
        return this.c;
    }

    public final int e() {
        return this.a;
    }

    public final void f(RecyclerView recyclerView) {
        s.h(recyclerView, "recyclerView");
        g(recyclerView);
    }

    public final void h(InterfaceC0363a onScrollSelectChangeListener) {
        s.h(onScrollSelectChangeListener, "onScrollSelectChangeListener");
        this.f9451d = onScrollSelectChangeListener;
    }

    public final void i(int i2) {
        this.b = i2;
    }

    public final void j(float f2) {
        this.c = f2;
    }

    public final void k(int i2) {
        this.a = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        int a;
        s.h(recyclerView, "recyclerView");
        if (i2 == 0) {
            g(recyclerView);
            View a2 = a(recyclerView);
            if (a2 == null) {
                return;
            }
            a = c.a((a2.getLeft() + (a2.getWidth() * 0.5d)) - this.a);
            recyclerView.smoothScrollBy(a, 0);
            InterfaceC0363a interfaceC0363a = this.f9451d;
            if (interfaceC0363a == null) {
                return;
            }
            interfaceC0363a.a(a2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        s.h(recyclerView, "recyclerView");
        g(recyclerView);
    }
}
