package us.pinguo.edit2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.utils.k;
import us.pinguo.repository2020.database.staticsticker.ShopDetail;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerStoreDetailFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.StickerStoreDetailFragment$initObserver$1", f = "StickerStoreDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StickerStoreDetailFragment$initObserver$1 extends SuspendLambda implements kotlin.jvm.b.p<us.pinguo.edit2020.utils.k<ShopDetail>, Continuation<? super kotlin.u>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StickerStoreDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreDetailFragment$initObserver$1(StickerStoreDetailFragment stickerStoreDetailFragment, Continuation<? super StickerStoreDetailFragment$initObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = stickerStoreDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        StickerStoreDetailFragment$initObserver$1 stickerStoreDetailFragment$initObserver$1 = new StickerStoreDetailFragment$initObserver$1(this.this$0, continuation);
        stickerStoreDetailFragment$initObserver$1.L$0 = obj;
        return stickerStoreDetailFragment$initObserver$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(us.pinguo.edit2020.utils.k<ShopDetail> kVar, Continuation<? super kotlin.u> continuation) {
        return ((StickerStoreDetailFragment$initObserver$1) create(kVar, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            us.pinguo.edit2020.utils.k kVar = (us.pinguo.edit2020.utils.k) this.L$0;
            if (kVar instanceof k.d) {
                this.this$0.n0((k.d) kVar);
            } else if (kVar instanceof k.b) {
                this.this$0.l0();
            } else {
                this.this$0.m0();
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
