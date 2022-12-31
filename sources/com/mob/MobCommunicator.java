package com.mob;

import android.util.Base64;
import com.mob.commons.MobProductCollector;
import com.mob.commons.b;
import com.mob.commons.b.a;
import com.mob.commons.j;
import com.mob.tools.MobLog;
import com.mob.tools.RxMob;
import com.mob.tools.log.NLog;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.StringPart;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import com.tencent.bugly.BuglyStrategy;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes2.dex */
public final class MobCommunicator implements PublicMemberKeeper {
    private BigInteger b;
    private BigInteger c;

    /* renamed from: d  reason: collision with root package name */
    private MobRSA f5832d;

    /* renamed from: g  reason: collision with root package name */
    private NetworkHelper.NetworkTimeOut f5835g;
    private Random a = new Random();

    /* renamed from: e  reason: collision with root package name */
    private Hashon f5833e = new Hashon();

    /* renamed from: f  reason: collision with root package name */
    private NetworkHelper f5834f = new NetworkHelper();

    /* loaded from: classes2.dex */
    public static class Callback<T> implements PublicMemberKeeper {
        public void onResultError(Throwable th) {
        }

        public void onResultOk(T t) {
        }
    }

    /* loaded from: classes2.dex */
    public static class NetworkError extends Exception implements PublicMemberKeeper {
        private static final long serialVersionUID = -8447657431687664787L;

        public NetworkError(String str) {
            super(str);
        }
    }

    public MobCommunicator(int i2, String str, String str2) {
        this.f5832d = new MobRSA(i2);
        this.b = new BigInteger(str, 16);
        this.c = new BigInteger(str2, 16);
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        this.f5835g = networkTimeOut;
        networkTimeOut.readTimout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        networkTimeOut.connectionTimeout = 5000;
    }

    public <T> void request(HashMap<String, Object> hashMap, String str, boolean z, Callback<T> callback) {
        request(true, null, hashMap, str, z, callback);
    }

    public <T> T requestSynchronized(HashMap<String, Object> hashMap, String str, boolean z) throws Throwable {
        return (T) requestSynchronized((HashMap<String, String>) null, hashMap, str, z);
    }

    public <T> void request(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z, Callback<T> callback) {
        request(true, hashMap, hashMap2, str, z, callback);
    }

    public <T> T requestSynchronized(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z) throws Throwable {
        return (T) requestSynchronized(true, hashMap, hashMap2, str, z);
    }

    public <T> void request(final boolean z, final HashMap<String, String> hashMap, final HashMap<String, Object> hashMap2, final String str, final boolean z2, final Callback<T> callback) {
        RxMob.create(new RxMob.QuickSubscribe<T>() { // from class: com.mob.MobCommunicator.1
            @Override // com.mob.tools.RxMob.QuickSubscribe
            protected void doNext(RxMob.Subscriber<T> subscriber) throws Throwable {
                subscriber.onNext(!b.G() ? MobCommunicator.this.requestSynchronized(z, hashMap, hashMap2, str, z2) : null);
            }
        }).subscribeOnNewThreadAndObserveOnUIThread(new RxMob.Subscriber<T>() { // from class: com.mob.MobCommunicator.2
            @Override // com.mob.tools.RxMob.Subscriber
            public void onError(Throwable th) {
                callback.onResultError(th);
            }

            @Override // com.mob.tools.RxMob.Subscriber
            public void onNext(T t) {
                callback.onResultOk(t);
            }
        });
    }

    public <T> T requestSynchronized(String str, String str2, boolean z) throws Throwable {
        return (T) requestSynchronized((HashMap<String, String>) null, str, str2, z);
    }

    private byte[] a(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new GZIPOutputStream(byteArrayOutputStream));
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public <T> T requestSynchronized(HashMap<String, String> hashMap, String str, String str2, boolean z) throws Throwable {
        return (T) requestSynchronized(true, hashMap, str, str2, z);
    }

    public <T> T requestSynchronized(boolean z, HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z2) throws Throwable {
        String str2;
        if (hashMap2 != null) {
            String fromHashMap = this.f5833e.fromHashMap(hashMap2);
            if (fromHashMap.length() != 0) {
                str2 = fromHashMap;
                return (T) requestSynchronized(z, hashMap, str2, str, z2);
            }
        }
        str2 = "{}";
        return (T) requestSynchronized(z, hashMap, str2, str, z2);
    }

    public <T> T requestSynchronized(boolean z, HashMap<String, String> hashMap, String str, String str2, boolean z2) throws Throwable {
        byte[] a = a();
        String a2 = a(a, str, z2);
        ArrayList<KVPair<String>> a3 = a(z, hashMap, str, a2.getBytes("utf-8").length);
        String[] strArr = new String[1];
        HttpResponseCallback a4 = a(a, strArr);
        StringPart stringPart = new StringPart();
        stringPart.append(a2);
        NLog mobLog = MobLog.getInstance();
        mobLog.d(">>>  request: " + str + "\nurl = " + str2 + "\nheader = " + a3.toString(), new Object[0]);
        this.f5834f.rawPost(str2, a3, stringPart, -1, a4, this.f5835g);
        if (strArr[0] != null) {
            NLog mobLog2 = MobLog.getInstance();
            mobLog2.d(">>> response: " + strArr[0], new Object[0]);
            return (T) a(strArr[0]);
        }
        return null;
    }

