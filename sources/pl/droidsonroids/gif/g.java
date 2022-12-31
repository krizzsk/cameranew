package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InvalidationHandler.java */
/* loaded from: classes3.dex */
public class g extends Handler {
    private final WeakReference<c> a;

    public g(c cVar) {
        super(Looper.getMainLooper());
        this.a = new WeakReference<>(cVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        c cVar = this.a.get();
        if (cVar == null) {
            return;
        }
        if (message.what == -1) {
            cVar.invalidateSelf();
            return;
        }
        Iterator<a> it = cVar.f8982h.iterator();
        while (it.hasNext()) {
            it.next().a(message.what);
        }
    }
}
