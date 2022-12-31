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
import kotlinx.coroutines.DelayKt;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerStoreDetailFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.StickerStoreDetailFragment$doOnError$1", f = "StickerStoreDetailFragment.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StickerStoreDetailFragment$doOnError$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ StickerStoreDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreDetailFragment$doOnError$1(StickerStoreDetailFragment stickerStoreDetailFragment, Continuation<? super StickerStoreDetailFragment$doOnError$1> continuation) {
        super(2, continuation);
        this.this$0 = stickerStoreDetailFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m101invokeSuspend$lambda0(StickerStoreDetailFragment stickerStoreDetailFragment, View view) {
        StaticStickerStoreViewModel r0;
        String str;
        VdsAgent.lambdaOnClick(view);
        if (us.pinguo.common.widget.tab.k.b(us.pinguo.common.widget.tab.k.a, 0, 1, null)) {
            return;
        }
        r0 = stickerStoreDetailFragment.r0();
        str = stickerStoreDetailFragment.b;
        r0.j(str);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new StickerStoreDetailFragment$doOnError$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((StickerStoreDetailFragment$doOnError$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            this.label = 1;
            if (DelayKt.b(1500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        View inflate = this.this$0.getLayoutInflater().inflate(R.layout.error_load_view, (ViewGroup) null);
        final StickerStoreDetailFragment stickerStoreDetailFragment = this.this$0;
        ((TextView) inflate.findViewById(R.id.tvRetry)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.fragment.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerStoreDetailFragment$doOnError$1.m101invokeSuspend$lambda0(StickerStoreDetailFragment.this, view);
            }
        });
        ((TextView) this.this$0._$_findCachedViewById(R.id.tvTitle)).setText(us.pinguo.edit2020.utils.d.k(R.string.str_sticker_store));
        StickerStoreDetailFragment stickerStoreDetailFragment2 = this.this$0;
        int i3 = R.id.flContainer;
        ((FrameLayout) stickerStoreDetailFragment2._$_findCachedViewById(i3)).removeAllViews();
        ((FrameLayout) this.this$0._$_findCachedViewById(i3)).addView(inflate);
        return kotlin.u.a;
    }
}
