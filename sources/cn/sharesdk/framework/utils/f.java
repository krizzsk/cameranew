package cn.sharesdk.framework.utils;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;
/* compiled from: SSDKHandlerThread.java */
/* loaded from: classes.dex */
public abstract class f implements Handler.Callback {
    protected final Handler a = MobHandlerThread.newHandler(this);

    public void a(int i2, int i3, Object obj) {
        Message message = new Message();
        message.what = -1;
        message.arg1 = i2;
        message.arg2 = i3;
        message.obj = obj;
        this.a.sendMessage(message);
    }

    protected void a(Message message) {
    }

    protected abstract void b(Message message);

    protected void c(Message message) {
    }

    public void e() {
        a(0, 0, null);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == -2) {
            c(message);
            return false;
        } else if (i2 != -1) {
            b(message);
            return false;
        } else {
            a(message);
            return false;
        }
    }
}
