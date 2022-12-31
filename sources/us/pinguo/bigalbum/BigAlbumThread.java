package us.pinguo.bigalbum;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes3.dex */
public class BigAlbumThread extends HandlerThread {
    Handler mBigAlbumHandler;

    public BigAlbumThread() {
        super("Thread-BigAlbum-Control");
    }

    public Handler getBigAlbumHandler() {
        return this.mBigAlbumHandler;
    }

    public void runTask(Runnable runnable) {
        this.mBigAlbumHandler.post(runnable);
    }

    @Override // java.lang.Thread
    public void start() {
        super.start();
        this.mBigAlbumHandler = new Handler(getLooper());
    }
}
