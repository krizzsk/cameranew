package us.pinguo.edit2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
final class EditFragment$onViewCreated$3$2 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditFragment.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$onViewCreated$3$2$1", f = "EditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.fragment.EditFragment$onViewCreated$3$2$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        int label;
        final /* synthetic */ EditFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EditFragment editFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = editFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x002f, code lost:
            if (kotlin.jvm.internal.s.c(r2.getValue(), kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)) != false) goto L10;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r2) {
            /*
                r1 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r1.label
                if (r0 != 0) goto L39
                kotlin.j.b(r2)
                us.pinguo.edit2020.fragment.EditFragment r2 = r1.this$0
                r0 = 0
                us.pinguo.edit2020.fragment.EditFragment.N0(r2, r0)
                us.pinguo.edit2020.fragment.EditFragment r2 = r1.this$0
                androidx.lifecycle.MutableLiveData r2 = us.pinguo.edit2020.fragment.EditFragment.D0(r2)
                boolean r2 = r2.hasObservers()
                if (r2 == 0) goto L31
                us.pinguo.edit2020.fragment.EditFragment r2 = r1.this$0
                androidx.lifecycle.MutableLiveData r2 = us.pinguo.edit2020.fragment.EditFragment.D0(r2)
                java.lang.Object r2 = r2.getValue()
                r0 = 1
                java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
                boolean r2 = kotlin.jvm.internal.s.c(r2, r0)
                if (r2 == 0) goto L36
            L31:
                us.pinguo.edit2020.fragment.EditFragment r2 = r1.this$0
                us.pinguo.edit2020.fragment.EditFragment.y0(r2)
            L36:
                kotlin.u r2 = kotlin.u.a
                return r2
            L39:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.fragment.EditFragment$onViewCreated$3$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$onViewCreated$3$2(EditFragment editFragment) {
        super(1);
        this.this$0 = editFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.c()), null, null, new AnonymousClass1(this.this$0, null), 3, null);
    }
}
