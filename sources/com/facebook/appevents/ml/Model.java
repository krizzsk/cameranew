package com.facebook.appevents.ml;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.appevents.ml.ModelManager;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class Model {
    private a a;
    private a b;
    private a c;

    /* renamed from: d  reason: collision with root package name */
    private a f2324d;

    /* renamed from: e  reason: collision with root package name */
    private a f2325e;

    /* renamed from: f  reason: collision with root package name */
    private a f2326f;

    /* renamed from: g  reason: collision with root package name */
    private a f2327g;

    /* renamed from: h  reason: collision with root package name */
    private a f2328h;

    /* renamed from: i  reason: collision with root package name */
    private a f2329i;

    /* renamed from: j  reason: collision with root package name */
    private a f2330j;

    /* renamed from: k  reason: collision with root package name */
    private a f2331k;

    /* renamed from: l  reason: collision with root package name */
    private final Map<String, a> f2332l = new HashMap();

    private Model(Map<String, a> map) {
        this.a = map.get("embed.weight");
        this.b = b.l(map.get("convs.0.weight"));
        this.c = b.l(map.get("convs.1.weight"));
        this.f2324d = b.l(map.get("convs.2.weight"));
        this.f2325e = map.get("convs.0.bias");
        this.f2326f = map.get("convs.1.bias");
        this.f2327g = map.get("convs.2.bias");
        this.f2328h = b.k(map.get("fc1.weight"));
        this.f2329i = b.k(map.get("fc2.weight"));
        this.f2330j = map.get("fc1.bias");
        this.f2331k = map.get("fc2.bias");
        for (String str : new HashSet<String>() { // from class: com.facebook.appevents.ml.Model.1
            {
                add(ModelManager.Task.MTML_INTEGRITY_DETECT.toKey());
                add(ModelManager.Task.MTML_APP_EVENT_PREDICTION.toKey());
            }
        }) {
            String str2 = str + ".weight";
            String str3 = str + ".bias";
            a aVar = map.get(str2);
            a aVar2 = map.get(str3);
            if (aVar != null) {
                this.f2332l.put(str2, b.k(aVar));
            }
            if (aVar2 != null) {
                this.f2332l.put(str3, aVar2);
            }
        }
    }

    @Nullable
    public static Model a(File file) {
        if (com.facebook.internal.instrument.e.a.c(Model.class)) {
            return null;
        }
        try {
            try {
                return new Model(c(file));
            } catch (Exception unused) {
                return null;
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, Model.class);
            return null;
        }
    }

    private static Map<String, String> b() {
        if (com.facebook.internal.instrument.e.a.c(Model.class)) {
            return null;
        }
        try {
            return new HashMap<String, String>() { // from class: com.facebook.appevents.ml.Model.2
                {
                    put("embedding.weight", "embed.weight");
                    put("dense1.weight", "fc1.weight");
                    put("dense2.weight", "fc2.weight");
                    put("dense3.weight", "fc3.weight");
                    put("dense1.bias", "fc1.bias");
                    put("dense2.bias", "fc2.bias");
                    put("dense3.bias", "fc3.bias");
                }
            };
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, Model.class);
            return null;
        }
    }

    @Nullable
    private static Map<String, a> c(File file) {
        Map<String, a> map = null;
        if (com.facebook.internal.instrument.e.a.c(Model.class)) {
            return null;
        }
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                int available = fileInputStream.available();
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                byte[] bArr = new byte[available];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                if (available < 4) {
                    return null;
                }
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 4);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                int i2 = wrap.getInt();
                int i3 = i2 + 4;
                if (available < i3) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(new String(bArr, 4, i2));
                JSONArray names = jSONObject.names();
                int length = names.length();
                String[] strArr = new String[length];
                for (int i4 = 0; i4 < length; i4++) {
                    strArr[i4] = names.getString(i4);
                }
                Arrays.sort(strArr);
                HashMap hashMap = new HashMap();
                Map<String, String> b = b();
                int i5 = 0;
                while (i5 < length) {
                    String str = strArr[i5];
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    int length2 = jSONArray.length();
                    int[] iArr = new int[length2];
                    int i6 = 1;
                    for (int i7 = 0; i7 < length2; i7++) {
                        try {
                            iArr[i7] = jSONArray.getInt(i7);
                            i6 *= iArr[i7];
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                    int i8 = i6 * 4;
                    int i9 = i3 + i8;
                    if (i9 > available) {
                        return null;
                    }
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr, i3, i8);
                    wrap2.order(ByteOrder.LITTLE_ENDIAN);
                    a aVar = new a(iArr);
                    wrap2.asFloatBuffer().get(aVar.b(), 0, i6);
                    if (b.containsKey(str)) {
                        str = b.get(str);
                    }
                    hashMap.put(str, aVar);
                    i5++;
                    i3 = i9;
                    map = null;
                }
                return hashMap;
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, Model.class);
                return null;
            }
        } catch (Exception unused2) {
            return map;
        }
    }

    @Nullable
    public a d(a aVar, String[] strArr, String str) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            a c = b.c(b.e(strArr, 128, this.a), this.b);
            b.a(c, this.f2325e);
            b.i(c);
            a c2 = b.c(c, this.c);
            b.a(c2, this.f2326f);
            b.i(c2);
            a g2 = b.g(c2, 2);
            a c3 = b.c(g2, this.f2324d);
            b.a(c3, this.f2327g);
            b.i(c3);
            a g3 = b.g(c, c.c(1));
            a g4 = b.g(g2, g2.c(1));
            a g5 = b.g(c3, c3.c(1));
            b.f(g3, 1);
            b.f(g4, 1);
            b.f(g5, 1);
            a d2 = b.d(b.b(new a[]{g3, g4, g5, aVar}), this.f2328h, this.f2330j);
            b.i(d2);
            a d3 = b.d(d2, this.f2329i, this.f2331k);
            b.i(d3);
            Map<String, a> map = this.f2332l;
            a aVar2 = map.get(str + ".weight");
            Map<String, a> map2 = this.f2332l;
            a aVar3 = map2.get(str + ".bias");
            if (aVar2 != null && aVar3 != null) {
                a d4 = b.d(d3, aVar2, aVar3);
                b.j(d4);
                return d4;
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }
}
