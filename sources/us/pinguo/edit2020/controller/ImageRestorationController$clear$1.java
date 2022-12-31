package us.pinguo.edit2020.controller;

import com.growingio.android.sdk.monitor.BuildConfig;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.util.FileUtils;
/* compiled from: ImageRestorationController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.ImageRestorationController$clear$1", f = "ImageRestorationController.kt", i = {}, l = {IjkMediaMeta.FF_PROFILE_H264_HIGH_444, BuildConfig.VERSION_CODE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class ImageRestorationController$clear$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageRestorationController$clear$1(Continuation<? super ImageRestorationController$clear$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ImageRestorationController$clear$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ImageRestorationController$clear$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            String b = us.pinguo.common.helper.b.c.b();
            this.label = 1;
            if (FileUtils.l(b, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
            return kotlin.u.a;
        } else {
            kotlin.j.b(obj);
        }
        String a = us.pinguo.common.helper.b.c.a();
        this.label = 2;
        if (FileUtils.l(a, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}
