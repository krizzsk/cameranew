package us.pinguo.edit2020.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerStoreListFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.StickerStoreListFragment$doOnError$1", f = "StickerStoreListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StickerStoreListFragment$doOnError$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ StickerStoreListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreListFragment$doOnError$1(StickerStoreListFragment stickerStoreListFragment, Continuation<? super StickerStoreListFragment$doOnError$1> continuation) {
        super(2, continuation);
        this.this$0 = stickerStoreListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m102invokeSuspend$lambda0(StickerStoreListFragment stickerStoreListFragment, View view) {
        StaticStickerStoreViewModel i0;
        VdsAgent.lambdaOnClick(view);
        if (us.pinguo.common.widget.tab.k.b(us.pinguo.common.widget.tab.k.a, 0, 1, null)) {
            return;
        }
        i0 = stickerStoreListFragment.i0();
        i0.l();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new StickerStoreListFragment$doOnError$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((StickerStoreListFragment$doOnError$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            View inflate = this.this$0.getLayoutInflater().inflate(R.layout.error_load_view, (ViewGroup) null);
            final StickerStoreListFragment stickerStoreListFragment = this.this$0;
            ((TextView) inflate.findViewById(R.id.tvRetry)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.fragment.x0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StickerStoreListFragment$doOnError$1.m102invokeSuspend$lambda0(StickerStoreListFragment.this, view);
                }
            });
            StickerStoreListFragment stickerStoreListFragment2 = this.this$0;
            int i2 = R.id.flContainer;
            ((FrameLayout) stickerStoreListFragment2._$_findCachedViewById(i2)).removeAllViews();
            ((FrameLayout) this.this$0._$_findCachedViewById(i2)).addView(inflate);
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
