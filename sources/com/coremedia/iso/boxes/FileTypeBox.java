package com.coremedia.iso.boxes;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class FileTypeBox extends AbstractBox {
    public static final String TYPE = "ftyp";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private List<String> compatibleBrands;
    private String majorBrand;
    private long minorVersion;

    static {
        ajc$preClinit();
    }

    public FileTypeBox() {
        super(TYPE);
        this.compatibleBrands = Collections.emptyList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("FileTypeBox.java", FileTypeBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.lang.String"), 85);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setMajorBrand", "com.coremedia.iso.boxes.FileTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "setMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", Constants.LONG, "minorVersion", "", "void"), 103);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "getMinorVersion", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", Constants.LONG), 113);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "", "", "", "java.util.List"), 122);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setCompatibleBrands", "com.coremedia.iso.boxes.FileTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.majorBrand = IsoTypeReader.read4cc(byteBuffer);
        this.minorVersion = IsoTypeReader.readUInt32(byteBuffer);
        int remaining = byteBuffer.remaining() / 4;
        this.compatibleBrands = new LinkedList();
        for (int i2 = 0; i2 < remaining; i2++) {
            this.compatibleBrands.add(IsoTypeReader.read4cc(byteBuffer));
        }
    }

    public List<String> getCompatibleBrands() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.compatibleBrands;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(IsoFile.fourCCtoBytes(this.majorBrand));
        IsoTypeWriter.writeUInt32(byteBuffer, this.minorVersion);
        for (String str : this.compatibleBrands) {
            byteBuffer.put(IsoFile.fourCCtoBytes(str));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (this.compatibleBrands.size() * 4) + 8;
    }

    public String getMajorBrand() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.majorBrand;
    }

    public long getMinorVersion() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.minorVersion;
    }

    public void setCompatibleBrands(List<String> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, list));
        this.compatibleBrands = list;
    }

    public void setMajorBrand(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.majorBrand = str;
    }

    public void setMinorVersion(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_2, this, this, h.a.a.a.a.f(j2)));
        this.minorVersion = j2;
    }

    @DoNotParseDetail
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileTypeBox[");
        sb.append("majorBrand=");
        sb.append(getMajorBrand());
        sb.append(";");
        sb.append("minorVersion=");
        sb.append(getMinorVersion());
        for (String str : this.compatibleBrands) {
            sb.append(";");
            sb.append("compatibleBrand=");
            sb.append(str);
        }
        sb.append("]");
        return sb.toString();
    }

    public FileTypeBox(String str, long j2, List<String> list) {
        super(TYPE);
        this.compatibleBrands = Collections.emptyList();
        this.majorBrand = str;
        this.minorVersion = j2;
        this.compatibleBrands = list;
    }
}
