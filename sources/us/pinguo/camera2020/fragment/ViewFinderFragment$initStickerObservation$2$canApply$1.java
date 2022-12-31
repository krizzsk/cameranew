package us.pinguo.camera2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.v1;
import us.pinguo.camera2020.module.ExclusiveEffectType;
import us.pinguo.camera2020.module.sticker.CameraStickerModule;
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$initStickerObservation$2$canApply$1", f = "ViewFinderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class ViewFinderFragment$initStickerObservation$2$canApply$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super v1>, Object> {
    final /* synthetic */ ExclusiveEffectType $effectType;
    final /* synthetic */ Ref$BooleanRef $result;
    final /* synthetic */ CameraStickerModule $stickerModule;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewFinderFragment.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$initStickerObservation$2$canApply$1$1", f = "ViewFinderFragment.kt", i = {}, l = {2941}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.fragment.ViewFinderFragment$initStickerObservation$2$canApply$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ ExclusiveEffectType $effectType;
        final /* synthetic */ Ref$BooleanRef $result;
        final /* synthetic */ CameraStickerModule $stickerModule;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CameraStickerModule cameraStickerModule, ExclusiveEffectType exclusiveEffectType, Ref$BooleanRef ref$BooleanRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$stickerModule = cameraStickerModule;
            this.$effectType = exclusiveEffectType;
            this.$result = ref$BooleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$stickerModule, this.$effectType, this.$result, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L18
                if (r1 != r3) goto L10
                kotlin.j.b(r6)
                goto L41
            L10:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L18:
                kotlin.j.b(r6)
                us.pinguo.camera2020.module.sticker.CameraStickerModule r6 = r5.$stickerModule
                androidx.lifecycle.LiveData r6 = r6.u()
                java.lang.Object r6 = r6.getValue()
                us.pinguo.repository2020.database.sticker.Sticker r6 = (us.pinguo.repository2020.database.sticker.Sticker) r6
                if (r6 != 0) goto L2c
                kotlin.u r6 = kotlin.u.a
                return r6
            L2c:
                us.pinguo.camera2020.module.ExclusiveEffectType r1 = r5.$effectType
                us.pinguo.camera2020.module.ExclusiveEffectType r4 = us.pinguo.camera2020.module.ExclusiveEffectType.EFFECT_SHAPE
                if (r1 != r4) goto L4a
                us.pinguo.camera2020.module.sticker.CameraStickerModule r1 = r5.$stickerModule
                java.lang.String r6 = r6.getPid()
                r5.label = r3
                java.lang.Object r6 = r1.p(r6, r5)
                if (r6 != r0) goto L41
                return r0
            L41:
                if (r6 == 0) goto L4a
                kotlin.jvm.internal.Ref$BooleanRef r6 = r5.$result
                r6.element = r2
                kotlin.u r6 = kotlin.u.a
                return r6
            L4a:
                us.pinguo.camera2020.module.ExclusiveEffectType r6 = r5.$effectType
                us.pinguo.camera2020.module.ExclusiveEffectType r0 = us.pinguo.camera2020.module.ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP
                if (r6 != r0) goto L54
                kotlin.jvm.internal.Ref$BooleanRef r6 = r5.$result
                r6.element = r2
            L54:
                kotlin.u r6 = kotlin.u.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment$initStickerObservation$2$canApply$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$initStickerObservation$2$canApply$1(CameraStickerModule cameraStickerModule, ExclusiveEffectType exclusiveEffectType, Ref$BooleanRef ref$BooleanRef, Continuation<? super ViewFinderFragment$initStickerObservation$2$canApply$1> continuation) {
        super(2, continuation);
        this.$stickerModule = cameraStickerModule;
        this.$effectType = exclusiveEffectType;
        this.$result = ref$BooleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        ViewFinderFragment$initStickerObservation$2$canApply$1 viewFinderFragment$initStickerObservation$2$canApply$1 = new ViewFinderFragment$initStickerObservation$2$canApply$1(this.$stickerModule, this.$effectType, this.$result, continuation);
        viewFinderFragment$initStickerObservation$2$canApply$1.L$0 = obj;
        return viewFinderFragment$initStickerObservation$2$canApply$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super v1> continuation) {
        return ((ViewFinderFragment$initStickerObservation$2$canApply$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        v1 d2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            d2 = kotlinx.coroutines.l.d((kotlinx.coroutines.m0) this.L$0, null, null, new AnonymousClass1(this.$stickerModule, this.$effectType, this.$result, null), 3, null);
            return d2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
