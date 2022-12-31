package us.pinguo.location;

import android.app.Application;
import android.text.TextUtils;
import us.pinguo.librouter.b.c.e;
import us.pinguo.librouter.b.c.f;
/* loaded from: classes5.dex */
public class LocationLib extends us.pinguo.librouter.b.c.a {
    private String mCacheLocation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements us.pinguo.librouter.b.c.b {
        a() {
        }

        @Override // us.pinguo.librouter.b.c.b
        public void a(f fVar) {
            String e2 = f.e(fVar);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            LocationLib.this.mCacheLocation = e2;
        }

        @Override // us.pinguo.librouter.b.c.b
        public f b() {
            return f.a(LocationLib.this.mCacheLocation == null ? "" : LocationLib.this.mCacheLocation);
        }
    }

    @Override // us.pinguo.librouter.b.a
    public void initLib(Application application) {
        initLocation(application);
    }

    public void initLocation(Application application) {
        d.c().g(application, true, new a());
    }

    @Override // us.pinguo.librouter.b.a
    public e initInterface() {
        return new b();
    }
}
