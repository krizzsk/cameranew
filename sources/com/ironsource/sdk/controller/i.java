package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.fileSystem.ISNFile;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileSystemJSAdapter.java */
/* loaded from: classes2.dex */
public class i {
    private String a;
    private com.ironsource.sdk.fileSystem.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileSystemJSAdapter.java */
    /* loaded from: classes2.dex */
    public class a implements d.e.d.o.c {
        final /* synthetic */ l a;
        final /* synthetic */ k b;

        a(l lVar, k kVar) {
            this.a = lVar;
            this.b = kVar;
        }

        @Override // d.e.d.o.c
        public void g(ISNFile iSNFile) {
            try {
                l lVar = this.a;
                k kVar = this.b;
                lVar.b(kVar, i.this.g(kVar, iSNFile.toJSONObject()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // d.e.d.o.c
        public void l(ISNFile iSNFile, com.ironsource.sdk.data.c cVar) {
            try {
                l lVar = this.a;
                k kVar = this.b;
                lVar.a(kVar, i.this.c(kVar, cVar.b()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, com.ironsource.sdk.fileSystem.b bVar) {
        this.a = str;
        this.b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject c(k kVar, String str) {
        try {
            return kVar.e().put("errMsg", str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    private ISNFile d(JSONObject jSONObject, String str) throws Exception {
        if (jSONObject.has("folderPath")) {
            return new ISNFile(com.ironsource.sdk.utils.c.a(str, jSONObject.getString("folderPath")));
        }
        throw new Exception("Missing params for folder");
    }

    private ISNFile e(JSONObject jSONObject, String str) throws Exception {
        if (jSONObject.has("filePath") && jSONObject.has("fileName")) {
            String string = jSONObject.getString("filePath");
            return new ISNFile(com.ironsource.sdk.utils.c.a(str, string), jSONObject.getString("fileName"));
        }
        throw new Exception("Missing params for file");
    }

    private JSONObject f(k kVar, long j2) {
        try {
            return kVar.e().put("result", j2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject g(k kVar, JSONObject jSONObject) {
        try {
            return kVar.e().put("result", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    private d.e.d.o.c i(k kVar, l lVar) {
        return new a(lVar, kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(JSONObject jSONObject, WebController.r.b0 b0Var) {
        k kVar = new k(jSONObject);
        l lVar = new l(b0Var);
        try {
            String b = kVar.b();
            JSONObject c = kVar.c();
            char c2 = 65535;
            switch (b.hashCode()) {
                case -2073025383:
                    if (b.equals("saveFile")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1137024519:
                    if (b.equals("deleteFolder")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -318115535:
                    if (b.equals("getTotalSizeOfFiles")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 537556755:
                    if (b.equals("updateAttributesOfFile")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1764172231:
                    if (b.equals("deleteFile")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1953259713:
                    if (b.equals("getFiles")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                this.b.f(e(c, this.a), c.optString("fileUrl"), i(kVar, lVar));
            } else if (c2 == 1) {
                ISNFile e2 = e(c, this.a);
                this.b.b(e2);
                lVar.b(kVar, g(kVar, e2.toJSONObject()));
            } else if (c2 == 2) {
                ISNFile d2 = d(c, this.a);
                this.b.c(d2);
                lVar.b(kVar, g(kVar, d2.toJSONObject()));
            } else if (c2 == 3) {
                lVar.b(kVar, g(kVar, this.b.d(d(c, this.a))));
            } else if (c2 == 4) {
                lVar.b(kVar, f(kVar, this.b.e(d(c, this.a))));
            } else if (c2 != 5) {
            } else {
                ISNFile e3 = e(c, this.a);
                this.b.g(e3, c.optJSONObject("attributesToUpdate"));
                lVar.b(kVar, g(kVar, e3.toJSONObject()));
            }
        } catch (Exception e4) {
            lVar.a(kVar, c(kVar, e4.getMessage()));
        }
    }
}
