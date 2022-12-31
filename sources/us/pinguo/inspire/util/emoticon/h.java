package us.pinguo.inspire.util.emoticon;

import com.rockerhieu.emoji.model.JsonReader;
/* compiled from: EmoticonJsonReader.java */
/* loaded from: classes9.dex */
public class h extends JsonReader {
    @Override // com.rockerhieu.emoji.model.JsonReader
    public Object toObject(String str, Class cls) {
        return new com.google.gson.e().j(str, cls);
    }
}
