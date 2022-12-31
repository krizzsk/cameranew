package us.pinguo.repository2020.manager;

import androidx.databinding.ObservableField;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.entity.MaterialDetail;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.entity.StyleMakeupDetail;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyDataManager.kt */
/* loaded from: classes6.dex */
public final class BeautyDataManager$downloadAndInstallStyleMakeup$1$1$1 extends Lambda implements p<Boolean, StyleMakeupDetail, u> {
    final /* synthetic */ q<Boolean, MaterialDetail, String, u> $downloadAction;
    final /* synthetic */ StyleMakeupDetail $it;
    final /* synthetic */ String $message;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BeautyDataManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyDataManager$downloadAndInstallStyleMakeup$1$1$1$1", f = "BeautyDataManager.kt", i = {}, l = {347}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.manager.BeautyDataManager$downloadAndInstallStyleMakeup$1$1$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ q<Boolean, MaterialDetail, String, u> $downloadAction;
        final /* synthetic */ StyleMakeupDetail $materialDetail;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BeautyDataManager.kt */
        /* renamed from: us.pinguo.repository2020.manager.BeautyDataManager$downloadAndInstallStyleMakeup$1$1$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C04411 extends Lambda implements q<Boolean, MaterialDetail, String, u> {
            final /* synthetic */ q<Boolean, MaterialDetail, String, u> $downloadAction;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C04411(q<? super Boolean, ? super MaterialDetail, ? super String, u> qVar) {
                super(3);
                this.$downloadAction = qVar;
            }

            @Override // kotlin.jvm.b.q
            public /* bridge */ /* synthetic */ u invoke(Boolean bool, MaterialDetail materialDetail, String str) {
                invoke(bool.booleanValue(), materialDetail, str);
                return u.a;
            }

            public final void invoke(boolean z, MaterialDetail materialDetail, String message) {
                ObservableField<MaterialInstallState> installState;
                ObservableField<MaterialInstallState> installState2;
                s.h(materialDetail, "materialDetail");
                s.h(message, "message");
                if (z) {
                    StyleMakeup styleMakeup = BeautyDataManager.a.q().get(materialDetail.getPid());
                    if (styleMakeup != null && (installState2 = styleMakeup.getInstallState()) != null) {
                        installState2.set(MaterialInstallState.STATE_INSTALLED);
                    }
                } else {
                    StyleMakeup styleMakeup2 = BeautyDataManager.a.q().get(materialDetail.getPid());
                    if (styleMakeup2 != null && (installState = styleMakeup2.getInstallState()) != null) {
                        installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
                    }
                }
                this.$downloadAction.invoke(Boolean.valueOf(z), materialDetail, message);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(StyleMakeupDetail styleMakeupDetail, q<? super Boolean, ? super MaterialDetail, ? super String, u> qVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$materialDetail = styleMakeupDetail;
            this.$downloadAction = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$materialDetail, this.$downloadAction, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                BeautyInstallManager beautyInstallManager = BeautyInstallManager.a;
                StyleMakeupDetail styleMakeupDetail = this.$materialDetail;
                C04411 c04411 = new C04411(this.$downloadAction);
                this.label = 1;
                if (beautyInstallManager.c(styleMakeupDetail, c04411, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            return u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BeautyDataManager$downloadAndInstallStyleMakeup$1$1$1(q<? super Boolean, ? super MaterialDetail, ? super String, u> qVar, StyleMakeupDetail styleMakeupDetail, String str) {
        super(2);
        this.$downloadAction = qVar;
        this.$it = styleMakeupDetail;
        this.$message = str;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Boolean bool, StyleMakeupDetail styleMakeupDetail) {
        invoke(bool.booleanValue(), styleMakeupDetail);
        return u.a;
    }

    public final void invoke(boolean z, StyleMakeupDetail materialDetail) {
        ObservableField<MaterialInstallState> installState;
        s.h(materialDetail, "materialDetail");
        if (z) {
            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new AnonymousClass1(materialDetail, this.$downloadAction, null), 3, null);
            return;
        }
        StyleMakeup styleMakeup = BeautyDataManager.a.q().get(materialDetail.getPid());
        if (styleMakeup != null && (installState = styleMakeup.getInstallState()) != null) {
            installState.set(MaterialInstallState.STATE_UNDOWNLOAD);
        }
        this.$downloadAction.invoke(Boolean.valueOf(z), this.$it, this.$message);
    }
}
