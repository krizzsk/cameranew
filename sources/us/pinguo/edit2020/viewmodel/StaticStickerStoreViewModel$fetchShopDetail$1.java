package us.pinguo.edit2020.viewmodel;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.m0;
import us.pinguo.edit2020.utils.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerStoreViewModel.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel$fetchShopDetail$1", f = "StaticStickerStoreViewModel.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StaticStickerStoreViewModel$fetchShopDetail$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;
    final /* synthetic */ StaticStickerStoreViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerStoreViewModel$fetchShopDetail$1(StaticStickerStoreViewModel staticStickerStoreViewModel, Continuation<? super StaticStickerStoreViewModel$fetchShopDetail$1> continuation) {
        super(2, continuation);
        this.this$0 = staticStickerStoreViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerStoreViewModel$fetchShopDetail$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerStoreViewModel$fetchShopDetail$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        e eVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            eVar = this.this$0.c;
            k b = k.a.b();
            this.label = 1;
            if (eVar.D(b, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        return u.a;
    }
}
