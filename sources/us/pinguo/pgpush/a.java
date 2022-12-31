package us.pinguo.pgpush;

import android.content.Context;
import us.pinguo.push.b;
import us.pinguo.push.f;
/* compiled from: PushInit.java */
/* loaded from: classes5.dex */
public class a {
    public static void a(Context context, b bVar) {
        try {
            f.c(context, bVar);
        } catch (Exception e2) {
            us.pinguo.common.log.a.g("newPush", "Fatal", e2);
        }
    }
}
