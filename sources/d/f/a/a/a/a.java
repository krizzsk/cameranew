package d.f.a.a.a;

import android.graphics.Bitmap;
import d.f.a.b.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: DiscCacheAware.java */
@Deprecated
/* loaded from: classes3.dex */
public interface a {
    boolean a(String str, Bitmap bitmap) throws IOException;

    boolean b(String str, InputStream inputStream, c.a aVar) throws IOException;

    File get(String str);

    boolean remove(String str);
}
