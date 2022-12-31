package us.pinguo.camera360.module;

import android.os.MessageQueue;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements MessageQueue.IdleHandler {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        return CameraModule.a();
    }
}
