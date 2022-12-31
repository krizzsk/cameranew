package us.pinguo.edit2020.viewmodel.module;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.database.staticsticker.StaticSticker;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerDetail;
import us.pinguo.repository2020.database.staticsticker.StaticStickerManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.StaticStickerModule$applySticker$2", f = "StaticStickerModule.kt", i = {}, l = {TypedValues.PositionType.TYPE_POSITION_TYPE, FrameMetricsAggregator.EVERY_DURATION}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StaticStickerModule$applySticker$2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ StaticStickerCategory $category;
    final /* synthetic */ boolean $history;
    final /* synthetic */ String $sid;
    final /* synthetic */ StaticSticker $sticker;
    int label;
    final /* synthetic */ StaticStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerModule.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.StaticStickerModule$applySticker$2$1", f = "StaticStickerModule.kt", i = {}, l = {512}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.viewmodel.module.StaticStickerModule$applySticker$2$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ StaticStickerCategory $category;
        final /* synthetic */ StaticStickerDetail $detail;
        final /* synthetic */ boolean $history;
        final /* synthetic */ StaticSticker $sticker;
        int label;
        final /* synthetic */ StaticStickerModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StaticStickerModule staticStickerModule, StaticStickerDetail staticStickerDetail, StaticStickerCategory staticStickerCategory, boolean z, StaticSticker staticSticker, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = staticStickerModule;
            this.$detail = staticStickerDetail;
            this.$category = staticStickerCategory;
            this.$history = z;
            this.$sticker = staticSticker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$detail, this.$category, this.$history, this.$sticker, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x006f A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.j.b(r13)
                goto L70
            Lf:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L17:
                kotlin.j.b(r13)
                us.pinguo.edit2020.viewmodel.module.StaticStickerModule r1 = r12.this$0
                us.pinguo.repository2020.database.staticsticker.StaticStickerDetail r13 = r12.$detail
                us.pinguo.repository2020.database.staticsticker.StaticStickerCategory r3 = r12.$category
                java.lang.Integer r3 = r3.getVip()
                r4 = 0
                if (r3 != 0) goto L28
                goto L2e
            L28:
                int r3 = r3.intValue()
                if (r3 == r2) goto L5b
            L2e:
                us.pinguo.edit2020.viewmodel.module.StaticStickerModule r3 = r12.this$0
                us.pinguo.repository2020.database.staticsticker.StaticStickerManager r3 = us.pinguo.edit2020.viewmodel.module.StaticStickerModule.b(r3)
                java.util.Map r3 = r3.y()
                us.pinguo.repository2020.database.staticsticker.StaticStickerDetail r5 = r12.$detail
                java.lang.String r5 = r5.getSid()
                java.lang.Object r3 = r3.get(r5)
                us.pinguo.repository2020.database.staticsticker.StaticSticker r3 = (us.pinguo.repository2020.database.staticsticker.StaticSticker) r3
                if (r3 != 0) goto L48
            L46:
                r3 = 0
                goto L56
            L48:
                java.lang.Integer r3 = r3.getVip()
                if (r3 != 0) goto L4f
                goto L46
            L4f:
                int r3 = r3.intValue()
                if (r3 != r2) goto L46
                r3 = 1
            L56:
                if (r3 == 0) goto L59
                goto L5b
            L59:
                r3 = 0
                goto L5c
            L5b:
                r3 = 1
            L5c:
                boolean r4 = r12.$history
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r10 = 64
                r11 = 0
                r12.label = r2
                r2 = r13
                r9 = r12
                java.lang.Object r13 = us.pinguo.edit2020.viewmodel.module.StaticStickerModule.n(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                if (r13 != r0) goto L70
                return r0
            L70:
                us.pinguo.edit2020.bean.q0 r13 = (us.pinguo.edit2020.bean.q0) r13
                if (r13 != 0) goto L75
                goto L9f
            L75:
                us.pinguo.edit2020.viewmodel.module.StaticStickerModule r0 = r12.this$0
                us.pinguo.repository2020.database.staticsticker.StaticSticker r1 = r12.$sticker
                us.pinguo.repository2020.database.staticsticker.StaticStickerManager r0 = us.pinguo.edit2020.viewmodel.module.StaticStickerModule.b(r0)
                r0.I(r1)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r13.f()
                r0.append(r1)
                r1 = 95
                r0.append(r1)
                java.lang.String r1 = r13.h()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                us.pinguo.u3dengine.edit.UnityEditCaller.StaticSticker.selectStaticStickerWithKey(r0)
            L9f:
                us.pinguo.edit2020.viewmodel.module.StaticStickerModule r0 = r12.this$0
                us.pinguo.edit2020.viewmodel.module.StaticStickerModule.d(r0, r13)
                kotlin.u r13 = kotlin.u.a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.StaticStickerModule$applySticker$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerModule$applySticker$2(StaticStickerModule staticStickerModule, String str, StaticStickerCategory staticStickerCategory, boolean z, StaticSticker staticSticker, Continuation<? super StaticStickerModule$applySticker$2> continuation) {
        super(2, continuation);
        this.this$0 = staticStickerModule;
        this.$sid = str;
        this.$category = staticStickerCategory;
        this.$history = z;
        this.$sticker = staticSticker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerModule$applySticker$2(this.this$0, this.$sid, this.$category, this.$history, this.$sticker, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerModule$applySticker$2) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        StaticStickerManager staticStickerManager;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            staticStickerManager = this.this$0.q;
            String str = this.$sid;
            this.label = 1;
            obj = staticStickerManager.p(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j.b(obj);
            return u.a;
        } else {
            j.b(obj);
        }
        StaticStickerDetail staticStickerDetail = (StaticStickerDetail) obj;
        if (staticStickerDetail == null) {
            return u.a;
        }
        g2 c = z0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, staticStickerDetail, this.$category, this.$history, this.$sticker, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return u.a;
    }
}
