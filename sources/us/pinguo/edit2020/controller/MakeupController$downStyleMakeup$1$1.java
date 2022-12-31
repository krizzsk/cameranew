package us.pinguo.edit2020.controller;

import androidx.databinding.ObservableField;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.viewmodel.module.EditMakeupModule;
import us.pinguo.repository2020.entity.MaterialDetail;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.StyleMakeup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MakeupController.kt */
/* loaded from: classes4.dex */
public final class MakeupController$downStyleMakeup$1$1 extends Lambda implements kotlin.jvm.b.q<Boolean, MaterialDetail, String, kotlin.u> {
    final /* synthetic */ StyleMakeup $styleMakeup;
    final /* synthetic */ MakeupController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MakeupController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.MakeupController$downStyleMakeup$1$1$1", f = "MakeupController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.MakeupController$downStyleMakeup$1$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ boolean $isSuccess;
        final /* synthetic */ String $message;
        final /* synthetic */ StyleMakeup $styleMakeup;
        int label;
        final /* synthetic */ MakeupController this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MakeupController.kt */
        /* renamed from: us.pinguo.edit2020.controller.MakeupController$downStyleMakeup$1$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C03871 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
            final /* synthetic */ StyleMakeup $styleMakeup;
            final /* synthetic */ MakeupController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03871(MakeupController makeupController, StyleMakeup styleMakeup) {
                super(1);
                this.this$0 = makeupController;
                this.$styleMakeup = styleMakeup;
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.u.a;
            }

            public final void invoke(boolean z) {
                if (z) {
                    this.this$0.c0(this.$styleMakeup, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, MakeupController makeupController, StyleMakeup styleMakeup, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isSuccess = z;
            this.this$0 = makeupController;
            this.$styleMakeup = styleMakeup;
            this.$message = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isSuccess, this.this$0, this.$styleMakeup, this.$message, continuation);
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
                if (this.$isSuccess) {
                    if (kotlin.jvm.internal.s.c(this.this$0.a.u(), this.$styleMakeup)) {
                        EditMakeupModule editMakeupModule = this.this$0.a;
                        StyleMakeup styleMakeup = this.$styleMakeup;
                        editMakeupModule.c0(styleMakeup, new C03871(this.this$0, styleMakeup));
                    }
                } else {
                    if (this.$message.length() > 0) {
                        us.pinguo.foundation.utils.k0.a.b(this.$message);
                    }
                    ObservableField<MaterialInstallState> installState = this.$styleMakeup.getInstallState();
                    if (installState != null) {
                        installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                    }
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MakeupController$downStyleMakeup$1$1(MakeupController makeupController, StyleMakeup styleMakeup) {
        super(3);
        this.this$0 = makeupController;
        this.$styleMakeup = styleMakeup;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, MaterialDetail materialDetail, String str) {
        invoke(bool.booleanValue(), materialDetail, str);
        return kotlin.u.a;
    }

    public final void invoke(boolean z, MaterialDetail materialDetail, String message) {
        kotlin.jvm.internal.s.h(message, "message");
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.c()), null, null, new AnonymousClass1(z, this.this$0, this.$styleMakeup, message, null), 3, null);
    }
}
