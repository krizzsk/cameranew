package com.tapjoy.internal;

import android.util.Base64;
import com.tapjoy.TapjoyUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import java.util.zip.CRC32;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class fo {
    public final a a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7539d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7540e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7541f;

    /* loaded from: classes3.dex */
    public enum a {
        SDK_ANDROID((byte) 2),
        RPC_ANALYTICS((byte) 49);
        
        public byte a;

        a(byte b2) {
            this.a = b2;
        }

        @Nullable
        public static a a(byte b2) {
            a[] values;
            for (a aVar : values()) {
                if (aVar.a == b2) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public fo(String str) {
        int length = str.length();
        if (str.matches("[A-Za-z0-9\\-_]*") && length >= 60 && (length & 3) == 0) {
            try {
                byte[] decode = Base64.decode(str, 8);
                int length2 = decode.length;
                ByteBuffer wrap = ByteBuffer.wrap(decode);
                wrap.order(ByteOrder.BIG_ENDIAN);
                int length3 = decode.length - 4;
                int i2 = wrap.getInt(length3);
                CRC32 crc32 = new CRC32();
                crc32.update(decode, 0, length3);
                if (i2 == ((int) crc32.getValue())) {
                    this.f7540e = str;
                    this.b = new UUID(wrap.getLong(0), wrap.getLong(8)).toString();
                    byte b = wrap.get(16);
                    this.f7541f = b;
                    a a2 = a.a(wrap.get(17));
                    this.a = a2;
                    this.c = str.substring(24, 44);
                    if (b == 1) {
                        this.f7539d = null;
                        return;
                    } else if (b != 2 || a2 != a.SDK_ANDROID) {
                        throw new IllegalArgumentException("The given API key was not supported.");
                    } else {
                        if (length2 >= 57) {
                            byte[] bArr = new byte[12];
                            System.arraycopy(decode, 33, bArr, 0, 12);
                            this.f7539d = TapjoyUtil.convertToHex(bArr);
                            return;
                        }
                        throw new IllegalArgumentException("The given API key was invalid.");
                    }
                }
                throw new IllegalArgumentException("The given API key was invalid.");
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("The given API key was malformed.", e2);
            }
        }
        throw new IllegalArgumentException("The given API key was malformed.");
    }

    public static String a(String str) {
        if (str.regionMatches(13, "-8000-8000-", 0, 11)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 8));
            stringBuffer.append(str.substring(24, 30));
            stringBuffer.append(str.substring(9, 13));
            stringBuffer.append(str.substring(30));
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("The given UUID did not come from 5Rocks.");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof fo) {
            return this.f7540e.equals(((fo) obj).f7540e);
        }
        return false;
    }

    public final String toString() {
        return this.f7540e;
    }
}
