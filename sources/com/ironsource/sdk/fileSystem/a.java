package com.ironsource.sdk.fileSystem;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: FileSystemHandler.java */
/* loaded from: classes2.dex */
public class a extends Handler {
    private final ConcurrentHashMap<String, d.e.d.o.c> a = new ConcurrentHashMap<>();

    private boolean b(int i2) {
        return i2 == 1016 || i2 == 1015;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, d.e.d.o.c cVar) {
        if (str == null || cVar == null) {
            return;
        }
        this.a.put(str, cVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            ISNFile iSNFile = (ISNFile) message.obj;
            String path = iSNFile.getPath();
            d.e.d.o.c cVar = this.a.get(path);
            if (cVar == null) {
                return;
            }
            if (b(message.what)) {
                cVar.g(iSNFile);
            } else {
                int i2 = message.what;
                cVar.l(iSNFile, new com.ironsource.sdk.data.c(i2, d.e.d.o.d.a(i2)));
            }
            this.a.remove(path);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
