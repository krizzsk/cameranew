package com.camera360.dynamic_feature_splice;

import java.util.List;
import us.pinguo.picker.image.PickItem;
/* compiled from: SpliceEditFragment.kt */
/* loaded from: classes8.dex */
public final class e1 {
    private final List<PickItem> a;
    private final int b;

    /* JADX WARN: Multi-variable type inference failed */
    public e1(List<? extends PickItem> list, int i2, boolean z) {
        kotlin.jvm.internal.s.h(list, "list");
        this.a = list;
        this.b = i2;
    }

    public final List<PickItem> a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final void c(boolean z) {
    }

    public /* synthetic */ e1(List list, int i2, boolean z, int i3, kotlin.jvm.internal.o oVar) {
        this(list, i2, (i3 & 4) != 0 ? false : z);
    }
}
