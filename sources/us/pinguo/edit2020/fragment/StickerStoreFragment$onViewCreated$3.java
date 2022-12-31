package us.pinguo.edit2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
/* compiled from: StickerStoreFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.StickerStoreFragment$onViewCreated$3", f = "StickerStoreFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class StickerStoreFragment$onViewCreated$3 extends SuspendLambda implements kotlin.jvm.b.p<Integer, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ StickerStoreFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreFragment$onViewCreated$3(StickerStoreFragment stickerStoreFragment, Continuation<? super StickerStoreFragment$onViewCreated$3> continuation) {
        super(2, continuation);
        this.this$0 = stickerStoreFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new StickerStoreFragment$onViewCreated$3(this.this$0, continuation);
    }

    public final Object invoke(int i2, Continuation<? super kotlin.u> continuation) {
        return ((StickerStoreFragment$onViewCreated$3) create(Integer.valueOf(i2), continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super kotlin.u> continuation) {
        return invoke(num.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        us.pinguo.edit2020.adapter.r0 e0;
        StaticStickerStoreViewModel f0;
        us.pinguo.edit2020.adapter.r0 e02;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            e0 = this.this$0.e0();
            f0 = this.this$0.f0();
            e0.l(f0.p());
            e02 = this.this$0.e0();
            e02.notifyDataSetChanged();
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
