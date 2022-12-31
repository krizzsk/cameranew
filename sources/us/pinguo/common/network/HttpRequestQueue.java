package us.pinguo.common.network;

import android.app.Application;
import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.Volley;
@Deprecated
/* loaded from: classes4.dex */
public class HttpRequestQueue {
    private static Application application = null;
    protected static boolean isCheckMainThreadTime = false;
    private static byte[] lock = new byte[0];
    private static RequestQueue mRequestQueue;

    public static RequestQueue getInstance() {
        if (mRequestQueue == null) {
            synchronized (lock) {
                if (mRequestQueue == null) {
                    Application application2 = application;
                    if (application2 != null) {
                        mRequestQueue = Volley.newRequestQueue((Context) application2, (BaseHttpStack) new TrustAllCertsHurlStack());
                    } else {
                        throw new IllegalArgumentException("please call HttpRequestQueue.initInApp in application oncreate");
                    }
                }
            }
        }
        return mRequestQueue;
    }

    public static void initInApp(Application application2, boolean z) {
        application = application2;
        isCheckMainThreadTime = z;
    }
}
