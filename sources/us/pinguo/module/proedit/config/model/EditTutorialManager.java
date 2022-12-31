package us.pinguo.module.proedit.config.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.pinguo.lib.download.Config;
import com.pinguo.lib.download.listener.DownloadListener;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.manager.TutorialDownloadManager;
import us.pinguo.foundation.utils.k0;
import us.pinguo.repository2020.utils.o;
/* compiled from: EditTutorialManager.kt */
/* loaded from: classes5.dex */
public final class EditTutorialManager {
    public static final EditTutorialManager a = new EditTutorialManager();
    private static final Handler b = new a(Looper.getMainLooper());

    /* compiled from: EditTutorialManager.kt */
    /* loaded from: classes5.dex */
    public static final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            s.h(msg, "msg");
            if (msg.what != 1) {
                return;
            }
            k0.a.a(R.string.text_tutorial_download_fail);
        }
    }

    /* compiled from: EditTutorialManager.kt */
    /* loaded from: classes5.dex */
    public static final class b implements DownloadListener {
        b() {
        }

        @Override // com.pinguo.lib.download.listener.DownloadListener
        public void onComplete(Config config) {
            EditTutorialManager editTutorialManager = EditTutorialManager.a;
            editTutorialManager.d().sendEmptyMessage(0);
            editTutorialManager.b();
        }

        @Override // com.pinguo.lib.download.listener.DownloadListener
        public void onFailed(Config config, Throwable th) {
            EditTutorialManager.a.d().sendEmptyMessage(1);
        }

        @Override // com.pinguo.lib.download.listener.DownloadListener
        public void onPause(Config config, Throwable th) {
        }

        @Override // com.pinguo.lib.download.listener.DownloadListener
        public void onStart(Config config) {
        }
    }

    private EditTutorialManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        l.d(n0.a(z0.b()), null, null, new EditTutorialManager$checkPrevSource$1(null), 3, null);
    }

    public final void c() {
        String j2 = o.j(o.a, "tutorial_option4", "", null, 4, null);
        if (j2 == null || j2.length() == 0) {
            TutorialDownloadManager.d(TutorialDownloadManager.a, new b(), null, 2, null);
        }
    }

    public final Handler d() {
        return b;
    }
}
