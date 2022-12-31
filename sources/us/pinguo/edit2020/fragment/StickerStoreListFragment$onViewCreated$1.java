package us.pinguo.edit2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.utils.k;
/* compiled from: StickerStoreListFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.StickerStoreListFragment$onViewCreated$1", f = "StickerStoreListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class StickerStoreListFragment$onViewCreated$1 extends SuspendLambda implements kotlin.jvm.b.p<us.pinguo.edit2020.utils.k<us.pinguo.edit2020.model.f.b>, Continuation<? super kotlin.u>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StickerStoreListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreListFragment$onViewCreated$1(StickerStoreListFragment stickerStoreListFragment, Continuation<? super StickerStoreListFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = stickerStoreListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        StickerStoreListFragment$onViewCreated$1 stickerStoreListFragment$onViewCreated$1 = new StickerStoreListFragment$onViewCreated$1(this.this$0, continuation);
        stickerStoreListFragment$onViewCreated$1.L$0 = obj;
        return stickerStoreListFragment$onViewCreated$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(us.pinguo.edit2020.utils.k<us.pinguo.edit2020.model.f.b> kVar, Continuation<? super kotlin.u> continuation) {
        return ((StickerStoreListFragment$onViewCreated$1) create(kVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            us.pinguo.edit2020.utils.k kVar = (us.pinguo.edit2020.utils.k) this.L$0;
            if (kVar instanceof k.d) {
                this.this$0.g0((k.d) kVar);
            } else if (kVar instanceof k.b) {
                this.this$0.e0();
            } else {
                this.this$0.f0();
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
