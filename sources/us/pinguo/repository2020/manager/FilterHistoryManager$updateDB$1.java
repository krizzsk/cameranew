package us.pinguo.repository2020.manager;

import com.pinguo.camera360.effect.model.entity.Effect;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterHistoryManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterHistoryManager$updateDB$1", f = "FilterHistoryManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FilterHistoryManager$updateDB$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ FilterEntry $entry;
    final /* synthetic */ String $position;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterHistoryManager$updateDB$1(String str, FilterEntry filterEntry, Continuation<? super FilterHistoryManager$updateDB$1> continuation) {
        super(2, continuation);
        this.$position = str;
        this.$entry = filterEntry;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterHistoryManager$updateDB$1(this.$position, this.$entry, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterHistoryManager$updateDB$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            FilterHistoryManager.a.e(this.$position);
            if (this.$entry.getItemId() != null && !s.c(this.$entry.getItemId(), Effect.EFFECT_FILTER_AUTO_KEY) && !s.c(this.$entry.getItemId(), Effect.EFFECT_FILTER_NONE_KEY)) {
                us.pinguo.repository2020.database.b.c c = us.pinguo.repository2020.database.a.a().v().c(this.$position, this.$entry.getItemId());
                if (c == null) {
                    String itemId = this.$entry.getItemId();
                    String pkgId = this.$entry.getPkgId();
                    if (pkgId == null) {
                        pkgId = "";
                    }
                    us.pinguo.repository2020.database.a.a().v().b(new us.pinguo.repository2020.database.b.c(0, itemId, pkgId, this.$position, 1, 1, null));
                } else {
                    c.f(c.b() + 1);
                    us.pinguo.repository2020.database.a.a().v().d(c);
                }
            }
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
