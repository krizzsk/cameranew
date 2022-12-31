package us.pinguo.inspire.router;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.inspire.w;
/* compiled from: PermissionCheckCall.java */
/* loaded from: classes9.dex */
public class b implements Application.ActivityLifecycleCallbacks {
    private static final Map<String, String[]> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("PGEditActivity", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        hashMap.put("PGEditResultActivity2", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        hashMap.put("TemplateEditActivity", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        hashMap.put("OptionsException", new String[]{"android.permission.CAMERA"});
        hashMap.put("CameraAdjustActivity", new String[]{"android.permission.CAMERA"});
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        String[] strArr = a.get(activity.getClass().getSimpleName());
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        for (String str : strArr) {
            if (!(ContextCompat.checkSelfPermission(activity, str) == 0)) {
                w.a(activity, strArr);
                return;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
