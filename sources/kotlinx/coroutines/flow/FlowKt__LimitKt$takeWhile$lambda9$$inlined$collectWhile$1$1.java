package kotlinx.coroutines.flow;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.monitor.BuildConfig;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1", f = "Limit.kt", i = {0, 0, 1}, l = {IjkMediaMeta.FF_PROFILE_H264_HIGH_444, BuildConfig.VERSION_CODE}, m = "emit", n = {"this", FirebaseAnalytics.Param.VALUE, "this"}, s = {"L$0", "L$1", "L$0"})
/* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1$1  reason: invalid class name */
/* loaded from: classes3.dex */
public final class FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d0 this$0;

    public FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1$1(d0 d0Var, Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
