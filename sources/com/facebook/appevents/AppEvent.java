package com.facebook.appevents;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.adjust.sdk.Constants;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.r;
import com.facebook.internal.x;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class AppEvent implements Serializable {
    private static final long serialVersionUID = 1;
    private static final HashSet<String> validatedIdentifiers = new HashSet<>();
    private final String checksum;
    private final boolean inBackground;
    private final boolean isImplicit;
    private final JSONObject jsonObject;
    private final String name;

    /* loaded from: classes.dex */
    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final boolean inBackground;
        private final boolean isImplicit;
        private final String jsonString;

        private SerializationProxyV1(String str, boolean z, boolean z2) {
            this.jsonString = str;
            this.isImplicit = z;
            this.inBackground = z2;
        }

        private Object readResolve() throws JSONException {
            return new AppEvent(this.jsonString, this.isImplicit, this.inBackground, null);
        }
    }

    /* loaded from: classes.dex */
    static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 20160803001L;
        private final String checksum;
        private final boolean inBackground;
        private final boolean isImplicit;
        private final String jsonString;

        private Object readResolve() throws JSONException {
            return new AppEvent(this.jsonString, this.isImplicit, this.inBackground, this.checksum);
        }

        private SerializationProxyV2(String str, boolean z, boolean z2, String str2) {
            this.jsonString = str;
            this.isImplicit = z;
            this.inBackground = z2;
            this.checksum = str2;
        }
    }

    private String calculateChecksum() {
        if (Build.VERSION.SDK_INT > 19) {
            return md5Checksum(this.jsonObject.toString());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.jsonObject.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            sb.append(str);
            sb.append(" = ");
            sb.append(this.jsonObject.optString(str));
            sb.append('\n');
        }
        return md5Checksum(sb.toString());
    }

    private JSONObject getJSONObjectForAppEvent(String str, @NonNull String str2, Double d2, Bundle bundle, @Nullable UUID uuid) throws JSONException {
        validateIdentifier(str2);
        JSONObject jSONObject = new JSONObject();
        String e2 = com.facebook.appevents.m.a.e(str2);
        jSONObject.put("_eventName", e2);
        jSONObject.put("_eventName_md5", md5Checksum(e2));
        jSONObject.put("_logTime", System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (bundle != null) {
            Map<String, String> validateParameters = validateParameters(bundle);
            for (String str3 : validateParameters.keySet()) {
                jSONObject.put(str3, validateParameters.get(str3));
            }
        }
        if (d2 != null) {
            jSONObject.put("_valueToSum", d2.doubleValue());
        }
        if (this.inBackground) {
            jSONObject.put("_inBackground", "1");
        }
        if (this.isImplicit) {
            jSONObject.put("_implicitlyLogged", "1");
        } else {
            r.h(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", jSONObject.toString());
        }
        return jSONObject;
    }

    private static String md5Checksum(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            return com.facebook.appevents.internal.b.c(messageDigest.digest());
        } catch (UnsupportedEncodingException e2) {
            x.X("Failed to generate checksum: ", e2);
            return "1";
        } catch (NoSuchAlgorithmException e3) {
            x.X("Failed to generate checksum: ", e3);
            return "0";
        }
    }

    private static void validateIdentifier(String str) throws FacebookException {
        boolean contains;
        if (str != null && str.length() != 0 && str.length() <= 40) {
            HashSet<String> hashSet = validatedIdentifiers;
            synchronized (hashSet) {
                contains = hashSet.contains(str);
            }
            if (contains) {
                return;
            }
            if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                synchronized (hashSet) {
                    hashSet.add(str);
                }
                return;
            }
            throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", str));
        }
        if (str == null) {
            str = "<None Provided>";
        }
        throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", str, 40));
    }

    private Map<String, String> validateParameters(Bundle bundle) throws FacebookException {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            validateIdentifier(str);
            Object obj = bundle.get(str);
            if (!(obj instanceof String) && !(obj instanceof Number)) {
                throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", obj, str));
            }
            hashMap.put(str, obj.toString());
        }
        com.facebook.appevents.l.a.c(hashMap);
        com.facebook.appevents.m.a.f(hashMap, this.name);
        com.facebook.appevents.k.a.c(hashMap, this.name);
        return hashMap;
    }

    private Object writeReplace() {
        return new SerializationProxyV2(this.jsonObject.toString(), this.isImplicit, this.inBackground, this.checksum);
    }

    public boolean getIsImplicit() {
        return this.isImplicit;
    }

    public JSONObject getJSONObject() {
        return this.jsonObject;
    }

    public String getName() {
        return this.name;
    }

    public boolean isChecksumValid() {
        if (this.checksum == null) {
            return true;
        }
        return calculateChecksum().equals(this.checksum);
    }

    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString());
    }

    public AppEvent(String str, @NonNull String str2, Double d2, Bundle bundle, boolean z, boolean z2, @Nullable UUID uuid) throws JSONException, FacebookException {
        this.isImplicit = z;
        this.inBackground = z2;
        this.name = str2;
        this.jsonObject = getJSONObjectForAppEvent(str, str2, d2, bundle, uuid);
        this.checksum = calculateChecksum();
    }

    private AppEvent(String str, boolean z, boolean z2, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.jsonObject = jSONObject;
        this.isImplicit = z;
        this.name = jSONObject.optString("_eventName");
        this.checksum = str2;
        this.inBackground = z2;
    }
}
