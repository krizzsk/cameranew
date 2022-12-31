package com.mob.commons;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.ResHelper;
import com.tencent.bugly.BuglyStrategy;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: TokenFetcher.java */
/* loaded from: classes2.dex */
public class k {
    private static final String a = i.b() + "/openid";
    private static k b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private DeviceHelper f5883d;

    /* renamed from: e  reason: collision with root package name */
    private Context f5884e;

    /* renamed from: f  reason: collision with root package name */
    private TreeMap<String, Object> f5885f;

    private k() {
        Context context = MobSDK.getContext();
        this.f5884e = context;
        this.f5883d = DeviceHelper.getInstance(context);
    }

    public static k a() {
        if (b == null) {
            synchronized (k.class) {
                if (b == null) {
                    b = new k();
                }
            }
        }
        return b;
    }

    private String c() {
        this.f5885f = new TreeMap<>();
        String str = null;
        try {
            String k2 = k();
            boolean a2 = a(l());
            NLog mobLog = MobLog.getInstance();
            mobLog.d("[%s] %s", "TokenFetcher", "cachedToken: " + k2);
            if (TextUtils.isEmpty(k2)) {
                str = a(this.f5885f);
            } else {
                NLog mobLog2 = MobLog.getInstance();
                mobLog2.d("[%s] %s", "TokenFetcher", "isChanged: " + a2);
                str = !a2 ? k2 : a(this.f5885f);
            }
            b.c = str;
        } catch (Throwable th) {
            MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Sync token from cache & net error");
        }
        return str;
    }

