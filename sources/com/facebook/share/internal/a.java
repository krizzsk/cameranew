package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: CameraEffectJSONUtility.java */
/* loaded from: classes.dex */
public class a {
    private static final Map<Class<?>, d> a;

    /* compiled from: CameraEffectJSONUtility.java */
    /* renamed from: com.facebook.share.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0117a implements d {
        C0117a() {
        }

        @Override // com.facebook.share.internal.a.d
        public void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
            jSONObject.put(str, obj);
        }
    }

    /* compiled from: CameraEffectJSONUtility.java */
    /* loaded from: classes.dex */
    static class b implements d {
        b() {
        }

        @Override // com.facebook.share.internal.a.d
        public void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : (String[]) obj) {
                jSONArray.put(str2);
            }
            jSONObject.put(str, jSONArray);
        }
    }

    /* compiled from: CameraEffectJSONUtility.java */
    /* loaded from: classes.dex */
    static class c implements d {
        c() {
        }

        @Override // com.facebook.share.internal.a.d
        public void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
            throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
        }
    }

    /* compiled from: CameraEffectJSONUtility.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(String.class, new C0117a());
        hashMap.put(String[].class, new b());
        hashMap.put(JSONArray.class, new c());
    }

    public static JSONObject a(CameraEffectArguments cameraEffectArguments) throws JSONException {
        if (cameraEffectArguments == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.c()) {
            Object b2 = cameraEffectArguments.b(str);
            if (b2 != null) {
                d dVar = a.get(b2.getClass());
                if (dVar != null) {
                    dVar.a(jSONObject, str, b2);
                } else {
                    throw new IllegalArgumentException("Unsupported type: " + b2.getClass());
                }
            }
        }
        return jSONObject;
    }
}
