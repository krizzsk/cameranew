package com.facebook.share.internal;

import androidx.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: OpenGraphJSONUtility.java */
/* loaded from: classes.dex */
public final class h {

    /* compiled from: OpenGraphJSONUtility.java */
    /* loaded from: classes.dex */
    public interface a {
        JSONObject a(SharePhoto sharePhoto);
    }

    private h() {
    }

    private static JSONArray a(List list, a aVar) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(h.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (Object obj : list) {
                jSONArray.put(d(obj, aVar));
            }
            return jSONArray;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, h.class);
            return null;
        }
    }

    public static JSONObject b(ShareOpenGraphAction shareOpenGraphAction, a aVar) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(h.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : shareOpenGraphAction.f()) {
                jSONObject.put(str, d(shareOpenGraphAction.a(str), aVar));
            }
            return jSONObject;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, h.class);
            return null;
        }
    }

    private static JSONObject c(ShareOpenGraphObject shareOpenGraphObject, a aVar) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(h.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : shareOpenGraphObject.f()) {
                jSONObject.put(str, d(shareOpenGraphObject.a(str), aVar));
            }
            return jSONObject;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, h.class);
            return null;
        }
    }

    public static Object d(@Nullable Object obj, a aVar) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(h.class)) {
            return null;
        }
        try {
            if (obj == null) {
                return JSONObject.NULL;
            }
            if (!(obj instanceof String) && !(obj instanceof Boolean) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long)) {
                if (obj instanceof SharePhoto) {
                    if (aVar != null) {
                        return aVar.a((SharePhoto) obj);
                    }
                    return null;
                } else if (obj instanceof ShareOpenGraphObject) {
                    return c((ShareOpenGraphObject) obj, aVar);
                } else {
                    if (obj instanceof List) {
                        return a((List) obj, aVar);
                    }
                    throw new IllegalArgumentException("Invalid object found for JSON serialization: " + obj.toString());
                }
            }
            return obj;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, h.class);
            return null;
        }
    }
}
