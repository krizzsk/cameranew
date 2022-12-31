package com.camera360.dynamic_feature_splice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.camera360.dynamic_feature_splice.DragLinearLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import us.pinguo.picker.image.PickManager;
/* compiled from: SpliceScrollView.kt */
/* loaded from: classes8.dex */
public final class SpliceScrollView extends ScrollView implements q1, DragLinearLayout.e {
    private final DragLinearLayout a;
    private kotlin.jvm.b.a<kotlin.u> b;
    private o1 c;

    /* renamed from: d  reason: collision with root package name */
    private int f2182d;

    /* renamed from: e  reason: collision with root package name */
    private p1 f2183e;

    /* compiled from: SpliceScrollView.kt */
    /* loaded from: classes8.dex */
    public static final class a extends g1 {
        a() {
        }

        @Override // com.camera360.dynamic_feature_splice.DragLinearLayout.d
        public void c() {
            o1 o1Var = SpliceScrollView.this.c;
            if (o1Var != null) {
                o1Var.q(-1);
            }
            SpliceScrollView.this.h().invoke();
        }
    }

    /* compiled from: SpliceScrollView.kt */
    /* loaded from: classes8.dex */
    public static final class b implements DragLinearLayout.f {
        final /* synthetic */ o1 a;

        b(o1 o1Var) {
            this.a = o1Var;
        }

        @Override // com.camera360.dynamic_feature_splice.DragLinearLayout.f
        public void c(View view, int i2, View secondView, int i3) {
            kotlin.jvm.internal.s.h(secondView, "secondView");
            this.a.c(view, i2 - 1, secondView, i3 - 1);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpliceScrollView(Context context) {
        this(context, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    private final void e() {
        View view = new View(getContext());
        view.setBackgroundColor(-657931);
        this.a.addView(view, -1, this.f2182d);
    }

    @Override // com.camera360.dynamic_feature_splice.DragLinearLayout.e
    public void a(View view, int i2) {
        if (i2 > 0 && i2 < this.a.getChildCount() - 1) {
            o1 o1Var = this.c;
            if (o1Var == null) {
                return;
            }
            o1Var.a(view, i2 - 1);
            return;
        }
        o1 o1Var2 = this.c;
        if (o1Var2 == null) {
            return;
        }
        o1Var2.a(view, -1);
    }

    @Override // com.camera360.dynamic_feature_splice.DragLinearLayout.e
    public int b() {
        o1 o1Var = this.c;
        int b2 = o1Var == null ? -1 : o1Var.b();
        if (b2 < 0) {
            return -1;
        }
        return b2 + 1;
    }

    @Override // com.camera360.dynamic_feature_splice.q1
    public void c() {
        o1 o1Var = this.c;
        if (o1Var == null) {
            return;
        }
        this.a.removeAllViews();
        e();
        int f2 = o1Var.f();
        for (int i2 = 0; i2 < f2; i2++) {
            DragLinearLayout dragLinearLayout = this.a;
            Context context = getContext();
            kotlin.jvm.internal.s.g(context, "context");
            dragLinearLayout.addView(o1Var.l(this, context, i2), -1, -2);
        }
        e();
        int i3 = 1;
        int childCount = this.a.getChildCount() - 1;
        while (i3 < childCount) {
            int i4 = i3 + 1;
            View child = this.a.getChildAt(i3);
            DragLinearLayout dragLinearLayout2 = this.a;
            kotlin.jvm.internal.s.g(child, "child");
            dragLinearLayout2.setViewDraggable(child, child);
            i3 = i4;
        }
    }

    public final View f() {
        kotlin.z.d h2;
        boolean z;
        int scrollY = getScrollY() + (getHeight() / 2);
        h2 = kotlin.z.j.h(0, this.a.getChildCount());
        Iterator<Integer> it = h2.iterator();
        while (it.hasNext()) {
            View childAt = g().getChildAt(((kotlin.collections.h0) it).nextInt());
            int top = childAt.getTop();
            if (scrollY > childAt.getBottom() || top > scrollY) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                return childAt;
            }
        }
        return null;
    }

    public final DragLinearLayout g() {
        return this.a;
    }

    public final kotlin.jvm.b.a<kotlin.u> h() {
        return this.b;
    }

    public final boolean i() {
        return this.a.y();
    }

    public final boolean j() {
        p1 p1Var = this.f2183e;
        return p1Var != null && p1Var.G();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (j()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (!this.a.r() || b() == -1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public final void setAdapter(o1 o1Var) {
        if (o1Var != null) {
            this.c = o1Var;
            o1Var.r(this);
            o1Var.n();
            this.a.setOnSwapListener(new b(o1Var));
            this.a.setOnItemSelectedCtrl(this);
            return;
        }
        this.a.setOnSwapListener(null);
        this.a.setOnItemSelectedCtrl(null);
        this.a.removeAllViews();
        o1 o1Var2 = this.c;
        if (o1Var2 != null) {
            o1Var2.r(null);
        }
        this.c = null;
    }

    public final void setScrollableCallback(p1 p1Var) {
        this.f2183e = p1Var;
    }

    public final void setStartDetectingCallback(kotlin.jvm.b.a<kotlin.u> aVar) {
        kotlin.jvm.internal.s.h(aVar, "<set-?>");
        this.b = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpliceScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int b2;
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.b = SpliceScrollView$startDetectingCallback$1.INSTANCE;
        b2 = kotlin.y.c.b(PickManager.a.b() * 8);
        this.f2182d = b2;
        DragLinearLayout dragLinearLayout = new DragLinearLayout(context, null, 2, null);
        this.a = dragLinearLayout;
        dragLinearLayout.setOrientation(1);
        dragLinearLayout.setBackgroundColor(-1);
        dragLinearLayout.setContainerScrollView(this);
        addView(dragLinearLayout, -1, -2);
        dragLinearLayout.setOnDragStatusChangedListsner(new a());
    }
}
