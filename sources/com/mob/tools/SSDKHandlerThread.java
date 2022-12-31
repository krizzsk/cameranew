package com.mob.tools;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public abstract class SSDKHandlerThread implements Handler.Callback {
    private static final int MSG_START = -1;
    private static final int MSG_STOP = -2;
    protected final Handler handler = MobHandlerThread.newHandler("s", this);

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == -2) {
            onStop(message);
            return false;
        } else if (i2 != -1) {
            onMessage(message);
            return false;
        } else {
            onStart(message);
            return false;
        }
    }

    protected abstract void onMessage(Message message);

    protected void onStart(Message message) {
    }

    protected void onStop(Message message) {
    }

    public void startThread() {
        startThread(0, 0, null);
    }

    public void stopThread() {
        stopThread(0, 0, null);
    }

    public void startThread(int i2, int i3, Object obj) {
        Message message = new Message();
        message.what = -1;
        message.arg1 = i2;
        message.arg2 = i3;
        message.obj = obj;
        this.handler.sendMessage(message);
    }

    public void stopThread(int i2, int i3, Object obj) {
        Message message = new Message();
        message.what = -2;
        message.arg1 = i2;
        message.arg2 = i3;
        message.obj = obj;
        this.handler.sendMessage(message);
    }
}
