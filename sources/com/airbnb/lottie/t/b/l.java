package com.airbnb.lottie.t.b;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class l implements m, j {
    private final Path a = new Path();
    private final Path b = new Path();
    private final Path c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final List<m> f507d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final MergePaths f508e;

    /* compiled from: MergePathsContent.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT >= 19) {
            mergePaths.c();
            this.f508e = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    private void a() {
        for (int i2 = 0; i2 < this.f507d.size(); i2++) {
            this.c.addPath(this.f507d.get(i2).getPath());
        }
    }

    @TargetApi(19)
    private void c(Path.Op op) {
        this.b.reset();
        this.a.reset();
        for (int size = this.f507d.size() - 1; size >= 1; size--) {
            m mVar = this.f507d.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> i2 = dVar.i();
                for (int size2 = i2.size() - 1; size2 >= 0; size2--) {
                    Path path = i2.get(size2).getPath();
                    path.transform(dVar.j());
                    this.b.addPath(path);
                }
            } else {
                this.b.addPath(mVar.getPath());
            }
        }
        m mVar2 = this.f507d.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> i3 = dVar2.i();
            for (int i4 = 0; i4 < i3.size(); i4++) {
                Path path2 = i3.get(i4).getPath();
                path2.transform(dVar2.j());
                this.a.addPath(path2);
            }
        } else {
            this.a.set(mVar2.getPath());
        }
        this.c.op(this.a, this.b, op);
    }

    @Override // com.airbnb.lottie.t.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < this.f507d.size(); i2++) {
            this.f507d.get(i2).b(list, list2);
        }
    }

    @Override // com.airbnb.lottie.t.b.j
    public void f(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c previous = listIterator.previous();
            if (previous instanceof m) {
                this.f507d.add((m) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.m
    public Path getPath() {
        this.c.reset();
        if (this.f508e.d()) {
            return this.c;
        }
        int i2 = a.a[this.f508e.b().ordinal()];
        if (i2 == 1) {
            a();
        } else if (i2 == 2) {
            c(Path.Op.UNION);
        } else if (i2 == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i2 == 4) {
            c(Path.Op.INTERSECT);
        } else if (i2 == 5) {
            c(Path.Op.XOR);
        }
        return this.c;
    }
}
