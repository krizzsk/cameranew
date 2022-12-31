package com.camera360.dynamic_feature_splice;

import kotlin.jvm.internal.Lambda;
/* compiled from: SpliceEditFragment.kt */
/* loaded from: classes8.dex */
final class SpliceEditFragment$positionChanged$mediaItem$1 extends Lambda implements kotlin.jvm.b.l<us.pinguo.picker.image.gallery.m, Boolean> {
    final /* synthetic */ n1 $spliceItem;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceEditFragment$positionChanged$mediaItem$1(n1 n1Var) {
        super(1);
        this.$spliceItem = n1Var;
    }

    @Override // kotlin.jvm.b.l
    public final Boolean invoke(us.pinguo.picker.image.gallery.m it) {
        kotlin.jvm.internal.s.h(it, "it");
        String f2 = it.f();
        n1 n1Var = this.$spliceItem;
        return Boolean.valueOf(kotlin.jvm.internal.s.c(f2, n1Var == null ? null : n1Var.c()));
    }
}
