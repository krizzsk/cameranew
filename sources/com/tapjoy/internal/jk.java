package com.tapjoy.internal;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompatExtras;
import androidx.core.app.NotificationCompatJellybean;
import com.google.firebase.messaging.Constants;
import com.tapjoy.internal.ji;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
@RequiresApi(16)
/* loaded from: classes3.dex */
public final class jk {
    private static Field b;
    private static boolean c;
    private static final Object a = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f7760d = new Object();

    public static SparseArray a(List list) {
        int size = list.size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = (Bundle) list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (a) {
            if (c) {
                return null;
            }
            try {
                if (b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e(NotificationCompatJellybean.TAG, "Notification.extras field is not of type Bundle");
                        c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    b = declaredField;
                }
                Bundle bundle = (Bundle) b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e(NotificationCompatJellybean.TAG, "Unable to access notification extras", e2);
                c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e(NotificationCompatJellybean.TAG, "Unable to access notification extras", e3);
                c = true;
                return null;
            }
        }
    }

    private static Bundle[] a(jl[] jlVarArr) {
        if (jlVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[jlVarArr.length];
        for (int i2 = 0; i2 < jlVarArr.length; i2++) {
            jl jlVar = jlVarArr[i2];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", jlVar.a);
            bundle.putCharSequence(Constants.ScionAnalytics.PARAM_LABEL, jlVar.b);
            bundle.putCharSequenceArray("choices", jlVar.c);
            bundle.putBoolean("allowFreeFormInput", jlVar.f7761d);
            bundle.putBundle("extras", jlVar.f7762e);
            Set<String> set = jlVar.f7763f;
            if (set != null && !set.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList<>(set.size());
                for (String str : set) {
                    arrayList.add(str);
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
            bundleArr[i2] = bundle;
        }
        return bundleArr;
    }

    public static Bundle a(Notification.Builder builder, ji.a aVar) {
        builder.addAction(aVar.f7741e, aVar.f7742f, aVar.f7743g);
        Bundle bundle = new Bundle(aVar.a);
        jl[] jlVarArr = aVar.b;
        if (jlVarArr != null) {
            bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, a(jlVarArr));
        }
        jl[] jlVarArr2 = aVar.c;
        if (jlVarArr2 != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(jlVarArr2));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f7740d);
        return bundle;
    }
}
