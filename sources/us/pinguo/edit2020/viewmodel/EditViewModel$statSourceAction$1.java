package us.pinguo.edit2020.viewmodel;

import com.adjust.sdk.Constants;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.foundation.statistics.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditViewModel.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.EditViewModel$statSourceAction$1", f = "EditViewModel.kt", i = {}, l = {638}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class EditViewModel$statSourceAction$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $action;
    int label;
    final /* synthetic */ EditViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditViewModel$statSourceAction$1(EditViewModel editViewModel, String str, Continuation<? super EditViewModel$statSourceAction$1> continuation) {
        super(2, continuation);
        this.this$0 = editViewModel;
        this.$action = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditViewModel$statSourceAction$1(this.this$0, this.$action, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditViewModel$statSourceAction$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object y;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            EditViewModel editViewModel = this.this$0;
            this.label = 1;
            y = editViewModel.y(this);
            if (y == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
            y = obj;
        }
        ArrayList arrayList = (ArrayList) y;
        if (arrayList == null) {
            return u.a;
        }
        h.b.q(us.pinguo.vip.proxy.b.a.f() ? "vip" : Constants.NORMAL, this.$action, (String) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), (String) arrayList.get(3), (String) arrayList.get(4), (String) arrayList.get(5), (String) arrayList.get(6), (String) arrayList.get(7), (String) arrayList.get(8), (String) arrayList.get(9), (String) arrayList.get(10), (String) arrayList.get(11), (String) arrayList.get(12), (String) arrayList.get(13), (String) arrayList.get(14), (String) arrayList.get(15), (String) arrayList.get(16), (String) arrayList.get(17), (String) arrayList.get(18), (String) arrayList.get(19), (String) arrayList.get(20), (String) arrayList.get(21), (String) arrayList.get(22), (String) arrayList.get(23), (String) arrayList.get(24), (String) arrayList.get(25), (String) arrayList.get(26), (String) arrayList.get(27), (String) arrayList.get(28), (String) arrayList.get(29), (String) arrayList.get(30), (String) arrayList.get(31));
        return u.a;
    }
}
