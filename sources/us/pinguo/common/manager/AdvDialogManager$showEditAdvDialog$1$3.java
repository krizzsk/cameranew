package us.pinguo.common.manager;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.camera2020.view.dialog.HomeAdvDialog;
import us.pinguo.foundation.statistics.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdvDialogManager.kt */
@DebugMetadata(c = "us.pinguo.common.manager.AdvDialogManager$showEditAdvDialog$1$3", f = "AdvDialogManager.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class AdvDialogManager$showEditAdvDialog$1$3 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ AdvItem $advItem;
    int label;
    final /* synthetic */ AdvDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvDialogManager$showEditAdvDialog$1$3(FragmentActivity fragmentActivity, AdvDialogManager advDialogManager, AdvItem advItem, Continuation<? super AdvDialogManager$showEditAdvDialog$1$3> continuation) {
        super(2, continuation);
        this.$activity = fragmentActivity;
        this.this$0 = advDialogManager;
        this.$advItem = advItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new AdvDialogManager$showEditAdvDialog$1$3(this.$activity, this.this$0, this.$advItem, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((AdvDialogManager$showEditAdvDialog$1$3) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        HomeAdvDialog homeAdvDialog;
        HomeAdvDialog homeAdvDialog2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            this.label = 1;
            if (DelayKt.b(1000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        FragmentActivity fragmentActivity = this.$activity;
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            homeAdvDialog = this.this$0.a;
            if (!(homeAdvDialog != null && homeAdvDialog.b0())) {
                FragmentTransaction beginTransaction = this.$activity.getSupportFragmentManager().beginTransaction();
                s.g(beginTransaction, "activity.supportFragmentManager.beginTransaction()");
                homeAdvDialog2 = this.this$0.a;
                if (homeAdvDialog2 != null) {
                    AdvItem advItem = this.$advItem;
                    FragmentTransaction add = beginTransaction.add(homeAdvDialog2, "advDialog");
                    VdsAgent.onFragmentTransactionAdd(beginTransaction, homeAdvDialog2, "advDialog", add);
                    add.commitAllowingStateLoss();
                    h.a.L("edit_page_main", advItem.advId, "show");
                    AdvConfigManager.getInstance().addGuidDisplayCount(advItem);
                    b.a.a(advItem);
                }
                return u.a;
            }
        }
        return u.a;
    }
}
