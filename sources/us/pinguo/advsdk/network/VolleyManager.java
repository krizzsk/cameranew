package us.pinguo.advsdk.network;

import android.content.Context;
import com.android.pgvolley.RequestQueue;
import com.android.pgvolley.toolbox.ClearCacheRequest;
import com.android.pgvolley.toolbox.DiskBasedCache;
import com.android.pgvolley.toolbox.Volley;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class VolleyManager {
    private Context b;
    private RequestQueue a = null;
    private byte[] c = new byte[0];

    public VolleyManager(Context context) {
        this.b = null;
        this.b = context;
    }

    public RequestQueue a() {
        if (this.b == null) {
            us.pinguo.advsdk.utils.b.a("please init volley first!");
            return null;
        }
        if (this.a == null) {
            synchronized (this.c) {
                if (this.a == null) {
                    Context context = this.b;
                    if (context != null) {
                        this.a = Volley.newRequestQueue(context, new j.a.a.a.a.e());
                        this.a.add(new ClearCacheRequest(new DiskBasedCache(new File(this.b.getCacheDir(), "volley")), null));
                    } else {
                        throw new IllegalArgumentException("please call HttpRequestQueue.initInApp in application oncreate");
                    }
                }
            }
        }
        return this.a;
    }
}
