package us.pinguo.advconfigdata.service;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
/* loaded from: classes3.dex */
public class KeepLiveActivity extends Activity {
    public static KeepLiveActivity a;

    public static void a() {
        KeepLiveActivity keepLiveActivity = a;
        if (keepLiveActivity == null || keepLiveActivity.isFinishing()) {
            return;
        }
        a.finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
        a = this;
    }
}
