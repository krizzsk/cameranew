package us.pinguo.foundation.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
/* compiled from: AppGotoRule.java */
/* loaded from: classes4.dex */
public interface a {
    Intent a(Uri uri, Bundle bundle, Context context);

    void b(Uri uri, Context context, Intent intent);

    boolean c(Uri uri, Bundle bundle);

    boolean d(Uri uri);
}
