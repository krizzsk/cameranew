package us.pinguo.image.saver.sandbox;

import android.os.Environment;
/* loaded from: classes4.dex */
public class SandBoxConstants {
    public static final String a;
    public static final String b;
    public static final String c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f11193d;

    /* loaded from: classes4.dex */
    public enum SandBoxPictureType {
        share,
        share_org,
        thumb,
        photo,
        photo_org
    }

    static {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        a = absolutePath;
        String str = absolutePath + "/Camera360";
        b = str;
        String str2 = str + "/TempData/.sandbox";
        c = str2;
        f11193d = str2 + "/";
    }
}
