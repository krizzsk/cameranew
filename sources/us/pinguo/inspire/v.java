package us.pinguo.inspire;

import android.content.Context;
import android.content.Intent;
import us.pinguo.foundation.base.InspireContentActivity;
/* compiled from: InspireLauncher.kt */
/* loaded from: classes4.dex */
public final class v {
    public static final void a(Context context, String className, String str) {
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(className, "className");
        Intent intent = new Intent();
        intent.setClassName(context, className);
        if (str != null) {
            intent.putExtra(InspireContentActivity.FRAGMENT_NAME, str);
        }
        intent.setFlags(603979776);
        context.startActivity(intent);
    }
}
