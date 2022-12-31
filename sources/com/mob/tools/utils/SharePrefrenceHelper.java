package com.mob.tools.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class SharePrefrenceHelper {
    private Context context;
    private MobSharePreference prefrence;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class MobSharePreference {
        private static Handler handler = MobHandlerThread.newHandler("s", new Handler.Callback() { // from class: com.mob.tools.utils.SharePrefrenceHelper.MobSharePreference.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                OnCommitListener onCommitListener;
                try {
                    onCommitListener = (OnCommitListener) message.obj;
                } catch (Throwable unused) {
                    onCommitListener = null;
                }
                try {
                    Bundle data = message.getData();
                    String string = data.getString("json");
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(data.getString("file")), "utf-8");
                    outputStreamWriter.append((CharSequence) string);
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    if (onCommitListener != null) {
                        onCommitListener.onCommit(null);
                        return false;
                    }
                    return false;
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                    if (onCommitListener != null) {
                        onCommitListener.onCommit(th);
                        return false;
                    }
                    return false;
                }
            }
        });
        private Hashon hashon;
        private OnCommitListener listener;
        private File spFile;
        private HashMap<String, Object> spMap;

        public MobSharePreference(Context context, String str) {
            if (context != null) {
                try {
                    File file = new File(new File(context.getFilesDir(), "Mob"), str);
                    this.spFile = file;
                    if (!file.getParentFile().exists()) {
                        this.spFile.getParentFile().mkdirs();
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                    return;
                }
            }
            this.spMap = new HashMap<>();
            this.hashon = new Hashon();
            open();
        }

        private Object get(String str) {
            Object obj;
            synchronized (this.spMap) {
                obj = this.spMap.get(str);
            }
            return obj;
        }

        private void open() {
            synchronized (this.spMap) {
                if (this.spFile.exists()) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.spFile), "utf-8"));
                    StringBuilder sb = new StringBuilder();
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (sb.length() > 0) {
                            sb.append("\n");
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    this.spMap = this.hashon.fromJson(sb.toString());
                }
            }
        }

        private void put(String str, Object obj) {
            synchronized (this.spMap) {
                this.spMap.put(str, obj);
                if (handler != null) {
                    Message message = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putString("json", this.hashon.fromHashMap(this.spMap));
                    bundle.putString("file", this.spFile.getAbsolutePath());
                    message.setData(bundle);
                    message.what = 1;
                    message.obj = this.listener;
                    handler.sendMessage(message);
                }
            }
        }

        public void clear() {
            synchronized (this.spMap) {
                this.spMap.clear();
            }
            if (handler != null) {
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("json", this.hashon.fromHashMap(this.spMap));
                bundle.putString("file", this.spFile.getAbsolutePath());
                message.setData(bundle);
                message.what = 1;
                message.obj = this.listener;
                handler.sendMessage(message);
            }
        }

        public HashMap<String, Object> getAll() {
            HashMap<String, Object> hashMap;
            synchronized (this.spMap) {
                hashMap = new HashMap<>();
                hashMap.putAll(this.spMap);
            }
            return hashMap;
        }

        public boolean getBoolean(String str, boolean z) {
            Object obj = get(str);
            return obj != null ? ((Number) obj).byteValue() == 1 : z;
        }

        public byte getByte(String str, byte b) {
            Object obj = get(str);
            return obj != null ? ((Number) obj).byteValue() : b;
        }

        public char getChar(String str, char c) {
            Object obj = get(str);
            return obj != null ? ((String) obj).charAt(0) : c;
        }

        public double getDouble(String str, double d2) {
            Object obj = get(str);
            return obj != null ? ((Number) obj).doubleValue() : d2;
        }

        public float getFloat(String str, float f2) {
            Object obj = get(str);
            return obj != null ? ((Number) obj).floatValue() : f2;
        }

        public int getInt(String str, int i2) {
            Object obj = get(str);
            return obj != null ? ((Number) obj).intValue() : i2;
        }

        public long getLong(String str, long j2) {
            Object obj = get(str);
            return obj != null ? ((Number) obj).longValue() : j2;
        }

        public short getShort(String str, short s) {
            Object obj = get(str);
            return obj != null ? ((Number) obj).shortValue() : s;
        }

        public String getString(String str, String str2) {
            Object obj = get(str);
            return obj != null ? (String) obj : str2;
        }

        public void putAll(HashMap<String, Object> hashMap) {
            synchronized (this.spMap) {
                this.spMap.putAll(hashMap);
            }
            if (handler != null) {
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("json", this.hashon.fromHashMap(this.spMap));
                bundle.putString("file", this.spFile.getAbsolutePath());
                message.setData(bundle);
                message.what = 1;
                message.obj = this.listener;
                handler.sendMessage(message);
            }
        }

        public void putBoolean(String str, boolean z) {
            putByte(str, z ? (byte) 1 : (byte) 0);
        }

        public void putByte(String str, byte b) {
            put(str, Byte.valueOf(b));
        }

        public void putChar(String str, char c) {
            putString(str, String.valueOf(c));
        }

        public void putDouble(String str, double d2) {
            put(str, Double.valueOf(d2));
        }

        public void putFloat(String str, float f2) {
            put(str, Float.valueOf(f2));
        }

        public void putInt(String str, int i2) {
            put(str, Integer.valueOf(i2));
        }

        public void putLong(String str, long j2) {
            put(str, Long.valueOf(j2));
        }

        public void putShort(String str, short s) {
            put(str, Short.valueOf(s));
        }

        public void putString(String str, String str2) {
            put(str, str2);
        }

        public void remove(String str) {
            put(str, null);
        }

        public void setOnCommitListener(OnCommitListener onCommitListener) {
            this.listener = onCommitListener;
        }
    }

    /* loaded from: classes3.dex */
    public interface OnCommitListener {
        void onCommit(Throwable th);
    }

    public SharePrefrenceHelper(Context context) {
        if (context != null) {
            this.context = context.getApplicationContext();
        }
    }

    public void clear() {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            mobSharePreference.clear();
        }
    }

    public Object get(String str) {
        try {
            String string = getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(string, 2)));
            Object readObject = objectInputStream.readObject();
            objectInputStream.close();
            return readObject;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public HashMap<String, Object> getAll() {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            return mobSharePreference.getAll();
        }
        return new HashMap<>();
    }

    public boolean getBoolean(String str) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            return mobSharePreference.getBoolean(str, false);
        }
        return false;
    }

    public float getFloat(String str) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            return mobSharePreference.getFloat(str, 0.0f);
        }
        return 0.0f;
    }

    public int getInt(String str) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            return mobSharePreference.getInt(str, 0);
        }
        return 0;
    }

    public long getLong(String str) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            return mobSharePreference.getLong(str, 0L);
        }
        return 0L;
    }

    public String getString(String str) {
        MobSharePreference mobSharePreference = this.prefrence;
        return mobSharePreference != null ? mobSharePreference.getString(str, "") : "";
    }

    public void open(String str) {
        open(str, 0);
    }

    public void put(String str, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            objectOutputStream.close();
            putString(str, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public void putAll(HashMap<String, Object> hashMap) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            mobSharePreference.putAll(hashMap);
        }
    }

    public void putBoolean(String str, Boolean bool) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            mobSharePreference.putBoolean(str, bool.booleanValue());
        }
    }

    public void putFloat(String str, Float f2) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            mobSharePreference.putFloat(str, f2.floatValue());
        }
    }

    public void putInt(String str, Integer num) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            mobSharePreference.putInt(str, num.intValue());
        }
    }

    public void putLong(String str, Long l2) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            mobSharePreference.putLong(str, l2.longValue());
        }
    }

    public void putString(String str, String str2) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            mobSharePreference.putString(str, str2);
        }
    }

    public void remove(String str) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            mobSharePreference.remove(str);
        }
    }

    public void setOnCommitListener(OnCommitListener onCommitListener) {
        MobSharePreference mobSharePreference = this.prefrence;
        if (mobSharePreference != null) {
            mobSharePreference.setOnCommitListener(onCommitListener);
        }
    }

    public void open(String str, int i2) {
        this.prefrence = new MobSharePreference(this.context, str + "_" + i2);
    }

    public boolean getBoolean(String str, boolean z) {
        MobSharePreference mobSharePreference = this.prefrence;
        return mobSharePreference != null ? mobSharePreference.getBoolean(str, z) : z;
    }

    public float getFloat(String str, float f2) {
        MobSharePreference mobSharePreference = this.prefrence;
        return mobSharePreference != null ? mobSharePreference.getFloat(str, f2) : f2;
    }

    public int getInt(String str, int i2) {
        MobSharePreference mobSharePreference = this.prefrence;
        return mobSharePreference != null ? mobSharePreference.getInt(str, i2) : i2;
    }

    public long getLong(String str, long j2) {
        MobSharePreference mobSharePreference = this.prefrence;
        return mobSharePreference != null ? mobSharePreference.getLong(str, j2) : j2;
    }

    public String getString(String str, String str2) {
        MobSharePreference mobSharePreference = this.prefrence;
        return mobSharePreference != null ? mobSharePreference.getString(str, str2) : str2;
    }
}
