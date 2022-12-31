package com.pinguo.camera360.app.download;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.k.b.a;
import com.pinguo.lib.download.Config;
import com.pinguo.lib.download.listener.DownloadListenerAdapter;
/* loaded from: classes3.dex */
public class AppDownloadService extends Service {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends DownloadListenerAdapter {
        a(AppDownloadService appDownloadService) {
        }

        @Override // com.pinguo.lib.download.listener.DownloadListenerAdapter, com.pinguo.lib.download.listener.DownloadListener
        public void onComplete(Config config) {
            a.C0243a.f(config.getDownloadUrl());
        }
    }

    private void a(Intent intent) {
        Config config = (Config) intent.getParcelableExtra("download_config");
        String stringExtra = intent.getStringExtra("download_title");
        int intExtra = intent.getIntExtra("finish_action", 0);
        if (config == null) {
            return;
        }
        a.C0243a.e(config.getDownloadUrl());
        b.d().c(config.getDownloadUrl(), config.getMd5(), stringExtra, intExtra, new a(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        VdsAgent.onServiceStartCommand(this, intent, i2, i3);
        if (intent == null) {
            return super.onStartCommand(intent, i2, i3);
        }
        if ("us.pinguo.camera360.app.download.RETRY_SERVICE".equals(intent.getAction())) {
            a(intent);
        }
        return super.onStartCommand(intent, i2, i3);
    }
}
