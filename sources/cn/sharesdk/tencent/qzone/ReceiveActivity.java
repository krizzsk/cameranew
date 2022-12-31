package cn.sharesdk.tencent.qzone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.MobUIShell;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class ReceiveActivity extends Activity {
    private static String a;
    private static PlatformActionListener b;

    public static void a(String str) {
        a = str;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            String scheme = intent.getScheme();
            if (scheme == null || !scheme.startsWith(a)) {
                return;
            }
            finish();
            Bundle urlToBundle = ResHelper.urlToBundle(intent.getDataString());
            String valueOf = String.valueOf(urlToBundle.get("result"));
            String valueOf2 = String.valueOf(urlToBundle.get(AuthActivity.ACTION_KEY));
            if ("shareToQQ".equals(valueOf2) || "shareToQzone".equals(valueOf2)) {
                if (TJAdUnitConstants.String.VIDEO_COMPLETE.equals(valueOf)) {
                    if (b != null) {
                        b.onComplete(null, 9, new Hashon().fromJson(String.valueOf(urlToBundle.get("response"))));
                    }
                } else if ("error".equals(valueOf)) {
                    if (b != null) {
                        b.onError(null, 9, new Throwable(String.valueOf(urlToBundle.get("response"))));
                    }
                } else {
                    PlatformActionListener platformActionListener = b;
                    if (platformActionListener != null) {
                        platformActionListener.onCancel(null, 9);
                    }
                }
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setClass(this, MobUIShell.class);
            intent2.setFlags(335544320);
            startActivity(intent2);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            PlatformActionListener platformActionListener2 = b;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(null, 9, th);
            }
        }
    }

    public static void a(PlatformActionListener platformActionListener) {
        b = platformActionListener;
    }
}
