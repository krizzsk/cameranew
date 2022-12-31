package us.pinguo.edit2020.controller;

import android.text.TextUtils;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.controller.BackgroundReplacementController$2$1;
import us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule;
import us.pinguo.util.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.BackgroundReplacementController$2$1", f = "BackgroundReplacementController.kt", i = {}, l = {141, 142}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class BackgroundReplacementController$2$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundReplacementController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.BackgroundReplacementController$2$1$1", f = "BackgroundReplacementController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.BackgroundReplacementController$2$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        int label;
        final /* synthetic */ BackgroundReplacementController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BackgroundReplacementController backgroundReplacementController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = backgroundReplacementController;
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
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                BackgroundReplacementController.U0(this.this$0, true, false, 2, null);
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundReplacementController.kt */
    /* renamed from: us.pinguo.edit2020.controller.BackgroundReplacementController$2$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
        final /* synthetic */ BackgroundReplacementController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BackgroundReplacementController backgroundReplacementController) {
            super(1);
            this.this$0 = backgroundReplacementController;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invoke$lambda-0  reason: not valid java name */
        public static final void m81invoke$lambda0(BackgroundReplacementController this$0) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            BackgroundReplacementController.U0(this$0, false, false, 2, null);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return kotlin.u.a;
        }

        public final void invoke(boolean z) {
            final BackgroundReplacementController backgroundReplacementController = this.this$0;
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.w
                @Override // java.lang.Runnable
                public final void run() {
                    BackgroundReplacementController$2$1.AnonymousClass2.m81invoke$lambda0(BackgroundReplacementController.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$2$1(String str, BackgroundReplacementController backgroundReplacementController, Continuation<? super BackgroundReplacementController$2$1> continuation) {
        super(2, continuation);
        this.$it = str;
        this.this$0 = backgroundReplacementController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundReplacementController$2$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((BackgroundReplacementController$2$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            if (!TextUtils.isEmpty(this.$it)) {
                String it = this.$it;
                kotlin.jvm.internal.s.g(it, "it");
                this.label = 1;
                obj = FileUtils.q(it, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return kotlin.u.a;
        } else if (i2 != 1) {
            if (i2 == 2) {
                kotlin.j.b(obj);
                BackgroundReplacementModule backgroundReplacementModule = this.this$0.c;
                String it2 = this.$it;
                kotlin.jvm.internal.s.g(it2, "it");
                backgroundReplacementModule.q0(it2, new AnonymousClass2(this.this$0));
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            kotlinx.coroutines.g2 c = kotlinx.coroutines.z0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 2;
            if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            BackgroundReplacementModule backgroundReplacementModule2 = this.this$0.c;
            String it22 = this.$it;
            kotlin.jvm.internal.s.g(it22, "it");
            backgroundReplacementModule2.q0(it22, new AnonymousClass2(this.this$0));
        }
        return kotlin.u.a;
    }
}
