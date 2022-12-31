package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class CleanApertureAtom extends AbstractFullBox {
    public static final String TYPE = "clef";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    double height;
    double width;

    static {
        ajc$preClinit();
    }

    public CleanApertureAtom() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("CleanApertureAtom.java", CleanApertureAtom.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getWidth", "com.googlecode.mp4parser.boxes.apple.CleanApertureAtom", "", "", "", "double"), 45);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setWidth", "com.googlecode.mp4parser.boxes.apple.CleanApertureAtom", "double", "width", "", "void"), 49);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getHeight", "com.googlecode.mp4parser.boxes.apple.CleanApertureAtom", "", "", "", "double"), 53);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setHeight", "com.googlecode.mp4parser.boxes.apple.CleanApertureAtom", "double", "height", "", "void"), 57);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.width = IsoTypeReader.readFixedPoint1616(byteBuffer);
        this.height = IsoTypeReader.readFixedPoint1616(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.width);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.height);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 12L;
    }

    public double getHeight() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.height;
    }

    public double getWidth() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.width;
    }

    public void setHeight(double d2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.c(d2)));
        this.height = d2;
    }

    public void setWidth(double d2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.c(d2)));
        this.width = d2;
    }
}
