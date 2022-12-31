package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class KeywordsBox extends AbstractFullBox {
    public static final String TYPE = "kywd";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private String[] keywords;
    private String language;

    static {
        ajc$preClinit();
    }

    public KeywordsBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("KeywordsBox.java", KeywordsBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getLanguage", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "java.lang.String"), 40);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getKeywords", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "[Ljava.lang.String;"), 44);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "setLanguage", "com.coremedia.iso.boxes.KeywordsBox", "java.lang.String", IjkMediaMeta.IJKM_KEY_LANGUAGE, "", "void"), 48);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setKeywords", "com.coremedia.iso.boxes.KeywordsBox", "[Ljava.lang.String;", "keywords", "", "void"), 52);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "java.lang.String"), 87);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = IsoTypeReader.readIso639(byteBuffer);
        int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.keywords = new String[readUInt8];
        for (int i2 = 0; i2 < readUInt8; i2++) {
            IsoTypeReader.readUInt8(byteBuffer);
            this.keywords[i2] = IsoTypeReader.readString(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        String[] strArr;
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        IsoTypeWriter.writeUInt8(byteBuffer, this.keywords.length);
        for (String str : this.keywords) {
            IsoTypeWriter.writeUInt8(byteBuffer, Utf8.utf8StringLengthInBytes(str) + 1);
            byteBuffer.put(Utf8.convert(str));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        long j2 = 7;
        for (String str : this.keywords) {
            j2 += Utf8.utf8StringLengthInBytes(str) + 1 + 1;
        }
        return j2;
    }

    public String[] getKeywords() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.keywords;
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.language;
    }

    public void setKeywords(String[] strArr) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, strArr));
        this.keywords = strArr;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_2, this, this, str));
        this.language = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("KeywordsBox[language=");
        stringBuffer.append(getLanguage());
        for (int i2 = 0; i2 < this.keywords.length; i2++) {
            stringBuffer.append(";keyword");
            stringBuffer.append(i2);
            stringBuffer.append("=");
            stringBuffer.append(this.keywords[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
