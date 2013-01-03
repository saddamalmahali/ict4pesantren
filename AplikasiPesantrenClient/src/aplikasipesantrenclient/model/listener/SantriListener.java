/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.model.listener;

import aplikasipesantren.entity.Santri;
import aplikasipesantrenclient.model.SantriModel;

/**
 *
 * @author Saddam
 */
public interface SantriListener {
    public void onChange(SantriModel model);
    public void onInsert(Santri santri);
    public void onUpdate(Santri santri);
    public void onDelete();
}
