package com.camera360.dynamic_feature_splice;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.camera360.dynamic_feature_splice.SpliceResultFragment$showImageInfo$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.g2;
import us.pinguo.picker.image.PickItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpliceResultFragment.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceResultFragment$showImageInfo$1", f = "SpliceResultFragment.kt", i = {}, l = {226, 227}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class SpliceResultFragment$showImageInfo$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ SpliceResultFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpliceResultFragment.kt */
    @DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceResultFragment$showImageInfo$1$1", f = "SpliceResultFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.camera360.dynamic_feature_splice.SpliceResultFragment$showImageInfo$1$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ n1 $info;
        int label;
        final /* synthetic */ SpliceResultFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SpliceResultFragment spliceResultFragment, n1 n1Var, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = spliceResultFragment;
            this.$info = n1Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
        public static final void m17invokeSuspend$lambda0(SpliceResultFragment spliceResultFragment, View view) {
            FragmentActivity activity = spliceResultFragment.getActivity();
            if (activity == null) {
                return;
            }
            i1.a(activity);
            activity.finish();
            us.pinguo.foundation.statistics.h.a.B("splice_again");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invokeSuspend$lambda-1  reason: not valid java name */
        public static final void m18invokeSuspend$lambda1(SpliceResultFragment spliceResultFragment, n1 n1Var, View view) {
            us.pinguo.foundation.statistics.h.a.B("preview_pic");
            spliceResultFragment.k0(n1Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$info, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            n1 n1Var;
            View view;
            View view2;
            View view3;
            View view4;
            View view5;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                if (!this.this$0.f2177d && (n1Var = this.$info) != null) {
                    if (us.pinguo.foundation.d.f10987f) {
                        this.this$0.t0(n1Var);
                    }
                    view = this.this$0.c;
                    if (view != null) {
                        final SpliceResultFragment spliceResultFragment = this.this$0;
                        ((FrameLayout) view.findViewById(R.id.iv_once_more)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.a1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view6) {
                                SpliceResultFragment$showImageInfo$1.AnonymousClass1.m17invokeSuspend$lambda0(SpliceResultFragment.this, view6);
                            }
                        });
                        view2 = this.this$0.c;
                        if (view2 != null) {
                            ((SpliceResultLayout) view2.findViewById(R.id.puzzle_layout)).setImageBitmap(this.$info.a());
                            view3 = this.this$0.c;
                            if (view3 != null) {
                                int i2 = R.id.puzzle_img;
                                ((ImageView) view3.findViewById(i2)).setImageBitmap(this.$info.a());
                                view4 = this.this$0.c;
                                if (view4 != null) {
                                    final SpliceResultFragment spliceResultFragment2 = this.this$0;
                                    final n1 n1Var2 = this.$info;
                                    ((ImageView) view4.findViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.z0
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view6) {
                                            SpliceResultFragment$showImageInfo$1.AnonymousClass1.m18invokeSuspend$lambda1(SpliceResultFragment.this, n1Var2, view6);
                                        }
                                    });
                                    view5 = this.this$0.c;
                                    if (view5 != null) {
                                        ((ImageView) view5.findViewById(i2)).setVisibility(0);
                                        return kotlin.u.a;
                                    }
                                    kotlin.jvm.internal.s.z("rootView");
                                    throw null;
                                }
                                kotlin.jvm.internal.s.z("rootView");
                                throw null;
                            }
                            kotlin.jvm.internal.s.z("rootView");
                            throw null;
                        }
                        kotlin.jvm.internal.s.z("rootView");
                        throw null;
                    }
                    kotlin.jvm.internal.s.z("rootView");
                    throw null;
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceResultFragment$showImageInfo$1(SpliceResultFragment spliceResultFragment, Continuation<? super SpliceResultFragment$showImageInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = spliceResultFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new SpliceResultFragment$showImageInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((SpliceResultFragment$showImageInfo$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            Splices splices = Splices.a;
            SpliceResult spliceResult = this.this$0.b;
            if (spliceResult == null) {
                kotlin.jvm.internal.s.z("result");
                throw null;
            }
            PickItem pickItem = new PickItem(0, spliceResult.path);
            this.label = 1;
            obj = splices.c(pickItem, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
            return kotlin.u.a;
        } else {
            kotlin.j.b(obj);
        }
        g2 c = kotlinx.coroutines.z0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, (n1) obj, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}
