package us.pinguo.common.filter;

import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.repository2020.entity.PackageItem;
/* compiled from: FilterPackageAdapter.kt */
/* loaded from: classes4.dex */
final class FilterPackageAdapter$onBindViewHolder$2 extends Lambda implements l<Boolean, u> {
    final /* synthetic */ PackageItem $filterPackage;
    final /* synthetic */ FilterPackageAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPackageAdapter$onBindViewHolder$2(FilterPackageAdapter filterPackageAdapter, PackageItem packageItem) {
        super(1);
        this.this$0 = filterPackageAdapter;
        this.$filterPackage = packageItem;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return u.a;
    }

    public final void invoke(boolean z) {
        p<PackageItem, Boolean, u> f2 = this.this$0.f();
        if (f2 == null) {
            return;
        }
        f2.invoke(this.$filterPackage, Boolean.valueOf(z));
    }
}
