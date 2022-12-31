package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class ht {
    public static final ht a = new ht();
    public Context b;
    public SharedPreferences c = null;

    /* renamed from: d  reason: collision with root package name */
    public SharedPreferences f7638d = null;

    /* renamed from: e  reason: collision with root package name */
    ExecutorService f7639e = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: f  reason: collision with root package name */
    private File f7640f;

    private ht() {
    }

    public static boolean a(long j2) {
        return j2 >= 3600;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        boolean z;
        long b = v.b();
        File[] listFiles = b().listFiles();
        HashMap hashMap = new HashMap();
        if (listFiles != null) {
            for (File file : listFiles) {
                hashMap.put(file.getName(), file);
            }
        }
        SharedPreferences.Editor edit = this.c.edit();
        SharedPreferences.Editor edit2 = this.f7638d.edit();
        HashMap hashMap2 = new HashMap(this.c.getAll());
        HashMap hashMap3 = new HashMap(this.f7638d.getAll());
        Iterator it = hashMap2.entrySet().iterator();
        boolean z2 = false;
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) ((Map.Entry) it.next()).getKey();
            if (!hashMap3.containsKey(str)) {
                it.remove();
                edit.remove(str);
                z2 = true;
            }
        }
        Iterator it2 = hashMap3.entrySet().iterator();
        while (it2.hasNext()) {
            String str2 = (String) ((Map.Entry) it2.next()).getKey();
            if (!hashMap2.containsKey(str2)) {
                it2.remove();
                edit2.remove(str2);
                z2 = true;
            }
        }
        Iterator it3 = hashMap2.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            String str3 = (String) entry.getKey();
            if (((Long) entry.getValue()).longValue() < b) {
                it3.remove();
                edit.remove(str3);
                edit2.remove(str3);
                z2 = true;
            } else {
                hashMap.remove(str3);
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            ((File) entry2.getValue()).delete();
        }
        if (hashMap2.size() > 30) {
            int size = hashMap2.size() - 30;
            LinkedList linkedList = new LinkedList(hashMap2.entrySet());
            Collections.sort(linkedList, new Comparator() { // from class: com.tapjoy.internal.ht.3
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((Long) ((Map.Entry) obj).getValue()).compareTo((Long) ((Map.Entry) obj2).getValue());
                }
            });
            Iterator it4 = linkedList.iterator();
            for (int i2 = 0; i2 < size && it4.hasNext(); i2++) {
                Map.Entry entry3 = (Map.Entry) it4.next();
                String str4 = (String) entry3.getKey();
                Long l2 = (Long) entry3.getValue();
                edit.remove(str4);
                edit2.remove(str4);
                a(str4).delete();
            }
        } else {
            z = z2;
        }
        if (z) {
            edit.commit();
            edit2.commit();
        }
    }

    public final void a() {
        this.f7639e.submit(new Runnable() { // from class: com.tapjoy.internal.ht.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ht.this.b == null) {
                    return;
                }
                ht.this.c();
            }
        });
    }

    final synchronized String b(URL url) {
        String str;
        String string;
        String url2 = url.toString();
        String convertToHex = TapjoyUtil.convertToHex(ch.a(url2.getBytes()));
        String string2 = this.f7638d.getString(convertToHex, null);
        if (string2 == null) {
            this.f7638d.edit().putString(convertToHex, url2).commit();
            return convertToHex;
        } else if (string2.equals(url2)) {
            return convertToHex;
        } else {
            int i2 = 0;
            do {
                i2++;
                str = convertToHex + "_" + i2;
                string = this.f7638d.getString(str, null);
                if (string == null) {
                    break;
                }
            } while (!string.equals(url2));
            this.f7638d.edit().putString(str, url2).commit();
            return str;
        }
    }

    public final File a(URL url) {
        if (this.b == null) {
            return null;
        }
        synchronized (this) {
            String b = b(url);
            File a2 = a(b);
            if (a2.exists()) {
                long b2 = v.b();
                long j2 = this.c.getLong(b, 0L);
                if (j2 >= b2) {
                    return a2;
                }
                if (j2 != 0) {
                    this.c.edit().remove(b).commit();
                    this.f7638d.edit().remove(b).commit();
                }
                a2.delete();
                return null;
            }
            return null;
        }
    }

    final File b() {
        File file = this.f7640f;
        if (file == null) {
            file = new File(this.b.getCacheDir(), "tapjoy_mm_cache");
            this.f7640f = file;
        }
        if (!file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    final File a(String str) {
        return new File(b(), str);
    }
}
