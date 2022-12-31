package us.pinguo.camera2020.widget.bubbleSeekbar;

import android.content.res.Resources;
import android.os.Environment;
import android.util.TypedValue;
import android.view.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* compiled from: BubbleUtils.java */
/* loaded from: classes3.dex */
public class b {
    private static Properties b;
    private static final File a = new File(Environment.getRootDirectory(), "build.prop");
    private static final Object c = new Object();

    public static int a(float f2) {
        return (int) TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    private static Properties b() {
        synchronized (c) {
            if (b == null) {
                Properties properties = new Properties();
                b = properties;
                try {
                    properties.load(new FileInputStream(a));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Window window) {
        return (window == null || (window.getAttributes().flags & 1024) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        return b().containsKey("ro.miui.ui.version.name");
    }

    public static int e(float f2) {
        return (int) TypedValue.applyDimension(2, f2, Resources.getSystem().getDisplayMetrics());
    }
}
