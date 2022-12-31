package com.camera360.dynamic_feature_splice;

import com.camera360.dynamic_feature_splice.SplicePickPhotoItemAdapter;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplicePickPhotoItemAdapter.kt */
/* loaded from: classes8.dex */
public final class SplicePickPhotoItemAdapter$onBindViewHolder$1$1$1 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ SplicePickPhotoItemAdapter.a $holder;
    final /* synthetic */ boolean $ischecked;
    final /* synthetic */ int $position;
    final /* synthetic */ SplicePickPhotoItemAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplicePickPhotoItemAdapter$onBindViewHolder$1$1$1(SplicePickPhotoItemAdapter splicePickPhotoItemAdapter, SplicePickPhotoItemAdapter.a aVar, int i2, boolean z) {
        super(1);
        this.this$0 = splicePickPhotoItemAdapter;
        this.$holder = aVar;
        this.$position = i2;
        this.$ischecked = z;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke2(bool);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        if (this.this$0.h() || this.$holder.f() != this.$position) {
            return;
        }
        if (kotlin.jvm.internal.s.c(bool, Boolean.FALSE)) {
            this.$holder.b().setVisibility(0);
        }
        this.this$0.v(this.$holder, this.$ischecked, bool == null ? true : bool.booleanValue());
    }
}
