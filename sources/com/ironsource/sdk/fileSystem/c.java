package com.ironsource.sdk.fileSystem;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* compiled from: MetadataFileService.java */
/* loaded from: classes2.dex */
public class c {
    private String a;

    public c(String str) {
        this.a = str;
    }

    private void b(ISNFile iSNFile) throws Exception {
        com.ironsource.sdk.utils.c.y(new JSONObject().toString().getBytes(), iSNFile.getPath());
    }

    private ISNFile e() throws Exception {
        ISNFile iSNFile = new ISNFile(this.a, "metadata.json");
        if (!iSNFile.exists()) {
            b(iSNFile);
        }
        return iSNFile;
    }

    private boolean g(JSONObject jSONObject) throws Exception {
        return com.ironsource.sdk.utils.c.y(jSONObject.toString().getBytes(), e().getPath()) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean a(String str, JSONObject jSONObject) throws Exception {
        JSONObject f2;
        f2 = f();
        f2.put(str, jSONObject);
        return g(f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean c(String str) throws Exception {
        JSONObject f2 = f();
        if (f2.has(str)) {
            f2.remove(str);
            return g(f2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(ArrayList<ISNFile> arrayList) throws Exception {
        Iterator<ISNFile> it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!c(it.next().getName())) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized JSONObject f() throws Exception {
        return new JSONObject(com.ironsource.sdk.utils.c.w(e()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean h(String str, JSONObject jSONObject) throws Exception {
        JSONObject f2;
        f2 = f();
        JSONObject optJSONObject = f2.optJSONObject(str);
        if (optJSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                optJSONObject.putOpt(next, jSONObject.opt(next));
            }
        } else {
            f2.putOpt(str, jSONObject);
        }
        return g(f2);
    }
}
