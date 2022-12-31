package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.bigalbum.BigAlbumObserver;
/* compiled from: BigAlbumChangeNotifier.java */
/* loaded from: classes3.dex */
public class e extends BigAlbumObserver {
    private y a;
    private AtomicBoolean b;
    private String c;

    public e(y yVar, Application application) {
        super(new Handler(application.getMainLooper()));
        this.b = new AtomicBoolean(true);
        this.a = yVar;
        BigAlbumManager.instance().registerObserver(this);
    }

    public boolean a() {
        return this.b.compareAndSet(true, false);
    }

    @Override // us.pinguo.bigalbum.BigAlbumObserver, us.pinguo.bigalbum.IBigAlbumObserver
    public void onChange(String str) {
        String str2 = this.c;
        if (str2 == null || str2.equalsIgnoreCase(str)) {
            us.pinguo.common.log.a.c("notify onChange:" + str, new Object[0]);
            if (this.b.compareAndSet(false, true)) {
                this.a.w();
            }
        }
    }

    public e(y yVar, Application application, String str) {
        this(yVar, application);
        this.c = str;
    }
}
