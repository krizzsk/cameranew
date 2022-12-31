package us.pinguo.edit2020.controller;

import android.view.View;
import androidx.databinding.ObservableField;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.viewmodel.module.EditMakeupModule;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.SelfDefMakeup;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MakeupController.kt */
/* loaded from: classes4.dex */
public final class MakeupController$downSelfDefMakeup$1 extends Lambda implements kotlin.jvm.b.q<Boolean, SelfDefMakeupMaterial, String, kotlin.u> {
    final /* synthetic */ View $itemView;
    final /* synthetic */ SelfDefMakeup $selfDefMakeup;
    final /* synthetic */ MakeupController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MakeupController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.MakeupController$downSelfDefMakeup$1$1", f = "MakeupController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.MakeupController$downSelfDefMakeup$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ boolean $isSuccess;
        final /* synthetic */ View $itemView;
        final /* synthetic */ String $message;
        final /* synthetic */ SelfDefMakeup $selfDefMakeup;
        int label;
        final /* synthetic */ MakeupController this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MakeupController.kt */
        /* renamed from: us.pinguo.edit2020.controller.MakeupController$downSelfDefMakeup$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C03861 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
            final /* synthetic */ int $faceIndex;
            final /* synthetic */ View $itemView;
            final /* synthetic */ SelfDefMakeup $selfDefMakeup;
            final /* synthetic */ MakeupController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03861(MakeupController makeupController, int i2, View view, SelfDefMakeup selfDefMakeup) {
                super(1);
                this.this$0 = makeupController;
                this.$faceIndex = i2;
                this.$itemView = view;
                this.$selfDefMakeup = selfDefMakeup;
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.u.a;
            }

            public final void invoke(boolean z) {
                if (z) {
                    MakeupController makeupController = this.this$0;
                    makeupController.d0(makeupController.a.o(), this.$faceIndex, this.this$0.a.F(), this.$itemView, this.$selfDefMakeup);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, MakeupController makeupController, SelfDefMakeup selfDefMakeup, String str, View view, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isSuccess = z;
            this.this$0 = makeupController;
            this.$selfDefMakeup = selfDefMakeup;
            this.$message = str;
            this.$itemView = view;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isSuccess, this.this$0, this.$selfDefMakeup, this.$message, this.$itemView, continuation);
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
                    if (kotlin.jvm.internal.s.c(this.this$0.a.t(), this.$selfDefMakeup)) {
                        int C = this.this$0.a.C();
                        EditMakeupModule editMakeupModule = this.this$0.a;
                        SelfDefMakeup selfDefMakeup = this.$selfDefMakeup;
                        editMakeupModule.a0(C, selfDefMakeup, new C03861(this.this$0, C, this.$itemView, selfDefMakeup));
                    }
                } else {
                    if (this.$message.length() > 0) {
                        us.pinguo.foundation.utils.k0.a.b(this.$message);
                    }
                    ObservableField<MaterialInstallState> installState = this.$selfDefMakeup.getInstallState();
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
    public MakeupController$downSelfDefMakeup$1(MakeupController makeupController, SelfDefMakeup selfDefMakeup, View view) {
        super(3);
        this.this$0 = makeupController;
        this.$selfDefMakeup = selfDefMakeup;
        this.$itemView = view;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, SelfDefMakeupMaterial selfDefMakeupMaterial, String str) {
        invoke(bool.booleanValue(), selfDefMakeupMaterial, str);
        return kotlin.u.a;
    }

    public final void invoke(boolean z, SelfDefMakeupMaterial selfDefMakeupMaterial, String message) {
        kotlin.jvm.internal.s.h(message, "message");
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.c()), null, null, new AnonymousClass1(z, this.this$0, this.$selfDefMakeup, message, this.$itemView, null), 3, null);
    }
}
