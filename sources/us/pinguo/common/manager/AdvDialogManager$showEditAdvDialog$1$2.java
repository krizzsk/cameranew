package us.pinguo.common.manager;

import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.statistics.h;
/* compiled from: AdvDialogManager.kt */
/* loaded from: classes4.dex */
final class AdvDialogManager$showEditAdvDialog$1$2 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ AdvItem $advItem;
    final /* synthetic */ kotlin.jvm.b.a<u> $onCancel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvDialogManager$showEditAdvDialog$1$2(kotlin.jvm.b.a<u> aVar, AdvItem advItem) {
        super(0);
        this.$onCancel = aVar;
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
        kotlin.jvm.b.a<u> aVar = this.$onCancel;
        if (aVar != null) {
            aVar.invoke();
        }
        h.a.L("edit_page_main", this.$advItem.advId, "cancel");
    }
}
