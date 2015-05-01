/*
 * 
 */
package com.cssn.samplesdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.cssn.mobilesdk.*;
import com.cssn.samplesdk.model.MainActivityModel;

/**
 * 
 *
 */
public class DataContext extends android.app.Application
{
    private static final String TAG = DataContext.class.getName();

    private static DataContext instance = null;
    private int cardType;
    private DriversLicenseCardDuplex processedLicenseCardDuplex;
    private DriversLicenseCard processedLicenseCard;
    private MedicalCard processedMedicalCard;
    private PassportCard processedPassportCard;
    
    private MainActivityModel mainActivityModel = null;
    
    private LicenseDetails cssnLicenseDetails;

    private String licenseKey = "";

    private Context context;

    private DataContext()
    {
    }
    
    public static DataContext getInstance()
    {
        if (instance == null)
        {
            instance = new DataContext();
        }

        return instance;
    }

    public String getLicenseKey()
    {
        licenseKey = getSharedPreferences().getString("licenseKey", "");
        return licenseKey;
    }
    public void setContext(Context context){
      this.context = context;
    }

    public void setLicenseKey(String licenseKey)
    {
        this.licenseKey = licenseKey;
        Editor editor = getSharedPreferences().edit();
        editor.putString("licenseKey", licenseKey);
        editor.commit();
    }

    public int getCardType()
    {
        return cardType;
    }

    public void setCardType(int cardType)
    {
        this.cardType = cardType;
    }

    public DriversLicenseCard getProcessedLicenseCard()
    {
        return processedLicenseCard;
    }

    public DriversLicenseCardDuplex getProcessedLicenseCardDuplex()
    {
        return processedLicenseCardDuplex;
    }

    public void setProcessedLicenseCard(DriversLicenseCard processedLicenseCard)
    {
        this.processedLicenseCard = processedLicenseCard;
    }

    public void setProcessedLicenseCardDuplex(DriversLicenseCardDuplex processedLicenseCard)
    {
        this.processedLicenseCardDuplex = processedLicenseCard;
    }

    public MedicalCard getProcessedMedicalCard()
    {
        return processedMedicalCard;
    }

    public void setProcessedMedicalCard(MedicalCard processedMedicalCard)
    {
        this.processedMedicalCard = processedMedicalCard;
    }

    public PassportCard getProcessedPassportCard()
    {
        return processedPassportCard;
    }

    public void setProcessedPassportCard(PassportCard processedPassportCard)
    {
        this.processedPassportCard = processedPassportCard;
    }

    /**
     * @return the mainActivityModel
     */
    public MainActivityModel getMainActivityModel()
    {
        return mainActivityModel;
    }

    /**
     * @param mainActivityModel the mainActivityModel to set
     */
    public void setMainActivityModel(MainActivityModel mainActivityModel)
    {
        this.mainActivityModel = mainActivityModel;
    }

    /**
     * @return the cssnLicenseDetails
     */
    public LicenseDetails getCssnLicenseDetails()
    {
        return cssnLicenseDetails;
    }

    /**
     * @param cssnLicenseDetails the cssnLicenseDetails to set
     */
    public void setCssnLicenseDetails(LicenseDetails cssnLicenseDetails)
    {
        this.cssnLicenseDetails = cssnLicenseDetails;
    }

    private SharedPreferences getSharedPreferences()
    {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
