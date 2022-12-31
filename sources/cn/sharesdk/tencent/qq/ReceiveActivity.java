package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
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
    private static PlatformActionListener listener;
    private static String uriScheme;

    public static void setPlatformActionListener(PlatformActionListener platformActionListener) {
        listener = platformActionListener;
    }

    public static void setUriScheme(String str) {
        uriScheme = str;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            String scheme = intent.getScheme();
            finish();
            if (scheme == null || !scheme.startsWith(uriScheme)) {
                return;
            }
            Bundle urlToBundle = ResHelper.urlToBundle(intent.getDataString());
            String valueOf = String.valueOf(urlToBundle.get("result"));
            String valueOf2 = String.valueOf(urlToBundle.get(AuthActivity.ACTION_KEY));
            if ("shareToQQ".equals(valueOf2) || "shareToQzone".equals(valueOf2)) {
                if (TJAdUnitConstants.String.VIDEO_COMPLETE.equals(valueOf)) {
                    if (listener != null) {
                        listener.onComplete(null, 9, new Hashon().fromJson(String.valueOf(urlToBundle.get("response"))));
                    }
                } else if ("error".equals(valueOf)) {
                    if (listener != null) {
                        listener.onError(null, 9, new Throwable(String.valueOf(urlToBundle.get("response"))));
                    }
                } else {
                    PlatformActionListener platformActionListener = listener;
                    if (platformActionListener != null) {
                        platformActionListener.onCancel(null, 9);
                    }
                }
            }
            if (Build.VERSION.SDK_INT <= 22) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setClass(this, MobUIShell.class);
                intent2.setFlags(335544320);
                startActivity(intent2);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            PlatformActionListener platformActionListener2 = listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(null, 9, th);
            }
        }
    }
}
