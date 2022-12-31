package com.coremedia.iso.boxes.dece;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class TrickPlayBox extends AbstractFullBox {
    public static final String TYPE = "trik";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private List<Entry> entries;

    /* loaded from: classes.dex */
    public static class Entry {
        private int value;

        public Entry() {
        }

        public int getDependencyLevel() {
            return this.value & 63;
        }

        public int getPicType() {
            return (this.value >> 6) & 3;
        }

        public void setDependencyLevel(int i2) {
            this.value = (i2 & 63) | this.value;
        }

        public void setPicType(int i2) {
            int i3 = this.value & 31;
            this.value = i3;
            this.value = ((i2 & 3) << 6) | i3;
        }

        public String toString() {
            return "Entry{picType=" + getPicType() + ",dependencyLevel=" + getDependencyLevel() + '}';
        }

        public Entry(int i2) {
            this.value = i2;
        }
    }

    static {
        ajc$preClinit();
    }

    public TrickPlayBox() {
        super(TYPE);
        this.entries = new ArrayList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrickPlayBox.java", TrickPlayBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "setEntries", "com.coremedia.iso.boxes.dece.TrickPlayBox", "java.util.List", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "void"), 32);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getEntries", "com.coremedia.iso.boxes.dece.TrickPlayBox", "", "", "", "java.util.List"), 36);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.dece.TrickPlayBox", "", "", "", "java.lang.String"), 103);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        while (byteBuffer.remaining() > 0) {
            this.entries.add(new Entry(IsoTypeReader.readUInt8(byteBuffer)));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        for (Entry entry : this.entries) {
            IsoTypeWriter.writeUInt8(byteBuffer, entry.value);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return this.entries.size() + 4;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_0, this, this, list));
        this.entries = list;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "TrickPlayBox{entries=" + this.entries + '}';
    }
}
