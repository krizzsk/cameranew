package us.pinguo.foundation.base;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ActivityRecorder {
    private List<WeakReference<Activity>> a;

    /* loaded from: classes4.dex */
    private static class b {
        private static ActivityRecorder a = new ActivityRecorder();
    }

    public static ActivityRecorder getInstance() {
        return b.a;
    }

    public void a(Activity activity) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(new WeakReference<>(activity));
    }

    public int b() {
        List<WeakReference<Activity>> list = this.a;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        return this.a.size();
    }

    public Activity c() {
        List<WeakReference<Activity>> list = this.a;
        if (list == null || list.size() <= 1) {
            return null;
        }
        List<WeakReference<Activity>> list2 = this.a;
        return list2.get(list2.size() - 2).get();
    }

    public Activity d() {
        List<WeakReference<Activity>> list = this.a;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<WeakReference<Activity>> list2 = this.a;
        return list2.get(list2.size() - 1).get();
    }

    public void e(Activity activity) {
        List<WeakReference<Activity>> list = this.a;
        if (list != null) {
            for (WeakReference<Activity> weakReference : list) {
                if (weakReference.get() != null && weakReference.get() == activity) {
                    this.a.remove(weakReference);
                    return;
                }
            }
        }
    }

    private ActivityRecorder() {
        this.a = new ArrayList();
    }
}
