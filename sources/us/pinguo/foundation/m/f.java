package us.pinguo.foundation.m;

import android.text.TextUtils;
import com.android.volley.Network;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.BasicNetwork;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.DirectOutputHurlStack;
import us.pinguo.foundation.m.e;
/* compiled from: RxVolley.java */
/* loaded from: classes4.dex */
public class f {
    private static Network a;
    private static Map<String, WeakReference<Observable<?>>> b;
    private static Func1<VolleyError, Throwable> c;

    public static <T> Observable<T> a(final j<T> jVar) {
        if (b == null) {
            b = new HashMap();
        }
        Observable<T> subscribeOn = Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.foundation.m.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                f.e(j.this, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io());
        b.put(jVar.getCacheKey(), new WeakReference<>(subscribeOn));
        return subscribeOn;
    }

    private static Network b() {
        return new BasicNetwork((BaseHttpStack) new DirectOutputHurlStack());
    }

    public static <T> Response<T> c(j<T> jVar) {
        if (a == null) {
            a = b();
        }
        return d(jVar, a);
    }

    public static <T> Response<T> d(j<T> jVar, Network network) {
        try {
            return jVar.parseVolleyResponse(network.performRequest(jVar));
        } catch (VolleyError e2) {
            return Response.error(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(j jVar, Subscriber subscriber) {
        if (a == null) {
            a = b();
        }
        try {
            Response c2 = c(jVar);
            if (c2.isSuccess()) {
                subscriber.onNext(c2.result);
                subscriber.onCompleted();
            } else {
                Func1<VolleyError, Throwable> func1 = c;
                if (func1 != null) {
                    subscriber.onError(func1.call(c2.error));
                } else {
                    subscriber.onError(c2.error);
                }
            }
        } catch (Exception e2) {
            subscriber.onError(e2);
        }
        b.remove(jVar.getCacheKey());
    }

    public static <T> Observable<T> f(j<T> jVar) {
        return a(jVar).observeOn(AndroidSchedulers.mainThread());
    }

    public static void g(Func1<VolleyError, Throwable> func1) {
        c = func1;
    }

    /* compiled from: RxVolley.java */
    /* loaded from: classes4.dex */
    public static class a<T> {
        String mBody;
        String mCacheKey;
        private long mContentLength;
        Type mEntityType;
        File mFile;
        String mFileKey;
        boolean mIsMkFile;
        boolean mIsOctetStream;
        e.a mListener;
        String mMimeType;
        File mOctetFile;
        long mOctetFileOffset;
        Map<String, String> mParams;
        private String mToken;
        String mUrl;
        int mMethod = 0;
        List<k> mExtraParams = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RxVolley.java */
        /* renamed from: us.pinguo.foundation.m.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0394a extends l<T> {
            C0394a(File file, long j2, long j3, String str, int i2, String str2, e.a aVar) {
                super(file, j2, j3, str, i2, str2, aVar);
            }

            @Override // us.pinguo.foundation.m.g
            protected Type getEntityType() {
                a aVar = a.this;
                Type type = aVar.mEntityType;
                return type != null ? type : ((ParameterizedType) aVar.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RxVolley.java */
        /* loaded from: classes4.dex */
        public class b extends h {
            b(String str, String str2, int i2, String str3) {
                super(str, str2, i2, str3);
            }

            @Override // us.pinguo.foundation.m.g
            protected Type getEntityType() {
                a aVar = a.this;
                Type type = aVar.mEntityType;
                return type != null ? type : ((ParameterizedType) aVar.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RxVolley.java */
        /* loaded from: classes4.dex */
        public class c extends g<T> {
            c(int i2, String str) {
                super(i2, str);
            }

            @Override // us.pinguo.foundation.m.g
            protected Type getEntityType() {
                a aVar = a.this;
                Type type = aVar.mEntityType;
                return type != null ? type : ((ParameterizedType) aVar.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RxVolley.java */
        /* loaded from: classes4.dex */
        public class d extends i<T> {
            d(int i2, String str, e.a aVar) {
                super(i2, str, aVar);
            }

            @Override // us.pinguo.foundation.m.g
            protected Type getEntityType() {
                a aVar = a.this;
                Type type = aVar.mEntityType;
                return type != null ? type : ((ParameterizedType) aVar.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            }
        }

        public a<T> body(String str) {
            this.mBody = str;
            return this;
        }

        public j<T> build() {
            j<T> createVolleyRequest = createVolleyRequest();
            Map<String, String> map = this.mParams;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    createVolleyRequest.a(entry.getKey(), entry.getValue());
                }
            }
            List<k> list = this.mExtraParams;
            if (list != null) {
                for (k kVar : list) {
                    createVolleyRequest.b(kVar);
                }
            }
            createVolleyRequest.c(this.mCacheKey);
            return createVolleyRequest;
        }

        public a<T> contentLength(long j2) {
            this.mContentLength = j2;
            return this;
        }

        j<T> createVolleyRequest() {
            if (this.mIsOctetStream) {
                return new C0394a(this.mOctetFile, this.mOctetFileOffset, this.mContentLength, this.mToken, this.mMethod, this.mUrl, this.mListener);
            }
            if (this.mIsMkFile) {
                return new b(this.mToken, this.mBody, this.mMethod, this.mUrl);
            }
            if (this.mFile == null) {
                return new c(this.mMethod, this.mUrl);
            }
            d dVar = new d(this.mMethod, this.mUrl, this.mListener);
            dVar.d(this.mFileKey, this.mFile, this.mMimeType);
            return dVar;
        }

        public Map<String, String> getParams() {
            if (this.mParams == null) {
                this.mParams = new HashMap();
            }
            return this.mParams;
        }

        public a<T> method(int i2) {
            this.mMethod = i2;
            return this;
        }

        public a<T> mkfile(boolean z) {
            this.mIsMkFile = z;
            return this;
        }

        public a<T> octetFile(File file) {
            this.mOctetFile = file;
            return this;
        }

        public a<T> octetOffset(long j2) {
            this.mOctetFileOffset = j2;
            return this;
        }

        public a<T> octetStream(boolean z) {
            this.mIsOctetStream = z;
            return this;
        }

        public a<T> progressListener(e.a aVar) {
            this.mListener = aVar;
            return this;
        }

        public a<T> put(String str, String str2) {
            if (this.mParams == null) {
                this.mParams = new HashMap();
            }
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                this.mParams.put(str, str2);
            }
            return this;
        }

        public a<T> putDefault(String str, String str2, String str3) {
            if (TextUtils.isEmpty(str2)) {
                str2 = str3;
            }
            return put(str, str2);
        }

        public a<T> putNonNull(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                put(str, str2);
            }
            return this;
        }

        public a<T> setCacheKey(String str) {
            this.mCacheKey = str;
            return this;
        }

        public a<T> token(String str) {
            this.mToken = str;
            return this;
        }

        public a<T> type(Type type) {
            this.mEntityType = type;
            return this;
        }

        public a<T> url(String str) {
            this.mUrl = str;
            return this;
        }

        public a<T> put(Map<String, String> map) {
            if (this.mParams == null) {
                this.mParams = new HashMap();
            }
            this.mParams.putAll(map);
            return this;
        }

        public a<T> put(String str, boolean z) {
            put(str, z + "");
            return this;
        }

        public a<T> put(String str, long j2) {
            put(str, j2 + "");
            return this;
        }

        public a<T> put(String str, int i2) {
            put(str, i2 + "");
            return this;
        }

        public a<T> put(String str, double d2) {
            put(str, d2 + "");
            return this;
        }

        public a<T> put(String str, File file, String str2) {
            this.mFileKey = str;
            this.mFile = file;
            this.mMimeType = str2;
            return this;
        }

        public a<T> put(k kVar) {
            if (kVar != null) {
                this.mExtraParams.add(kVar);
            }
            return this;
        }
    }
}
