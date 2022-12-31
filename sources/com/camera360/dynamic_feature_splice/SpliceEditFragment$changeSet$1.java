package com.camera360.dynamic_feature_splice;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Lambda;
/* compiled from: SpliceEditFragment.kt */
/* loaded from: classes8.dex */
final class SpliceEditFragment$changeSet$1 extends Lambda implements kotlin.jvm.b.a<List<? extends us.pinguo.picker.image.gallery.m>> {
    final /* synthetic */ us.pinguo.picker.image.gallery.o $mediaSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceEditFragment$changeSet$1(us.pinguo.picker.image.gallery.o oVar) {
        super(0);
        this.$mediaSet = oVar;
    }

    @Override // kotlin.jvm.b.a
    public final List<? extends us.pinguo.picker.image.gallery.m> invoke() {
        List<? extends us.pinguo.picker.image.gallery.m> h2;
        us.pinguo.picker.image.gallery.o oVar = this.$mediaSet;
        ArrayList<us.pinguo.picker.image.gallery.m> g2 = oVar.g(0, oVar.h());
        if (g2 == null) {
            h2 = kotlin.collections.u.h();
            return h2;
        }
        return g2;
    }
}
