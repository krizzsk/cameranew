package us.pinguo.foundation;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: PGCamera2Preferences.java */
/* loaded from: classes4.dex */
public final class j {

    /* renamed from: e  reason: collision with root package name */
    private static j f11016e;

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f11017f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    private static final Set<String> f11018g;
    private SharedPreferences b;
    private SharedPreferences a = null;
    private ConcurrentHashMap<String, Object> c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f11019d = new ConcurrentHashMap<>();

    static {
        HashSet hashSet = new HashSet();
        f11018g = hashSet;
        hashSet.add("key_camera_picture_size");
        hashSet.add("key_camera_exposure");
        hashSet.add("key_camera_flashmode");
        hashSet.add("key_camera_whitebalance");
        hashSet.add("key_camera_jpeg_redress_enable");
        hashSet.add("key_camera_jpeg_redress_mirror");
        hashSet.add("key_camera_jpeg_redress_orientation");
        hashSet.add("pref_camera_iso_key");
        hashSet.add("key_camera_sharpness");
        hashSet.add("pref_video_quality_key");
        hashSet.add("pref_video_flashmode_key");
        hashSet.add("key_frame_blur_type");
    }

    private j(Context context) {
        this.b = null;
        this.b = context.getSharedPreferences(context.getPackageName() + "_global", 0);
    }

    private void b(SharedPreferences sharedPreferences, ConcurrentHashMap<String, Object> concurrentHashMap) {
        if (sharedPreferences != null && concurrentHashMap.size() > 0) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (Map.Entry<String, Object> entry : concurrentHashMap.entrySet()) {
                t(edit, entry.getKey(), entry.getValue());
            }
            edit.apply();
            concurrentHashMap.clear();
        }
    }

    private boolean d(SharedPreferences sharedPreferences, ConcurrentHashMap<String, Object> concurrentHashMap) {
        if (sharedPreferences != null && concurrentHashMap.size() > 0) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (Map.Entry<String, Object> entry : concurrentHashMap.entrySet()) {
                t(edit, entry.getKey(), entry.getValue());
            }
            boolean commit = edit.commit();
            concurrentHashMap.clear();
            return commit;
        }
        return true;
    }

    public static j e() {
        j jVar;
        j jVar2 = f11016e;
        if (jVar2 != null) {
            return jVar2;
        }
        synchronized (f11017f) {
            if (f11016e == null) {
                f11016e = new j(e.b());
            }
            jVar = f11016e;
        }
        return jVar;
    }

    public static boolean l(String str) {
        return !f11018g.contains(str);
    }

    private void t(SharedPreferences.Editor editor, String str, Object obj) {
        if (obj instanceof String) {
            editor.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            editor.putFloat(str, ((Float) obj).floatValue());
        }
    }

    public void a() {
        b(this.a, this.c);
        b(this.b, this.f11019d);
    }

    public boolean c() {
        return d(this.a, this.c) && d(this.b, this.f11019d);
    }

    public boolean f(String str, boolean z) {
        if (l(str)) {
            Object obj = this.f11019d.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return this.b.getBoolean(str, z);
        }
        Object obj2 = this.c.get(str);
        if (obj2 instanceof Boolean) {
            return ((Boolean) obj2).booleanValue();
        }
        return this.a.getBoolean(str, z);
    }

    public int g() {
        return i("key_front_image_interval", 21600);
    }

    public int h() {
        return i("key_front_image_version", 0);
    }

    public int i(String str, int i2) {
        if (l(str)) {
            Object obj = this.f11019d.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return this.b.getInt(str, i2);
        }
        Object obj2 = this.c.get(str);
        if (obj2 instanceof Integer) {
            return ((Integer) obj2).intValue();
        }
        return this.a.getInt(str, i2);
    }

    public long j(String str, long j2) {
        if (l(str)) {
            Object obj = this.f11019d.get(str);
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            return this.b.getLong(str, j2);
        }
        Object obj2 = this.c.get(str);
        if (obj2 instanceof Long) {
            return ((Long) obj2).longValue();
        }
        return this.a.getLong(str, j2);
    }

    public String k(String str, String str2) {
        if (l(str)) {
            Object obj = this.f11019d.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            return this.b.getString(str, str2);
        }
        Object obj2 = this.c.get(str);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        return this.a.getString(str, str2);
    }

    public void m(String str, boolean z) {
        if (l(str)) {
            this.f11019d.put(str, Boolean.valueOf(z));
        } else {
            this.c.put(str, Boolean.valueOf(z));
        }
    }

    public void n(int i2) {
        q("key_front_image_interval", i2);
    }

    public void o(long j2) {
        r("key_front_image_pull_date", j2);
    }

    public void p(int i2) {
        q("key_front_image_version", i2);
    }

    public void q(String str, int i2) {
        if (l(str)) {
            this.f11019d.put(str, Integer.valueOf(i2));
        } else {
            this.c.put(str, Integer.valueOf(i2));
        }
    }

    public void r(String str, long j2) {
        if (l(str)) {
            this.f11019d.put(str, Long.valueOf(j2));
        } else {
            this.c.put(str, Long.valueOf(j2));
        }
    }

    public void s(String str, String str2) {
        if (l(str)) {
            this.f11019d.put(str, str2);
        } else {
            this.c.put(str, str2);
        }
    }
}
