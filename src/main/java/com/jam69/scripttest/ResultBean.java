/*
 *  Copyright &copy; Indra 2016
 */
package com.jam69.scripttest;



/**
 *
 * @author jamartinm
 */
public class ResultBean
{

    public Integer agencyId;
    public String agencyTxt;
    public Integer productId;
    public String productTxt;
    public Integer profileId;
    public String profileTxt;
    
    public Integer sellsCount;
    public Double sellsAmount;
    public Double deposit;
    public Double mediaPrice;
    public Double subvencion;
    
    public Integer legsCount;
    public Double legsAmount;
    public Double penalty;
    public Double numerator;
    public Double denominator;
    public Double reference;
    public Double numerator2;
    public Double denominator2;
    public Double reference2;
    public Double balance;
    public Double compAmount;
    

    

 
    
    public String getAgencyTxt()
    {
        return agencyTxt;
    }
    
    
    public void setAgencyTxt( String agencyTxt )
    {
        this.agencyTxt = agencyTxt;
    }
    
    
    public String getProductTxt()
    {
        return productTxt;
    }
    
    
    public void setProductTxt( String productTxt )
    {
        this.productTxt = productTxt;
    }
    
    
    public String getProfileTxt()
    {
        return profileTxt;
    }
    
    
    public void setProfileTxt( String profileTxt )
    {
        this.profileTxt = profileTxt;
    }
    
    
    public Double getNumerator2()
    {
        return numerator2;
    }
    
    
    public void setNumerator2( Double numerator2 )
    {
        this.numerator2 = numerator2;
    }
    
    
    public Double getDenominator2()
    {
        return denominator2;
    }
    
    
    public void setDenominator2( Double denominator2 )
    {
        this.denominator2 = denominator2;
    }
    
    
    public Double getReference2()
    {
        return reference2;
    }
    
    
    public void setReference2( Double reference2 )
    {
        this.reference2 = reference2;
    }
    
    
    public Integer getAgencyId()
    {
        return agencyId;
    }


    public void setAgencyId( Integer agencyId )
    {
        this.agencyId = agencyId;
    }


    public Integer getProductId()
    {
        return productId;
    }


    public void setProductId( Integer productId )
    {
        this.productId = productId;
    }


    public Integer getSellsCount()
    {
        return sellsCount;
    }


    public void setSellsCount( Integer sellsCount )
    {
        this.sellsCount = sellsCount;
    }


    public Double getSellsAmount()
    {
        return sellsAmount;
    }


    public void setSellsAmount( Double sellsAmmount )
    {
        this.sellsAmount = sellsAmmount;
    }


    public Integer getLegsCount()
    {
        return legsCount;
    }


    public void setLegsCount( Integer legsCount )
    {
        this.legsCount = legsCount;
    }


    public Double getLegsAmount()
    {
        return legsAmount;
    }


    public void setLegsAmount( Double legsAmmount )
    {
        this.legsAmount = legsAmmount;
    }


    public Double getNumerator()
    {
        return numerator;
    }


    public void setNumerator( Double numerator )
    {
        this.numerator = numerator;
    }


    public Double getDenominator()
    {
        return denominator;
    }


    public void setDenominator( Double denominator )
    {
        this.denominator = denominator;
    }


    public Double getReference()
    {
        return reference;
    }


    public void setReference( Double reference )
    {
        this.reference = reference;
    }


    public Double getBalance()
    {
        return balance;
    }


    public void setBalance( Double balance )
    {
        this.balance = balance;
    }


    public Double getCompAmount()
    {
        return compAmount;
    }


    public void setCompAmount( Double compAmount )
    {
        this.compAmount = compAmount;
    }


    public Integer getProfileId()
    {
        return profileId;
    }


    public void setProfileId( Integer profileId )
    {
        this.profileId = profileId;
    }


    public Double getDeposit()
    {
        return deposit;
    }


    public void setDeposit( Double deposit )
    {
        this.deposit = deposit;
    }


    public Double getMediaPrice()
    {
        return mediaPrice;
    }


    public void setMediaPrice( Double mediaPrice )
    {
        this.mediaPrice = mediaPrice;
    }


    public Double getPenalty()
    {
        return penalty;
    }


    public void setPenalty( Double penalty )
    {
        this.penalty = penalty;
    }
    
    
    public Double getSubvencion()
    {
        return subvencion;
    }
    
    
    public void setSubvencion( Double subvencion )
    {
        this.subvencion = subvencion;
    }
    
    
    @Override
    public String toString()
    {
        return "ResultBean{" + "agencyId=" + agencyId + ", agencyTxt=" + agencyTxt + ", productId=" + productId + ", productTxt="
                + productTxt + ", profileId=" + profileId + ", profileTxt=" + profileTxt + ", sellsCount=" + sellsCount + ", sellsAmount="
                + sellsAmount + ", deposit=" + deposit + ", mediaPrice=" + mediaPrice + ", subvencion=" + subvencion + ", legsCount="
                + legsCount + ", legsAmount=" + legsAmount + ", penalty=" + penalty + ", numerator=" + numerator + ", denominator="
                + denominator + ", reference=" + reference + ", numerator2=" + numerator2 + ", denominator2=" + denominator2
                + ", reference2=" + reference2 + ", balance=" + balance + ", compAmount=" + compAmount + '}';
    }
    
}
