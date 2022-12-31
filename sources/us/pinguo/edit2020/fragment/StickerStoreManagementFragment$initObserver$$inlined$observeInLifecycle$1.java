package us.pinguo.edit2020.fragment;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.repository2020.database.staticsticker.StaticSticker;
/* compiled from: StaticStickerExtension.kt */
@DebugMetadata(c = "us.pinguo.edit2020.utils.StaticStickerExtensionKt$observeInLifecycle$1", f = "StaticStickerExtension.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StickerStoreManagementFragment$initObserver$$inlined$observeInLifecycle$1 extends SuspendLambda implements kotlin.jvm.b.p<List<StaticSticker>, Continuation<? super kotlin.u>, Object> {
    int label;

    public StickerStoreManagementFragment$initObserver$$inlined$observeInLifecycle$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new StickerStoreManagementFragment$initObserver$$inlined$observeInLifecycle$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(List<StaticSticker> list, Continuation<? super kotlin.u> continuation) {
        return ((StickerStoreManagementFragment$initObserver$$inlined$observeInLifecycle$1) create(list, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