    private byte[] a() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        this.a.setSeed(System.currentTimeMillis());
        dataOutputStream.writeLong(this.a.nextLong());
        dataOutputStream.writeLong(this.a.nextLong());
        dataOutputStream.flush();
        dataOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private String a(byte[] bArr, String str, boolean z) throws Throwable {
        byte[] bytes = str.getBytes("utf-8");
        if (z) {
            bytes = a(bytes);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        byte[] encode = this.f5832d.encode(bArr, this.b, this.c);
        dataOutputStream.writeInt(encode.length);
        dataOutputStream.write(encode);
        byte[] AES128Encode = Data.AES128Encode(bArr, bytes);
        dataOutputStream.writeInt(AES128Encode.length);
        dataOutputStream.write(AES128Encode);
        dataOutputStream.flush();
        dataOutputStream.close();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    private ArrayList<KVPair<String>> a(boolean z, HashMap<String, String> hashMap, String str, int i2) throws Throwable {
        ArrayList<KVPair<String>> a = z ? a(str, i2) : null;
        if (a == null) {
            a = new ArrayList<>();
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                if (entry != null) {
                    a.add(new KVPair<>(entry.getKey(), entry.getValue()));
                }
            }
        }
        return a;
    }

    private ArrayList<KVPair<String>> a(String str, int i2) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("sign", Data.MD5(str + MobSDK.getAppSecret())));
        arrayList.add(new KVPair<>("key", MobSDK.getAppkey()));
        arrayList.add(new KVPair<>(HttpRequest.HEADER_CONTENT_LENGTH, String.valueOf(i2)));
        arrayList.add(new KVPair<>("User-Identity", MobProductCollector.getUserIdentity()));
        arrayList.add(new KVPair<>(j.a(68), a.c(MobSDK.getContext())));
        return arrayList;
    }

    private HttpResponseCallback a(final byte[] bArr, final String[] strArr) {
        return new HttpResponseCallback() { // from class: com.mob.MobCommunicator.3
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                int responseCode = httpConnection.getResponseCode();
                InputStream inputStream = responseCode == 200 ? httpConnection.getInputStream() : httpConnection.getErrorStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[1024];
                for (int read = inputStream.read(bArr2); read != -1; read = inputStream.read(bArr2)) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                inputStream.close();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (responseCode == 200) {
                    long a = MobCommunicator.this.a(httpConnection);
                    if (a != -1 && a == byteArray.length) {
                        strArr[0] = MobCommunicator.this.a(bArr, byteArray);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("httpStatus", Integer.valueOf(responseCode));
                    hashMap.put("status", -2);
                    hashMap.put("error", "Illegal content length");
                    throw new NetworkError(MobCommunicator.this.f5833e.fromHashMap(hashMap));
                }
                HashMap fromJson = MobCommunicator.this.f5833e.fromJson(new String(byteArray, "utf-8"));
                fromJson.put("httpStatus", Integer.valueOf(responseCode));
                throw new NetworkError(MobCommunicator.this.f5833e.fromHashMap(fromJson));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(HttpConnection httpConnection) throws Throwable {
        List<String> a = a(httpConnection, HttpRequest.HEADER_CONTENT_LENGTH);
        if (a == null || a.size() <= 0) {
            return -1L;
        }
        return Long.parseLong(a.get(0));
    }

    private List<String> a(HttpConnection httpConnection, String str) throws Throwable {
        Map<String, List<String>> headerFields = httpConnection.getHeaderFields();
        if (headerFields == null || headerFields.isEmpty()) {
            return null;
        }
        for (String str2 : headerFields.keySet()) {
            if (str2 != null && str2.equals(str)) {
                return headerFields.get(str2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(byte[] bArr, byte[] bArr2) throws Throwable {
        return new String(Data.AES128Decode(bArr, Base64.decode(bArr2, 2)), "utf-8");
    }

    private Object a(String str) throws Throwable {
        if (str != null) {
            HashMap fromJson = this.f5833e.fromJson(str.trim());
            if (!fromJson.isEmpty()) {
                Object obj = fromJson.get("res");
                return obj == null ? fromJson.get("data") : obj;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("status", -1);
            hashMap.put("error", "response is empty");
            throw new NetworkError(this.f5833e.fromHashMap(hashMap));
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("status", -1);
        hashMap2.put("error", "response is empty");
        throw new NetworkError(this.f5833e.fromHashMap(hashMap2));
    }
}
