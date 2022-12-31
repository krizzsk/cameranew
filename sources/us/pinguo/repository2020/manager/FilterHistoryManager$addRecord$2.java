package us.pinguo.repository2020.manager;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterHistoryManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterHistoryManager$addRecord$2", f = "FilterHistoryManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FilterHistoryManager$addRecord$2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ List<FilterEntry> $filterEntry;
    final /* synthetic */ String $position;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterHistoryManager$addRecord$2(List<FilterEntry> list, String str, Continuation<? super FilterHistoryManager$addRecord$2> continuation) {
        super(2, continuation);
        this.$filterEntry = list;
        this.$position = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterHistoryManager$addRecord$2(this.$filterEntry, this.$position, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterHistoryManager$addRecord$2) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            List<FilterEntry> list = this.$filterEntry;
            String str = this.$position;
            for (FilterEntry filterEntry : list) {
                FilterHistoryManager.a.f(str, filterEntry);
            }
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
