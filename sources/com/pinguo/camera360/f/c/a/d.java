package com.pinguo.camera360.f.c.a;

import android.text.TextUtils;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.e;
import us.pinguo.foundation.utils.m0;
/* compiled from: StickerAdLoader.java */
/* loaded from: classes3.dex */
public class d {
    private static Map<String, Observable> a = new HashMap();

    private static Observable<String> a(final String str, final boolean z) {
        return Observable.create(new Observable.OnSubscribe() { // from class: com.pinguo.camera360.f.c.a.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                d.c(str, z, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private static File b(boolean z) {
        File file;
        File cacheDir = e.b().getCacheDir();
        if (z) {
            file = new File(cacheDir, "sticker");
        } else {
            file = new File(cacheDir, "filter");
        }
        file.mkdirs();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(String str, boolean z, Subscriber subscriber) {
        File file;
        String absolutePath;
        BaseImageDownloader baseImageDownloader = new BaseImageDownloader(e.b());
        try {
            us.pinguo.common.log.a.k("开始下载:" + str, new Object[0]);
            d.f.a.a.a.d.c cVar = new d.f.a.a.a.d.c();
            File b = b(z);
            String a2 = cVar.a(str);
            if (z) {
                file = new File(b, a2 + ".zip");
            } else {
                if (str != null && str.endsWith(".gif")) {
                    a2 = a2 + ".gif";
                }
                file = new File(b, a2);
            }
            if (!file.exists()) {
                InputStream a3 = baseImageDownloader.a(str, null);
                File file2 = new File(b, a2 + ".temp");
                d.f.a.b.c.b(a3, new BufferedOutputStream(new FileOutputStream(file2), 32768), null);
                file2.renameTo(file);
            }
            us.pinguo.common.log.a.k("广告文件下载完成:" + file.getAbsolutePath(), new Object[0]);
            if (z) {
                File file3 = new File(b, a2);
                file3.mkdirs();
                m0.d(file.getAbsolutePath(), file3.getAbsolutePath());
                absolutePath = file3.getAbsolutePath();
            } else {
                absolutePath = file.getAbsolutePath();
            }
            subscriber.onNext(absolutePath);
            subscriber.onCompleted();
        } catch (IOException e2) {
            us.pinguo.common.log.a.e("下载失败:" + str, e2);
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(String str, Throwable th) {
        us.pinguo.common.log.a.f(th);
        a.remove(str);
    }

    public static void f() {
        List<AdvItem> items = AdvConfigManager.getInstance().getItems("0ee0acc362a5243fe68a53aa32894751");
        if (items == null || items.size() <= 0) {
            return;
        }
        g(items.get(0).resUrl, true);
    }

    public static String g(final String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d.f.a.a.a.d.c cVar = new d.f.a.a.a.d.c();
        File b = b(z);
        String a2 = cVar.a(str);
        if (str != null && str.endsWith(".gif")) {
            a2 = a2 + ".gif";
        }
        File file = new File(b, a2);
        boolean exists = file.exists();
        if (z && exists && file.isDirectory()) {
            return file.getAbsolutePath();
        }
        if (!z && exists) {
            return file.getAbsolutePath();
        }
        if (a.get(str) == null) {
            Observable<String> a3 = a(str, z);
            a.put(str, a3);
            a3.subscribe(new Action1() { // from class: com.pinguo.camera360.f.c.a.a
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    String str2 = (String) obj;
                    d.a.remove(str);
                }
            }, new Action1() { // from class: com.pinguo.camera360.f.c.a.c
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    d.e(str, (Throwable) obj);
                }
            });
        }
        return null;
    }
}
