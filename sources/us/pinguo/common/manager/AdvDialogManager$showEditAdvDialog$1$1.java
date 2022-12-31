package us.pinguo.common.manager;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.advconfigdata.database.AdvItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvDialogManager.kt */
/* loaded from: classes4.dex */
public final class AdvDialogManager$showEditAdvDialog$1$1 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ AdvItem $advItem;
    final /* synthetic */ l<Uri, u> $onConfirmClick;
    final /* synthetic */ AdvDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdvDialogManager$showEditAdvDialog$1$1(AdvItem advItem, AdvDialogManager advDialogManager, l<? super Uri, u> lVar, FragmentActivity fragmentActivity) {
        super(0);
        this.$advItem = advItem;
        this.this$0 = advDialogManager;
        this.$onConfirmClick = lVar;
        this.$activity = fragmentActivity;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (r1 == true) goto L9;
     */
    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke2() {
        /*
            r7 = this;
            us.pinguo.foundation.statistics.c r0 = us.pinguo.foundation.statistics.h.a
            us.pinguo.advconfigdata.database.AdvItem r1 = r7.$advItem
            java.lang.String r1 = r1.advId
            java.lang.String r2 = "edit_page_main"
            java.lang.String r3 = "click"
            r0.L(r2, r1, r3)
            us.pinguo.common.manager.AdvDialogManager r0 = r7.this$0     // Catch: java.lang.Exception -> L1a
            us.pinguo.camera2020.view.dialog.HomeAdvDialog r0 = us.pinguo.common.manager.AdvDialogManager.a(r0)     // Catch: java.lang.Exception -> L1a
            if (r0 != 0) goto L16
            goto L1e
        L16:
            r0.dismissAllowingStateLoss()     // Catch: java.lang.Exception -> L1a
            goto L1e
        L1a:
            r0 = move-exception
            r0.printStackTrace()
        L1e:
            us.pinguo.advconfigdata.database.AdvItem r0 = r7.$advItem
            java.lang.String r0 = r0.interactionUri
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r1 = r0.getPath()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L30
        L2e:
            r2 = 0
            goto L3a
        L30:
            r4 = 2
            r5 = 0
            java.lang.String r6 = "edit"
            boolean r1 = kotlin.text.l.C(r1, r6, r3, r4, r5)
            if (r1 != r2) goto L2e
        L3a:
            if (r2 == 0) goto L47
            kotlin.jvm.b.l<android.net.Uri, kotlin.u> r1 = r7.$onConfirmClick
            java.lang.String r2 = "uri"
            kotlin.jvm.internal.s.g(r0, r2)
            r1.invoke(r0)
            goto L56
        L47:
            us.pinguo.foundation.interaction.AppGoto r0 = us.pinguo.foundation.interaction.AppGoto.getInstance()
            us.pinguo.advconfigdata.database.AdvItem r1 = r7.$advItem
            us.pinguo.foundation.interaction.c r0 = r0.d(r1)
            androidx.fragment.app.FragmentActivity r1 = r7.$activity
            r0.b(r1)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.manager.AdvDialogManager$showEditAdvDialog$1$1.invoke2():void");
    }
}
