/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.test;

import domain.Test;
import javax.ejb.Local;

/**
 *
 * @author tihomir
 */
@Local
public interface SessionTestLocal {

    void saveTest(Test test) throws Exception;
    
}
