package com.pinguo.camera360.test;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pinguo.camera360.test.ABActivity;
import java.util.HashMap;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.z0;
import vStudio.Android.Camera360.R;
/* compiled from: ABActivity.kt */
@DebugMetadata(c = "com.pinguo.camera360.test.ABActivity$onCreate$1", f = "ABActivity.kt", i = {}, l = {56, 57}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class ABActivity$onCreate$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ABActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ABActivity.kt */
    @DebugMetadata(c = "com.pinguo.camera360.test.ABActivity$onCreate$1$1", f = "ABActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.pinguo.camera360.test.ABActivity$onCreate$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        int label;
        final /* synthetic */ ABActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ABActivity aBActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = aBActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            HashMap hashMap;
            List list;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                ABActivity aBActivity = this.this$0;
                int i2 = R.id.rv_ab;
                ((RecyclerView) aBActivity._$_findCachedViewById(i2)).setLayoutManager(new LinearLayoutManager(this.this$0));
                hashMap = this.this$0.f6958e;
                ABActivity.a aVar = new ABActivity.a(hashMap);
                list = this.this$0.f6957d;
                aVar.e(list);
                ((RecyclerView) this.this$0._$_findCachedViewById(i2)).setAdapter(aVar);
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABActivity$onCreate$1(ABActivity aBActivity, Continuation<? super ABActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = aBActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ABActivity$onCreate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ABActivity$onCreate$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ABActivity aBActivity;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            aBActivity = this.this$0;
            this.L$0 = aBActivity;
            this.label = 1;
            obj = aBActivity.v0(this);
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
            aBActivity = (ABActivity) this.L$0;
            kotlin.j.b(obj);
        }
        aBActivity.f6957d = (List) obj;
        g2 c = z0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
        this.L$0 = null;
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}
