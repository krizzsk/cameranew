package us.pinguo.foundation.utils;

import android.text.TextUtils;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
/* compiled from: BooleanTypeAdapter.java */
/* loaded from: classes4.dex */
public class g extends com.google.gson.q<Boolean> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BooleanTypeAdapter.java */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static boolean toBoolean(String str) {
        return !TextUtils.isEmpty(str) && (str.equalsIgnoreCase("true") || !str.equals("0"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.q
    public Boolean read(com.google.gson.stream.a aVar) throws IOException {
        JsonToken c0 = aVar.c0();
        int i2 = a.a[c0.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                aVar.Y();
                return Boolean.FALSE;
            } else if (i2 == 3) {
                return Boolean.valueOf(aVar.U() != 0);
            } else if (i2 != 4) {
                JsonParseException jsonParseException = new JsonParseException("Expected BOOLEAN or NUMBER but was " + c0);
                if (!us.pinguo.foundation.d.f10987f) {
                    us.pinguo.common.log.a.f(jsonParseException);
                    return Boolean.FALSE;
                }
                throw jsonParseException;
            } else {
                return Boolean.valueOf(toBoolean(aVar.a0()));
            }
        }
        return Boolean.valueOf(aVar.S());
    }

    @Override // com.google.gson.q
    public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
        if (bool == null) {
            bVar.S();
        } else {
            bVar.d0(bool);
        }
    }
}