    private long d() {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = this.f5884e.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo(this.f5883d.getPackageName(), 0)) == null || Build.VERSION.SDK_INT < 9) {
                return 0L;
            }
            return packageInfo.firstInstallTime;
        } catch (Throwable th) {
            MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Get ins time error");
            return 0L;
        }
    }

    private String e() {
        String f2 = f();
        if (TextUtils.isEmpty(f2) && this.f5883d.getSdcardState()) {
            f2 = g();
            if (!TextUtils.isEmpty(f2)) {
                a(f2);
            }
        }
        return f2;
    }

    private String f() {
        DataInputStream dataInputStream;
        String str;
        DataInputStream dataInputStream2 = null;
        try {
            File a2 = a(this.f5884e, ".mdid");
            if (a2 == null || !a2.exists()) {
                str = null;
            } else {
                dataInputStream = new DataInputStream(new FileInputStream(a2));
                try {
                    str = dataInputStream.readUTF();
                    dataInputStream2 = dataInputStream;
                } catch (Throwable th) {
                    th = th;
                    try {
                        MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Read mdid cache error");
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                                return null;
                            } catch (IOException e2) {
                                MobLog.getInstance().d(e2, "[%s] %s", "TokenFetcher", "Close stream error");
                                return null;
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e3) {
                                MobLog.getInstance().d(e3, "[%s] %s", "TokenFetcher", "Close stream error");
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (dataInputStream2 != null) {
                try {
                    dataInputStream2.close();
                } catch (IOException e4) {
                    MobLog.getInstance().d(e4, "[%s] %s", "TokenFetcher", "Close stream error");
                }
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
        }
    }

    private String g() {
        try {
            return Data.byteToHex(Data.SHA1(UUID.randomUUID().toString()));
        } catch (Throwable th) {
            MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Generate mdid error");
            return null;
        }
    }

    private String h() {
        return com.mob.commons.b.a.b(this.f5884e);
    }

    private String i() {
        try {
            String authorizeForOnce = DeviceAuthorizer.authorizeForOnce();
            String signMD5 = this.f5883d.getSignMD5();
            return Data.byteToHex(Data.SHA1(authorizeForOnce + signMD5));
        } catch (Throwable th) {
            MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Generate mvaid error");
            return null;
        }
    }

    private String j() {
        try {
            String packageName = this.f5883d.getPackageName();
            String uuid = UUID.randomUUID().toString();
            return Data.byteToHex(Data.SHA1(packageName + uuid));
        } catch (Throwable th) {
            MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Generate mvaid error");
            return null;
        }
    }

    private String k() {
        DataInputStream dataInputStream;
        String str;
        DataInputStream dataInputStream2 = null;
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(this.f5884e, ".optn");
            if (dataCacheFile == null || !dataCacheFile.exists()) {
                str = null;
            } else {
                dataInputStream = new DataInputStream(new FileInputStream(dataCacheFile));
                try {
                    str = dataInputStream.readUTF();
                    dataInputStream2 = dataInputStream;
                } catch (Throwable th) {
                    th = th;
                    try {
                        MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Read token cache error");
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                                return null;
                            } catch (IOException e2) {
                                MobLog.getInstance().d(e2, "[%s] %s", "TokenFetcher", "Close stream error");
                                return null;
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException e3) {
                                MobLog.getInstance().d(e3, "[%s] %s", "TokenFetcher", "Close stream error");
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (dataInputStream2 != null) {
                try {
                    dataInputStream2.close();
                } catch (IOException e4) {
                    MobLog.getInstance().d(e4, "[%s] %s", "TokenFetcher", "Close stream error");
                }
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
        }
    }

    private HashMap<String, Object> l() {
        FileChannel fileChannel;
        HashMap<String, Object> hashMap;
        FileChannel fileChannel2 = null;
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(this.f5884e, ".opdn");
            if (dataCacheFile == null || !dataCacheFile.exists()) {
                hashMap = null;
            } else {
                fileChannel = new FileInputStream(dataCacheFile).getChannel();
                try {
                    ByteBuffer allocate = ByteBuffer.allocate((int) fileChannel.size());
                    while (fileChannel.read(allocate) > 0) {
                    }
                    hashMap = a("1234567890abcdfi", allocate.array());
                    fileChannel2 = fileChannel;
                } catch (Throwable th) {
                    th = th;
                    try {
                        MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Read openid cache error");
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                                return null;
                            } catch (IOException e2) {
                                MobLog.getInstance().d(e2, "[%s] %s", "TokenFetcher", "Close stream error");
                                return null;
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException e3) {
                                MobLog.getInstance().d(e3, "[%s] %s", "TokenFetcher", "Close stream error");
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (fileChannel2 != null) {
                try {
                    fileChannel2.close();
                } catch (IOException e4) {
                    MobLog.getInstance().d(e4, "[%s] %s", "TokenFetcher", "Close stream error");
                }
            }
            return hashMap;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    public String b() {
        if (b.O()) {
            NLog mobLog = MobLog.getInstance();
            mobLog.d("[%s] %s", "TokenFetcher", "Mem token: " + this.c);
            if (TextUtils.isEmpty(this.c)) {
                synchronized (k.class) {
                    if (TextUtils.isEmpty(this.c)) {
                        return c();
                    }
                }
            }
            return this.c;
        }
        return null;
    }

    private boolean a(HashMap<String, Object> hashMap) {
        String MD5;
        String j2;
        ArrayList arrayList;
        String[] queryIMEI;
        String[] queryIMSI;
        Object obj;
        Object obj2;
        ArrayList<HashMap<String, String>> ia;
        String str;
        Object obj3;
        Object obj4;
        String str2 = "generalMd5";
        try {
            this.f5885f.put("factory", this.f5883d.getManufacturer());
            this.f5885f.put(BigAlbumStore.PhotoTagColumns.MODEL, this.f5883d.getModel());
            this.f5885f.put("sysver", Integer.valueOf(this.f5883d.getOSVersionInt()));
            this.f5885f.put("imei", this.f5883d.getIMEI());
            this.f5885f.put("serialNo", this.f5883d.getSerialno());
            this.f5885f.put("adsid", this.f5883d.getAdvertisingID());
            this.f5885f.put("pkg", this.f5883d.getPackageName());
            this.f5885f.put("appver", this.f5883d.getAppVersionName());
            long q = h.q();
            if (q > 0) {
                this.f5885f.put("firstLaunchTime", Long.valueOf(q));
            }
            long d2 = d();
            if (d2 > 0) {
                this.f5885f.put("appInstallTime", Long.valueOf(d2));
            }
            this.f5885f.put("deviceId", this.f5883d.getDeviceKey());
            this.f5885f.put("duid", DeviceAuthorizer.authorizeForOnce());
            this.f5885f.put("androidId", this.f5883d.getAndroidID());
            String e2 = e();
            if (!TextUtils.isEmpty(e2)) {
                this.f5885f.put("mdId", e2);
            }
            MD5 = Data.MD5(new JSONObject(this.f5885f).toString());
            String h2 = h();
            if (!TextUtils.isEmpty(h2)) {
                this.f5885f.put("moId", h2);
            }
            String i2 = i();
            if (!TextUtils.isEmpty(i2)) {
                this.f5885f.put("mvaId", i2);
            }
            if (hashMap != null && !hashMap.isEmpty()) {
                j2 = (String) hashMap.get("maaid");
            } else {
                j2 = j();
            }
            if (!TextUtils.isEmpty(j2)) {
                this.f5885f.put("maaId", j2);
            }
            HashMap<String, String> listNetworkHardware = this.f5883d.listNetworkHardware();
            arrayList = new ArrayList();
            if (listNetworkHardware != null && !listNetworkHardware.isEmpty()) {
                for (Map.Entry<String, String> entry : listNetworkHardware.entrySet()) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("ss", entry.getKey());
                    hashMap2.put("mac", entry.getValue());
                    arrayList.add(hashMap2);
                }
                this.f5885f.put("macArray", arrayList);
            }
            queryIMEI = this.f5883d.queryIMEI();
            if (queryIMEI != null && queryIMEI.length > 0) {
                this.f5885f.put("imeiArray", queryIMEI);
            }
            queryIMSI = this.f5883d.queryIMSI();
            if (queryIMSI != null) {
                obj = "pkg";
                if (queryIMSI.length > 0) {
                    this.f5885f.put("imsiArray", queryIMSI);
                }
            } else {
                obj = "pkg";
            }
            obj2 = "mac";
            ia = this.f5883d.getIA(false);
        } catch (Throwable th) {
            th = th;
            str2 = "[%s] %s";
        }
        try {
            if (ia != null) {
                if (!ia.isEmpty()) {
                    str = "[%s] %s";
                    try {
                        this.f5885f.put("al", ia);
                        TreeMap<String, Object> treeMap = new TreeMap<>();
                        treeMap.put("generalMd5", MD5);
                        treeMap.put("maaid", j2);
                        treeMap.put("macArray", arrayList);
                        treeMap.put("imeiArray", queryIMEI);
                        treeMap.put("imsiArray", queryIMSI);
                        treeMap.put("al", ia);
                        b(treeMap);
                        if (hashMap == null && !hashMap.isEmpty()) {
                            if (!MD5.equals((String) hashMap.get("generalMd5"))) {
                                MobLog.getInstance().d(str, "TokenFetcher", "generalMd5 changed");
                                return true;
                            }
                            String str3 = str;
                            ArrayList arrayList2 = (ArrayList) hashMap.get("macArray");
                            if (!arrayList.isEmpty()) {
                                if (arrayList2 != null && !arrayList2.isEmpty()) {
                                    if (arrayList2.size() != arrayList.size()) {
                                        MobLog.getInstance().d(str3, "TokenFetcher", "macArray changed");
                                        return true;
                                    }
                                    ArrayList arrayList3 = new ArrayList();
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        HashMap hashMap3 = (HashMap) it.next();
                                        if (hashMap3 == null || hashMap3.isEmpty()) {
                                            obj4 = obj2;
                                        } else {
                                            obj4 = obj2;
                                            arrayList3.add(hashMap3.get(obj4));
                                        }
                                        obj2 = obj4;
                                    }
                                    Object obj5 = obj2;
                                    ArrayList arrayList4 = new ArrayList();
                                    Iterator it2 = arrayList2.iterator();
                                    while (it2.hasNext()) {
                                        HashMap hashMap4 = (HashMap) it2.next();
                                        if (hashMap4 != null && !hashMap4.isEmpty()) {
                                            arrayList4.add(hashMap4.get(obj5));
                                        }
                                    }
                                    Iterator it3 = arrayList3.iterator();
                                    while (it3.hasNext()) {
                                        if (!arrayList4.contains((String) it3.next())) {
                                            MobLog.getInstance().d(str3, "TokenFetcher", "macArray changed");
                                            return true;
                                        }
                                    }
                                }
                                MobLog.getInstance().d(str3, "TokenFetcher", "macArray changed");
                                return true;
                            }
                            ArrayList arrayList5 = (ArrayList) hashMap.get("imeiArray");
                            if (queryIMEI != null && queryIMEI.length > 0) {
                                if (arrayList5 != null && !arrayList5.isEmpty()) {
                                    if (arrayList5.size() != queryIMEI.length) {
                                        MobLog.getInstance().d(str3, "TokenFetcher", "imeiArray changed");
                                        return true;
                                    }
                                    for (String str4 : queryIMEI) {
                                        if (!arrayList5.contains(str4)) {
                                            MobLog.getInstance().d(str3, "TokenFetcher", "imeiArray changed");
                                            return true;
                                        }
                                    }
                                }
                                MobLog.getInstance().d(str3, "TokenFetcher", "imeiArray changed");
                                return true;
                            }
                            ArrayList arrayList6 = (ArrayList) hashMap.get("imsiArray");
                            if (queryIMSI != null && queryIMSI.length > 0) {
                                if (arrayList6 != null && !arrayList6.isEmpty()) {
                                    if (arrayList6.size() != queryIMSI.length) {
                                        MobLog.getInstance().d(str3, "TokenFetcher", "imsiArray changed");
                                        return true;
                                    }
                                    for (String str5 : queryIMSI) {
                                        if (!arrayList6.contains(str5)) {
                                            MobLog.getInstance().d(str3, "TokenFetcher", "imsiArray changed");
                                            return true;
                                        }
                                    }
                                }
                                MobLog.getInstance().d(str3, "TokenFetcher", "imsiArray changed");
                                return true;
                            }
                            ArrayList arrayList7 = (ArrayList) hashMap.get("al");
                            if (ia != null && !ia.isEmpty()) {
                                if (arrayList7 != null && !arrayList7.isEmpty()) {
                                    if (arrayList7.size() != ia.size()) {
                                        MobLog.getInstance().d(str3, "TokenFetcher", "al changed");
                                        return true;
                                    }
                                    ArrayList arrayList8 = new ArrayList();
                                    Iterator<HashMap<String, String>> it4 = ia.iterator();
                                    while (it4.hasNext()) {
                                        HashMap<String, String> next = it4.next();
                                        if (next == null || next.isEmpty()) {
                                            obj3 = obj;
                                        } else {
                                            obj3 = obj;
                                            arrayList8.add(next.get(obj3));
                                        }
                                        obj = obj3;
                                    }
                                    Object obj6 = obj;
                                    ArrayList arrayList9 = new ArrayList();
                                    Iterator it5 = arrayList7.iterator();
                                    while (it5.hasNext()) {
                                        HashMap hashMap5 = (HashMap) it5.next();
                                        if (hashMap5 != null && !hashMap5.isEmpty()) {
                                            arrayList9.add(hashMap5.get(obj6));
                                        }
                                    }
                                    Iterator it6 = arrayList8.iterator();
                                    while (it6.hasNext()) {
                                        if (!arrayList9.contains((String) it6.next())) {
                                            MobLog.getInstance().d(str3, "TokenFetcher", "al changed");
                                            return true;
                                        }
                                    }
                                }
                                MobLog.getInstance().d(str3, "TokenFetcher", "al changed");
                                return true;
                            }
                            MobLog.getInstance().d(str3, "TokenFetcher", "No changes");
                            return false;
                        }
                        MobLog.getInstance().d(str, "TokenFetcher", "No openids cache, treat as changed");
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = str;
                        MobLog.getInstance().e(th, str2, "TokenFetcher", "Fetch token from server error.");
                        return false;
                    }
                }
            }
            if (hashMap == null) {
            }
            MobLog.getInstance().d(str, "TokenFetcher", "No openids cache, treat as changed");
            return true;
        } catch (Throwable th3) {
            th = th3;
            MobLog.getInstance().e(th, str2, "TokenFetcher", "Fetch token from server error.");
            return false;
        }
        str = "[%s] %s";
        TreeMap<String, Object> treeMap2 = new TreeMap<>();
        treeMap2.put("generalMd5", MD5);
        treeMap2.put("maaid", j2);
        treeMap2.put("macArray", arrayList);
        treeMap2.put("imeiArray", queryIMEI);
        treeMap2.put("imsiArray", queryIMSI);
        treeMap2.put("al", ia);
        b(treeMap2);
    }

    private String b(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        Random random = new Random();
        dataOutputStream.writeLong(random.nextLong());
        dataOutputStream.writeLong(random.nextLong());
        dataOutputStream.flush();
        dataOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new GZIPOutputStream(byteArrayOutputStream2));
        bufferedOutputStream.write(str.getBytes("utf-8"));
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        byte[] AES128Encode = Data.AES128Encode(byteArray, byteArrayOutputStream2.toByteArray());
        byte[] encode = new MobRSA(1024).encode(byteArray, new BigInteger("ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", 16), new BigInteger("191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", 16));
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream3);
        dataOutputStream2.writeInt(encode.length);
        dataOutputStream2.write(encode);
        dataOutputStream2.writeInt(AES128Encode.length);
        dataOutputStream2.write(AES128Encode);
        dataOutputStream2.flush();
        dataOutputStream2.close();
        return Base64.encodeToString(byteArrayOutputStream3.toByteArray(), 2);
    }

    private void c(String str) {
        MobLog.getInstance().d("[%s] %s", "TokenFetcher", "Write token cache");
        DataOutputStream dataOutputStream = null;
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(this.f5884e, ".optn");
            if (dataCacheFile != null) {
                DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(dataCacheFile));
                try {
                    dataOutputStream2.writeUTF(str);
                    dataOutputStream = dataOutputStream2;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    try {
                        MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Cache token error");
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.flush();
                                dataOutputStream.close();
                                return;
                            } catch (IOException e2) {
                                MobLog.getInstance().d(e2, "[%s] %s", "TokenFetcher", "Close stream error");
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (IOException e3) {
                                MobLog.getInstance().d(e3, "[%s] %s", "TokenFetcher", "Close stream error");
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (IOException e4) {
                    MobLog.getInstance().d(e4, "[%s] %s", "TokenFetcher", "Close stream error");
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void b(TreeMap<String, Object> treeMap) {
        FileChannel fileChannel = null;
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(this.f5884e, ".opdn");
            byte[] a2 = a("1234567890abcdfi", treeMap);
            if (a2 != null && a2.length > 0) {
                fileChannel = new FileOutputStream(dataCacheFile).getChannel();
                fileChannel.write(ByteBuffer.wrap(a2));
                fileChannel.force(true);
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e2) {
                    MobLog.getInstance().d(e2, "[%s] %s", "TokenFetcher", "Close stream error");
                }
            }
        } catch (Throwable th) {
            try {
                MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Write openid cache error");
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e3) {
                        MobLog.getInstance().d(e3, "[%s] %s", "TokenFetcher", "Close stream error");
                    }
                }
            } catch (Throwable th2) {
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e4) {
                        MobLog.getInstance().d(e4, "[%s] %s", "TokenFetcher", "Close stream error");
                    }
                }
                throw th2;
            }
        }
    }

    private void a(String str) {
        DataOutputStream dataOutputStream = null;
        try {
            File a2 = a(this.f5884e, ".mdid");
            if (a2 != null && a2.exists()) {
                DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(a2));
                try {
                    dataOutputStream2.writeUTF(str);
                    dataOutputStream = dataOutputStream2;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    try {
                        MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Cache mdid error");
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.flush();
                                dataOutputStream.close();
                                return;
                            } catch (IOException e2) {
                                MobLog.getInstance().d(e2, "[%s] %s", "TokenFetcher", "Close stream error");
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (IOException e3) {
                                MobLog.getInstance().d(e3, "[%s] %s", "TokenFetcher", "Close stream error");
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (IOException e4) {
                    MobLog.getInstance().d(e4, "[%s] %s", "TokenFetcher", "Close stream error");
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private File a(Context context, String str) {
        try {
            if ((Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && this.f5883d.getSdcardState()) {
                String sdcardPath = this.f5883d.getSdcardPath();
                if (TextUtils.isEmpty(sdcardPath)) {
                    return null;
                }
                String str2 = sdcardPath + "/Mob/";
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str2, str);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                return file2;
            }
            return null;
        } catch (Throwable th) {
            MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Get MDID error");
            return null;
        }
    }

    private String a(TreeMap<String, Object> treeMap) {
        Object obj;
        HashMap hashMap;
        String str = null;
        if (treeMap == null || treeMap.isEmpty()) {
            return null;
        }
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("factory", treeMap.get("factory"));
            hashMap2.put(BigAlbumStore.PhotoTagColumns.MODEL, treeMap.get(BigAlbumStore.PhotoTagColumns.MODEL));
            hashMap2.put("sysver", treeMap.get("sysver"));
            hashMap2.put("imei", treeMap.get("imei"));
            hashMap2.put("serialNo", treeMap.get("serialNo"));
            hashMap2.put("adsid", treeMap.get("adsid"));
            hashMap2.put("pkg", treeMap.get("pkg"));
            hashMap2.put("appver", treeMap.get("appver"));
            hashMap2.put("firstLaunchTime", treeMap.get("firstLaunchTime"));
            hashMap2.put("appInstallTime", treeMap.get("appInstallTime"));
            hashMap2.put("deviceId", treeMap.get("deviceId"));
            hashMap2.put("duid", treeMap.get("duid"));
            hashMap2.put("mdId", treeMap.get("mdId"));
            hashMap2.put("moId", treeMap.get("moId"));
            hashMap2.put("mvaId", treeMap.get("mvaId"));
            hashMap2.put("maaId", treeMap.get("maaId"));
            hashMap2.put("androidId", treeMap.get("androidId"));
            hashMap2.put("macArray", treeMap.get("macArray"));
            hashMap2.put("imeiArray", treeMap.get("imeiArray"));
            hashMap2.put("imsiArray", treeMap.get("imsiArray"));
            hashMap2.put("al", treeMap.get("al"));
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("appkey", MobSDK.getAppkey()));
            try {
                arrayList.add(new KVPair<>("m", b(new Hashon().fromHashMap(hashMap2))));
                ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
                arrayList2.add(new KVPair<>("User-Identity", MobProductCollector.getUserIdentity()));
                arrayList2.add(new KVPair<>(j.a(68), com.mob.commons.b.a.c(MobSDK.getContext())));
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.readTimout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
                networkTimeOut.connectionTimeout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
                NetworkHelper networkHelper = new NetworkHelper();
                String str2 = a;
                String httpPost = networkHelper.httpPost(str2, arrayList, (KVPair<String>) null, arrayList2, networkTimeOut);
                NLog mobLog = MobLog.getInstance();
                obj = "[%s] %s";
                try {
                    mobLog.d(obj, "TokenFetcher", "Request: " + str2 + "\nvaluesEn: " + arrayList + "\nheaders: " + arrayList2 + "\nResponse: " + httpPost);
                    HashMap fromJson = new Hashon().fromJson(httpPost);
                    if (!"200".equals(String.valueOf(fromJson.get("code"))) || (hashMap = (HashMap) fromJson.get("data")) == null) {
                        return null;
                    }
                    String str3 = (String) hashMap.get("token");
                    try {
                        b.c = str3;
                        c(str3);
                        return str3;
                    } catch (Throwable th) {
                        th = th;
                        str = str3;
                        MobLog.getInstance().e(th, obj, "TokenFetcher", "Fetch token from server error.");
                        return str;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = "[%s] %s";
                MobLog.getInstance().e(th, obj, "TokenFetcher", "Fetch token from server error.");
                return str;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private byte[] a(String str, TreeMap<String, Object> treeMap) {
        try {
            return Data.AES128Encode(str, new JSONObject(treeMap).toString());
        } catch (Throwable th) {
            MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Encypt data error");
            return null;
        }
    }

    private HashMap<String, Object> a(String str, byte[] bArr) {
        try {
            return new Hashon().fromJson(Data.AES128Decode(str, bArr));
        } catch (Throwable th) {
            MobLog.getInstance().d(th, "[%s] %s", "TokenFetcher", "Decrypt data error");
            return new HashMap<>();
        }
    }
}
