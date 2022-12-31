package com.pinguo.camera360.gallery.temps;

import java.util.Locale;
import us.pinguo.foundation.k;
/* loaded from: classes3.dex */
public class SandBox {
    public static final String a = k.f11021e + "/";

    /* loaded from: classes3.dex */
    public enum ProjectFileType {
        share,
        share_org,
        thumb,
        photo,
        photo_org
    }

    public static String a(long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a);
        stringBuffer.append(String.valueOf(j2));
        stringBuffer.append("/");
        return stringBuffer.toString();
    }

    public static String b(ProjectFileType projectFileType, long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a);
        stringBuffer.append(String.valueOf(j2));
        stringBuffer.append("/");
        stringBuffer.append(projectFileType.toString().toLowerCase(Locale.ENGLISH));
        stringBuffer.append(".jpg");
        return stringBuffer.toString();
    }
}
