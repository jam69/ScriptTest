/*
 *  Copyright &copy; Indra 2016
 */
package com.jam69.scripttest;

/**
 *
 * @author jamartinm
 */
public class TestCompiler implements Test1
{

    private CompInfo compInfo;
    private KmInfo kmInfo;
    
    public void setCompInfo(CompInfo c){
        this.compInfo=c;
    }
    public void setKmInfo(KmInfo k){
        this.kmInfo=k;
    }

    public void doIt(ResultBean v)
    {
        Integer product = v.productId;
        Double ref = compInfo.sellsAmount(product);
        v.reference2 = ref;
        Double num = kmInfo.kilometers(v.agencyId).doubleValue();
        v.numerator2 = num;
        Float den = kmInfo.totalKilometers();
        v.denominator2 = den.doubleValue();
        Double ventas = v.sellsAmount;
        if (ventas == null)
        {
            ventas = Double.valueOf(0);
        }
        if (num == null)
        {
            num = Double.valueOf(0);
        }
        v.balance = ventas - ref * num / den;
        v.balance = 2.;
//log.info("-->"+v.productId+"-"+v.agencyId);
    }
}
