package us.pinguo.common.filter;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.repository2020.entity.PackageItem;
/* compiled from: FilterPackageAdapter.kt */
/* loaded from: classes4.dex */
final class FilterPackageAdapter$onBindViewHolder$1 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ PackageItem $filterPackage;
    final /* synthetic */ int $realPosition;
    final /* synthetic */ FilterPackageAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPackageAdapter$onBindViewHolder$1(FilterPackageAdapter filterPackageAdapter, int i2, PackageItem packageItem) {
        super(0);
        this.this$0 = filterPackageAdapter;
        this.$realPosition = i2;
        this.$filterPackage = packageItem;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        p<Integer, PackageItem, u> g2 = this.this$0.g();
        if (g2 == null) {
            return;
        }
        g2.invoke(Integer.valueOf(this.$realPosition), this.$filterPackage);
    }
}
