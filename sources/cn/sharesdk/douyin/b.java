package cn.sharesdk.douyin;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
/* compiled from: DouyinHandler.java */
/* loaded from: classes.dex */
public class b {
    private Platform a;
    private Platform.ShareParams b;
    private PlatformActionListener c;

    public b(Platform platform) {
        this.a = platform;
    }

    public void a(Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        this.b = shareParams;
        this.c = platformActionListener;
    }

    public Platform a() {
        return this.a;
    }
}
