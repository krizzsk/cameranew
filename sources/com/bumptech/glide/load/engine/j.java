package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* compiled from: ResourceRecycler.java */
/* loaded from: classes.dex */
class j {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new b());

    /* compiled from: ResourceRecycler.java */
    /* loaded from: classes.dex */
    private static class b implements Handler.Callback {
        private b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((i) message.obj).recycle();
                return true;
            }
            return false;
        }
    }

    public void a(i<?> iVar) {
        com.bumptech.glide.l.h.a();
        if (this.a) {
            this.b.obtainMessage(1, iVar).sendToTarget();
            return;
        }
        this.a = true;
        iVar.recycle();
        this.a = false;
    }
}
