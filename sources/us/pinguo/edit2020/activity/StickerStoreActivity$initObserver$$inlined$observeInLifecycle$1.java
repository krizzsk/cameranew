package us.pinguo.edit2020.activity;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import us.pinguo.edit2020.viewmodel.d;
/* compiled from: StaticStickerExtension.kt */
@DebugMetadata(c = "us.pinguo.edit2020.utils.StaticStickerExtensionKt$observeInLifecycle$1", f = "StaticStickerExtension.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StickerStoreActivity$initObserver$$inlined$observeInLifecycle$1 extends SuspendLambda implements p<d, Continuation<? super u>, Object> {
    int label;

    public StickerStoreActivity$initObserver$$inlined$observeInLifecycle$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerStoreActivity$initObserver$$inlined$observeInLifecycle$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(d dVar, Continuation<? super u> continuation) {
        return ((StickerStoreActivity$initObserver$$inlined$observeInLifecycle$1) create(dVar, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            j.b(obj);
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
