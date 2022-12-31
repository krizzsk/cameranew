package com.mp4parser.iso14496.part15;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* loaded from: classes3.dex */
public class PriotityRangeBox extends AbstractBox {
    public static final String TYPE = "svpr";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    int max_priorityId;
    int min_priorityId;
    int reserved1;
    int reserved2;

    static {
        ajc$preClinit();
    }

    public PriotityRangeBox() {
        super(TYPE);
        this.reserved1 = 0;
        this.reserved2 = 0;
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("PriotityRangeBox.java", PriotityRangeBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getReserved1", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 45);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setReserved1", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", BigAlbumStore.PhotoColumns.RESERVED1, "", "void"), 49);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getMin_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 53);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setMin_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", "min_priorityId", "", "void"), 57);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getReserved2", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 61);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setReserved2", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", BigAlbumStore.PhotoColumns.RESERVED2, "", "void"), 65);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getMax_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 69);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setMax_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", "max_priorityId", "", "void"), 73);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.min_priorityId = readUInt8;
        this.reserved1 = (readUInt8 & 192) >> 6;
        this.min_priorityId = readUInt8 & 63;
        int readUInt82 = IsoTypeReader.readUInt8(byteBuffer);
        this.max_priorityId = readUInt82;
        this.reserved2 = (readUInt82 & 192) >> 6;
        this.max_priorityId = readUInt82 & 63;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt8(byteBuffer, (this.reserved1 << 6) + this.min_priorityId);
        IsoTypeWriter.writeUInt8(byteBuffer, (this.reserved2 << 6) + this.max_priorityId);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 2L;
    }

    public int getMax_priorityId() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.max_priorityId;
    }

    public int getMin_priorityId() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.min_priorityId;
    }

    public int getReserved1() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.reserved1;
    }

    public int getReserved2() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.reserved2;
    }

    public void setMax_priorityId(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, h.a.a.a.a.e(i2)));
        this.max_priorityId = i2;
    }

    public void setMin_priorityId(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.e(i2)));
        this.min_priorityId = i2;
    }

    public void setReserved1(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.e(i2)));
        this.reserved1 = i2;
    }

    public void setReserved2(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, h.a.a.a.a.e(i2)));
        this.reserved2 = i2;
    }
}
