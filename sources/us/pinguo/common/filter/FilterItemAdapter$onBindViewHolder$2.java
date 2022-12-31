package us.pinguo.common.filter;

import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.repository2020.entity.FilterItem;
/* compiled from: FilterItemAdapter.kt */
/* loaded from: classes4.dex */
final class FilterItemAdapter$onBindViewHolder$2 extends Lambda implements l<Boolean, u> {
    final /* synthetic */ FilterItem $filter;
    final /* synthetic */ FilterItemAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterItemAdapter$onBindViewHolder$2(FilterItemAdapter filterItemAdapter, FilterItem filterItem) {
        super(1);
        this.this$0 = filterItemAdapter;
        this.$filter = filterItem;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return u.a;
    }

    public final void invoke(boolean z) {
        p<Boolean, FilterItem, u> f2 = this.this$0.f();
        if (f2 == null) {
            return;
        }
        f2.invoke(Boolean.valueOf(z), this.$filter);
    }
}
