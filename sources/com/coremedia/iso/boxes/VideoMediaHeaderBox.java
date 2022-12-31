package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class VideoMediaHeaderBox extends AbstractMediaHeaderBox {
    public static final String TYPE = "vmhd";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private int graphicsmode;
    private int[] opcolor;

    static {
        ajc$preClinit();
    }

    public VideoMediaHeaderBox() {
        super(TYPE);
        this.graphicsmode = 0;
        this.opcolor = new int[3];
        setFlags(1);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("VideoMediaHeaderBox.java", VideoMediaHeaderBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "int"), 39);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "[I"), 43);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "", "", "", "java.lang.String"), 71);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setOpcolor", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "[I", "opcolor", "", "void"), 75);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "setGraphicsmode", "com.coremedia.iso.boxes.VideoMediaHeaderBox", "int", "graphicsmode", "", "void"), 79);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.graphicsmode = IsoTypeReader.readUInt16(byteBuffer);
        this.opcolor = new int[3];
        for (int i2 = 0; i2 < 3; i2++) {
            this.opcolor[i2] = IsoTypeReader.readUInt16(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt16(byteBuffer, this.graphicsmode);
        for (int i2 : this.opcolor) {
            IsoTypeWriter.writeUInt16(byteBuffer, i2);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 12L;
    }

    public int getGraphicsmode() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.graphicsmode;
    }

    public int[] getOpcolor() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.opcolor;
    }

    public void setGraphicsmode(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_4, this, this, h.a.a.a.a.e(i2)));
        this.graphicsmode = i2;
    }

    public void setOpcolor(int[] iArr) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, iArr));
        this.opcolor = iArr;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "VideoMediaHeaderBox[graphicsmode=" + getGraphicsmode() + ";opcolor0=" + getOpcolor()[0] + ";opcolor1=" + getOpcolor()[1] + ";opcolor2=" + getOpcolor()[2] + "]";
    }
}
