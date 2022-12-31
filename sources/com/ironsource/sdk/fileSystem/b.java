package com.ironsource.sdk.fileSystem;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.ironsource.environment.e;
import com.ironsource.sdk.utils.f;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: FileSystemService.java */
/* loaded from: classes2.dex */
public class b {
    private Context a;
    private d.e.d.o.b b;
    private com.ironsource.sdk.fileSystem.a c;

    /* renamed from: d  reason: collision with root package name */
    private c f5774d;

    /* compiled from: FileSystemService.java */
    /* loaded from: classes2.dex */
    class a implements d.e.d.o.c {
        final /* synthetic */ d.e.d.o.c a;

        /* compiled from: FileSystemService.java */
        /* renamed from: com.ironsource.sdk.fileSystem.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0219a extends JSONObject {
            C0219a(a aVar) throws JSONException {
                put("lastReferencedTime", System.currentTimeMillis());
            }
        }

        a(d.e.d.o.c cVar) {
            this.a = cVar;
        }

        @Override // d.e.d.o.c
        public void g(ISNFile iSNFile) {
            this.a.g(iSNFile);
            try {
                b.this.f5774d.a(iSNFile.getName(), new C0219a(this));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.e.d.o.c
        public void l(ISNFile iSNFile, com.ironsource.sdk.data.c cVar) {
            this.a.l(iSNFile, cVar);
        }
    }

    public b(Context context, d.e.d.o.b bVar, com.ironsource.sdk.fileSystem.a aVar, c cVar) {
        this.a = context;
        this.b = bVar;
        this.c = aVar;
        this.f5774d = cVar;
    }

    public void b(ISNFile iSNFile) throws Exception {
        if (iSNFile.exists()) {
            if (iSNFile.delete()) {
                this.f5774d.c(iSNFile.getName());
                return;
            }
            throw new Exception("Failed to delete file");
        }
    }

    public void c(ISNFile iSNFile) throws Exception {
        if (iSNFile.exists()) {
            ArrayList<ISNFile> n = com.ironsource.sdk.utils.c.n(iSNFile);
            if (com.ironsource.sdk.utils.c.i(iSNFile) && iSNFile.delete()) {
                this.f5774d.d(n);
                return;
            }
            throw new Exception("Failed to delete folder");
        }
    }

    public JSONObject d(ISNFile iSNFile) throws Exception {
        if (iSNFile.exists()) {
            return com.ironsource.sdk.utils.c.c(iSNFile, this.f5774d.f());
        }
        throw new Exception("Folder does not exist");
    }

    public long e(ISNFile iSNFile) throws Exception {
        if (iSNFile.exists()) {
            return com.ironsource.sdk.utils.c.r(iSNFile);
        }
        throw new Exception("Folder does not exist");
    }

    public void f(ISNFile iSNFile, String str, d.e.d.o.c cVar) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            if (e.j(this.b.f()) > 0) {
                if (f.w()) {
                    if (d.e.c.a.f(this.a)) {
                        this.c.a(iSNFile.getPath(), new a(cVar));
                        if (iSNFile.exists()) {
                            Message message = new Message();
                            message.obj = iSNFile;
                            message.what = 1015;
                            this.c.handleMessage(message);
                            return;
                        }
                        this.b.c(iSNFile, str, this.c);
                        return;
                    }
                    throw new Exception("no_network_connection");
                }
                throw new Exception("sotrage_unavailable");
            }
            throw new Exception("no_disk_space");
        }
        throw new Exception("Missing params for file");
    }

    public void g(ISNFile iSNFile, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            if (iSNFile.exists()) {
                if (!this.f5774d.h(iSNFile.getName(), jSONObject)) {
                    throw new Exception("Failed to update attribute");
                }
                return;
            }
            throw new Exception("File does not exist");
        }
        throw new Exception("Missing attributes to update");
    }
}
