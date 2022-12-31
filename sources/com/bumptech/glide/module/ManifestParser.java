package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class ManifestParser {
    private final Context a;

    public ManifestParser(Context context) {
        this.a = context;
    }

    private static a b(String str) {
        Object obj;
        Object obj2;
        try {
            try {
                Object newInstance = Class.forName(str).newInstance();
                if (newInstance instanceof a) {
                    return (a) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + obj2, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + obj, e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e4);
        }
    }

    public List<a> a() {
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(b(str));
                    }
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
        }
    }
}
