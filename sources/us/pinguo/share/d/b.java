package us.pinguo.share.d;

import com.growingio.android.sdk.collection.Constants;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: UriUtils.java */
/* loaded from: classes6.dex */
public class b {
    public static String a(String str) {
        if (str != null) {
            return str.startsWith(InspirePublishFragment.FILE_HEADER) ? str.substring(7, str.length()) : str;
        }
        return null;
    }

    public static boolean b(String str) {
        return str.startsWith(Constants.HTTP_PROTOCOL_PREFIX) || str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX);
    }
}
