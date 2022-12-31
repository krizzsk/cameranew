package com.googlecode.mp4parser;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.FullBox;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public abstract class AbstractFullBox extends AbstractBox implements FullBox {
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private int flags;
    private int version;

    static {
        ajc$preClinit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractFullBox(String str) {
        super(str);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AbstractFullBox.java", AbstractFullBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "setVersion", "com.googlecode.mp4parser.AbstractFullBox", "int", "version", "", "void"), 51);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setFlags", "com.googlecode.mp4parser.AbstractFullBox", "int", "flags", "", "void"), 64);
    }

    @Override // com.coremedia.iso.boxes.FullBox
    @DoNotParseDetail
    public int getFlags() {
        if (!this.isParsed) {
            parseDetails();
        }
        return this.flags;
    }

    @Override // com.coremedia.iso.boxes.FullBox
    @DoNotParseDetail
    public int getVersion() {
        if (!this.isParsed) {
            parseDetails();
        }
        return this.version;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long parseVersionAndFlags(ByteBuffer byteBuffer) {
        this.version = IsoTypeReader.readUInt8(byteBuffer);
        this.flags = IsoTypeReader.readUInt24(byteBuffer);
        return 4L;
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public void setFlags(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.e(i2)));
        this.flags = i2;
    }

    @Override // com.coremedia.iso.boxes.FullBox
    public void setVersion(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_0, this, this, h.a.a.a.a.e(i2)));
        this.version = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt8(byteBuffer, this.version);
        IsoTypeWriter.writeUInt24(byteBuffer, this.flags);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractFullBox(String str, byte[] bArr) {
        super(str, bArr);
    }
}
