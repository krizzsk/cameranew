package us.pinguo.camera2020.activity;

import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.database.sticker.StickerManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Camera2020Activity.kt */
@DebugMetadata(c = "us.pinguo.camera2020.activity.Camera2020Activity$loadData$1", f = "Camera2020Activity.kt", i = {}, l = {ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class Camera2020Activity$loadData$1 extends SuspendLambda implements kotlin.jvm.b.p<m0, Continuation<? super kotlin.u>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Camera2020Activity$loadData$1(Continuation<? super Camera2020Activity$loadData$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new Camera2020Activity$loadData$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((Camera2020Activity$loadData$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            StickerManager stickerManager = StickerManager.a;
            this.label = 1;
            if (stickerManager.W(this) == coroutine_suspended) {
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
