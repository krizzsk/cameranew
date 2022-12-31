package com.coremedia.iso.boxes;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public final class OmaDrmAccessUnitFormatBox extends AbstractFullBox {
    public static final String TYPE = "odaf";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private byte allBits;
    private int initVectorLength;
    private int keyIndicatorLength;
    private boolean selectiveEncryption;

    static {
        ajc$preClinit();
    }

    public OmaDrmAccessUnitFormatBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("OmaDrmAccessUnitFormatBox.java", OmaDrmAccessUnitFormatBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "isSelectiveEncryption", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 46);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getKeyIndicatorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 50);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getInitVectorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 54);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setInitVectorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "int", "initVectorLength", "", "void"), 58);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "setKeyIndicatorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "int", "keyIndicatorLength", "", "void"), 62);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setAllBits", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "byte", "allBits", "", "void"), 66);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        byte readUInt8 = (byte) IsoTypeReader.readUInt8(byteBuffer);
        this.allBits = readUInt8;
        this.selectiveEncryption = (readUInt8 & 128) == 128;
        this.keyIndicatorLength = IsoTypeReader.readUInt8(byteBuffer);
        this.initVectorLength = IsoTypeReader.readUInt8(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt8(byteBuffer, this.allBits);
        IsoTypeWriter.writeUInt8(byteBuffer, this.keyIndicatorLength);
        IsoTypeWriter.writeUInt8(byteBuffer, this.initVectorLength);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 7L;
    }

    public int getInitVectorLength() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.initVectorLength;
    }

    public int getKeyIndicatorLength() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.keyIndicatorLength;
    }

    public boolean isSelectiveEncryption() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.selectiveEncryption;
    }

    public void setAllBits(byte b) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, h.a.a.a.a.b(b)));
        this.allBits = b;
        this.selectiveEncryption = (b & 128) == 128;
    }

    public void setInitVectorLength(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.e(i2)));
        this.initVectorLength = i2;
    }

    public void setKeyIndicatorLength(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_4, this, this, h.a.a.a.a.e(i2)));
        this.keyIndicatorLength = i2;
    }
}
