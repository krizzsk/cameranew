package us.pinguo.foundation;

import android.os.Environment;
import java.io.File;
/* compiled from: PGFileConstants.java */
@Deprecated
/* loaded from: classes4.dex */
public class k {
    public static final String a;
    public static final String b;
    public static final String c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f11020d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f11021e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f11022f;

    static {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Camera360";
        a = str;
        String str2 = str + "/TempData";
        b = str2;
        c = str2 + "/front_pic";
        f11020d = str2 + "/front_pic_mirror";
        f11021e = str + "/TempData/.sandbox";
        String b2 = f.b();
        f11022f = b2;
        if (new File(b2).exists() || new File(b2).mkdirs()) {
            return;
        }
        us.pinguo.common.log.a.g("", "Create dir failed!", new Object[0]);
    }
}
