package com.googlecode.mp4parser.boxes.dece;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import org.aspectj.lang.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class ContentInformationBox extends AbstractFullBox {
    public static final String TYPE = "cinf";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    Map<String, String> brandEntries;
    String codecs;
    Map<String, String> idEntries;
    String languages;
    String mimeSubtypeName;
    String profileLevelIdc;
    String protection;

    /* loaded from: classes2.dex */
    public static class BrandEntry {
        String iso_brand;
        String version;

        public BrandEntry(String str, String str2) {
            this.iso_brand = str;
            this.version = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BrandEntry brandEntry = (BrandEntry) obj;
            String str = this.iso_brand;
            if (str == null ? brandEntry.iso_brand == null : str.equals(brandEntry.iso_brand)) {
                String str2 = this.version;
                String str3 = brandEntry.version;
                return str2 == null ? str3 == null : str2.equals(str3);
            }
            return false;
        }

        public int hashCode() {
            String str = this.iso_brand;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.version;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }
    }

    static {
        ajc$preClinit();
    }

    public ContentInformationBox() {
        super(TYPE);
        this.brandEntries = new LinkedHashMap();
        this.idEntries = new LinkedHashMap();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("ContentInformationBox.java", ContentInformationBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getMimeSubtypeName", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), IjkMediaMeta.FF_PROFILE_H264_HIGH_444);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setMimeSubtypeName", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "mimeSubtypeName", "", "void"), 148);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "getBrandEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.util.Map"), 184);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "setBrandEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.util.Map", "brandEntries", "", "void"), 188);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "getIdEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.util.Map"), 192);
        ajc$tjp_13 = bVar.h("method-execution", bVar.g("1", "setIdEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.util.Map", "idEntries", "", "void"), 196);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getProfileLevelIdc", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 152);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setProfileLevelIdc", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "profileLevelIdc", "", "void"), 156);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getCodecs", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 160);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setCodecs", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "codecs", "", "void"), 164);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getProtection", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 168);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setProtection", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "protection", "", "void"), 172);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "getLanguages", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 176);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setLanguages", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "languages", "", "void"), BaseBlurEffect.ROTATION_180);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.mimeSubtypeName = IsoTypeReader.readString(byteBuffer);
        this.profileLevelIdc = IsoTypeReader.readString(byteBuffer);
        this.codecs = IsoTypeReader.readString(byteBuffer);
        this.protection = IsoTypeReader.readString(byteBuffer);
        this.languages = IsoTypeReader.readString(byteBuffer);
        int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        while (true) {
            int i2 = readUInt8 - 1;
            if (readUInt8 <= 0) {
                break;
            }
            this.brandEntries.put(IsoTypeReader.readString(byteBuffer), IsoTypeReader.readString(byteBuffer));
            readUInt8 = i2;
        }
        int readUInt82 = IsoTypeReader.readUInt8(byteBuffer);
        while (true) {
            int i3 = readUInt82 - 1;
            if (readUInt82 <= 0) {
                return;
            }
            this.idEntries.put(IsoTypeReader.readString(byteBuffer), IsoTypeReader.readString(byteBuffer));
            readUInt82 = i3;
        }
    }

    public Map<String, String> getBrandEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return this.brandEntries;
    }

    public String getCodecs() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.codecs;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, this.mimeSubtypeName);
        IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, this.profileLevelIdc);
        IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, this.codecs);
        IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, this.protection);
        IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, this.languages);
        IsoTypeWriter.writeUInt8(byteBuffer, this.brandEntries.size());
        for (Map.Entry<String, String> entry : this.brandEntries.entrySet()) {
            IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, entry.getKey());
            IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, entry.getValue());
        }
        IsoTypeWriter.writeUInt8(byteBuffer, this.idEntries.size());
        for (Map.Entry<String, String> entry2 : this.idEntries.entrySet()) {
            IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, entry2.getKey());
            IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, entry2.getValue());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        long utf8StringLengthInBytes = Utf8.utf8StringLengthInBytes(this.mimeSubtypeName) + 1 + 4 + Utf8.utf8StringLengthInBytes(this.profileLevelIdc) + 1 + Utf8.utf8StringLengthInBytes(this.codecs) + 1 + Utf8.utf8StringLengthInBytes(this.protection) + 1 + Utf8.utf8StringLengthInBytes(this.languages) + 1 + 1;
        for (Map.Entry<String, String> entry : this.brandEntries.entrySet()) {
            utf8StringLengthInBytes = utf8StringLengthInBytes + Utf8.utf8StringLengthInBytes(entry.getKey()) + 1 + Utf8.utf8StringLengthInBytes(entry.getValue()) + 1;
        }
        long j2 = utf8StringLengthInBytes + 1;
        for (Map.Entry<String, String> entry2 : this.idEntries.entrySet()) {
            j2 = j2 + Utf8.utf8StringLengthInBytes(entry2.getKey()) + 1 + Utf8.utf8StringLengthInBytes(entry2.getValue()) + 1;
        }
        return j2;
    }

    public Map<String, String> getIdEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_12, this, this));
        return this.idEntries;
    }

    public String getLanguages() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.languages;
    }

    public String getMimeSubtypeName() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.mimeSubtypeName;
    }

    public String getProfileLevelIdc() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.profileLevelIdc;
    }

    public String getProtection() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.protection;
    }

    public void setBrandEntries(Map<String, String> map) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, map));
        this.brandEntries = map;
    }

    public void setCodecs(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, str));
        this.codecs = str;
    }

    public void setIdEntries(Map<String, String> map) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, map));
        this.idEntries = map;
    }

    public void setLanguages(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, str));
        this.languages = str;
    }

    public void setMimeSubtypeName(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.mimeSubtypeName = str;
    }

    public void setProfileLevelIdc(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, str));
        this.profileLevelIdc = str;
    }

    public void setProtection(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, str));
        this.protection = str;
    }
}
