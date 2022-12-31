package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
/* compiled from: WXLaunchMiniProgram.java */
/* loaded from: classes.dex */
public class i {

    /* compiled from: WXLaunchMiniProgram.java */
    /* loaded from: classes.dex */
    public static final class a extends m {
        public String a;
        public String b = "";
        public int c = 0;

        /* renamed from: d  reason: collision with root package name */
        public String f315d = "";

        @Override // cn.sharesdk.wechat.utils.m
        public final int a() {
            return 19;
        }

        @Override // cn.sharesdk.wechat.utils.m
        public final boolean a(boolean z) {
            String str = this.a;
            if (str != null && str.length() != 0 && this.a.length() <= 10240) {
                int i2 = this.c;
                if (i2 < 0 || i2 > 2) {
                    SSDKLog.b().d("checkArgs fail", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
                    return false;
                }
                return true;
            }
            SSDKLog.b().d("checkArgs fail, userName is invalid", new Object[0]);
            return false;
        }

        @Override // cn.sharesdk.wechat.utils.m
        public final void a(Bundle bundle) {
            super.a(bundle);
            bundle.putString("_launch_wxminiprogram_username", this.a);
            bundle.putString("_launch_wxminiprogram_path", this.b);
            bundle.putInt("_launch_wxminiprogram_type", this.c);
            bundle.putString("_launch_wxminiprogram_extData", this.f315d);
        }
    }
}
