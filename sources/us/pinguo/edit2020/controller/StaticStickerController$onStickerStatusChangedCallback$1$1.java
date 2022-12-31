package us.pinguo.edit2020.controller;

import android.graphics.PointF;
import android.view.ViewGroup;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.AdvanceStickerAdjustView;
import us.pinguo.edit2020.view.SelectRectAdjustView;
import us.pinguo.edit2020.view.SelectRectFunctionView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.StaticStickerController$onStickerStatusChangedCallback$1$1", f = "StaticStickerController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StaticStickerController$onStickerStatusChangedCallback$1$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ int $blendMode;
    final /* synthetic */ us.pinguo.edit2020.bean.u0 $it;
    final /* synthetic */ String $key;
    final /* synthetic */ float $normalizedCenterX;
    final /* synthetic */ float $normalizedCenterY;
    final /* synthetic */ float $normalizedSizeX;
    final /* synthetic */ float $normalizedSizeY;
    final /* synthetic */ float $opacity;
    final /* synthetic */ float $rotateAngle;
    final /* synthetic */ int $stickerStatus;
    int label;
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$onStickerStatusChangedCallback$1$1(StaticStickerController staticStickerController, int i2, float f2, int i3, String str, float f3, float f4, float f5, float f6, float f7, us.pinguo.edit2020.bean.u0 u0Var, Continuation<? super StaticStickerController$onStickerStatusChangedCallback$1$1> continuation) {
        super(2, continuation);
        this.this$0 = staticStickerController;
        this.$blendMode = i2;
        this.$opacity = f2;
        this.$stickerStatus = i3;
        this.$key = str;
        this.$rotateAngle = f3;
        this.$normalizedCenterX = f4;
        this.$normalizedCenterY = f5;
        this.$normalizedSizeX = f6;
        this.$normalizedSizeY = f7;
        this.$it = u0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerController$onStickerStatusChangedCallback$1$1(this.this$0, this.$blendMode, this.$opacity, this.$stickerStatus, this.$key, this.$rotateAngle, this.$normalizedCenterX, this.$normalizedCenterY, this.$normalizedSizeX, this.$normalizedSizeY, this.$it, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((StaticStickerController$onStickerStatusChangedCallback$1$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            if (this.this$0.f()) {
                this.this$0.b.E0(us.pinguo.edit2020.model.f.a.c.a(this.$blendMode), Boxing.boxFloat(this.$opacity), Boxing.boxBoolean(false), false);
                AdvanceStickerAdjustView advanceStickerAdjustView = this.this$0.m;
                if (advanceStickerAdjustView != null) {
                    advanceStickerAdjustView.i(Boxing.boxInt(this.$blendMode), Boxing.boxFloat(this.$opacity));
                }
                return kotlin.u.a;
            }
            if (this.$stickerStatus == 0) {
                this.this$0.b.g0(this.$key);
                ((SelectRectFunctionView) this.this$0.f10427e.findViewById(R.id.selectRectFunctionView)).i();
            }
            ViewGroup viewGroup = this.this$0.f10427e;
            int i2 = R.id.selectRectAdjustView;
            SelectRectAdjustView selectRectAdjustView = (SelectRectAdjustView) viewGroup.findViewById(i2);
            kotlin.jvm.internal.s.g(selectRectAdjustView, "fragmentLayout.selectRectAdjustView");
            String str = this.$key;
            float f2 = this.$rotateAngle;
            PointF pointF = new PointF(this.$normalizedCenterX, this.$normalizedCenterY);
            PointF pointF2 = new PointF(this.$normalizedSizeX, this.$normalizedSizeY);
            us.pinguo.edit2020.bean.u0 it = this.$it;
            kotlin.jvm.internal.s.g(it, "it");
            selectRectAdjustView.b0(str, f2, pointF, pointF2, it, (r17 & 32) != 0, this.$stickerStatus);
            this.this$0.b.q(((SelectRectAdjustView) this.this$0.f10427e.findViewById(i2)).F().length() == 0);
            if (this.$stickerStatus == 1) {
                this.this$0.b.h0();
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
