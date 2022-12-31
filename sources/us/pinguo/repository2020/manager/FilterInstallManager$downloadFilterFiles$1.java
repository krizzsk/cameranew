package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.FilterDetailData;
import us.pinguo.repository2020.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterInstallManager$downloadFilterFiles$1", f = "FilterInstallManager.kt", i = {0}, l = {103, 103, 104}, m = "invokeSuspend", n = {"packageResult"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class FilterInstallManager$downloadFilterFiles$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ FilterDetailData $filterDetail;
    final /* synthetic */ q $listener;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FilterInstallManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterInstallManager$downloadFilterFiles$1(FilterDetailData filterDetailData, q qVar, FilterInstallManager filterInstallManager, Continuation<? super FilterInstallManager$downloadFilterFiles$1> continuation) {
        super(2, continuation);
        this.$filterDetail = filterDetailData;
        this.$listener = qVar;
        this.this$0 = filterInstallManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        FilterInstallManager$downloadFilterFiles$1 filterInstallManager$downloadFilterFiles$1 = new FilterInstallManager$downloadFilterFiles$1(this.$filterDetail, this.$listener, this.this$0, continuation);
        filterInstallManager$downloadFilterFiles$1.L$0 = obj;
        return filterInstallManager$downloadFilterFiles$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterInstallManager$downloadFilterFiles$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d0, code lost:
        if (((java.lang.Boolean) r2).booleanValue() != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.FilterInstallManager$downloadFilterFiles$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
