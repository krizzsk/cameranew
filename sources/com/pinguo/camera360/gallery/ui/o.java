package com.pinguo.camera360.gallery.ui;

import android.util.SparseArray;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.b0.a;
import java.util.ArrayList;
import java.util.Set;
/* compiled from: IPhotoSelector.java */
/* loaded from: classes3.dex */
public interface o {

    /* compiled from: IPhotoSelector.java */
    /* loaded from: classes3.dex */
    public interface a {
        void l();

        void s(int i2);
    }

    /* compiled from: IPhotoSelector.java */
    /* loaded from: classes3.dex */
    public interface b extends a {
        void h(boolean z, Set<Integer> set);

        void n(boolean z, int i2);
    }

    void a(ArrayList<y.c> arrayList, SparseArray<a.C0242a> sparseArray);

    void b(Path path);

    int c();

    void d(a aVar);

    void e(Path path, boolean z);

    void f();

    ArrayList<Path> g(boolean z);

    boolean h(Path path, int i2);

    boolean i();

    void j(com.pinguo.camera360.gallery.data.y yVar);
}
