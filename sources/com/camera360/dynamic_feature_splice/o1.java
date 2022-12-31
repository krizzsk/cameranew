package com.camera360.dynamic_feature_splice;

import android.content.Context;
import android.view.View;
import com.camera360.dynamic_feature_splice.DragLinearLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* compiled from: SpliceItemAdapter.kt */
/* loaded from: classes8.dex */
public abstract class o1 implements DragLinearLayout.f, DragLinearLayout.e {
    private List<n1> b;
    private q1 c;
    private final ArrayList<CropZoomImageView> a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private int f2198d = -1;

    private final void e(int i2, int i3) {
        if (i2 >= 0) {
            this.a.get(i2).f(false);
        }
        if (i3 >= 0) {
            this.a.get(i3).f(true);
        }
    }

    @Override // com.camera360.dynamic_feature_splice.DragLinearLayout.e
    public void a(View view, int i2) {
        int i3 = this.f2198d;
        i2 = (i2 == -1 || i3 == i2) ? -1 : -1;
        if (i2 != -1 || m()) {
            this.f2198d = i2;
            o(i2);
            e(i3, this.f2198d);
        }
    }

    @Override // com.camera360.dynamic_feature_splice.DragLinearLayout.e
    public int b() {
        return this.f2198d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.camera360.dynamic_feature_splice.DragLinearLayout.f
    public void c(View view, int i2, View secondView, int i3) {
        kotlin.jvm.internal.s.h(secondView, "secondView");
        List list = this.a;
        int i4 = 0;
        Object[] array = list.toArray(new CropZoomImageView[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        boolean z = true;
        if (i2 >= 0 && i2 < array.length) {
            if (i3 >= 0 && i3 < array.length) {
                Object obj = array[i2];
                Object obj2 = array[i3];
                array[i3] = obj;
                array[i2] = obj2;
                list.clear();
                int length = array.length;
                int i5 = 0;
                while (i5 < length) {
                    Object obj3 = array[i5];
                    i5++;
                    list.add(obj3);
                }
            }
        }
        List<n1> list2 = this.b;
        if (list2 == 0) {
            return;
        }
        Object[] array2 = list2.toArray(new n1[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        if (i2 >= 0 && i2 < array2.length) {
            if ((i3 < 0 || i3 >= array2.length) ? false : false) {
                Object obj4 = array2[i2];
                Object obj5 = array2[i3];
                array2[i3] = obj4;
                array2[i2] = obj5;
                list2.clear();
                int length2 = array2.length;
                while (i4 < length2) {
                    Object obj6 = array2[i4];
                    i4++;
                    list2.add(obj6);
                }
            }
        }
    }

    public final void d(n1 spliceItem) {
        List<n1> list;
        kotlin.jvm.internal.s.h(spliceItem, "spliceItem");
        int i2 = this.f2198d;
        if (i2 >= 0 && (list = this.b) != null) {
            list.remove(i2);
            list.add(this.f2198d, spliceItem);
        }
    }

    public final int f() {
        List<n1> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final n1 g(int i2) {
        List<n1> list;
        List<n1> list2 = this.b;
        boolean z = false;
        int size = list2 == null ? 0 : list2.size();
        if (i2 >= 0 && i2 < size) {
            z = true;
        }
        if (!z || (list = this.b) == null) {
            return null;
        }
        return list.get(i2);
    }

    public final List<n1> h() {
        return this.b;
    }

    public final CropZoomImageView i(int i2) {
        boolean z = false;
        if (i2 >= 0 && i2 < this.a.size()) {
            z = true;
        }
        if (z) {
            return this.a.get(i2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<CropZoomImageView> j() {
        return this.a;
    }

    public final ArrayList<CropZoomImageView> k() {
        return this.a;
    }

    public abstract View l(SpliceScrollView spliceScrollView, Context context, int i2);

    public abstract boolean m();

    public final void n() {
        q1 q1Var = this.c;
        if (q1Var == null) {
            return;
        }
        q1Var.c();
    }

    public abstract void o(int i2);

    public final void p(List<n1> list) {
        this.b = list;
    }

    public final void q(int i2) {
        int i3 = this.f2198d;
        if (i2 != i3) {
            this.f2198d = i2;
            o(i2);
            e(i3, this.f2198d);
        }
    }

    public final void r(q1 q1Var) {
        this.c = q1Var;
    }
}
