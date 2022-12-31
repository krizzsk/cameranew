package us.pinguo.librouter.module.camera;

import android.app.Activity;
import android.content.Intent;
/* compiled from: IPayInterface.java */
/* loaded from: classes5.dex */
public interface f {

    /* compiled from: IPayInterface.java */
    /* loaded from: classes5.dex */
    public interface a {
        void payCancel();

        void payFail(String str);

        void paySuccess();
    }

    boolean a();

    void b(int i2, int i3, Intent intent);

    String c();

    void d(Activity activity);

    void e();

    void f(Activity activity, a aVar);
}
