package com.pinguo.camera360.app.download;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.pinguo.lib.download.Config;
import com.pinguo.lib.download.PGDownloadManager;
import com.pinguo.lib.download.listener.DownloadListener;
import com.pinguo.lib.download.listener.DownloadProcessListener;
import java.io.File;
import java.util.Locale;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.util.q;
import vStudio.Android.Camera360.R;
/* compiled from: AppDownloadManager.java */
/* loaded from: classes3.dex */
public class b {
    private static final b b = new b();
    private c a;

    /* compiled from: AppDownloadManager.java */
    /* loaded from: classes3.dex */
    private class a implements DownloadListener, DownloadProcessListener {
        private String a;
        private int b;
        private DownloadListener c;

        protected a(String str, int i2, DownloadListener downloadListener) {
            this.a = null;
            this.b = 0;
            this.c = null;
            this.a = str;
            this.b = i2;
            this.c = downloadListener;
        }

        @Override // com.pinguo.lib.download.listener.DownloadListener
        public void onComplete(Config config) {
            b.this.a.a(this.a);
            DownloadListener downloadListener = this.c;
            if (downloadListener != null) {
                downloadListener.onComplete(config);
            }
            if (this.b != 1) {
                return;
            }
            b.h(BaseApplication.d(), config.getSavePath());
        }

        @Override // com.pinguo.lib.download.listener.DownloadListener
        public void onFailed(Config config, Throwable th) {
            b.this.a.a(this.a);
            File file = new File(config.getSaveTmpPath());
            if (file.exists()) {
                file.delete();
            }
            b.this.a.e(this.a, config, R.string.download_error_retry);
            DownloadListener downloadListener = this.c;
            if (downloadListener != null) {
                downloadListener.onFailed(config, th);
            }
        }

        @Override // com.pinguo.lib.download.listener.DownloadListener
        public void onPause(Config config, Throwable th) {
            b.this.a.a(this.a);
            b.this.a.e(this.a, config, R.string.download_pause_retry);
            DownloadListener downloadListener = this.c;
            if (downloadListener != null) {
                downloadListener.onPause(config, th);
            }
        }

        @Override // com.pinguo.lib.download.listener.DownloadProcessListener
        public void onProgressUpdate(Config config, int i2, int i3) {
            int i4 = (int) ((i2 * 100) / i3);
            c cVar = b.this.a;
            String str = this.a;
            cVar.f(str, i4 + "%," + b.this.f(i2, i3), i4);
        }

        @Override // com.pinguo.lib.download.listener.DownloadListener
        public void onStart(Config config) {
            b.this.a.f(this.a, BaseApplication.d().getResources().getString(R.string.push_start_download), 0);
            DownloadListener downloadListener = this.c;
            if (downloadListener != null) {
                downloadListener.onStart(config);
            }
        }
    }

    private b() {
        this.a = null;
        this.a = new c();
    }

    public static b d() {
        return b;
    }

    private String e(int i2) {
        if (i2 >= 1024) {
            return i2 < 1048576 ? String.format(Locale.ENGLISH, "%.2fK", Float.valueOf(i2 / 1024.0f)) : i2 < 1073741824 ? String.format(Locale.ENGLISH, "%.2fM", Float.valueOf((i2 / 1024.0f) / 1024.0f)) : String.format(Locale.ENGLISH, "%.2fG", Float.valueOf(((i2 / 1024.0f) / 1024.0f) / 1024.0f));
        }
        return i2 + "B";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(int i2, int i3) {
        return e(i2) + "/" + e(i3);
    }

    public static void h(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            try {
                Intent intent = new Intent();
                intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                intent.setAction("android.intent.action.VIEW");
                intent.setDataAndType(FileProvider.getUriForFile(context, "vStudio.Android.Camera360.fileProvider", file), "application/vnd.android.package-archive");
                intent.addFlags(1);
                context.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public void c(String str, String str2, String str3, int i2, DownloadListener downloadListener) {
        if (str3 == null) {
            str3 = Uri.parse(str).getLastPathSegment();
        }
        Config build = new Config.Builder(str).setFileSuffix(".apk").setMd5(str2).build();
        Context d2 = BaseApplication.d();
        if (!q.f(d2)) {
            this.a.e(str3, build, R.string.download_not_network);
            return;
        }
        a aVar = new a(str3, i2, downloadListener);
        if (PGDownloadManager.get().start(build, aVar, aVar)) {
            String string = d2.getResources().getString(R.string.download_waiting);
            if (this.a.b(str3)) {
                this.a.f(str3, string, 0);
            } else {
                this.a.d(str3, string);
            }
        }
    }

    public boolean g(String str, String str2) {
        return new File(new Config.Builder(str).setFileSuffix(".apk").setMd5(str2).build().getSavePath()).exists();
    }
}
