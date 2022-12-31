package us.pinguo.repository2020.database.paint;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
/* compiled from: PaintMaterialDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface a {
    @Query("delete from paint_material where id in (:materialDetailIds)")
    void a(List<String> list);

    @Insert(onConflict = 1)
    void b(PaintMaterialTable... paintMaterialTableArr);

    @Query("select * from paint_material")
    List<PaintMaterialTable> getAll();
}
