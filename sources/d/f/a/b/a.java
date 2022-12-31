package d.f.a.b;

import java.io.File;
/* compiled from: DiskCacheUtils.java */
/* loaded from: classes3.dex */
public final class a {
    public static boolean a(String str, d.f.a.a.a.b bVar) {
        File file = bVar.get(str);
        return file != null && file.exists() && file.delete();
    }
}
