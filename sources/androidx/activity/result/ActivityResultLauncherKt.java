package androidx.activity.result;

import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: ActivityResultLauncher.kt */
/* loaded from: classes.dex */
public final class ActivityResultLauncherKt {
    public static final void launch(ActivityResultLauncher<Void> launch, ActivityOptionsCompat activityOptionsCompat) {
        s.h(launch, "$this$launch");
        launch.launch(null, activityOptionsCompat);
    }

    public static /* synthetic */ void launch$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            activityOptionsCompat = null;
        }
        launch(activityResultLauncher, activityOptionsCompat);
    }

    public static final void launchUnit(ActivityResultLauncher<u> launch, ActivityOptionsCompat activityOptionsCompat) {
        s.h(launch, "$this$launch");
        launch.launch(u.a, activityOptionsCompat);
    }

    public static /* synthetic */ void launchUnit$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            activityOptionsCompat = null;
        }
        launchUnit(activityResultLauncher, activityOptionsCompat);
    }
}
