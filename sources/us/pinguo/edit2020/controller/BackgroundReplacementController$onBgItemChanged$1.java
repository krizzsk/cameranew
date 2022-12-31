package us.pinguo.edit2020.controller;

import android.graphics.Bitmap;
import android.graphics.PointF;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.view.ManualMattingView;
import us.pinguo.edit2020.view.SelectRectAdjustView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.BackgroundReplacementController$onBgItemChanged$1", f = "BackgroundReplacementController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class BackgroundReplacementController$onBgItemChanged$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ float $normalizedCenterX;
    final /* synthetic */ float $normalizedCenterY;
    final /* synthetic */ float $normalizedSizeX;
    final /* synthetic */ float $normalizedSizeY;
    final /* synthetic */ float $rotateAngle;
    final /* synthetic */ int $stickerStatus;
    int label;
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$onBgItemChanged$1(BackgroundReplacementController backgroundReplacementController, String str, int i2, float f2, float f3, float f4, float f5, float f6, Continuation<? super BackgroundReplacementController$onBgItemChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = backgroundReplacementController;
        this.$key = str;
        this.$stickerStatus = i2;
        this.$rotateAngle = f2;
        this.$normalizedCenterX = f3;
        this.$normalizedCenterY = f4;
        this.$normalizedSizeX = f5;
        this.$normalizedSizeY = f6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundReplacementController$onBgItemChanged$1(this.this$0, this.$key, this.$stickerStatus, this.$rotateAngle, this.$normalizedCenterX, this.$normalizedCenterY, this.$normalizedSizeX, this.$normalizedSizeY, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((BackgroundReplacementController$onBgItemChanged$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Boolean bool;
        ManualMattingView manualMattingView;
        Bitmap bitmapDelete;
        Bitmap bitmapJingxiang;
        Bitmap bitmapAdd;
        Bitmap bitmapXuanzhuan;
        Bitmap bitmapTihuan;
        Bitmap bitmapJingxiang2;
        Bitmap bitmapKoutu;
        Bitmap bitmapXuanzhuan2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            if (!this.this$0.f10290k) {
                if (!kotlin.jvm.internal.s.c(this.this$0.f10287h.F(), this.$key)) {
                    if ((this.$key.length() > 0) && this.$stickerStatus == 0) {
                        this.this$0.c.c();
                    }
                }
                us.pinguo.edit2020.bean.u0 value = this.this$0.c.O().getValue();
                if (value != null) {
                    String str = this.$key;
                    BackgroundReplacementController backgroundReplacementController = this.this$0;
                    float f2 = this.$rotateAngle;
                    float f3 = this.$normalizedCenterX;
                    float f4 = this.$normalizedCenterY;
                    float f5 = this.$normalizedSizeX;
                    float f6 = this.$normalizedSizeY;
                    int i2 = this.$stickerStatus;
                    if (kotlin.jvm.internal.s.c(str, "photoItem")) {
                        SelectRectAdjustView selectRectAdjustView = backgroundReplacementController.f10287h;
                        bitmapTihuan = backgroundReplacementController.v;
                        kotlin.jvm.internal.s.g(bitmapTihuan, "bitmapTihuan");
                        bitmapJingxiang2 = backgroundReplacementController.x;
                        kotlin.jvm.internal.s.g(bitmapJingxiang2, "bitmapJingxiang");
                        bitmapKoutu = backgroundReplacementController.w;
                        kotlin.jvm.internal.s.g(bitmapKoutu, "bitmapKoutu");
                        bitmapXuanzhuan2 = backgroundReplacementController.y;
                        kotlin.jvm.internal.s.g(bitmapXuanzhuan2, "bitmapXuanzhuan");
                        selectRectAdjustView.Q(bitmapTihuan, bitmapJingxiang2, bitmapKoutu, bitmapXuanzhuan2);
                    } else {
                        if (str.length() > 0) {
                            SelectRectAdjustView selectRectAdjustView2 = backgroundReplacementController.f10287h;
                            bitmapDelete = backgroundReplacementController.A;
                            kotlin.jvm.internal.s.g(bitmapDelete, "bitmapDelete");
                            bitmapJingxiang = backgroundReplacementController.x;
                            kotlin.jvm.internal.s.g(bitmapJingxiang, "bitmapJingxiang");
                            bitmapAdd = backgroundReplacementController.z;
                            kotlin.jvm.internal.s.g(bitmapAdd, "bitmapAdd");
                            bitmapXuanzhuan = backgroundReplacementController.y;
                            kotlin.jvm.internal.s.g(bitmapXuanzhuan, "bitmapXuanzhuan");
                            selectRectAdjustView2.Q(bitmapDelete, bitmapJingxiang, bitmapAdd, bitmapXuanzhuan);
                        }
                    }
                    backgroundReplacementController.f10287h.b0(str, f2, new PointF(f3, f4), new PointF(f5, f6), value, (r17 & 32) != 0, i2);
                    backgroundReplacementController.c.B(backgroundReplacementController.f10287h.F().length() == 0);
                }
            } else {
                Boolean boxBoolean = Boxing.boxBoolean(true);
                bool = this.this$0.q;
                if (kotlin.jvm.internal.s.c(boxBoolean, bool) && this.$stickerStatus == 0 && kotlin.jvm.internal.s.c(this.$key, "photoItem") && (manualMattingView = this.this$0.s) != null) {
                    BackgroundReplacementController backgroundReplacementController2 = this.this$0;
                    us.pinguo.edit2020.bean.c0 n = manualMattingView.n();
                    if (n != null) {
                        backgroundReplacementController2.r = Boxing.boxBoolean(true);
                        backgroundReplacementController2.O0(n);
                    }
                }
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
