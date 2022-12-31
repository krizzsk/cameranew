package us.pinguo.inspire.a0;

import java.io.IOException;
import java.lang.reflect.Type;
import us.pinguo.inspire.Inspire;
/* compiled from: GsonBiCache.java */
/* loaded from: classes4.dex */
public class c<T> extends e<T> {
    private T mMemCache;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(d dVar) {
        super(dVar);
        try {
            this.mMemCache = (T) super.getObject();
        } catch (Exception e2) {
            Inspire.f(e2);
        }
    }

    @Override // us.pinguo.inspire.a0.e
    public void clear() {
        super.clear();
        this.mMemCache = null;
    }

    @Override // us.pinguo.inspire.a0.e, us.pinguo.inspire.a0.f
    public T getObject() throws IOException {
        T t = this.mMemCache;
        if (t != null) {
            return t;
        }
        T t2 = (T) super.getObject();
        this.mMemCache = t2;
        return t2;
    }

    @Override // us.pinguo.inspire.a0.e, us.pinguo.inspire.a0.f
    public void putObject(T t) throws Exception {
        super.putObject(t);
        this.mMemCache = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(d dVar, Type type) {
        super(dVar);
        setType(type);
        try {
            this.mMemCache = (T) super.getObject();
        } catch (Exception e2) {
            Inspire.f(e2);
        }
    }
}
