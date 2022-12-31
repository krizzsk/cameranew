package us.pinguo.inspire;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
/* compiled from: PermissionBufferLauncher.kt */
/* loaded from: classes4.dex */
public final class w {
    public static final w a = new w();

    private w() {
    }

    public static final void a(Activity activity, String... permissions) {
        kotlin.jvm.internal.s.h(activity, "activity");
        kotlin.jvm.internal.s.h(permissions, "permissions");
        Intent intent = new Intent();
        intent.setClassName(activity.getPackageName(), "us.pinguo.inspire.PermissionBufferActivity");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        int length = permissions.length;
        int i2 = 0;
        while (i2 < length) {
            String str = permissions[i2];
            i2++;
            arrayList.add(new PermissionInfo(str, true));
        }
        intent.putParcelableArrayListExtra(FirebaseAnalytics.Param.VALUE, arrayList);
        activity.startActivity(intent);
    }

    public static final void b(Activity activity, String... permissions) {
        kotlin.jvm.internal.s.h(activity, "activity");
        kotlin.jvm.internal.s.h(permissions, "permissions");
        Intent intent = new Intent();
        intent.setClassName(activity.getPackageName(), "us.pinguo.inspire.PermissionBufferActivity");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        int length = permissions.length;
        int i2 = 0;
        while (i2 < length) {
            String str = permissions[i2];
            i2++;
            arrayList.add(new PermissionInfo(str, true));
        }
        intent.putParcelableArrayListExtra(FirebaseAnalytics.Param.VALUE, arrayList);
        intent.putExtra("finishSelf", true);
        activity.startActivityForResult(intent, 6928);
    }
}
