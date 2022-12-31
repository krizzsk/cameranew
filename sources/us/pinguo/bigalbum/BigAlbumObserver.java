package us.pinguo.bigalbum;

import android.os.Handler;
/* loaded from: classes3.dex */
public abstract class BigAlbumObserver implements IBigAlbumObserver {
    Handler mHandler;

    /* loaded from: classes3.dex */
    private final class NotificationRunnable implements Runnable {
        String changedTable;

        public NotificationRunnable(String str) {
            this.changedTable = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            BigAlbumObserver.this.onChange(this.changedTable);
        }
    }

    public BigAlbumObserver(Handler handler) {
        this.mHandler = handler;
    }

    void dispatchChange(String str) {
        Handler handler = this.mHandler;
        if (handler == null) {
            onChange(str);
        } else {
            handler.post(new NotificationRunnable(str));
        }
    }

    @Override // us.pinguo.bigalbum.IBigAlbumObserver
    public abstract void onChange(String str);
}
