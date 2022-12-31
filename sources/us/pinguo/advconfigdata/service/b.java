package us.pinguo.advconfigdata.service;

import android.content.Intent;
import android.content.res.Configuration;
/* compiled from: ICommonService.java */
/* loaded from: classes3.dex */
public interface b {
    void a(Intent intent, int i2);

    void b(Intent intent);

    boolean c(Intent intent);

    int d(Intent intent, int i2, int i3);

    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onDestroy();

    void onLowMemory();

    void onTrimMemory(int i2);
}
