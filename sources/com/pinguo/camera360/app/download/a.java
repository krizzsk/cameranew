package com.pinguo.camera360.app.download;

import com.pinguo.lib.download.listener.DownloadListener;
/* compiled from: AppBindDownloader.java */
/* loaded from: classes3.dex */
public class a {
    private static final String a = "a";

    public void a(String str, String str2, DownloadListener downloadListener) {
        if (str != null && str2 != null) {
            b.d().c(str2, null, null, 1, downloadListener);
        } else {
            us.pinguo.common.log.a.m(a, "appname is null or url is null", new Object[0]);
        }
    }
}
