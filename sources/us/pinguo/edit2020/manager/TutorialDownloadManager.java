package us.pinguo.edit2020.manager;

import com.pinguo.lib.download.Config;
import com.pinguo.lib.download.PGDownloadManager;
import com.pinguo.lib.download.listener.DownloadListener;
import com.pinguo.lib.download.listener.DownloadProcessListener;
import java.io.File;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.j;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.R;
import us.pinguo.foundation.utils.k0;
/* compiled from: TutorialDownloadManager.kt */
/* loaded from: classes4.dex */
public final class TutorialDownloadManager {
    public static final TutorialDownloadManager a = new TutorialDownloadManager();
    private static final h b;
    private static final String c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f10533d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f10534e;

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f10535f;

    static {
        String absolutePath;
        h hVar = new h();
        b = hVar;
        c = s.q(hVar.a(), "tutorial");
        File externalFilesDir = us.pinguo.foundation.e.b().getExternalFilesDir(null);
        String str = "";
        if (externalFilesDir != null && (absolutePath = externalFilesDir.getAbsolutePath()) != null) {
            str = absolutePath;
        }
        f10533d = str;
        f10534e = s.q(str, "/tutorial");
        f10535f = new String[]{s.q(str, "/tutorial7"), s.q(str, "/tutorial5")};
    }

    private TutorialDownloadManager() {
    }

    public static /* synthetic */ void d(TutorialDownloadManager tutorialDownloadManager, DownloadListener downloadListener, DownloadProcessListener downloadProcessListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            downloadListener = null;
        }
        if ((i2 & 2) != 0) {
            downloadProcessListener = null;
        }
        tutorialDownloadManager.c(downloadListener, downloadProcessListener);
    }

    public final void c(final DownloadListener downloadListener, DownloadProcessListener downloadProcessListener) {
        DownloadListener downloadListener2 = new DownloadListener() { // from class: us.pinguo.edit2020.manager.TutorialDownloadManager$downloadTutorial$realDownloadListener$1
            @Override // com.pinguo.lib.download.listener.DownloadListener
            public void onComplete(Config config) {
                j.d(n0.a(z0.b()), null, null, new TutorialDownloadManager$downloadTutorial$realDownloadListener$1$onComplete$1(DownloadListener.this, config, null), 3, null);
            }

            @Override // com.pinguo.lib.download.listener.DownloadListener
            public void onFailed(Config config, Throwable th) {
                DownloadListener downloadListener3 = DownloadListener.this;
                if (downloadListener3 != null) {
                    downloadListener3.onFailed(config, th);
                }
                k0.a.a(R.string.text_tutorial_download_fail);
            }

            @Override // com.pinguo.lib.download.listener.DownloadListener
            public void onPause(Config config, Throwable th) {
                DownloadListener downloadListener3 = DownloadListener.this;
                if (downloadListener3 == null) {
                    return;
                }
                downloadListener3.onPause(config, th);
            }

            @Override // com.pinguo.lib.download.listener.DownloadListener
            public void onStart(Config config) {
                DownloadListener downloadListener3 = DownloadListener.this;
                if (downloadListener3 == null) {
                    return;
                }
                downloadListener3.onStart(config);
            }
        };
        StringBuilder sb = new StringBuilder();
        sb.append("http://res.c360dn.com/tutorial-v13/");
        String str = c;
        sb.append(str);
        sb.append(".zip");
        PGDownloadManager.get().start(new Config.Builder(sb.toString()).setSaveFolder(s.q(f10534e, "/")).setFileName(str).setFileSuffix(".zip").build(), downloadListener2, downloadProcessListener);
    }

    public final String[] e() {
        return f10535f;
    }

    public final String f() {
        return f10534e;
    }

    public final String g() {
        return f10534e + '/' + c;
    }

    public final boolean h() {
        return b.b();
    }
}
