package com.camera360.dynamic_feature_splice;

import com.camera360.dynamic_feature_splice.SpliceEditFragment$swapSpliceItem$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.g2;
import us.pinguo.picker.image.PickItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpliceEditFragment.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceEditFragment$swapSpliceItem$1", f = "SpliceEditFragment.kt", i = {}, l = {237, 238}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class SpliceEditFragment$swapSpliceItem$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ PickItem $pickItem;
    int label;
    final /* synthetic */ SpliceEditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpliceEditFragment.kt */
    @DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceEditFragment$swapSpliceItem$1$1", f = "SpliceEditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.camera360.dynamic_feature_splice.SpliceEditFragment$swapSpliceItem$1$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ n1 $spliceItem;
        int label;
        final /* synthetic */ SpliceEditFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SpliceEditFragment spliceEditFragment, n1 n1Var, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = spliceEditFragment;
            this.$spliceItem = n1Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
        public static final void m15invokeSuspend$lambda0(SpliceEditFragment spliceEditFragment, CropZoomImageView cropZoomImageView) {
            boolean z;
            z = spliceEditFragment.f2161k;
            if (z) {
                return;
            }
            SpliceScrollView spliceScrollView = spliceEditFragment.f2154d;
            if (spliceScrollView == null) {
                kotlin.jvm.internal.s.z("scrollView");
                throw null;
            }
            int top = cropZoomImageView.getTop();
            int height = cropZoomImageView.getHeight();
            SpliceScrollView spliceScrollView2 = spliceEditFragment.f2154d;
            if (spliceScrollView2 != null) {
                spliceScrollView.smoothScrollTo(0, top + ((height - spliceScrollView2.getHeight()) / 2));
            } else {
                kotlin.jvm.internal.s.z("scrollView");
                throw null;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$spliceItem, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            o1 o1Var;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                z = this.this$0.f2161k;
                if (!z && this.$spliceItem != null) {
                    o1Var = this.this$0.m;
                    if (o1Var == null) {
                        return kotlin.u.a;
                    }
                    o1Var.d(this.$spliceItem);
                    final CropZoomImageView i2 = o1Var.i(o1Var.b());
                    if (i2 != null) {
                        i2.e(this.$spliceItem.a());
                    }
                    if (i2 != null) {
                        SpliceScrollView spliceScrollView = this.this$0.f2154d;
                        if (spliceScrollView == null) {
                            kotlin.jvm.internal.s.z("scrollView");
                            throw null;
                        }
                        DragLinearLayout g2 = spliceScrollView.g();
                        final SpliceEditFragment spliceEditFragment = this.this$0;
                        us.pinguo.foundation.ui.c.b(g2, new Runnable() { // from class: com.camera360.dynamic_feature_splice.q0
                            @Override // java.lang.Runnable
                            public final void run() {
                                SpliceEditFragment$swapSpliceItem$1.AnonymousClass1.m15invokeSuspend$lambda0(SpliceEditFragment.this, i2);
                            }
                        });
                    }
                    return kotlin.u.a;
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceEditFragment$swapSpliceItem$1(PickItem pickItem, SpliceEditFragment spliceEditFragment, Continuation<? super SpliceEditFragment$swapSpliceItem$1> continuation) {
        super(2, continuation);
        this.$pickItem = pickItem;
        this.this$0 = spliceEditFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new SpliceEditFragment$swapSpliceItem$1(this.$pickItem, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((SpliceEditFragment$swapSpliceItem$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            Splices splices = Splices.a;
            PickItem pickItem = this.$pickItem;
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
