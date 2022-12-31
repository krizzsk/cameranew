package us.pinguo.advconfigdata.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes3.dex */
public class SPUtils {
    public static final String FILE_NAME = "adv_share_data";
    private static final String TAG = "SPUtils";

    /* loaded from: classes3.dex */
    private static class a {
        private static final Method a = b();

        public static void a(SharedPreferences.Editor editor) {
            try {
                Method method = a;
                if (method != null) {
                    method.invoke(editor, new Object[0]);
                    return;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
            editor.commit();
        }

        private static Method b() {
            try {
                return SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }

    public SPUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static byte[] StringToBytes(String str) {
        int i2;
        int i3;
        String trim = str.toUpperCase().trim();
        if (trim.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[trim.length() / 2];
        int i4 = 0;
        while (i4 < trim.length()) {
            char charAt = trim.charAt(i4);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    i2 = charAt - '7';
                }
                return null;
            }
            i2 = charAt - '0';
            int i5 = i2 * 16;
            int i6 = i4 + 1;
            char charAt2 = trim.charAt(i6);
            if (charAt2 < '0' || charAt2 > '9') {
                if (charAt2 >= 'A' && charAt2 <= 'F') {
                    i3 = charAt2 - '7';
                }
                return null;
            }
            i3 = charAt2 - '0';
            bArr[i6 / 2] = (byte) (i5 + i3);
            i4 = i6 + 1;
        }
        return bArr;
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & Draft_75.END_OF_FRAME);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static void clear(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("adv_share_data", 0).edit();
        edit.clear();
        a.a(edit);
    }

    public static boolean contains(Context context, String str) {
        return context.getSharedPreferences("adv_share_data", 0).contains(str);
    }

    public static Object get(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("adv_share_data", 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static Map<String, ?> getAll(Context context) {
        return context.getSharedPreferences("adv_share_data", 0).getAll();
    }

    public static Object getMultiProcess(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("adv_share_data", 4);
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static void put(Context context, String str, Object obj) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("adv_share_data", 0).edit();
            if (obj != null) {
                if (obj instanceof String) {
                    edit.putString(str, (String) obj);
                } else if (obj instanceof Integer) {
                    edit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Float) {
                    edit.putFloat(str, ((Float) obj).floatValue());
                } else if (obj instanceof Long) {
                    edit.putLong(str, ((Long) obj).longValue());
                } else {
                    edit.putString(str, obj.toString());
                }
                a.a(edit);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void putMultiProcess(Context context, String str, Object obj) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("adv_share_data", 4).edit();
            if (obj != null) {
                if (obj instanceof String) {
                    edit.putString(str, (String) obj);
                } else if (obj instanceof Integer) {
                    edit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Float) {
                    edit.putFloat(str, ((Float) obj).floatValue());
                } else if (obj instanceof Long) {
                    edit.putLong(str, ((Long) obj).longValue());
                } else {
                    edit.putString(str, obj.toString());
                }
                a.a(edit);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Object readObject(Context context, String str) {
        byte[] StringToBytes;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("adv_share_data", 0);
            if (sharedPreferences.contains(str)) {
                String string = sharedPreferences.getString(str, "");
                if (!TextUtils.isEmpty(string) && (StringToBytes = StringToBytes(string)) != null) {
                    return new ObjectInputStream(new ByteArrayInputStream(StringToBytes)).readObject();
                }
            }
        } catch (StreamCorruptedException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static void remove(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("adv_share_data", 0).edit();
        edit.remove(str);
        a.a(edit);
    }

    public static void saveObject(Context context, String str, Object obj) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("adv_share_data", 0).edit();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            edit.putString(str, bytesToHexString(byteArrayOutputStream.toByteArray()));
            edit.commit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
