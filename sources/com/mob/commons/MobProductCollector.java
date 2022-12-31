package com.mob.commons;

import android.os.SystemClock;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes2.dex */
public class MobProductCollector implements PublicMemberKeeper {
    public static final String[] MOB_PRODUCTS = {ShareSDK.SDK_TAG, "SMSSDK", "MOBLINK", "MOBPUSH", "SECVERIFY", "MOBADSDK", "MOBGUARD", "GESVERIFY", "MOBAPM"};
    public static final String[] MOB_PRODUCTS_DEPRECATED = {"SHAREREC", "MOBAPI", "UMSSDK", "CMSSDK", "BBSSDK", "SHOPSDK", "PAYSDK", "MOBIM", "ANALYSDK", "MOBVERIFY"};
    public static final String[] MOB_SOLUTIONS = {"GROWSOLUTION"};
    private static boolean a = false;
    private static final HashMap<String, MobProduct> b = new HashMap<>();
    private static final HashMap<String, MobSolution> c = new HashMap<>();

    private static HashMap<String, MobProduct> a() {
        Class<?> cls;
        HashMap<String, MobProduct> hashMap = new HashMap<>();
        for (Object obj : f.a) {
            try {
                if (obj instanceof String) {
                    cls = Class.forName(String.valueOf(obj).trim());
                } else {
                    cls = (Class) obj;
                }
                int i2 = 0;
                if (MobProduct.class.isAssignableFrom(cls) && !MobProduct.class.equals(cls)) {
                    MobProduct mobProduct = (MobProduct) cls.newInstance();
                    String productTag = mobProduct.getProductTag();
                    String[] strArr = MOB_PRODUCTS;
                    int length = strArr.length;
                    while (true) {
                        if (i2 < length) {
                            String str = strArr[i2];
                            if (str.equals(productTag)) {
                                hashMap.put(str, mobProduct);
                                break;
                            }
                            i2++;
                        }
                    }
                } else if (MobSolution.class.isAssignableFrom(cls) && !MobSolution.class.equals(cls)) {
                    MobSolution mobSolution = (MobSolution) cls.newInstance();
                    String solutionTag = mobSolution.getSolutionTag();
                    String[] strArr2 = MOB_SOLUTIONS;
                    int length2 = strArr2.length;
                    while (true) {
                        if (i2 < length2) {
                            String str2 = strArr2[i2];
                            if (str2.equals(solutionTag)) {
                                c.put(str2, mobSolution);
                                break;
                            }
                            i2++;
                        }
                    }
                } else {
                    cls.newInstance();
                }
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }
        return hashMap;
    }

    private static String b() {
        return a(40);
    }

    public static synchronized void collect() {
        synchronized (MobProductCollector.class) {
            getProducts();
        }
    }

    public static synchronized ArrayList<MobProduct> getProducts() {
        ArrayList<MobProduct> arrayList;
        synchronized (MobProductCollector.class) {
            if (!a) {
                b.putAll(a());
                a = true;
            }
            arrayList = new ArrayList<>();
            arrayList.addAll(b.values());
        }
        return arrayList;
    }

    public static synchronized String getUserIdentity() {
        String userIdentity;
        synchronized (MobProductCollector.class) {
            userIdentity = getUserIdentity(getProducts());
        }
        return userIdentity;
    }

    public static synchronized boolean registerProduct(MobProduct mobProduct) {
        synchronized (MobProductCollector.class) {
            if (mobProduct != null) {
                HashMap<String, MobProduct> hashMap = b;
                if (!hashMap.containsKey(mobProduct.getProductTag())) {
                    hashMap.put(mobProduct.getProductTag(), mobProduct);
                    return true;
                }
            }
            return false;
        }
    }

    public static void syncInit() {
        try {
            MOBLINK moblink = new MOBLINK();
            if (moblink instanceof MobProduct) {
                moblink.getProductTag();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00cb A[Catch: all -> 0x0274, TryCatch #1 {all -> 0x0274, blocks: (B:4:0x0003, B:6:0x008b, B:9:0x0092, B:11:0x009b, B:13:0x00cb, B:14:0x00df, B:16:0x013c, B:35:0x019f, B:37:0x01ab, B:38:0x01b7, B:40:0x01bd, B:45:0x01fe, B:47:0x020a, B:48:0x021b, B:10:0x0097), top: B:61:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x013c A[Catch: all -> 0x0274, TRY_LEAVE, TryCatch #1 {all -> 0x0274, blocks: (B:4:0x0003, B:6:0x008b, B:9:0x0092, B:11:0x009b, B:13:0x00cb, B:14:0x00df, B:16:0x013c, B:35:0x019f, B:37:0x01ab, B:38:0x01b7, B:40:0x01bd, B:45:0x01fe, B:47:0x020a, B:48:0x021b, B:10:0x0097), top: B:61:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ab A[Catch: all -> 0x0274, TryCatch #1 {all -> 0x0274, blocks: (B:4:0x0003, B:6:0x008b, B:9:0x0092, B:11:0x009b, B:13:0x00cb, B:14:0x00df, B:16:0x013c, B:35:0x019f, B:37:0x01ab, B:38:0x01b7, B:40:0x01bd, B:45:0x01fe, B:47:0x020a, B:48:0x021b, B:10:0x0097), top: B:61:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x020a A[Catch: all -> 0x0274, TryCatch #1 {all -> 0x0274, blocks: (B:4:0x0003, B:6:0x008b, B:9:0x0092, B:11:0x009b, B:13:0x00cb, B:14:0x00df, B:16:0x013c, B:35:0x019f, B:37:0x01ab, B:38:0x01b7, B:40:0x01bd, B:45:0x01fe, B:47:0x020a, B:48:0x021b, B:10:0x0097), top: B:61:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.lang.String getUserIdentity(java.util.ArrayList<com.mob.commons.MobProduct> r18) {
        /*
            Method dump skipped, instructions count: 643
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.MobProductCollector.getUserIdentity(java.util.ArrayList):java.lang.String");
    }

    private static String a(int i2) {
        long currentTimeMillis = System.currentTimeMillis() ^ SystemClock.elapsedRealtime();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(currentTimeMillis);
        Random random = new Random();
        for (int i3 = 0; i3 < i2; i3++) {
            if ("char".equalsIgnoreCase(random.nextInt(2) % 2 == 0 ? "char" : "num")) {
                stringBuffer.insert(i3 + 1, (char) (random.nextInt(26) + 97));
            } else {
                stringBuffer.insert(stringBuffer.length(), random.nextInt(10));
            }
        }
        return stringBuffer.toString().substring(0, 40);
    }
}
