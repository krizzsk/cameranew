package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.android.billingclient.api.BillingClient;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: InAppPurchaseEventManager.java */
/* loaded from: classes.dex */
class h {
    private static final HashMap<String, Method> a = new HashMap<>();
    private static final HashMap<String, Class<?>> b = new HashMap<>();
    private static final String c = com.facebook.f.f().getPackageName();

    /* renamed from: d  reason: collision with root package name */
    private static final SharedPreferences f2315d = com.facebook.f.f().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);

    /* renamed from: e  reason: collision with root package name */
    private static final SharedPreferences f2316e = com.facebook.f.f().getSharedPreferences("com.facebook.internal.PURCHASE", 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Object a(Context context, IBinder iBinder) {
        return n(context, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{iBinder});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = f2315d;
        long j2 = sharedPreferences.getLong("LAST_CLEARED_TIME", 0L);
        if (j2 == 0) {
            sharedPreferences.edit().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
        } else if (currentTimeMillis - j2 > 604800) {
            sharedPreferences.edit().clear().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
        }
    }

    private static ArrayList<String> c(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor edit = f2316e.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                JSONObject jSONObject = new JSONObject(next);
                String string = jSONObject.getString("productId");
                long j2 = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j2 / 1000) <= 86400 && !f2316e.getString(string, "").equals(string2)) {
                    edit.putString(string, string2);
                    arrayList2.add(next);
                }
            } catch (JSONException unused) {
            }
        }
        edit.apply();
        return arrayList2;
    }

    @Nullable
    private static Class<?> d(Context context, String str) {
        HashMap<String, Class<?>> hashMap = b;
        Class<?> cls = hashMap.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            cls = context.getClassLoader().loadClass(str);
            hashMap.put(str, cls);
            return cls;
        } catch (ClassNotFoundException unused) {
            return cls;
        }
    }

    @Nullable
    private static Method e(Class<?> cls, String str) {
        HashMap<String, Method> hashMap = a;
        Method method = hashMap.get(str);
        if (method != null) {
            return method;
        }
        Class<?>[] clsArr = null;
        char c2 = 65535;
        try {
            switch (str.hashCode()) {
                case -1801122596:
                    if (str.equals("getPurchases")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1450694211:
                    if (str.equals("isBillingSupported")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1123215065:
                    if (str.equals("asInterface")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -594356707:
                    if (str.equals("getPurchaseHistory")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -573310373:
                    if (str.equals("getSkuDetails")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                clsArr = new Class[]{IBinder.class};
            } else if (c2 == 1) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
            } else if (c2 == 2) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class};
            } else if (c2 == 3) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
            } else if (c2 == 4) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
            }
            method = cls.getDeclaredMethod(str, clsArr);
            hashMap.put(str, method);
            return method;
        } catch (NoSuchMethodException unused) {
            return method;
        }
    }

    private static ArrayList<String> f(Context context, Object obj, String str) {
        ArrayList<String> stringArrayList;
        ArrayList<String> arrayList = new ArrayList<>();
        if (o(context, obj, str).booleanValue()) {
            String str2 = null;
            int i2 = 0;
            boolean z = false;
            do {
                Object n = n(context, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", obj, new Object[]{6, c, str, str2, new Bundle()});
                if (n != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) n;
                    if (bundle.getInt("RESPONSE_CODE") == 0 && (stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST")) != null) {
                        Iterator<String> it = stringArrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                z = true;
                                break;
                            }
                            arrayList.add(next);
                            i2++;
                        }
                        str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                        if (i2 < 30 || str2 == null) {
                            break;
                            break;
                        }
                    }
                }
                str2 = null;
                if (i2 < 30) {
                    break;
                }
            } while (!z);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> g(Context context, Object obj) {
        Class<?> d2;
        ArrayList<String> arrayList = new ArrayList<>();
        return (obj == null || (d2 = d(context, "com.android.vending.billing.IInAppBillingService")) == null || e(d2, "getPurchaseHistory") == null) ? arrayList : c(f(context, obj, BillingClient.SkuType.INAPP));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c A[EDGE_INSN: B:21:0x005c->B:19:0x005c ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList<java.lang.String> h(android.content.Context r9, java.lang.Object r10, java.lang.String r11) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r10 != 0) goto L8
            return r0
        L8:
            java.lang.Boolean r1 = o(r9, r10, r11)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L5c
            r1 = 0
            r2 = 0
            r3 = r2
            r4 = 0
        L16:
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r5[r1] = r7
            r7 = 1
            java.lang.String r8 = com.facebook.appevents.internal.h.c
            r5[r7] = r8
            r7 = 2
            r5[r7] = r11
            r5[r6] = r3
            java.lang.String r3 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r6 = "getPurchases"
            java.lang.Object r3 = n(r9, r3, r6, r10, r5)
            if (r3 == 0) goto L55
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.lang.String r5 = "RESPONSE_CODE"
            int r5 = r3.getInt(r5)
            if (r5 != 0) goto L55
            java.lang.String r5 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r5 = r3.getStringArrayList(r5)
            if (r5 == 0) goto L5c
            int r6 = r5.size()
            int r4 = r4 + r6
            r0.addAll(r5)
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r5)
            goto L56
        L55:
            r3 = r2
        L56:
            r5 = 30
            if (r4 >= r5) goto L5c
            if (r3 != 0) goto L16
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.h.h(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> i(Context context, Object obj) {
        return c(h(context, obj, BillingClient.SkuType.INAPP));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> j(Context context, Object obj) {
        return c(h(context, obj, "subs"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> k(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map<String, String> p = p(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!p.containsKey(next)) {
                arrayList2.add(next);
            }
        }
        p.putAll(l(context, arrayList2, obj, z));
        return p;
    }

    private static Map<String, String> l(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        HashMap hashMap = new HashMap();
        if (obj != null && !arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Object[] objArr = new Object[4];
            objArr[0] = 3;
            objArr[1] = c;
            objArr[2] = z ? "subs" : BillingClient.SkuType.INAPP;
            objArr[3] = bundle;
            Object n = n(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", obj, objArr);
            if (n != null) {
                Bundle bundle2 = (Bundle) n;
                if (bundle2.getInt("RESPONSE_CODE") == 0) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            hashMap.put(arrayList.get(i2), stringArrayList.get(i2));
                        }
                    }
                    q(hashMap);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m(String str) {
        try {
            String optString = new JSONObject(str).optString("freeTrialPeriod");
            if (optString != null) {
                return !optString.isEmpty();
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }

    @Nullable
    private static Object n(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method e2;
        Class<?> d2 = d(context, str);
        if (d2 == null || (e2 = e(d2, str2)) == null) {
            return null;
        }
        if (obj != null) {
            obj = d2.cast(obj);
        }
        try {
            return e2.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private static Boolean o(Context context, Object obj, String str) {
        if (obj == null) {
            return Boolean.FALSE;
        }
        boolean z = false;
        Object n = n(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", obj, new Object[]{3, c, str});
        if (n != null && ((Integer) n).intValue() == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private static Map<String, String> p(ArrayList<String> arrayList) {
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String string = f2315d.getString(next, null);
            if (string != null) {
                String[] split = string.split(";", 2);
                if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                    hashMap.put(next, split[1]);
                }
            }
        }
        return hashMap;
    }

    private static void q(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor edit = f2315d.edit();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            edit.putString(entry.getKey(), currentTimeMillis + ";" + entry.getValue());
        }
        edit.apply();
    }
}
