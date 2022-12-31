package us.pinguo.image.saver.sandbox;

import android.content.Context;
import java.util.Locale;
import us.pinguo.image.saver.sandbox.SandBoxConstants;
/* compiled from: SandBoxModel.java */
/* loaded from: classes4.dex */
public class a {
    public static String a(SandBoxConstants.SandBoxPictureType sandBoxPictureType, long j2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(SandBoxConstants.f11193d);
        stringBuffer.append(String.valueOf(j2));
        stringBuffer.append("/");
        stringBuffer.append(sandBoxPictureType.toString().toLowerCase(Locale.ENGLISH));
        stringBuffer.append(".jpg");
        return stringBuffer.toString();
    }

    public static void b(Context context, us.pinguo.image.saver.d.a aVar) {
        try {
            SandBoxSql.getInstance().b(aVar);
        } catch (Exception unused) {
        }
    }
}
