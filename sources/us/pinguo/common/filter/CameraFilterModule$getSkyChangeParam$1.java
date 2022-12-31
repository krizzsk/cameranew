package us.pinguo.common.filter;

import com.growingio.android.sdk.java_websocket.WebSocket;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraFilterModule.kt */
@DebugMetadata(c = "us.pinguo.common.filter.CameraFilterModule", f = "CameraFilterModule.kt", i = {0, 1, 1, 2, 2, 2, 2, 2}, l = {442, WebSocket.DEFAULT_WSS_PORT, 450}, m = "getSkyChangeParam", n = {"itemId", "itemId", "filterPackagePath", "itemId", "filterPackagePath", "defaultOpacity", "defaultColor", "defaultSkyTemperature"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes4.dex */
public final class CameraFilterModule$getSkyChangeParam$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CameraFilterModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraFilterModule$getSkyChangeParam$1(CameraFilterModule cameraFilterModule, Continuation<? super CameraFilterModule$getSkyChangeParam$1> continuation) {
        super(continuation);
        this.this$0 = cameraFilterModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object F;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        F = this.this$0.F(null, null, this);
        return F;
    }
}
