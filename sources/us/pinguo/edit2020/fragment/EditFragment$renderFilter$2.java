package us.pinguo.edit2020.fragment;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
final class EditFragment$renderFilter$2 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ Ref$BooleanRef $isOnlineFilter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$renderFilter$2(Ref$BooleanRef ref$BooleanRef) {
        super(1);
        this.$isOnlineFilter = ref$BooleanRef;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        this.$isOnlineFilter.element = z;
    }
}
