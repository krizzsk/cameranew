package com.google.ads.mediation;

import com.google.android.gms.internal.ads.zzazk;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes.dex */
public class MediationServerParameters {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes.dex */
    public static final class MappingException extends Exception {
        public MappingException(String str) {
            super(str);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    protected @interface a {
        String name();

        boolean required() default true;
    }

    public void a(Map<String, String> map) throws MappingException {
        Field[] fields;
        HashMap hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            a aVar = (a) field.getAnnotation(a.class);
            if (aVar != null) {
                hashMap.put(aVar.name(), field);
            }
        }
        if (hashMap.isEmpty()) {
            zzazk.zzex("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException unused) {
                    String key = entry.getKey();
                    StringBuilder sb = new StringBuilder(String.valueOf(key).length() + 49);
                    sb.append("Server option \"");
                    sb.append(key);
                    sb.append("\" could not be set: Illegal Access");
                    zzazk.zzex(sb.toString());
                } catch (IllegalArgumentException unused2) {
                    String key2 = entry.getKey();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(key2).length() + 43);
                    sb2.append("Server option \"");
                    sb2.append(key2);
                    sb2.append("\" could not be set: Bad Type");
                    zzazk.zzex(sb2.toString());
                }
            } else {
                String key3 = entry.getKey();
                String value = entry.getValue();
                StringBuilder sb3 = new StringBuilder(String.valueOf(key3).length() + 31 + String.valueOf(value).length());
                sb3.append("Unexpected server option: ");
                sb3.append(key3);
                sb3.append(" = \"");
                sb3.append(value);
                sb3.append("\"");
                zzazk.zzdy(sb3.toString());
            }
        }
        StringBuilder sb4 = new StringBuilder();
        for (Field field3 : hashMap.values()) {
            if (((a) field3.getAnnotation(a.class)).required()) {
                String valueOf = String.valueOf(((a) field3.getAnnotation(a.class)).name());
                zzazk.zzex(valueOf.length() != 0 ? "Required server option missing: ".concat(valueOf) : new String("Required server option missing: "));
                if (sb4.length() > 0) {
                    sb4.append(", ");
                }
                sb4.append(((a) field3.getAnnotation(a.class)).name());
            }
        }
        if (sb4.length() > 0) {
            String valueOf2 = String.valueOf(sb4.toString());
            throw new MappingException(valueOf2.length() != 0 ? "Required server option(s) missing: ".concat(valueOf2) : new String("Required server option(s) missing: "));
        }
    }
}
