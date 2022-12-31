package com.pinguo.camera360.vip;

import android.content.Context;
import com.pinguo.camera360.vip.VipManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VipManager.kt */
@DebugMetadata(c = "com.pinguo.camera360.vip.VipManager$init$5$1", f = "VipManager.kt", i = {}, l = {284}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class VipManager$init$5$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SubscriptionInfo $vip;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VipManager.kt */
    @DebugMetadata(c = "com.pinguo.camera360.vip.VipManager$init$5$1$1", f = "VipManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.pinguo.camera360.vip.VipManager$init$5$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ VipManager.a $info;
        final /* synthetic */ SubscriptionInfo $vip;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, VipManager.a aVar, SubscriptionInfo subscriptionInfo, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$info = aVar;
            this.$vip = subscriptionInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.$info, this.$vip, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                j.b(obj);
                VipManager vipManager = VipManager.a;
                Context context = this.$context;
                VipManager.a aVar = this.$info;
                SubscriptionInfo vip = this.$vip;
                s.g(vip, "vip");
                vipManager.n(context, aVar, vip);
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipManager$init$5$1(Context context, SubscriptionInfo subscriptionInfo, Continuation<? super VipManager$init$5$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$vip = subscriptionInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new VipManager$init$5$1(this.$context, this.$vip, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((VipManager$init$5$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x014f A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.vip.VipManager$init$5$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
