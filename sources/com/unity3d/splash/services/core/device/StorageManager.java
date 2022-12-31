package com.unity3d.splash.services.core.device;

import android.content.Context;
import com.unity3d.splash.services.c.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class StorageManager {
    protected static final Map a = new HashMap();
    protected static final List b = new ArrayList();

    /* loaded from: classes3.dex */
    public enum StorageType {
        PRIVATE,
        PUBLIC
    }

    public static synchronized void a(StorageType storageType, String str) {
        synchronized (StorageManager.class) {
            Map map = a;
            if (!map.containsKey(storageType)) {
                map.put(storageType, str);
            }
        }
    }

    public static a b(StorageType storageType) {
        List<a> list = b;
        if (list != null) {
            for (a aVar : list) {
                if (aVar != null && aVar.h().equals(storageType)) {
                    return aVar;
                }
            }
            return null;
        }
        return null;
    }

    public static boolean c(StorageType storageType) {
        List<a> list = b;
        if (list != null) {
            for (a aVar : list) {
                if (aVar != null && aVar.h().equals(storageType)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean d(Context context) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return false;
        }
        StorageType storageType = StorageType.PUBLIC;
        a(storageType, filesDir + "/" + b.f() + "public-data.json");
        if (f(storageType)) {
            StorageType storageType2 = StorageType.PRIVATE;
            a(storageType2, filesDir + "/" + b.f() + "private-data.json");
            return f(storageType2);
        }
        return false;
    }

    public static void e(StorageType storageType) {
        if (c(storageType)) {
            a b2 = b(storageType);
            if (b2 != null) {
                b2.i();
                return;
            }
            return;
        }
        Map map = a;
        if (map.containsKey(storageType)) {
            a aVar = new a((String) map.get(storageType), storageType);
            aVar.i();
            b.add(aVar);
        }
    }

    private static boolean f(StorageType storageType) {
        if (c(storageType)) {
            return true;
        }
        e(storageType);
        a b2 = b(storageType);
        if (b2 != null && !b2.k()) {
            b2.l();
        }
        return b2 != null;
    }
}
