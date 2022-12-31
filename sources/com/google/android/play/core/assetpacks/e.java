package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class e {
    public static e a(long j2, Map<String, AssetPackState> map) {
        return new q0(j2, map);
    }

    public static e b(Bundle bundle, f1 f1Var) {
        return d(bundle, f1Var, new ArrayList());
    }

    public static e c(Bundle bundle, f1 f1Var, h0 h0Var) {
        return e(bundle, f1Var, new ArrayList(), h0Var);
    }

    public static e d(Bundle bundle, f1 f1Var, List<String> list) {
        return e(bundle, f1Var, list, j0.a);
    }

    private static e e(Bundle bundle, f1 f1Var, List<String> list, h0 h0Var) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        HashMap hashMap = new HashMap();
        int size = stringArrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = stringArrayList.get(i2);
            hashMap.put(str, AssetPackState.a(bundle, str, f1Var, h0Var));
        }
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            String str2 = list.get(i3);
            hashMap.put(str2, AssetPackState.b(str2, 4, 0, 0L, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        }
        return a(bundle.getLong("total_bytes_to_download"), hashMap);
    }

    public abstract Map<String, AssetPackState> f();

    public abstract long g();
}
