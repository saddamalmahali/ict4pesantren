/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model.listener;

import aplikasipesantren.entity.Pelajaran;
import aplikasipesantrenclient.model.PelajaranModel;

/**
 *
 * @author Saddam
 */
public interface PelajaranListener {
    public void onChange(PelajaranModel model);
    public void onInsert(Pelajaran pelajaran);
    public void onUpdate(Pelajaran pelajaran);
    public void onDelete();
}
