package com.shizhefei.view.viewpager;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
/* compiled from: RecycleBin.java */
/* loaded from: classes3.dex */
public class a {
    private View[] a = new View[0];
    private int[] b = new int[0];
    private SparseArray<View>[] c;

    /* renamed from: d  reason: collision with root package name */
    private int f7164d;

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<View> f7165e;

    private void c() {
        int length = this.a.length;
        int i2 = this.f7164d;
        SparseArray<View>[] sparseArrayArr = this.c;
        for (int i3 = 0; i3 < i2; i3++) {
            SparseArray<View> sparseArray = sparseArrayArr[i3];
            int size = sparseArray.size();
            int i4 = size - length;
            int i5 = size - 1;
            int i6 = 0;
            while (i6 < i4) {
                sparseArray.remove(sparseArray.keyAt(i5));
                i6++;
                i5--;
            }
        }
    }

    static View d(SparseArray<View> sparseArray, int i2) {
        int size = sparseArray.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = sparseArray.keyAt(i3);
                View view = sparseArray.get(keyAt);
                if (keyAt == i2) {
                    sparseArray.remove(keyAt);
                    return view;
                }
            }
            int i4 = size - 1;
            View valueAt = sparseArray.valueAt(i4);
            sparseArray.remove(sparseArray.keyAt(i4));
            return valueAt;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void a(View view, int i2, int i3) {
        if (this.f7164d == 1) {
            this.f7165e.put(i2, view);
        } else {
            this.c[i3].put(i2, view);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            view.setAccessibilityDelegate(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(int i2, int i3) {
        if (this.f7164d == 1) {
            return d(this.f7165e, i2);
        }
        if (i3 >= 0) {
            SparseArray<View>[] sparseArrayArr = this.c;
            if (i3 < sparseArrayArr.length) {
                return d(sparseArrayArr[i3], i2);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void e() {
        View[] viewArr = this.a;
        int[] iArr = this.b;
        boolean z = this.f7164d > 1;
        SparseArray<View> sparseArray = this.f7165e;
        for (int length = viewArr.length - 1; length >= 0; length--) {
            View view = viewArr[length];
            if (view != null) {
                int i2 = iArr[length];
                viewArr[length] = null;
                iArr[length] = -1;
                if (g(i2)) {
                    if (z) {
                        sparseArray = this.c[i2];
                    }
                    sparseArray.put(length, view);
                    if (Build.VERSION.SDK_INT >= 14) {
                        view.setAccessibilityDelegate(null);
                    }
                }
            }
        }
        c();
    }

    public void f(int i2) {
        if (i2 >= 1) {
            SparseArray<View>[] sparseArrayArr = new SparseArray[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                sparseArrayArr[i3] = new SparseArray<>();
            }
            this.f7164d = i2;
            this.f7165e = sparseArrayArr[0];
            this.c = sparseArrayArr;
            return;
        }
        throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
    }

    protected boolean g(int i2) {
        return i2 >= 0;
    }
}
