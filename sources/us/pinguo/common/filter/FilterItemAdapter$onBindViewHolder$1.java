package us.pinguo.common.filter;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.repository2020.entity.FilterItem;
/* compiled from: FilterItemAdapter.kt */
/* loaded from: classes4.dex */
final class FilterItemAdapter$onBindViewHolder$1 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ FilterItem $filter;
    final /* synthetic */ int $position;
    final /* synthetic */ FilterItemAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterItemAdapter$onBindViewHolder$1(FilterItemAdapter filterItemAdapter, int i2, FilterItem filterItem) {
        super(0);
        this.this$0 = filterItemAdapter;
        this.$position = i2;
        this.$filter = filterItem;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        p<Integer, FilterItem, u> g2 = this.this$0.g();
        if (g2 == null) {
            return;
        }
        g2.invoke(Integer.valueOf(this.$position), this.$filter);
    }
}
