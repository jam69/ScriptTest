/*
 *  Copyright &copy; Indra 2016
 */
package com.jam69.scripttest;

/**
 *
 * @author jamartinm
 */
public class KmInfo
{

 

    public KmInfo( )
    {
     
    }


    public Float kilometers( int agencyId )
    {
        return Double.valueOf(agencyId*500.).floatValue();
    }


    public Float totalKilometers()
    {
        return 999f;
    }

}
