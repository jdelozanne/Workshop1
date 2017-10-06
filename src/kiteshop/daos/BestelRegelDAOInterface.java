/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import kiteshop.pojos.BestelRegel;

/**
 *
 * @author julia
 */
public interface BestelRegelDAOInterface {
    
    void createBestelRegel(BestelRegel regel);

    BestelRegel readBestelRegel(int bestelRegelID);

    void updateBestelRegel(BestelRegel regel);

    void deleteBestelRegel(BestelRegel regel);
    
}
