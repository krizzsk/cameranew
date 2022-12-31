package us.pinguo.admobvista;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import us.pinguo.advsdk.a.i;
import us.pinguo.foundation.utils.n;
/* compiled from: PGAdvImageLoader.java */
/* loaded from: classes3.dex */
public class e implements i {
    @Override // us.pinguo.advsdk.a.i
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n.a.d(Uri.parse(str));
    }

    @Override // us.pinguo.advsdk.a.i
    public String b(String str) {
        File b = n.a.b(Uri.parse(str));
        if (b != null) {
            return b.getAbsolutePath();
        }
        return null;
    }

    @Override // us.pinguo.advsdk.a.i
    public void c(i iVar) {
    }

    @Override // us.pinguo.advsdk.a.i
    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return n.a.c(Uri.parse(str));
    }
}
