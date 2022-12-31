package us.pinguo.edit2020.viewmodel.module;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBackgroundBlurModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.EditBackgroundBlurModule", f = "EditBackgroundBlurModule.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2}, l = {601, TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 615}, m = "addOrRefreshCustomizedLens", n = {"this", "bitmap", "customizeBlurPath", "this", "bitmap", "customizeBlurPath", "this", "bitmap", "customizeBlurPath", "iconPath", "iconFile"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes4.dex */
public final class EditBackgroundBlurModule$addOrRefreshCustomizedLens$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditBackgroundBlurModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBackgroundBlurModule$addOrRefreshCustomizedLens$1(EditBackgroundBlurModule editBackgroundBlurModule, Continuation<? super EditBackgroundBlurModule$addOrRefreshCustomizedLens$1> continuation) {
        super(continuation);
        this.this$0 = editBackgroundBlurModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, this);
    }
}
