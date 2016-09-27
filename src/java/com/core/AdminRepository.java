/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core;

import com.entities.Campaignbatch;
import com.entities.Campaigns;
import com.entities.Merchantprofile;
import com.entities.Profile;
import com.entities.Transactions;
import java.util.List;


/**
 *
 * @author Ahmed
 */
public interface AdminRepository extends UnitOfWork
{
    public List<Transactions> getTransactions();    
    public List<Profile> getProfiles();
    public Profile getProfile(String criteria);
    public List<Profile> getProfilesByDate();
    public Merchantprofile getMerchantProfile(String username);

    public Merchantprofile validate(String userid, String password);

    public void addCampaignBatch(Campaignbatch campaignBatch);

    public List<Transactions> getCampaigners(Double mindeposit);

    public void addCampaign(Campaigns campaign);

    public List<Campaignbatch> getMyCampaigns(Merchantprofile mprofile);

    public List<Campaigns> getCampaigners(Campaignbatch cb);
    
}
