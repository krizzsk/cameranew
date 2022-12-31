package us.pinguo.common.manager;

import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.statistics.h;
/* compiled from: AdvDialogManager.kt */
/* loaded from: classes4.dex */
final class AdvDialogManager$showAdvDialog$1$2 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ AdvItem $advItem;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvDialogManager$showAdvDialog$1$2(AdvItem advItem) {
        super(0);
        this.$advItem = advItem;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        h.a.L("camerafragment", this.$advItem.advId, "cancel");
    }
}
