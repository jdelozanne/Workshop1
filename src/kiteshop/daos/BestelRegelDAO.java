/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

/**
 *
 * @author julia
 */
public interface BestelRegelDAO {
    
    void createBestelRegel(BestelRegel regel);

    void readBestelRegel(BestelRegel regel);

    void updateBestelRegel(BestelRegel regel);

    void deleteBestelRegel(BestelRegel regel);
    
}
