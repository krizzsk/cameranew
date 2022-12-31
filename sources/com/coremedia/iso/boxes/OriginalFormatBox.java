package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class OriginalFormatBox extends AbstractBox {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "frma";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private String dataFormat;

    static {
        ajc$preClinit();
    }

    public OriginalFormatBox() {
        super(TYPE);
        this.dataFormat = "    ";
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("OriginalFormatBox.java", OriginalFormatBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getDataFormat", "com.coremedia.iso.boxes.OriginalFormatBox", "", "", "", "java.lang.String"), 42);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setDataFormat", "com.coremedia.iso.boxes.OriginalFormatBox", "java.lang.String", "dataFormat", "", "void"), 47);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.OriginalFormatBox", "", "", "", "java.lang.String"), 67);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.dataFormat = IsoTypeReader.read4cc(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(IsoFile.fourCCtoBytes(this.dataFormat));
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 4L;
    }

    public String getDataFormat() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.dataFormat;
    }

    public void setDataFormat(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.dataFormat = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "OriginalFormatBox[dataFormat=" + getDataFormat() + "]";
    }
}
