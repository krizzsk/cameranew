package us.pinguo.common.filter.controller;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterController.kt */
@DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$onStoreActivityResult$1", f = "FilterController.kt", i = {}, l = {1011}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FilterController$onStoreActivityResult$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $categoryId;
    final /* synthetic */ String $filterId;
    final /* synthetic */ String $packageId;
    int label;
    final /* synthetic */ FilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterController$onStoreActivityResult$1(FilterController filterController, String str, String str2, String str3, Continuation<? super FilterController$onStoreActivityResult$1> continuation) {
        super(2, continuation);
        this.this$0 = filterController;
        this.$categoryId = str;
        this.$packageId = str2;
        this.$filterId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterController$onStoreActivityResult$1(this.this$0, this.$categoryId, this.$packageId, this.$filterId, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterController$onStoreActivityResult$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            this.label = 1;
            if (DelayKt.b(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        this.this$0.h0();
        FilterController.B0(this.this$0, new FilterEntry(this.$categoryId, this.$packageId, this.$filterId), false, 2, null);
        return u.a;
    }
}
