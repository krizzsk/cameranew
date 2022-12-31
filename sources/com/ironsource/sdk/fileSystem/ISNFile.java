package com.ironsource.sdk.fileSystem;

import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* loaded from: classes2.dex */
public class ISNFile extends File {
    public ISNFile(String str, String str2) {
        super(str, str2);
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", getName());
        jSONObject.put(PGEditResultActivity2.PATH, getPath());
        jSONObject.put("lastModified", lastModified());
        if (isFile()) {
            jSONObject.put(BigAlbumStore.PhotoColumns.SIZE, length());
        }
        return jSONObject;
    }

    @Override // java.io.File
    public String toString() {
        return "ISNFile(name: " + getName() + ", path: " + getPath() + ", isFile: " + isFile() + ", isDirectory: " + isDirectory() + ", lastModified: " + lastModified() + ", length: " + length() + ")";
    }

    public ISNFile(String str) {
        super(str);
    }
}
