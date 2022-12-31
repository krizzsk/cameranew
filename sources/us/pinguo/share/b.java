package us.pinguo.share;

import android.app.Activity;
import us.pinguo.share.core.PGShareInfo;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.util.l;
/* compiled from: ShareManager.java */
/* loaded from: classes6.dex */
public class b {
    private static void a(Activity activity, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        new a().c(activity, str, str2, str3, str4, pGShareListener);
    }

    private static void b(Activity activity, String str, String str2, String str3, String str4, PGShareListener pGShareListener) {
        new a().d(activity, str, str2, str3, str4, pGShareListener);
    }

    private static void c(Activity activity, String str, PGShareListener pGShareListener) {
        new a().e(activity, str, pGShareListener);
    }

    public static void d(Activity activity, PGShareInfo pGShareInfo, PGShareListener pGShareListener) {
        if (pGShareInfo.hasVideo()) {
            b(activity, pGShareInfo.getVideoUri(), pGShareInfo.getTitle(), pGShareInfo.getThumbnailUri(), pGShareInfo.getText(), pGShareListener);
        } else if (pGShareInfo.hasImage()) {
            c(activity, pGShareInfo.getImageUri(), pGShareListener);
        } else {
            a(activity, pGShareInfo.getWebUrl(), pGShareInfo.getTitle(), pGShareInfo.getThumbnailUri(), pGShareInfo.getText(), pGShareListener);
        }
    }

    public static void e(Activity activity, l lVar, PGShareListener pGShareListener) {
        PGShareInfo a = lVar.a();
        if (a.hasVideo()) {
            b(activity, a.getVideoUri(), a.getTitle(), a.getThumbnailUri(), a.getText(), pGShareListener);
        } else if (a.hasImage()) {
            c(activity, a.getImageUri(), pGShareListener);
        } else {
            a(activity, a.getWebUrl(), a.getTitle(), a.getThumbnailUri(), a.getText(), pGShareListener);
        }
    }
}
