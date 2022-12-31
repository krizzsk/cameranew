package us.pinguo.repository2020.database.staticsticker;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
/* compiled from: StickerTemplateCollectionDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface i {
    @Query("DELETE FROM sticker_template_collection WHERE tid = :id")
    void a(String str);

    @Insert(onConflict = 1)
    void b(k kVar);

    @Query("SELECT * FROM sticker_template_collection")
    List<k> getAll();
}
