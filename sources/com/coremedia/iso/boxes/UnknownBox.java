package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class UnknownBox extends AbstractBox {
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    ByteBuffer data;

    static {
        ajc$preClinit();
    }

    public UnknownBox(String str) {
        super(str);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("UnknownBox.java", UnknownBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getData", "com.coremedia.iso.boxes.UnknownBox", "", "", "", "java.nio.ByteBuffer"), 52);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setData", "com.coremedia.iso.boxes.UnknownBox", "java.nio.ByteBuffer", "data", "", "void"), 56);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        this.data.rewind();
        byteBuffer.put(this.data);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return this.data.limit();
    }

    public ByteBuffer getData() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.data;
    }

    public void setData(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, byteBuffer));
        this.data = byteBuffer;
    }
}
