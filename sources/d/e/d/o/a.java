package d.e.d.o;

import android.os.Handler;
import android.os.Message;
import com.ironsource.sdk.fileSystem.ISNFile;
/* compiled from: DownloadHandler.java */
/* loaded from: classes2.dex */
public class a extends Handler {
    c a;

    public void a() {
        this.a = null;
    }

    public void b(c cVar) {
        if (cVar != null) {
            this.a = cVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        c cVar = this.a;
        if (cVar == null) {
            com.ironsource.sdk.utils.d.d("DownloadHandler", "OnPreCacheCompletion listener is null, msg: " + message.toString());
            return;
        }
        try {
            int i2 = message.what;
            if (i2 != 1016) {
                this.a.l((ISNFile) message.obj, new com.ironsource.sdk.data.c(i2, d.a(i2)));
                return;
            }
            cVar.g((ISNFile) message.obj);
        } catch (Throwable th) {
            com.ironsource.sdk.utils.d.d("DownloadHandler", "handleMessage | Got exception: " + th.getMessage());
            th.printStackTrace();
        }
    }
}
