package cn.sharesdk.framework.loopshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.loopshare.MobLink;
import cn.sharesdk.loopshare.Scene;
import cn.sharesdk.loopshare.SceneRestorable;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* loaded from: classes.dex */
public class RestoreTempActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        SSDKLog.b().w("[LoopShare] RestoreTempActivity onCreate");
        super.onCreate(bundle);
        try {
            MobLink.setActivityDelegate(this, new SceneRestorable() { // from class: cn.sharesdk.framework.loopshare.RestoreTempActivity.1
                public void onReturnSceneData(Scene scene) {
                    if (scene != null) {
                        String path = scene.getPath();
                        HashMap params = scene.getParams();
                        String str = (String) params.get("targetAction_And");
                        params.remove("targetAction_And");
                        params.remove("targetAction_iOS");
                        try {
                            params.put(PGEditResultActivity2.PATH, path);
                            String fromHashMap = new Hashon().fromHashMap(params);
                            if (!TextUtils.isEmpty(fromHashMap)) {
                                new a(MobSDK.getContext(), "sharesdk_moblink_sp").a("share_restore_extra", fromHashMap);
                                NLog b = SSDKLog.b();
                                b.d("LoopShare RestoreTempActivity save json is okd " + fromHashMap, new Object[0]);
                            }
                            if (MobLinkAPI.b() != null) {
                                MobLinkAPI.b().onResult(params);
                                SSDKLog.b().d("LoopShare RestoreTempActivity onResult is OK", new Object[0]);
                            }
                            RestoreTempActivity.this.finish();
                        } catch (Throwable th) {
                            NLog b2 = SSDKLog.b();
                            b2.d("LoopShare RestoreTempActivity onReturnSceneData catch " + th, new Object[0]);
                            if (MobLinkAPI.b() != null) {
                                MobLinkAPI.b().onError(th);
                            }
                            RestoreTempActivity.this.finish();
                        }
                    }
                }
            });
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("LoopShare RestoreTempActivity onCreate catch " + th, new Object[0]);
            finish();
        }
    }

    @Override // android.app.Activity
    @Instrumented
    protected void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        SSDKLog.b().w("[LoopShare] RestoreTempActivity onNewIntent");
        super.onNewIntent(intent);
        try {
            MobLink.updateNewIntent(intent, this);
            SSDKLog.b().d("LoopShare RestoreTempActivity onNewIntent ", new Object[0]);
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("LoopShare RestoreTempActivity onNewIntent catch " + th, new Object[0]);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        SSDKLog.b().w("[LoopShare] RestoreTempActivity onResume");
        super.onResume();
        finish();
    }
}
