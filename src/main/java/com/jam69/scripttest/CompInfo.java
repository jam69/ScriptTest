/*
 *  Copyright &copy; Indra 2016
 */
package com.jam69.scripttest;

/**
 *
 * @author jamartinm
 */
public class CompInfo {
 
   
    public Integer sellsCount(Integer productId){
       return 100;
    }
    public Double sellsAmount(Integer productId){  // .filter( Objects::nonNull )
        return 1000.;
    }
     public Integer legsCount(Integer productId){
        return 200;
    }
    public Double legsAmount(Integer productId){
        return 2000.;
    }
    
}
