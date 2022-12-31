package us.pinguo.vip.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlinx.coroutines.channels.e;
/* compiled from: VipSalePageLauncher.kt */
/* loaded from: classes6.dex */
public final class c {
    public static final c a = new c();
    private static e<String> b;

    private c() {
    }

    public static /* synthetic */ void d(c cVar, Context context, Bundle bundle, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        cVar.c(context, bundle, z);
    }

    public final void a() {
        b = null;
    }

    public final boolean b() {
        return b != null;
    }

    public final void c(Context context, Bundle bundle, boolean z) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        if (b.a.d()) {
            intent.setClassName(context, "com.pinguo.camera360.member.SubscriptionMemberActivity");
        } else {
            intent.setClassName(context, "com.pinguo.camera360.member.MemberRightsActivity");
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (z && (context instanceof Activity)) {
            ((Activity) context).startActivityForResult(intent, 1000);
        } else {
            context.startActivity(intent);
        }
    }
}
