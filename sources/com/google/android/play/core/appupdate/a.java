package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.internal.j;
/* loaded from: classes2.dex */
public final class a extends d.c.a.d.a.a.c<InstallState> {
    public a(Context context) {
        super(new j("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // d.c.a.d.a.a.c
    public final void a(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
            this.a.c("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
            return;
        }
        this.a.c("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.a.c("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        j jVar = this.a;
        jVar.c("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        jVar.c("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
        jVar.c("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
        InstallState a = InstallState.a(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0L), intent.getLongExtra("total.bytes.to.download", 0L), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
        this.a.c("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
        c(a);
    }
}
