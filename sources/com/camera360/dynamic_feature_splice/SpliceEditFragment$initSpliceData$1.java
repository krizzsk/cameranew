package com.camera360.dynamic_feature_splice;

import com.camera360.dynamic_feature_splice.SpliceEditFragment;
import com.camera360.dynamic_feature_splice.SpliceEditFragment$initSpliceData$1;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.g2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpliceEditFragment.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceEditFragment$initSpliceData$1", f = "SpliceEditFragment.kt", i = {}, l = {696, 697}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class SpliceEditFragment$initSpliceData$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ SpliceEditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpliceEditFragment.kt */
    @DebugMetadata(c = "com.camera360.dynamic_feature_splice.SpliceEditFragment$initSpliceData$1$1", f = "SpliceEditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.camera360.dynamic_feature_splice.SpliceEditFragment$initSpliceData$1$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ List<n1> $list;
        final /* synthetic */ int $position;
        int label;
        final /* synthetic */ SpliceEditFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SpliceEditFragment spliceEditFragment, List<n1> list, int i2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = spliceEditFragment;
            this.$list = list;
            this.$position = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
        public static final void m14invokeSuspend$lambda0(SpliceEditFragment spliceEditFragment, SpliceEditFragment.a aVar, int i2) {
            boolean z;
            z = spliceEditFragment.f2161k;
            if (z) {
                return;
            }
            CropZoomImageView i3 = aVar.i(i2);
            if (i3 != null) {
                SpliceScrollView spliceScrollView = spliceEditFragment.f2154d;
                if (spliceScrollView == null) {
                    kotlin.jvm.internal.s.z("scrollView");
                    throw null;
                }
                int top = i3.getTop();
                int height = i3.getHeight();
                SpliceScrollView spliceScrollView2 = spliceEditFragment.f2154d;
                if (spliceScrollView2 == null) {
                    kotlin.jvm.internal.s.z("scrollView");
                    throw null;
                }
                spliceScrollView.smoothScrollTo(0, top + ((height - spliceScrollView2.getHeight()) / 2));
            }
            if (spliceEditFragment.G()) {
                spliceEditFragment.y0();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$list, this.$position, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                z = this.this$0.f2161k;
                if (!z) {
                    this.this$0.M0();
                    final SpliceEditFragment.a aVar = new SpliceEditFragment.a(this.this$0);
                    aVar.p(this.$list);
                    this.this$0.m = aVar;
                    SpliceScrollView spliceScrollView = this.this$0.f2154d;
                    if (spliceScrollView != null) {
                        spliceScrollView.setAdapter(aVar);
                        aVar.q(this.$position);
                        this.this$0.C1();
                        if (this.$position >= 0) {
                            SpliceScrollView spliceScrollView2 = this.this$0.f2154d;
                            if (spliceScrollView2 == null) {
                                kotlin.jvm.internal.s.z("scrollView");
                                throw null;
                            }
                            DragLinearLayout g2 = spliceScrollView2.g();
                            final SpliceEditFragment spliceEditFragment = this.this$0;
                            final int i2 = this.$position;
                            us.pinguo.foundation.ui.c.b(g2, new Runnable() { // from class: com.camera360.dynamic_feature_splice.o0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    SpliceEditFragment$initSpliceData$1.AnonymousClass1.m14invokeSuspend$lambda0(SpliceEditFragment.this, aVar, i2);
                                }
                            });
                        }
                        return kotlin.u.a;
                    }
                    kotlin.jvm.internal.s.z("scrollView");
                    throw null;
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceEditFragment$initSpliceData$1(SpliceEditFragment spliceEditFragment, int i2, Continuation<? super SpliceEditFragment$initSpliceData$1> continuation) {
        super(2, continuation);
        this.this$0 = spliceEditFragment;
        this.$position = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new SpliceEditFragment$initSpliceData$1(this.this$0, this.$position, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((SpliceEditFragment$initSpliceData$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        o1 o1Var;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            Splices splices = Splices.a;
            ArrayList arrayList = this.this$0.b;
            o1Var = this.this$0.m;
            List<n1> h2 = o1Var == null ? null : o1Var.h();
            this.label = 1;
            obj = splices.d(arrayList, h2, this);
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
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, (List) obj, this.$position, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}
