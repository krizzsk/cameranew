package us.pinguo.bigdata.c;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* compiled from: FileCache.java */
/* loaded from: classes3.dex */
public class a<T> {
    private static String b;
    private ReadWriteLock a = new ReentrantReadWriteLock();

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private String b(String str) {
        return str.replaceAll("[^a-zA-Z0-9.-]", "_");
    }

    private File d(String str) {
        if (!TextUtils.isEmpty(b)) {
            if (!TextUtils.isEmpty(str)) {
                return new File(b + File.separator + str);
            }
            throw new IllegalArgumentException("Key can not be empty");
        }
        throw new IllegalArgumentException("FileCache must be installed before use.");
    }

    public static void e(Context context) {
        if (context != null) {
            b = context.getCacheDir().getAbsolutePath();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public T c(String str) {
        ObjectInputStream objectInputStream;
        File d2 = d(b(str));
        ?? r4 = 0;
        if (!d2.exists()) {
            return null;
        }
        try {
            try {
                this.a.readLock().lock();
                objectInputStream = new ObjectInputStream(new FileInputStream(d2));
                try {
                    T t = (T) objectInputStream.readObject();
                    a(objectInputStream);
                    this.a.readLock().unlock();
                    return t;
                } catch (FileNotFoundException unused) {
                    us.pinguo.common.log.a.g("FileCache", "GET: Cache file with key " + str + " not exists", new Object[0]);
                    a(objectInputStream);
                    this.a.readLock().unlock();
                    return null;
                } catch (IOException unused2) {
                    us.pinguo.common.log.a.g("FileCache", "GET: Cache file with key " + str + " throws IO Exception", new Object[0]);
                    a(objectInputStream);
                    this.a.readLock().unlock();
                    return null;
                } catch (ClassNotFoundException unused3) {
                    us.pinguo.common.log.a.g("FileCache", "GET: Cache file with key " + str + " throws ClassNotFound Exception", new Object[0]);
                    a(objectInputStream);
                    this.a.readLock().unlock();
                    return null;
                } catch (Exception unused4) {
                    us.pinguo.common.log.a.g("FileCache", "GET: Cache file with key " + str + " cache failed", new Object[0]);
                    a(objectInputStream);
                    this.a.readLock().unlock();
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r4 = d2;
                a(r4);
                this.a.readLock().unlock();
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            objectInputStream = null;
        } catch (IOException unused6) {
            objectInputStream = null;
        } catch (ClassNotFoundException unused7) {
            objectInputStream = null;
        } catch (Exception unused8) {
            objectInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            a(r4);
            this.a.readLock().unlock();
            throw th;
        }
    }

    public void f(String str, T t) {
        ObjectOutputStream objectOutputStream;
        File d2 = d(b(str));
        if (!d2.getParentFile().exists() && !d2.getParentFile().mkdirs()) {
            us.pinguo.common.log.a.g("FileCache", "SET: Cache folder with key " + str + " created failed", new Object[0]);
        }
        if (d2.exists() && !d2.delete()) {
            us.pinguo.common.log.a.g("FileCache", "SET: Delete file with key " + str + " failed", new Object[0]);
            return;
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                this.a.writeLock().lock();
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(d2));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException unused) {
        } catch (IOException unused2) {
        } catch (Exception unused3) {
        }
        try {
            objectOutputStream.writeObject(t);
            a(objectOutputStream);
        } catch (FileNotFoundException unused4) {
            objectOutputStream2 = objectOutputStream;
            us.pinguo.common.log.a.g("FileCache", "SET: Cache file with key " + str + " not exists", new Object[0]);
            a(objectOutputStream2);
            this.a.writeLock().unlock();
        } catch (IOException unused5) {
            objectOutputStream2 = objectOutputStream;
            us.pinguo.common.log.a.g("FileCache", "SET: Cache file with key " + str + " throws IO Exception", new Object[0]);
            a(objectOutputStream2);
            this.a.writeLock().unlock();
        } catch (Exception unused6) {
            objectOutputStream2 = objectOutputStream;
            us.pinguo.common.log.a.g("FileCache", "SET: Cache file with key " + str + " cache failed", new Object[0]);
            a(objectOutputStream2);
            this.a.writeLock().unlock();
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            a(objectOutputStream2);
            this.a.writeLock().unlock();
            throw th;
        }
        this.a.writeLock().unlock();
    }
}
