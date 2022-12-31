package us.pinguo.edit2020.controller;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.SelectRectAdjustView;
import us.pinguo.edit2020.view.SelectRectFunctionView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerController.kt */
/* loaded from: classes4.dex */
public final class StaticStickerController$initSelectRectView$4 extends Lambda implements kotlin.jvm.b.q<String, Boolean, Boolean, kotlin.u> {
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.StaticStickerController$initSelectRectView$4$1", f = "StaticStickerController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.StaticStickerController$initSelectRectView$4$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ boolean $canMoveDown;
        final /* synthetic */ boolean $canMoveUp;
        final /* synthetic */ String $key;
        int label;
        final /* synthetic */ StaticStickerController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, StaticStickerController staticStickerController, boolean z, boolean z2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$key = str;
            this.this$0 = staticStickerController;
            this.$canMoveUp = z;
            this.$canMoveDown = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$key, this.this$0, this.$canMoveUp, this.$canMoveDown, continuation);
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
                if (kotlin.jvm.internal.s.c(this.$key, ((SelectRectAdjustView) this.this$0.f10427e.findViewById(R.id.selectRectAdjustView)).F())) {
                    ((SelectRectFunctionView) this.this$0.f10427e.findViewById(R.id.selectRectFunctionView)).k(this.$canMoveUp, this.$canMoveDown);
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$initSelectRectView$4(StaticStickerController staticStickerController) {
        super(3);
        this.this$0 = staticStickerController;
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Boolean bool, Boolean bool2) {
        invoke(str, bool.booleanValue(), bool2.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(String key, boolean z, boolean z2) {
        LifecycleOwner lifecycleOwner;
        kotlin.jvm.internal.s.h(key, "key");
        lifecycleOwner = this.this$0.a;
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), kotlinx.coroutines.z0.c(), null, new AnonymousClass1(key, this.this$0, z, z2, null), 2, null);
    }
}
