/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.result;

import domain.Result;
import javax.ejb.Local;

/**
 *
 * @author tihomir
 */
@Local
public interface SessionResultLocal {

    void saveResult(Result result) throws Exception;
    
}
