package us.pinguo.common.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
/* compiled from: VipNoticeAnimView.kt */
@DebugMetadata(c = "us.pinguo.common.widget.VipNoticeAnimView$onTransitionAnimEnd$1", f = "VipNoticeAnimView.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class VipNoticeAnimView$onTransitionAnimEnd$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;
    final /* synthetic */ VipNoticeAnimView this$0;

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Animator.AnimatorListener {
        final /* synthetic */ VipNoticeAnimView a;

        public a(VipNoticeAnimView vipNoticeAnimView) {
            this.a = vipNoticeAnimView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            s.h(animator, "animator");
            VipNoticeAnimView vipNoticeAnimView = this.a;
            int i2 = us.pinguo.commonui.R.id.noticeText;
            ((TextView) vipNoticeAnimView.a(i2)).setWidth(this.a.d());
            TextView noticeText = (TextView) this.a.a(i2);
            s.g(noticeText, "noticeText");
            noticeText.setVisibility(8);
            VdsAgent.onSetViewVisibility(noticeText, 8);
            ImageView iconVip = (ImageView) this.a.a(us.pinguo.commonui.R.id.iconVip);
            s.g(iconVip, "iconVip");
            iconVip.setVisibility(0);
            VdsAgent.onSetViewVisibility(iconVip, 0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            s.h(animator, "animator");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipNoticeAnimView$onTransitionAnimEnd$1(VipNoticeAnimView vipNoticeAnimView, Continuation<? super VipNoticeAnimView$onTransitionAnimEnd$1> continuation) {
        super(2, continuation);
        this.this$0 = vipNoticeAnimView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new VipNoticeAnimView$onTransitionAnimEnd$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((VipNoticeAnimView$onTransitionAnimEnd$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            this.label = 1;
            if (DelayKt.b(2500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        VipNoticeAnimView vipNoticeAnimView = this.this$0;
        int i3 = us.pinguo.commonui.R.id.noticeText;
        Context b = us.pinguo.foundation.e.b();
        s.g(b, "getAppContext()");
        vipNoticeAnimView.setScaleXAnim(ObjectAnimator.ofInt((TextView) vipNoticeAnimView.a(i3), "width", ((TextView) this.this$0.a(i3)).getWidth(), us.pinguo.util.g.a(b, 32.0f)));
        ObjectAnimator e2 = this.this$0.e();
        if (e2 != null) {
            e2.setDuration(400L);
        }
        ObjectAnimator e3 = this.this$0.e();
        if (e3 != null) {
            e3.addListener(new a(this.this$0));
        }
        ObjectAnimator e4 = this.this$0.e();
        if (e4 != null) {
            e4.start();
        }
        return u.a;
    }
}
