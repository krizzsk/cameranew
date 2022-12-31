package us.pinguo.inspire.a0;

import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.j;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.channels.FileLock;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import us.pinguo.inspire.Inspire;
import us.pinguo.util.k;
import us.pinguo.util.l;
/* compiled from: GsonDiskCache.java */
/* loaded from: classes4.dex */
public class e<T> extends g<T> {
    public static final String TAG = "us.pinguo.inspire.a0.e";
    private d mDir;
    private Type mType;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(d dVar) {
        this.mDir = dVar;
        l.f(dVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Object b(Integer num) {
        return wrap().a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ Object c(Object obj, Object obj2) {
        wrap().b(obj);
        return obj;
    }

    public static FileLock getFileLock(File file) throws IOException {
        return new RandomAccessFile(file, "rw").getChannel().lock();
    }

    private String getFilePath() {
        return this.mDir.toString();
    }

    private String getFromFile(String str) {
        String d2;
        File file = new File(str);
        return (file.exists() && (d2 = k.d(file)) != null) ? d2 : "";
    }

    private T loadObject() throws IOException, JsonSyntaxException {
        FileLock fileLock = getFileLock(new File(getFilePath()));
        String fromFile = getFromFile(getFilePath());
        fileLock.release();
        Type entityType = getEntityType();
        if (fromFile == null || TextUtils.isEmpty(fromFile)) {
            return null;
        }
        return (T) new com.google.gson.e().k(fromFile, entityType);
    }

    private void saveToFile(String str) throws Exception {
        File file = new File(getFilePath());
        FileLock fileLock = getFileLock(file);
        k.l(file, str);
        fileLock.release();
    }

    public void clear() {
        try {
            saveToFile("");
        } catch (Exception e2) {
            Inspire.f(e2);
        }
    }

    public /* synthetic */ Object d(Object obj, Object obj2) {
        c(obj, obj2);
        return obj;
    }

    protected Type getEntityType() {
        Type type = this.mType;
        return type != null ? type : ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override // us.pinguo.inspire.a0.f
    public T getObject() throws IOException {
        return loadObject();
    }

    public Observable<T> peekObject() {
        return Observable.just(0).subscribeOn(Schedulers.io()).map(new Func1() { // from class: us.pinguo.inspire.a0.b
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return e.this.b((Integer) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<T> postObject(final T t) {
        return Observable.just(t).subscribeOn(Schedulers.io()).map(new Func1() { // from class: us.pinguo.inspire.a0.a
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                e eVar = e.this;
                Object obj2 = t;
                eVar.d(obj2, obj);
                return obj2;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // us.pinguo.inspire.a0.f
    public void putObject(T t) throws Exception {
        if (t == null) {
            return;
        }
        saveToFile(new com.google.gson.e().s(t));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setType(Type type) {
        this.mType = type;
    }

    public T getObject(Class cls, j jVar) throws IOException {
        return loadObject(cls, jVar);
    }

    private T loadObject(Class cls, j jVar) throws IOException, JsonSyntaxException {
        FileLock fileLock = getFileLock(new File(getFilePath()));
        String fromFile = getFromFile(getFilePath());
        fileLock.release();
        Type entityType = getEntityType();
        if (fromFile == null || TextUtils.isEmpty(fromFile)) {
            return null;
        }
        com.google.gson.f fVar = new com.google.gson.f();
        fVar.d(cls, jVar);
        return (T) fVar.b().k(fromFile, entityType);
    }
}
