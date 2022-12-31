package com.camera360.dynamic_feature_splice;

import com.camera360.dynamic_feature_splice.SpliceEditFragment;
import java.util.List;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpliceEditFragment.kt */
/* loaded from: classes8.dex */
public final class SpliceEditFragment$changeSet$2 extends Lambda implements kotlin.jvm.b.l<List<? extends us.pinguo.picker.image.gallery.m>, kotlin.u> {
    final /* synthetic */ SpliceEditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceEditFragment$changeSet$2(SpliceEditFragment spliceEditFragment) {
        super(1);
        this.this$0 = spliceEditFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(List<? extends us.pinguo.picker.image.gallery.m> list) {
        invoke2(list);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends us.pinguo.picker.image.gallery.m> list) {
        boolean z;
        SpliceEditFragment.b bVar;
        z = this.this$0.f2161k;
        if (z || list == null) {
            return;
        }
        bVar = this.this$0.p;
        bVar.x(list);
    }
}
