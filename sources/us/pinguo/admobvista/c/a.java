package us.pinguo.admobvista.c;

import android.text.TextUtils;
import java.io.File;
import us.pinguo.advconfigdata.AdvConfigManager;
/* compiled from: ServerFileLoadControler.java */
/* loaded from: classes3.dex */
public class a {
    public static boolean a() {
        String downFilePath = AdvConfigManager.getInstance().getDownFilePath("http://dispatcher.c360dn.com/album_gif_type_1.gif");
        String downFilePath2 = AdvConfigManager.getInstance().getDownFilePath("http://dispatcher.c360dn.com/album_gif_type_2.gif");
        String downFilePath3 = AdvConfigManager.getInstance().getDownFilePath("http://dispatcher.c360dn.com/album_gif_type_3.gif");
        return !TextUtils.isEmpty(downFilePath) && !TextUtils.isEmpty(downFilePath2) && !TextUtils.isEmpty(downFilePath3) && new File(downFilePath).exists() && new File(downFilePath2).exists() && new File(downFilePath3).exists();
    }
}
