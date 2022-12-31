package cn.sharesdk.framework;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ReflectablePlatformActionListener implements PlatformActionListener {
    private int a;
    private Handler.Callback b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private Handler.Callback f67d;

    /* renamed from: e  reason: collision with root package name */
    private int f68e;

    /* renamed from: f  reason: collision with root package name */
    private Handler.Callback f69f;

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i2) {
        if (this.f69f != null) {
            Message message = new Message();
            message.what = this.f68e;
            message.obj = new Object[]{platform, Integer.valueOf(i2)};
            UIHandler.sendMessage(message, this.f69f);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i2, HashMap<String, Object> hashMap) {
        if (this.b != null) {
            Message message = new Message();
            message.what = this.a;
            message.obj = new Object[]{platform, Integer.valueOf(i2), hashMap};
            UIHandler.sendMessage(message, this.b);
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i2, Throwable th) {
        if (this.f67d != null) {
            Message message = new Message();
            message.what = this.c;
            message.obj = new Object[]{platform, Integer.valueOf(i2), th};
            UIHandler.sendMessage(message, this.f67d);
        }
    }

    public void setOnCancelCallback(int i2, Handler.Callback callback) {
        this.f68e = i2;
        this.f69f = callback;
    }

    public void setOnCompleteCallback(int i2, Handler.Callback callback) {
        this.a = i2;
        this.b = callback;
    }

    public void setOnErrorCallback(int i2, Handler.Callback callback) {
        this.c = i2;
        this.f67d = callback;
    }
}
