package com.growingio.android.sdk.message;

import android.os.Handler;
import com.growingio.android.sdk.models.VPAEvent;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class MessageHandler {
    private static Set<MessageCallBack> callBacks = Collections.synchronizedSet(new HashSet());

    /* loaded from: classes2.dex */
    public interface MessageCallBack {
        void handleMessage(int i2, Object... objArr);
    }

    /* loaded from: classes2.dex */
    public static class TestMessageCallBack implements MessageCallBack {
        private Handler handler;

        public TestMessageCallBack(Handler handler) {
            this.handler = handler;
        }

        @Override // com.growingio.android.sdk.message.MessageHandler.MessageCallBack
        public void handleMessage(int i2, Object... objArr) {
            this.handler.obtainMessage(i2, objArr).sendToTarget();
        }
    }

    public static void addCallBack(MessageCallBack messageCallBack) {
        callBacks.add(messageCallBack);
    }

    public static void handleMessage(int i2, Object... objArr) {
        if (readyToSend()) {
            for (MessageCallBack messageCallBack : callBacks) {
                if (messageCallBack instanceof RealTimeMessageHolder) {
                    if (2097155 == i2 && objArr != null && objArr.length == 3) {
                        messageCallBack.handleMessage(i2, objArr);
                    }
                } else if (1048576 == i2 && objArr != null && objArr.length == 1) {
                    messageCallBack.handleMessage(i2, ((VPAEvent) objArr[0]).toJson());
                } else {
                    messageCallBack.handleMessage(i2, objArr);
                }
            }
        }
    }

    private static boolean isEmpty() {
        return callBacks.isEmpty();
    }

    public static boolean readyToSend() {
        return !isEmpty();
    }

    public static void addCallBack(RealTimeMessageCallBack realTimeMessageCallBack) {
        callBacks.add(new RealTimeMessageHolder(realTimeMessageCallBack));
    }
}
