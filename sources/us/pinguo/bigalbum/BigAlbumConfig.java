package us.pinguo.bigalbum;

import android.content.Context;
import android.os.Environment;
import us.pinguo.common.utils.h;
/* loaded from: classes3.dex */
public abstract class BigAlbumConfig {
    public abstract String getAppChannel();

    public String getAppKey() {
        return "7653b3eb8fd35ada";
    }

    public abstract String getAppName();

    public String getAppSecret() {
        return "cq6h7qnsu4twd3wdmqe81o9ic3mxnz8k";
    }

    public String getAppVersion(Context context) {
        return h.a(context);
    }

    public String getLegacyDbPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Camera360/TempData/.sandbox/sandbox.db";
    }

    public long getPullInterval() {
        return 0L;
    }

    public String getServiceHost() {
        return "http://syncapi-testing-dev.camera360.com";
    }

    public boolean isDebug() {
        return false;
    }
}
