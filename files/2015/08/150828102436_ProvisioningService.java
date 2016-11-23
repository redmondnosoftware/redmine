package ar.com.redmondsoftware.provisioning.service;

import java.util.List;

import ar.com.redmondsoftware.provisioning.model.BlackWhiteList;
import ar.com.redmondsoftware.provisioning.model.Subscriber;

public interface ProvisioningService {
	
	/**
	 * @return All the Black-White-Lists availables
	 */
	public List<BlackWhiteList> getLists();
	
	/**
	 * @return All the active Black-White-Lists
	 */
	public List<BlackWhiteList> getActiveLists();

	
	/**
	 * @return the Subscriber identified by the snb parameter or null if it doesn't exist
	 * @param snb subscriber identifier
	 * */
	public Subscriber getBySnb(Long snb);

	/**
	 * Informs if the subscriber identified by snb is blocked in the list identified by code
	 * @param code blacklist identifier
	 * @param snb subscriber identifier
	 * @param blockedRegExp regular expression considered for blocking a subscriber, if null "A" is considered
	 * @return
	 */
	public boolean isBlockedInList(String code, Long snb);
	
	/**
	 * Refresh parameters from GeneralParameter
	 */
	public void refreshConfig();
	

	/**
	 * If bwList is a blacklist, then the subscriber added. 
	 * If bwList is a whitelist, then the subscriber is removed. 
	 * @param snb subscriber identifier
	 * @param bwList the list 
	 */
	public void blockSubscriberInList(Long snb, BlackWhiteList bwList);
	
	/**
	 * If code belongs to a blacklist, then the subscriber added. 
	 * If code belongs to a whitelist, then the subscriber is removed. 
	 * @param snb subscriber identifier
	 * @param code the list code 
	 */
	public void blockSubscriberInList(Long snb, String code);
	
	/**
	 * If bwList is a blacklist, then the subscriber removed. 
	 * If bwList is a whitelist, then the subscriber is added. 
	 * @param snb subscriber identifier
	 * @param bwList the list
	 */
	public void enableSubscriberInList(Long snb, BlackWhiteList bwList);
	
	/**
	 * If code belongs to a blacklist, then the subscriber removed. 
	 * If code belongs to a whitelist, then the subscriber is added. 
	 * @param snb subscriber identifier
	 * @param code the list code
	 */
	public void enableSubscriberInList(Long snb, String code);
	
	
	
	//The following methods are just for testing !!!!
	public Subscriber createSubscriber(Long snb, String planType, String active);
	public BlackWhiteList createBlackWhiteList(String code, String name, String unexistentCode, String status);
	//public BlackWhiteSubscriber createBlackWhiteSubscriber(Long snb, BlackWhiteList bwList, String status);
		
}
