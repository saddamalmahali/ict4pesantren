/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model.listener;

import aplikasipesantren.entity.Kamar;
import aplikasipesantrenclient.model.KamarModel;

/**
 *
 * @author Saddam
 */
public interface KamarListener {
    public void onChange(KamarModel model);
    public void onInsert(Kamar kamar);
    public void onDelete();
}
