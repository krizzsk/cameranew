package us.pinguo.share.d;

import android.content.Context;
import android.content.pm.PackageManager;
import cn.sharesdk.framework.ShareSDK;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import us.pinguo.share.core.ShareSite;
/* compiled from: ShareUtils.java */
/* loaded from: classes6.dex */
public final class a {
    public static boolean a(Context context, String str) {
        if (str == null || "".equals(str) || context.getPackageManager().getLaunchIntentForPackage(str) == null) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean b(Context context, ShareSite shareSite) {
        return a(context, shareSite.getPackageName());
    }

    public static void c(boolean z) {
        ShareSDK.setCloseGppService(z);
    }

    public static void d(boolean z, OperationCallback operationCallback) {
        MobSDK.submitPolicyGrantResult(z, operationCallback);
    }
}
