package us.pinguo.common.manager;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.camera2020.view.dialog.HomeAdvDialog;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.statistics.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvDialogManager.kt */
/* loaded from: classes4.dex */
public final class AdvDialogManager$showAdvDialog$1$1 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ AdvItem $advItem;
    final /* synthetic */ AdvDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvDialogManager$showAdvDialog$1$1(AdvItem advItem, AdvDialogManager advDialogManager, FragmentActivity fragmentActivity) {
        super(0);
        this.$advItem = advItem;
        this.this$0 = advDialogManager;
        this.$activity = fragmentActivity;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        HomeAdvDialog homeAdvDialog;
        h.a.L("camerafragment", this.$advItem.advId, "click");
        try {
            homeAdvDialog = this.this$0.a;
            if (homeAdvDialog != null) {
                homeAdvDialog.dismissAllowingStateLoss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        AppGoto.getInstance().d(this.$advItem).b(this.$activity);
    }
}
