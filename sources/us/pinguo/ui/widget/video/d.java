package us.pinguo.ui.widget.video;

import android.net.Uri;
import com.danikula.videocache.HttpProxyCacheServer;
import us.pinguo.util.v;
/* compiled from: VideoCache.java */
/* loaded from: classes6.dex */
public class d {
    private static boolean a = true;
    private static HttpProxyCacheServer b;
    private static final byte[] c = new byte[0];

    public static Uri a(Uri uri) {
        if (!a || uri == null || uri.getScheme() == null || !uri.getScheme().startsWith("http")) {
            return uri;
        }
        String uri2 = uri.toString();
        String j2 = b().j(uri2);
        us.pinguo.common.log.a.k("原Url:" + uri2 + " 代理Url:" + j2, new Object[0]);
        return Uri.parse(j2);
    }

    public static HttpProxyCacheServer b() {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new HttpProxyCacheServer(v.a());
                }
            }
        }
        return b;
    }
}
