package us.pinguo.inspire.data;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
/* compiled from: VideoSeekManager.java */
/* loaded from: classes9.dex */
public class a {
    private static List<Uri> a = new ArrayList();

    public static boolean a(Uri uri) {
        if (a.contains(uri)) {
            us.pinguo.common.log.a.m("zhouwei", "repeat seek......", new Object[0]);
            return true;
        }
        us.pinguo.common.log.a.m("zhouwei", "no repeat seek......", new Object[0]);
        a.add(uri);
        return false;
    }
}
