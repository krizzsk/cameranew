package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.w0;
import com.google.android.play.core.internal.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class av {
    private static final com.google.android.play.core.internal.j c = new com.google.android.play.core.internal.j("SplitInstallService");

    /* renamed from: d  reason: collision with root package name */
    private static final Intent f4873d = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");
    private final String a;
    @Nullable
    com.google.android.play.core.internal.t<w0> b;

    public av(Context context) {
        this.a = context.getPackageName();
        if (z0.a(context)) {
            this.b = new com.google.android.play.core.internal.t<>(com.google.android.play.core.splitcompat.q.a(context), c, "SplitInstallService", f4873d, j.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ArrayList c(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10800);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrayList e(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        int size = collection.size();
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = new Bundle();
            bundle.putString(IjkMediaMeta.IJKM_KEY_LANGUAGE, (String) collection.get(i2));
            arrayList.add(bundle);
        }
        return arrayList;
    }

    private static <T> com.google.android.play.core.tasks.d<T> g() {
        c.e("onError(%d)", -14);
        return com.google.android.play.core.tasks.f.a(new SplitInstallException(-14));
    }

    public final com.google.android.play.core.tasks.d<Integer> a(Collection<String> collection, Collection<String> collection2) {
        if (this.b == null) {
            return g();
        }
        c.f("startInstall(%s,%s)", collection, collection2);
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.b.c(new k(this, pVar, collection, collection2, pVar));
        return pVar.a();
    }
}
