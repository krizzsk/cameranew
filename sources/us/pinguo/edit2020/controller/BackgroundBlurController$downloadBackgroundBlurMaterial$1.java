package us.pinguo.edit2020.controller;

import androidx.databinding.ObservableField;
import com.growingio.android.sdk.java_websocket.WebSocket;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.repository2020.entity.BackgroundBlurMaterial;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.manager.BackgroundBlurDataManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurController.kt */
/* loaded from: classes4.dex */
public final class BackgroundBlurController$downloadBackgroundBlurMaterial$1 extends Lambda implements kotlin.jvm.b.p<Boolean, BackgroundBlurMaterial, kotlin.u> {
    final /* synthetic */ BackgroundBlurController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundBlurController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.BackgroundBlurController$downloadBackgroundBlurMaterial$1$1", f = "BackgroundBlurController.kt", i = {}, l = {WebSocket.DEFAULT_WSS_PORT}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.BackgroundBlurController$downloadBackgroundBlurMaterial$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ BackgroundBlurMaterial $downloadBlurMaterial;
        int label;
        final /* synthetic */ BackgroundBlurController this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BackgroundBlurController.kt */
        /* renamed from: us.pinguo.edit2020.controller.BackgroundBlurController$downloadBackgroundBlurMaterial$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C03821 extends Lambda implements kotlin.jvm.b.p<Boolean, BackgroundBlurMaterial, kotlin.u> {
            final /* synthetic */ BackgroundBlurController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03821(BackgroundBlurController backgroundBlurController) {
                super(2);
                this.this$0 = backgroundBlurController;
            }

            @Override // kotlin.jvm.b.p
            public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, BackgroundBlurMaterial backgroundBlurMaterial) {
                invoke(bool.booleanValue(), backgroundBlurMaterial);
                return kotlin.u.a;
            }

            public final void invoke(boolean z, BackgroundBlurMaterial installBlurMaterial) {
                kotlin.jvm.internal.s.h(installBlurMaterial, "installBlurMaterial");
                if (z) {
                    ObservableField<MaterialInstallState> installState = installBlurMaterial.getInstallState();
                    if (installState != null) {
                        installState.set(MaterialInstallState.STATE_INSTALLED);
                    }
                    this.this$0.X(installBlurMaterial);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BackgroundBlurMaterial backgroundBlurMaterial, BackgroundBlurController backgroundBlurController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$downloadBlurMaterial = backgroundBlurMaterial;
            this.this$0 = backgroundBlurController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$downloadBlurMaterial, this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                BackgroundBlurDataManager backgroundBlurDataManager = BackgroundBlurDataManager.a;
                BackgroundBlurMaterial backgroundBlurMaterial = this.$downloadBlurMaterial;
                C03821 c03821 = new C03821(this.this$0);
                this.label = 1;
                if (backgroundBlurDataManager.o(backgroundBlurMaterial, c03821, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurController$downloadBackgroundBlurMaterial$1(BackgroundBlurController backgroundBlurController) {
        super(2);
        this.this$0 = backgroundBlurController;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, BackgroundBlurMaterial backgroundBlurMaterial) {
        invoke(bool.booleanValue(), backgroundBlurMaterial);
        return kotlin.u.a;
    }

    public final void invoke(boolean z, BackgroundBlurMaterial downloadBlurMaterial) {
        kotlin.jvm.internal.s.h(downloadBlurMaterial, "downloadBlurMaterial");
        if (z) {
            kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new AnonymousClass1(downloadBlurMaterial, this.this$0, null), 3, null);
            return;
        }
        ObservableField<MaterialInstallState> installState = downloadBlurMaterial.getInstallState();
        if (installState == null) {
            return;
        }
        installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
    }
}
