package us.pinguo.common.filter.controller;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.entity.PackageItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterController.kt */
/* loaded from: classes4.dex */
public final class FilterController$flingFilter$3 extends Lambda implements kotlin.jvm.b.l<PackageItem, u> {
    final /* synthetic */ boolean $seekbarStatus;
    final /* synthetic */ FilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterController$flingFilter$3(FilterController filterController, boolean z) {
        super(1);
        this.this$0 = filterController;
        this.$seekbarStatus = z;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(PackageItem packageItem) {
        invoke2(packageItem);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(PackageItem it) {
        s.h(it, "it");
        this.this$0.f1(this.$seekbarStatus);
    }
}
